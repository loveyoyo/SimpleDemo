package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewActivity extends AppCompatActivity {

    @BindView(R.id.imageViewActivity_iv1)
    ImageView mImageViewActivityIv1;
    @BindView(R.id.imageViewActivity_iv2)
    ImageView mImageViewActivityIv2;
    @BindView(R.id.imageViewActivity_iv3)
    ImageView mImageViewActivityIv3;
    @BindView(R.id.imageViewActivity_iv4)
    ImageView mImageViewActivityIv4;
    @BindView(R.id.imageViewActivity_iv5)
    ImageView mImageViewActivityIv5;
    @BindView(R.id.imageViewActivity_iv6)
    ImageView mImageViewActivityIv6;
    @BindView(R.id.imageViewActivity_iv7)
    ImageView mImageViewActivityIv7;
    @BindView(R.id.imageViewActivity_iv8)
    ImageView mImageViewActivityIv8;
    @BindView(R.id.imageViewActivity_iv9)
    ImageView mImageViewActivityIv9;

    public static void toImageViewActivity(Context context) {
        Intent intent = new Intent(context, ImageViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        mImageViewActivityIv3.setAdjustViewBounds(true);
    }

}
