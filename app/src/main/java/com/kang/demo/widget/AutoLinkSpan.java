package com.kang.demo.widget;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

import com.kang.demo.MainActivity;
import com.kang.demo.R;

/**
 * Created by MockingJay on 2019/5/27;
 * Description:
 */

public class AutoLinkSpan extends URLSpan {

    public AutoLinkSpan(String url) {
        super(url);
    }

    public AutoLinkSpan(Parcel src) {
        super(src);
    }

    @Override
    public void onClick(View widget) {
        if (widget.getTag(R.id.textViewURLSpanActivity_tv8) != null) {
            widget.setTag(R.id.textViewURLSpanActivity_tv8, null);
            return;
        }
        Intent intent = new Intent(widget.getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        widget.getContext().startActivity(intent);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
//        ds.setColor(ds.getColor());
        ds.setColor(Color.parseColor("#00ff00"));
        ds.setUnderlineText(false);
    }

}
