package com.kang.demo.res;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kang.demo.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutActivity extends AppCompatActivity {

    @BindView(R.id.title_leftTv)
    TextView mTitleLeftTv;
    @BindView(R.id.title_contentTv)
    TextView mTitleContentTv;
    @BindView(R.id.title_rightTv)
    TextView mTitleRightTv;
    @BindView(R.id.layoutActivity_tv1)
    TextView mLayoutActivityTv1;

    public static void toLayoutActivity(Context context) {
        Intent intent = new Intent(context, LayoutActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_leftTv, R.id.title_rightTv, R.id.layoutActivity_tv1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_leftTv:
                try {
                    String str = URLEncoder.encode("福利", "UTF-8");
                    Log.e("===MockingJay===", "str:" + str);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.title_rightTv:
                break;
            case R.id.layoutActivity_tv1:
                break;
            default:
                break;
        }
    }

}
