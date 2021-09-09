package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzzi {
    private static volatile boolean zzbrm = false;
    private static final Class<?> zzbrn = zztd();
    static final zzzi zzbro = new zzzi(true);
    private final Map<Object, Object> zzbrp;

    zzzi() {
        this.zzbrp = new HashMap();
    }

    private zzzi(boolean z) {
        this.zzbrp = Collections.emptyMap();
    }

    private static Class<?> zztd() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzzi zzte() {
        return zzzh.zztc();
    }
}
