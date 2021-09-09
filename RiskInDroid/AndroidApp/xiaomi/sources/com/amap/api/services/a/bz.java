package com.amap.api.services.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.services.a.by;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

public class bz {

    /* renamed from: a  reason: collision with root package name */
    static String f3359a;
    private static final String[] b = {"arm64-v8a", "x86_64"};
    private static final String[] c = {"arm", "x86"};

    public static Method a(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(c(str), clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        f3359a = sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    public static String a(Context context) {
        String str;
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 28) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                Field declaredField = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                str = (String) declaredField.get(applicationInfo);
            } catch (Throwable th) {
                ci.a(th, "ut", "gct");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                    if (strArr2 != null && strArr2.length > 0) {
                        str = strArr2[0];
                    }
                    if (!TextUtils.isEmpty(str) && Arrays.asList(b).contains(str)) {
                        String str2 = context.getApplicationInfo().nativeLibraryDir;
                        if (!TextUtils.isEmpty(str2)) {
                            if (Arrays.asList(c).contains(str2.substring(str2.lastIndexOf(File.separator) + 1)) && (strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length > 0) {
                                str = strArr[0];
                            }
                        }
                    }
                } catch (Throwable th2) {
                    ci.a(th2, "ut", "gct_p");
                }
            }
            return !TextUtils.isEmpty(str) ? Build.CPU_ABI : str;
        }
        str = "";
        if (Build.VERSION.SDK_INT >= 28) {
        }
        if (!TextUtils.isEmpty(str)) {
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static by a() throws bo {
        return new by.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static by b() throws bo {
        return new by.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int length = str.length();
            if (length > 255) {
                length = 255;
            }
            a(byteArrayOutputStream, (byte) length, a(str));
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, byte b2, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b2});
            byte b3 = b2 & 255;
            if (b3 < 255 && b3 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (b3 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            ci.a(e, "ut", "wFie");
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String c2 = bu.c(a(str));
        try {
            return ((char) ((c2.length() % 26) + 65)) + c2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        if (str.length() < 2) {
            return "";
        }
        return bu.a(str.substring(1));
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] c() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(bu.b(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            ci.a(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0045 A[SYNTHETIC, Splitter:B:31:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x004f A[SYNTHETIC, Splitter:B:36:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005b A[SYNTHETIC, Splitter:B:43:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0065 A[SYNTHETIC, Splitter:B:48:0x0065] */
    public static String a(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                        cause.printStackTrace(printWriter);
                    }
                    String obj = stringWriter.toString();
                    try {
                        stringWriter.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        printWriter.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return obj;
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        th.printStackTrace();
                        if (stringWriter != null) {
                        }
                        if (printWriter != null) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (stringWriter != null) {
                        }
                        if (printWriter != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                printWriter = null;
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            stringWriter = null;
            printWriter = null;
            if (stringWriter != null) {
            }
            if (printWriter != null) {
            }
            throw th;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        try {
            for (Map.Entry next : map.entrySet()) {
                if (z) {
                    z = false;
                    stringBuffer.append((String) next.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) next.getValue());
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append((String) next.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) next.getValue());
                }
            }
        } catch (Throwable th) {
            ci.a(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static byte[] b(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            ci.a(th, "ut", "gZp");
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[SYNTHETIC, Splitter:B:31:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0060 A[SYNTHETIC, Splitter:B:36:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0067 A[SYNTHETIC, Splitter:B:41:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0071 A[SYNTHETIC, Splitter:B:46:0x0071] */
    public static byte[] c(byte[] bArr) {
        ZipOutputStream zipOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry("log"));
                    zipOutputStream.write(bArr);
                    zipOutputStream.closeEntry();
                    zipOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th) {
                        ci.a(th, "ut", "zp1");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ci.a(th, "ut", "zp");
                        if (zipOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        return bArr2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (zipOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    ci.a(th4, "ut", "zp2");
                }
            } catch (Throwable th5) {
                th = th5;
                zipOutputStream = null;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th6) {
                        ci.a(th6, "ut", "zp1");
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th7) {
                        ci.a(th7, "ut", "zp2");
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
            zipOutputStream = null;
            if (zipOutputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A[SYNTHETIC, Splitter:B:28:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[SYNTHETIC, Splitter:B:35:0x005c] */
    static PublicKey d() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bu.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                KeyFactory instance2 = KeyFactory.getInstance("RSA");
                Certificate generateCertificate = instance.generateCertificate(byteArrayInputStream);
                if (generateCertificate != null) {
                    if (instance2 != null) {
                        PublicKey generatePublic = instance2.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return generatePublic;
                    }
                }
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (byteArrayInputStream != null) {
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    if (byteArrayInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] d(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    static String e(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            ci.a(th, "ut", "h2s");
            return null;
        }
    }

    static String f(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String g(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] d(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(String.valueOf(str));
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0038 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0040 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    private static byte[] h(byte[] bArr) throws IOException, Throwable {
        ? r1;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        GZIPOutputStream gZIPOutputStream3 = null;
        if (bArr == null) {
            return null;
        }
        try {
            ? byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream2 = byteArrayOutputStream;
                    gZIPOutputStream3 = gZIPOutputStream;
                    r1 = gZIPOutputStream2;
                    if (gZIPOutputStream3 != null) {
                    }
                    if (r1 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = byteArrayOutputStream;
                if (gZIPOutputStream3 != null) {
                }
                if (r1 != 0) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r1 = 0;
            if (gZIPOutputStream3 != null) {
                gZIPOutputStream3.close();
            }
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = "";
        String e = bp.e(context);
        String a2 = bw.a(e);
        String a3 = bp.a(context);
        try {
            if (jSONObject.has("info")) {
                str5 = jSONObject.getString("info");
                str4 = "请在高德开放平台官网中搜索\"" + str5 + "\"相关内容进行解决";
            } else {
                str5 = str6;
                str4 = str5;
            }
            try {
                if ("INVALID_USER_SCODE".equals(str5)) {
                    String string = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : str6;
                    if (jSONObject.has("sec_code_debug")) {
                        str6 = jSONObject.getString("sec_code_debug");
                    }
                    if (a2.equals(string) || a2.equals(str6)) {
                        str3 = "请在高德开放平台官网中搜索\"请求内容过长导致业务调用失败\"相关内容进行解决";
                        f(f3359a);
                        f("                                   鉴权错误信息                                  ");
                        f(f3359a);
                        e("SHA1Package:".concat(String.valueOf(e)));
                        e("key:".concat(String.valueOf(a3)));
                        e("csid:".concat(String.valueOf(str)));
                        e("gsid:".concat(String.valueOf(str2)));
                        e("json:" + jSONObject.toString());
                        f("                                                                               ");
                        f(str3);
                        f(f3359a);
                    }
                } else if ("INVALID_USER_KEY".equals(str5)) {
                    if (jSONObject.has("key")) {
                        str6 = jSONObject.getString("key");
                    }
                    if (str6.length() > 0 && !a3.equals(str6)) {
                        str4 = "请在高德开放平台官网上发起技术咨询工单—>账号与Key问题，咨询INVALID_USER_KEY如何解决";
                    }
                }
            } catch (Throwable unused) {
            }
            str3 = str4;
        } catch (Throwable unused2) {
            str3 = str6;
        }
        f(f3359a);
        f("                                   鉴权错误信息                                  ");
        f(f3359a);
        e("SHA1Package:".concat(String.valueOf(e)));
        e("key:".concat(String.valueOf(a3)));
        e("csid:".concat(String.valueOf(str)));
        e("gsid:".concat(String.valueOf(str2)));
        e("json:" + jSONObject.toString());
        f("                                                                               ");
        f(str3);
        f(f3359a);
    }

    static void e(String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String substring = str.substring(0, 78);
            f("|" + substring + "|");
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        f(sb.toString());
    }

    private static void f(String str) {
        Log.i("authErrLog", str);
    }
}
