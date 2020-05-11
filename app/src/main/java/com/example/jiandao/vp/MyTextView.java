package com.example.jiandao.vp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.annotation.SuppressLint;
@SuppressLint("AppCompatCustomView")

public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

   //重写这个方法，强制返回true
    @Override
    public boolean isFocused() {
        return true;
    }
}