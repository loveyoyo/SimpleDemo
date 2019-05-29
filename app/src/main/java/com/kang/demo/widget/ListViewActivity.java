package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.kang.demo.R;
import com.kang.demo.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.listViewActivity_lv1)
    ListView mListViewActivityLv1;
    @BindView(R.id.listViewActivity_tv1)
    Button mListViewActivityTv1;

    private List<String> mList = new ArrayList<>();
    private ListViewAdapter mListViewAdapter;

    public static void toListViewActivity(Context context) {
        Intent intent = new Intent(context, ListViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String str = "";
        for (int i = 0; i < 300; i++) {
            str = "hello " + i + " world";
            mList.add(str);
        }
//        mListViewActivityLv1.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);
//        mListViewActivityLv1.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
//        mListViewActivityLv1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        mListViewAdapter = new ListViewAdapter(this, mList);
        mListViewActivityLv1.setAdapter(mListViewAdapter);
        mListViewActivityLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("===MockingJay===", "position:" + position);
            }
        });
    }

    @OnClick(R.id.listViewActivity_tv1)
    public void onViewClicked() {
        mList.add("new item");
        mListViewAdapter.setList(mList);
    }

}
