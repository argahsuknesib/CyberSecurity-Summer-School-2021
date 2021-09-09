package com.xiaomi.youpin.login.entity.error;

import com.xiaomi.youpin.login.entity.Error;

public class ExceptionError extends Error {
    public Exception O00000o0;

    public ExceptionError(int i, String str) {
        super(i, str);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.O00000o0 == null) {
            str = "";
        } else {
            str = "Exception " + this.O00000o0.getMessage();
        }
        sb.append(str);
        return sb.toString();
    }
}
