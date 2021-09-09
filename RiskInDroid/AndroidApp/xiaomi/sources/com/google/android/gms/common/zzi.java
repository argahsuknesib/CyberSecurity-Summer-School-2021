package com.google.android.gms.common;

import com.google.android.gms.common.GoogleCertificates;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

final class zzi extends zzg {
    private final String packageName;
    private final GoogleCertificates.CertData zzbn;
    private final boolean zzbo;
    private final boolean zzbp;

    private zzi(String str, GoogleCertificates.CertData certData, boolean z, boolean z2) {
        super(false, null, null);
        this.packageName = str;
        this.zzbn = certData;
        this.zzbo = z;
        this.zzbp = z2;
    }

    /* access modifiers changed from: package-private */
    public final String getErrorMessage() {
        String str = this.zzbp ? "debug cert rejected" : "not whitelisted";
        String str2 = this.packageName;
        String bytesToStringLowercase = Hex.bytesToStringLowercase(AndroidUtilsLight.getMessageDigest("SHA-1").digest(this.zzbn.getBytes()));
        boolean z = this.zzbo;
        StringBuilder sb = new StringBuilder(str.length() + 44 + String.valueOf(str2).length() + String.valueOf(bytesToStringLowercase).length());
        sb.append(str);
        sb.append(": pkg=");
        sb.append(str2);
        sb.append(", sha1=");
        sb.append(bytesToStringLowercase);
        sb.append(", atk=");
        sb.append(z);
        sb.append(", ver=12451009.false");
        return sb.toString();
    }
}
