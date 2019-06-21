package com.kang.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kang.demo.animation.AnimationActivity;
import com.kang.demo.fourComponents.ComponentActivity;
import com.kang.demo.hardware.HardwareActivity;
import com.kang.demo.res.ResActivity;
import com.kang.demo.view.ViewAllActivity;
import com.kang.demo.widget.WidgetActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WidgetActivity.toWidgetActivity(MainActivity.this);
                finish();
            }
        },1000);
    }

    @OnClick({R.id.mainActivity_widget_btn, R.id.mainActivity_animation_btn, R.id.mainActivity_res_btn,
            R.id.mainActivity_component_btn, R.id.mainActivity_view_btn, R.id.mainActivity_system_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mainActivity_widget_btn:
                WidgetActivity.toWidgetActivity(this);
                break;
            case R.id.mainActivity_animation_btn:
                AnimationActivity.toAnimationActivity(this);
                break;
            case R.id.mainActivity_res_btn:
                ResActivity.toResActivity(this);
                break;
            case R.id.mainActivity_component_btn:
                ComponentActivity.toComponentActivity(this);
                break;
            case R.id.mainActivity_view_btn:
                ViewAllActivity.toViewActivity(this);
                break;
            case R.id.mainActivity_system_btn:
                HardwareActivity.toHardwareActivity(this);
                break;
            default:
                break;
        }
    }

}
