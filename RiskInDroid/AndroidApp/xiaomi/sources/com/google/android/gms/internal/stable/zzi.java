package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzi {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static HashMap<String, String> zzagq;
    private static final Uri zzagv = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern zzagw = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzagx = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzagy = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzagz = new HashMap<>();
    private static final HashMap<String, Integer> zzaha = new HashMap<>();
    private static final HashMap<String, Long> zzahb = new HashMap<>();
    private static final HashMap<String, Float> zzahc = new HashMap<>();
    private static Object zzahd;
    private static boolean zzahe;
    private static String[] zzahf = new String[0];

    public static int getInt(ContentResolver contentResolver, String str, int i) {
        int i2;
        Object zzb = zzb(contentResolver);
        Integer num = (Integer) zza(zzaha, str, Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null) {
            try {
                i2 = Integer.parseInt(zza);
                num = Integer.valueOf(i2);
            } catch (NumberFormatException unused) {
            }
            zza(zzb, zzaha, str, num);
            return i2;
        }
        i2 = i;
        zza(zzb, zzaha, str, num);
        return i2;
    }

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Object zzb = zzb(contentResolver);
        Long l = (Long) zza(zzahb, str, Long.valueOf(j));
        if (l != null) {
            return l.longValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null) {
            try {
                long parseLong = Long.parseLong(zza);
                l = Long.valueOf(parseLong);
                j = parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        zza(zzb, zzahb, str, l);
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r2;
     */
    private static <T> T zza(HashMap hashMap, String str, Object obj) {
        synchronized (zzi.class) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            Object obj2 = hashMap.get(str);
            if (obj2 == null) {
                obj2 = obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
        r13 = r13.query(com.google.android.gms.internal.stable.zzi.CONTENT_URI, null, null, new java.lang.String[]{r14}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        if (r13 == null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0077, code lost:
        if (r13.moveToFirst() != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007a, code lost:
        r0 = r13.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007e, code lost:
        if (r0 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0084, code lost:
        if (r0.equals(r15) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
        r0 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0087, code lost:
        zza(r1, r14, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008a, code lost:
        if (r0 == null) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008c, code lost:
        r15 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0092, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        zza(r1, r14, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0097, code lost:
        if (r13 == null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0099, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009c, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009d, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x009e, code lost:
        if (r13 != null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a0, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a3, code lost:
        throw r14;
     */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzi.class) {
            zza(contentResolver);
            Object obj = zzahd;
            if (zzagq.containsKey(str)) {
                String str3 = zzagq.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            } else {
                String[] strArr = zzahf;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (!str.startsWith(strArr[i])) {
                        i++;
                    } else if (!zzahe || zzagq.isEmpty()) {
                        zzagq.putAll(zza(contentResolver, zzahf));
                        zzahe = true;
                        if (zzagq.containsKey(str)) {
                            String str4 = zzagq.get(str);
                            if (str4 == null) {
                                str4 = str2;
                            }
                        }
                    }
                }
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzagv, null, null, strArr, null);
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
        if (zzagq == null) {
            zzagy.set(false);
            zzagq = new HashMap<>();
            zzahd = new Object();
            zzahe = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzj(null));
        } else if (zzagy.getAndSet(false)) {
            zzagq.clear();
            zzagz.clear();
            zzaha.clear();
            zzahb.clear();
            zzahc.clear();
            zzahd = new Object();
            zzahe = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzi.class) {
            if (obj == zzahd) {
                zzagq.put(str, str2);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzi.class) {
            if (obj == zzahd) {
                hashMap.put(str, t);
                zzagq.remove(str);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Boolean bool = (Boolean) zza(zzagz, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzagw.matcher(zza).matches()) {
                z = true;
                bool = Boolean.TRUE;
            } else if (zzagx.matcher(zza).matches()) {
                z = false;
                bool = Boolean.FALSE;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + zza + "\") as boolean");
            }
        }
        zza(zzb, zzagz, str, bool);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzi.class) {
            zza(contentResolver);
            obj = zzahd;
        }
        return obj;
    }
}
