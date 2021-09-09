package com.kookong.sdk.bean;

import java.util.List;

public class ManualMatchLineupData {
    private String lid;
    private List<Channel> list;
    private String result;
    private int resultCode;

    public String getLid() {
        return this.lid;
    }

    public void setLid(String str) {
        this.lid = str;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public List<Channel> getList() {
        return this.list;
    }

    public void setList(List<Channel> list2) {
        this.list = list2;
    }
}
