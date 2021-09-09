package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class l {
    private static LruCache<String, a> d = new m(ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);

    static class a {

        /* renamed from: a  reason: collision with root package name */
        String f6176a;

        private a() {
        }

        /* synthetic */ a(m mVar) {
            this();
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            BufferedWriter bufferedWriter = null;
            try {
                a aVar = new a(null);
                aVar.f6176a = str2;
                d.put(str, aVar);
                String b = b();
                File file = new File(b);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(b, str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2), 1024);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    n.a(bufferedWriter2);
                } catch (Exception e) {
                    bufferedWriter = bufferedWriter2;
                    e = e;
                    try {
                        q.c("FileUtil", "put error:" + e.toString());
                        n.a(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        n.a(bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    bufferedWriter = bufferedWriter2;
                    th = th2;
                    n.a(bufferedWriter);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                q.c("FileUtil", "put error:" + e.toString());
                n.a(bufferedWriter);
            }
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        a aVar = d.get(str);
        if (aVar != null) {
            return aVar.f6176a;
        }
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(b(), str);
            StringBuilder sb = new StringBuilder();
            if (file.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Exception e) {
                        e = e;
                        bufferedReader2 = bufferedReader;
                        try {
                            q.c("FileUtil", "get error:" + e.toString());
                            n.a(bufferedReader2);
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            n.a(bufferedReader2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        n.a(bufferedReader2);
                        throw th;
                    }
                }
            } else {
                bufferedReader = null;
            }
            String sb2 = sb.toString();
            a aVar2 = new a(null);
            aVar2.f6176a = sb2;
            d.put(str, aVar2);
            n.a(bufferedReader);
            return sb2;
        } catch (Exception e2) {
            e = e2;
            q.c("FileUtil", "get error:" + e.toString());
            n.a(bufferedReader2);
            return "";
        }
    }

    private static String b() {
        return c("onetrack");
    }

    public static String a() {
        return c("tombstone");
    }

    private static String c(String str) {
        String str2 = com.xiaomi.onetrack.f.a.a().getFilesDir().getAbsolutePath() + File.separator + str;
        File file = new File(str2);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static void b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                d.remove(str);
                File file = new File(b(), str);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            q.c("FileUtil", "clear error:" + e.toString());
        }
    }

    public static String a(String str, int i) {
        BufferedReader bufferedReader;
        try {
            File file = new File(str);
            StringBuilder sb = new StringBuilder();
            if (file.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                        if (sb.length() > i) {
                            break;
                        }
                    } catch (Exception e) {
                        e = e;
                        try {
                            q.c("FileUtil", "get error:" + e.toString());
                            n.a(bufferedReader);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            n.a(bufferedReader);
                            throw th;
                        }
                    }
                }
            } else {
                bufferedReader = null;
            }
            if (sb.length() > i) {
                String substring = sb.substring(0, i - 1);
                n.a(bufferedReader);
                return substring;
            }
            String sb2 = sb.toString();
            n.a(bufferedReader);
            return sb2;
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
            q.c("FileUtil", "get error:" + e.toString());
            n.a(bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            n.a(bufferedReader);
            throw th;
        }
    }

    public static void a(File file) {
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        } catch (Exception e) {
            q.c("FileUtil", "failed to remove file: " + file.getName() + "," + e.toString());
        }
    }
}
