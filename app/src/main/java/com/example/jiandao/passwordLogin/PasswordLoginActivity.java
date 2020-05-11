package com.example.jiandao.passwordLogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.login.LoginActivity;
import com.example.jiandao.login.LoginBean;
import com.example.jiandao.passwordLogin.forgetpw.ForgetPwActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PasswordLoginActivity extends BaseActivity<PasswordLoginPresenter> implements PasswordLoginContract.IPasswordLoginView {


    @BindView(R.id.close_passwordLogin)
    ImageView closePasswordLogin;
    @BindView(R.id.phone_passwordLogin)
    EditText phonePasswordLogin;
    @BindView(R.id.clean_passwordLogin)
    ImageView cleanPasswordLogin;
    @BindView(R.id.password_passwordLogin)
    EditText passwordPasswordLogin;
    @BindView(R.id.clean2_passwordLogin)
    ImageView clean2PasswordLogin;
    @BindView(R.id.open_passwordLogin)
    ImageView openPasswordLogin;
    @BindView(R.id.forgetpw_passwordLogin)
    TextView forgetpwpasswordLogin;
    @BindView(R.id.loginButton_passwordLogin)
    Button loginButtonPasswordLogin;
    @BindView(R.id.Verification_code_login)
    TextView VerificationCodeLogin;
    @BindView(R.id.register_immediately)
    TextView registerImmediately;
    @BindView(R.id.wechat_passwordLogin)
    ImageView wechatPasswordLogin;
    @BindView(R.id.qq_passwordLogin)
    ImageView qqPasswordLogin;
    @BindView(R.id.weibo_passwordLogin)
    ImageView weiboPasswordLogin;
    private String phone;
    private String password;

    @Override
    protected PasswordLoginPresenter initPresenter() {
        return new PasswordLoginPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        loginButtonPasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = phonePasswordLogin.getText().toString();
                password = passwordPasswordLogin.getText().toString();
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)){
                    if (!TextUtils.isEmpty(password)){
                        mPresenter.passwordLogin(phone,password);
                    }else Toast.makeText(PasswordLoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(PasswordLoginActivity.this, "输入手机号有误", Toast.LENGTH_SHORT).show();

            }
        });

        forgetpwpasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)){
                    Intent intent = new Intent(PasswordLoginActivity.this, ForgetPwActivity.class);
                    intent.putExtra("phone",phone);
                    startActivity(intent);
                }else Toast.makeText(PasswordLoginActivity.this, "输入手机号有误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_password_login;
    }

    public static boolean isMobileNO(String phone){
        boolean flag = false;
        Pattern pattern =Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        flag = matcher.matches();
        return flag;
    }

    @Override
    public void passwordLogin(LoginBean loginBean) {
        if (loginBean.getCode()==1){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        }else if (loginBean.getCode()==2){
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
