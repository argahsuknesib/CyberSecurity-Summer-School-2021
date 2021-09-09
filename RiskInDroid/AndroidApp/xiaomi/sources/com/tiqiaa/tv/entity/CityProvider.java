package com.tiqiaa.tv.entity;

import _m_j.box;
import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;

@bpa(O000000o = "tb_city_provider")
public class CityProvider implements IJsonable {
    int city_id;
    @boy
    @box
    int id;
    int provider_id;

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

    public int getProvider_id() {
        return this.provider_id;
    }

    public void setProvider_id(int i) {
        this.provider_id = i;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
