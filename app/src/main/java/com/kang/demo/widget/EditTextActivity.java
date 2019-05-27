package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditTextActivity extends AppCompatActivity {

    @BindView(R.id.editTextActivity_et1)
    EditText mEditTextActivityEt1;
    @BindView(R.id.editTextActivity_v1)
    View mEditTextActivityV1;
    @BindView(R.id.editTextActivity_v2)
    View mEditTextActivityV2;
    @BindView(R.id.editTextActivity_v3)
    View mEditTextActivityV3;
    @BindView(R.id.editTextActivity_v4)
    View mEditTextActivityV4;
    @BindView(R.id.editTextActivity_v5)
    View mEditTextActivityV5;
    @BindView(R.id.editTextActivity_v6)
    View mEditTextActivityV6;
    @BindView(R.id.editTextActivity_v7)
    View mEditTextActivityV7;
    @BindView(R.id.editTextActivity_v8)
    View mEditTextActivityV8;
    @BindView(R.id.editTextActivity_v9)
    View mEditTextActivityV9;
    @BindView(R.id.editTextActivity_tv1)
    TextView mEditTextActivityTv1;
    @BindView(R.id.editTextActivity_tv2)
    TextView mEditTextActivityTv2;
    @BindView(R.id.editTextActivity_tv3)
    TextView mEditTextActivityTv3;

    public static void toEditTextActivity(Context context) {
        Intent intent = new Intent(context, EditTextActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);

        mEditTextActivityEt1.setAlpha(0.1f);
        mEditTextActivityV1.getBackground().setAlpha(1);
        mEditTextActivityV2.getBackground().setAlpha(255);

        mEditTextActivityTv3.getBackground().mutate().setAlpha(12);

    }
}
