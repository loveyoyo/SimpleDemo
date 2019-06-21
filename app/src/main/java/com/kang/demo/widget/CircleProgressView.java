package com.kang.demo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kang.demo.R;

/**
 * Created by MockingJay on 2019/6/20;
 * Description:
 */

public class CircleProgressView extends View {

    /**
     * 最大进度；
     */
    private int max;

    /**
     * 圈颜色；
     */
    private int roundColor;

    /**
     * 进度颜色；
     */
    private int roundProgressColor;

    /**
     * 文字颜色；
     */
    private int textColor;

    /**
     * 文字大小；
     */
    private float textSize;
    /**
     * 圈宽度；
     */
    private float roundWidth;
    /**
     * 是否显示文字；
     */
    private boolean textShow;
    /**
     * 当前进度；
     */
    private int progress;
    /**
     * 画笔；
     */
    private Paint paint;

    /**
     * 是否绘图；
     */
    private boolean isPainting = true;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getRoundColor() {
        return roundColor;
    }

    public void setRoundColor(int roundColor) {
        this.roundColor = roundColor;
    }

    public int getRoundProgressColor() {
        return roundProgressColor;
    }

    public void setRoundProgressColor(int roundProgressColor) {
        this.roundProgressColor = roundProgressColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public boolean isPainting() {
        return isPainting;
    }

    public void setPainting(boolean painting) {
        isPainting = painting;
    }

    public float getTextSize() {
        return textSize;

    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public float getRoundWidth() {
        return roundWidth;
    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }

    public boolean isTextShow() {
        return textShow;
    }

    public void setTextShow(boolean textShow) {
        this.textShow = textShow;
    }

    public int getProgress() {
        return progress;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    /**
     * @param context
     * @param attrs
     */
    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        max = typedArray.getInteger(R.styleable.CustomProgressBar_max, 100);
        roundColor = typedArray.getColor(R.styleable.CustomProgressBar_roundColor, Color.RED);
        roundProgressColor = typedArray.getColor(R.styleable.CustomProgressBar_roundProgressColor, Color.BLUE);
        textColor = typedArray.getColor(R.styleable.CustomProgressBar_textColor, Color.GREEN);
        textSize = typedArray.getDimension(R.styleable.CustomProgressBar_textSize, 55);
        roundWidth = typedArray.getDimension(R.styleable.CustomProgressBar_roundWidth, 10);
        textShow = typedArray.getBoolean(R.styleable.CustomProgressBar_textShow, false);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("===MockingJay===", "onDraw...");

        //第一步 画圆环
        //中心点x坐标
        int cx = getWidth() / 2;
        //中心点y坐标
        int cy = getHeight() / 2;
        Log.e("===MockingJay===", "width:" + getWidth() + "==height:" + getHeight());

//        int center = cx / 2;//中心点到最外层距离
        int center = cx;
        //画笔半径
        float radius = center - roundWidth / 2;
        Log.e("===MockingJay===", "radius:" + radius);
        //圆形颜色
        paint.setColor(roundColor);
        /*
        Paint.Style.FILL：填充内部
        Paint.Style.FILL_AND_STROKE  ：填充内部和描边
        Paint.Style.STROKE  ：描边
        */
        //描边 空心圆
        paint.setStyle(Paint.Style.STROKE);
        //圆环宽度
        paint.setStrokeWidth(roundWidth);
        //抗锯齿
        paint.setAntiAlias(true);
        /*
        drawCircle的四个参数
        cx：圆心的x坐标。
        cy：圆心的y坐标。
        radius：圆的半径。
        paint：绘制时所使用的画笔
        */
        canvas.drawCircle(cx, cy, radius, paint);

        //第二步 画进度百分比 也就是中间文字
        if (textShow) {
            //文字颜色
            paint.setColor(textColor);
            //文字笔画宽度
            paint.setStrokeWidth(0);
            //文字大小
            paint.setTextSize(textSize);
            //字体
            paint.setTypeface(Typeface.DEFAULT);

            int percent = (int) (progress / (float) max * 100);
            String strPercent = percent + "%";
            //绘制文本对象
            Paint.FontMetricsInt pfm = paint.getFontMetricsInt();

            if (percent != 0) {
                canvas.drawText(strPercent, cx - paint.measureText(strPercent) / 2, cy + (pfm.bottom - pfm.top) / 2 - pfm.bottom, paint);
            } else {
                canvas.drawText("0%", cx - paint.measureText(strPercent) / 2, cy + (pfm.bottom - pfm.top) / 2 - pfm.bottom, paint);
            }
        }


        // 第三步 画圆弧
        RectF oval = new RectF(cx - radius, cy - radius, cx + radius, cy + radius);
        paint.setColor(roundProgressColor);
        paint.setStrokeWidth(roundWidth);
        paint.setStyle(Paint.Style.STROKE);
        /*
        setStrokeCap(Paint.Cap cap);
        当画笔样式为STROKE或FILL_OR_STROKE时，设置笔刷的图形样式，
        如圆形样式 Cap.ROUND,或方形样式Cap.SQUARE
        */
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(oval, 0, 360 * progress / max, false, paint);
    }

    public void setProgress(int progress) {
        if (isPainting) {
            Log.e("===MockingJay===","正在绘图。。。");
            if (progress < 0) {
                throw new IllegalArgumentException("进度Progress不能小于0");
            }
            if (progress > max) {
                progress = max;
            }
            if (progress <= max) {
                this.progress = progress;
                postInvalidate();
            }
        }else{
            Log.e("===MockingJay===","暂停绘图。。。");
        }


    }

}

































