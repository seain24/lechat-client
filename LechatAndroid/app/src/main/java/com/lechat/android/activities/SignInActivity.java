package com.lechat.android.activities;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lechat.android.pojo.MemberEntity;
import com.lechat.android.pojo.UserInfo;
import com.lechat.android.services.Emoji;
import com.lechat.android.services.impl.EmojiParser;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 19:25.
 * @Description: 登录页面
 */
public class SignInActivity extends  BaseActivity {
    private static String SHARED_PREFERENCE_KEY = "sharedPreferenceKey";
    private static String SHARED_PREFERENCE_USER = "sharedPreferenceUser";
    private static String SHARED_PREFERENCE_PASSWORD = "sharedPreferencePassword";
    private TextView mTvServerSet;
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;
    private ProgressBar mProgressBar;
    private TextView mTvProgressText;

    private String mUsername;
    private String mPassword;
    private TextView tv_server;
    private LinearLayout ll_moble, ll_iutalk;
    private RelativeLayout rl_server, rl_progressbar;
    private MemberEntity memberEntity;
    private List<UserInfo> userlist;
    private ImageView iv_line_mobile;
    private File file;
    private String picname;
    private String sign;
    private int uBirthday;
    private boolean flag = true;
    private Handler _handler;
    private int _currentGroupNum = 0;
    private boolean mLogining = false;

    private boolean dbInitialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 权宜之计，允许UI线程中进行网络通信
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());

        getLoginUserInfoFromSharedPreferences();

        // todo 加密
        mEdtUsername.setText(mUsername);
        mEdtPassword.setText(mPassword);
        AssetManager asset = getAssets();

        try {
            InputStream input = asset.open("faceconfig.xml");
            List<Emoji> list = EmojiParser.parse_input(input);
            for (Emoji stu : list) {
                Emoji emoji = new Emoji();
                emoji.setFile(stu.getFile());
                emoji.setFaceid(stu.getFaceid());
                emoji.setTip(stu.getTip());
                //BaseActivity.getDb().save(face);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
