package com.tiqiaa.tv.entity;

import _m_j.bdk;
import _m_j.box;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;

@bpa(O000000o = "tb_tvshowimg")
public class TvShowImg implements IJsonable {
    @box
    @bdk(O000000o = "id")
    int id;
    @bdk(O000000o = "pictype")
    int pictype;
    @bdk(O000000o = "tvshow_id")
    int tvshow_id;
    @bdk(O000000o = "url")
    String url;
    @bdk(O000000o = "url_small")
    String url_small;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getTvshow_id() {
        return this.tvshow_id;
    }

    public void setTvshow_id(int i) {
        this.tvshow_id = i;
    }

    public String getUrl() {
        if (this.url == null) {
            this.url = "";
        }
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl_small() {
        if (this.url_small == null) {
            this.url_small = "";
        }
        return this.url_small;
    }

    public void setUrl_small(String str) {
        this.url_small = str;
    }

    public int getPictype() {
        return this.pictype;
    }

    public void setPictype(int i) {
        this.pictype = i;
    }
}
