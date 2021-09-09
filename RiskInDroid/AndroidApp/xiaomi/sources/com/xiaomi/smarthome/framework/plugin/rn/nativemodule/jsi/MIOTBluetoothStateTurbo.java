package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.jsi;

import _m_j.fyc;
import _m_j.fyg;

public class MIOTBluetoothStateTurbo {
    public native void installBinding(long j);

    public int getBleState(String str) {
        int O000000o2 = fyg.O000000o.f17408O000000o.O000000o(str);
        fyc.O000000o("MIOTBluetoothStateTurbo", "getBleState:".concat(String.valueOf(O000000o2)));
        return O000000o2;
    }

    public boolean getOTAState(String str) {
        boolean O00000Oo = fyg.O000000o.f17408O000000o.O00000Oo(str);
        fyc.O000000o("MIOTBluetoothStateTurbo", "getOTAState:".concat(String.valueOf(O00000Oo)));
        return O00000Oo;
    }

    public boolean ifUseNewBleState() {
        boolean O000000o2 = fyg.O000000o.f17408O000000o.O000000o();
        fyc.O000000o("MIOTBluetoothStateTurbo", "ifUseNewBleState:".concat(String.valueOf(O000000o2)));
        return O000000o2;
    }
}
