package com.amap.api.services.a;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class dc extends df {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3394a;
    protected by b;

    public abstract byte[] b();

    public abstract byte[] c();

    /* access modifiers changed from: protected */
    public String f() {
        return "2.1";
    }

    public boolean g() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return false;
    }

    public dc(Context context, by byVar) {
        if (context != null) {
            this.f3394a = context.getApplicationContext();
        }
        this.b = byVar;
    }

    public Map<String, String> d() {
        String f = bp.f(this.f3394a);
        String a2 = bs.a();
        String a3 = bs.a(this.f3394a, a2, "key=".concat(String.valueOf(f)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    public final byte[] h() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(r());
            byteArrayOutputStream.write(s());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            ci.a(th2, "bre", "geb");
            return null;
        }
        throw th;
    }

    private byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bz.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            ci.a(th2, "bre", "gbh");
            return null;
        }
        throw th;
    }

    public byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (g()) {
                byte[] a2 = bs.a(this.f3394a, l());
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a3 = bz.a(f());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = bz.a(k());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a4));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            ci.a(th2, "bre", "gred");
        }
        throw th;
        return new byte[]{0};
    }

    public String k() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.c(), this.b.a());
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    private byte[] r() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] b2 = b();
            if (b2 != null) {
                if (b2.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(b2));
                    byteArrayOutputStream.write(b2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ci.a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ci.a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ci.a(th3, "bre", "grrd");
        }
        throw th;
        return new byte[]{0};
    }

    private byte[] s() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c = c();
            if (c != null) {
                if (c.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a2 = bs.a(this.f3394a, c);
                    byteArrayOutputStream.write(a(a2));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ci.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ci.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ci.a(th3, "bre", "gred");
        }
        throw th;
        return new byte[]{0};
    }
}
