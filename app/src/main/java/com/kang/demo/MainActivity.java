package com.kang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kang.demo.widget.EditTextActivity;
import com.kang.demo.widget.TextViewActivity;
import com.kang.demo.widget.TextViewRotateActivity;
import com.kang.demo.widget.TextViewURLSpanActivity;

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

    @OnClick({R.id.mainActivity_tv_btn, R.id.mainActivity_et_btn, R.id.mainActivity_autoLink_btn, R.id.mainActivity_rotate_btn})
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
            default:
                break;
        }
    }

}
