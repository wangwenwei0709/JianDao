package com.example.jiandao.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jiandao.utils.Constants;
import com.example.jiandao.utils.SpUtil;
import com.linsh.utilseverywhere.Utils;
import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {

    public static MyApplication myApplication;
    public static boolean isLogin;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
//      初始化内存泄漏检测工具
        initLeakCanary();
//        注册监听每个acitivyt的生命周期，便于栈管理
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);

        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        if (TextUtils.isEmpty(token)){
            isLogin = false;
        }else {
            isLogin = true;
        }
    }

    ActivityLifecycleCallbacks activityLifecycleCallbacks=new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
            AppManager.getInstance().addActivity(activity);
        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    };

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }
}
