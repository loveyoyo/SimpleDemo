package com.kang.demo.fourComponents;

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

public class ComponentActivity extends AppCompatActivity {

    @BindView(R.id.componentActivity_btn1)
    Button mComponentActivityBtn1;
    @BindView(R.id.componentActivity_btn2)
    Button mComponentActivityBtn2;
    @BindView(R.id.componentActivity_btn3)
    Button mComponentActivityBtn3;

    public static void toComponentActivity(Context context){
        Intent intent = new Intent(context,ComponentActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.componentActivity_btn1, R.id.componentActivity_btn2, R.id.componentActivity_btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.componentActivity_btn1:
                FirstActivity.toFirstActivity(this);
                break;
            case R.id.componentActivity_btn2:

                break;
            case R.id.componentActivity_btn3:
                break;
            default:
                break;
        }
    }

}
