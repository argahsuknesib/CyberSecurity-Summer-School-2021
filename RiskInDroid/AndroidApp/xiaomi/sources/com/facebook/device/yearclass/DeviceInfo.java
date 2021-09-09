package com.facebook.device.yearclass;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class DeviceInfo {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        /* class com.facebook.device.yearclass.DeviceInfo.AnonymousClass1 */

        public final boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    };

    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005d */
    public static int getCPUMaxFreqKHz() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int i = -1;
        for (int i2 = 0; i2 < getNumberOfCPUCores(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
                    fileInputStream2 = new FileInputStream(file);
                    fileInputStream2.read(bArr);
                    int i3 = 0;
                    while (bArr[i3] >= 48 && bArr[i3] <= 57 && i3 < 128) {
                        i3++;
                    }
                    Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                    if (valueOf.intValue() > i) {
                        i = valueOf.intValue();
                    }
                    fileInputStream2.close();
                }
            } catch (NumberFormatException ) {
                fileInputStream2.close();
            } catch (IOException unused) {
                return -1;
            } catch (Throwable th) {
                fileInputStream2.close();
                throw th;
            }
        }
        if (i != -1) {
            return i;
        }
        fileInputStream = new FileInputStream("/proc/cpuinfo");
        int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream) * 1000;
        if (parseFileForValue <= i) {
            parseFileForValue = i;
        }
        fileInputStream.close();
        return parseFileForValue;
    }

    @TargetApi(16)
    public static long getTotalMemory(Context context) {
        FileInputStream fileInputStream;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        long j = -1;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            j = ((long) parseFileForValue("MemTotal", fileInputStream)) * 1024;
            fileInputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
        return j;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            return extractValue(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (bArr[i] < 48 || bArr[i] > 57) {
                i++;
            } else {
                int i2 = i + 1;
                while (i2 < bArr.length && bArr[i2] >= 48 && bArr[i2] <= 57) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
        }
        return -1;
    }
}
