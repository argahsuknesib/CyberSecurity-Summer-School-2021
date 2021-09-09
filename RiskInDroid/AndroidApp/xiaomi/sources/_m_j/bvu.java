package _m_j;

import _m_j.bwy;
import android.content.Context;
import java.util.HashMap;
import java.util.Locale;

public final class bvu {
    private static bvu O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    bsw f13322O000000o = null;
    Context O00000Oo = null;
    boolean O00000o = false;
    int O00000o0 = 0;
    private int O00000oo = bvz.O00000oo;
    private int O0000O0o = 0;

    public static bvu O000000o(Context context) {
        if (O00000oO == null) {
            O00000oO = new bvu(context);
        }
        return O00000oO;
    }

    private bvu(Context context) {
        try {
            bwy.O000000o.f13370O000000o.O000000o(context);
        } catch (Throwable unused) {
        }
        this.O00000Oo = context;
        this.f13322O000000o = bsw.O000000o();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    public final void O000000o(long j, boolean z, int i) {
        try {
            this.O00000o = z;
            bwy.O000000o.f13370O000000o.O000000o(z);
            this.O00000oo = Long.valueOf(j).intValue();
            this.O0000O0o = i;
        } catch (Throwable th) {
            bvz.O000000o(th, "LocNetManager", "setOption");
        }
    }

    public final bvv O000000o(Context context, byte[] bArr, String str, boolean z) {
        String str2;
        try {
            HashMap hashMap = new HashMap(16);
            bvv bvv = new bvv(context, bvz.O00000Oo());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.7.1");
                hashMap.put("KEY", bwt.O00000oo(context));
                hashMap.put("enginever", "5.1");
                String O000000o2 = bwv.O000000o();
                String O000000o3 = bwv.O000000o(context, O000000o2, "key=" + bwt.O00000oo(context));
                hashMap.put("ts", O000000o2);
                hashMap.put("scode", O000000o3);
                hashMap.put("encr", "1");
                bvv.O00000oo = hashMap;
                String str3 = "loc";
                if (!z) {
                    str3 = "locf";
                }
                bvv.O0000o0 = true;
                bvv.O0000Ooo = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.7.1", str3, 3);
                bvv.O0000OoO = z;
                bvv.O0000OOo = str;
                bvv.O0000Oo0 = bwi.O000000o(bArr);
                bvv.O00000oO = brq.O000000o(context);
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                int i = this.O0000O0o;
                if (i != 0) {
                    if (i == 1) {
                        str2 = "language:cn";
                    } else if (i == 2) {
                        str2 = "language:en";
                    }
                    hashMap2.put("custom", str2);
                    bvv.O0000o00 = hashMap2;
                    bvv.O00000o0 = this.O00000oo;
                    bvv.O00000o = this.O00000oo;
                    if ((this.O00000o && !bwi.O0000OoO(context)) || !str.startsWith("http:")) {
                        return bvv;
                    }
                    bvv.O0000OOo = bvv.O0000OOo.replace("https:", "https:");
                    return bvv;
                }
                hashMap2.remove("custom");
                bvv.O0000o00 = hashMap2;
                bvv.O00000o0 = this.O00000oo;
                bvv.O00000o = this.O00000oo;
                if (this.O00000o) {
                }
                bvv.O0000OOo = bvv.O0000OOo.replace("https:", "https:");
                return bvv;
            } catch (Throwable unused) {
                return bvv;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00c5 A[Catch:{ Throwable -> 0x00e2, Throwable -> 0x00ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d4 A[Catch:{ Throwable -> 0x00e2, Throwable -> 0x00ea }] */
    public final String O000000o(Context context, double d, double d2) {
        byte[] bArr;
        String str;
        try {
            HashMap hashMap = new HashMap(16);
            bvv bvv = new bvv(context, bvz.O00000Oo());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.7.1");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", bwt.O00000oo(context));
            int i = this.O0000O0o;
            if (i != 0) {
                if (i == 1) {
                    str = "zh-CN";
                } else if (i == 2) {
                    str = "en";
                }
                hashMap2.put("language", str);
                String O000000o2 = bwv.O000000o();
                String O000000o3 = bwv.O000000o(context, O000000o2, brs.O00000Oo(hashMap2));
                hashMap2.put("ts", O000000o2);
                hashMap2.put("scode", O000000o3);
                bvv.O00000Oo(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
                bvv.O0000o0 = false;
                bvv.O0000OoO = true;
                bvv.O0000Ooo = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.7.1", "loc", 3);
                bvv.O0000o00 = hashMap2;
                bvv.O00000oo = hashMap;
                bvv.O00000oO = brq.O000000o(context);
                bvv.O00000o0 = bvz.O00000oo;
                bvv.O00000o = bvz.O00000oo;
                if (!bwi.O0000OoO(context)) {
                    bvv.O0000OOo = "http://restapi.amap.com/v3/geocode/regeo".replace("http:", "https:");
                    bArr = bsw.O000000o(bvv);
                } else {
                    bvv.O0000OOo = "http://restapi.amap.com/v3/geocode/regeo";
                    bArr = bsw.O00000Oo(bvv);
                }
                return new String(bArr, "utf-8");
            }
            hashMap2.remove("language");
            String O000000o22 = bwv.O000000o();
            String O000000o32 = bwv.O000000o(context, O000000o22, brs.O00000Oo(hashMap2));
            hashMap2.put("ts", O000000o22);
            hashMap2.put("scode", O000000o32);
            bvv.O00000Oo(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
            bvv.O0000o0 = false;
            bvv.O0000OoO = true;
            bvv.O0000Ooo = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.7.1", "loc", 3);
            bvv.O0000o00 = hashMap2;
            bvv.O00000oo = hashMap;
            bvv.O00000oO = brq.O000000o(context);
            bvv.O00000o0 = bvz.O00000oo;
            bvv.O00000o = bvz.O00000oo;
            if (!bwi.O0000OoO(context)) {
            }
            return new String(bArr, "utf-8");
        } catch (Throwable unused) {
        }
        return null;
    }
}
