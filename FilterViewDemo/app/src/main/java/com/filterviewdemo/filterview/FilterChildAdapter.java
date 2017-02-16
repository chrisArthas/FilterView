package com.filterviewdemo.filterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.filterviewdemo.R;

import java.util.ArrayList;

/**
 * Created by chris on 2017/2/16.
 */
public class FilterChildAdapter extends BaseAdapter {

    private String TAG = "FilterChildAdapter";

    private Context context;

    private ArrayList<County> countyList;

    public FilterChildAdapter(Context context)
    {
        super();
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return countyList.get(position);
    }

    @Override
    public int getCount() {
        if(countyList != null)
        {
            return countyList.size();
        }else
        {
            return 0;
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(convertView == null)
        {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.filter_child_item, null);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.back = (RelativeLayout)convertView.findViewById(R.id.back_lay);
            convertView.setTag(holder);
        }else
        {
            holder = (Holder) convertView.getTag();
        }

        holder.name.setText(countyList.get(position).getCountyName());

        return convertView;
    }
    public void setData(ArrayList<County> list)
    {
        countyList = list;
    }

    private class Holder{
        private TextView name;

        private RelativeLayout back;
    }
}
