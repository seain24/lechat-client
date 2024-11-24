package com.lechat.android.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lechat.android.R;

public class SignUpActivity extends BaseActivity {
    private EditText mobileEtx, usernameEtx, passwordEtx, confirmPwdEtx;
    private Button signupBtn;
    private String mobile, username, password;
    private String szAccountNo, szNickName, szPasswd, surePasswd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setData() {
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szAccountNo = mobileEtx.getText().toString().trim();
                szNickName = usernameEtx.getText().toString().trim();
                szPasswd = passwordEtx.getText().toString().trim();
                surePasswd = confirmPwdEtx.getText().toString().trim();
                switch (v.getId()) {
                    case R.id.btn_back:
                        setResult(BaseActivity.SIGNUP_RESULT_CANCEL);
                        finish();
                        break;

                    case R.id.makesure_register:
                        // todo 网络工具
                        if (!NetUtils.isConnected(this))
                        {
                            Toast.makeText(this, R.string.net_not_available, Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // 注册
                        if (szAccountNo.trim().length() <= 0) {
                            Toast.makeText(this, "请输入账户名！", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (szNickName.trim().length() < 0) {
                            Toast.makeText(this, "请输入用户名！", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (szPasswd.length() < 3 || szPasswd.length() > 20) {
                            Toast.makeText(this, "密码请输入6-16位字符！！", Toast.LENGTH_SHORT)
                                    .show();
                            return;
                        }
                        if (surePasswd.length() < 3 || surePasswd.length() > 20) {
                            Toast.makeText(this, "两次密码输入不一致！！", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Button btnRegister = (Button)findViewById(R.id.makesure_register);
                        btnRegister.setEnabled(false);
                        NetWorker.registerUser(szAccountNo, szPasswd, szNickName);
                        break;

                    default:
                        break;
                }
            }
        });
    }



}