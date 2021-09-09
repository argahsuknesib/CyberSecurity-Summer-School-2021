package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.cache.keystore.EncryptionManager;

public final class fas {

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile boolean f16036O000000o;
    private EncryptionManager O00000Oo;
    private fau O00000o;
    private byte[] O00000o0;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final fas f16038O000000o = new fas((byte) 0);
    }

    /* synthetic */ fas(byte b) {
        this();
    }

    private fas() {
        this.O00000o0 = "j49ks1q".getBytes();
        this.f16036O000000o = false;
        this.O00000o = new fau() {
            /* class _m_j.fas.AnonymousClass1 */

            public final String O000000o(String str, String str2) {
                return MMKV.O000000o("security.cache", "ox23.j3qk").O00000o0(str, str2);
            }

            public final boolean O00000Oo(String str, String str2) {
                return MMKV.O000000o("security.cache", "ox23.j3qk").O00000Oo(str, str2);
            }

            public final boolean O000000o(String str, boolean z) {
                return MMKV.O000000o("security.cache", "ox23.j3qk").O00000Oo(str, z);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.tencent.mmkv.MMKV.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              com.tencent.mmkv.MMKV.O000000o(java.lang.String, java.lang.String):com.tencent.mmkv.MMKV
              com.tencent.mmkv.MMKV.O000000o(com.tencent.mmkv.MMKVLogLevel, java.lang.String):void
              com.tencent.mmkv.MMKV.O000000o(java.lang.String, double):boolean
              com.tencent.mmkv.MMKV.O000000o(java.lang.String, int):boolean
              com.tencent.mmkv.MMKV.O000000o(java.lang.String, java.util.Set<java.lang.String>):boolean
              com.tencent.mmkv.MMKV.O000000o(java.lang.String, boolean):boolean */
            public final boolean O000000o(String str) {
                return MMKV.O000000o("security.cache", "ox23.j3qk").O000000o(str, true);
            }

            public final boolean O00000Oo(String str) {
                return MMKV.O000000o("security.cache", "ox23.j3qk").contains(str);
            }
        };
    }

    public final void O000000o(Context context) {
        try {
            this.O00000Oo = new EncryptionManager(context, this.O00000o, "mijia", this.O00000o0);
            this.f16036O000000o = true;
        } catch (Exception e) {
            gsy.O00000Oo("SecurityCache", "init  fail");
            e.printStackTrace();
            this.f16036O000000o = false;
        }
    }

    public final boolean O000000o(String str, String str2) {
        return O0000O0o(str + ".token", str2);
    }

    public final String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return O0000O0o(str + ".token");
    }

    public final boolean O00000Oo(String str, String str2) {
        return O0000O0o(str + ".ltmk", str2);
    }

    public final String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return O0000O0o(str + ".ltmk");
    }

    public final boolean O00000o0(String str, String str2) {
        return O0000O0o(str + ".pincode", str2);
    }

    public final String O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return O0000O0o(str + ".pincode");
    }

    public final boolean O00000o(String str, String str2) {
        return O0000O0o(str + ".sessionKey", str2);
    }

    public final String O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return O0000O0o(str + ".sessionKey");
    }

    public final boolean O00000oO(String str, String str2) {
        return O0000O0o(str + ".shareKeyId", str2);
    }

    public final String O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return O0000O0o(str + ".shareKeyId");
    }

    public final boolean O00000oo(String str, String str2) {
        return O0000O0o(str + ".meshBindInfo", str2);
    }

    public final String O00000oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return O0000O0o(str + ".meshBindInfo");
    }

    public final String O0000O0o(String str) {
        String str2;
        try {
            String O000000o2 = EncryptionManager.O000000o(str);
            String O00000Oo2 = MMKV.O000000o("security.cache", "ox23.j3qk").O00000Oo(O000000o2);
            if (O00000Oo2 != null) {
                EncryptionManager encryptionManager = this.O00000Oo;
                if (O00000Oo2 == null || O00000Oo2.length() <= 0) {
                    str2 = null;
                } else {
                    EncryptionManager.O000000o o000000o = new EncryptionManager.O000000o();
                    String[] split = O00000Oo2.split("]");
                    o000000o.f4324O000000o = Base64.decode(split[0], 2);
                    o000000o.O00000Oo = Base64.decode(split[1], 2);
                    if (split.length > 2) {
                        o000000o.O00000o0 = Base64.decode(split[2], 2);
                    }
                    byte[] O000000o3 = encryptionManager.O000000o(o000000o);
                    str2 = new String(O000000o3, 0, O000000o3.length, "UTF-8");
                }
                gsy.O00000Oo("SecurityCache", String.format("read (%s : %s)=>(%s:%s)", O000000o2, O00000Oo2, str, str2));
                return str2;
            }
            gsy.O00000Oo("SecurityCache", String.format("read (%s : %s)=>(%s:%s)", O000000o2, null, str, null));
            return null;
        } catch (Exception e) {
            gsy.O00000Oo("SecurityCache", "read " + str + ",occur exception :" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public final boolean O0000O0o(String str, String str2) {
        String str3;
        try {
            String O000000o2 = EncryptionManager.O000000o(str);
            EncryptionManager encryptionManager = this.O00000Oo;
            if (str2 == null || str2.length() <= 0) {
                str3 = null;
            } else {
                EncryptionManager.O000000o O000000o3 = encryptionManager.O000000o(str2.getBytes("UTF-8"));
                if (O000000o3.O00000o0 != null) {
                    str3 = Base64.encodeToString(O000000o3.f4324O000000o, 2) + "]" + Base64.encodeToString(O000000o3.O00000Oo, 2) + "]" + Base64.encodeToString(O000000o3.O00000o0, 2);
                } else {
                    str3 = Base64.encodeToString(O000000o3.f4324O000000o, 2) + "]" + Base64.encodeToString(O000000o3.O00000Oo, 2);
                }
            }
            MMKV.O000000o("security.cache", "ox23.j3qk").O00000Oo(O000000o2, str3);
            gsy.O00000Oo("SecurityCache", String.format("write (%s,%s)=>(%s,%s)", str, str2, O000000o2, str3));
            return true;
        } catch (Exception e) {
            gsy.O00000Oo("SecurityCache", "write " + str + ",occur exception :" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
