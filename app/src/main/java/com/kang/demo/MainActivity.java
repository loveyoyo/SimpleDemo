package com.kang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kang.demo.animation.AnimationActivity;
import com.kang.demo.widget.ButtonActivity;
import com.kang.demo.widget.EditTextActivity;
import com.kang.demo.widget.ImageViewActivity;
import com.kang.demo.widget.ListViewActivity;
import com.kang.demo.widget.ProgressBarActivity;
import com.kang.demo.widget.TextViewActivity;
import com.kang.demo.widget.TextViewRotateActivity;
import com.kang.demo.widget.TextViewURLSpanActivity;
import com.kang.demo.widget.ViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainActivity_tv_btn)
    Button mMainActivityTvBtn;
    @BindView(R.id.mainActivity_et_btn)
    Button mMainActivityEtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mainActivity_tv_btn, R.id.mainActivity_et_btn, R.id.mainActivity_autoLink_btn,
            R.id.mainActivity_rotate_btn, R.id.mainActivity_view_btn, R.id.mainActivity_button_btn,
            R.id.mainActivity_imageView_btn, R.id.mainActivity_listView_btn, R.id.mainActivity_progressBar_btn,
            R.id.mainActivity_animation_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mainActivity_tv_btn:
                TextViewActivity.toTextViewActivity(this);
                break;
            case R.id.mainActivity_et_btn:
                EditTextActivity.toEditTextActivity(this);
                break;
            case R.id.mainActivity_autoLink_btn:
                TextViewURLSpanActivity.toTextViewURLSpanActivity(this);
                break;
            case R.id.mainActivity_rotate_btn:
                TextViewRotateActivity.toTextViewRotateActivity(this);
                break;
            case R.id.mainActivity_view_btn:
                ViewActivity.toViewActivity(this);
                break;
            case R.id.mainActivity_button_btn:
                ButtonActivity.toButtonActivity(this);
                break;
            case R.id.mainActivity_imageView_btn:
                ImageViewActivity.toImageViewActivity(this);
                break;
            case R.id.mainActivity_listView_btn:
                ListViewActivity.toListViewActivity(this);
                break;
            case R.id.mainActivity_progressBar_btn:
                ProgressBarActivity.toProgressBarActivity(this);
                break;
            case R.id.mainActivity_animation_btn:
                AnimationActivity.toAnimationActivity(this);
                break;
            default:
                break;
        }
    }

}
