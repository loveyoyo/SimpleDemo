package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kang.demo.R;

public class TextViewRotateActivity extends AppCompatActivity {

    public static void toTextViewRotateActivity(Context context) {
        Intent intent = new Intent(context, TextViewRotateActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_rotate);
    }
}
