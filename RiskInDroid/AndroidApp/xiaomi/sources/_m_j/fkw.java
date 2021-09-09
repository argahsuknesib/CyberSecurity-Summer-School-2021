package _m_j;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class fkw {
    public static String O000000o(String str) {
        File file = new File(str);
        String str2 = "";
        if (file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = str2 + readLine + "\n";
                }
                fileInputStream.close();
            } catch (FileNotFoundException | IOException unused) {
            }
        }
        return str2;
    }

    public static boolean O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(str2);
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            gsy.O000000o(6, "FileUtils", e.toString());
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0040 A[SYNTHETIC, Splitter:B:25:0x0040] */
    public static byte[] O000000o(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (Throwable th) {
                    gsy.O000000o(6, "FileUtils", Log.getStackTraceString(th));
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                try {
                    gsy.O000000o(6, "FileUtils", Log.getStackTraceString(th));
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th5) {
                    gsy.O000000o(6, "FileUtils", Log.getStackTraceString(th5));
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f A[SYNTHETIC, Splitter:B:18:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f A[SYNTHETIC, Splitter:B:23:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    public static boolean O000000o(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            O00000o(file);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (Throwable th) {
                    gsy.O000000o(6, "FileUtils", Log.getStackTraceString(th));
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        gsy.O000000o(6, "FileUtils", Log.getStackTraceString(th3));
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            gsy.O000000o(6, "FileUtils", Log.getStackTraceString(th));
            if (fileOutputStream != null) {
            }
        }
    }

    public static Parcel O00000Oo(File file) {
        Parcel O000000o2 = O000000o(O000000o(file));
        if (O000000o2 == null) {
            file.delete();
        }
        return O000000o2;
    }

    public static Parcel O000000o(byte[] bArr) {
        if (bArr != null) {
            try {
                Parcel obtain = Parcel.obtain();
                obtain.setDataCapacity(bArr.length);
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                return obtain;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static boolean O000000o(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        File O00000oo = O00000oo(str2);
        InputStream inputStream = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(O00000oo);
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
                inputStream = open;
                try {
                    gsy.O00000o0(LogType.PLUGIN, "FileUtils", "copyAsserts  " + e.toString());
                    O00000Oo(str2);
                    O000000o((Closeable) inputStream);
                    O000000o((Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    O000000o((Closeable) inputStream);
                    O000000o((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = open;
                O000000o((Closeable) inputStream);
                O000000o((Closeable) fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        O000000o((Closeable) open);
                        O000000o((Closeable) fileOutputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                inputStream = open;
                gsy.O00000o0(LogType.PLUGIN, "FileUtils", "copyAsserts  " + e.toString());
                O00000Oo(str2);
                O000000o((Closeable) inputStream);
                O000000o((Closeable) fileOutputStream);
                return false;
            } catch (Throwable th3) {
                th = th3;
                inputStream = open;
                O000000o((Closeable) inputStream);
                O000000o((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            gsy.O00000o0(LogType.PLUGIN, "FileUtils", "copyAsserts  " + e.toString());
            O00000Oo(str2);
            O000000o((Closeable) inputStream);
            O000000o((Closeable) fileOutputStream);
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            O000000o((Closeable) inputStream);
            O000000o((Closeable) fileOutputStream);
            throw th;
        }
    }

    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean O00000Oo(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return true;
            }
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists() && !O00000Oo(file2.getAbsolutePath(), new File(str2, file2.getName()).getAbsolutePath())) {
                    return false;
                }
            }
            return true;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(O00000oo(str2));
            byte[] bArr = new byte[2048];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileInputStream.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private static File O00000oo(String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        return file;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return O00000o0(new File(str));
    }

    public static boolean O00000o0(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File O00000o0 : listFiles) {
                O00000o0(O00000o0);
            }
        }
        return file.delete();
    }

    public static void O00000o0(String str) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists()) {
                            O00000o0(file2.getAbsolutePath());
                        }
                    }
                }
                file.delete();
            }
        }
    }

    public static void O00000o0(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    new File(str2).mkdirs();
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : file.listFiles()) {
                            if (file2 != null && file2.exists()) {
                                O00000o0(file2.getAbsolutePath(), new File(str2, file2.getName()).getAbsolutePath());
                            }
                        }
                    }
                    file.delete();
                    return;
                }
                file.renameTo(new File(str2));
            }
        }
    }

    public static void O00000o(String str) {
        File parentFile;
        if (!TextUtils.isEmpty(str) && (parentFile = new File(str).getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static File O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return O00000o(new File(str));
    }

    private static File O00000o(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            gsy.O00000o0(LogType.PLUGIN, "FileUtils", Log.getStackTraceString(e));
        }
        return file;
    }

    public static String O000000o(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, "UTF-8");
        } catch (IOException e) {
            gsy.O000000o(6, "FileUtils", Log.getStackTraceString(e));
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r0 = java.io.File.separator + "data" + java.io.File.separator + "data" + java.io.File.separator + r4.getPackageName() + java.io.File.separator + "files";
        new java.io.File(r0).mkdirs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0044, code lost:
        r4 = r4.getDir("files", 0);
        r4.mkdirs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return r4.getPath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000d */
    public static String O000000o(Context context) {
        return context.getFilesDir().getPath();
    }

    public static void O000000o(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                gsy.O000000o(6, "FileUtils", "close error:" + Log.getStackTraceString(e));
            }
        }
    }

    public static ParcelFileDescriptor O000000o(Context context, Uri uri, int i) throws FileNotFoundException {
        if (!TextUtils.equals("content", uri.getScheme()) && !TextUtils.equals("file", uri.getScheme())) {
            return ParcelFileDescriptor.open(new File(uri.toString()), i);
        }
        return context.getContentResolver().openFileDescriptor(uri, i != 536870912 ? i != 805306368 ? "r" : "rw" : "w");
    }
}
