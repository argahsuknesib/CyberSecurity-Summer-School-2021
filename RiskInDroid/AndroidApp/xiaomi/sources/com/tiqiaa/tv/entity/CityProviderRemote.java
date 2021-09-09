package com.tiqiaa.tv.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;
import java.io.Serializable;

public class CityProviderRemote implements IJsonable, Serializable {
    private static final long serialVersionUID = 5224318027080375776L;
    @bdk(O000000o = "id")
    String remote_id;
    @bdk(O000000o = "name")
    String remote_name;
    @bdk(O000000o = "times")
    int times;

    public String getRemote_id() {
        return this.remote_id;
    }

    public void setRemote_id(String str) {
        this.remote_id = str;
    }

    public String getRemote_name() {
        return this.remote_name;
    }

    public void setRemote_name(String str) {
        this.remote_name = str;
    }

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int i) {
        this.times = i;
    }
}
