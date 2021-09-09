package com.tiqiaa.tv.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;

public class TvShowPreview implements IJsonable {
    @bdk(O000000o = "id")
    int id;
    @bdk(O000000o = "js")
    int js;
    @bdk(O000000o = "preview")
    String preview;
    @bdk(O000000o = "preview_name")
    String preview_name;
    @bdk(O000000o = "tvshow_id")
    int tvshow_id;

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

    public int getJs() {
        return this.js;
    }

    public void setJs(int i) {
        this.js = i;
    }

    public String getPreview_name() {
        if (this.preview_name == null) {
            this.preview_name = "";
        }
        return this.preview_name;
    }

    public void setPreview_name(String str) {
        this.preview_name = str;
    }

    public String getPreview() {
        if (this.preview == null) {
            this.preview = "";
        }
        return this.preview;
    }

    public void setPreview(String str) {
        this.preview = str;
    }
}
