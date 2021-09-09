package com.miui.tsmclient.util;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException unused) {
            }
            closeQuietly((Closeable) outputStream);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static boolean copyAssetFileToPath(Context context, String str, String str2) {
        try {
            copyInputStreamToFile(context.getAssets().open(str), new File(str2));
            return true;
        } catch (IOException e) {
            LogUtils.e("copyAssetFileToFile failed.", e);
            return false;
        }
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, false);
            try {
                copyLarge(inputStream, fileOutputStream);
                fileOutputStream.close();
                closeQuietly((OutputStream) fileOutputStream);
                closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                closeQuietly((OutputStream) fileOutputStream);
                closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeQuietly((OutputStream) fileOutputStream);
            closeQuietly(inputStream);
            throw th;
        }
    }

    public static FileOutputStream openOutputStream(File file, boolean z) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (!file.isDirectory()) {
                return file.delete();
            }
            deleteDirectory(file);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: ".concat(String.valueOf(file)));
        }
        throw new IOException("Unable to delete file: ".concat(String.valueOf(file)));
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            IOException e = null;
            for (File forceDelete : file.listFiles()) {
                try {
                    forceDelete(forceDelete);
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (e != null) {
                throw e;
            } else if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }
}
