package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

public final class zzgt {

    public static final class zza extends zzcg<zza, C0029zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        /* access modifiers changed from: private */
        public static final zza zzbil = new zza();

        /* renamed from: com.google.android.gms.internal.clearcut.zzgt$zza$zza  reason: collision with other inner class name */
        public static final class C0029zza extends zzcg.zza<zza, C0029zza> implements zzdq {
            private C0029zza() {
                super(zza.zzbil);
            }

            /* synthetic */ C0029zza(zzgu zzgu) {
                this();
            }
        }

        public enum zzb implements zzcj {
            NO_RESTRICTION(0),
            SIDEWINDER_DEVICE(1),
            LATCHSKY_DEVICE(2);
            
            private static final zzck<zzb> zzbq = new zzgv();
            private final int value;

            private zzb(int i) {
                this.value = i;
            }

            public static zzb zzbe(int i) {
                if (i == 0) {
                    return NO_RESTRICTION;
                }
                if (i == 1) {
                    return SIDEWINDER_DEVICE;
                }
                if (i != 2) {
                    return null;
                }
                return LATCHSKY_DEVICE;
            }

            public static zzck<zzb> zzd() {
                return zzbq;
            }

            public final int zzc() {
                return this.value;
            }
        }

        static {
            zzcg.zza(zza.class, zzbil);
        }

        private zza() {
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgt$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzdz<zza> zzdz;
            switch (zzgu.zzba[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0029zza(null);
                case 3:
                    return zza(zzbil, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbil;
                case 5:
                    zzdz<zza> zzdz2 = zzbg;
                    zzdz<zza> zzdz3 = zzdz2;
                    if (zzdz2 == null) {
                        synchronized (zza.class) {
                            zzdz<zza> zzdz4 = zzbg;
                            zzdz = zzdz4;
                            if (zzdz4 == null) {
                                ? zzb2 = new zzcg.zzb(zzbil);
                                zzbg = zzb2;
                                zzdz = zzb2;
                            }
                        }
                        zzdz3 = zzdz;
                    }
                    return zzdz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
