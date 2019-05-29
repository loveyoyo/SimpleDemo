package com.kang.demo.widget;

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

public class ButtonActivity extends AppCompatActivity {

    @BindView(R.id.buttonActivity_btn1)
    Button mButtonActivityBtn1;
    @BindView(R.id.buttonActivity_btn2)
    Button mButtonActivityBtn2;

    public static void toButtonActivity(Context context) {
        Intent intent = new Intent(context, ButtonActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.buttonActivity_btn1, R.id.buttonActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonActivity_btn1:

                break;
            case R.id.buttonActivity_btn2:

                break;
            default:
                break;
        }
    }

}
