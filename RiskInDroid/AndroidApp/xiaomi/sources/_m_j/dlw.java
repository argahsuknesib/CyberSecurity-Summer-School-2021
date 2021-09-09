package _m_j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

final class dlw {
    static int O000000o() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new dlx()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    static int O00000Oo() {
        int i = 0;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i = Integer.valueOf(trim).intValue();
            }
        } catch (Exception e) {
            dlv.O0000OoO.O00000Oo((Throwable) e);
        }
        return i * 1000;
    }

    static String O00000o() {
        String[] strArr = {"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i = 2; i < split.length; i++) {
                strArr[0] = strArr[0] + split[i] + " ";
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return strArr[0];
    }

    static int O00000o0() {
        int i = 0;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i = Integer.valueOf(trim).intValue();
            }
        } catch (Throwable th) {
            dlv.O0000OoO.O00000Oo(th);
        }
        return i * 1000;
    }
}
