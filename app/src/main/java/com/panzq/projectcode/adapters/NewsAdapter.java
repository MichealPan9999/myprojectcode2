package com.panzq.projectcode.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.panzq.projectcode.R;
import com.panzq.projectcode.datas.Data;

import java.util.List;

/**
 * Created by panzq on 2016/12/23.
 */

public class NewsAdapter extends BaseAdapter {
    private List<Data> mData;
    private Context mContext;

    public NewsAdapter(List<Data> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder = null;
        if (viewHolder == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.news_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txt_item_title = (TextView)convertView.findViewById(R.id.txt_item_title);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_item_title.setText(mData.get(position).getNew_title());
        return convertView;
    }
    private class ViewHolder
    {
        TextView txt_item_title;
    }
}
