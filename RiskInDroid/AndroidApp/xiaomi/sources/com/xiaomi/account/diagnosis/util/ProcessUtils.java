package com.xiaomi.account.diagnosis.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessUtils {
    private ProcessUtils() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC, Splitter:B:15:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[SYNTHETIC, Splitter:B:23:0x003d] */
    public static String getProcessName(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }
}
