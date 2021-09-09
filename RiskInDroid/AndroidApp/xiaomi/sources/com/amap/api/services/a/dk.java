package com.amap.api.services.a;

import com.amap.api.services.a.cw;
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

public class dk {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059 A[SYNTHETIC, Splitter:B:25:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[SYNTHETIC, Splitter:B:30:0x0063] */
    public static void a(String str, byte[] bArr, dj djVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        cw cwVar;
        OutputStream outputStream = null;
        try {
            if (!a(djVar.f3401a, str)) {
                File file = new File(djVar.f3401a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                cwVar = cw.a(file, 1, 1, djVar.b);
                try {
                    cwVar.a(djVar.d);
                    byte[] b = djVar.e.b(bArr);
                    cw.a b2 = cwVar.b(str);
                    outputStream = b2.a(0);
                    outputStream.write(b);
                    b2.a();
                    cwVar.c();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    if (cwVar != null) {
                        try {
                            cwVar.close();
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
                    if (cwVar != null) {
                        try {
                            cwVar.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            cwVar = null;
            if (outputStream != null) {
            }
            if (cwVar != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b A[SYNTHETIC, Splitter:B:44:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a6 A[SYNTHETIC, Splitter:B:49:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    public static void a(dj djVar) {
        cw cwVar = null;
        try {
            if (djVar.f.c()) {
                djVar.f.a(true);
                cw cwVar2 = cw.a(new File(djVar.f3401a), 1, 1, djVar.b);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] a2 = a(cwVar2, djVar, arrayList);
                    if (a2 != null) {
                        if (a2.length != 0) {
                            JSONObject jSONObject = new JSONObject(new String(db.a().b(new ck(a2, djVar.c))));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                cwVar = cwVar2;
                            } else {
                                if (!(djVar.f == null || a2 == null)) {
                                    djVar.f.a(a2.length);
                                }
                                if (djVar.f.b() < Integer.MAX_VALUE) {
                                    a(cwVar2, arrayList);
                                } else {
                                    a(cwVar2);
                                }
                            }
                        }
                    }
                    if (cwVar2 != null) {
                        try {
                            cwVar2.close();
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cwVar2 != null) {
                        try {
                            cwVar2.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (cwVar != null) {
                try {
                    cwVar.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        } catch (Throwable th5) {
            th = th5;
            cl.c(th, "leg", "uts");
            if (cwVar == null) {
            }
        }
    }

    private static byte[] a(cw cwVar, dj djVar, List<String> list) {
        try {
            File b = cwVar.b();
            if (b != null && b.exists()) {
                int i = 0;
                for (String str : b.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a2 = dp.a(cwVar, str2, false);
                        i += a2.length;
                        list.add(str2);
                        if (i > djVar.f.b()) {
                            break;
                        }
                        djVar.g.b(a2);
                    }
                }
                return djVar.g.a();
            }
        } catch (Throwable th) {
            cl.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(cw cwVar) {
        if (cwVar != null) {
            try {
                cwVar.d();
            } catch (Throwable th) {
                cl.c(th, "ofm", "dlo");
            }
        }
    }

    private static void a(cw cwVar, List<String> list) {
        if (cwVar != null) {
            try {
                for (String c : list) {
                    cwVar.c(c);
                }
                cwVar.close();
            } catch (Throwable th) {
                cl.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            cl.c(th, "leg", "fet");
            return false;
        }
    }
}
