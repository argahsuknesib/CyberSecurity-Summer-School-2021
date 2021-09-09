package com.alipay.sdk.encrypt;

import com.alipay.sdk.util.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class d {
    private static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:13:0x0039 */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[SYNTHETIC, Splitter:B:24:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A[SYNTHETIC, Splitter:B:30:0x0055] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static byte[] a(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        ? r0 = 0;
        try {
            PublicKey b = b("RSA", str2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, b);
            byte[] bytes = str.getBytes("UTF-8");
            int blockSize = instance.getBlockSize();
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (i < bytes.length) {
                try {
                    byteArrayOutputStream.write(instance.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                    i += blockSize;
                } catch (Exception e) {
                    e = e;
                    try {
                        c.a(e);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return r0;
                    } catch (Throwable th) {
                        th = th;
                        r0 = byteArrayOutputStream;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (IOException e2) {
                                c.a(e2);
                            }
                        }
                        throw th;
                    }
                }
            }
            r0 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                c.a(e3);
                r0 = r0;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            c.a(e);
            if (byteArrayOutputStream != null) {
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
            }
            throw th;
        }
        return r0;
    }
}
