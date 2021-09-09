package com.xiaomi.smarthome.nfctag.idmimpl;

import _m_j.hig;
import _m_j.hte;
import android.content.Context;
import com.xiaomi.idm.tap.dispatcher.impl.AbstractActionExecutor;

public class UnsupportExecutor extends AbstractActionExecutor {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f10384O000000o;

    public UnsupportExecutor(Context context) {
        this.f10384O000000o = context;
    }

    public boolean execute() {
        if (hig.O00000o()) {
            hte.O000000o(this.f10384O000000o, "is old miui");
        }
        if (hig.O00000o0()) {
            return false;
        }
        hte.O000000o(this.f10384O000000o, "no miconnect");
        return false;
    }
}
