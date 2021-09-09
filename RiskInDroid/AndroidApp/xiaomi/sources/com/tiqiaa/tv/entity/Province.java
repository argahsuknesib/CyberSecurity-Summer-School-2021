package com.tiqiaa.tv.entity;

import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;
import java.util.List;

@bpa(O000000o = "tb_province")
public class Province implements IJsonable {
    List<City> cities;
    @boy
    int id;
    int province_id;
    String province_name;
    String py;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getProvince_id() {
        return this.province_id;
    }

    public void setProvince_id(int i) {
        this.province_id = i;
    }

    public String getProvince_name() {
        return this.province_name;
    }

    public void setProvince_name(String str) {
        this.province_name = str;
    }

    public List<City> getCities() {
        return this.cities;
    }

    public void setCities(List<City> list) {
        this.cities = list;
    }

    public String getPy() {
        return this.py;
    }

    public void setPy(String str) {
        this.py = str;
    }
}
