package com.xiaomi.miot.localtranslatesrv.core.metaDatas;

public class InputTranslateSource {
    private String SrcId;
    private String SrcKey;
    private int SrcType;
    private String TargetKey;
    private int TargetType;
    private Object srcValue;

    public Object getSrcValue() {
        return this.srcValue;
    }

    public void setSrcValue(Object obj) {
        this.srcValue = obj;
    }

    public int getSrcType() {
        return this.SrcType;
    }

    public String getSrcId() {
        return this.SrcId;
    }

    public String getSrcKey() {
        return this.SrcKey;
    }

    public String getTargetKey() {
        return this.TargetKey;
    }

    public void setSrcId(String str) {
        this.SrcId = str;
    }

    public void setSrcKey(String str) {
        this.SrcKey = str;
    }

    public void setSrcType(int i) {
        this.SrcType = i;
    }

    public void setTargetKey(String str) {
        this.TargetKey = str;
    }

    public int getTargetType() {
        return this.TargetType;
    }

    public void setTargetType(int i) {
        this.TargetType = i;
    }
}
