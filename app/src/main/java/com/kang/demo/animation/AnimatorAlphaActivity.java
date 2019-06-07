package com.kang.demo.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorAlphaActivity extends AppCompatActivity {

    @BindView(R.id.alphaAnimatorActivity_iv1)
    ImageView mAlphaAnimatorActivityIv1;
    @BindView(R.id.alphaAnimatorActivity_btn1)
    Button mAlphaAnimatorActivityBtn1;
    @BindView(R.id.alphaAnimatorActivity_btn2)
    Button mAlphaAnimatorActivityBtn2;

    private Animator mAnimator;

    public static void toAlphaAnimatorActivity(Context context) {
        Intent intent = new Intent(context, AnimatorAlphaActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_animator);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.alphaAnimatorActivity_btn1, R.id.alphaAnimatorActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alphaAnimatorActivity_btn1:
                mAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha_animator);
                mAnimator.setTarget(mAlphaAnimatorActivityIv1);
                mAnimator.start();
                break;
            case R.id.alphaAnimatorActivity_btn2:
                mAnimator.end();
                break;
            default:
                break;
        }
    }

}
