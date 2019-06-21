package com.kang.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by MockingJay on 2019/6/19;
 * Description:
 */

public class CircleView extends View {

    private Paint mPaint;
    /*
    * 进度条与边界的距离
    * */
    private int edgeMargin;
    /*
    *圆形进度条的半径
    * */
    private int rotateRaduis;
    /*
    * 进度条与罗盘之间的距离
    * */
    private static final int mMaring = 25;

    private Context mContext;

    private Point centPoint;
    private Paint Gpaint;
    private Paint pPaint;
    private RectF oval;

    private boolean isDraging;//是否可以拖动小球
    private Point mRockBollPosition = new Point();//进度条上的小球位置
    private int mRadius = 8;
    private int playedRadian;//进度条已经播放的角度

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initValues();
        init();
    }

    private void initValues() {
        rotateRaduis = 3 * getScreenWidth() / 8;
        edgeMargin = getScreenWidth() / 8;
        /*
        * 画圆盘的画笔
        * */
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#FFFFFF"));
        centPoint = new Point(rotateRaduis + edgeMargin, rotateRaduis + edgeMargin);

        Gpaint = new Paint();//画进度条背景
        Gpaint.setColor(Color.GRAY); //设置圆环的颜色
        Gpaint.setStyle(Paint.Style.STROKE); //设置空心
        Gpaint.setStrokeWidth(8f); //设置圆环的宽度
        Gpaint.setAntiAlias(true);  //消除锯齿

        pPaint = new Paint();//画进度条进度的画笔
        pPaint.setColor(Color.RED); //设置圆环的颜色
        pPaint.setStyle(Paint.Style.STROKE); //设置空心
        pPaint.setStrokeWidth(8f); //设置圆环的宽度
        pPaint.setAntiAlias(true);  //消除锯齿

        oval = new RectF((float) (centPoint.x - rotateRaduis), (float) (centPoint.y - rotateRaduis),
                (float) (centPoint.x + rotateRaduis), (float) (centPoint.y + rotateRaduis));
    }

    private void init() {
        //InputStream is = getResources().openRawResource(R.drawable.img_record);
        //bgBitmap = BitmapFactory.decodeStream(is);
        //Matrix matrix = new Matrix();
        //float scale = (float)rotateRaduis*2/(float)bgBitmap.getWidth();
        //matrix.postScale(scale, scale);
        //bgBitmap = Bitmap.createBitmap(bgBitmap,0,0, bgBitmap.getWidth() ,bgBitmap.getHeight() ,matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(centPoint.x, centPoint.y, rotateRaduis, Gpaint); //画出圆环
        canvas.drawArc(oval, 270, playedRadian, false, pPaint);

//		if(isShowRock){
//		}
        canvas.drawCircle(mRockBollPosition.x, mRockBollPosition.y, mRadius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(rotateRaduis * 2 + edgeMargin * 2, rotateRaduis * 2 + edgeMargin * 2);
    }

    private int getScreenWidth() {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Log.e("===MockingJay===", "getScreenWidth:" + wm.getDefaultDisplay().getWidth());
        return wm.getDefaultDisplay().getWidth();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Point cp;
        Point rp;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Point np = new Point((int) event.getX(), (int) event.getY());
                int distance = distance(centPoint, np);
//                System.out.println("distance：" + distance + "，小：" + (rotateRaduis - mMaring) + "，大：" + (rotateRaduis + mMaring));
                cp = new Point((int) event.getX(), (int) event.getY());
                rp = getOnRadius(cp);
                if (distance >= rotateRaduis - mMaring && distance <= rotateRaduis + mMaring) {
                    mRockBollPosition.set(rp.x, rp.y);
                    Log.i("===MockingJay===", "点下有效");
                    mRadius = mMaring;
                    isDraging = true;
                    //Point pp = new Point((int)event.getX(),(int)event.getY());
                    flushRadian(centPoint, cp);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isDraging) {
                    cp = new Point((int) event.getX(), (int) event.getY());
                    rp = getOnRadius(cp);
                    mRockBollPosition.set(rp.x, rp.y);
                    flushRadian(centPoint, cp);
                }
                break;
            case MotionEvent.ACTION_UP:
                isDraging = false;
                mRadius = 8;
                break;
            default:
                break;
        }
        invalidate();
        return true;
    }

    private Point getOnRadius(Point cp) {
        float radian = getRadian(cp, centPoint);
        int cX = centPoint.x + (int) (rotateRaduis * Math.cos(radian));
        int cY = centPoint.y - (int) (rotateRaduis * Math.sin(radian));
        return new Point(cX, cY);
    }

    private void flushRadian(Point cp, Point pp) {
        float lenA = pp.x - cp.x;
        float lenB = cp.y - pp.y;
//		float lenC = (float) Math.sqrt(lenA*lenA+lenB*lenB);
        float a = lenA / lenB;
//		System.out.println("余数----------》"+a);
        double atan = Math.atan(lenA / lenB);
        double radian = (atan / Math.PI) * 180;
        if (pp.x > cp.x) {
            if (radian > 0) {
                playedRadian = (int) radian;
            } else {
                playedRadian = (int) (180 + radian);
            }
        } else {
            if (radian >= 0) {
                playedRadian = (int) (180 + radian);
            } else {
                playedRadian = (int) (360 + radian);
            }
        }
        progressListener.setProgresschanged((float) playedRadian / 360f);
//		System.out.println("atan:"+(atan/Math.PI)*180);
    }

    private int distance(Point cp, Point np) {
        try {
            int dx = np.x - cp.x;
            int dy = np.y - cp.y;
            return (int) Math.sqrt(Math.abs(dx * dx) + Math.abs(dy * dy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param a
     * @param b
     * @return
     * @describe 触摸点与中心点之间直线与水平方向的夹角角
     */
    public static float getRadian(Point a, Point b) {
        float lenA = a.x - b.x;
        float lenB = a.y - b.y;
        float lenC = (float) Math.sqrt(lenA * lenA + lenB * lenB);
        float ang = (float) Math.acos(lenA / lenC);
        ang = ang * (b.y < a.y ? -1 : 1);
        return ang;
    }

    /**
     * 根据进度条角度刷新小球的位置
     *
     * @param ang
     */
    private void flushRockPosition(int ang) {
//		mRockBollPosition.s
        mRockBollPosition.y = (int) (centPoint.y - (Math.cos(((float) ang / 180f) * Math.PI) * rotateRaduis));
        mRockBollPosition.x = (int) (centPoint.x + (Math.sin(((float) ang / 180f) * Math.PI) * rotateRaduis));
//		Log.i(TAG, "角度ang="+ang);
//		Log.i(TAG, "小球位置x="+mRockBollPosition.x+",y="+mRockBollPosition.y);
    }

    public void setProgress(float progress) {
        playedRadian = (int) (360 * progress);
        flushRockPosition(playedRadian);
        invalidate();
    }

    private ProgressChangedListener progressListener;

    public void setProgressListener(ProgressChangedListener progressListener) {
        this.progressListener = progressListener;
    }

    public interface ProgressChangedListener {
        void setProgresschanged(float progress);
    }
}

