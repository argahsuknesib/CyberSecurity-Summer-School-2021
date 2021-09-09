package com.tiqiaa.tv.entity;

import _m_j.bdk;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;

@bpa(O000000o = "tb_channel_num")
public class ChannelNum implements IJsonable {
    int cfg_id;
    @bdk(O000000o = "channel_id")
    int channel_id;
    boolean enable;
    int id;
    @bdk(O000000o = "num")
    int num;

    public int getChannel_id() {
        return this.channel_id;
    }

    public void setChannel_id(int i) {
        this.channel_id = i;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }
}
