package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.GoogleCertificates;

class zzg {
    private static final zzg zzbk = new zzg(true, null, null);
    private final Throwable cause;
    final boolean zzbl;
    private final String zzbm;

    zzg(boolean z, String str, Throwable th) {
        this.zzbl = z;
        this.zzbm = str;
        this.cause = th;
    }

    static zzg zza(String str, GoogleCertificates.CertData certData, boolean z, boolean z2) {
        return new zzi(str, certData, z, z2);
    }

    static zzg zza(String str, Throwable th) {
        return new zzg(false, str, th);
    }

    static zzg zze(String str) {
        return new zzg(false, str, null);
    }

    static zzg zzg() {
        return zzbk;
    }

    /* access modifiers changed from: package-private */
    public String getErrorMessage() {
        return this.zzbm;
    }

    /* access modifiers changed from: package-private */
    public final void zzh() throws SecurityException {
        if (!this.zzbl) {
            String valueOf = String.valueOf(getErrorMessage());
            String concat = valueOf.length() != 0 ? "GoogleCertificatesRslt: ".concat(valueOf) : new String("GoogleCertificatesRslt: ");
            Throwable th = this.cause;
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi() {
        if (this.zzbl) {
            return;
        }
        if (this.cause != null) {
            Log.d("GoogleCertificatesRslt", getErrorMessage(), this.cause);
        } else {
            Log.d("GoogleCertificatesRslt", getErrorMessage());
        }
    }
}
