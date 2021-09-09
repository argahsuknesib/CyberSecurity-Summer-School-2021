package com.google.firebase.iid;

import _m_j.o0O0OOO0;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class zzao {
    private final SharedPreferences zzcq;
    private final zzp zzcr;
    private final Map<String, zzq> zzcs;
    private final Context zzz;

    public zzao(Context context) {
        this(context, new zzp());
    }

    private zzao(Context context, zzp zzp) {
        this.zzcs = new o0O0OOO0();
        this.zzz = context;
        this.zzcq = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzcr = zzp;
        File file = new File(ContextCompat.O00000o0(this.zzz), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zzag();
                    FirebaseInstanceId.getInstance().zzk();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private final synchronized boolean isEmpty() {
        return this.zzcq.getAll().isEmpty();
    }

    private static String zza(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    static String zzd(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void zza(String str) {
        String string = this.zzcq.getString("topic_operaion_queue", "");
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length());
        sb.append(string);
        sb.append(",");
        sb.append(str);
        this.zzcq.edit().putString("topic_operaion_queue", sb.toString()).apply();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza = zzap.zza(str4, str5, System.currentTimeMillis());
        if (zza != null) {
            SharedPreferences.Editor edit = this.zzcq.edit();
            edit.putString(zza(str, str2, str3), zza);
            edit.commit();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return null;
     */
    public final synchronized String zzaf() {
        String string = this.zzcq.getString("topic_operaion_queue", null);
        if (string != null) {
            String[] split = string.split(",");
            if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                return split[1];
            }
        }
    }

    public final synchronized void zzag() {
        this.zzcs.clear();
        zzp.zza(this.zzz);
        this.zzcq.edit().clear().commit();
    }

    public final synchronized zzap zzb(String str, String str2, String str3) {
        return zzap.zzi(this.zzcq.getString(zza(str, str2, str3), null));
    }

    public final synchronized void zzc(String str, String str2, String str3) {
        String zza = zza(str, str2, str3);
        SharedPreferences.Editor edit = this.zzcq.edit();
        edit.remove(zza);
        edit.commit();
    }

    public final synchronized boolean zzf(String str) {
        boolean z;
        String string = this.zzcq.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(str);
        if (string.startsWith(valueOf.length() != 0 ? ",".concat(valueOf) : new String(","))) {
            String valueOf2 = String.valueOf(str);
            this.zzcq.edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? ",".concat(valueOf2) : new String(",")).length())).apply();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized zzq zzg(String str) {
        zzq zzq;
        zzq zzq2 = this.zzcs.get(str);
        if (zzq2 != null) {
            return zzq2;
        }
        try {
            zzq = this.zzcr.zzb(this.zzz, str);
        } catch (zzr unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.getInstance().zzk();
            zzq = this.zzcr.zzc(this.zzz, str);
        }
        this.zzcs.put(str, zzq);
        return zzq;
    }

    public final synchronized void zzh(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.zzcq.edit();
        for (String next : this.zzcq.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }
}
