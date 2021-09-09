package com.google.android.gms.internal.clearcut;

import android.net.Uri;

public final class zzao {
    /* access modifiers changed from: private */
    public final String zzef;
    /* access modifiers changed from: private */
    public final Uri zzeg;
    /* access modifiers changed from: private */
    public final String zzeh;
    /* access modifiers changed from: private */
    public final String zzei;
    /* access modifiers changed from: private */
    public final boolean zzej;
    /* access modifiers changed from: private */
    public final boolean zzek;

    public zzao(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private zzao(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.zzef = str;
        this.zzeg = uri;
        this.zzeh = str2;
        this.zzei = str3;
        this.zzej = z;
        this.zzek = z2;
    }

    public final <T> zzae<T> zza(String str, T t, zzan<T> zzan) {
        return zzae.zza(this, str, t, zzan);
    }

    public final zzae<String> zza(String str, String str2) {
        return zzae.zza(this, str, (String) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzae.zzb(com.google.android.gms.internal.clearcut.zzao, java.lang.String, boolean):com.google.android.gms.internal.clearcut.zzae
     arg types: [com.google.android.gms.internal.clearcut.zzao, java.lang.String, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzae.zzb(com.google.android.gms.internal.clearcut.zzao, java.lang.String, java.lang.String):com.google.android.gms.internal.clearcut.zzae
      com.google.android.gms.internal.clearcut.zzae.zzb(com.google.android.gms.internal.clearcut.zzao, java.lang.String, boolean):com.google.android.gms.internal.clearcut.zzae */
    public final zzae<Boolean> zzc(String str, boolean z) {
        return zzae.zza(this, str, false);
    }

    public final zzao zzc(String str) {
        boolean z = this.zzej;
        if (!z) {
            return new zzao(this.zzef, this.zzeg, str, this.zzei, z, this.zzek);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzao zzd(String str) {
        return new zzao(this.zzef, this.zzeg, this.zzeh, str, this.zzej, this.zzek);
    }
}
