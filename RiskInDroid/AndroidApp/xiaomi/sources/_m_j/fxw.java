package _m_j;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class fxw {
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012b A[SYNTHETIC, Splitter:B:60:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0136 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0139 A[SYNTHETIC, Splitter:B:67:0x0139] */
    public static void O000000o(File file) {
        StringBuilder sb;
        File file2;
        if (file.exists()) {
            ZipFile zipFile = null;
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        String name = zipEntry.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (!name.startsWith("lib/armeabi-v7a/")) {
                                if (!name.startsWith("lib/arm64-v8a/") && !name.endsWith(".so")) {
                                }
                            }
                            String substring = name.substring(name.lastIndexOf("/") + 1);
                            if (name.contains("lib/arm64-v8a/")) {
                                file2 = new File(O00000o());
                            } else {
                                file2 = new File(O00000o0());
                            }
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            File file3 = new File(file2, substring);
                            File file4 = new File(file2, "temp");
                            try {
                                if (file4.exists()) {
                                    file4.delete();
                                }
                                file4.createNewFile();
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry));
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file4));
                                byte[] bArr = new byte[16384];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                bufferedInputStream.close();
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                file4.renameTo(file3);
                            } catch (Exception e) {
                                file4.delete();
                                fyc.O00000o("ApkNativeLibHelper", "installNativeLibrary write so file error:" + Log.getStackTraceString(e));
                            }
                            fyc.O00000Oo("ApkNativeLibHelper", "installNativeLibrary: " + zipEntry.getName());
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException e2) {
                        e = e2;
                        sb = new StringBuilder("installNativeLibrary close zipFile error:");
                        sb.append(Log.getStackTraceString(e));
                        fyc.O00000o0("ApkNativeLibHelper", sb.toString());
                    }
                } catch (Throwable th) {
                    th = th;
                    if (zipFile2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fyc.O00000o("ApkNativeLibHelper", "installNativeLibrary error:" + Log.getStackTraceString(th));
                if (zipFile == null) {
                }
            }
        }
    }

    public static boolean O000000o(String str) {
        String str2;
        File file;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            if (!str.startsWith("lib")) {
                sb.append("lib");
            }
            sb.append(str);
            if (!str.endsWith(".so")) {
                sb.append(".so");
            }
            str2 = sb.toString();
        }
        if (O000000o()) {
            file = new File(O00000o(), str2);
        } else {
            file = new File(O00000o0(), str2);
        }
        String absolutePath = file.getAbsolutePath();
        try {
            if (new File(absolutePath).exists()) {
                System.load(absolutePath);
                return true;
            }
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            fyc.O00000o0("ApkNativeLibHelper", "loadLibrary error: IS_CPU_ARCH_ONLY_32=true,catched an exception:" + Log.getStackTraceString(th));
            return false;
        }
    }

    private static String O00000Oo() {
        return new File(CommonApplication.getApplication().getFilesDir().getParentFile(), "lib-rn-plugin").getAbsolutePath();
    }

    private static String O00000o0() {
        return new File(O00000Oo(), "armeabi-v7a").getAbsolutePath();
    }

    private static String O00000o() {
        return new File(O00000Oo(), "arm64-v8a").getAbsolutePath();
    }

    public static boolean O000000o() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return Os.readlink("/proc/self/exe").contains("64");
            } catch (Exception e) {
                fyc.O00000o0("ApkNativeLibHelper", "is64Bit, Os.readlink error:" + Log.getStackTraceString(e));
            }
        }
        String str = null;
        try {
            String str2 = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
            fyc.O000000o("ApkNativeLibHelper", "is64Bit, getCurrentInstructionSet:".concat(String.valueOf(str2)));
            if (!TextUtils.isEmpty(str2)) {
                return str2.contains("64");
            }
        } catch (Exception e2) {
            fyc.O00000o0("ApkNativeLibHelper", "is64Bit,getCurrentInstructionSet exception " + Log.getStackTraceString(e2));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                str = strArr[0];
            }
        } else {
            str = Build.CPU_ABI;
        }
        if (str != null) {
            str.contains("arm64");
        }
        return false;
    }
}
