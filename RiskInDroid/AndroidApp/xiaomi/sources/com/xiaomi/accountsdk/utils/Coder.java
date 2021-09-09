package com.xiaomi.accountsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Coder {
    public static String hash4SHA1(String str) {
        return hash4SHA1(str, 2);
    }

    public static String hash4SHA1(String str, int i) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.encodeToString(hash4SHA1(str.getBytes("UTF-8")), i);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static byte[] hash4SHA1(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String getMd5DigestUpperCase(String str) {
        String dataMd5Digest;
        if (str == null || (dataMd5Digest = getDataMd5Digest(str.getBytes())) == null) {
            return null;
        }
        return dataMd5Digest.toUpperCase();
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

    public static String generateSignature(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            if (str2 != null) {
                arrayList.add(Uri.parse(str2).getEncodedPath());
            }
            boolean z = true;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            arrayList.add(str3);
            StringBuilder sb = new StringBuilder();
            for (String str4 : arrayList) {
                if (!z) {
                    sb.append('&');
                }
                sb.append(str4);
                z = false;
            }
            return hash4SHA1(sb.toString());
        }
        throw new InvalidParameterException("security is not nullable");
    }

    public static String generateNonce(long j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(new Random().nextLong());
            dataOutputStream.writeInt((int) (j / 60000));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 10);
    }
}
