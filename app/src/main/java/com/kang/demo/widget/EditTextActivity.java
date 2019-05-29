package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditTextActivity extends AppCompatActivity {

    @BindView(R.id.editTextActivity_et1)
    EditText mEditTextActivityEt1;
    @BindView(R.id.editTextActivity_et2)
    EditText mEditTextActivityEt2;
    @BindView(R.id.editTextActivity_tv1)
    TextView mEditTextActivityTv1;

    public static void toEditTextActivity(Context context) {
        Intent intent = new Intent(context, EditTextActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);

        mEditTextActivityEt1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int metaState = event.getMetaState();
                int unicodeChar = event.getUnicodeChar();
                String msg = "";
                msg += "按键动作：" + String.valueOf(event.getAction()) + "\n";
                msg += "按键代码：" + String.valueOf(keyCode) + "\n";
                msg += "按键字符：" + unicodeChar + "\n";
                msg += "UNICODE：" + String.valueOf(unicodeChar) + "\n";
                msg += "重复次数：" + String.valueOf(event.getRepeatCount()) + "\n";
                msg += "功能键状态：" + String.valueOf(metaState) + "\n";
                msg += "硬件编码：" + String.valueOf(event.getScanCode()) + "\n";
                msg += "按键标志：" + String.valueOf(event.getFlags()) + "\n";
                mEditTextActivityTv1.setText(msg);
                /*switch (keyCode) {
                    case KeyEvent.KEYCODE_ENTER:
                        Toast.makeText(EditTextActivity.this, "您在第一个et中点击了回车键", Toast.LENGTH_SHORT).show();
                        mEditTextActivityEt1.setText("hello world");
                        break;
                    default:
                        break;
                }*/
                return false;
            }
        });

        mEditTextActivityEt1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("===MockingJay===", "onTouch....");
                return false;
            }
        });
        mEditTextActivityEt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("===MockingJay===", "onFocusChange...");
            }
        });

        /*mEditTextActivityTv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("===MockingJay===", "tv    onTouch....");
                return false;
            }
        });*/
        /*mEditTextActivityTv1.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                Log.e("===MockingJay===", "onHover.....");
                return false;
            }
        });*/
        mEditTextActivityTv1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.e("===MockingJay===", "onDrag....");
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("===MockingJay===", "onTouchEvent...........");
        return super.onTouchEvent(event);
    }
}
