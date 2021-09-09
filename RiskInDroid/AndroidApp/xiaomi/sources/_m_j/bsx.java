package _m_j;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class bsx extends bsz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f13255O000000o;
    protected brr O00000Oo;

    public bsx(Context context, brr brr) {
        if (context != null) {
            this.f13255O000000o = context.getApplicationContext();
        }
        this.O00000Oo = brr;
    }

    protected static byte[] O000000o(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    private byte[] O0000o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O0000Oo0 = O0000Oo0();
            if (O0000Oo0 != null) {
                if (O0000Oo0.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] O000000o2 = bwx.O000000o(O0000Oo0);
                    byteArrayOutputStream.write(O000000o(O000000o2));
                    byteArrayOutputStream.write(O000000o2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        bsc.O000000o(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                bsc.O000000o(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            bsc.O000000o(th3, "bre", "gred");
        }
        throw th;
        return new byte[]{0};
    }

    private static byte[] O0000o0() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(brs.O000000o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                bsc.O000000o(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            bsc.O000000o(th2, "bre", "gbh");
            return null;
        }
        throw th;
    }

    private byte[] O0000o0O() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (O00000oO()) {
                byte[] O000000o2 = bwv.O000000o(this.f13255O000000o, O0000Oo());
                byteArrayOutputStream.write(O000000o(O000000o2));
                byteArrayOutputStream.write(O000000o2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] O000000o3 = brs.O000000o(O0000O0o());
            if (O000000o3 == null || O000000o3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(O000000o(O000000o3));
                byteArrayOutputStream.write(O000000o3);
            }
            byte[] O000000o4 = brs.O000000o(O00000oo());
            if (O000000o4 == null || O000000o4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(O000000o(O000000o4));
                byteArrayOutputStream.write(O000000o4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                bsc.O000000o(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            bsc.O000000o(th2, "bre", "gred");
        }
        throw th;
        return new byte[]{0};
    }

    private byte[] O0000o0o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O0000OOo = O0000OOo();
            if (O0000OOo != null) {
                if (O0000OOo.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(O000000o(O0000OOo));
                    byteArrayOutputStream.write(O0000OOo);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        bsc.O000000o(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                bsc.O000000o(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            bsc.O000000o(th3, "bre", "grrd");
        }
        throw th;
        return new byte[]{0};
    }

    public Map<String, String> O00000Oo() {
        String O00000oo = bwt.O00000oo(this.f13255O000000o);
        String O000000o2 = bwv.O000000o();
        String O000000o3 = bwv.O000000o(this.f13255O000000o, O000000o2, "key=".concat(String.valueOf(O00000oo)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", O000000o2);
        hashMap.put("key", O00000oo);
        hashMap.put("scode", O000000o3);
        return hashMap;
    }

    public final byte[] O00000o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(O0000o0());
            byteArrayOutputStream.write(O0000o0O());
            byteArrayOutputStream.write(O0000o0o());
            byteArrayOutputStream.write(O0000o());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                bsc.O000000o(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            bsc.O000000o(th2, "bre", "geb");
            return null;
        }
        throw th;
    }

    public boolean O00000oO() {
        return true;
    }

    public String O00000oo() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.O00000Oo.O00000Oo(), this.O00000Oo.O000000o());
    }

    /* access modifiers changed from: protected */
    public String O0000O0o() {
        return "2.1";
    }

    public abstract byte[] O0000OOo();

    /* access modifiers changed from: protected */
    public boolean O0000Oo() {
        return false;
    }

    public abstract byte[] O0000Oo0();
}
