package _m_j;

import android.content.Context;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public final class bvj {
    private static String O000000o(Context context) {
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
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        r6 = new java.lang.String(r3.toByteArray(), "UTF-8");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        if (r6.contains("#") == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r6 = r6.split("#");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        if (r6 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008d, code lost:
        if (r6.length != 2) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0095, code lost:
        if (android.text.TextUtils.equals(r7, r6[0]) == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        r6 = r6[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        O000000o(r3);
        O000000o(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a1, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        O000000o(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a9, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ab, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized String O000000o(Context context, String str) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        synchronized (bvj.class) {
            String O000000o2 = O000000o(context);
            if (TextUtils.isEmpty(O000000o2)) {
                return "";
            }
            File file = new File(O000000o2 + File.separator + "backups", ".adiu");
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
                            O000000o(byteArrayOutputStream);
                            O000000o(randomAccessFile);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile = null;
                        byteArrayOutputStream = null;
                        Throwable th22 = th;
                        O000000o(byteArrayOutputStream);
                        O000000o(randomAccessFile);
                        throw th22;
                    }
                    O000000o(randomAccessFile);
                    return "";
                }
            }
            return "";
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:36:? */
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
    /* JADX WARNING: Can't wrap try/catch for region: R(18:7|8|9|10|11|(1:15)|16|17|18|19|20|(1:22)|(2:24|25)|(2:28|29)|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:37|38|(0)|(0)|50|51|52) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:40|39|(0)|(0)|62|63|64|65) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00a2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x00b4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098 A[SYNTHETIC, Splitter:B:44:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009f A[SYNTHETIC, Splitter:B:48:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa A[SYNTHETIC, Splitter:B:56:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b1 A[SYNTHETIC, Splitter:B:60:0x00b1] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0082=Splitter:B:30:0x0082, B:50:0x00a2=Splitter:B:50:0x00a2, B:62:0x00b4=Splitter:B:62:0x00b4} */
    public static synchronized void O000000o(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<_m_j.bvj> r0 = _m_j.bvj.class
            monitor-enter(r0)
            java.lang.String r4 = O000000o(r4)     // Catch:{ all -> 0x00b9 }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)
            return
        L_0x000f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r1.<init>()     // Catch:{ all -> 0x00b9 }
            r1.append(r5)     // Catch:{ all -> 0x00b9 }
            java.lang.String r5 = "#"
            r1.append(r5)     // Catch:{ all -> 0x00b9 }
            r1.append(r6)     // Catch:{ all -> 0x00b9 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x00b9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r6.<init>()     // Catch:{ all -> 0x00b9 }
            r6.append(r4)     // Catch:{ all -> 0x00b9 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x00b9 }
            r6.append(r4)     // Catch:{ all -> 0x00b9 }
            java.lang.String r4 = "backups"
            r6.append(r4)     // Catch:{ all -> 0x00b9 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00b9 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00b9 }
            r6.<init>(r4)     // Catch:{ all -> 0x00b9 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = ".adiu"
            r4.<init>(r6, r1)     // Catch:{ all -> 0x00b9 }
            r1 = 0
            boolean r2 = r6.exists()     // Catch:{ Throwable -> 0x00a6, all -> 0x0093 }
            if (r2 == 0) goto L_0x0052
            boolean r2 = r6.isDirectory()     // Catch:{ Throwable -> 0x00a6, all -> 0x0093 }
            if (r2 == 0) goto L_0x0055
        L_0x0052:
            r6.mkdirs()     // Catch:{ Throwable -> 0x00a6, all -> 0x0093 }
        L_0x0055:
            r4.createNewFile()     // Catch:{ Throwable -> 0x00a6, all -> 0x0093 }
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x00a6, all -> 0x0093 }
            java.lang.String r2 = "rws"
            r6.<init>(r4, r2)     // Catch:{ Throwable -> 0x00a6, all -> 0x0093 }
            java.nio.channels.FileChannel r4 = r6.getChannel()     // Catch:{ Throwable -> 0x0091, all -> 0x008e }
            java.nio.channels.FileLock r1 = r4.tryLock()     // Catch:{ Throwable -> 0x008c, all -> 0x0087 }
            if (r1 == 0) goto L_0x0076
            java.lang.String r2 = "UTF-8"
            byte[] r5 = r5.getBytes(r2)     // Catch:{ Throwable -> 0x008c, all -> 0x0087 }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r5)     // Catch:{ Throwable -> 0x008c, all -> 0x0087 }
            r4.write(r5)     // Catch:{ Throwable -> 0x008c, all -> 0x0087 }
        L_0x0076:
            if (r1 == 0) goto L_0x007d
            r1.release()     // Catch:{ IOException -> 0x007c }
            goto L_0x007d
        L_0x007c:
        L_0x007d:
            if (r4 == 0) goto L_0x0082
            r4.close()     // Catch:{ IOException -> 0x0082 }
        L_0x0082:
            O000000o(r6)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r0)
            return
        L_0x0087:
            r5 = move-exception
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x0096
        L_0x008c:
            goto L_0x00a8
        L_0x008e:
            r4 = move-exception
            r5 = r1
            goto L_0x0096
        L_0x0091:
            r4 = r1
            goto L_0x00a8
        L_0x0093:
            r4 = move-exception
            r5 = r1
            r6 = r5
        L_0x0096:
            if (r1 == 0) goto L_0x009d
            r1.release()     // Catch:{ IOException -> 0x009c }
            goto L_0x009d
        L_0x009c:
        L_0x009d:
            if (r5 == 0) goto L_0x00a2
            r5.close()     // Catch:{ IOException -> 0x00a2 }
        L_0x00a2:
            O000000o(r6)     // Catch:{ all -> 0x00b9 }
            throw r4     // Catch:{ all -> 0x00b9 }
        L_0x00a6:
            r4 = r1
            r6 = r4
        L_0x00a8:
            if (r1 == 0) goto L_0x00af
            r1.release()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00af
        L_0x00ae:
        L_0x00af:
            if (r4 == 0) goto L_0x00b4
            r4.close()     // Catch:{ IOException -> 0x00b4 }
        L_0x00b4:
            O000000o(r6)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r0)
            return
        L_0x00b9:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bvj.O000000o(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
