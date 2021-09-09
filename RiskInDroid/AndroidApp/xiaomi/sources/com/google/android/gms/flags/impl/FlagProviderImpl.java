package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.flags.IFlagProvider;
import com.google.android.gms.flags.impl.DataUtils;

@DynamiteApi
public class FlagProviderImpl extends IFlagProvider.Stub {
    private boolean zzacf = false;
    private SharedPreferences zzacu;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.zzacf ? z : DataUtils.BooleanUtils.getFromSharedPreferencesNoStrict(this.zzacu, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.zzacf ? i : DataUtils.IntegerUtils.getFromSharedPreferencesNoStrict(this.zzacu, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.zzacf ? j : DataUtils.LongUtils.getFromSharedPreferencesNoStrict(this.zzacu, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.zzacf ? str2 : DataUtils.StringUtils.getFromSharedPreferencesNoStrict(this.zzacu, str, str2);
    }

    public void init(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzacf) {
            try {
                this.zzacu = SharedPreferencesFactory.getSharedPreferences(context.createPackageContext("com.google.android.gms", 0));
                this.zzacf = true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("FlagProviderImpl", valueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
            }
        }
    }
}
