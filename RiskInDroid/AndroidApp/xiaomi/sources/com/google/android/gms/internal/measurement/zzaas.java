package com.google.android.gms.internal.measurement;

final class zzaas {
    private static final zzaaq zzbto = zzuc();
    private static final zzaaq zzbtp = new zzaar();

    static zzaaq zzua() {
        return zzbto;
    }

    static zzaaq zzub() {
        return zzbtp;
    }

    private static zzaaq zzuc() {
        try {
            return (zzaaq) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
