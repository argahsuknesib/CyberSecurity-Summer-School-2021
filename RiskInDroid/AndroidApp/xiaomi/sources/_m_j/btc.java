package _m_j;

import _m_j.bss;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

public final class btc {
    private static void O000000o(bss bss, List<String> list) {
        if (bss != null) {
            try {
                for (String O00000o0 : list) {
                    bss.O00000o0(O00000o0);
                }
                bss.close();
            } catch (Throwable th) {
                bsf.O00000Oo(th, "ofm", "dlo");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b3, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae A[SYNTHETIC, Splitter:B:54:0x00ae] */
    public static void O000000o(btb btb) {
        bss bss;
        bss bss2 = null;
        try {
            if (btb.O00000oo.O00000o0()) {
                btb.O00000oo.O000000o(true);
                bss = bss.O000000o(new File(btb.f13260O000000o), btb.O00000Oo);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] O000000o2 = O000000o(bss, btb, arrayList);
                    if (O000000o2 != null) {
                        if (O000000o2.length != 0) {
                            bse bse = new bse(O000000o2, btb.O00000o0);
                            bsw.O000000o();
                            JSONObject jSONObject = new JSONObject(new String(bsw.O00000Oo(bse)));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                bss2 = bss;
                            } else {
                                if (!(btb.O00000oo == null || O000000o2 == null)) {
                                    btb.O00000oo.O000000o(O000000o2.length);
                                }
                                if (btb.O00000oo.O00000Oo() < Integer.MAX_VALUE) {
                                    O000000o(bss, arrayList);
                                } else {
                                    bss.O00000o0();
                                }
                            }
                        }
                    }
                    if (bss != null) {
                        try {
                            bss.close();
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                }
            }
            if (bss2 != null) {
                try {
                    bss2.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                bsf.O00000Oo(th, "leg", "uts");
                if (bss2 != null) {
                    try {
                        bss2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                bss = bss2;
                if (bss != null) {
                }
                throw th;
            }
        }
    }

    private static boolean O000000o(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            bsf.O00000Oo(th, "leg", "fet");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061 A[SYNTHETIC, Splitter:B:30:0x0061] */
    public static void O000000o(String str, byte[] bArr, btb btb) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        bss bss;
        OutputStream outputStream = null;
        try {
            if (!O000000o(btb.f13260O000000o, str)) {
                File file = new File(btb.f13260O000000o);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bss = bss.O000000o(file, btb.O00000Oo);
                try {
                    bss.O000000o(btb.O00000o);
                    byte[] O00000Oo = btb.O00000oO.O00000Oo(bArr);
                    bss.O000000o O00000Oo2 = bss.O00000Oo(str);
                    outputStream = O00000Oo2.O000000o();
                    outputStream.write(O00000Oo);
                    O00000Oo2.O00000Oo();
                    bss.O00000Oo();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    if (bss != null) {
                        try {
                            bss.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (bss != null) {
                        try {
                            bss.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bss = null;
            if (outputStream != null) {
            }
            if (bss != null) {
            }
            throw th;
        }
    }

    private static byte[] O000000o(bss bss, btb btb, List<String> list) {
        try {
            File file = bss.O00000Oo;
            if (file != null && file.exists()) {
                int i = 0;
                for (String str : file.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] O000000o2 = bti.O000000o(bss, str2);
                        i += O000000o2.length;
                        list.add(str2);
                        if (i > btb.O00000oo.O00000Oo()) {
                            break;
                        }
                        btb.O0000O0o.O00000Oo(O000000o2);
                    }
                }
                return btb.O0000O0o.O000000o();
            }
        } catch (Throwable th) {
            bsf.O00000Oo(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
