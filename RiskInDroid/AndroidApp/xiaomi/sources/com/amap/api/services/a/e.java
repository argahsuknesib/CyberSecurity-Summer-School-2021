package com.amap.api.services.a;

import android.content.Context;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class e {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.e.a(android.content.Context, boolean):java.lang.String
     arg types: [android.content.Context, int]
     candidates:
      com.amap.api.services.a.e.a(android.content.Context, java.lang.String):java.lang.String
      com.amap.api.services.a.e.a(android.content.Context, boolean):java.lang.String */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        r7 = new java.lang.String(r4.toByteArray(), "UTF-8");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        if (android.text.TextUtils.isEmpty(r7) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0081, code lost:
        if (r7.contains("#") == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        r7 = r7.split("#");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        if (r7 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008d, code lost:
        if (r7.length != 2) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        if (android.text.TextUtils.equals(r8, r7[0]) == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0097, code lost:
        r7 = r7[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        a(r4);
        a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a1, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a9, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ab, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized String a(Context context, String str) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        synchronized (e.class) {
            String a2 = a(context, false);
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            File file = new File(a2 + File.separator + "backups", ".adiu");
            if (file.exists()) {
                if (file.canRead()) {
                    if (file.length() == 0) {
                        file.delete();
                        return "";
                    }
                    ByteArrayOutputStream byteArrayOutputStream2 = null;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            byte[] bArr = new byte[1024];
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                int read = randomAccessFile.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = null;
                            Throwable th2 = th;
                            a(byteArrayOutputStream);
                            a(randomAccessFile);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile = null;
                        byteArrayOutputStream = null;
                        Throwable th22 = th;
                        a(byteArrayOutputStream);
                        a(randomAccessFile);
                        throw th22;
                    }
                    a(randomAccessFile);
                    return "";
                }
            }
            return "";
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:37:? */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.RandomAccessFile, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.e.a(android.content.Context, boolean):java.lang.String
     arg types: [android.content.Context, int]
     candidates:
      com.amap.api.services.a.e.a(android.content.Context, java.lang.String):java.lang.String
      com.amap.api.services.a.e.a(android.content.Context, boolean):java.lang.String */
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
    /* JADX WARNING: Can't wrap try/catch for region: R(11:18|19|20|21|(1:23)|(2:25|26)|(2:29|30)|31|32|33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:35|36|(0)|(0)|51|52|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:37|(0)|(0)|63|64|65|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00b5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099 A[SYNTHETIC, Splitter:B:45:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a0 A[SYNTHETIC, Splitter:B:49:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab A[SYNTHETIC, Splitter:B:57:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b2 A[SYNTHETIC, Splitter:B:61:0x00b2] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0083=Splitter:B:31:0x0083, B:51:0x00a3=Splitter:B:51:0x00a3, B:63:0x00b5=Splitter:B:63:0x00b5} */
    public static synchronized void a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<com.amap.api.services.a.e> r0 = com.amap.api.services.a.e.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r4 = a(r4, r1)     // Catch:{ all -> 0x00ba }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r1.<init>()     // Catch:{ all -> 0x00ba }
            r1.append(r5)     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = "#"
            r1.append(r5)     // Catch:{ all -> 0x00ba }
            r1.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r6.<init>()     // Catch:{ all -> 0x00ba }
            r6.append(r4)     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x00ba }
            r6.append(r4)     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = "backups"
            r6.append(r4)     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00ba }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00ba }
            r6.<init>(r4)     // Catch:{ all -> 0x00ba }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = ".adiu"
            r4.<init>(r6, r1)     // Catch:{ all -> 0x00ba }
            r1 = 0
            boolean r2 = r6.exists()     // Catch:{ Throwable -> 0x00a7, all -> 0x0094 }
            if (r2 == 0) goto L_0x0053
            boolean r2 = r6.isDirectory()     // Catch:{ Throwable -> 0x00a7, all -> 0x0094 }
            if (r2 == 0) goto L_0x0056
        L_0x0053:
            r6.mkdirs()     // Catch:{ Throwable -> 0x00a7, all -> 0x0094 }
        L_0x0056:
            r4.createNewFile()     // Catch:{ Throwable -> 0x00a7, all -> 0x0094 }
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x00a7, all -> 0x0094 }
            java.lang.String r2 = "rws"
            r6.<init>(r4, r2)     // Catch:{ Throwable -> 0x00a7, all -> 0x0094 }
            java.nio.channels.FileChannel r4 = r6.getChannel()     // Catch:{ Throwable -> 0x0092, all -> 0x008f }
            java.nio.channels.FileLock r1 = r4.tryLock()     // Catch:{ Throwable -> 0x008d, all -> 0x0088 }
            if (r1 == 0) goto L_0x0077
            java.lang.String r2 = "UTF-8"
            byte[] r5 = r5.getBytes(r2)     // Catch:{ Throwable -> 0x008d, all -> 0x0088 }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r5)     // Catch:{ Throwable -> 0x008d, all -> 0x0088 }
            r4.write(r5)     // Catch:{ Throwable -> 0x008d, all -> 0x0088 }
        L_0x0077:
            if (r1 == 0) goto L_0x007e
            r1.release()     // Catch:{ IOException -> 0x007d }
            goto L_0x007e
        L_0x007d:
        L_0x007e:
            if (r4 == 0) goto L_0x0083
            r4.close()     // Catch:{ IOException -> 0x0083 }
        L_0x0083:
            a(r6)     // Catch:{ all -> 0x00ba }
            monitor-exit(r0)
            return
        L_0x0088:
            r5 = move-exception
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x0097
        L_0x008d:
            goto L_0x00a9
        L_0x008f:
            r4 = move-exception
            r5 = r1
            goto L_0x0097
        L_0x0092:
            r4 = r1
            goto L_0x00a9
        L_0x0094:
            r4 = move-exception
            r5 = r1
            r6 = r5
        L_0x0097:
            if (r1 == 0) goto L_0x009e
            r1.release()     // Catch:{ IOException -> 0x009d }
            goto L_0x009e
        L_0x009d:
        L_0x009e:
            if (r5 == 0) goto L_0x00a3
            r5.close()     // Catch:{ IOException -> 0x00a3 }
        L_0x00a3:
            a(r6)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00a7:
            r4 = r1
            r6 = r4
        L_0x00a9:
            if (r1 == 0) goto L_0x00b0
            r1.release()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b0
        L_0x00af:
        L_0x00b0:
            if (r4 == 0) goto L_0x00b5
            r4.close()     // Catch:{ IOException -> 0x00b5 }
        L_0x00b5:
            a(r6)     // Catch:{ all -> 0x00ba }
            monitor-exit(r0)
            return
        L_0x00ba:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.e.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
