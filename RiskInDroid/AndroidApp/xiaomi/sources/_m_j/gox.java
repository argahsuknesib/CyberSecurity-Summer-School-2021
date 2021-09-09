package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class gox {
    public static String O000000o(Context context, boolean z) {
        if (context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            StringBuilder sb2 = new StringBuilder("total_mem ");
            double d = (double) memoryInfo.totalMem;
            Double.isNaN(d);
            sb2.append((d / 1024.0d) / 1024.0d);
            sb2.append("MB");
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder("avai_mem ");
            double d2 = (double) (memoryInfo.availMem >> 10);
            Double.isNaN(d2);
            sb3.append(d2 / 1024.0d);
            sb3.append("MB");
            sb.append(sb3.toString());
            sb.append("is_low_mem " + memoryInfo.lowMemory);
            StringBuilder sb4 = new StringBuilder("threshold ");
            double d3 = (double) memoryInfo.threshold;
            Double.isNaN(d3);
            sb4.append((d3 / 1024.0d) / 1024.0d);
            sb4.append("MB");
            sb.append(sb4.toString());
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                String str = "crash-" + new SimpleDateFormat().format(new Date()) + "-" + currentTimeMillis + ".hprof";
                File externalFilesDir = context.getExternalFilesDir("external");
                if (externalFilesDir != null) {
                    Debug.dumpHprofData(externalFilesDir.getPath() + "/crash_log/" + str);
                }
                Debug.MemoryInfo memoryInfo2 = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo2);
                StringBuilder sb5 = new StringBuilder("nat_mem ");
                double nativeHeapAllocatedSize = (double) Debug.getNativeHeapAllocatedSize();
                Double.isNaN(nativeHeapAllocatedSize);
                sb5.append((nativeHeapAllocatedSize / 1024.0d) / 1024.0d);
                sb5.append("MB");
                sb.append(sb5.toString());
                StringBuilder sb6 = new StringBuilder("nat_free_mem ");
                double nativeHeapFreeSize = (double) Debug.getNativeHeapFreeSize();
                Double.isNaN(nativeHeapFreeSize);
                sb6.append((nativeHeapFreeSize / 1024.0d) / 1024.0d);
                sb6.append("MB");
                sb.append(sb6.toString());
                StringBuilder sb7 = new StringBuilder("nat_heap_size ");
                double nativeHeapSize = (double) Debug.getNativeHeapSize();
                Double.isNaN(nativeHeapSize);
                sb7.append((nativeHeapSize / 1024.0d) / 1024.0d);
                sb7.append("MB");
                sb.append(sb7.toString());
                StringBuilder sb8 = new StringBuilder("d_priv_dir ");
                double d4 = (double) memoryInfo2.dalvikPrivateDirty;
                Double.isNaN(d4);
                sb8.append(d4 / 1024.0d);
                sb8.append("MB");
                sb.append(sb8.toString());
                sb.append("d_pss " + memoryInfo2.dalvikPss);
                sb.append("d_pss " + memoryInfo2.dalvikSharedDirty);
                sb.append("d_pss " + memoryInfo2.nativePrivateDirty);
                sb.append("d_pss " + memoryInfo2.nativePss);
                sb.append("d_pss " + memoryInfo2.nativeSharedDirty);
                sb.append("d_pss " + memoryInfo2.otherPrivateDirty);
                sb.append("d_pss " + memoryInfo2.otherPss);
                sb.append("d_pss " + memoryInfo2.otherSharedDirty);
            }
            StringBuilder sb9 = new StringBuilder("应用可使用最大内存 ");
            double maxMemory = (double) Runtime.getRuntime().maxMemory();
            Double.isNaN(maxMemory);
            sb9.append((maxMemory / 1024.0d) / 1024.0d);
            sb9.append("MB");
            sb.append(sb9.toString());
            StringBuilder sb10 = new StringBuilder("应用空闲内存 ");
            double freeMemory = (double) Runtime.getRuntime().freeMemory();
            Double.isNaN(freeMemory);
            sb10.append((freeMemory / 1024.0d) / 1024.0d);
            sb10.append("MB");
            sb.append(sb10.toString());
            StringBuilder sb11 = new StringBuilder("应用占用总内存 ");
            double d5 = (double) Runtime.getRuntime().totalMemory();
            Double.isNaN(d5);
            sb11.append((d5 / 1024.0d) / 1024.0d);
            sb11.append("MB");
            sb.append(sb11.toString());
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return th.getMessage();
        }
    }

    public static String O000000o() {
        StringBuilder sb = new StringBuilder();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/status", "r");
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
                sb2.append("\r\n");
            }
            randomAccessFile.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean O000000o(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context.getApplicationInfo().targetSdkVersion < 23) {
            if (g.O000000o(context, str, Binder.getCallingPid(), Binder.getCallingUid(), context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } else if (context.checkSelfPermission(str) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void O000000o(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String O000000o(Context context) {
        String str;
        if (context == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() >= 32) {
            return str.substring(0, 32);
        }
        StringBuilder sb = new StringBuilder(str);
        for (int length = str.length(); length < 32; length++) {
            sb.append(str.charAt(length % str.length()));
        }
        return sb.toString();
    }
}
