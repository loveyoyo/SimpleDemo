package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.widget.TextView;

import com.kang.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextViewURLSpanActivity extends AppCompatActivity {

    @BindView(R.id.textViewURLSpanActivity_tv4)
    TextView mTextViewURLSpanActivityTv4;
    @BindView(R.id.textViewURLSpanActivity_tv5)
    TextView mTextViewURLSpanActivityTv5;
    @BindView(R.id.textViewURLSpanActivity_tv6)
    TextView mTextViewURLSpanActivityTv6;
    @BindView(R.id.textViewURLSpanActivity_tv7)
    TextView mTextViewURLSpanActivityTv7;
    @BindView(R.id.textViewURLSpanActivity_tv8)
    TextView mTextViewURLSpanActivityTv8;

    public static void toTextViewURLSpanActivity(Context context) {
        Intent intent = new Intent(context, TextViewURLSpanActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_urlspan);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        //使用动态代码设置文本的自动链接,需要把文本放在资源文件中才可以调用;
        mTextViewURLSpanActivityTv4.setMovementMethod(LinkMovementMethod.getInstance());
        //不使用资源文件;
        mTextViewURLSpanActivityTv5.setAutoLinkMask(Linkify.PHONE_NUMBERS);
        mTextViewURLSpanActivityTv5.setMovementMethod(LinkMovementMethod.getInstance());
        //使用Html.fromHtml()方法解析文本;
        mTextViewURLSpanActivityTv6.setText(Html.fromHtml("这是网址地址：<a href=\"https://github.com/loveyoyo\">github地址</a>。这是手机号码：<a href=\"tel:17682344650\">手机号码</a>"));
        mTextViewURLSpanActivityTv6.setMovementMethod(LinkMovementMethod.getInstance());
        //使用SpannableString;
        SpannableString spannableString = new SpannableString("这是github地址。这是手机号码。");
        spannableString.setSpan(new URLSpan("https://github.com/loveyoyo"), 2, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new URLSpan("tel:17682344650"), 13, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextViewURLSpanActivityTv7.setText(spannableString);
        mTextViewURLSpanActivityTv7.setMovementMethod(LinkMovementMethod.getInstance());
        //;
        Spannable spannable = (Spannable) mTextViewURLSpanActivityTv8.getText();
        URLSpan[] spans = spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i = 0; i < spans.length; i++) {
            String url = spans[i].getURL();
            int index = spannable.toString().indexOf(url);
            int end = index + url.length();
            if (index == -1) {
                if (url.contains("http://")) {
                    url = url.replace("http://", "");
                } else if (url.contains("https://")) {
                    url = url.replace("https://", "");
                } else if (url.contains("rtsp://")) {
                    url = url.replace("rtsp://", "");
                }
                index = spannable.toString().indexOf(url);
                end = index + url.length();
            }
            if (index != -1) {
                spannable.removeSpan(spans[i]);
                spannable.setSpan(new AutoLinkSpan(spans[i].getURL()), index
                        , end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }
//        mTextViewURLSpanActivityTv7.setText("这是网址地址：https://github.com/loveyoyo。这是手机号码：17682344650");


//        mTextViewURLSpanActivityTv5.setAutoLinkMask(Linkify.ALL);
//        mTextViewURLSpanActivityTv6.setAutoLinkMask(Linkify.ALL);

    }

}





































