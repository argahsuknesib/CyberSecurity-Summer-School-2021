package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

public final class elm {
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d8 A[Catch:{ IOException -> 0x00e8 }, LOOP:1: B:45:0x00d2->B:47:0x00d8, LOOP_END] */
    private static boolean O00000Oo(Context context, String str, long j) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp");
        ArrayList<String> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ":" + context.getPackageName() + "," + currentTimeMillis;
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            ele.O000000o(bufferedReader);
                            break;
                        }
                        String[] split = readLine.split(":");
                        if (split.length == 2) {
                            if (TextUtils.equals(split[0], String.valueOf(str))) {
                                String[] split2 = split[1].split(",");
                                if (split2.length == 2) {
                                    long parseLong = Long.parseLong(split2[1]);
                                    if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j)) * 0.9f) {
                                        ele.O000000o(bufferedReader);
                                        return false;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                arrayList.add(readLine);
                            }
                        }
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th) {
                        th = th;
                        ele.O000000o(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                bufferedReader2 = null;
                try {
                    arrayList.clear();
                    ele.O000000o(bufferedReader2);
                    arrayList.add(str2);
                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                    try {
                        while (r0.hasNext()) {
                        }
                    } catch (IOException e) {
                        e = e;
                        try {
                            duv.O00000o(e.toString());
                            ele.O000000o(bufferedWriter);
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            ele.O000000o(bufferedWriter);
                            throw th;
                        }
                    }
                    ele.O000000o(bufferedWriter);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    ele.O000000o(bufferedReader);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                ele.O000000o(bufferedReader);
                throw th;
            }
        } else if (!ele.O00000o0(file)) {
            return true;
        }
        arrayList.add(str2);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String write : arrayList) {
                bufferedWriter.write(write);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e2) {
            e = e2;
            bufferedWriter = null;
            duv.O00000o(e.toString());
            ele.O000000o(bufferedWriter);
            return true;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
            ele.O000000o(bufferedWriter);
            throw th;
        }
        ele.O000000o(bufferedWriter);
        return true;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static boolean O000000o(Context context, String str, long j) {
        ? r2;
        RandomAccessFile randomAccessFile;
        if (Build.VERSION.SDK_INT >= 23) {
            if (!(context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0)) {
                return true;
            }
        }
        FileLock fileLock = null;
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp.lock");
            ele.O00000o0(file);
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                FileLock lock = randomAccessFile2.getChannel().lock();
                boolean O00000Oo = O00000Oo(context, str, j);
                if (lock != null && lock.isValid()) {
                    try {
                        lock.release();
                    } catch (IOException unused) {
                    }
                }
                ele.O000000o(randomAccessFile2);
                return O00000Oo;
            } catch (IOException e) {
                e = e;
                randomAccessFile = randomAccessFile2;
                try {
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    ele.O000000o((Closeable) randomAccessFile);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    r2 = randomAccessFile;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused3) {
                        }
                    }
                    ele.O000000o((Closeable) r2);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            randomAccessFile = fileLock;
            e.printStackTrace();
            fileLock.release();
            ele.O000000o((Closeable) randomAccessFile);
            return true;
        } catch (Throwable th2) {
            th = th2;
            r2 = fileLock;
            fileLock.release();
            ele.O000000o((Closeable) r2);
            throw th;
        }
    }
}
