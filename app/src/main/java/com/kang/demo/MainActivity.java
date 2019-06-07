package com.kang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kang.demo.animation.AnimationActivity;
import com.kang.demo.fourComponents.ComponentActivity;
import com.kang.demo.res.ResActivity;
import com.kang.demo.widget.ButtonActivity;
import com.kang.demo.widget.EditTextActivity;
import com.kang.demo.widget.ImageViewActivity;
import com.kang.demo.widget.ListViewActivity;
import com.kang.demo.widget.ProgressBarActivity;
import com.kang.demo.widget.TextViewActivity;
import com.kang.demo.widget.TextViewRotateActivity;
import com.kang.demo.widget.TextViewURLSpanActivity;
import com.kang.demo.widget.ViewActivity;
import com.kang.demo.widget.WidgetActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mainActivity_widget_btn,R.id.mainActivity_animation_btn, R.id.mainActivity_res_btn, R.id.mainActivity_component_btn})
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
            default:
                break;
        }
    }

}
