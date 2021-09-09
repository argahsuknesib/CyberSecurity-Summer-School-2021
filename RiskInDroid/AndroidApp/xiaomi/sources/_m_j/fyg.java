package _m_j;

import _m_j.fap;
import _m_j.fat;
import com.tencent.mmkv.MMKV;

public final class fyg implements fyh {

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final fyh f17408O000000o = new fyg((byte) 0);
    }

    /* synthetic */ fyg(byte b) {
        this();
    }

    private fyg() {
    }

    public final int O000000o(String str) {
        int O00000Oo = fap.O000000o.f16027O000000o.O000000o(str).O00000Oo();
        gnk.O000000o("[%s] getConnectState = %d", "BleHostObjectImpl", Integer.valueOf(O00000Oo));
        return O00000Oo;
    }

    public final boolean O00000Oo(String str) {
        boolean O00000o0 = fap.O000000o.f16027O000000o.O000000o(str).O00000o0();
        gnk.O000000o("[%s] isOTA =%s", "BleHostObjectImpl", Boolean.valueOf(O00000o0));
        return O00000o0;
    }

    public final boolean O000000o() {
        fat fat = fat.O000000o.f16039O000000o;
        MMKV O000000o2 = MMKV.O000000o("smart.config.cache");
        boolean decodeBool = O000000o2.decodeBool(O000000o2.nativeHandle, "SMART.CONFIG.KEY.USE_HOST_OBJ", false);
        gnk.O000000o("[%s] isABTest =%s", "BleHostObjectImpl", Boolean.valueOf(decodeBool));
        return decodeBool;
    }
}
