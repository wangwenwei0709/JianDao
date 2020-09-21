package com.example.jiandao.login;

import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.passwordLogin.PasswordLoginActivity;
import com.example.jiandao.register.RegisterActivity;
import com.tencent.mmkv.MMKV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {


    @BindView(R.id.close_login)
    ImageView closeLogin;
    @BindView(R.id.phone_login)
    EditText phoneLogin;
    @BindView(R.id.clean_login)
    ImageView cleanLogin;
    @BindView(R.id.verification_login)
    EditText verificationLogin;
    @BindView(R.id.getCode_login)
    Button getCodeLogin;
    @BindView(R.id.agreement_login)
    TextView agreementLogin;
    @BindView(R.id.loginbutton_login)
    Button loginbuttonLogin;
    @BindView(R.id.wechat_login)
    ImageView wechatLogin;
    @BindView(R.id.qq_login)
    ImageView qqLogin;
    @BindView(R.id.weibo_login)
    ImageView weiboLogin;
    @BindView(R.id.Password_to_login)
    TextView PasswordToLogin;
    @BindView(R.id.register_immediately)
    TextView registerImmediately;
    private String phone;
    private String code;


    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void initView() {
        CharSequence text = agreementLogin.getText();
        SpannableString spannableString = new SpannableString(text);
        URLSpan urlSpan = new URLSpan("https://www.baidu.com/");
        URLSpan urlSpan2 = new URLSpan("https://www.sogou.com/");
        spannableString.setSpan(urlSpan,9,13, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(urlSpan2,14,18,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        agreementLogin.setMovementMethod(LinkMovementMethod.getInstance());
        agreementLogin.setText(spannableString);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        getCodeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                String phone = phoneLogin.getText().toString();
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)){
                    mPresenter.getVerified(phone,"4");
                }else Toast.makeText(LoginActivity.this, "输入手机号有误", Toast.LENGTH_SHORT).show();
            }
        });

        loginbuttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = phoneLogin.getText().toString();
                code = verificationLogin.getText().toString();
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)){
                    if (!TextUtils.isEmpty(code)){
                        Pattern pattern = Pattern.compile("\\d{6}");
                        boolean matches = pattern.matcher(code).matches();
                        if (matches){
                            Log.e("TAG", phone + code);
                            mPresenter.checkSmsCode(phone, code,"4");
                        }else Toast.makeText(LoginActivity.this, "短信验证码无效", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(LoginActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(LoginActivity.this, "请输入正确得手机号", Toast.LENGTH_SHORT).show();
            }
        });

        registerImmediately.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        PasswordToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, PasswordLoginActivity.class));
            }
        });
    }



    public static boolean isMobileNO(String phone){
        boolean flag = false;
        Pattern pattern =Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        flag = matcher.matches();
        return flag;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }


    @Override
    public void getVerified(VerfiedBean s) {
        if (s.getCode()==1){
            Toast.makeText(this, "成功收到", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "没有收到", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {
        if (verfiedBean.getCode()==1){
            mPresenter.login(phone,code);
        }else Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLoginResult(LoginBean loginBean) {
//        Toast.makeText(this, loginBean.getData().getUser_info().getNickname(), Toast.LENGTH_SHORT).show();
//        Log.e("TAG", "我的昵称是："+loginBean.getData().getUser_info().getNickname());
        if (loginBean.getCode()==1){
            Toast.makeText(this, "登录成功返回数据，且code等于1,跳转Home", Toast.LENGTH_SHORT).show();
            if (null != loginBean.getData().getToken().getValue() && loginBean.getData().getToken().getValue()!=""){
                MMKV mmkv = MMKV.defaultMMKV();
                mmkv.encode("token", loginBean.getData().getToken().getValue());
                mmkv.encode("expire_time", loginBean.getData().getToken().getExpire_time());
                mmkv.encode("head_url", loginBean.getData().getUser_info().getHead_url());
                mmkv.encode("nickname", loginBean.getData().getUser_info().getNickname());
                mmkv.encode("mobile", loginBean.getData().getUser_info().getMobile());

                Toast.makeText(this, "登录成功，返回上一个页面", Toast.LENGTH_SHORT).show();

                finish();
            }
        }
    }


}
