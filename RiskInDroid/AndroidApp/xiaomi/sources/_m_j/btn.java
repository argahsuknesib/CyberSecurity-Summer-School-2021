package _m_j;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

public final class btn extends btp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13275O000000o = 13;
    public static int O00000Oo = 6;
    private Context O00000oO;

    public btn(Context context, btp btp) {
        super(btp);
        this.O00000oO = context;
    }

    private static byte[] O000000o(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            brs.O000000o(byteArrayOutputStream, "1.2." + f13275O000000o + "." + O00000Oo);
            brs.O000000o(byteArrayOutputStream, "Android");
            brs.O000000o(byteArrayOutputStream, bww.O0000oOo(context));
            brs.O000000o(byteArrayOutputStream, bww.O0000Ooo(context));
            brs.O000000o(byteArrayOutputStream, bww.O0000O0o(context));
            brs.O000000o(byteArrayOutputStream, Build.MANUFACTURER);
            brs.O000000o(byteArrayOutputStream, Build.MODEL);
            brs.O000000o(byteArrayOutputStream, Build.DEVICE);
            brs.O000000o(byteArrayOutputStream, bww.O0000ooO(context));
            brs.O000000o(byteArrayOutputStream, bwt.O00000o0(context));
            brs.O000000o(byteArrayOutputStream, bwt.O00000o(context));
            brs.O000000o(byteArrayOutputStream, bwt.O00000oo(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
        throw th;
    }

    /* access modifiers changed from: protected */
    public final byte[] O000000o(byte[] bArr) {
        byte[] O000000o2 = O000000o(this.O00000oO);
        byte[] bArr2 = new byte[(O000000o2.length + bArr.length)];
        System.arraycopy(O000000o2, 0, bArr2, 0, O000000o2.length);
        System.arraycopy(bArr, 0, bArr2, O000000o2.length, bArr.length);
        return bArr2;
    }
}
