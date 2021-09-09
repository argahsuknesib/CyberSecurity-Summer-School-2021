package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzwn {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbmh = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbmi = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbmj = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzbmk = new AtomicBoolean();
    private static HashMap<String, String> zzbml;
    private static final HashMap<String, Boolean> zzbmm = new HashMap<>();
    private static final HashMap<String, Integer> zzbmn = new HashMap<>();
    private static final HashMap<String, Long> zzbmo = new HashMap<>();
    private static final HashMap<String, Float> zzbmp = new HashMap<>();
    private static Object zzbmq;
    private static boolean zzbmr;
    private static String[] zzbms = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r2;
     */
    private static <T> T zza(HashMap hashMap, String str, Object obj) {
        synchronized (zzwn.class) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            Object obj2 = hashMap.get(str);
            if (obj2 == null) {
                obj2 = obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r13 = r13.query(com.google.android.gms.internal.measurement.zzwn.CONTENT_URI, null, null, new java.lang.String[]{r14}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r13 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        if (r13.moveToFirst() != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r15 = r13.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r15 == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        if (r15.equals(null) == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        zza(r0, r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        if (r15 == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008e, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0094, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        zza(r0, r14, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0098, code lost:
        if (r13 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009a, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009f, code lost:
        if (r13 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a1, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a4, code lost:
        throw r14;
     */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzwn.class) {
            zza(contentResolver);
            Object obj = zzbmq;
            if (zzbml.containsKey(str)) {
                String str3 = zzbml.get(str);
                if (str3 == null) {
                    str3 = null;
                }
            } else {
                String[] strArr = zzbms;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (!str.startsWith(strArr[i])) {
                        i++;
                    } else if (!zzbmr || zzbml.isEmpty()) {
                        zzbml.putAll(zza(contentResolver, zzbms));
                        zzbmr = true;
                        if (zzbml.containsKey(str)) {
                            String str4 = zzbml.get(str);
                            if (str4 == null) {
                                str4 = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbmh, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzbml == null) {
            zzbmk.set(false);
            zzbml = new HashMap<>();
            zzbmq = new Object();
            zzbmr = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzwo(null));
        } else if (zzbmk.getAndSet(false)) {
            zzbml.clear();
            zzbmm.clear();
            zzbmn.clear();
            zzbmo.clear();
            zzbmp.clear();
            zzbmq = new Object();
            zzbmr = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzwn.class) {
            if (obj == zzbmq) {
                zzbml.put(str, str2);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Boolean bool = (Boolean) zza(zzbmm, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzbmi.matcher(zza).matches()) {
                z = true;
                bool = Boolean.TRUE;
            } else if (zzbmj.matcher(zza).matches()) {
                z = false;
                bool = Boolean.FALSE;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + zza + "\") as boolean");
            }
        }
        HashMap<String, Boolean> hashMap = zzbmm;
        synchronized (zzwn.class) {
            if (zzb == zzbmq) {
                hashMap.put(str, bool);
                zzbml.remove(str);
            }
        }
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzwn.class) {
            zza(contentResolver);
            obj = zzbmq;
        }
        return obj;
    }
}
