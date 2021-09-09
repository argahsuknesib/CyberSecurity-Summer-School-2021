package com.hzy.tvmao.ir.ac;

import com.hzy.tvmao.utils.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ACTimeKey implements Serializable {
    private static final long serialVersionUID = 1;
    private int curSetTime;
    private int fid;
    private int timeDisplayValue;
    private List<Integer> timeRangeList = new ArrayList();
    private long timeingEndTime;

    public int increaseTime() {
        int indexOf = this.timeRangeList.indexOf(Integer.valueOf(this.timeDisplayValue)) + 1;
        List<Integer> list = this.timeRangeList;
        if (indexOf >= list.size()) {
            indexOf = 0;
        }
        this.timeDisplayValue = list.get(indexOf).intValue();
        return this.timeDisplayValue;
    }

    public int decreaseTime() {
        int indexOf = this.timeRangeList.indexOf(Integer.valueOf(this.timeDisplayValue)) - 1;
        List<Integer> list = this.timeRangeList;
        if (indexOf < 0) {
            indexOf = list.size() - 1;
        }
        this.timeDisplayValue = list.get(indexOf).intValue();
        return this.timeDisplayValue;
    }

    public void addTimeing() {
        setCurSetTime(getTimeDisplayValue());
        this.timeingEndTime = new Date(d.a() + ((long) (this.curSetTime * 60 * 1000))).getTime();
    }

    public void cancleTimeing() {
        setCurSetTime(0);
        this.timeingEndTime = 0;
        if (this.timeRangeList.size() > 0) {
            this.timeDisplayValue = this.timeRangeList.get(0).intValue();
        } else {
            this.timeDisplayValue = 0;
        }
    }

    public int cutTimeing() {
        if (!timeIsHaveRegular()) {
            return this.curSetTime;
        }
        int a2 = (int) ((this.timeingEndTime - d.a()) / 60000);
        int indexOf = this.timeRangeList.indexOf(Integer.valueOf(this.curSetTime));
        if (indexOf == -1) {
            cancleTimeing();
            return this.curSetTime;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 > indexOf) {
                break;
            } else if (a2 <= this.timeRangeList.get(i2).intValue()) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        return this.timeRangeList.get(i).intValue();
    }

    public int getTimeDisplayValue() {
        return this.timeDisplayValue;
    }

    public void setTimeDisplayValue(int i) {
        this.timeDisplayValue = i;
    }

    public int getFid() {
        return this.fid;
    }

    public void setFid(int i) {
        this.fid = i;
    }

    public List<Integer> getTimeRangeList() {
        return this.timeRangeList;
    }

    public void setTimeRangeList(List<Integer> list) {
        this.timeRangeList = list;
    }

    public int getCurSetTime() {
        return this.curSetTime;
    }

    public void setCurSetTime(int i) {
        this.curSetTime = i;
    }

    public boolean timeIsHaveRegular() {
        return this.curSetTime != 0 && this.timeingEndTime > d.a();
    }

    public void timingCheck() {
        if (this.timeingEndTime <= d.a()) {
            cancleTimeing();
        }
    }

    public long getTimeingEndTime() {
        return this.timeingEndTime;
    }

    public void setTimeingEndTime(long j) {
        this.timeingEndTime = j;
    }
}
