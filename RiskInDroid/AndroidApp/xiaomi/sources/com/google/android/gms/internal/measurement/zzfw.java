package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfw {
    private String value;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final String zzakv = null;
    private final String zzny;

    public zzfw(zzfr zzfr, String str, String str2) {
        this.zzakq = zzfr;
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
    }

    public final void zzbs(String str) {
        if (!zzka.zzs(str, this.value)) {
            SharedPreferences.Editor edit = this.zzakq.zziy().edit();
            edit.putString(this.zzny, str);
            edit.apply();
            this.value = str;
        }
    }

    public final String zzjg() {
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = this.zzakq.zziy().getString(this.zzny, null);
        }
        return this.value;
    }
}
