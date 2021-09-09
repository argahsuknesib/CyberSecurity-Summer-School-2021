package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class euc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15818O000000o = "euc";
    private static final String[] O00000Oo = {"goldfish"};
    private static final String[] O00000o0 = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    public static boolean O000000o(Context context) {
        boolean z;
        euh.O000000o(f15818O000000o, "Emulator is start");
        boolean z2 = Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("Andy") || Build.PRODUCT.contains("Droid4X") || Build.PRODUCT.contains("nox") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("aries") || Build.MANUFACTURER.contains("Genymotion") || Build.MANUFACTURER.contains("Andy") || Build.MANUFACTURER.contains("nox") || Build.MANUFACTURER.contains("TiantianVM") || Build.BRAND.contains("Andy") || Build.DEVICE.contains("Andy") || Build.DEVICE.contains("Droid4X") || Build.DEVICE.contains("nox") || Build.DEVICE.contains("vbox86p") || Build.DEVICE.contains("aries") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || Build.MODEL.contains("Android SDK built for x86_64") || Build.MODEL.contains("Android SDK built for x86") || Build.HARDWARE.contains("vbox86") || Build.HARDWARE.contains("nox") || Build.HARDWARE.contains("ttVM_x86") || Build.FINGERPRINT.contains("generic/sdk/generic") || Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("generic/google_sdk/generic") || Build.FINGERPRINT.contains("vbox86p") || Build.FINGERPRINT.contains("generic/vbox86p/vbox86p");
        boolean z3 = O000000o(context, "com.example.android.apis") && O000000o(context, "com.android.development");
        String[] strArr = O00000o0;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return z2 || z3 || z || (O000000o("/proc/tty/drivers") || O000000o("/proc/cpuinfo")) || O000000o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[SYNTHETIC, Splitter:B:16:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[SYNTHETIC, Splitter:B:22:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    private static boolean O000000o() {
        String str;
        BufferedReader bufferedReader = null;
        try {
            Process start = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    str = "$unknown";
                    if (!str.contains("intel")) {
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            str = sb.toString().toLowerCase(Locale.getDefault());
            try {
                bufferedReader2.close();
            } catch (IOException unused2) {
            }
        } catch (Exception unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            str = "$unknown";
            return !str.contains("intel") ? true : true;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
        if (!str.contains("intel") && !str.contains("amd")) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A[SYNTHETIC, Splitter:B:20:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[SYNTHETIC, Splitter:B:31:0x0053] */
    private static boolean O000000o(String str) {
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileInputStream2.read(bArr);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                        }
                        String str2 = new String(bArr);
                        while (r3 < r2) {
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                String str22 = new String(bArr);
                while (r3 < r2) {
                }
                return false;
            }
            String str222 = new String(bArr);
            for (String contains : O00000Oo) {
                if (str222.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean O000000o(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
