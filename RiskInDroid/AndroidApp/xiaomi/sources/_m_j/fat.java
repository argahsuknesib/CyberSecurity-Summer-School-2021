package _m_j;

import com.tencent.mmkv.MMKV;

public final class fat {

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final fat f16039O000000o = new fat((byte) 0);
    }

    /* synthetic */ fat(byte b) {
        this();
    }

    private fat() {
    }

    public static void O000000o(boolean z) {
        MMKV.O000000o("smart.config.cache").O000000o("SMART.CONFIG.KEY.USE_HOST_OBJ", z);
    }

    public static String O000000o(String str) {
        return MMKV.O000000o("smart.config.cache").O00000Oo("SMART.CONFIG.KEY.MCU.VERSION".concat(String.valueOf(str)));
    }
}
