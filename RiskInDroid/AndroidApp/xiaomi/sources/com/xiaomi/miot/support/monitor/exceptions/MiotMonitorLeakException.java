package com.xiaomi.miot.support.monitor.exceptions;

import android.text.TextUtils;

public class MiotMonitorLeakException extends MiotMonitorBaseException {
    private static final long serialVersionUID = 1;
    private String logInfo;

    public MiotMonitorLeakException(String str) {
        super(str);
        this.logInfo = str;
    }

    public String getLogInfo() {
        return TextUtils.isEmpty(this.logInfo) ? "" : this.logInfo;
    }
}
