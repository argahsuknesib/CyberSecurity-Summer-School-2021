package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzfv {
    private final long zzabj;
    private final /* synthetic */ zzfr zzakq;
    @VisibleForTesting
    private final String zzaks;
    private final String zzakt;
    private final String zzaku;

    private zzfv(zzfr zzfr, String str, long j) {
        this.zzakq = zzfr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zzaks = String.valueOf(str).concat(":start");
        this.zzakt = String.valueOf(str).concat(":count");
        this.zzaku = String.valueOf(str).concat(":value");
        this.zzabj = j;
    }

    private final void zzfh() {
        this.zzakq.zzab();
        long currentTimeMillis = this.zzakq.zzbt().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzakq.zziy().edit();
        edit.remove(this.zzakt);
        edit.remove(this.zzaku);
        edit.putLong(this.zzaks, currentTimeMillis);
        edit.apply();
    }

    private final long zzfj() {
        return this.zzakq.zziy().getLong(this.zzaks, 0);
    }

    public final void zzc(String str, long j) {
        this.zzakq.zzab();
        if (zzfj() == 0) {
            zzfh();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzakq.zziy().getLong(this.zzakt, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zzakq.zziy().edit();
            edit.putString(this.zzaku, str);
            edit.putLong(this.zzakt, 1);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.zzakq.zzgb().zzlc().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = this.zzakq.zziy().edit();
        if (z) {
            edit2.putString(this.zzaku, str);
        }
        edit2.putLong(this.zzakt, j3);
        edit2.apply();
    }

    public final Pair<String, Long> zzfi() {
        long j;
        this.zzakq.zzab();
        this.zzakq.zzab();
        long zzfj = zzfj();
        if (zzfj == 0) {
            zzfh();
            j = 0;
        } else {
            j = Math.abs(zzfj - this.zzakq.zzbt().currentTimeMillis());
        }
        long j2 = this.zzabj;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            zzfh();
            return null;
        }
        String string = this.zzakq.zziy().getString(this.zzaku, null);
        long j3 = this.zzakq.zziy().getLong(this.zzakt, 0);
        zzfh();
        return (string == null || j3 <= 0) ? zzfr.zzajs : new Pair<>(string, Long.valueOf(j3));
    }
}
