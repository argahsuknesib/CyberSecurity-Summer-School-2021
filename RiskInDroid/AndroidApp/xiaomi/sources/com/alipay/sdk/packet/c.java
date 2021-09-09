package com.alipay.sdk.packet;

import com.alipay.sdk.cons.a;
import com.alipay.sdk.encrypt.b;
import com.alipay.sdk.encrypt.d;
import com.alipay.sdk.encrypt.e;
import com.alipay.sdk.util.l;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3196a;
    private String b = l.a(24);

    public c(boolean z) {
        this.f3196a = z;
    }

    public final d a(b bVar, boolean z, String str) {
        byte[] bArr;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.a().getBytes();
        byte[] bytes2 = bVar.b().getBytes();
        if (z) {
            try {
                bytes2 = b.a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        if (this.f3196a) {
            bArr = a(bytes, a(this.b, a.e), a(this.b, bytes2, str));
        } else {
            bArr = a(bytes, bytes2);
        }
        return new d(z, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067 A[SYNTHETIC, Splitter:B:29:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0079 A[SYNTHETIC, Splitter:B:41:0x0079] */
    public final b a(d dVar, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        String str3;
        try {
            byteArrayInputStream = new ByteArrayInputStream(dVar.b());
            try {
                byte[] bArr = new byte[5];
                byteArrayInputStream.read(bArr);
                byte[] bArr2 = new byte[a(new String(bArr))];
                byteArrayInputStream.read(bArr2);
                str3 = new String(bArr2);
            } catch (Exception e) {
                e = e;
                str3 = null;
                try {
                    com.alipay.sdk.util.c.a(e);
                    if (byteArrayInputStream != null) {
                    }
                    str2 = null;
                    if (str3 == null) {
                    }
                    return new b(str3, str2);
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            try {
                byte[] bArr3 = new byte[5];
                byteArrayInputStream.read(bArr3);
                int a2 = a(new String(bArr3));
                if (a2 > 0) {
                    byte[] bArr4 = new byte[a2];
                    byteArrayInputStream.read(bArr4);
                    if (this.f3196a) {
                        bArr4 = b(this.b, bArr4, str);
                    }
                    if (dVar.a()) {
                        bArr4 = b.b(bArr4);
                    }
                    str2 = new String(bArr4);
                } else {
                    str2 = null;
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception e2) {
                e = e2;
                com.alipay.sdk.util.c.a(e);
                if (byteArrayInputStream != null) {
                }
                str2 = null;
                if (str3 == null) {
                }
                return new b(str3, str2);
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayInputStream = null;
            str3 = null;
            com.alipay.sdk.util.c.a(e);
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused3) {
                }
            }
            str2 = null;
            if (str3 == null) {
            }
            return new b(str3, str2);
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
            }
            throw th;
        }
        if (str3 == null || str2 != null) {
            return new b(str3, str2);
        }
        return null;
    }

    private static byte[] a(String str, String str2) {
        return d.a(str, str2);
    }

    private static byte[] a(String str, byte[] bArr, String str2) {
        return e.a(str, bArr, str2);
    }

    private static byte[] b(String str, byte[] bArr, String str2) {
        return e.b(str, bArr, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
        if (r2 == null) goto L_0x0054;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A[SYNTHETIC, Splitter:B:29:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0058 A[SYNTHETIC, Splitter:B:37:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005f A[SYNTHETIC, Splitter:B:41:0x005f] */
    private static byte[] a(byte[]... bArr) {
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } catch (Exception e) {
                e = e;
                dataOutputStream = null;
                try {
                    com.alipay.sdk.util.c.a(e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                throw th;
            }
            try {
                for (byte[] bArr3 : bArr) {
                    dataOutputStream.write(a(bArr3.length).getBytes());
                    dataOutputStream.write(bArr3);
                }
                dataOutputStream.flush();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                com.alipay.sdk.util.c.a(e);
                if (byteArrayOutputStream != null) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            com.alipay.sdk.util.c.a(e);
            if (byteArrayOutputStream != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (dataOutputStream != null) {
            }
            throw th;
        }
        try {
            dataOutputStream.close();
        } catch (Exception unused4) {
        }
        return bArr2;
    }

    private static String a(int i) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
    }

    private static int a(String str) {
        return Integer.parseInt(str);
    }
}
