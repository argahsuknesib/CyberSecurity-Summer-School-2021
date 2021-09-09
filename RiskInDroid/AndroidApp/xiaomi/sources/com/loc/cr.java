package com.loc;

import _m_j.brq;
import _m_j.brr;
import _m_j.brs;
import _m_j.bsf;
import _m_j.bsw;
import _m_j.bta;
import _m_j.btx;
import _m_j.btz;
import _m_j.buc;
import _m_j.bwv;
import _m_j.ov;
import _m_j.ow;
import _m_j.ox;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.location.security.Core;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class cr implements ox {
    private static brr O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4523O000000o = null;
    public int O00000Oo = 1;
    public btx O00000o = null;
    public Context O00000o0 = null;

    public cr(Context context) {
        this.O00000o0 = context;
    }

    private static String O000000o(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("\\$")) == null) {
            return null;
        }
        return split[0];
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:56:0x006b */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:21:? */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|(2:10|(1:12)(1:59))|13|14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x006b, code lost:
        if (r2 != 0) goto L_0x002c;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0048 A[SYNTHETIC, Splitter:B:34:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x004f A[SYNTHETIC, Splitter:B:38:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0056 A[SYNTHETIC, Splitter:B:42:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x005f A[SYNTHETIC, Splitter:B:49:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0066 A[SYNTHETIC, Splitter:B:53:0x0066] */
    private static byte[] O000000o(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream2;
        byte[] bArr2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    byteArrayOutputStream = 0;
                    th = th3;
                    if (byteArrayInputStream != null) {
                    }
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayOutputStream != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream2 = null;
                th = th;
                gZIPInputStream = gZIPInputStream2;
                byteArrayOutputStream = gZIPInputStream2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (byteArrayOutputStream != 0) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            try {
                byte[] bArr3 = new byte[512];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
            } catch (Throwable th5) {
                th = th5;
                if (byteArrayInputStream != null) {
                }
                if (gZIPInputStream != null) {
                }
                if (byteArrayOutputStream != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
            gZIPInputStream2 = null;
            th = th;
            gZIPInputStream = gZIPInputStream2;
            byteArrayOutputStream = gZIPInputStream2;
            if (byteArrayInputStream != null) {
            }
            if (gZIPInputStream != null) {
            }
            if (byteArrayOutputStream != 0) {
            }
            throw th;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused4) {
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[Catch:{ Throwable -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00aa A[Catch:{ Throwable -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf A[Catch:{ t -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ca A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1 A[SYNTHETIC, Splitter:B:38:0x00d1] */
    public final ow O000000o(ov ovVar) {
        boolean z;
        ow owVar;
        Proxy proxy;
        Map<String, String> map;
        bta bta;
        byte[] bArr;
        String str;
        String str2;
        String str3 = ovVar.f2376O000000o;
        String str4 = "http://offline.aps.amap.com/LoadOfflineData/repeatData";
        if (str3.contains(str4)) {
            str2 = "http://apilocate.amap.com/offline/down";
        } else {
            str4 = "http://cgicol.amap.com/dataPipeline/uploadData";
            if (str3.contains(str4)) {
                str2 = "http://apilocate.amap.com/offline/up";
            } else {
                z = false;
                owVar = new ow();
                proxy = brq.O000000o(this.O00000o0);
                buc buc = new buc();
                buc.f13280O000000o = str3;
                buc.O00000oO = proxy;
                buc.O00000o = ovVar.O00000o;
                buc.O00000o0 = ovVar.O00000o;
                map = ovVar.O00000Oo;
                if (z) {
                    String O000000o2 = bwv.O000000o();
                    if (str3.contains("?")) {
                        str = bwv.O000000o(this.O00000o0, O000000o2, brs.O00000o(str3.substring(str3.lastIndexOf("?") + 1)));
                    } else {
                        str = bwv.O000000o(this.O00000o0, O000000o2, "key=" + this.f4523O000000o);
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put("User-Agent", "AMAP_Location_SDK_Android " + this.O00000o.f13278O000000o);
                    map.put("key", this.f4523O000000o);
                    map.put("ts", O000000o2);
                    map.put("scode", str);
                }
                if (map != null) {
                    buc.O00000Oo = map;
                }
                buc.O00000oo = ovVar.O00000o0;
                bsw.O000000o();
                bta = bsw.O000000o(buc, false);
                try {
                    bArr = bta.f13259O000000o;
                    if (O000000o(str3, bArr)) {
                        return null;
                    }
                    owVar.O00000o0 = bArr;
                    owVar.f2377O000000o = 200;
                    owVar.O00000Oo = bta.O00000Oo;
                    return owVar;
                } catch (t e) {
                    e = e;
                    if (bta != null) {
                    }
                    return null;
                }
            }
        }
        str3 = str3.replace(str4, str2);
        z = true;
        owVar = new ow();
        try {
            proxy = brq.O000000o(this.O00000o0);
        } catch (Throwable unused) {
            proxy = null;
        }
        try {
            buc buc2 = new buc();
            buc2.f13280O000000o = str3;
            buc2.O00000oO = proxy;
            buc2.O00000o = ovVar.O00000o;
            buc2.O00000o0 = ovVar.O00000o;
            map = ovVar.O00000Oo;
            if (z) {
            }
            if (map != null) {
            }
            buc2.O00000oo = ovVar.O00000o0;
            try {
                bsw.O000000o();
                bta = bsw.O000000o(buc2, false);
                bArr = bta.f13259O000000o;
                if (O000000o(str3, bArr)) {
                }
            } catch (t e2) {
                e = e2;
                bta = null;
                if (bta != null) {
                    owVar.O00000o0 = bta.f13259O000000o;
                    owVar.f2377O000000o = e.e();
                    owVar.O00000Oo = bta.O00000Oo;
                    return owVar;
                }
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private boolean O000000o(String str, byte[] bArr) {
        try {
            if (str.contains("http://control.aps.amap.com/conf/r?type=3&mid=300&sver=140")) {
                String str2 = new String(Core.xxt(O000000o(bArr), -1), "UTF-8");
                if (this.O00000Oo == -1) {
                    return true;
                }
                int O000000o2 = btz.O000000o(this.O00000o0, "his_config", "version");
                if (O000000o2 != -1) {
                    String O00000Oo2 = btz.O00000Oo(this.O00000o0, "his_config", "command");
                    if (!O000000o(O00000Oo2).equals(O000000o(str2))) {
                        if (O000000o2 == this.O00000Oo) {
                            try {
                                SharedPreferences.Editor edit = this.O00000o0.getSharedPreferences("LocationCloudConfig", 0).edit();
                                edit.putString("command", O00000Oo2);
                                btz.O000000o(edit);
                            } catch (Throwable unused) {
                            }
                            try {
                                bsf.O00000Oo(O000000o(), "cloudcheck", "云控项有改变，版本号未变");
                            } catch (Throwable unused2) {
                            }
                            return false;
                        }
                        btz.O000000o(this.O00000o0, "his_config", str2, this.O00000Oo);
                        return true;
                    }
                } else {
                    btz.O000000o(this.O00000o0, "his_config", str2, this.O00000Oo);
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    private brr O000000o() {
        try {
            String str = this.O00000o.f13278O000000o;
            String[] strArr = {"com.amap.api.location", "com.loc", "com.amap.api.fence", "com.amap.co"};
            if (O00000oO == null) {
                brr.O000000o O000000o2 = new brr.O000000o("loc", str, "AMAP_Location_SDK_Android ".concat(String.valueOf(str))).O000000o(strArr);
                O000000o2.O00000Oo = str;
                O00000oO = O000000o2.O000000o();
            }
        } catch (Throwable unused) {
        }
        return O00000oO;
    }
}
