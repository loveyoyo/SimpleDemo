package com.kang.demo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kang.demo.R;

import java.util.List;

/**
 * Created by MockingJay on 2019/6/12;
 * Description:
 */

public class ListViewSwipeAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    public ListViewSwipeAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(null == convertView){
            convertView = mLayoutInflater.inflate(R.layout.item_lv_swipe_layout,parent,false);
            holder = new ViewHolder();
            holder.top_tv = convertView.findViewById(R.id.tv_top);
            holder.delete_tv = convertView.findViewById(R.id.tv_delete);
            holder.content_tv = convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.content_tv.setText(mList.get(position));
        holder.top_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("===MockingJay===","top..........");
            }
        });
        holder.delete_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("===MockingJay===","delete..........");
            }
        });
        return convertView;
    }

    class ViewHolder{
        private TextView top_tv;
        private TextView delete_tv;
        private TextView content_tv;
    }
}
















