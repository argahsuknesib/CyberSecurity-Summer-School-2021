package com.google.android.gms.internal.measurement;

final class zzaai {
    private static final zzaag zzbtg = zztv();
    private static final zzaag zzbth = new zzaah();

    static zzaag zztt() {
        return zzbtg;
    }

    static zzaag zztu() {
        return zzbth;
    }

    private static zzaag zztv() {
        try {
            return (zzaag) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
