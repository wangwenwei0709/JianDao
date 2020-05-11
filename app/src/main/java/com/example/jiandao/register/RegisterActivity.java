package com.example.jiandao.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.login.LoginActivity;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.register.next.NextRegisterActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.IRegisterView {


    @BindView(R.id.close_register)
    ImageView closeRegister;
    @BindView(R.id.phone_register)
    EditText phoneRegister;
    @BindView(R.id.clean_register)
    ImageView cleanRegister;
    @BindView(R.id.verification_register)
    EditText verificationRegister;
    @BindView(R.id.getCode_register)
    TextView getCodeRegister;
    @BindView(R.id.nextbutton_register)
    Button nextbuttonRegister;
    @BindView(R.id.Verification_code_login)
    TextView VerificationCodeLogin;
    @BindView(R.id.Password_to_login)
    TextView PasswordToLogin;
    @BindView(R.id.wechat_register)
    ImageView wechatRegister;
    @BindView(R.id.qq_register)
    ImageView qqRegister;
    @BindView(R.id.weibo_register)
    ImageView weiboRegister;
    private String phone;
    private String code;

    @Override
    protected RegisterPresenter initPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        getCodeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneRegister.getText().toString();
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)){
                    mPresenter.getVerified(phone,"1");
                }else Toast.makeText(RegisterActivity.this, "输入手机号有误", Toast.LENGTH_SHORT).show();
            }
        });

        nextbuttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = phoneRegister.getText().toString();
                code = verificationRegister.getText().toString();
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)){
                    if (!TextUtils.isEmpty(code)){
                        Pattern pattern = Pattern.compile("\\d{6}");
                        boolean matches = pattern.matcher(code).matches();
                        if (matches){
                            Log.e("TAG", phone + code);
                            mPresenter.checkSmsCode(phone, code,"1");
                        }else Toast.makeText(RegisterActivity.this, "短信验证码无效", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(RegisterActivity.this, "请输入正确得手机号", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_register;
    }

    public static boolean isMobileNO(String phone){
        boolean flag = false;
        Pattern pattern =Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        flag = matcher.matches();
        return flag;
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
            Intent intent = new Intent(this, NextRegisterActivity.class);
            intent.putExtra("mobile",phone);
            startActivity(intent);
        }else Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();
    }
}
