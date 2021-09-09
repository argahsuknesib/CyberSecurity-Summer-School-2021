package com.xiaomi.mico.common.util;

import _m_j.ahh;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class IOUtils {
    public static final String[] SUPPORTED_IMAGE_FORMATS = {"jpg", "png", "bmp", "gif", "webp"};

    public static void closeQuietly(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
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

    /* JADX WARNING: Can't wrap try/catch for region: R(5:1|2|3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    public static void closeQuietly(OutputStream outputStream) {
        if (outputStream != null) {
            outputStream.flush();
            outputStream.close();
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, 4096);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
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

    public static void copyFile(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (!file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream2);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read >= 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            closeQuietly(fileInputStream);
                            closeQuietly(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream2);
                throw th;
            }
        }
    }

    public static void hideFromMediaScanner(File file) {
        File file2 = new File(file, ".nomedia");
        if (!file2.exists() || !file2.isFile()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                ahh.O000000o(e);
            }
        }
    }

    public static byte[] getFileSha1Digest(String str) throws NoSuchAlgorithmException, IOException {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                instance.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                return instance.digest();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[SYNTHETIC, Splitter:B:24:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[SYNTHETIC, Splitter:B:28:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public static String getFileSHA1Digest(String str) {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                BigInteger bigInteger = new BigInteger(1, instance.digest());
                fileInputStream2.close();
                String format = String.format("%1$040X", bigInteger);
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return format;
            } catch (Exception e) {
                e = e;
                fileInputStream = fileInputStream2;
                try {
                    Object[] objArr = {"getSHA1Digest", e};
                    if (fileInputStream != null) {
                        return "";
                    }
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (Exception unused2) {
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Object[] objArr2 = {"getSHA1Digest", e};
            if (fileInputStream != null) {
            }
        }
    }

    public static void deleteDirs(File file) {
        new Object[1][0] = "deleteDirs filePath = " + file.getAbsolutePath();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else {
                        deleteDirs(file2);
                    }
                }
            }
            file.delete();
        }
    }

    public static String getFileSuffix(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(lastIndexOf + 1) : "";
    }

    public static boolean isSupportImageSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String equalsIgnoreCase : SUPPORTED_IMAGE_FORMATS) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
