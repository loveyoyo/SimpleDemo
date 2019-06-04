package com.kang.demo.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawableAnimActivity extends AppCompatActivity {

    @BindView(R.id.drawableAnimActivity_iv1)
    ImageView mDrawableAnimActivityIv1;

    Application mApplication;
    Activity mActivity;
    Service mService;
    Animator mAnimator;
    Animation mAnimation;
    AnimatorSet mAnimatorSet;
    ValueAnimator mValueAnimator;
    ObjectAnimator mObjectAnimator;
    TimeAnimator mTimeAnimator;

    public static void toDrawableAnimActivity(Context context) {
        Intent intent = new Intent(context, DrawableAnimActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawable_anim);
        ButterKnife.bind(this);
        Log.e("===MockingJay===", "onCreate...");

        initView();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e("===MockingJay===", "onWindowFocusChanged...");
    }

    private void initView() {
        mDrawableAnimActivityIv1.setBackgroundResource(R.drawable.drawable_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) mDrawableAnimActivityIv1.getBackground();
        animationDrawable.start();
        Log.e("===MockingJay===", "动画开始了...");

    }

}
