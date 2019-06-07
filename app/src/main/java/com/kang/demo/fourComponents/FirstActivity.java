package com.kang.demo.fourComponents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.firstActivity_btn1)
    Button mFirstActivityBtn1;
    @BindView(R.id.firstActivity_btn2)
    Button mFirstActivityBtn2;

    public static void toFirstActivity(Context context) {
        Intent intent = new Intent(context, FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.firstActivity_btn1, R.id.firstActivity_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.firstActivity_btn1:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivityForResult(intent, -1);
                break;
            case R.id.firstActivity_btn2:
                Intent intent2 = new Intent(this, SecondActivity.class);
                startActivityForResult(intent2, 1);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("===MockingJay===", "onActivityResult...");

        switch (requestCode) {
            case -1:
                Log.e("===MockingJay===","-1..............");
                String str = data.getStringExtra("intent_result");
                Log.e("===MockingJay===", "str:" + str);
                break;
            case 1:
                Log.e("===MockingJay===","1......1.......1..........");
                String str2 = data.getStringExtra("intent_result2");
                Log.e("===MockingJay===", "str2:" + str2);
                break;
            default:
                break;
        }
    }

}
