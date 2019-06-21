package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleViewActivity extends AppCompatActivity {

    @BindView(R.id.circleViewActivity_cv1)
    CircleView mCircleViewActivityCv1;

    public static void toCircleViewActivity(Context context) {
        Intent intent = new Intent(context, CircleViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mCircleViewActivityCv1.setProgressListener(new CircleView.ProgressChangedListener() {
            @Override
            public void setProgresschanged(float progress) {
                Log.e("===MockingJay===", "progress:" + progress);
            }
        });
    }
}
