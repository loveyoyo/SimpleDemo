package com.kang.demo.hardware;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScreenOnOrOffActivity extends AppCompatActivity {

    @BindView(R.id.screenActivity_on_btn)
    Button mScreenActivityOnBtn;
    @BindView(R.id.screenActivity_off_btn)
    Button mScreenActivityOffBtn;

    PowerManager powerManager;
    PowerManager.WakeLock wakeLock;
    BitmapDrawable mBitmapDrawable;

    public static void toScreenOnOrOffActivity(Context context) {
        Intent intent = new Intent(context, ScreenOnOrOffActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_on_or_off);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
//        wakeLock.release();
    }

    @OnClick({R.id.screenActivity_on_btn, R.id.screenActivity_off_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.screenActivity_on_btn:
                setScreenOn();
//                getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                break;
            case R.id.screenActivity_off_btn:
//                wakeLock.release();
                setScreenOff();
                break;
            default:
                break;
        }
    }

    private void setScreenOn() {
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "kang");
        wakeLock.acquire();
    }

    private void setScreenOff() {
//        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
//        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "kang");
//        wakeLock.release();

        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName componentName = new ComponentName(this, AdminReceiver.class);
        boolean isAdmin = devicePolicyManager.isAdminActive(componentName);
        Log.e("===MockingJay===", "isAdmin:" + isAdmin);
        if (!isAdmin) {
            //打开DevicePolicyManager管理器，授权页面
            Intent intent = new Intent();
            //授权页面Action -->  DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN
            intent.setAction(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            //设置DEVICE_ADMIN，告诉系统申请管理者权限的Component/DeviceAdminReceiver
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
            //设置 提示语--可不添加
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "DevicePolicyManager涉及的管理权限,一次性激活!");
            startActivityForResult(intent, 100);
        } else {

        }
        devicePolicyManager.lockNow();
    }

}


































