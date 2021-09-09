package com.facebook.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Files {
    private Files() {
    }

    static byte[] readFile(InputStream inputStream, long j) throws IOException {
        if (j > 2147483647L) {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
        } else if (j == 0) {
            return ByteStreams.toByteArray(inputStream);
        } else {
            return ByteStreams.toByteArray(inputStream, (int) j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    public static byte[] toByteArray(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] readFile = readFile(fileInputStream, fileInputStream.getChannel().size());
                fileInputStream.close();
                return readFile;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }
}
