package _m_j;

import com.tencent.bugly.crashreport.CrashReport;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class exs implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    String f15930O000000o;
    String O00000Oo;

    public exs(String str, String str2) {
        this.f15930O000000o = str;
        this.O00000Oo = str2;
    }

    private static String O000000o(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private void O000000o(ZipFile zipFile, ZipEntry zipEntry, String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(new File(this.O00000Oo + File.separator + str, str2));
            } catch (IOException e) {
                e = e;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            CrashReport.O000000o(e);
            fileOutputStream = null;
            O000000o(inputStream, fileOutputStream);
        }
        O000000o(inputStream, fileOutputStream);
    }

    private static void O000000o(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] bArr = null;
            try {
                int available = bufferedInputStream.available();
                if (available <= 0) {
                    available = 1024;
                }
                bArr = new byte[available];
            } catch (IOException e) {
                CrashReport.O000000o(e);
            }
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e2) {
                    CrashReport.O000000o(e2);
                }
                try {
                    break;
                } catch (IOException e3) {
                    CrashReport.O000000o(e3);
                    return;
                }
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
        }
    }

    private static void O00000Oo(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d7 A[SYNTHETIC, Splitter:B:32:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dd A[SYNTHETIC, Splitter:B:36:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    public final void run() {
        new File(this.O00000Oo).mkdirs();
        dgn.O000000o("PluginSoManager", "write file path " + this.O00000Oo);
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(this.f15930O000000o);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        String name = zipEntry.getName();
                        if (name.endsWith(".so")) {
                            if (name.contains("arm64-v8a")) {
                                O00000Oo(this.O00000Oo + File.separator + "arm64-v8a");
                                O000000o(zipFile2, zipEntry, "arm64-v8a", O000000o(name));
                            } else if (name.contains("armeabi-v7a")) {
                                O00000Oo(this.O00000Oo + File.separator + "armeabi-v7a");
                                O000000o(zipFile2, zipEntry, "armeabi-v7a", O000000o(name));
                            } else if (name.contains("armeabi")) {
                                O00000Oo(this.O00000Oo + File.separator + "armeabi");
                                O000000o(zipFile2, zipEntry, "armeabi", O000000o(name));
                            }
                        }
                    }
                }
                try {
                    zipFile2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e) {
                e = e;
                zipFile = zipFile2;
                try {
                    CrashReport.O000000o(e);
                    if (zipFile == null) {
                        try {
                            zipFile.close();
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            CrashReport.O000000o(e);
            if (zipFile == null) {
            }
        }
    }
}
