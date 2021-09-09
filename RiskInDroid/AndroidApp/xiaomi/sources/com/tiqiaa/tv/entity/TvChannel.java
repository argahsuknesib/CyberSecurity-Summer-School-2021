package com.tiqiaa.tv.entity;

import _m_j.bdk;
import _m_j.box;
import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;

@bpa(O000000o = "tb_tvchannel")
public class TvChannel implements IJsonable {
    @bdk(O000000o = "country_codes")
    private String country_codes;
    @bdk(O000000o = "en_name")
    private String en_name;
    @bdk(O000000o = "enable")
    private boolean enable;
    @boy
    @box
    @bdk(O000000o = "id")
    int id;
    @bdk(O000000o = "logo_url")
    private String logo_url;
    @bdk(O000000o = "name")
    private String name;
    @bdk(O000000o = "other_name")
    private String other_name;
    @bdk(O000000o = "priority")
    private int priority;
    @bdk(O000000o = "sort_key")
    private String sort_key;
    @bdk(O000000o = "tv_id")
    private int tv_id;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        if (this.name == null) {
            this.name = "";
        }
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEn_name() {
        if (this.en_name == null) {
            this.en_name = "";
        }
        return this.en_name;
    }

    public void setEn_name(String str) {
        this.en_name = str;
    }

    public String getOther_name() {
        if (this.other_name == null) {
            this.other_name = "";
        }
        return this.other_name;
    }

    public void setOther_name(String str) {
        this.other_name = str;
    }

    public int getTv_id() {
        return this.tv_id;
    }

    public void setTv_id(int i) {
        this.tv_id = i;
    }

    public String getLogo_url() {
        return this.logo_url;
    }

    public void setLogo_url(String str) {
        this.logo_url = str;
    }

    public String getSort_key() {
        return this.sort_key;
    }

    public void setSort_key(String str) {
        this.sort_key = str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public String getCountry_codes() {
        return this.country_codes;
    }

    public void setCountry_codes(String str) {
        this.country_codes = str;
    }
}
