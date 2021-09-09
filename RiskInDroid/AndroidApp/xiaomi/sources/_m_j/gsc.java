package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public final class gsc {
    private static String O0000Oo0(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
    }

    public static String O000000o(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : "";
    }

    @TargetApi(19)
    public static String O000000o(Context context, Uri uri) {
        Uri uri2 = null;
        if (uri != null) {
            if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return O000000o(context, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str = split[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return O000000o(context, uri2, "_id=?", new String[]{split[1]});
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    private static String O000000o(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static File O00000Oo(Context context, Uri uri) {
        String O000000o2 = O000000o(context, uri);
        if (!TextUtils.isEmpty(O000000o2)) {
            return new File(O000000o2);
        }
        return null;
    }

    public static String O00000Oo(String str) {
        String O000000o2;
        if (TextUtils.isEmpty(str)) {
            return "application/octet-stream";
        }
        String O0000Oo0 = O0000Oo0(str);
        return (TextUtils.isEmpty(O0000Oo0) || (O000000o2 = gtb.O000000o(O000000o(O0000Oo0))) == null) ? "application/octet-stream" : O000000o2;
    }

    public static void O000000o(Context context, Uri uri, byte[] bArr) throws IOException {
        File O00000Oo = O00000Oo(context, uri);
        if (O00000Oo != null) {
            O000000o(O00000Oo, bArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f  */
    private static void O000000o(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File '" + file + "' does not exist");
            } else if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (file.canRead()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } else {
                throw new IOException("File '" + file + "' cannot be read");
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static byte[] O00000o0(Context context, Uri uri) throws IOException {
        File O00000Oo = O00000Oo(context, uri);
        if (O00000Oo != null) {
            return O000000o(O00000Oo);
        }
        return new byte[0];
    }

    public static boolean O00000Oo(File file) {
        return O0000Oo(file.getAbsolutePath());
    }

    private static boolean O0000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        File file2 = new File(sb.toString());
        file.renameTo(file2);
        return file2.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x004d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static void O000000o(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            if (new File(str).exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream = fileInputStream2;
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                fileInputStream.close();
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        fileInputStream.close();
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream == null) {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    fileInputStream.close();
                    fileOutputStream.close();
                    throw th;
                }
            } else {
                fileOutputStream = null;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileInputStream == null && fileOutputStream != null) {
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (!(fileInputStream == null || fileOutputStream == null)) {
                fileInputStream.close();
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static String O00000o0(String str) {
        File file = new File(str);
        if (!file.isFile()) {
            return "";
        }
        try {
            return O000000o((InputStream) new FileInputStream(file));
        } catch (FileNotFoundException | IOException unused) {
            return "";
        }
    }

    private static String O000000o(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append("\n");
            } else {
                inputStream.close();
                return sb.toString();
            }
        }
    }

    public static boolean O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory() || !file.delete()) {
            return false;
        }
        return true;
    }

    public static void O00000oO(String str) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists()) {
                            O00000oO(file2.getAbsolutePath());
                        }
                    }
                }
                file.delete();
            }
        }
    }

    public static boolean O00000oo(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String O000000o(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A[SYNTHETIC, Splitter:B:22:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045 A[SYNTHETIC, Splitter:B:27:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public static boolean O00000Oo(String str, String str2) {
        PrintWriter printWriter = null;
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            } else {
                file.mkdirs();
                file.createNewFile();
            }
            PrintWriter printWriter2 = new PrintWriter(file);
            try {
                printWriter2.write(str);
                printWriter2.flush();
                try {
                    printWriter2.close();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (Exception e2) {
                e = e2;
                printWriter = printWriter2;
                try {
                    e.printStackTrace();
                    if (printWriter != null) {
                        return false;
                    }
                    try {
                        printWriter.close();
                        return false;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                printWriter = printWriter2;
                if (printWriter != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (printWriter != null) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0040  */
    public static String O0000O0o(String str) throws IOException {
        String str2;
        File file = new File(str);
        FileReader fileReader = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                char[] cArr = new char[((int) file.length())];
                fileReader2.read(cArr);
                str2 = new String(cArr);
                fileReader2.close();
                fileReader2.close();
            } catch (Exception e) {
                e = e;
                fileReader = fileReader2;
                try {
                    e.printStackTrace();
                    if (fileReader != null) {
                    }
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        fileReader2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
            e.printStackTrace();
            if (fileReader != null) {
            }
            return str2;
        }
        return str2;
    }

    public static byte[] O0000OOo(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e) {
            gsy.O000000o(6, "file2Byte", "file2Byte FileNotFoundException:" + e.getLocalizedMessage());
            return null;
        } catch (IOException e2) {
            gsy.O000000o(6, "file2Byte", "file2Byte IOException:" + e2.getLocalizedMessage());
            return null;
        }
    }

    public static long O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        long j = 0;
        if (outputStream == null) {
            return 0;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream2.write(bArr, 0, read);
                            j += (long) read;
                        } else {
                            bufferedOutputStream2.flush();
                            O000000o((Closeable) bufferedInputStream);
                            O000000o(bufferedOutputStream2);
                            return j;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        O000000o((Closeable) bufferedInputStream);
                        O000000o(bufferedOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                O000000o((Closeable) bufferedInputStream);
                O000000o(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            O000000o((Closeable) bufferedInputStream);
            O000000o(bufferedOutputStream);
            throw th;
        }
    }

    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                gsy.O000000o(5, "TAG", "RnPluginFileUtils#close, close error:" + Log.getStackTraceString(e));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    public static byte[] O000000o(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File '" + file + "' does not exist");
            } else if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (file.canRead()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long length = file.length();
                    if (length <= 2147483647L) {
                        int i = (int) length;
                        int i2 = 0;
                        if (i == 0) {
                            byte[] bArr = new byte[0];
                            fileInputStream2.close();
                            return bArr;
                        }
                        byte[] bArr2 = new byte[i];
                        while (i2 < i) {
                            int read = fileInputStream2.read(bArr2, i2, i - i2);
                            if (read == -1) {
                                break;
                            }
                            i2 += read;
                        }
                        if (i2 == i) {
                            fileInputStream2.close();
                            return bArr2;
                        }
                        throw new IOException("Unexpected read size. current: " + i2 + ", expected: " + i);
                    }
                    throw new IllegalArgumentException("Size cannot be greater than Integer max value: ".concat(String.valueOf(length)));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } else {
                throw new IOException("File '" + file + "' cannot be read");
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }
}
