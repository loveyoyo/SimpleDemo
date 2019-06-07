package com.kang.demo.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorSetActivity extends AppCompatActivity {

    @BindView(R.id.animatorSetActivity_iv1)
    ImageView mAnimatorSetActivityIv1;
    @BindView(R.id.animatorSetActivity_btn1)
    Button mAnimatorSetActivityBtn1;
    @BindView(R.id.animatorSetActivity_btn2)
    Button mAnimatorSetActivityBtn2;

    private Animator mAnimator;


    public static void toAnimatorSetActivity(Context context) {
        Intent intent = new Intent(context, AnimatorSetActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.animatorSetActivity_btn1, R.id.animatorSetActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.animatorSetActivity_btn1:
                mAnimator = AnimatorInflater.loadAnimator(this, R.animator.set_animator);
                mAnimator.setTarget(mAnimatorSetActivityIv1);
                mAnimator.start();
                break;
            case R.id.animatorSetActivity_btn2:
                mAnimator.end();
                break;
            default:
                break;
        }
    }

}
