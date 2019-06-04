package com.kang.demo.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimAlphaActivity extends AppCompatActivity {


     


    @BindView(R.id.animAlphaActivity_iv1)
    ImageView mAnimAlphaActivityIv1;
    @BindView(R.id.animAlphaActivity_btn1)
    Button mAnimAlphaActivityBtn1;
    @BindView(R.id.animAlphaActivity_btn2)
    Button mAnimAlphaActivityBtn2;

    private Animation animationAlpha;
    Interpolator mInterpolator;

    public static void toAnimAlphaActivity(Context context) {
        Intent intent = new Intent(context, AnimAlphaActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_alpha);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.animAlphaActivity_btn1, R.id.animAlphaActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.animAlphaActivity_btn1:
                Log.e("===MockingJay===","animAlphaActivity_btn1...");
                animationAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
                mAnimAlphaActivityIv1.startAnimation(animationAlpha);
                break;
            case R.id.animAlphaActivity_btn2:
                Log.e("===MockingJay===","animAlphaActivity_btn2...");
                mAnimAlphaActivityIv1.clearAnimation();
                break;
            default:
                break;
        }
    }

}
