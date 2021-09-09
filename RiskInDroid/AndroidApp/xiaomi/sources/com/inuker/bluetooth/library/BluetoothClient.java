package com.inuker.bluetooth.library;

import _m_j.bii;
import _m_j.bil;
import _m_j.bky;
import android.content.Context;

public class BluetoothClient implements bil {

    /* renamed from: O000000o  reason: collision with root package name */
    private bil f4484O000000o;

    public BluetoothClient(Context context) {
        if (context != null) {
            this.f4484O000000o = bii.O000000o(context);
            return;
        }
        throw new NullPointerException("Context null");
    }

    public final void O000000o() {
        bky.O00000Oo(String.format("stopSearch", new Object[0]));
        this.f4484O000000o.O000000o();
    }
}
