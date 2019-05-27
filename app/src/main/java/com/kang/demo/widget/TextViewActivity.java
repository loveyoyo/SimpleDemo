package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextViewActivity extends AppCompatActivity {

    @BindView(R.id.textViewActivity_tv1)
    TextView mTextViewActivityTv1;
    @BindView(R.id.textViewActivity_tv2)
    TextView mTextViewActivityTv2;
    @BindView(R.id.textViewActivity_tv3)
    TextView mTextViewActivityTv3;
    @BindView(R.id.textViewActivity_v1)
    View mTextViewActivityV1;
    @BindView(R.id.textViewActivity_tv4)
    TextView mTextViewActivityTv4;
    @BindView(R.id.textViewActivity_v2)
    View mTextViewActivityV2;
    @BindView(R.id.textViewActivity_v3)
    View mTextViewActivityV3;

    public static void toTextViewActivity(Context context) {
        Intent intent = new Intent(context, TextViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
//        mTextViewActivityTv1.setTex
    }


    @OnClick({R.id.textViewActivity_tv2, R.id.textViewActivity_tv3, R.id.textViewActivity_tv1, R.id.textViewActivity_v1, R.id.textViewActivity_tv4, R.id.textViewActivity_v2, R.id.textViewActivity_v3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textViewActivity_tv2:
                break;
            case R.id.textViewActivity_tv3:
                Log.e("===MockingJay===","旋转的文字...");
                break;
            case R.id.textViewActivity_tv1:
                break;
            case R.id.textViewActivity_v1:
                break;
            case R.id.textViewActivity_tv4:
                break;
            case R.id.textViewActivity_v2:
                Log.e("===MockingJay===","scale...");
                break;
            case R.id.textViewActivity_v3:
                Log.e("===MockingJay===","translation...");
                break;
            default:
                break;
        }
    }

}
