package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzep {
    final String name;
    private final String origin;
    final long timestamp;
    final long zzafp;
    final zzer zzafq;
    final String zzti;

    zzep(zzgl zzgl, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzer zzer;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zzti = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j;
        this.zzafp = j2;
        long j3 = this.zzafp;
        if (j3 != 0 && j3 > this.timestamp) {
            zzgl.zzge().zzip().zzg("Event created with reverse previous/current timestamps. appId", zzfg.zzbm(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzer = new zzer(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgl.zzge().zzim().log("Param name can't be null");
                } else {
                    Object zzh = zzgl.zzgb().zzh(next, bundle2.get(next));
                    if (zzh == null) {
                        zzgl.zzge().zzip().zzg("Param value can't be null", zzgl.zzga().zzbk(next));
                    } else {
                        zzgl.zzgb().zza(bundle2, next, zzh);
                    }
                }
                it.remove();
            }
            zzer = new zzer(bundle2);
        }
        this.zzafq = zzer;
    }

    private zzep(zzgl zzgl, String str, String str2, String str3, long j, long j2, zzer zzer) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzer);
        this.zzti = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j;
        this.zzafp = j2;
        long j3 = this.zzafp;
        if (j3 != 0 && j3 > this.timestamp) {
            zzgl.zzge().zzip().zze("Event created with reverse previous/current timestamps. appId, name", zzfg.zzbm(str2), zzfg.zzbm(str3));
        }
        this.zzafq = zzer;
    }

    public final String toString() {
        String str = this.zzti;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzafq);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final zzep zza(zzgl zzgl, long j) {
        return new zzep(zzgl, this.origin, this.zzti, this.name, this.timestamp, j, this.zzafq);
    }
}
