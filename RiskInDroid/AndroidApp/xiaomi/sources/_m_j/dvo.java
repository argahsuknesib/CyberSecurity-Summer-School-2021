package _m_j;

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
import java.util.HashMap;
import java.util.List;

public final class dvo {
    public static String O000000o(duy duy) {
        return duy.O00000oO + "#" + duy.O00000oo + "#" + duy.O0000O0o + "#" + duy.f14964O000000o;
    }

    private static void O000000o(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Exception e;
        if (!TextUtils.isEmpty(str) && hashMap != null && hashMap.size() != 0) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    for (String next : hashMap.keySet()) {
                        bufferedWriter.write(next + "%%%" + hashMap.get(next));
                        bufferedWriter.newLine();
                    }
                    ele.O000000o(bufferedWriter);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        duv.O000000o(e);
                        ele.O000000o(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        ele.O000000o(bufferedWriter);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                bufferedWriter = null;
                e = e3;
                duv.O000000o(e);
                ele.O000000o(bufferedWriter);
            } catch (Throwable th2) {
                bufferedWriter = null;
                th = th2;
                ele.O000000o(bufferedWriter);
                throw th;
            }
        }
    }

    private static long[] O00000Oo(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            duv.O000000o(e);
            return null;
        }
    }

    private static HashMap<String, String> O00000o0(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("%%%");
                    if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        hashMap.put(split[0], split[1]);
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        duv.O000000o(e);
                        ele.O000000o(bufferedReader);
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        ele.O000000o(bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ele.O000000o(bufferedReader2);
                    throw th;
                }
            }
            ele.O000000o(bufferedReader2);
        } catch (Exception e2) {
            e = e2;
            duv.O000000o(e);
            ele.O000000o(bufferedReader);
            return hashMap;
        }
        return hashMap;
    }

    public static void O000000o(String str, duz[] duzArr) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        StringBuilder sb;
        String sb2;
        String str2 = str;
        duz[] duzArr2 = duzArr;
        if (duzArr2.length > 0 && !TextUtils.isEmpty(str)) {
            FileLock fileLock = null;
            try {
                File file = new File(str2 + ".lock");
                ele.O00000o0(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    HashMap<String, String> O00000o0 = O00000o0(str);
                    for (duz duz : duzArr2) {
                        if (duz != null) {
                            String O000000o2 = O000000o((duy) duz);
                            long j = ((duy) duz).O00000Oo;
                            long j2 = ((duy) duz).O00000o0;
                            if (!TextUtils.isEmpty(O000000o2) && j > 0 && j2 >= 0) {
                                String str3 = O00000o0.get(O000000o2);
                                if (TextUtils.isEmpty(str3)) {
                                    sb2 = j + "#" + j2;
                                } else {
                                    long[] O00000Oo = O00000Oo(str3);
                                    if (O00000Oo != null && O00000Oo[0] > 0) {
                                        if (O00000Oo[1] >= 0) {
                                            sb = new StringBuilder();
                                            sb.append(j + O00000Oo[0]);
                                            sb.append("#");
                                            sb.append(j2 + O00000Oo[1]);
                                            sb2 = sb.toString();
                                        }
                                    }
                                    sb = new StringBuilder();
                                    sb.append(j);
                                    sb.append("#");
                                    sb.append(j2);
                                    sb2 = sb.toString();
                                }
                                O00000o0.put(O000000o2, sb2);
                            }
                        }
                    }
                    O000000o(str2, O00000o0);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            duv.O000000o(e);
                        }
                    }
                    ele.O000000o(randomAccessFile);
                } catch (Throwable unused) {
                    try {
                        duv.O00000o0("failed to write perf to file ");
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            duv.O000000o(e2);
                        }
                        ele.O000000o(randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            duv.O000000o(e3);
                        }
                        ele.O000000o(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                ele.O000000o(randomAccessFile);
                throw th;
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (5) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.RandomAccessFile, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00e3, code lost:
        if (r2 == null) goto L_0x00e8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a A[Catch:{ Exception -> 0x00ab, all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x004b A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static List<String> O000000o(String str) {
        BufferedReader bufferedReader;
        FileLock fileLock;
        BufferedReader bufferedReader2;
        File file;
        BufferedReader bufferedReader3;
        BufferedReader bufferedReader4;
        BufferedReader bufferedReader5;
        FileLock fileLock2;
        FileLock fileLock3;
        ? randomAccessFile;
        BufferedReader bufferedReader6;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return arrayList;
        }
        FileLock fileLock4 = null;
        try {
            file = new File(str + ".lock");
            try {
                ele.O00000o0(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Exception e) {
                e = e;
                bufferedReader5 = null;
                bufferedReader3 = bufferedReader5;
                bufferedReader4 = bufferedReader5;
                try {
                    duv.O000000o(e);
                    try {
                        fileLock4.release();
                    } catch (IOException e2) {
                        duv.O000000o(e2);
                    }
                    ele.O000000o(bufferedReader4);
                    ele.O000000o(bufferedReader3);
                } catch (Throwable th) {
                    th = th;
                    fileLock = fileLock4;
                    bufferedReader = bufferedReader3;
                    bufferedReader2 = bufferedReader4;
                    try {
                        fileLock.release();
                    } catch (IOException e3) {
                        duv.O000000o(e3);
                    }
                    ele.O000000o((Closeable) bufferedReader2);
                    ele.O000000o((Closeable) bufferedReader);
                    if (file != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileLock3 = null;
                fileLock = fileLock3;
                fileLock2 = fileLock3;
                bufferedReader = fileLock;
                bufferedReader2 = fileLock2;
                fileLock.release();
                ele.O000000o((Closeable) bufferedReader2);
                ele.O000000o((Closeable) bufferedReader);
                if (file != null) {
                }
                throw th;
            }
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e4) {
                e = e4;
                bufferedReader3 = null;
                bufferedReader4 = randomAccessFile;
                duv.O000000o(e);
                fileLock4.release();
                ele.O000000o(bufferedReader4);
                ele.O000000o(bufferedReader3);
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
                fileLock2 = randomAccessFile;
                bufferedReader = fileLock;
                bufferedReader2 = fileLock2;
                fileLock.release();
                ele.O000000o((Closeable) bufferedReader2);
                ele.O000000o((Closeable) bufferedReader);
                if (file != null) {
                }
                throw th;
            }
            try {
                BufferedReader bufferedReader7 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader7.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("%%%");
                        if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                            duy O00000o = O00000o(split[0]);
                            String str2 = split[1];
                            if (O00000o != null) {
                                long[] O00000Oo = O00000Oo(str2);
                                if (O00000Oo != null) {
                                    O00000o.O00000Oo = O00000Oo[0];
                                    O00000o.O00000o0 = O00000Oo[1];
                                    if (O00000o == null) {
                                        arrayList.add(O00000o.O00000Oo());
                                    }
                                }
                            }
                            O00000o = null;
                            if (O00000o == null) {
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedReader6 = bufferedReader7;
                        fileLock4 = fileLock;
                        bufferedReader4 = randomAccessFile;
                        bufferedReader3 = bufferedReader6;
                        duv.O000000o(e);
                        fileLock4.release();
                        ele.O000000o(bufferedReader4);
                        ele.O000000o(bufferedReader3);
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader2 = randomAccessFile;
                        bufferedReader = bufferedReader7;
                        fileLock.release();
                        ele.O000000o((Closeable) bufferedReader2);
                        ele.O000000o((Closeable) bufferedReader);
                        if (file != null) {
                        }
                        throw th;
                    }
                }
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e6) {
                        duv.O000000o(e6);
                    }
                }
                ele.O000000o((Closeable) randomAccessFile);
                ele.O000000o(bufferedReader7);
            } catch (Exception e7) {
                e = e7;
                bufferedReader6 = null;
                fileLock4 = fileLock;
                bufferedReader4 = randomAccessFile;
                bufferedReader3 = bufferedReader6;
                duv.O000000o(e);
                fileLock4.release();
                ele.O000000o(bufferedReader4);
                ele.O000000o(bufferedReader3);
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = 0;
                bufferedReader2 = randomAccessFile;
                fileLock.release();
                ele.O000000o((Closeable) bufferedReader2);
                ele.O000000o((Closeable) bufferedReader);
                if (file != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            file = null;
            bufferedReader5 = null;
            bufferedReader3 = bufferedReader5;
            bufferedReader4 = bufferedReader5;
            duv.O000000o(e);
            if (fileLock4 != null && fileLock4.isValid()) {
                fileLock4.release();
            }
            ele.O000000o(bufferedReader4);
            ele.O000000o(bufferedReader3);
        } catch (Throwable th6) {
            th = th6;
            file = null;
            fileLock3 = null;
            fileLock = fileLock3;
            fileLock2 = fileLock3;
            bufferedReader = fileLock;
            bufferedReader2 = fileLock2;
            if (fileLock != null && fileLock.isValid()) {
                fileLock.release();
            }
            ele.O000000o((Closeable) bufferedReader2);
            ele.O000000o((Closeable) bufferedReader);
            if (file != null) {
                file.delete();
            }
            throw th;
        }
        file.delete();
        return arrayList;
    }

    private static duy O00000o(String str) {
        duy duy = null;
        try {
            String[] split = TextUtils.isEmpty(str) ? null : str.split("#");
            if (split == null || split.length < 4 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1]) || TextUtils.isEmpty(split[2]) || TextUtils.isEmpty(split[3])) {
                return null;
            }
            duy duy2 = new duy();
            try {
                duy2.O00000oO = Integer.parseInt(split[0]);
                duy2.O00000oo = split[1];
                duy2.O0000O0o = Integer.parseInt(split[2]);
                duy2.f14964O000000o = Integer.parseInt(split[3]);
                return duy2;
            } catch (Exception unused) {
                duy = duy2;
                duv.O00000o0("parse per key error");
                return duy;
            }
        } catch (Exception unused2) {
            duv.O00000o0("parse per key error");
            return duy;
        }
    }
}
