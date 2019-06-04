package com.kang.demo.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends AppCompatActivity {

    @BindView(R.id.animationActivity_anim_alpha_btn)
    Button mAnimationActivityAnimAlphaBtn;
    @BindView(R.id.animationActivity_anim_rotate_btn)
    Button mAnimationActivityAnimRotateBtn;
    @BindView(R.id.animationActivity_anim_scale_btn)
    Button mAnimationActivityAnimScaleBtn;
    @BindView(R.id.animationActivity_anim_translate_btn)
    Button mAnimationActivityAnimTranslateBtn;

    public static void toAnimationActivity(Context context) {
        Intent intent = new Intent(context, AnimationActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.animationActivity_anim_alpha_btn, R.id.animationActivity_anim_rotate_btn, R.id.animationActivity_anim_scale_btn,
            R.id.animationActivity_anim_translate_btn, R.id.animationActivity_drawable_btn, R.id.animationActivity_anim_set1_btn,
            R.id.animationActivity_animator_alpha_btn,R.id.animationActivity_animator_set1_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.animationActivity_anim_alpha_btn:
                AnimAlphaActivity.toAnimAlphaActivity(this);
                break;
            case R.id.animationActivity_anim_rotate_btn:
                break;
            case R.id.animationActivity_anim_scale_btn:
                break;
            case R.id.animationActivity_anim_translate_btn:
                break;
            case R.id.animationActivity_drawable_btn:
                DrawableAnimActivity.toDrawableAnimActivity(this);
                break;
            case R.id.animationActivity_anim_set1_btn:
                AnimationSetActivity.toAnimationSetActivity(this);
                break;
            case R.id.animationActivity_animator_alpha_btn:
                AnimatorAlphaActivity.toAlphaAnimatorActivity(this);
                break;
            case R.id.animationActivity_animator_set1_btn:
                AnimatorSetActivity.toAnimatorSetActivity(this);
                break;
            default:
                break;
        }
    }

}
