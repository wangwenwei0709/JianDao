package com.example.jiandao.app;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import android.os.Process;

import java.util.Stack;

public class AppManager {
//     初始化  Activity和Fragment  管理栈
//     人为写的一个集合
    private static Stack<Activity> activityStack = new Stack<>();
    private static Stack<Fragment> fragmentStack = new Stack<>();

//    内存判断
    private static volatile AppManager appManager;

//    添加
//    删除

    public AppManager() {
    }

    public static AppManager getInstance(){
        if (appManager==null){
            synchronized (AppManager.class){
                if (appManager == null){
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    /**
     * 获取所有Activity
     */
    public static Stack<Activity> getActivityStack(){
        return activityStack;
    }

    /**
     * 获取所有Fragment
     */
    public static Stack<Fragment> getFragmentStack(){
        return fragmentStack;
    }

    /**
     * A B C D EF
     * 先进后出
     */
    public void addActivity(Activity activity){
        if (activityStack == null){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 移除指定Activity
     */
    public void removeActivity(Activity activity){
        if (activity!=null){
            activity.finish();
            activityStack.remove(activity);
        }
    }

    /**
     * 删除当前Activity
     */
    public void deleteActivity(){
        Activity activity = activityStack.lastElement();
        if (activity!=null){
            if (!activity.isFinishing()){
                    activity.finish();
            }
        }
    }

    //Fragment 和 Activity类似

    /**
     * 当应用退出后，需要结束掉所有的Activity
     */
    public void appExit(){
        for (int i = 0; i < activityStack.size(); i++) {
            if (null !=activityStack.get(i)){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
        System.exit(0);
        Process.killProcess(Process.myPid());
//        双击退出
//        1、点击返回键
//                2、判断返回键 时间间隔
//                3、满足appExit
    }
}
