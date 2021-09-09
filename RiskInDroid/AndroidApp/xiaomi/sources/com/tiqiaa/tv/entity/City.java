package com.tiqiaa.tv.entity;

import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;
import java.util.List;

@bpa(O000000o = "tb_city")
public class City implements IJsonable {
    int city_id;
    String city_name;
    @boy
    int id;
    List<TvProvider> providers;
    int province_id;
    String py;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getCity_id() {
        return this.city_id;
    }

    public void setCity_id(int i) {
        this.city_id = i;
    }

    public String getCity_name() {
        return this.city_name;
    }

    public void setCity_name(String str) {
        this.city_name = str;
    }

    public int getProvince_id() {
        return this.province_id;
    }

    public void setProvince_id(int i) {
        this.province_id = i;
    }

    public List<TvProvider> getProviders() {
        return this.providers;
    }

    public void setProviders(List<TvProvider> list) {
        this.providers = list;
    }

    public String getPy() {
        return this.py;
    }

    public void setPy(String str) {
        this.py = str;
    }
}
