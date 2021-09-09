package com.facebook.appevents.internal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

final class HashUtils {
    HashUtils() {
    }

    public static final String computeChecksum(String str) throws Exception {
        return computeFileMd5(new File(str));
    }

    private static String computeFileMd5(File file) throws Exception {
        Throwable th;
        int read;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            } while (read != -1);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            bufferedInputStream.close();
            return bigInteger;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
