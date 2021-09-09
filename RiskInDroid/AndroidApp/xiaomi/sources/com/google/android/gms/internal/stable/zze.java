package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import java.util.HashMap;

public final class zze {

    public static class zza implements BaseColumns {
        private static HashMap<Uri, zzh> zzagq = new HashMap<>();

        private static zzh zza(ContentResolver contentResolver, Uri uri) {
            zzh zzh = zzagq.get(uri);
            if (zzh == null) {
                zzh zzh2 = new zzh();
                zzagq.put(uri, zzh2);
                contentResolver.registerContentObserver(uri, true, new zzf(null, zzh2));
                return zzh2;
            } else if (!zzh.zzagu.getAndSet(false)) {
                return zzh;
            } else {
                synchronized (zzh) {
                    zzh.zzags.clear();
                    zzh.zzagt = new Object();
                }
                return zzh;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r11 = r11.query(r12, new java.lang.String[]{"value"}, "name=?", new java.lang.String[]{r13}, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            if (r11 == null) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r11.moveToFirst() != false) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
            r2 = r11.getString(0);
            zza(r1, r0, r13, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            if (r11 == null) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            r11.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            zza(r1, r0, r13, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
            if (r11 == null) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
            r11.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
            r12 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
            r2 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0057, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0058, code lost:
            r2 = r11;
            r11 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005c, code lost:
            r12 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005e, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005f, code lost:
            r11 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            android.util.Log.e("GoogleSettings", "Can't get key " + r13 + " from " + r12, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007b, code lost:
            if (r2 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0081, code lost:
            if (r2 != null) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0083, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0086, code lost:
            throw r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            return r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return r11;
         */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        protected static String zza(ContentResolver contentResolver, Uri uri, String str) {
            zzh zza;
            synchronized (zza.class) {
                zza = zza(contentResolver, uri);
            }
            synchronized (zza) {
                Object obj = zza.zzagt;
                if (zza.zzags.containsKey(str)) {
                    String str2 = zza.zzags.get(str);
                    return str2;
                }
            }
        }

        private static void zza(zzh zzh, Object obj, String str, String str2) {
            synchronized (zzh) {
                if (obj == zzh.zzagt) {
                    zzh.zzags.put(str, str2);
                }
            }
        }
    }
}
