package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs;

class IORejectionException extends Exception {
    private String code;

    public IORejectionException(String str, String str2) {
        super(str2);
        this.code = str;
    }

    public String getCode() {
        return this.code;
    }
}
