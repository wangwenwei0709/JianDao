package com.example.jiandao.passwordLogin.forgetpw;

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
import com.example.jiandao.passwordLogin.affirmpw.AffrimPwActivity;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetPwActivity extends BaseActivity<ForgetPwPresenter> implements ForgetPwContract.IForgetPwView {


    @BindView(R.id.close_passwordLogin)
    ImageView closePasswordLogin;
    @BindView(R.id.phone_forgetpw)
    TextView phoneForgetpw;
    @BindView(R.id.verification_forgetpw)
    EditText verificationForgetpw;
    @BindView(R.id.getCode_forgetpw)
    TextView getCodeForgetpw;
    @BindView(R.id.nextbutton_forgetpw)
    Button nextbuttonForgetpw;
    private String phone;
    private String code;

    @Override
    protected ForgetPwPresenter initPresenter() {
        return new ForgetPwPresenter();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        phoneForgetpw.setText(phone);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        getCodeForgetpw.setOnClickListener(v -> {
            mPresenter.getVerified(phone,"2");
        });

        nextbuttonForgetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = verificationForgetpw.getText().toString().trim();
                if (!TextUtils.isEmpty(code)){
                    Pattern pattern = Pattern.compile("\\d{6}");
                    boolean matches = pattern.matcher(code).matches();
                    if (matches){
                        mPresenter.checkSmsCode(phone, code,"2");
                    }else Toast.makeText(ForgetPwActivity.this, "短信验证码无效", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(ForgetPwActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_forget_pw;
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
            Intent intent = new Intent(this, AffrimPwActivity.class);
            intent.putExtra("mobile",phone);
            intent.putExtra("sms_code",code);
            startActivity(intent);
        }else Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();
    }

}
