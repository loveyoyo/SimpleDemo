package com.kang.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kang.demo.R;

import java.util.List;

/**
 * Created by MockingJay on 2019/5/28;
 * Description:
 */

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    public ListViewAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setList(List<String> list) {
        mList = list;
        notifyDataSetChanged();
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
        if (null == convertView) {
            convertView = mLayoutInflater.inflate(R.layout.item_listview_layout, parent, false);
            holder = new ViewHolder();
            holder.mTextView = convertView.findViewById(R.id.item_listView_tv1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTextView.setText(mList.get(position));
        return convertView;
    }

    static class ViewHolder {
        private TextView mTextView;
    }

}
