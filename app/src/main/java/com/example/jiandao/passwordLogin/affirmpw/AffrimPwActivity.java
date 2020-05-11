package com.example.jiandao.passwordLogin.affirmpw;

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
import com.example.jiandao.passwordLogin.PasswordLoginActivity;
import com.example.jiandao.register.next.NextRegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AffrimPwActivity extends BaseActivity<AffrimPwPresenter> implements AffrimPwContract.IAffrimPwView {


    @BindView(R.id.close_affrimpw)
    ImageView closeAffrimpw;
    @BindView(R.id.tv_affrimpw)
    TextView tvAffrimpw;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.ok_affrimpw)
    Button okAffrimpw;
    @BindView(R.id.password_affrimpw)
    EditText passwordAffrimpw;
    @BindView(R.id.password2_affrimpw)
    EditText password2Affrimpw;
    private String mobile;
    private String sms_code;

    @Override
    protected AffrimPwPresenter initPresenter() {
        return new AffrimPwPresenter();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
        sms_code = intent.getStringExtra("sms_code");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        okAffrimpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordAffrimpw.getText().toString();
                String password2 = password2Affrimpw.getText().toString();
                if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(password2)) {
                    if (password.length() > 6) {
                        if (password.equals(password2)) {
                            mPresenter.affrimpw(mobile, password,sms_code);
                        } else
                            Toast.makeText(AffrimPwActivity.this, "密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(AffrimPwActivity.this, "密码长度必须大于6位", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(AffrimPwActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_affrim_pw;
    }

    @Override
    public void affrimpw(AffrimPwBean affrimPwBean) {
        startActivity(new Intent(this, PasswordLoginActivity.class));
    }

}
