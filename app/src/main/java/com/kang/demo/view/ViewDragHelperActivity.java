package com.kang.demo.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kang.demo.R;

public class ViewDragHelperActivity extends AppCompatActivity {

    public static void toViewDragHelperActivity(Context context) {
        Intent intent = new Intent(context, ViewDragHelperActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drag_helper);
    }
}
