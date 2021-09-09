package _m_j;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

public final class bwv {

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13365O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        String O00000oO;
        String O00000oo;
        String O0000O0o;
        String O0000OOo;
        String O0000Oo;
        String O0000Oo0;
        String O0000OoO;
        String O0000Ooo;
        String O0000o;
        String O0000o0;
        String O0000o00;
        String O0000o0O;
        String O0000o0o;
        String O0000oO;
        String O0000oO0;
        String O0000oOO;
        String O0000oOo;
        String O0000oo;
        String O0000oo0;
        String O0000ooO;
        String O0000ooo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public static String O000000o() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!bwt.O000000o()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            bsc.O000000o(th, "CI", "TS");
            return null;
        }
    }

    public static String O000000o(Context context, String str, String str2) {
        try {
            String O00000oO = bwt.O00000oO(context);
            return brp.O000000o(O00000oO + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            bsc.O000000o(th, "CI", "Sco");
            return null;
        }
    }

    private static void O000000o(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            brs.O000000o(byteArrayOutputStream, str.getBytes().length > 255 ? -1 : (byte) str.getBytes().length, brs.O000000o(str));
        } else {
            brs.O000000o(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cb A[SYNTHETIC, Splitter:B:22:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d7 A[SYNTHETIC, Splitter:B:29:0x00d7] */
    private static byte[] O000000o(O000000o o000000o) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                O000000o(byteArrayOutputStream, o000000o.f13365O000000o);
                O000000o(byteArrayOutputStream, o000000o.O00000Oo);
                O000000o(byteArrayOutputStream, o000000o.O00000o0);
                O000000o(byteArrayOutputStream, o000000o.O00000o);
                O000000o(byteArrayOutputStream, o000000o.O00000oO);
                O000000o(byteArrayOutputStream, o000000o.O00000oo);
                O000000o(byteArrayOutputStream, o000000o.O0000O0o);
                O000000o(byteArrayOutputStream, o000000o.O0000OOo);
                O000000o(byteArrayOutputStream, o000000o.O0000Oo0);
                O000000o(byteArrayOutputStream, o000000o.O0000Oo);
                O000000o(byteArrayOutputStream, o000000o.O0000OoO);
                O000000o(byteArrayOutputStream, o000000o.O0000Ooo);
                O000000o(byteArrayOutputStream, o000000o.O0000o00);
                O000000o(byteArrayOutputStream, o000000o.O0000o0);
                O000000o(byteArrayOutputStream, o000000o.O0000o0O);
                O000000o(byteArrayOutputStream, o000000o.O0000o0o);
                O000000o(byteArrayOutputStream, o000000o.O0000o);
                O000000o(byteArrayOutputStream, o000000o.O0000oO0);
                O000000o(byteArrayOutputStream, o000000o.O0000oO);
                O000000o(byteArrayOutputStream, o000000o.O0000oOO);
                O000000o(byteArrayOutputStream, o000000o.O0000oOo);
                O000000o(byteArrayOutputStream, o000000o.O0000oo0);
                O000000o(byteArrayOutputStream, o000000o.O0000oo);
                O000000o(byteArrayOutputStream, o000000o.O0000ooO);
                O000000o(byteArrayOutputStream, o000000o.O0000ooo);
                byte[] O00000Oo = brs.O00000Oo(byteArrayOutputStream.toByteArray());
                PublicKey O00000o = brs.O00000o();
                if (O00000Oo.length > 117) {
                    byte[] bArr2 = new byte[117];
                    System.arraycopy(O00000Oo, 0, bArr2, 0, 117);
                    byte[] O000000o2 = bwx.O000000o(bArr2, O00000o);
                    bArr = new byte[((O00000Oo.length + NotificationCompat.FLAG_HIGH_PRIORITY) - 117)];
                    System.arraycopy(O000000o2, 0, bArr, 0, NotificationCompat.FLAG_HIGH_PRIORITY);
                    System.arraycopy(O00000Oo, 117, bArr, NotificationCompat.FLAG_HIGH_PRIORITY, O00000Oo.length - 117);
                } else {
                    bArr = bwx.O000000o(O00000Oo, O00000o);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                try {
                    bsc.O000000o(th, "CI", "gzx");
                    if (byteArrayOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] O000000o(Context context, boolean z) {
        try {
            O000000o o000000o = new O000000o((byte) 0);
            o000000o.f13365O000000o = bww.O0000oOo(context);
            o000000o.O00000Oo = bww.O0000Ooo(context);
            String O0000O0o = bww.O0000O0o(context);
            if (O0000O0o == null) {
                O0000O0o = "";
            }
            o000000o.O00000o0 = O0000O0o;
            o000000o.O00000o = bwt.O00000o0(context);
            o000000o.O00000oO = Build.MODEL;
            o000000o.O00000oo = Build.MANUFACTURER;
            o000000o.O0000O0o = Build.DEVICE;
            o000000o.O0000OOo = bwt.O00000Oo(context);
            o000000o.O0000Oo0 = bwt.O00000o(context);
            o000000o.O0000Oo = String.valueOf(Build.VERSION.SDK_INT);
            o000000o.O0000OoO = bww.O0000ooO(context);
            o000000o.O0000Ooo = bww.O0000oOO(context);
            StringBuilder sb = new StringBuilder();
            sb.append(bww.O0000o(context));
            o000000o.O0000o00 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(bww.O0000o0o(context));
            o000000o.O0000o0 = sb2.toString();
            o000000o.O0000o0O = bww.O00oOooO(context);
            o000000o.O0000o0o = bww.O0000o0O(context);
            if (z) {
                o000000o.O0000o = "";
            } else {
                o000000o.O0000o = bww.O0000OoO(context);
            }
            if (z) {
                o000000o.O0000oO0 = "";
            } else {
                o000000o.O0000oO0 = bww.O0000Oo(context);
            }
            if (z) {
                o000000o.O0000oO = "";
                o000000o.O0000oOO = "";
            } else {
                String[] O0000o00 = bww.O0000o00(context);
                o000000o.O0000oO = O0000o00[0];
                o000000o.O0000oOO = O0000o00[1];
            }
            o000000o.O0000oo = bww.O000000o();
            String O000000o2 = bww.O000000o(context);
            if (!TextUtils.isEmpty(O000000o2)) {
                o000000o.O0000ooO = O000000o2;
            } else {
                o000000o.O0000ooO = "";
            }
            o000000o.O0000ooo = "aid=" + bww.O0000Oo0(context) + "|serial=" + bww.O0000OOo(context) + "|storage=" + bww.O00000o() + "|ram=" + bww.O0000ooo(context) + "|arch=" + bww.O00000oO();
            String O00000Oo = bww.O00000Oo();
            if (!TextUtils.isEmpty(O00000Oo)) {
                o000000o.O0000ooo += "|adiuExtras=" + O00000Oo;
            }
            String O000000o3 = bww.O000000o(context, ",");
            if (!TextUtils.isEmpty(O000000o3)) {
                o000000o.O0000ooo += "|multiImeis=" + O000000o3;
            }
            String O0000oo = bww.O0000oo(context);
            if (!TextUtils.isEmpty(O0000oo)) {
                o000000o.O0000ooo += "|meid=" + O0000oo;
            }
            return O000000o(o000000o);
        } catch (Throwable th) {
            bsc.O000000o(th, "CI", "gz");
            return null;
        }
    }
}
