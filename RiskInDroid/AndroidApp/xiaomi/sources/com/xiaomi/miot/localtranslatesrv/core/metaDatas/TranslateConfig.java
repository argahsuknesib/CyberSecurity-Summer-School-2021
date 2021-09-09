package com.xiaomi.miot.localtranslatesrv.core.metaDatas;

public class TranslateConfig {
    private String AdditionalMethod;
    private String MetaData;
    private String SrcId;
    private String SrcKey;
    private int SrcType;
    private String SrcValueTranslateExpression;
    private int Status;
    private String TargetId;
    private String TargetKey;
    private int TargetType;
    private String TargetValueTranslateExpression;
    private int ValueTranslateType;
    private String additionalGetMethod;
    private String setMethodExpression;
    private String subcribePropName;

    public int getSrcType() {
        return this.SrcType;
    }

    public String getSrcId() {
        return this.SrcId;
    }

    public String getSrcKey() {
        return this.SrcKey;
    }

    public int getTargetType() {
        return this.TargetType;
    }

    public String getTargetId() {
        return this.TargetId;
    }

    public String getTargetKey() {
        return this.TargetKey;
    }

    public int getValueTranslateType() {
        return this.ValueTranslateType;
    }

    public String getSrcValueTranslateExpression() {
        return this.SrcValueTranslateExpression;
    }

    public String getTargetValueTranslateExpression() {
        return this.TargetValueTranslateExpression;
    }

    public String getMetaData() {
        return this.MetaData;
    }

    public int getStatus() {
        return this.Status;
    }

    public String getAdditionalMethod() {
        return this.AdditionalMethod;
    }

    public void setSrcType(int i) {
        this.SrcType = i;
    }

    public void setSrcId(String str) {
        this.SrcId = str;
    }

    public void setSrcKey(String str) {
        this.SrcKey = str;
    }

    public void setTargetType(int i) {
        this.TargetType = i;
    }

    public void setTargetId(String str) {
        this.TargetId = str;
    }

    public void setTargetKey(String str) {
        this.TargetKey = str;
    }

    public void setValueTranslateType(int i) {
        this.ValueTranslateType = i;
    }

    public void setSrcValueTranslateExpression(String str) {
        this.SrcValueTranslateExpression = str;
    }

    public void setTargetValueTranslateExpression(String str) {
        this.TargetValueTranslateExpression = str;
    }

    public void setMetaData(String str) {
        this.MetaData = str;
    }

    public void setStatus(int i) {
        this.Status = i;
    }

    public void setAdditionalMethod(String str) {
        this.AdditionalMethod = str;
    }

    public String getSetMethodExpression() {
        return this.setMethodExpression;
    }

    public void setSetMethodExpression(String str) {
        this.setMethodExpression = str;
    }

    public String getAdditionalGetMethod() {
        return this.additionalGetMethod;
    }

    public void setAdditionalGetMethod(String str) {
        this.additionalGetMethod = str;
    }

    public String getSubcribePropName() {
        return this.subcribePropName;
    }

    public void setSubcribePropName(String str) {
        this.subcribePropName = str;
    }
}
