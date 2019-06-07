package com.kang.demo.fourComponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.secondActivity_btn1)
    Button mSecondActivityBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.secondActivity_btn1,R.id.secondActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.secondActivity_btn1:
                Intent intent = new Intent();
                intent.putExtra("intent_result", "hello world");
                setResult(10, intent);
                finish();
                break;
            case R.id.secondActivity_btn2:
                Intent intent2 = new Intent();
                intent2.putExtra("intent_result2", "hello world again");
                setResult(11, intent2);
                finish();
                break;
                default:
                    break;
        }

    }

}
