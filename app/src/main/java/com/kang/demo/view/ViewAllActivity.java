package com.kang.demo.view;

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

public class ViewAllActivity extends AppCompatActivity {

    public static void toViewActivity(Context context) {
        Intent intent = new Intent(context, ViewAllActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.viewActivity_viewDragHelper_btn)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.viewActivity_viewDragHelper_btn:
                ViewDragHelperActivity.toViewDragHelperActivity(this);
                break;
            default:
                break;
        }
    }
}
