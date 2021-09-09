package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class dif {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, String> f14664O000000o = null;
    private static boolean O00000Oo = false;

    public static String O000000o(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (did.O000000o(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static String O000000o() {
        return O000000o(System.currentTimeMillis());
    }

    public static String O000000o(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String O000000o(Date date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    private static byte[] O00000o0(byte[] bArr, String str) {
        if (bArr == null) {
            return bArr;
        }
        did.O00000o0("rqdp{  enD:} %d %d", Integer.valueOf(bArr.length), 1);
        try {
            dhk dhk = new dhk();
            dhk.O000000o(str);
            return dhk.O00000Oo(bArr);
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:2:0x000d */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:8:0x001e */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.io.FileInputStream} */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.FileInputStream] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=java.io.FileInputStream, for r8v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057 A[Catch:{ Throwable -> 0x0090 }, LOOP:0: B:20:0x0057->B:22:0x005d, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067 A[Catch:{ Throwable -> 0x0090 }, LOOP:1: B:23:0x0061->B:25:0x0067, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a A[SYNTHETIC, Splitter:B:28:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a2 A[SYNTHETIC, Splitter:B:48:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ac A[SYNTHETIC, Splitter:B:53:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bd A[SYNTHETIC, Splitter:B:61:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c7 A[SYNTHETIC, Splitter:B:66:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x006b A[EDGE_INSN: B:73:0x006b->B:26:0x006b ?: BREAK  , SYNTHETIC] */
    public static byte[] O000000o(File file, String str, FileInputStream fileInputStream) {
        FileInputStream fileInputStream2;
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream3;
        String str2;
        ByteArrayInputStream byteArrayInputStream;
        byte[] bArr;
        int read;
        did.O00000o0("rqdp{  ZF start}", new Object[0]);
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        str2 = file.getName();
                        byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                        zipOutputStream.setMethod(8);
                        zipOutputStream.putNextEntry(new ZipEntry(str2));
                        bArr = new byte[1024];
                        if (fileInputStream != null) {
                            while (true) {
                                int read2 = fileInputStream.read(bArr);
                                if (read2 <= 0) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read2);
                            }
                        }
                        while (true) {
                            read = byteArrayInputStream.read(bArr);
                            if (read > 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.closeEntry();
                        zipOutputStream.flush();
                        zipOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        zipOutputStream.close();
                        did.O00000o0("rqdp{  ZF end}", new Object[0]);
                        return byteArray;
                    } catch (Throwable th) {
                        th = th;
                        zipOutputStream = null;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        did.O00000o0("rqdp{  ZF end}", new Object[0]);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = null;
                zipOutputStream = null;
                if (fileInputStream2 != null) {
                }
                if (zipOutputStream != null) {
                }
                did.O00000o0("rqdp{  ZF end}", new Object[0]);
                throw th;
            }
        }
        str2 = fileInputStream;
        fileInputStream = null;
        byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        zipOutputStream = new ZipOutputStream(byteArrayOutputStream2);
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(str2));
            bArr = new byte[1024];
            if (fileInputStream != null) {
            }
            while (true) {
                read = byteArrayInputStream.read(bArr);
                if (read > 0) {
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.finish();
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            if (fileInputStream != null) {
            }
            try {
                zipOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            did.O00000o0("rqdp{  ZF end}", new Object[0]);
            return byteArray2;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream3 = fileInputStream;
            if (!did.O000000o(th)) {
            }
            if (fileInputStream3 != null) {
            }
            if (zipOutputStream != null) {
            }
            did.O00000o0("rqdp{  ZF end}", new Object[0]);
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        did.O00000o0("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            dhi O000000o2 = dhh.O000000o(2);
            if (O000000o2 == null) {
                return null;
            }
            return O000000o2.O000000o(bArr);
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] O00000Oo(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        did.O00000o0("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            dhi O000000o2 = dhh.O000000o(2);
            if (O000000o2 == null) {
                return null;
            }
            return O000000o2.O00000Oo(bArr);
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return O00000o0(O000000o(bArr), str);
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] O00000Oo(byte[] bArr, String str) {
        try {
            return O00000Oo(O00000o(bArr, str));
        } catch (Exception e) {
            if (did.O000000o(e)) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static long O00000Oo() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String O00000o0(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static String O00000o(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            return O00000o0(instance.digest());
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c7 A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00cc A[SYNTHETIC, Splitter:B:63:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d6 A[SYNTHETIC, Splitter:B:68:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8 A[SYNTHETIC, Splitter:B:77:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f2 A[SYNTHETIC, Splitter:B:82:0x00f2] */
    public static boolean O000000o(File file, File file2) {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        did.O00000o0("rqdp{  ZF start}", new Object[0]);
        if (file.equals(file2)) {
            did.O00000o("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        } else if (!file.exists() || !file.canRead()) {
            did.O00000o("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        } else {
            try {
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
            if (!file2.exists() || !file2.canRead()) {
                return false;
            }
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                    try {
                        zipOutputStream.setMethod(8);
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        byte[] bArr = new byte[5000];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        did.O00000o0("rqdp{  ZF end}", new Object[0]);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        if (zipOutputStream != null) {
                        }
                        did.O00000o0("rqdp{  ZF end}", new Object[0]);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipOutputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    did.O00000o0("rqdp{  ZF end}", new Object[0]);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                zipOutputStream = null;
                if (fileInputStream != null) {
                }
                if (zipOutputStream != null) {
                }
                did.O00000o0("rqdp{  ZF end}", new Object[0]);
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e A[Catch:{ all -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083 A[SYNTHETIC, Splitter:B:38:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008d A[SYNTHETIC, Splitter:B:43:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009a A[SYNTHETIC, Splitter:B:51:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4 A[SYNTHETIC, Splitter:B:56:0x00a4] */
    public static ArrayList<String> O000000o(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ArrayList<String> arrayList = new ArrayList<>();
        if (dgr.O00000oo(dgs.O000000o(context).f14615O000000o)) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(new String("unknown(low memory)"));
            return arrayList2;
        }
        BufferedReader bufferedReader3 = null;
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader3 != null) {
                    }
                    throw th;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!did.O000000o(th)) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    return null;
                }
            }
            bufferedReader.close();
            try {
                bufferedReader2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String O000000o(Context context, String str) {
        if (str.trim().equals("")) {
            return "";
        }
        if (f14664O000000o == null) {
            f14664O000000o = new HashMap();
            ArrayList<String> O000000o2 = O000000o(context, new String[]{"/system/bin/sh", "-c", "getprop"});
            if (O000000o2 != null && O000000o2.size() > 0) {
                did.O00000Oo(dif.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                for (String matcher : O000000o2) {
                    Matcher matcher2 = compile.matcher(matcher);
                    if (matcher2.find()) {
                        f14664O000000o.put(matcher2.group(1), matcher2.group(2));
                    }
                }
                did.O00000Oo(dif.class, "System properties number: %d.", Integer.valueOf(f14664O000000o.size()));
            }
        }
        return f14664O000000o.containsKey(str) ? f14664O000000o.get(str) : "fail";
    }

    public static void O00000Oo(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean O000000o(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static byte[] O00000o0(long j) {
        try {
            return String.valueOf(j).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long O00000oO(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Context O000000o(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static void O000000o(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception unused) {
        }
    }

    public static Object O000000o(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void O000000o(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(next.getKey());
            arrayList2.add(next.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            bundle.putString("pluginKey".concat(String.valueOf(i)), (String) arrayList.get(i));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString("pluginVal" + i2 + "plugInId", ((PlugInBean) arrayList2.get(i2)).f5811O000000o);
            bundle.putString("pluginVal" + i2 + "plugInUUID", ((PlugInBean) arrayList2.get(i2)).O00000o0);
            bundle.putString("pluginVal" + i2 + "plugInVersion", ((PlugInBean) arrayList2.get(i2)).O00000Oo);
        }
        parcel.writeBundle(bundle);
    }

    public static Map<String, PlugInBean> O000000o(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(readBundle.getString("pluginKey".concat(String.valueOf(i))));
        }
        for (int i2 = 0; i2 < intValue; i2++) {
            String string = readBundle.getString("pluginVal" + i2 + "plugInId");
            String string2 = readBundle.getString("pluginVal" + i2 + "plugInUUID");
            arrayList2.add(new PlugInBean(string, readBundle.getString("pluginVal" + i2 + "plugInVersion"), string2));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                hashMap.put(arrayList.get(i3), PlugInBean.class.cast(arrayList2.get(i3)));
            }
        } else {
            did.O00000oO("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static void O00000Oo(Parcel parcel, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(next.getKey());
            arrayList2.add(next.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    public static Map<String, String> O00000Oo(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            did.O00000oO("map parcel error!", new Object[0]);
        } else {
            hashMap = new HashMap(stringArrayList.size());
            for (int i = 0; i < stringArrayList.size(); i++) {
                hashMap.put(stringArrayList.get(i), stringArrayList2.get(i));
            }
        }
        return hashMap;
    }

    public static byte[] O000000o(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T> T O000000o(byte[] bArr, Parcelable.Creator creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            T createFromParcel = creator.createFromParcel(obtain);
            if (obtain != null) {
                obtain.recycle();
            }
            return createFromParcel;
        } catch (Throwable th) {
            if (obtain != null) {
                obtain.recycle();
            }
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Process, java.lang.String] */
    public static String O000000o(Context context, int i) {
        ? r1 = 0;
        if (!dgr.O000000o(context, "android.permission.READ_LOGS")) {
            did.O00000o("no read_log permission!", new Object[0]);
            return r1;
        }
        String[] strArr = {"logcat", "-d", "-v", "threadtime"};
        StringBuilder sb = new StringBuilder();
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
                if (i > 0 && sb.length() > i) {
                    sb.delete(0, sb.length() - i);
                }
            }
            String sb2 = sb.toString();
            if (exec != null) {
                try {
                    exec.getOutputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    exec.getInputStream().close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    exec.getErrorStream().close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return sb2;
        } catch (Throwable th) {
            if (r1 != 0) {
                try {
                    r1.getOutputStream().close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    r1.getInputStream().close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    r1.getErrorStream().close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Map<String, String> O000000o(int i) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : allStackTraces.entrySet()) {
            int i2 = 0;
            sb.setLength(0);
            if (!(next.getValue() == null || ((StackTraceElement[]) next.getValue()).length == 0)) {
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                int length = stackTraceElementArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cutted !]");
                        break;
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                    i2++;
                }
                hashMap.put(((Thread) next.getKey()).getName() + "(" + ((Thread) next.getKey()).getId() + ")", sb.toString());
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A[SYNTHETIC, Splitter:B:20:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0055 A[SYNTHETIC, Splitter:B:27:0x0055] */
    public static synchronized byte[] O00000o0() {
        DataInputStream dataInputStream;
        synchronized (dif.class) {
            try {
                byte[] bArr = new byte[16];
                dataInputStream = new DataInputStream(new FileInputStream(new File("/dev/urandom")));
                try {
                    dataInputStream.readFully(bArr);
                    try {
                        dataInputStream.close();
                        return bArr;
                    } catch (Exception e) {
                        if (!did.O00000Oo(e)) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        did.O00000oO("Failed to read from /dev/urandom : %s", e);
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        KeyGenerator instance = KeyGenerator.getInstance("AES");
                        instance.init((int) NotificationCompat.FLAG_HIGH_PRIORITY, new SecureRandom());
                        byte[] encoded = instance.generateKey().getEncoded();
                        return encoded;
                    } catch (Throwable th) {
                        th = th;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                did.O00000oO("Failed to read from /dev/urandom : %s", e);
                if (dataInputStream != null) {
                }
                KeyGenerator instance2 = KeyGenerator.getInstance("AES");
                instance2.init((int) NotificationCompat.FLAG_HIGH_PRIORITY, new SecureRandom());
                byte[] encoded2 = instance2.generateKey().getEncoded();
                return encoded2;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                }
                throw th;
            }
        }
    }

    @TargetApi(19)
    public static byte[] O000000o(int i, byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            if (Build.VERSION.SDK_INT >= 21) {
                if (!O00000Oo) {
                    instance.init(i, secretKeySpec, new GCMParameterSpec(instance.getBlockSize() << 3, bArr2));
                    return instance.doFinal(bArr);
                }
            }
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            O00000Oo = true;
            throw e;
        } catch (Exception e2) {
            if (did.O00000Oo(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            if (did.O00000Oo(e)) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static boolean O000000o(Context context, String str, long j) {
        did.O00000o0("[Util] try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                did.O00000o0("[Util] lock file(%s) is expired, unlock it", str);
                O00000Oo(context, str);
            }
            if (file.createNewFile()) {
                did.O00000o0("[Util] successfully locked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            did.O00000o0("[Util] Failed to locked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            did.O000000o(th);
            return false;
        }
    }

    public static boolean O00000Oo(Context context, String str) {
        did.O00000o0("[Util] try to unlock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            did.O00000o0("[Util] successfully unlocked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            did.O000000o(th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A[SYNTHETIC, Splitter:B:23:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0058 A[SYNTHETIC, Splitter:B:31:0x0058] */
    public static String O000000o(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                } catch (Throwable th) {
                    th = th;
                    try {
                        did.O000000o(th);
                        if (bufferedReader != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e) {
                did.O000000o(e);
            }
            return sb2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e2) {
                    did.O000000o(e2);
                }
            }
            throw th;
        }
    }

    private static BufferedReader O00000Oo(File file) {
        if (file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                did.O000000o(th);
            }
        }
        return null;
    }

    public static BufferedReader O000000o(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                if (file.canRead()) {
                    return O00000Oo(file);
                }
            }
            return null;
        } catch (NullPointerException e) {
            did.O000000o(e);
            return null;
        }
    }

    public static Thread O000000o(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            did.O00000oO("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean O000000o(Runnable runnable) {
        dic O000000o2 = dic.O000000o();
        if (O000000o2 != null) {
            return O000000o2.O000000o(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return O000000o(runnable, split[split.length - 1]) != null;
    }

    public static boolean O00000Oo(String str) {
        if (str == null || str.trim().length() <= 0) {
            return false;
        }
        if (str.length() > 255) {
            did.O000000o("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (!str.toLowerCase().startsWith("http")) {
            did.O000000o("URL(%s) is not start with \"http\".", str);
            return false;
        } else if (str.toLowerCase().contains("qq.com")) {
            return true;
        } else {
            did.O000000o("URL(%s) does not contain \"qq.com\".", str);
            return false;
        }
    }

    public static SharedPreferences O000000o(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static String O00000Oo(String str, String str2) {
        return (dgs.O000000o() == null || dgs.O000000o().O000OOOo == null) ? "" : dgs.O000000o().O000OOOo.getString(str, str2);
    }

    public static String O00000oo(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                stringBuffer.append(':');
            }
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    private static byte[] O00000o(byte[] bArr, String str) {
        if (bArr == null) {
            return bArr;
        }
        try {
            dhk dhk = new dhk();
            dhk.O000000o(str);
            return dhk.O000000o(bArr);
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            did.O00000o("encrytype %d %s", 1, str);
            return null;
        }
    }
}
