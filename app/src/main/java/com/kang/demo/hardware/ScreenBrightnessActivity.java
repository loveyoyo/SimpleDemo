package com.kang.demo.hardware;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScreenBrightnessActivity extends AppCompatActivity {

    @BindView(R.id.brightnessActivity_current_btn)
    Button mBrightnessActivityCurrentBtn;
    @BindView(R.id.brightnessActivity_tv1)
    TextView mBrightnessActivityTv1;
    @BindView(R.id.brightnessActivity_oneActivity_btn)
    Button mBrightnessActivityOneActivityBtn;
    @BindView(R.id.brightnessActivity_allActivity_btn)
    Button mBrightnessActivityAllActivityBtn;
    @BindView(R.id.brightnessActivity_isAuto_btn)
    Button mBrightnessActivityIsAutoBtn;
    @BindView(R.id.brightnessActivity_tv2)
    TextView mBrightnessActivityTv2;
    @BindView(R.id.brightnessActivity_tv3)
    TextView mBrightnessActivityTv3;
    @BindView(R.id.brightnessActivity_openAuto_btn)
    Button mBrightnessActivityOpenAutoBtn;
    @BindView(R.id.brightnessActivity_closeAuto_btn)
    Button mBrightnessActivityCloseAutoBtn;




    public static void toScreenBrightnessActivity(Context context) {
        Intent intent = new Intent(context, ScreenBrightnessActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_brightness);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.brightnessActivity_current_btn, R.id.brightnessActivity_oneActivity_btn, R.id.brightnessActivity_mode_btn,
            R.id.brightnessActivity_allActivity_btn, R.id.brightnessActivity_isAuto_btn, R.id.brightnessActivity_openAuto_btn,
            R.id.brightnessActivity_closeAuto_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.brightnessActivity_current_btn:
                int currentBrightness = getCurrentScreenBrightness(this);
                mBrightnessActivityTv1.setText("当前屏幕亮度是：" + currentBrightness);
                break;
            case R.id.brightnessActivity_mode_btn:
                int mode = getCurrentScreenBrightnessMode(this);
                if (mode == 0) {
                    mBrightnessActivityTv2.setText("当前系统亮度模式：" + "手动调节");
                } else if (mode == 1) {
                    mBrightnessActivityTv2.setText("当前系统亮度模式：" + "自动调节");
                }
                break;
            case R.id.brightnessActivity_oneActivity_btn:
                setCurrentBrightness(this, 200);
                break;
            case R.id.brightnessActivity_allActivity_btn:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (!Settings.System.canWrite(this)) {
                        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                        intent.setData(Uri.parse("package:" + this.getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        this.startActivity(intent);
                    } else {
                        //有了权限，具体的操作;
                        setSystemBrightness(this,200);
                    }
                }
                break;
            case R.id.brightnessActivity_isAuto_btn:
                break;
            case R.id.brightnessActivity_openAuto_btn:
                requestPermission(1);
                break;
            case R.id.brightnessActivity_closeAuto_btn:
                requestPermission(0);
                break;
            default:
                break;
        }
    }

    private void requestPermission(int mode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + this.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.startActivity(intent);
            } else {
                //有了权限，具体的操作;
                setScreenMode(this, mode);
            }
        }
    }


    private int getCurrentScreenBrightness(Context context) {
        int currentBrightness = 0;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            currentBrightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        Log.e("===MockingJay===", "currentBrightness:" + currentBrightness);
        return currentBrightness;
    }

    private int getCurrentScreenBrightnessMode(Context context) {
        int screenBrightnessMode = 0;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            screenBrightnessMode = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return screenBrightnessMode;
    }

    private void setScreenMode(Context context, int mode) {
        ContentResolver contentResolver = getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, mode);
    }

    private void setCurrentBrightness(Activity activity, int brightness) {
        WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
        layoutParams.screenBrightness = Float.valueOf(brightness) * (1f / 255f);
        activity.getWindow().setAttributes(layoutParams);
    }

    private void setSystemBrightness(Context context,int brightness){
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = android.provider.Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS);
        android.provider.Settings.System.putInt(contentResolver,Settings.System.SCREEN_BRIGHTNESS,brightness);
        contentResolver.notifyChange(uri,null);
    }


}








































