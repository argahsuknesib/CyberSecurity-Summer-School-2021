package com.xiaomi.youpin.common.base;

import com.xiaomi.youpin.log.LogUtils;

public class ExceptionError extends YouPinError {
    public Exception e;

    public ExceptionError(int i, String str) {
        super(i, str);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.e == null) {
            str = "";
        } else {
            str = "Exception " + this.e.getMessage();
        }
        sb.append(str);
        return sb.toString();
    }

    public String toStringWithTrace() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.e == null) {
            str = "";
        } else {
            str = "Exception " + this.e.getMessage() + " stackTrace " + LogUtils.getStackTraceString(this.e);
        }
        sb.append(str);
        return sb.toString();
    }
}
