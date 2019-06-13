package com.kang.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.kang.demo.R;
import com.kang.demo.adapter.ListViewAdapter;
import com.kang.demo.adapter.ListViewSwipeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewSwipeActivity extends AppCompatActivity {

    @BindView(R.id.listViewSwipeActivity_lv)
    ListView mListViewSwipeActivityLv;


    private ListViewSwipeAdapter mListViewSwipeAdapter;
    private List<String> mList = new ArrayList<>();

    public static void toListViewSwipeActivity(Context context){
        Intent intent = new Intent(context,ListViewSwipeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_swipe);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        for(int i = 0;i < 40;i ++){
            String str = "第" + i + "个";
            mList.add(str);
        }
        mListViewSwipeAdapter = new ListViewSwipeAdapter(this,mList);
        mListViewSwipeActivityLv.setAdapter(mListViewSwipeAdapter);

    }



}
