package com.sina.weibo.sdk.share;

import _m_j.dbm;
import _m_j.dbt;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public final class ShareUtils {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9 A[SYNTHETIC, Splitter:B:29:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3 A[Catch:{ Exception -> 0x0143, all -> 0x0140 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010e A[Catch:{ Exception -> 0x0136, all -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0121 A[Catch:{ Exception -> 0x0131 }, LOOP:0: B:48:0x011a->B:50:0x0121, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013c A[SYNTHETIC, Splitter:B:63:0x013c] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0151 A[SYNTHETIC, Splitter:B:74:0x0151] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0156 A[Catch:{ Exception -> 0x0159 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x015e A[SYNTHETIC, Splitter:B:83:0x015e] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0163 A[Catch:{ Exception -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0126 A[EDGE_INSN: B:89:0x0126->B:51:0x0126 ?: BREAK  , SYNTHETIC] */
    protected static String copyFileToWeiboTem(Context context, Uri uri, int i) {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        Cursor cursor;
        String str;
        File file;
        byte[] bArr;
        int read;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String packageName = dbm.O00000Oo(context).getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "com.sina.weibo";
            }
            String str2 = "/Android/data/" + packageName + "/files/.composerTem/";
            new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2).mkdirs();
            Calendar instance = Calendar.getInstance();
            try {
                if (uri.getScheme().equals("file")) {
                    str = instance.getTimeInMillis() + uri.getLastPathSegment();
                    cursor = null;
                } else {
                    cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(cursor.getColumnIndex("_display_name"));
                            }
                        } catch (Exception e) {
                            e = e;
                            try {
                                Log.v("weibo sdk rename", e.toString());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                str = null;
                                if (TextUtils.isEmpty(str)) {
                                }
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str);
                                if (file.exists()) {
                                }
                                fileOutputStream = new FileOutputStream(file);
                                bArr = new byte[1444];
                                while (true) {
                                    read = bufferedInputStream.read(bArr);
                                    if (read == -1) {
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                String path = file.getPath();
                                try {
                                    bufferedInputStream.close();
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                }
                                return path;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    str = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
                Log.v("weibo sdk rename", e.toString());
                if (cursor != null) {
                }
                str = null;
                if (TextUtils.isEmpty(str)) {
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str);
                if (file.exists()) {
                }
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path2 = file.getPath();
                bufferedInputStream.close();
                fileOutputStream.close();
                return path2;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Calendar.getInstance().getTimeInMillis());
                sb.append(i == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
                str = sb.toString();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
            try {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                try {
                    dbt.O00000o0("weibo sdk copy", e.toString());
                    if (bufferedInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path22 = file.getPath();
                bufferedInputStream.close();
                fileOutputStream.close();
                return path22;
            } catch (Exception e4) {
                e = e4;
                dbt.O00000o0("weibo sdk copy", e.toString());
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused2) {
                        return null;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused3) {
                    throw th;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
