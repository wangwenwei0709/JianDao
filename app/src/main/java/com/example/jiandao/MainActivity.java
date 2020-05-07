package com.example.jiandao;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiandao.app.AppManager;
import com.example.jiandao.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView {

    @BindView(R.id.tv_main)
    TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Toast.makeText(this, "调用P层网络请求", Toast.LENGTH_SHORT).show();
        mPresenter.getRecommendList();
    }

    @Override
    public void initListener() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    /**
     * 双击退出    时间分发    onTouchEvent、  disPatchTouch、onInterc。。。
     */

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        菜单、home、返回键 点击了返回键
//        点击屏幕的时候，   按下，抬起， 移动  判断时间为两秒
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
//            获取当前点击返回键的时间   --   两个时间
            long currentTime = System.currentTimeMillis();
            if (currentTime - fristKeyBackTime > 2000) {
//              表示不能退
                fristKeyBackTime = currentTime;
                Toast.makeText(this, "再点击一次返回键，退出当前应用", Toast.LENGTH_SHORT).show();
            } else {
//               成立 关闭应用
                AppManager.getInstance().appExit();
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    private long fristKeyBackTime = 0;


    @Override
    public void setData(RemBean remBean) {
        String theme = remBean.getData().getList().get(0).getTheme();
        tvMain.setText(theme);
    }
}
