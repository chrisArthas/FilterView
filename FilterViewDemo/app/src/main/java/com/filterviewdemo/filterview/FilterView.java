package com.filterviewdemo.filterview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;


import com.filterviewdemo.R;

import java.util.ArrayList;

/**
 * Created by chris on 2017/2/16.
 */
public class FilterView extends RelativeLayout{

    private ListView fListView;

    private ListView cListView;

    private Context context;

    private ArrayList<City> cityList;

    private FilterListAdapter fatherAdapter;

    private FilterChildAdapter childAdapter;

    private FilterCallBackInterface callBackInterface;


    private int fListPosition  = 0;

    public FilterView(Context context)
    {
        super(context);
    }

    public FilterView(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        this.context = context;
        initView();
        initListener();
    }

    private void initView()
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.filter_view_layout, this, true);
        fListView = (ListView) findViewById(R.id.list_father);
        cListView = (ListView) findViewById(R.id.list_child);
        fatherAdapter = new FilterListAdapter(context);
        childAdapter = new FilterChildAdapter(context);
        cListView.setAdapter(childAdapter);
        fListView.setAdapter(fatherAdapter);

    }

    private void initListener()
    {
        fListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fatherAdapter.setSelectPosition(position);
                fListPosition = position;
//                if(position == 0)
//                {
//                    //查询全省
//                    if(callBackInterface != null)
//                    {
//                        callBackInterface.onItemClick(fListPosition,0);
//                    }
//                    cListView.setVisibility(View.INVISIBLE);
//                }else
//                {
                    cListView.setVisibility(View.VISIBLE);
                    childAdapter.setData(fatherAdapter.getItem(position).getCountyList());
                    childAdapter.notifyDataSetChanged();
//                }
                fatherAdapter.notifyDataSetChanged();

            }
        });

        cListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(callBackInterface != null)
                {
                    callBackInterface.onItemClick(fListPosition,position);
                }
            }
        });
    }

    public void setData(ArrayList<City> list)
    {
        cityList = list;

        fatherAdapter.setData(cityList);
        fatherAdapter.notifyDataSetChanged();

    }


    public void setCallBackInterface(FilterCallBackInterface callBackInterface)
    {
        this.callBackInterface = callBackInterface;
    }

    /**
     * 第一列选中位置
     * @param position
     */
    public void setFSelectPosition(int position)
    {
        fListPosition = position;
        if(fatherAdapter != null)
        {
            fatherAdapter.setSelectPosition(position);
        }
        if(cityList != null && cityList.get(fatherAdapter.getSelectPosition()) != null)
        {
            childAdapter.setData(cityList.get(fatherAdapter.getSelectPosition()).getCountyList());

        }
        childAdapter.notifyDataSetChanged();

    }


}
