package com.xiaomi.miot.localtranslatesrv.core.metaDatas;

public class MetaData {
    private String additionalGetMethod;
    private Object parsedExpression;
    private String subscribePropName;

    public synchronized Object getParsedExpression() {
        return this.parsedExpression;
    }

    public synchronized void setParsedExpression(Object obj) {
        this.parsedExpression = obj;
    }

    public String getAdditionalGetMethod() {
        return this.additionalGetMethod;
    }

    public void setAdditionalGetMethod(String str) {
        this.additionalGetMethod = str;
    }

    public String getSubscribePropName() {
        return this.subscribePropName;
    }

    public void setSubscribePropName(String str) {
        this.subscribePropName = str;
    }
}
