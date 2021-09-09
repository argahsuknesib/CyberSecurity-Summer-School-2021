package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.firebase_messaging.zzh;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class zzp {
    zzp() {
    }

    private static zzq zza(SharedPreferences sharedPreferences, String str) throws zzr {
        String string = sharedPreferences.getString(zzao.zzd(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzao.zzd(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzq(zzc(string, string2), zzb(sharedPreferences, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        zza(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        throw r1;
     */
    private static zzq zza(File file) throws zzr, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property != null) {
            if (property2 != null) {
                try {
                    zzq zzq = new zzq(zzc(property, property2), Long.parseLong(properties.getProperty("cre")));
                    zza((Throwable) null, fileInputStream);
                    return zzq;
                } catch (NumberFormatException e) {
                    throw new zzr(e);
                }
            }
        }
        zza((Throwable) null, fileInputStream);
        return null;
    }

    static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private static void zza(Context context, String str, zzq zzq) {
        FileOutputStream fileOutputStream;
        try {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Writing key to properties file");
            }
            File zzf = zzf(context, str);
            zzf.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", zzq.zzq());
            properties.setProperty("pri", zzq.zzr());
            properties.setProperty("cre", String.valueOf(zzq.zzbe));
            fileOutputStream = new FileOutputStream(zzf);
            properties.store(fileOutputStream, (String) null);
            zza((Throwable) null, fileOutputStream);
        } catch (IOException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append("Failed to write key: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
        } catch (Throwable th) {
            zza(r4, fileOutputStream);
            throw th;
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzh.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileOutputStream fileOutputStream) {
        if (th != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                zzh.zza(th, th2);
            }
        } else {
            fileOutputStream.close();
        }
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzao.zzd(str, "cre"), null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static File zzb(Context context) {
        File O00000o0 = ContextCompat.O00000o0(context);
        if (O00000o0 != null && O00000o0.isDirectory()) {
            return O00000o0;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private final void zzb(Context context, String str, zzq zzq) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzq.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzr unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(zzao.zzd(str, "|P|"), zzq.zzq());
        edit.putString(zzao.zzd(str, "|K|"), zzq.zzr());
        edit.putString(zzao.zzd(str, "cre"), String.valueOf(zzq.zzbe));
        edit.commit();
    }

    private static KeyPair zzc(String str, String str2) throws zzr {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzr(e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzr(e2);
        }
    }

    private final zzq zzd(Context context, String str) throws zzr {
        try {
            zzq zze = zze(context, str);
            if (zze != null) {
                zzb(context, str, zze);
                return zze;
            }
            e = null;
            try {
                zzq zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza);
                    return zza;
                }
            } catch (zzr e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzr e2) {
            e = e2;
        }
    }

    private final zzq zze(Context context, String str) throws zzr {
        File zzf = zzf(context, str);
        if (!zzf.exists()) {
            return null;
        }
        try {
            return zza(zzf);
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return zza(zzf);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new zzr(e2);
            }
        }
    }

    private static File zzf(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), str2);
    }

    /* access modifiers changed from: package-private */
    public final zzq zzb(Context context, String str) throws zzr {
        zzq zzd = zzd(context, str);
        return zzd != null ? zzd : zzc(context, str);
    }

    /* access modifiers changed from: package-private */
    public final zzq zzc(Context context, String str) {
        zzq zzq = new zzq(zza.zzb(), System.currentTimeMillis());
        try {
            zzq zzd = zzd(context, str);
            if (zzd != null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
                }
                return zzd;
            }
        } catch (zzr unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        zza(context, str, zzq);
        zzb(context, str, zzq);
        return zzq;
    }
}
