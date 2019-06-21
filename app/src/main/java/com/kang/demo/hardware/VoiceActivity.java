package com.kang.demo.hardware;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kang.demo.R;

public class VoiceActivity extends AppCompatActivity {

    public static void toVoiceActivity(Context context){
        Intent intent = new Intent(context,VoiceActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
    }

}
