package com.facebook.react.common;

public class JavascriptException extends RuntimeException implements HasJavascriptExceptionMetadata {
    private String extraDataAsJson;

    public JavascriptException(String str) {
        super(str);
    }

    public String getExtraDataAsJson() {
        return this.extraDataAsJson;
    }

    public JavascriptException setExtraDataAsJson(String str) {
        this.extraDataAsJson = str;
        return this;
    }
}
