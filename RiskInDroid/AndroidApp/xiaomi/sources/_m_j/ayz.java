package _m_j;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ayz {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084 A[Catch:{ FileNotFoundException -> 0x008d, Exception -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    public static InputStream O000000o(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_data");
            sb.append("=? ");
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "mime_type", "_display_name"}, sb.toString(), new String[]{str}, null);
            if (query != null && query.moveToFirst()) {
                do {
                    int i = query.getInt(query.getColumnIndex("_id"));
                    query.getString(query.getColumnIndex("_data"));
                    query.getString(query.getColumnIndex("mime_type"));
                    query.getString(query.getColumnIndex("_display_name"));
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(i);
                    Uri withAppendedPath = Uri.withAppendedPath(uri, sb2.toString());
                    Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (long) i);
                    if (withAppendedPath != null) {
                        return context.getContentResolver().openInputStream(withAppendedId);
                    }
                } while (query.moveToNext());
                if (query != null) {
                }
            } else if (query != null) {
                return null;
            } else {
                query.close();
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String O000000o(String str) {
        return "file://".concat(String.valueOf(str));
    }

    public static void O000000o(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    O00000Oo(file2);
                }
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:67:0x00a5 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:52:0x0087 */
    /* JADX INFO: additional move instructions added (5) to help type inference */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
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
    /* JADX WARNING: Removed duplicated region for block: B:55:0x008c A[SYNTHETIC, Splitter:B:55:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0091 A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096 A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x009b A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00aa A[SYNTHETIC, Splitter:B:70:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00b2 A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00b7 A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00bc A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00ce A[SYNTHETIC, Splitter:B:85:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00d6 A[Catch:{ IOException -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00db A[Catch:{ IOException -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00e0 A[Catch:{ IOException -> 0x00d2 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:67:0x00a5=Splitter:B:67:0x00a5, B:52:0x0087=Splitter:B:52:0x0087} */
    public static java.lang.String O00000Oo(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ FileNotFoundException -> 0x009f, IOException -> 0x0081, all -> 0x007a }
            r2 = 28
            if (r1 < r2) goto L_0x000c
            java.io.InputStream r8 = O000000o(r8, r9)     // Catch:{ FileNotFoundException -> 0x009f, IOException -> 0x0081, all -> 0x007a }
            goto L_0x0011
        L_0x000c:
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x009f, IOException -> 0x0081, all -> 0x007a }
            r8.<init>(r9)     // Catch:{ FileNotFoundException -> 0x009f, IOException -> 0x0081, all -> 0x007a }
        L_0x0011:
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0076, IOException -> 0x0072, all -> 0x006e }
            r9.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0076, IOException -> 0x0072, all -> 0x006e }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0066, all -> 0x0061 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0066, all -> 0x0061 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0058, all -> 0x0055 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0058, all -> 0x0055 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050 }
        L_0x0024:
            int r4 = r9.read(r3)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050 }
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L_0x0030
            r2.write(r3, r6, r4)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050 }
            goto L_0x0024
        L_0x0030:
            r2.flush()     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050 }
            byte[] r3 = r1.toByteArray()     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050 }
            int r4 = r3.length     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050 }
            java.lang.String r0 = android.util.Base64.encodeToString(r3, r6, r4, r6)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050 }
            r2.close()     // Catch:{ IOException -> 0x004b }
            r1.close()     // Catch:{ IOException -> 0x004b }
            r9.close()     // Catch:{ IOException -> 0x004b }
            if (r8 == 0) goto L_0x004f
            r8.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x004f:
            return r0
        L_0x0050:
            r3 = move-exception
            goto L_0x0087
        L_0x0052:
            r3 = move-exception
            goto L_0x00a5
        L_0x0055:
            r2 = move-exception
            goto L_0x00cc
        L_0x0058:
            r2 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0087
        L_0x005c:
            r2 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x00a5
        L_0x0061:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x00cc
        L_0x0066:
            r1 = move-exception
            r3 = r1
            r1 = r0
            goto L_0x0086
        L_0x006a:
            r1 = move-exception
            r3 = r1
            r1 = r0
            goto L_0x00a4
        L_0x006e:
            r9 = move-exception
            r2 = r9
            r9 = r0
            goto L_0x007e
        L_0x0072:
            r9 = move-exception
            r3 = r9
            r9 = r0
            goto L_0x0085
        L_0x0076:
            r9 = move-exception
            r3 = r9
            r9 = r0
            goto L_0x00a3
        L_0x007a:
            r8 = move-exception
            r2 = r8
            r8 = r0
            r9 = r8
        L_0x007e:
            r1 = r9
            goto L_0x00cc
        L_0x0081:
            r8 = move-exception
            r3 = r8
            r8 = r0
            r9 = r8
        L_0x0085:
            r1 = r9
        L_0x0086:
            r2 = r1
        L_0x0087:
            r3.printStackTrace()     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x008f
            r2.close()     // Catch:{ IOException -> 0x00ae }
        L_0x008f:
            if (r1 == 0) goto L_0x0094
            r1.close()     // Catch:{ IOException -> 0x00ae }
        L_0x0094:
            if (r9 == 0) goto L_0x0099
            r9.close()     // Catch:{ IOException -> 0x00ae }
        L_0x0099:
            if (r8 == 0) goto L_0x00c3
            r8.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00c3
        L_0x009f:
            r8 = move-exception
            r3 = r8
            r8 = r0
            r9 = r8
        L_0x00a3:
            r1 = r9
        L_0x00a4:
            r2 = r1
        L_0x00a5:
            r3.printStackTrace()     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00b0
            r2.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b0
        L_0x00ae:
            r8 = move-exception
            goto L_0x00c0
        L_0x00b0:
            if (r1 == 0) goto L_0x00b5
            r1.close()     // Catch:{ IOException -> 0x00ae }
        L_0x00b5:
            if (r9 == 0) goto L_0x00ba
            r9.close()     // Catch:{ IOException -> 0x00ae }
        L_0x00ba:
            if (r8 == 0) goto L_0x00c3
            r8.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00c3
        L_0x00c0:
            r8.printStackTrace()
        L_0x00c3:
            return r0
        L_0x00c4:
            r0 = move-exception
            r7 = r0
            r0 = r8
            r8 = r2
            r2 = r7
            r7 = r0
            r0 = r8
            r8 = r7
        L_0x00cc:
            if (r0 == 0) goto L_0x00d4
            r0.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d4
        L_0x00d2:
            r8 = move-exception
            goto L_0x00e4
        L_0x00d4:
            if (r1 == 0) goto L_0x00d9
            r1.close()     // Catch:{ IOException -> 0x00d2 }
        L_0x00d9:
            if (r9 == 0) goto L_0x00de
            r9.close()     // Catch:{ IOException -> 0x00d2 }
        L_0x00de:
            if (r8 == 0) goto L_0x00e7
            r8.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00e7
        L_0x00e4:
            r8.printStackTrace()
        L_0x00e7:
            goto L_0x00e9
        L_0x00e8:
            throw r2
        L_0x00e9:
            goto L_0x00e8
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.ayz.O00000Oo(android.content.Context, java.lang.String):java.lang.String");
    }

    private static void O00000Oo(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    O00000Oo(file2);
                }
            }
            file.delete();
        }
    }

    public static Uri O00000o0(Context context, String str) {
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), String.valueOf(query.getInt(query.getColumnIndex("_id"))));
        } else if (!new File(str).exists()) {
            return null;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
    }

    public static File O000000o(Context context, String str, Uri uri) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(".");
            sb.append(MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri)));
            File file2 = new File(str, sb.toString());
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            FileInputStream fileInputStream = (FileInputStream) context.getContentResolver().openInputStream(uri);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (-1 != read) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file2;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
