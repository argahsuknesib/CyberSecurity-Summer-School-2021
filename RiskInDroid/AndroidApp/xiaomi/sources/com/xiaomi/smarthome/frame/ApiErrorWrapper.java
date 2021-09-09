package com.xiaomi.smarthome.frame;

import _m_j.fso;

public class ApiErrorWrapper extends Exception {
    public int code = -1;
    public String detail = "";
    public String mExtra;

    public ApiErrorWrapper(fso fso) {
        super(fso.O00000Oo);
        this.detail = fso.O00000Oo;
        this.code = fso.f17063O000000o;
        this.mExtra = fso.O00000o0;
    }
}
