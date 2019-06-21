package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CircleProgressActivity extends AppCompatActivity {

    @BindView(R.id.circleProgressActivity_btn1)
    Button mCircleProgressActivityBtn1;
    @BindView(R.id.circleProgressActivity_cpv1)
    CircleProgressView mCircleProgressActivityCpv1;

    Thread thread;
    Runnable runnable;

    public static void toCircleProgressActivity(Context context) {
        Intent intent = new Intent(context, CircleProgressActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
//        mCircleProgressActivityCpv1.setPainting(false);
        /*runnable = new Runnable() {
            @Override
            public void run() {
                if (mCircleProgressActivityCpv1.isPainting()) {
                    int progress = 0;
                    while (progress <= 100) {
                        progress += 2;
                        mCircleProgressActivityCpv1.setProgress(progress);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();*/

        mCircleProgressActivityCpv1.setRoundColor(Color.parseColor("#123123"));
    }

    @OnClick({R.id.circleProgressActivity_btn1, R.id.circleProgressActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.circleProgressActivity_btn1:
                mCircleProgressActivityCpv1.setPainting(true);
                Log.e("===MockingJay===", "开始。。。:" + mCircleProgressActivityCpv1.isPainting());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(mCircleProgressActivityCpv1.isPainting()){
                            int progress = 0;
                            while (progress <= 100) {
                                progress += 2;
                                mCircleProgressActivityCpv1.setProgress(progress);
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                }).start();
                break;
            case R.id.circleProgressActivity_btn2:
                Log.e("===MockingJay===", "结束。。。");
                mCircleProgressActivityCpv1.setPainting(false);
                break;
            default:
                break;
        }


    }

}
