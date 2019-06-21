package com.kang.demo.widget;

import android.app.Activity;
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

public class WidgetActivity extends AppCompatActivity {

    @BindView(R.id.widgetActivity_view_btn)
    Button mWidgetActivityViewBtn;
    @BindView(R.id.widgetActivity_tv_btn)
    Button mWidgetActivityTvBtn;
    @BindView(R.id.widgetActivity_et_btn)
    Button mWidgetActivityEtBtn;
    @BindView(R.id.widgetActivity_autoLink_btn)
    Button mWidgetActivityAutoLinkBtn;
    @BindView(R.id.widgetActivity_rotate_btn)
    Button mWidgetActivityRotateBtn;
    @BindView(R.id.widgetActivity_button_btn)
    Button mWidgetActivityButtonBtn;
    @BindView(R.id.widgetActivity_imageView_btn)
    Button mWidgetActivityImageViewBtn;
    @BindView(R.id.widgetActivity_listView_btn)
    Button mWidgetActivityListViewBtn;
    @BindView(R.id.widgetActivity_progressBar_btn)
    Button mWidgetActivityProgressBarBtn;

    Activity mActivity;
    View mView;


    public static void toWidgetActivity(Context context){
        Intent intent = new Intent(context,WidgetActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.widgetActivity_view_btn, R.id.widgetActivity_tv_btn, R.id.widgetActivity_et_btn,
            R.id.widgetActivity_autoLink_btn, R.id.widgetActivity_rotate_btn, R.id.widgetActivity_button_btn,
            R.id.widgetActivity_imageView_btn, R.id.widgetActivity_listView_btn, R.id.widgetActivity_progressBar_btn,
            R.id.widgetActivity_listViewSwipe_btn,R.id.widgetActivity_font_btn,R.id.widgetActivity_circleView_btn,
            R.id.widgetActivity_circleProgressView_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.widgetActivity_view_btn:
                ViewActivity.toViewActivity(this);
                break;
            case R.id.widgetActivity_tv_btn:
                TextViewActivity.toTextViewActivity(this);
                break;
            case R.id.widgetActivity_et_btn:
                EditTextActivity.toEditTextActivity(this);
                break;
            case R.id.widgetActivity_autoLink_btn:
                TextViewURLSpanActivity.toTextViewURLSpanActivity(this);
                break;
            case R.id.widgetActivity_rotate_btn:
                TextViewRotateActivity.toTextViewRotateActivity(this);
                break;
            case R.id.widgetActivity_button_btn:
                ButtonActivity.toButtonActivity(this);
                break;
            case R.id.widgetActivity_imageView_btn:
                ImageViewActivity.toImageViewActivity(this);
                break;
            case R.id.widgetActivity_listView_btn:
                ListViewActivity.toListViewActivity(this);
                break;
            case R.id.widgetActivity_progressBar_btn:
                ProgressBarActivity.toProgressBarActivity(this);
                break;
            case R.id.widgetActivity_listViewSwipe_btn:
                ListViewSwipeActivity.toListViewSwipeActivity(this);
                break;
            case R.id.widgetActivity_font_btn:
                TextViewFontActivity.toTextViewFontActivity(this);
                break;
            case R.id.widgetActivity_circleView_btn:
                CircleViewActivity.toCircleViewActivity(this);
                break;
            case R.id.widgetActivity_circleProgressView_btn:
                CircleProgressActivity.toCircleProgressActivity(this);
                break;
            default:
                break;
        }
    }

}
