package com.alipay.security.mobile.module.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class b {
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (r4 != null) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037 A[SYNTHETIC, Splitter:B:16:0x0037] */
    public static String a(String str, String str2) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(str, str2);
            if (!file.exists()) {
                return null;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
                try {
                    break;
                } catch (Throwable unused2) {
                }
            }
            bufferedReader.close();
            return sb.toString();
        } catch (IOException unused3) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }
}
