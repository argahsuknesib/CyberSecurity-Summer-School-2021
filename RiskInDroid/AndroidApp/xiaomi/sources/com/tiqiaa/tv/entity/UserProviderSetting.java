package com.tiqiaa.tv.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;
import java.util.List;

public class UserProviderSetting implements IJsonable {
    @bdk(O000000o = "city_id")
    int city_id;
    @bdk(O000000o = "imei")
    String imei;
    @bdk(O000000o = "machine_type")
    int machine_type;
    @bdk(O000000o = "nums")
    List<ChannelNum> nums;
    @bdk(O000000o = "provider_id")
    int provider_id;
    @bdk(O000000o = "remote_id")
    String remote_id;
    @bdk(O000000o = "name")
    String remote_name;

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

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public List<ChannelNum> getNums() {
        return this.nums;
    }

    public void setNums(List<ChannelNum> list) {
        this.nums = list;
    }

    public int getMachine_type() {
        return this.machine_type;
    }

    public void setMachine_type(int i) {
        this.machine_type = i;
    }
}
