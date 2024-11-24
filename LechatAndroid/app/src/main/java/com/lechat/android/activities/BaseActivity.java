package com.lechat.android.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.lechat.android.LeChatApplication;
import com.lechat.android.R;
import com.lechat.android.broadcaster.NetBroadcastReceiver;
import com.lechat.android.network.MsgType;
import com.lechat.android.pojo.MemberEntity;
import com.lechat.android.utils.LoggerFile;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Optional;

import kotlin.Result;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 18:45.
 * @Description: 所有activity类的父类
 */
public abstract class BaseActivity extends FragmentActivity {
    private static final String TAG = "BaseActivity";
    //注册Activity返回的结果
    public static final int SIGNUP_RESULT = 0;
    public static final int SIGNUP_RESULT_CANCEL = 1;
    public static final int SIGNUP_RESULT_OK = 2;

    protected static LeChatApplication application;
    public static boolean bLogin = false;
    Result<Boolean> signup_result;

    // 广播接收器
    private NetBroadcastReceiver netBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化application
        application = (LeChatApplication) getApplication();
        // 添加Activity到堆栈
        application.getAppManager().addActivity(this);

        setContentView(getContentView());
        autoInitAllWidgets();
        initData();
        setData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册网络状态监听的广播
        registerBroadcastReceiver();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        application = (LeChatApplication) getApplication();
        // 添加Activity到堆栈
        application.getAppManager().addActivity(this);
        application.getMemberEntity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 结束Activity&从堆栈中移除
        application.getAppManager().finishActivity(this);
    }

    private void processMessage(Message msg) {
        if (msg.what == MsgType.msg_type_kickuser) {
            // 跳转到登录页面
            Intent intent = new Intent(BaseActivity.this, SignInActivity.class);
            startActivity(intent);
            Toast.makeText(this, "当前账户在其他地点登录\r\n如果这不是您本人行为，建议修改密码", Toast.LENGTH_LONG).show();
        }
    }


    // Handler对象是静态的，则所有继承BaseActivity的子类都是共用同一个消息队列
    @SuppressLint("HandlerLeak")
    private static Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //ProcessNetMsg(msg);

            BaseActivity activity = ((BaseActivity) application.getAppManager().currentActivity());
            if (activity != null) {
                if (msg.what == MsgType.msg_network_disconnect) {
                    //Toast.makeText(acitivity, "网络已经断开", Toast.LENGTH_SHORT).show();
                } else activity.processMessage(msg);
            }
        }
    };


    /**
     * 获取布局文件ID
     *
     * @return
     */
    protected abstract int getContentView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置
     */
    protected abstract void setData();

    /**
     * 自动初始化所有控件
     */
    private void autoInitAllWidgets() {
        // 得到该Activity的所有字段
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 反射访问私有成员，必须加上这句
            field.setAccessible(true);

            try {
//                int id = R.id.class.getField(field.getName()).getInt(new R.id());
                int id = (int) R.id.class.getDeclaredMethod("id", String.class).invoke(null, field.getName());
                // 然后对这个属性赋值
                field.set(this, this.findViewById(id));
            } catch (Exception e) {
                LoggerFile.LogError(TAG, "init widget failed");
            }
        }
    }

    /**
     * 跳转到其他activity
     *
     * @param cls
     */
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    // ----------------------------------------------
    // --------------------基本控件设置----------------
    // ----------------------------------------------

    /**
     * 设置文字
     *
     * @param tv  TextView
     * @param str 要设置的字符串
     */
    protected void setText(TextView tv, String str) {
        if (StringUtils.isBlank(str) || tv == null) {
            return;
        }
        tv.setText(str);
    }

    /**
     * 显示网络图片, 可重新配置options
     *
     * @param iv
     * @param imageUrl
     * @param screenWidthScale
     * @param heightWidthScale
     * @param options
     */
//    protected void displayImage(ImageView iv, String imageUrl,
//                                float screenWidthScale, float heightWidthScale,
//                                DisplayImageOptions options) {
//        if (imageUrl == null) {
//            return;
//        }
//
//        ViewGroup.LayoutParams params = iv.getLayoutParams();
//        params.width = (int) (screenWidthScale * application.getScreenWidth());
//        params.height = (int) (params.width * heightWidthScale);
//        iv.setLayoutParams(params);
//
//        ImageLoader.getInstance().displayImage(imageUrl, iv, options);
//    }

    /**
     * 获取账号
     *
     * @return
     */
    public static Optional<Integer> getMyAccountID() {
        if (application == null) {
            return Optional.empty();
        }
        return Optional.of(application.getMemberEntity().getuAccountID());
    }

    public static Optional<MemberEntity> getMyMemberEntity() {
        if (application == null) {
            return Optional.empty();
        }
        return Optional.of(application.getMemberEntity());
    }

    /**
     * 注册网络状态广播
     */
    private void registerBroadcastReceiver() {
        //注册广播
        if (netBroadcastReceiver == null) {
            netBroadcastReceiver = new NetBroadcastReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(netBroadcastReceiver, filter);
            //设置监听
            netBroadcastReceiver.setStatusMonitor(this);
        }
    }
}