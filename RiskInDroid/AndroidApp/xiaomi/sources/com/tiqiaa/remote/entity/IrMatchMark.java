package com.tiqiaa.remote.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;

public class IrMatchMark implements IJsonable {
    @bdk(O000000o = "key_type")
    int key_type;
    @bdk(O000000o = "mark")
    String mark;
    @bdk(O000000o = "remote_id")
    String remote_id;

    public String getRemote_id() {
        return this.remote_id;
    }

    public void setRemote_id(String str) {
        this.remote_id = str;
    }

    public int getKey_type() {
        return this.key_type;
    }

    public void setKey_type(int i) {
        this.key_type = i;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String str) {
        this.mark = str;
    }
}
