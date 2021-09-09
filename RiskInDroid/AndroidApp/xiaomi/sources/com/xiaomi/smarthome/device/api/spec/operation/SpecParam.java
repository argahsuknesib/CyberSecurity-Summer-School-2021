package com.xiaomi.smarthome.device.api.spec.operation;

public class SpecParam {
    private int cardType;
    private String did;
    private final int miid;
    private int resultCode;
    private int siid;

    @Deprecated
    public SpecParam(String str, int i) {
        this(str, 0, i);
    }

    public SpecParam(String str, int i, int i2) {
        this.resultCode = -1;
        this.did = str;
        this.miid = i;
        this.siid = i2;
    }

    public SpecParam(String str, int i, int i2, int i3) {
        this.resultCode = -1;
        this.did = str;
        this.miid = i;
        this.siid = i2;
        this.cardType = i3;
    }

    public int getMiid() {
        return this.miid;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public int getSiid() {
        return this.siid;
    }

    public void setSiid(int i) {
        this.siid = i;
    }

    public int getCardType() {
        return this.cardType;
    }
}
