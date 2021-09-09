package com.tiqiaa.tv.entity;

import _m_j.bdk;
import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;
import com.tiqiaa.database.DataBaseManager;
import java.util.Date;

@bpa(O000000o = "tb_tvforennotice")
public class TvForenotice implements IJsonable, Comparable<TvForenotice> {
    Date cacheDate;
    @bdk(O000000o = "channel_id")
    int channel_id;
    @bdk(O000000o = "et")
    Date et;
    @bdk(O000000o = "fid")
    int fid;
    @bdk(O000000o = "fid2")
    int fid2;
    @boy
    @bdk(O000000o = "id")
    int id;
    @bdk(O000000o = "js")
    int js;
    String next_play;
    String playDate;
    @bdk(O000000o = "pn")
    String pn;
    @bdk(O000000o = "pp")
    String pp;
    @bdk(O000000o = "pt")
    Date pt;
    @bdk(O000000o = "tvshow")
    TvShow tvshow;
    @bdk(O000000o = "tvshow_img")
    TvShowImg tvshow_img;
    int type;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getChannel_id() {
        return this.channel_id;
    }

    public void setChannel_id(int i) {
        this.channel_id = i;
    }

    public Date getPt() {
        return this.pt;
    }

    public void setPt(Date date) {
        this.pt = date;
    }

    public Date getEt() {
        return this.et;
    }

    public void setEt(Date date) {
        this.et = date;
    }

    public String getPn() {
        if (this.pn == null) {
            this.pn = "";
        }
        return this.pn;
    }

    public void setPn(String str) {
        this.pn = str;
    }

    public int getFid() {
        return this.fid;
    }

    public void setFid(int i) {
        this.fid = i;
    }

    public int getFid2() {
        return this.fid2;
    }

    public void setFid2(int i) {
        this.fid2 = i;
    }

    public int getJs() {
        return this.js;
    }

    public void setJs(int i) {
        this.js = i;
    }

    public TvShowImg getTvshow_img() {
        if (this.tvshow_img == null) {
            this.tvshow_img = DataBaseManager.getInstance().getTvShowImgByshowId(getFid2() <= 0 ? getFid() : getFid2());
        }
        return this.tvshow_img;
    }

    public void setTvshow_img(TvShowImg tvShowImg) {
        this.tvshow_img = tvShowImg;
    }

    public String getPp() {
        return this.pp;
    }

    public void setPp(String str) {
        this.pp = str;
    }

    public String getNext_play() {
        return this.next_play;
    }

    public void setNext_play(String str) {
        this.next_play = str;
    }

    public TvShow getTvshow() {
        return this.tvshow;
    }

    public void setTvshow(TvShow tvShow) {
        this.tvshow = tvShow;
    }

    public Date getCacheDate() {
        return this.cacheDate;
    }

    public void setCacheDate(Date date) {
        this.cacheDate = date;
    }

    public String getPlayDate() {
        return this.playDate;
    }

    public void setPlayDate(String str) {
        this.playDate = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TvForenotice)) {
            return false;
        }
        TvForenotice tvForenotice = (TvForenotice) obj;
        if (this.id == tvForenotice.getId()) {
            return true;
        }
        if (this.channel_id == tvForenotice.getChannel_id() && this.pt.getTime() == tvForenotice.getPt().getTime()) {
            return true;
        }
        return false;
    }

    public int compareTo(TvForenotice tvForenotice) {
        Date date;
        if (tvForenotice.getPt() == null || (date = this.pt) == null) {
            return 0;
        }
        return (int) (date.getTime() - tvForenotice.getPt().getTime());
    }
}
