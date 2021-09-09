package com.alipay.security.mobile.module.d;

import com.alipay.security.mobile.module.a.a;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f3241a = "";
    private static String b = "";
    private static String c = "";

    public static synchronized void a(String str) {
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList);
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (d.class) {
            f3241a = str;
            b = str2;
            c = str3;
        }
    }

    public static synchronized void a(Throwable th) {
        String str;
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
            } else {
                str = "";
            }
            arrayList.add(str);
            a(arrayList);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        return;
     */
    private static synchronized void a(List<String> list) {
        synchronized (d.class) {
            if (!a.a(b)) {
                if (!a.a(c)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(c);
                    for (String valueOf : list) {
                        stringBuffer.append(", ".concat(String.valueOf(valueOf)));
                    }
                    stringBuffer.append("\n");
                    try {
                        File file = new File(f3241a);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(f3241a, b);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                        fileWriter.write(stringBuffer.toString());
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
