package com.xiaomi.accountsdk.hasheddeviceidlib;

import com.xiaomi.accountsdk.utils.AccountLog;
import java.security.MessageDigest;

public class DeviceIDCoder {
    protected DeviceIDCoder() {
    }

    public static String getDataMd5Digest(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                return getHexString(instance.digest());
            } catch (Exception e) {
                AccountLog.e("AccountCoder", "getDataMd5Digest", e);
            }
        }
        return null;
    }

    public static String getHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] & 240) >> 4;
            sb.append((char) ((i2 < 0 || i2 > 9) ? (i2 + 97) - 10 : i2 + 48));
            byte b = bArr[i] & 15;
            sb.append((char) ((b < 0 || b > 9) ? (b + 97) - 10 : b + 48));
        }
        return sb.toString();
    }

    public static String getMd5DigestUpperCase(String str) {
        String dataMd5Digest;
        if (str == null || (dataMd5Digest = getDataMd5Digest(str.getBytes())) == null) {
            return null;
        }
        return dataMd5Digest.toUpperCase();
    }
}
