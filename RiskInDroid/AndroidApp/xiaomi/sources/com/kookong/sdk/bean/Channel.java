package com.kookong.sdk.bean;

import com.hzy.tvmao.model.legacy.api.data.ManualMatchData;

public class Channel {
    private int category;
    private int cid;
    private String ctryId;
    private String ext;
    private int fee;
    private int hd;
    private String logo;
    private String name;
    private int num;
    public String pulse;
    private int type;

    public int getCid() {
        return this.cid;
    }

    public void setCid(int i) {
        this.cid = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public int getHd() {
        return this.hd;
    }

    public void setHd(int i) {
        this.hd = i;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public int getFee() {
        return this.fee;
    }

    public void setFee(int i) {
        this.fee = i;
    }

    public String getCtryId() {
        return this.ctryId;
    }

    public void setCtryId(String str) {
        this.ctryId = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public static Channel create(ManualMatchData.Ch ch) {
        Channel channel = new Channel();
        channel.cid = ch.cid;
        channel.name = ch.name;
        channel.num = ch.num;
        channel.category = ch.type;
        channel.type = 0;
        channel.ctryId = ch.ctrid;
        channel.hd = ch.hd;
        channel.fee = ch.fee;
        channel.logo = ch.logo;
        channel.pulse = ch.pulse;
        return channel;
    }
}
