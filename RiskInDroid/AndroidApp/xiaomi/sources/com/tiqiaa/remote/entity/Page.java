package com.tiqiaa.remote.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;

public class Page implements IJsonable, Cloneable {
    @bdk(O000000o = "appliance_type")
    int appliance_type;
    @bdk(O000000o = "brand_id")
    long brand_id;
    @bdk(O000000o = "keyword")
    String keyword;
    @bdk(O000000o = "lang")
    int lang;
    @bdk(O000000o = "page")
    int page;

    public long getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(long j) {
        this.brand_id = j;
    }

    public int getAppliance_type() {
        return this.appliance_type;
    }

    public void setAppliance_type(int i) {
        this.appliance_type = i;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public int getLang() {
        return this.lang;
    }

    public void setLang(int i) {
        this.lang = i;
    }

    public Object clone() throws CloneNotSupportedException {
        Page page2 = new Page();
        page2.setAppliance_type(this.appliance_type);
        page2.setBrand_id(this.brand_id);
        page2.setKeyword(this.keyword);
        page2.setLang(this.lang);
        page2.setPage(this.page);
        return page2;
    }
}
