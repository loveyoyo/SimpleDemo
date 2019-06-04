package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.kang.demo.R;

public class ProgressBarActivity extends AppCompatActivity {

    public static void toProgressBarActivity(Context context) {
        Intent intent = new Intent(context, ProgressBarActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_progress_bar);
        setProgressBarIndeterminateVisibility(true);
    }

}
