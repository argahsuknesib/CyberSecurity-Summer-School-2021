package com.xiaomi.miot.localtranslatesrv.core.metaDatas;

public class OutputTranslateTarget {
    private int SrcType;
    private String TargetKey;
    private String additionalMethod;
    private Object metaData;
    private String targetId;
    private int targetType;
    private Object targetValue;

    public Object getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(Object obj) {
        this.targetValue = obj;
    }

    public int getSrcType() {
        return this.SrcType;
    }

    public String getTargetKey() {
        return this.TargetKey;
    }

    public void setSrcType(int i) {
        this.SrcType = i;
    }

    public void setTargetKey(String str) {
        this.TargetKey = str;
    }

    public void setTargetType(int i) {
        this.targetType = i;
    }

    public int getTargetType() {
        return this.targetType;
    }

    public String getAdditionalMethod() {
        return this.additionalMethod;
    }

    public void setMetaData(Object obj) {
        this.metaData = obj;
    }

    public Object getMetaData() {
        return this.metaData;
    }

    public void setAdditionalMethod(String str) {
        this.additionalMethod = str;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }
}
