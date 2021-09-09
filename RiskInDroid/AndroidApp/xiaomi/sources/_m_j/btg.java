package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.loc.t;
import java.io.ByteArrayOutputStream;

public final class btg {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f13267O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;

    public btg(Context context, String str, String str2, String str3) throws t {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new t("无效的参数 - IllegalArgumentException");
        }
        this.f13267O000000o = context.getApplicationContext();
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000Oo = str3;
    }

    public final void O000000o(String str) throws t {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new t("无效的参数 - IllegalArgumentException");
        }
        this.O00000oO = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0097, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b4, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9 A[SYNTHETIC, Splitter:B:34:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af A[SYNTHETIC, Splitter:B:38:0x00af] */
    public final byte[] O000000o() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        byte[] bArr;
        byte[] bArr2 = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                brs.O000000o(byteArrayOutputStream, this.O00000o0);
                brs.O000000o(byteArrayOutputStream, this.O00000o);
                brs.O000000o(byteArrayOutputStream, this.O00000Oo);
                brs.O000000o(byteArrayOutputStream, String.valueOf(bww.O0000o(this.f13267O000000o)));
                i = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable th) {
            }
            byteArrayOutputStream.write(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
            if (TextUtils.isEmpty(this.O00000oO)) {
                bArr = new byte[]{0, 0};
            } else {
                byte[] O000000o2 = brs.O000000o(this.O00000oO);
                if (O000000o2 == null) {
                    bArr = new byte[]{0, 0};
                } else {
                    int length = O000000o2.length;
                    bArr = new byte[]{(byte) (length / 256), (byte) (length % 256)};
                }
            }
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(brs.O000000o(this.O00000oO));
            bArr2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                bsf.O00000Oo(th, "se", "tds");
                if (byteArrayOutputStream2 != null) {
                }
                return bArr2;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        }
        return bArr2;
    }
}
