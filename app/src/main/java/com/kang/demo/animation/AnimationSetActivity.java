package com.kang.demo.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationSetActivity extends AppCompatActivity {

    @BindView(R.id.animationSetActivity_iv1)
    ImageView mAnimationSetActivityIv1;
    @BindView(R.id.animationSetActivity_iv2)
    ImageView mAnimationSetActivityIv2;
    @BindView(R.id.animationSetActivity_btn1)
    Button mAnimationSetActivityBtn1;
    @BindView(R.id.animationSetActivity_btn2)
    Button mAnimationSetActivityBtn2;

    public static void toAnimationSetActivity(Context context) {
        Intent intent = new Intent(context, AnimationSetActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_set);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.animationSetActivity_btn1, R.id.animationSetActivity_btn2, R.id.animationSetActivity_btn3, R.id.animationSetActivity_btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.animationSetActivity_btn1:
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_anim);
                mAnimationSetActivityIv1.startAnimation(animation);
                break;
            case R.id.animationSetActivity_btn2:
                mAnimationSetActivityIv1.clearAnimation();
                break;
            case R.id.animationSetActivity_btn3:
                Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.set_anim2);
                mAnimationSetActivityIv2.startAnimation(animation2);
                break;
            case R.id.animationSetActivity_btn4:
                mAnimationSetActivityIv2.clearAnimation();
                break;
            default:
                break;
        }
    }

}
