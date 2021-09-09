package _m_j;

import android.app.ActivityManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

final class byf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f13405O000000o;
    private static long O00000Oo;

    class O000000o implements FileFilter {
        O000000o() {
        }

        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static int O000000o() {
        if (f13405O000000o == 0) {
            try {
                f13405O000000o = new File("/sys/devices/system/cpu/").listFiles(new O000000o()).length;
            } catch (Exception e) {
                Log.e("PerformanceUtils", "getNumCores exception", e);
                f13405O000000o = 1;
            }
        }
        return f13405O000000o;
    }

    public static long O00000Oo() {
        bxw.O00000Oo();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) bxv.O00000oo().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051 A[SYNTHETIC, Splitter:B:24:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[SYNTHETIC, Splitter:B:28:0x0059] */
    public static long O00000o0() {
        if (O00000Oo == 0) {
            long j = -1;
            FileReader fileReader = null;
            try {
                FileReader fileReader2 = new FileReader("/proc/meminfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader2, 8192);
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        j = (long) Integer.valueOf(readLine.split("\\s+")[1]).intValue();
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e = e;
                    fileReader = fileReader2;
                    try {
                        Log.e("PerformanceUtils", "getTotalMemory exception = ", e);
                        if (fileReader != null) {
                        }
                        O00000Oo = j;
                        return O00000Oo;
                    } catch (Throwable th) {
                        th = th;
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (IOException e2) {
                                Log.e("PerformanceUtils", "close localFileReader exception = ", e2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader2 != null) {
                    }
                    throw th;
                }
                try {
                    fileReader2.close();
                } catch (IOException e3) {
                    Log.e("PerformanceUtils", "close localFileReader exception = ", e3);
                }
            } catch (IOException e4) {
                e = e4;
                Log.e("PerformanceUtils", "getTotalMemory exception = ", e);
                if (fileReader != null) {
                    fileReader.close();
                }
                O00000Oo = j;
                return O00000Oo;
            }
            O00000Oo = j;
        }
        return O00000Oo;
    }
}
