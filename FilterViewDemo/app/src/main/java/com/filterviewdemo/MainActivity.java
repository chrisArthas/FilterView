package com.filterviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.filterviewdemo.filterview.City;
import com.filterviewdemo.filterview.County;
import com.filterviewdemo.filterview.FilterCallBackInterface;
import com.filterviewdemo.filterview.FilterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FilterCallBackInterface{

    private FilterView filterView;

    private ArrayList<City> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterView = (FilterView)findViewById(R.id.filter_view);

        initData();

        filterView.setData(dataList);
        filterView.setCallBackInterface(this);
        filterView.setFSelectPosition(0);
    }

    /**
     * 构造假数据
     *  实际情况下 可根据接口返回的数据类型来解析
     *
     */
    public void initData()
    {
        dataList = new ArrayList<>();
        for(int i = 0; i < 13;i ++)
        {
            City NJ = new City();
            NJ.setCityId((i+1)+"");
            NJ.setCityName(i+"南京");
            ArrayList<County> NJCounties = new ArrayList<>();
            County pukou = new County();
            pukou.setCountyId(i+"01");
            pukou.setCountyName(i+"浦口区");
            NJCounties.add(pukou);

            County jianye = new County();
            jianye.setCountyId(i+"02");
            jianye.setCountyName(i+"建邺区");
            NJCounties.add(jianye);

            County qinhuai = new County();
            qinhuai.setCountyId(i+"03");
            qinhuai.setCountyName(i+"秦淮");
            NJCounties.add(qinhuai);

            County gulou = new County();
            gulou.setCountyId(i+"04");
            gulou.setCountyName(i+"鼓楼区");
            NJCounties.add(gulou);

            County jiangnig = new County();
            jiangnig.setCountyId(i+"05");
            jiangnig.setCountyName(i+"江宁区");
            NJCounties.add(jiangnig);

            NJ.setCountyList(NJCounties);


            dataList.add(NJ);
        }

    }


    @Override
    public void onItemClick(int fPosition, int position) {
        Toast.makeText(this,"Click " + fPosition + " , "+position+"  区县："+dataList.get(fPosition).getCountyList().get(position).getCountyId(),Toast.LENGTH_LONG).show();
    }
}
