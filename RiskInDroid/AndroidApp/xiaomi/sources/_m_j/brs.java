package _m_j;

import _m_j.brr;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.loc.t;
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

public final class brs {

    /* renamed from: O000000o  reason: collision with root package name */
    static String f13224O000000o;
    private static final String[] O00000Oo = {"arm64-v8a", "x86_64"};
    private static final String[] O00000o0 = {"arm", "x86"};

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        f13224O000000o = sb.toString();
    }

    public static brr O000000o() throws t {
        return new brr.O000000o("collection", "1.0", "AMap_collection_1.0").O000000o(new String[]{"com.amap.api.collection"}).O000000o();
    }

    public static String O000000o(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String O000000o(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    public static String O000000o(Context context) {
        String str;
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 28) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                Field declaredField = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                str = (String) declaredField.get(applicationInfo);
            } catch (Throwable th) {
                bsc.O000000o(th, "ut", "gct");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                    if (strArr2 != null && strArr2.length > 0) {
                        str = strArr2[0];
                    }
                    if (!TextUtils.isEmpty(str) && Arrays.asList(O00000Oo).contains(str)) {
                        String str2 = context.getApplicationInfo().nativeLibraryDir;
                        if (!TextUtils.isEmpty(str2)) {
                            if (Arrays.asList(O00000o0).contains(str2.substring(str2.lastIndexOf(File.separator) + 1)) && (strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length > 0) {
                                str = strArr[0];
                            }
                        }
                    }
                } catch (Throwable th2) {
                    bsc.O000000o(th2, "ut", "gct_p");
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

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0041 A[SYNTHETIC, Splitter:B:32:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x004b A[SYNTHETIC, Splitter:B:37:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0057 A[SYNTHETIC, Splitter:B:44:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0061 A[SYNTHETIC, Splitter:B:49:0x0061] */
    public static String O000000o(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    while (true) {
                        th = th.getCause();
                        if (th == null) {
                            break;
                        }
                        th.printStackTrace(printWriter);
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

    public static String O000000o(Map<String, String> map) {
        Object value;
        if (map.size() == 0) {
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
                    value = next.getValue();
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append((String) next.getKey());
                    stringBuffer.append("=");
                    value = next.getValue();
                }
                stringBuffer.append((String) value);
            }
        } catch (Throwable th) {
            bsc.O000000o(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static String O000000o(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static Method O000000o(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(O00000o0(str), clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void O000000o(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = "";
        String O00000oO = bwt.O00000oO(context);
        String O000000o2 = brp.O000000o(O00000oO);
        String O000000o3 = bwt.O000000o(context);
        try {
            if (jSONObject.has("info")) {
                str5 = jSONObject.getString("info");
                str4 = "???????????????????????????????????????\"" + str5 + "\"????????????????????????";
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
                    if (O000000o2.equals(string) || O000000o2.equals(str6)) {
                        str3 = "???????????????????????????????????????\"??????????????????????????????????????????\"????????????????????????";
                        gsy.O000000o(4, "authErrLog", f13224O000000o);
                        gsy.O000000o(4, "authErrLog", "                                   ??????????????????                                  ");
                        gsy.O000000o(4, "authErrLog", f13224O000000o);
                        O00000oo("SHA1Package:".concat(String.valueOf(O00000oO)));
                        O00000oo("key:".concat(String.valueOf(O000000o3)));
                        O00000oo("csid:".concat(String.valueOf(str)));
                        O00000oo("gsid:".concat(String.valueOf(str2)));
                        O00000oo("json:" + jSONObject.toString());
                        gsy.O000000o(4, "authErrLog", "                                                                               ");
                        gsy.O000000o(4, "authErrLog", str3);
                        gsy.O000000o(4, "authErrLog", f13224O000000o);
                    }
                } else if ("INVALID_USER_KEY".equals(str5)) {
                    if (jSONObject.has("key")) {
                        str6 = jSONObject.getString("key");
                    }
                    if (str6.length() > 0 && !O000000o3.equals(str6)) {
                        str4 = "????????????????????????????????????????????????????????????>?????????Key???????????????INVALID_USER_KEY????????????";
                    }
                }
            } catch (Throwable unused) {
            }
            str3 = str4;
        } catch (Throwable unused2) {
            str3 = str6;
        }
        gsy.O000000o(4, "authErrLog", f13224O000000o);
        gsy.O000000o(4, "authErrLog", "                                   ??????????????????                                  ");
        gsy.O000000o(4, "authErrLog", f13224O000000o);
        O00000oo("SHA1Package:".concat(String.valueOf(O00000oO)));
        O00000oo("key:".concat(String.valueOf(O000000o3)));
        O00000oo("csid:".concat(String.valueOf(str)));
        O00000oo("gsid:".concat(String.valueOf(str2)));
        O00000oo("json:" + jSONObject.toString());
        gsy.O000000o(4, "authErrLog", "                                                                               ");
        gsy.O000000o(4, "authErrLog", str3);
        gsy.O000000o(4, "authErrLog", f13224O000000o);
    }

    public static void O000000o(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b});
            byte b2 = b & 255;
            if (b2 < 255 && b2 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (b2 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            bsc.O000000o(e, "ut", "wFie");
        }
    }

    public static void O000000o(ByteArrayOutputStream byteArrayOutputStream, String str) {
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
            O000000o(byteArrayOutputStream, (byte) length, O000000o(str));
        }
    }

    public static boolean O000000o(Context context, String str) {
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

    public static boolean O000000o(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static brr O00000Oo() throws t {
        return new brr.O000000o("co", "1.0.0", "AMap_co_1.0.0").O000000o(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).O000000o();
    }

    public static String O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        String O00000o02 = bwx.O00000o0(O000000o(str));
        try {
            return ((char) ((O00000o02.length() % 26) + 65)) + O00000o02;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String O00000Oo(Map<String, String> map) {
        String str;
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            }
            str = sb.toString();
        } else {
            str = null;
        }
        return O00000o(str);
    }

    public static boolean O00000Oo(Context context) {
        return bsi.O000000o(context);
    }

    public static byte[] O00000Oo(byte[] bArr) {
        try {
            return O0000OOo(bArr);
        } catch (Throwable th) {
            bsc.O000000o(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String O00000o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : split) {
                stringBuffer.append(append);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            bsc.O000000o(th, "ut", "sPa");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A[SYNTHETIC, Splitter:B:28:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[SYNTHETIC, Splitter:B:35:0x005c] */
    static PublicKey O00000o() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bwx.O00000Oo("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
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

    public static byte[] O00000o(byte[] bArr) {
        try {
            return O0000OOo(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static String O00000o0(String str) {
        return str.length() < 2 ? "" : bwx.O000000o(str.substring(1));
    }

    public static byte[] O00000o0() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(bwx.O00000Oo(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            bsc.O000000o(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[SYNTHETIC, Splitter:B:31:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0060 A[SYNTHETIC, Splitter:B:36:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0067 A[SYNTHETIC, Splitter:B:41:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0071 A[SYNTHETIC, Splitter:B:46:0x0071] */
    public static byte[] O00000o0(byte[] bArr) {
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
                        bsc.O000000o(th, "ut", "zp1");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bsc.O000000o(th, "ut", "zp");
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
                    bsc.O000000o(th4, "ut", "zp2");
                }
            } catch (Throwable th5) {
                th = th5;
                zipOutputStream = null;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th6) {
                        bsc.O000000o(th6, "ut", "zp1");
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th7) {
                        bsc.O000000o(th7, "ut", "zp2");
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

    static String O00000oO(byte[] bArr) {
        try {
            return O0000O0o(bArr);
        } catch (Throwable th) {
            bsc.O000000o(th, "ut", "h2s");
            return null;
        }
    }

    public static byte[] O00000oO(String str) {
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

    static String O00000oo(byte[] bArr) {
        try {
            return O0000O0o(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static void O00000oo(String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String substring = str.substring(0, 78);
            gsy.O000000o(4, "authErrLog", "|" + substring + "|");
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        gsy.O000000o(4, "authErrLog", sb.toString());
    }

    public static String O0000O0o(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            sb.append(hexString);
        }
        return sb.toString();
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
    private static byte[] O0000OOo(byte[] bArr) throws IOException, Throwable {
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
}
