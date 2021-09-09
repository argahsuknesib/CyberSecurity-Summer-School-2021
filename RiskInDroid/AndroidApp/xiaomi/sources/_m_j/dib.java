package _m_j;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class dib implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    int f14658O000000o;
    long O00000Oo;
    private int O00000o;
    private int O00000o0;
    private final Context O00000oO;
    private final int O00000oo;
    private final byte[] O0000O0o;
    private final dgs O0000OOo;
    private final dhy O0000Oo;
    private final dgu O0000Oo0;
    private final dia O0000OoO;
    private final int O0000Ooo;
    private final Map<String, String> O0000o;
    private final dhz O0000o0;
    private final dhz O0000o00;
    private String O0000o0O;
    private final String O0000o0o;
    private boolean O0000oO;
    private long O0000oO0;
    private boolean O0000oOO;

    public dib(Context context, int i, int i2, byte[] bArr, String str, String str2, dhz dhz, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, dhz, z, 2, 30000, z2, null);
    }

    public dib(Context context, int i, int i2, byte[] bArr, String str, String str2, dhz dhz, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        int i5 = i3;
        int i6 = i4;
        this.O00000o0 = 2;
        this.O00000o = 30000;
        this.O0000o0O = null;
        this.f14658O000000o = 0;
        this.O00000Oo = 0;
        this.O0000oO0 = 0;
        this.O0000oO = true;
        this.O0000oOO = false;
        this.O00000oO = context;
        this.O0000OOo = dgs.O000000o(context);
        this.O0000O0o = bArr;
        this.O0000Oo0 = dgu.O000000o();
        if (dhy.f14653O000000o == null) {
            dhy.f14653O000000o = new dhy(context);
        }
        this.O0000Oo = dhy.f14653O000000o;
        this.O0000OoO = dia.O000000o();
        this.O0000Ooo = i;
        this.O0000o0O = str;
        this.O0000o0o = str2;
        this.O0000o00 = dhz;
        this.O0000o0 = null;
        this.O0000oO = z;
        this.O00000oo = i2;
        if (i5 > 0) {
            this.O00000o0 = i5;
        }
        if (i6 > 0) {
            this.O00000o = i6;
        }
        this.O0000oOO = z2;
        this.O0000o = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    private void O000000o(boolean z, int i, String str, int i2) {
        String str2;
        dhz dhz;
        dhz dhz2;
        int i3 = this.O00000oo;
        if (i3 != 630) {
            if (i3 != 640) {
                if (i3 != 830) {
                    if (i3 != 840) {
                        str2 = String.valueOf(i3);
                        if (z) {
                            did.O000000o("[Upload] Success: %s", str2);
                        } else {
                            did.O00000oO("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i), str2, str);
                            if (this.O0000oO) {
                                this.O0000OoO.O000000o(i2, (an) null);
                            }
                        }
                        if (this.O00000Oo + this.O0000oO0 > 0) {
                            this.O0000OoO.O000000o(this.O0000OoO.O000000o(this.O0000oOO) + this.O00000Oo + this.O0000oO0, this.O0000oOO);
                        }
                        dhz = this.O0000o00;
                        if (dhz != null) {
                            dhz.O000000o(z);
                        }
                        dhz2 = this.O0000o0;
                        if (dhz2 != null) {
                            dhz2.O000000o(z);
                            return;
                        }
                        return;
                    }
                }
            }
            str2 = "userinfo";
            if (z) {
            }
            if (this.O00000Oo + this.O0000oO0 > 0) {
            }
            dhz = this.O0000o00;
            if (dhz != null) {
            }
            dhz2 = this.O0000o0;
            if (dhz2 != null) {
            }
        }
        str2 = "crash";
        if (z) {
        }
        if (this.O00000Oo + this.O0000oO0 > 0) {
        }
        dhz = this.O0000o00;
        if (dhz != null) {
        }
        dhz2 = this.O0000o0;
        if (dhz2 != null) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhv.O000000o(int, java.lang.String, byte[], boolean):boolean
     arg types: [int, java.lang.String, byte[], int]
     candidates:
      _m_j.dhv.O000000o(java.lang.String, java.lang.String, java.lang.String[], _m_j.dhu):int
      _m_j.dhv.O000000o(_m_j.dhv, java.lang.String, android.content.ContentValues, _m_j.dhu):long
      _m_j.dhv.O000000o(int, java.lang.String, byte[], _m_j.dhu):boolean
      _m_j.dhv.O000000o(_m_j.dhv, int, java.lang.String, _m_j.dhu):boolean
      _m_j.dhv.O000000o(int, java.lang.String, byte[], boolean):boolean */
    private static boolean O000000o(an anVar, dgs dgs, dgu dgu) {
        if (anVar == null) {
            did.O00000o("resp == null!", new Object[0]);
            return false;
        } else if (anVar.f5830a != 0) {
            did.O00000oO("resp result error %d", Byte.valueOf(anVar.f5830a));
            return false;
        } else {
            try {
                if (!dif.O000000o(anVar.d)) {
                    if (!dgs.O000000o().O00000oo().equals(anVar.d)) {
                        dhv.O000000o().O000000o(dgu.f14617O000000o, "key_ip", anVar.d.getBytes("UTF-8"), true);
                        dgs.O000000o(anVar.d);
                    }
                }
                if (!dif.O000000o(anVar.f) && !dgs.O000000o().O0000O0o().equals(anVar.f)) {
                    dhv.O000000o().O000000o(dgu.f14617O000000o, "key_imei", anVar.f.getBytes("UTF-8"), true);
                    dgs.O00000Oo(anVar.f);
                }
            } catch (Throwable th) {
                did.O000000o(th);
            }
            dgs.O0000o00 = anVar.e;
            if (anVar.b == 510) {
                if (anVar.c == null) {
                    did.O00000oO("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                ap apVar = (ap) dhg.O000000o(anVar.c, ap.class);
                if (apVar == null) {
                    did.O00000oO("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                dgu.O000000o(apVar);
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0350, code lost:
        if (r12 == 0) goto L_0x03fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0352, code lost:
        if (r12 != 2) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x035d, code lost:
        if ((r1.O00000Oo + r1.O0000oO0) <= 0) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x035f, code lost:
        r1.O0000OoO.O000000o((r1.O0000OoO.O000000o(r1.O0000oOO) + r1.O00000Oo) + r1.O0000oO0, r1.O0000oOO);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0374, code lost:
        r1.O0000OoO.O000000o(r12, (com.tencent.bugly.proguard.an) null);
        _m_j.did.O000000o("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        r1.O0000OoO.O000000o(r1.O0000Ooo, r1.O00000oo, r1.O0000O0o, r1.O0000o0O, r1.O0000o0o, r1.O0000o00, r1.O00000o0, r1.O00000o, true, r1.O0000o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x03c2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x03c3, code lost:
        O000000o(false, 1, "status of server is ".concat(java.lang.String.valueOf(r12)), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03d1, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02ba A[Catch:{ Throwable -> 0x03d2, Throwable -> 0x04f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x047c A[Catch:{ Throwable -> 0x03d2, Throwable -> 0x04f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0483 A[Catch:{ Throwable -> 0x03d2, Throwable -> 0x04f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0167 A[Catch:{ Throwable -> 0x03d2, Throwable -> 0x04f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016d A[Catch:{ Throwable -> 0x03d2, Throwable -> 0x04f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01aa A[Catch:{ Throwable -> 0x03d2, Throwable -> 0x04f7 }] */
    public final void run() {
        int i;
        byte[] O000000o2;
        Map<String, String> map;
        String str;
        boolean z;
        boolean z2;
        String str2 = "Bugly-Version";
        char c = 0;
        try {
            this.f14658O000000o = 0;
            this.O00000Oo = 0;
            this.O0000oO0 = 0;
            byte[] bArr = this.O0000O0o;
            if (dgt.O00000oo(this.O00000oO) == null) {
                O000000o(false, 0, "network is not available", 0);
                return;
            }
            if (bArr != null) {
                if (bArr.length != 0) {
                    long O000000o3 = this.O0000OoO.O000000o(this.O0000oOO);
                    if (((long) bArr.length) + O000000o3 >= 2097152) {
                        did.O00000oO("[Upload] Upload too much data, try next time: %d/%d", Long.valueOf(O000000o3), 2097152L);
                        O000000o(false, 0, new StringBuilder("over net consume: 2048K").toString(), 0);
                        return;
                    }
                    did.O00000o0("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.O00000oo));
                    if (!(this.O00000oO == null || this.O0000OOo == null || this.O0000Oo0 == null)) {
                        if (this.O0000Oo != null) {
                            StrategyBean O00000o02 = this.O0000Oo0.O00000o0();
                            if (O00000o02 == null) {
                                O000000o(false, 0, "illegal local strategy", 0);
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("prodId", this.O0000OOo.O00000o0());
                            hashMap.put("bundleId", this.O0000OOo.O00000oO);
                            hashMap.put("appVer", this.O0000OOo.O0000o0);
                            if (this.O0000o != null) {
                                hashMap.putAll(this.O0000o);
                            }
                            char c2 = 3;
                            if (this.O0000oO) {
                                hashMap.put("cmd", Integer.toString(this.O00000oo));
                                hashMap.put("platformId", Byte.toString((byte) 1));
                                this.O0000OOo.getClass();
                                hashMap.put("sdkVer", "2.6.6");
                                hashMap.put("strategylastUpdateTime", Long.toString(O00000o02.O0000o0o));
                                dia dia = this.O0000OoO;
                                did.O00000o0("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (dia.O00000oO != null) {
                                    hashMap.put("secureSessionId", dia.O00000oO);
                                } else {
                                    if (dia.O00000o != null) {
                                        if ((dia.O00000o.length << 3) == 128) {
                                            if (dia.O00000o0 == null) {
                                                dia.O00000o0 = Base64.decode(dia.O00000Oo, 0);
                                                if (dia.O00000o0 == null) {
                                                    did.O00000o("[UploadManager] Failed to decode RSA public key", new Object[0]);
                                                    z2 = false;
                                                    if (z2) {
                                                        O000000o(false, 0, "failed to add security info to HTTP headers", 0);
                                                        return;
                                                    }
                                                    byte[] O000000o4 = dif.O000000o(bArr);
                                                    if (O000000o4 == null) {
                                                        O000000o(false, 0, "failed to zip request body", 0);
                                                        return;
                                                    }
                                                    dia dia2 = this.O0000OoO;
                                                    if (dia2.O00000o != null) {
                                                        if ((dia2.O00000o.length << 3) == 128) {
                                                            bArr = dif.O000000o(1, O000000o4, dia2.O00000o);
                                                            if (bArr == null) {
                                                                O000000o(false, 0, "failed to encrypt request body", 0);
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    did.O00000o("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                    bArr = null;
                                                    if (bArr == null) {
                                                    }
                                                }
                                            }
                                            byte[] O000000o5 = dif.O000000o(dia.O00000o, dia.O00000o0);
                                            if (O000000o5 == null) {
                                                did.O00000o("[UploadManager] Failed to encrypt AES key", new Object[0]);
                                            } else {
                                                String encodeToString = Base64.encodeToString(O000000o5, 0);
                                                if (encodeToString == null) {
                                                    did.O00000o("[UploadManager] Failed to encode AES key", new Object[0]);
                                                } else {
                                                    hashMap.put("raKey", encodeToString);
                                                }
                                            }
                                            z2 = false;
                                            if (z2) {
                                            }
                                        }
                                    }
                                    did.O00000o("[UploadManager] AES key is invalid", new Object[0]);
                                    z2 = false;
                                    if (z2) {
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                }
                            }
                            this.O0000OoO.O000000o(this.O0000Ooo, System.currentTimeMillis());
                            String str3 = this.O0000o0O;
                            int i2 = 0;
                            int i3 = 0;
                            i = -1;
                            while (true) {
                                int i4 = i2 + 1;
                                if (i2 < this.O00000o0) {
                                    if (i4 > 1) {
                                        Object[] objArr = new Object[1];
                                        objArr[c] = Integer.valueOf(i4);
                                        did.O00000o("[Upload] Failed to upload last time, wait and try(%d) again.", objArr);
                                        dif.O00000Oo((long) this.O00000o);
                                        if (i4 == this.O00000o0) {
                                            Object[] objArr2 = new Object[1];
                                            objArr2[c] = this.O0000o0o;
                                            did.O00000o("[Upload] Use the back-up url at the last time: %s", objArr2);
                                            str3 = this.O0000o0o;
                                        }
                                    }
                                    Object[] objArr3 = new Object[1];
                                    objArr3[c] = Integer.valueOf(bArr.length);
                                    did.O00000o0("[Upload] Send %d bytes", objArr3);
                                    if (this.O0000oO) {
                                        str3 = O000000o(str3);
                                    }
                                    Object[] objArr4 = new Object[4];
                                    objArr4[c] = str3;
                                    objArr4[1] = Integer.valueOf(this.O00000oo);
                                    objArr4[2] = Integer.valueOf(Process.myPid());
                                    objArr4[c2] = Integer.valueOf(Process.myTid());
                                    did.O00000o0("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", objArr4);
                                    O000000o2 = this.O0000Oo.O000000o(str3, bArr, this, hashMap);
                                    if (O000000o2 == null) {
                                        Object[] objArr5 = new Object[2];
                                        objArr5[c] = 1;
                                        objArr5[1] = "Failed to upload for no response!";
                                        did.O00000oO("[Upload] Failed to upload(%d): %s", objArr5);
                                        i2 = i4;
                                        i3 = 1;
                                    } else {
                                        map = this.O0000Oo.O00000Oo;
                                        if (!this.O0000oO) {
                                            break;
                                        }
                                        if (map != null) {
                                            if (map.size() != 0) {
                                                if (!map.containsKey("status")) {
                                                    did.O00000o("[Upload] Headers does not contain %s", "status");
                                                } else if (!map.containsKey(str2)) {
                                                    did.O00000o("[Upload] Headers does not contain %s", str2);
                                                } else {
                                                    String str4 = map.get(str2);
                                                    if (!str4.contains("bugly")) {
                                                        str = str2;
                                                        did.O00000o("[Upload] Bugly version is not valid: %s", str4);
                                                        z = false;
                                                        if (!z) {
                                                            i = Integer.parseInt(map.get("status"));
                                                            did.O00000o0("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                            break;
                                                        }
                                                        did.O00000o0("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                        did.O00000oO("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                                                        if (map != null) {
                                                            for (Map.Entry next : map.entrySet()) {
                                                                did.O00000o0(String.format("[key]: %s, [value]: %s", next.getKey(), next.getValue()), new Object[0]);
                                                            }
                                                        }
                                                        did.O00000o0("[Upload] Failed to upload for no status header.", new Object[0]);
                                                        i2 = i4;
                                                        str2 = str;
                                                        c = 0;
                                                        i3 = 1;
                                                        c2 = 3;
                                                    } else {
                                                        str = str2;
                                                        did.O00000o0("[Upload] Bugly version from headers is: %s", str4);
                                                        z = true;
                                                        if (!z) {
                                                        }
                                                    }
                                                }
                                                str = str2;
                                                z = false;
                                                if (!z) {
                                                }
                                                i2 = i4;
                                                str2 = str;
                                                c = 0;
                                                i3 = 1;
                                                c2 = 3;
                                            }
                                        }
                                        str = str2;
                                        did.O00000o("[Upload] Headers is empty.", new Object[0]);
                                        z = false;
                                        if (!z) {
                                        }
                                    }
                                } else {
                                    O000000o(false, i3, "failed after many attempts", 0);
                                    return;
                                }
                            }
                            byte[] bArr2 = null;
                            did.O00000o0("[Upload] Received %d bytes", Integer.valueOf(O000000o2.length));
                            if (this.O0000oO) {
                                if (O000000o2.length == 0) {
                                    for (Map.Entry next2 : map.entrySet()) {
                                        did.O00000o0("[Upload] HTTP headers from server: key = %s, value = %s", next2.getKey(), next2.getValue());
                                    }
                                    O000000o(false, 1, "response data from server is empty", 0);
                                    return;
                                }
                                dia dia3 = this.O0000OoO;
                                if (dia3.O00000o != null) {
                                    if ((dia3.O00000o.length << 3) == 128) {
                                        bArr2 = dif.O000000o(2, O000000o2, dia3.O00000o);
                                        if (bArr2 != null) {
                                            O000000o(false, 1, "failed to decrypt response from server", 0);
                                            return;
                                        }
                                        O000000o2 = dif.O00000Oo(bArr2);
                                        if (O000000o2 == null) {
                                            O000000o(false, 1, "failed unzip(Gzip) response from server", 0);
                                            return;
                                        }
                                    }
                                }
                                did.O00000o("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (bArr2 != null) {
                                }
                            }
                            an O000000o6 = dhg.O000000o(O000000o2, this.O0000oO);
                            if (O000000o6 == null) {
                                O000000o(false, 1, "failed to decode response package", 0);
                                return;
                            }
                            if (this.O0000oO) {
                                this.O0000OoO.O000000o(i, O000000o6);
                            }
                            Object[] objArr6 = new Object[2];
                            objArr6[0] = Integer.valueOf(O000000o6.b);
                            objArr6[1] = Integer.valueOf(O000000o6.c == null ? 0 : O000000o6.c.length);
                            did.O00000o0("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr6);
                            if (!O000000o(O000000o6, this.O0000OOo, this.O0000Oo0)) {
                                O000000o(false, 2, "failed to process response package", 0);
                                return;
                            } else {
                                O000000o(true, 2, "successfully uploaded", 0);
                                return;
                            }
                        }
                    }
                    O000000o(false, 0, "illegal access error", 0);
                    return;
                }
            }
            O000000o(false, 0, "request package is empty!", 0);
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void O000000o(long j) {
        this.O0000oO0 += j;
    }

    private static String O000000o(String str) {
        if (dif.O000000o(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            did.O000000o(th);
            return str;
        }
    }
}
