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
public class FilterListAdapter extends BaseAdapter{

    private String TAG = "FilterListAdapter";

    private Context context;

    private ArrayList<City> cityList;

    private int selectPosition = 0;


    public FilterListAdapter(Context context)
    {
        super();
        this.context = context;

    }

    public void setData(ArrayList<City> cityList)
    {
        this.cityList = cityList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public City getItem(int position) {
        return cityList.get(position);
    }

    @Override
    public int getCount() {
        if(cityList != null)
        {
            return cityList.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.filter_item_layout, null);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.back = (RelativeLayout)convertView.findViewById(R.id.back_lay);
            convertView.setTag(holder);
        }else
        {
            holder = (Holder) convertView.getTag();
        }

        holder.name.setText(cityList.get(position).getCityName());
        if(position == selectPosition)
        {
            holder.name.setTextColor(context.getResources().getColor(R.color.common_blue));
            holder.back.setBackgroundColor(context.getResources().getColor(R.color.filter_back));
        }else
        {
            holder.name.setTextColor(context.getResources().getColor(R.color.black));
            holder.back.setBackgroundColor(context.getResources().getColor(R.color.white));

        }

        return convertView;
    }

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    private class Holder{
        private TextView name;

        private RelativeLayout back;
    }
}
