package com.tiqiaa.remote.entity;

import _m_j.bdk;
import _m_j.box;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;

@bpa(O000000o = "tb_match_key")
public class MatchKey implements IJsonable, Comparable<MatchKey> {
    @bdk(O000000o = "appliance_type")
    int appliance_type;
    @box
    int id;
    @bdk(O000000o = "key_type")
    int key_type;
    @bdk(O000000o = "seq")
    int seq;

    public int getAppliance_type() {
        return this.appliance_type;
    }

    public void setAppliance_type(int i) {
        this.appliance_type = i;
    }

    public int getKey_type() {
        return this.key_type;
    }

    public void setKey_type(int i) {
        this.key_type = i;
    }

    public int getSeq() {
        return this.seq;
    }

    public void setSeq(int i) {
        this.seq = i;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int compareTo(MatchKey matchKey) {
        return this.seq - matchKey.seq;
    }
}
