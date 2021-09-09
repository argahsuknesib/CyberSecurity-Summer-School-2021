package com.xiaomi.mico.api.logger;

import _m_j.fsr;
import _m_j.gsy;

public class AndroidApiLogger implements ApiLogger {
    private String mTag;

    public AndroidApiLogger(String str) {
        this.mTag = str;
    }

    public void v(String str) {
        if (fsr.O0000O0o || fsr.O0000OoO) {
            gsy.O000000o(2, this.mTag, str);
        }
    }

    public void v(String str, Object... objArr) {
        gsy.O000000o(2, this.mTag, String.format(str, objArr));
    }

    public void d(String str) {
        if (fsr.O0000O0o || fsr.O0000OoO) {
            gsy.O000000o(3, this.mTag, str);
        }
    }

    public void d(String str, Object... objArr) {
        if (fsr.O0000O0o || fsr.O0000OoO) {
            gsy.O000000o(3, this.mTag, String.format(str, objArr));
        }
    }

    public void i(String str) {
        if (fsr.O0000O0o || fsr.O0000OoO) {
            gsy.O000000o(4, this.mTag, str);
        }
    }

    public void i(String str, Object... objArr) {
        if (fsr.O0000O0o || fsr.O0000OoO) {
            gsy.O000000o(4, this.mTag, String.format(str, objArr));
        }
    }

    public void w(String str) {
        if (fsr.O0000O0o || fsr.O0000OoO) {
            gsy.O000000o(5, this.mTag, str);
        }
    }

    public void w(String str, Object... objArr) {
        if (fsr.O0000O0o || fsr.O0000OoO) {
            gsy.O000000o(5, this.mTag, String.format(str, objArr));
        }
    }

    public void e(String str) {
        gsy.O000000o(6, this.mTag, str);
    }

    public void e(String str, Object... objArr) {
        gsy.O000000o(6, this.mTag, String.format(str, objArr));
    }
}
