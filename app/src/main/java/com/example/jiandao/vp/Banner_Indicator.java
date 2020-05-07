package com.example.jiandao.vp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.example.jiandao.R;

public class Banner_Indicator extends View {

    private Paint paint;
    private Context context;
    private int bannerImagesize;
    private int currentItemPosion = 0;
    private int rectf_right_defult = 0;
    private int wind_Width;
    private int width;

    public Banner_Indicator(Context context) {
        this(context,null);
    }

    public Banner_Indicator(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Banner_Indicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        paint = new Paint();

        paint.setColor(getResources().getColor(R.color.colorRed));
        WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        width = window.getDefaultDisplay().getWidth();
    }

    public void setBannerImagesize(int bannerImagesize){
        this.bannerImagesize = bannerImagesize;
    }

    public void setCurrentBannerItem(int currentItemPosion){
        this.currentItemPosion = currentItemPosion;
        currentItemPosion = currentItemPosion+1;
        rectf_right_defult = width / bannerImagesize * currentItemPosion;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.top = 0;
        rectF.right = rectf_right_defult;
        rectF.bottom = 30;
        canvas.drawRect(rectF,paint);
    }
}
