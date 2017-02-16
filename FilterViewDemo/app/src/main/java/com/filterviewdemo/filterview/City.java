package com.filterviewdemo.filterview;

import java.util.ArrayList;

/**
 * Created by chris on 2017/2/16.
 */
public class City {

    private String cityName;

    private String cityId;

    private ArrayList<County> countyList;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public ArrayList<County> getCountyList() {
        return countyList;
    }

    public void setCountyList(ArrayList<County> countyList) {
        this.countyList = countyList;
    }
}
