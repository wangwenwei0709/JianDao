package com.example.jiandao.register.next;

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
import com.example.jiandao.home.view.HomeActivity;
import com.example.jiandao.login.LoginBean;
import com.tencent.mmkv.MMKV;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NextRegisterActivity extends BaseActivity<NextRegisterPresenter> implements NextRegisterContract.INextRegisterView {


    @BindView(R.id.close_next_register)
    ImageView closeNextRegister;
    @BindView(R.id.password_next_register)
    EditText passwordNextRegister;
    @BindView(R.id.clean_next_register)
    ImageView cleanNextRegister;
    @BindView(R.id.open_next_register)
    ImageView openNextRegister;
    @BindView(R.id.password2_next_register)
    EditText password2NextRegister;
    @BindView(R.id.clean2_next_register)
    ImageView clean2NextRegister;
    @BindView(R.id.open2_next_register)
    ImageView open2NextRegister;
    @BindView(R.id.agreement_next_register)
    TextView agreementNextRegister;
    @BindView(R.id.nextbutton_next_register)
    Button nextbuttonNextRegister;
    @BindView(R.id.Verification_code_next_register)
    TextView VerificationCodeNextRegister;
    @BindView(R.id.Password_to_next_register)
    TextView PasswordToNextRegister;
    @BindView(R.id.wechat_next_register)
    ImageView wechatNextRegister;
    @BindView(R.id.qq_next_register)
    ImageView qqNextRegister;
    @BindView(R.id.weibo_next_register)
    ImageView weiboNextRegister;
    private String mobile;

    @Override
    protected NextRegisterPresenter initPresenter() {
        return new NextRegisterPresenter();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        nextbuttonNextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordNextRegister.getText().toString();
                String password2 = password2NextRegister.getText().toString();
                if (!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(password2)){
                    if (password.length()>6){
                        if (password.equals(password2)){
                            mPresenter.register(mobile,password,password2);
                        }else Toast.makeText(NextRegisterActivity.this, "密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(NextRegisterActivity.this, "密码长度必须大于6位", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(NextRegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_next_register;
    }

    //新账号密码1234567
    @Override
    public void register(LoginBean loginBean) {
        if(loginBean.getCode()==1){
            Toast.makeText(this, "注册成功返回数据，且code等于1", Toast.LENGTH_SHORT).show();
            if(null !=loginBean.getData().getToken().getValue() &&loginBean.getData().getToken().getValue()!="" ){
                MMKV mmkv = MMKV.defaultMMKV();
                mmkv.encode("token",loginBean.getData().getToken().getValue());
                mmkv.encode("expire_time",loginBean.getData().getToken().getExpire_time());
                mmkv.encode("head_url",loginBean.getData().getUser_info().getHead_url());
                mmkv.encode("nickname",loginBean.getData().getUser_info().getNickname());
                mmkv.encode("mobile",loginBean.getData().getUser_info().getMobile());
                Intent intent = new Intent(NextRegisterActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }else {
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
