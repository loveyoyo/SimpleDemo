package com.kang.demo.hardware;

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

public class HardwareActivity extends AppCompatActivity {

    @BindView(R.id.hardwareActivity_brightness_btn)
    Button mHardwareActivityBrightnessBtn;
    @BindView(R.id.hardwareActivity_voice_btn)
    Button mHardwareActivityVoiceBtn;

    public static void toHardwareActivity(Context context){
        Intent intent = new Intent(context,HardwareActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.hardwareActivity_brightness_btn,R.id.hardwareActivity_screenOnOrOff_btn, R.id.hardwareActivity_voice_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hardwareActivity_brightness_btn:
                ScreenBrightnessActivity.toScreenBrightnessActivity(this);
                break;
            case R.id.hardwareActivity_screenOnOrOff_btn:
                ScreenOnOrOffActivity.toScreenOnOrOffActivity(this);
                break;
            case R.id.hardwareActivity_voice_btn:
                VoiceActivity.toVoiceActivity(this);
                break;
            default:
                break;
        }
    }

}
