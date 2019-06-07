package com.kang.demo.res;

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

public class ResActivity extends AppCompatActivity {

    @BindView(R.id.resActivity_btn1)
    Button mResActivityBtn1;
    @BindView(R.id.resActivity_btn2)
    Button mResActivityBtn2;

    public static void toResActivity(Context context) {
        Intent intent = new Intent(context, ResActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.resActivity_btn1, R.id.resActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.resActivity_btn1:
                LayoutActivity.toLayoutActivity(this);
                break;
            case R.id.resActivity_btn2:

                break;
            default:
                break;
        }
    }

}
