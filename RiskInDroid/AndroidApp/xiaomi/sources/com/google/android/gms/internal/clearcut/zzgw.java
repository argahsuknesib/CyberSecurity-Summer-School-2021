package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.util.List;

public final class zzgw {

    public static final class zza extends zzcg<zza, C0030zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        /* access modifiers changed from: private */
        public static final zza zzbir = new zza();
        private zzcn<zzb> zzbiq = zzbb();

        /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zza  reason: collision with other inner class name */
        public static final class C0030zza extends zzcg.zza<zza, C0030zza> implements zzdq {
            private C0030zza() {
                super(zza.zzbir);
            }

            /* synthetic */ C0030zza(zzgx zzgx) {
                this();
            }
        }

        public static final class zzb extends zzcg<zzb, C0031zza> implements zzdq {
            private static volatile zzdz<zzb> zzbg;
            /* access modifiers changed from: private */
            public static final zzb zzbiv = new zzb();
            private int zzbb;
            private String zzbis = "";
            private long zzbit;
            private long zzbiu;
            private int zzya;

            /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C0031zza extends zzcg.zza<zzb, C0031zza> implements zzdq {
                private C0031zza() {
                    super(zzb.zzbiv);
                }

                /* synthetic */ C0031zza(zzgx zzgx) {
                    this();
                }

                public final C0031zza zzn(String str) {
                    zzbf();
                    ((zzb) this.zzjt).zzm(str);
                    return this;
                }

                public final C0031zza zzr(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzp(j);
                    return this;
                }

                public final C0031zza zzs(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzq(j);
                    return this;
                }
            }

            static {
                zzcg.zza(zzb.class, zzbiv);
            }

            private zzb() {
            }

            public static C0031zza zzfz() {
                return (C0031zza) ((zzcg.zza) zzbiv.zza(zzcg.zzg.zzkh, (Object) null, (Object) null));
            }

            /* access modifiers changed from: private */
            public final void zzm(String str) {
                if (str != null) {
                    this.zzbb |= 2;
                    this.zzbis = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzp(long j) {
                this.zzbb |= 4;
                this.zzbit = j;
            }

            /* access modifiers changed from: private */
            public final void zzq(long j) {
                this.zzbb |= 8;
                this.zzbiu = j;
            }

            public final int getEventCode() {
                return this.zzya;
            }

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>, com.google.android.gms.internal.clearcut.zzcg$zzb] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzdz<zzb> zzdz;
                switch (zzgx.zzba[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0031zza(null);
                    case 3:
                        return zza(zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                    case 4:
                        return zzbiv;
                    case 5:
                        zzdz<zzb> zzdz2 = zzbg;
                        zzdz<zzb> zzdz3 = zzdz2;
                        if (zzdz2 == null) {
                            synchronized (zzb.class) {
                                zzdz<zzb> zzdz4 = zzbg;
                                zzdz = zzdz4;
                                if (zzdz4 == null) {
                                    ? zzb = new zzcg.zzb(zzbiv);
                                    zzbg = zzb;
                                    zzdz = zzb;
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

            public final boolean zzfv() {
                return (this.zzbb & 1) == 1;
            }

            public final String zzfw() {
                return this.zzbis;
            }

            public final long zzfx() {
                return this.zzbit;
            }

            public final long zzfy() {
                return this.zzbiu;
            }
        }

        static {
            zzcg.zza(zza.class, zzbir);
        }

        private zza() {
        }

        public static zza zzft() {
            return zzbir;
        }

        public static zza zzi(byte[] bArr) throws zzco {
            return (zza) zzcg.zzb(zzbir, bArr);
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzdz<zza> zzdz;
            switch (zzgx.zzba[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0030zza(null);
                case 3:
                    return zza(zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", zzb.class});
                case 4:
                    return zzbir;
                case 5:
                    zzdz<zza> zzdz2 = zzbg;
                    zzdz<zza> zzdz3 = zzdz2;
                    if (zzdz2 == null) {
                        synchronized (zza.class) {
                            zzdz<zza> zzdz4 = zzbg;
                            zzdz = zzdz4;
                            if (zzdz4 == null) {
                                ? zzb2 = new zzcg.zzb(zzbir);
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

        public final List<zzb> zzfs() {
            return this.zzbiq;
        }
    }
}
