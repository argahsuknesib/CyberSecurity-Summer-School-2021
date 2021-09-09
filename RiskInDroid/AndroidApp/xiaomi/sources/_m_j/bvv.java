package _m_j;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public final class bvv extends bsx {
    Map<String, String> O00000oo = null;
    String O0000O0o = "";
    String O0000OOo = "";
    byte[] O0000Oo = null;
    byte[] O0000Oo0 = null;
    boolean O0000OoO = false;
    String O0000Ooo = null;
    boolean O0000o0 = false;
    Map<String, String> O0000o00 = null;

    public bvv(Context context, brr brr) {
        super(context, brr);
    }

    public final Map<String, String> O000000o() {
        return this.O00000oo;
    }

    public final Map<String, String> O00000Oo() {
        return this.O0000o00;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[SYNTHETIC, Splitter:B:22:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003a A[SYNTHETIC, Splitter:B:27:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    public final void O00000Oo(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(O000000o(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            this.O0000Oo = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            if (byteArrayOutputStream == null) {
            }
        }
    }

    public final String O00000o0() {
        return this.O0000OOo;
    }

    public final boolean O00000oO() {
        return this.O0000OoO;
    }

    public final String O00000oo() {
        return this.O0000Ooo;
    }

    public final byte[] O0000OOo() {
        return this.O0000Oo0;
    }

    /* access modifiers changed from: protected */
    public final boolean O0000Oo() {
        return this.O0000o0;
    }

    public final byte[] O0000Oo0() {
        return this.O0000Oo;
    }

    /* access modifiers changed from: protected */
    public final String O0000OoO() {
        return this.O0000O0o;
    }
}
