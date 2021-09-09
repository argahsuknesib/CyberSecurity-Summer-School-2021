package com.xiaomi.accountsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.hasheddeviceidlib.DeviceIdHasher;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CloudCoder {
    private static final Integer INT_0 = 0;
    private static final String URL_REMOTE_DECRYPT = (XMPassport.URL_ACCOUNT_SAFE_API_BASE + "/user/getPlanText");
    private static final String URL_REMOTE_ENCRYPT = (XMPassport.URL_ACCOUNT_SAFE_API_BASE + "/user/getSecurityToken");

    public enum CIPHER_MODE {
        ENCRYPT,
        DECRYPT
    }

    public static Cipher newAESCipher(String str, int i) {
        return newAESCipherWithIV(str, i, "0102030405060708".getBytes());
    }

    public static Cipher newAESCipherWithIV(String str, int i, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr));
            return instance;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Cipher newRC4Cipher(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "RC4");
        try {
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(i, secretKeySpec);
            return instance;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String hash4SHA1(String str) {
        return Coder.hash4SHA1(str);
    }

    public static String generateSignature(String str, String str2, Map<String, String> map, String str3) {
        return Coder.generateSignature(str, str2, map, str3);
    }

    public static String remoteEndecrypt(String str, String str2, String str3, String str4, String str5, CIPHER_MODE cipher_mode) throws IOException, CipherException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException {
        String str6;
        if (TextUtils.isDigitsOnly(str)) {
            HashMap hashMap = new HashMap();
            String str7 = "plainText";
            if (cipher_mode == CIPHER_MODE.ENCRYPT) {
                str6 = URL_REMOTE_ENCRYPT;
                hashMap.put(str7, str3);
            } else {
                str6 = URL_REMOTE_DECRYPT;
                hashMap.put("token", str3);
            }
            hashMap.put("userId", str);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("cUserId", str2);
            hashMap2.put("serviceToken", str4);
            ProtocolLogHelper.newRequestLog(str6, HttpMethod.POST, new String[]{"token", "serviceToken"}).paramWithMaskOrNull(hashMap).cookieWithMaskOrNull(hashMap2).log();
            SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str6, hashMap, hashMap2, true, str5);
            ProtocolLogHelper.newResponseLog(str6).mapResponseOrNull(postAsMap).log();
            Object fromBody = postAsMap.getFromBody("code");
            if (INT_0.equals(fromBody)) {
                Object fromBody2 = postAsMap.getFromBody("data");
                if (fromBody2 instanceof Map) {
                    Map map = (Map) fromBody2;
                    if (cipher_mode == CIPHER_MODE.ENCRYPT) {
                        str7 = "cipher";
                    }
                    Object obj = map.get(str7);
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    throw new InvalidResponseException("invalid result: ".concat(String.valueOf(obj)));
                }
                throw new InvalidResponseException("invalid data node");
            }
            throw new InvalidResponseException("failed to encrypt, code: ".concat(String.valueOf(fromBody)));
        }
        throw new IllegalArgumentException("userId is not only digits");
    }

    public static String generatePseudoDeviceId() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encodeUpperHex(bArr);
    }

    public static String encodeUpperHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }

    public static String hashDeviceInfo(String str) {
        return DeviceIdHasher.hashDeviceInfo(str, 8);
    }

    public static String hashDeviceInfo(String str, int i) {
        return DeviceIdHasher.hashDeviceInfo(str, i);
    }

    public static String decodeString(String str, String str2, String str3) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return decodeString(newAESCipher(str, 2), str2, str3);
    }

    public static String decodeString(Cipher cipher, String str, String str2) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return new String(cipher.doFinal(Base64.decode(str.getBytes(str2), 2)), str2);
        } catch (IllegalArgumentException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    public static String encodeString(String str, String str2, String str3) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher newAESCipher = newAESCipher(str, 1);
        if (newAESCipher == null) {
            return "";
        }
        return encodeString(newAESCipher, str2, str3);
    }

    public static String encodeString(Cipher cipher, String str, String str2) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        return Base64.encodeToString(cipher.doFinal(str.getBytes(str2)), 2);
    }

    public static String getHexString(byte[] bArr) {
        return Coder.getHexString(bArr);
    }

    private static byte[] randomRc4Key128(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encodeStream(String str, byte[] bArr) throws IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] doFinal = newRC4Cipher(randomRc4Key128(str), 1).doFinal(bArr);
        if (bArr.length == doFinal.length) {
            return doFinal;
        }
        throw new IOException("The encoded data length is not the same with original data");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0047 A[SYNTHETIC, Splitter:B:31:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A[SYNTHETIC, Splitter:B:38:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0066 A[RETURN] */
    public static String getFileSha1Digest(String str) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (Exception e) {
                e = e;
                fileInputStream = null;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable unused) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (messageDigest != null) {
                        return getHexString(messageDigest.digest());
                    }
                    return null;
                }
            } catch (Throwable unused2) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                if (messageDigest != null) {
                }
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                fileInputStream.close();
                if (messageDigest != null) {
                    return getHexString(messageDigest.digest());
                }
                return null;
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            messageDigest = null;
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return null;
        } catch (Throwable unused3) {
            fileInputStream = null;
            messageDigest = null;
            if (fileInputStream != null) {
            }
            if (messageDigest != null) {
            }
        }
    }

    public static String getDataSha1Digest(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA1");
                instance.update(bArr);
                return getHexString(instance.digest());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getDataMd5Digest(byte[] bArr) {
        return Coder.getDataMd5Digest(bArr);
    }

    public static String getMd5DigestUpperCase(String str) {
        return Coder.getMd5DigestUpperCase(str);
    }

    public static String generateNonce() {
        return NonceCoder.generateNonce();
    }

    public static String generateNonce(long j) {
        return NonceCoder.generateNonce(j);
    }

    public static String hashAndJoin(String str, List<String> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return hashAndJoin(str, (String[]) list.toArray(new String[list.size()]), i);
    }

    public static String hashAndJoin(String str, String[] strArr, int i) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String hash4SHA1 : strArr) {
            String hash4SHA12 = hash4SHA1(hash4SHA1);
            if (hash4SHA12 != null) {
                if (i <= 0 || i > hash4SHA12.length()) {
                    arrayList.add(hash4SHA12);
                } else {
                    arrayList.add(hash4SHA12.substring(0, i));
                }
            }
        }
        if (str == null) {
            str = "";
        }
        return TextUtils.join(str, arrayList);
    }
}
