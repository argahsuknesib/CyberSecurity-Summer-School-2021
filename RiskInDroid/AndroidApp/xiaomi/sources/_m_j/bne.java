package _m_j;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bne {
    private static Object O000000o(Field field, Object obj) {
        try {
            Class<?> type = field.getType();
            if (type == Integer.class || type == Double.class || type == Float.class || type == Long.class) {
                if (obj == null) {
                    return -1;
                }
                return obj;
            } else if (type == String.class) {
                return obj == null ? "" : obj;
            } else {
                if (type == Map.class) {
                    return obj == null ? new JSONObject() : new JSONObject((Map<?, ?>) ((Map) obj));
                }
                if (type != List.class) {
                    if (type != Set.class) {
                        return obj == null ? type.newInstance() : obj;
                    }
                }
                return obj == null ? new JSONArray() : new JSONArray((Collection<?>) ((Collection) obj));
            }
        } catch (Exception unused) {
            return new Object();
        }
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable, java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059  */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static String O000000o(File file) {
        FileChannel fileChannel;
        ? r1;
        FileChannel fileChannel2;
        if (file.exists()) {
            FileLock fileLock = null;
            try {
                ? fileInputStream = new FileInputStream(file);
                try {
                    fileChannel = fileInputStream.getChannel();
                    try {
                        fileLock = fileChannel.lock(0, 63, true);
                        String str = new String(O000000o(fileChannel), "utf-8");
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        O000000o((Closeable) fileInputStream);
                        return str;
                    } catch (Exception e) {
                        e = e;
                        FileLock fileLock2 = fileInputStream;
                        fileChannel2 = fileLock;
                        fileLock = fileLock2;
                        try {
                            throw new IOException(e);
                        } catch (Throwable th) {
                            th = th;
                            FileLock fileLock3 = fileChannel2;
                            r1 = fileLock;
                            fileLock = fileLock3;
                            if (fileLock != null) {
                            }
                            if (fileChannel != null) {
                            }
                            O000000o((Closeable) r1);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r1 = fileInputStream;
                        if (fileLock != null) {
                        }
                        if (fileChannel != null) {
                        }
                        O000000o((Closeable) r1);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileChannel = null;
                    fileLock = fileInputStream;
                    fileChannel2 = fileChannel;
                    throw new IOException(e);
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    r1 = fileInputStream;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    O000000o((Closeable) r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileChannel = null;
                fileChannel2 = fileChannel;
                throw new IOException(e);
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                r1 = 0;
                if (fileLock != null) {
                }
                if (fileChannel != null) {
                }
                O000000o((Closeable) r1);
                throw th;
            }
        } else {
            throw new IOException("not exist");
        }
    }

    public static String O000000o(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(":");
            }
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    private static List<Object> O000000o(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object opt = jSONArray.opt(i);
            if (opt != null) {
                arrayList.add(O00000o0(opt));
            }
        }
        return arrayList;
    }

    public static Map<String, Object> O000000o(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                hashMap.put(next, O00000o0(opt));
            }
        }
        return hashMap;
    }

    public static JSONObject O000000o(Object obj) {
        JSONObject jSONObject = new JSONObject();
        if (obj == null) {
            return jSONObject;
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                if (!field.getName().equals("serialVersionUID")) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    blj blj = (blj) field.getAnnotation(blj.class);
                    if (blj == null) {
                        jSONObject.put(field.getName(), obj2);
                    } else {
                        boolean O00000o0 = blj.O00000o0();
                        if (obj2 != null || O00000o0) {
                            jSONObject.put(blj.O000000o(), blj.O00000Oo() ? O000000o(obj2) : O000000o(field, obj2));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject O000000o(Map<?, ?> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (str != null) {
                    try {
                        jSONObject.put(str, O00000Oo(next.getValue()));
                    } catch (JSONException unused) {
                    }
                } else {
                    throw new NullPointerException("key == null");
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0055  */
    public static void O000000o(java.io.File r4, byte[] r5) {
        /*
            if (r5 == 0) goto L_0x005c
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0041, all -> 0x003d }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0041, all -> 0x003d }
            java.nio.channels.FileChannel r4 = r1.getChannel()     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            java.nio.channels.FileLock r0 = r4.lock()     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r5)     // Catch:{ Exception -> 0x0031, all -> 0x002f }
        L_0x0014:
            boolean r2 = r5.hasRemaining()     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            if (r2 == 0) goto L_0x001e
            r4.write(r5)     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            goto L_0x0014
        L_0x001e:
            r1.flush()     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            if (r0 == 0) goto L_0x0026
            r0.release()
        L_0x0026:
            if (r4 == 0) goto L_0x002b
            r4.close()
        L_0x002b:
            O000000o(r1)
            return
        L_0x002f:
            r5 = move-exception
            goto L_0x004e
        L_0x0031:
            r5 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0044
        L_0x0036:
            r5 = move-exception
            r4 = r0
            goto L_0x004e
        L_0x0039:
            r5 = move-exception
            r4 = r0
            r0 = r1
            goto L_0x0043
        L_0x003d:
            r5 = move-exception
            r4 = r0
            r1 = r4
            goto L_0x004e
        L_0x0041:
            r5 = move-exception
            r4 = r0
        L_0x0043:
            r1 = r4
        L_0x0044:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x004a }
            r2.<init>(r5)     // Catch:{ all -> 0x004a }
            throw r2     // Catch:{ all -> 0x004a }
        L_0x004a:
            r5 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            r0.release()
        L_0x0053:
            if (r4 == 0) goto L_0x0058
            r4.close()
        L_0x0058:
            O000000o(r1)
            throw r5
        L_0x005c:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "file or bytes empty"
            r4.<init>(r5)
            goto L_0x0065
        L_0x0064:
            throw r4
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bne.O000000o(java.io.File, byte[]):void");
    }

    public static void O000000o(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean O000000o(String str) {
        try {
            return new File(Environment.getExternalStorageDirectory() + "/" + str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static byte[] O000000o(FileChannel fileChannel) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteBuffer allocate = ByteBuffer.allocate(100);
                int i = 0;
                int i2 = 0;
                while (true) {
                    int read = fileChannel.read(allocate, (long) i);
                    if (read <= 0) {
                        break;
                    }
                    i += read;
                    i2 += read;
                }
                byte[] array = allocate.array();
                if (i2 >= 4 && (array[0] & 255) == 0 && (array[1] & 255) == 0 && (array[2] & 255) == 0) {
                    if ((array[3] & 255) == 0) {
                        throw new IOException("read bytes not utf-8");
                    }
                }
                byteArrayOutputStream2.write(array, 0, i2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                O000000o((Closeable) byteArrayOutputStream2);
                return byteArray;
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    O000000o((Closeable) byteArrayOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                O000000o((Closeable) byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            throw new IOException(e);
        }
    }

    private static String O00000Oo(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            bmz.O000000o(e);
            throw new IOException("fail to md5 data");
        }
    }

    public static boolean O00000Oo(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String O00000o(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replaceAll(":", "").toLowerCase();
    }

    private static Object O00000o0(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof JSONObject ? O000000o((JSONObject) obj) : obj instanceof JSONArray ? O000000o((JSONArray) obj) : obj;
    }

    public static List<String> O00000o0(String str) {
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        O000000o((Closeable) bufferedReader2);
                        return arrayList;
                    } else if (!bnd.O000000o(readLine)) {
                        arrayList.add(readLine);
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        throw new IOException(e);
                    } catch (Throwable th) {
                        th = th;
                        O000000o((Closeable) bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    O000000o((Closeable) bufferedReader);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            throw new IOException(e);
        }
    }

    public static String O00000oO(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String O00000oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return O00000Oo(str.getBytes("utf-8"));
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] O0000O0o(String str) {
        try {
            return Base64.decode(str.getBytes("utf-8"), 0);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static String O0000OOo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Patterns.DOMAIN_NAME.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static boolean O0000Oo0(String str) {
        if (str == null) {
            return false;
        }
        return Patterns.IP_ADDRESS.matcher(str).matches();
    }

    private static Object O00000Oo(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                Collection<Object> collection = (Collection) obj;
                JSONArray jSONArray = new JSONArray();
                if (collection != null) {
                    for (Object O00000Oo : collection) {
                        jSONArray.put(O00000Oo(O00000Oo));
                    }
                }
                return jSONArray;
            } else if (obj.getClass().isArray()) {
                if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < length; i++) {
                        jSONArray2.put(O00000Oo(Array.get(obj, i)));
                    }
                    return jSONArray2;
                }
                throw new JSONException("Not a primitive data: " + obj.getClass());
            } else if (obj instanceof Map) {
                return O000000o((Map<?, ?>) ((Map) obj));
            } else {
                if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                    return obj;
                }
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
        } catch (Exception unused) {
        }
    }
}
