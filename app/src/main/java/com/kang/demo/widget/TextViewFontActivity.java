package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextViewFontActivity extends AppCompatActivity {

    @BindView(R.id.textViewFontActivity_tv1)
    TextView mTextViewFontActivityTv1;
    @BindView(R.id.textViewFontActivity_tv2)
    TextView mTextViewFontActivityTv2;
    @BindView(R.id.textViewFontActivity_tv3)
    TextView mTextViewFontActivityTv3;
    @BindView(R.id.textViewFontActivity_tv4)
    TextView mTextViewFontActivityTv4;
    @BindView(R.id.textViewFontActivity_tv5)
    TextView mTextViewFontActivityTv5;
    @BindView(R.id.textViewFontActivity_tv6)
    TextView mTextViewFontActivityTv6;
    @BindView(R.id.textViewFontActivity_tv7)
    TextView mTextViewFontActivityTv7;
    @BindView(R.id.textViewFontActivity_tv8)
    TextView mTextViewFontActivityTv8;
    @BindView(R.id.textViewFontActivity_tv9)
    TextView mTextViewFontActivityTv9;

    Typeface mTypeface;

    public static void toTextViewFontActivity(Context context) {
        Intent intent = new Intent(context, TextViewFontActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_font);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        AssetManager assetManager = getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/SmoothieShoppe.ttf");
        mTextViewFontActivityTv1.setTypeface(typeface);

//        mTextViewFontActivityTv2.setTypeface(Typeface.DEFAULT);
//        mTextViewFontActivityTv2.setTypeface(Typeface.SERIF);
//        mTextViewFontActivityTv2.setTypeface(Typeface.MONOSPACE);
//        mTextViewFontActivityTv2.setTypeface(Typeface.SANS_SERIF);
//        mTextViewFontActivityTv2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//        mTextViewFontActivityTv2.setTypeface(Typeface.DEFAULT,Typeface.BOLD_ITALIC);
//        mTextViewFontActivityTv2.setTypeface(Typeface.DEFAULT,Typeface.ITALIC);

        Typeface typeface2 = Typeface.createFromAsset(assetManager, "fonts/55.ttf");
        mTextViewFontActivityTv3.setTypeface(typeface2);



        mTextViewFontActivityTv4.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
        mTextViewFontActivityTv5.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
        mTextViewFontActivityTv6.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
        mTextViewFontActivityTv7.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
//        mTextViewFontActivityTv8.setTypeface(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
//        mTextViewFontActivityTv9.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        mTextViewFontActivityTv9.setTextSize(15);
        mTextViewFontActivityTv9.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);


    }

    /*public float sp2px(Context context,float value){
        float dimension = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,value,context.getResources().getDisplayMetrics());
        return dimension;
    }*/

    public static float sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return  spValue * fontScale;
    }


}





































