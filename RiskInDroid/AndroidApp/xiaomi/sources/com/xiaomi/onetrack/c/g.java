package com.xiaomi.onetrack.c;

import android.content.Context;
import com.xiaomi.onetrack.a.d;
import com.xiaomi.onetrack.d.c;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.q;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public class g {
    private static String h = "onetrack_netaccess_%s";
    private static SimpleDateFormat i = new SimpleDateFormat("yyyyMMdd");
    private static boolean j = false;
    private static volatile boolean k = true;
    /* access modifiers changed from: private */
    public static volatile boolean l = false;

    public static boolean a() {
        return j;
    }

    public static void a(boolean z) {
        j = z;
    }

    public static boolean b() {
        return !new File(a.a().getFilesDir(), ".ot_net_disallowed").exists();
    }

    public static void b(boolean z) {
        File file = new File(a.a().getFilesDir(), ".ot_net_allowed");
        File file2 = new File(a.a().getFilesDir(), ".ot_net_disallowed");
        if (z) {
            try {
                file.createNewFile();
                if (file2.exists()) {
                    file2.delete();
                }
            } catch (IOException e) {
                q.b("NetworkAccessManager", "setNetworkAccessStateEnabled: " + z + "failed ", e);
            }
        } else {
            file2.createNewFile();
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static String d() {
        Context a2 = a.a();
        return a2.getFilesDir().getAbsolutePath() + File.separator + "networkAccess";
    }

    public static void a(String str, String str2) {
        j.a(new h(str, str2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
    /* access modifiers changed from: private */
    public static synchronized void c(String str, String str2) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        synchronized (g.class) {
            File file = new File(d(), String.format(h, i.format(new Date())));
            BufferedWriter bufferedWriter2 = null;
            try {
                if (!file.exists()) {
                    if (file.getParentFile().exists()) {
                        file.createNewFile();
                    } else {
                        new File(file.getParentFile().getAbsolutePath()).mkdirs();
                        file.createNewFile();
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("eventName", str);
                jSONObject.put("data", str2);
                byte[] a2 = b.a(jSONObject.toString());
                fileWriter = new FileWriter(file, true);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (Exception e) {
                    e = e;
                    try {
                        q.b("NetworkAccessManager", "cta doSaveData error: " + e.toString());
                        e.printStackTrace();
                        n.a(bufferedWriter2);
                        n.a(fileWriter);
                    } catch (Throwable th) {
                        th = th;
                        n.a(bufferedWriter2);
                        n.a(fileWriter);
                        throw th;
                    }
                }
                try {
                    bufferedWriter.write(c.a(a2));
                    bufferedWriter.newLine();
                    k = true;
                    n.a(bufferedWriter);
                    n.a(fileWriter);
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter2 = bufferedWriter;
                    q.b("NetworkAccessManager", "cta doSaveData error: " + e.toString());
                    e.printStackTrace();
                    n.a(bufferedWriter2);
                    n.a(fileWriter);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    n.a(bufferedWriter2);
                    n.a(fileWriter);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                q.b("NetworkAccessManager", "cta doSaveData error: " + e.toString());
                e.printStackTrace();
                n.a(bufferedWriter2);
                n.a(fileWriter);
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
                n.a(bufferedWriter2);
                n.a(fileWriter);
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        return;
     */
    public static synchronized void c(boolean z) {
        synchronized (g.class) {
            try {
                File file = new File(d());
                if (file.exists()) {
                    if (file.isDirectory()) {
                        String format = i.format(new Date());
                        String format2 = String.format(h, format);
                        File[] listFiles = file.listFiles();
                        for (int i2 = 0; i2 < listFiles.length; i2++) {
                            if (listFiles[i2].isFile() && (z || !listFiles[i2].getName().equalsIgnoreCase(format2))) {
                                listFiles[i2].delete();
                            }
                        }
                        if (listFiles.length == 0) {
                            k = false;
                        }
                    }
                }
                k = false;
            } catch (Exception e) {
                q.b("NetworkAccessManager", "cta removeObsoleteEvent error: " + e.toString());
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a4  */
    public static synchronized List<JSONObject> c() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e;
        synchronized (g.class) {
            File file = new File(d(), String.format(h, i.format(new Date())));
            if (!file.exists()) {
                return null;
            }
            List<JSONObject> arrayList = new ArrayList<>();
            try {
                fileReader = new FileReader(file);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            arrayList.add(new JSONObject(b.a(c.a(readLine))));
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                q.b("NetworkAccessManager", "cta getCacheData error: " + e.toString());
                                e.printStackTrace();
                                n.a(bufferedReader);
                                n.a(fileReader);
                                if (arrayList.size() > 100) {
                                }
                                if (arrayList.size() > 0) {
                                }
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                n.a(bufferedReader);
                                n.a(fileReader);
                                throw th;
                            }
                        }
                    }
                    n.a(bufferedReader);
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    q.b("NetworkAccessManager", "cta getCacheData error: " + e.toString());
                    e.printStackTrace();
                    n.a(bufferedReader);
                    n.a(fileReader);
                    if (arrayList.size() > 100) {
                    }
                    if (arrayList.size() > 0) {
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    n.a(bufferedReader);
                    n.a(fileReader);
                    throw th;
                }
            } catch (Exception e4) {
                fileReader = null;
                e = e4;
                bufferedReader = null;
                q.b("NetworkAccessManager", "cta getCacheData error: " + e.toString());
                e.printStackTrace();
                n.a(bufferedReader);
                n.a(fileReader);
                if (arrayList.size() > 100) {
                }
                if (arrayList.size() > 0) {
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fileReader = null;
                n.a(bufferedReader);
                n.a(fileReader);
                throw th;
            }
            n.a(fileReader);
            if (arrayList.size() > 100) {
                arrayList = arrayList.subList(arrayList.size() - 100, arrayList.size());
            }
            if (arrayList.size() > 0) {
                k = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        return;
     */
    public static synchronized void a(d dVar) {
        synchronized (g.class) {
            if (dVar != null) {
                if (b()) {
                    if (!l) {
                        if (k) {
                            l = true;
                            j.a(new i(dVar));
                        }
                    }
                }
            }
        }
    }
}
