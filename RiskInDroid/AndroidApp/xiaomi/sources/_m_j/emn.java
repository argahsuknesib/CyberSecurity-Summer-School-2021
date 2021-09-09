package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

public final class emn {
    public static String O000000o(Context context) {
        String O00000Oo = emq.O000000o(context).O00000Oo("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(O00000Oo)) {
            return O00000Oo;
        }
        String O000000o2 = eml.O000000o(20);
        emq.O000000o(context).O000000o("sp_client_report_status", "sp_client_report_key", O000000o2);
        return O000000o2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e9, code lost:
        if (r7 == null) goto L_0x00ec;
     */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0105  */
    public static void O000000o(Context context, String str, String str2) {
        File file;
        RandomAccessFile randomAccessFile;
        Exception e;
        File externalFilesDir = context.getExternalFilesDir(str2);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            File externalFilesDir2 = context.getExternalFilesDir(str);
            if (externalFilesDir2 == null) {
                return;
            }
            if (!externalFilesDir2.exists()) {
                externalFilesDir2.mkdirs();
                return;
            }
            File[] listFiles = externalFilesDir2.listFiles(new emo());
            if (listFiles != null && listFiles.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                FileLock fileLock = null;
                RandomAccessFile randomAccessFile2 = null;
                File file2 = null;
                for (File file3 : listFiles) {
                    if (file3 != null) {
                        try {
                            if (!TextUtils.isEmpty(file3.getAbsolutePath())) {
                                file = new File(file3.getAbsolutePath() + ".lock");
                                try {
                                    ele.O00000o0(file);
                                    randomAccessFile = new RandomAccessFile(file, "rw");
                                    try {
                                        fileLock = randomAccessFile.getChannel().lock();
                                        File file4 = new File(externalFilesDir.getAbsolutePath() + File.separator + file3.getName() + currentTimeMillis);
                                        try {
                                            ele.O00000Oo(file3, file4);
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            file3.delete();
                                            file4.delete();
                                        }
                                        file3.delete();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e3) {
                                                duv.O000000o(e3);
                                            }
                                        }
                                        ele.O000000o(randomAccessFile);
                                    } catch (Exception e4) {
                                        e = e4;
                                        try {
                                            duv.O000000o(e);
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e5) {
                                                    duv.O000000o(e5);
                                                }
                                            }
                                            ele.O000000o(randomAccessFile);
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                fileLock.release();
                                            } catch (IOException e6) {
                                                duv.O000000o(e6);
                                            }
                                            ele.O000000o(randomAccessFile);
                                            if (file != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e7) {
                                    Exception exc = e7;
                                    randomAccessFile = randomAccessFile2;
                                    e = exc;
                                    duv.O000000o(e);
                                    fileLock.release();
                                    ele.O000000o(randomAccessFile);
                                } catch (Throwable th2) {
                                    th = th2;
                                    randomAccessFile = randomAccessFile2;
                                    fileLock.release();
                                    ele.O000000o(randomAccessFile);
                                    if (file != null) {
                                    }
                                    throw th;
                                }
                                file.delete();
                                randomAccessFile2 = randomAccessFile;
                                file2 = file;
                            }
                        } catch (Exception e8) {
                            file = file2;
                            randomAccessFile = randomAccessFile2;
                            e = e8;
                            duv.O000000o(e);
                            fileLock.release();
                            ele.O000000o(randomAccessFile);
                        } catch (Throwable th3) {
                            th = th3;
                            file = file2;
                            randomAccessFile = randomAccessFile2;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            ele.O000000o(randomAccessFile);
                            if (file != null) {
                                file.delete();
                            }
                            throw th;
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e9) {
                            duv.O000000o(e9);
                        }
                    }
                    ele.O000000o(randomAccessFile2);
                    if (file2 != null) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static void O000000o(Context context, List<String> list) {
        if (list != null && list.size() > 0 && O00000Oo(context)) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    O00000o0(context, next);
                }
            }
        }
    }

    @TargetApi(9)
    public static byte[] O000000o(String str) {
        byte[] copyOf = Arrays.copyOf(emi.O00000Oo(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    private static boolean O00000Oo(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static File[] O00000Oo(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new emp());
        }
        return null;
    }

    private static void O00000o0(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static boolean O000000o(Context context, String str) {
        File file = new File(str);
        long j = dvb.O000000o(context).O000000o().O00000o;
        if (file.exists()) {
            try {
                if (file.length() > j) {
                    return false;
                }
            } catch (Exception e) {
                duv.O000000o(e);
                return false;
            }
        } else {
            ele.O00000o0(file);
        }
        return true;
    }
}
