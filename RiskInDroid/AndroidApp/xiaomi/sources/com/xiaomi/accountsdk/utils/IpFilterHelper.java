package com.xiaomi.accountsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.accountsdk.account.exception.CryptoException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IpFilterHelper {
    private static volatile PublicKey sRSAPublicKey;

    IpFilterHelper() {
    }

    static String envIPAddressIfHas(String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("\\/\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}").matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                str = str.replace(group, "(" + rsaEnv(group) + ")");
            }
        }
        return str;
    }

    private static String rsaEnv(String str) {
        try {
            if (sRSAPublicKey == null) {
                sRSAPublicKey = RSACoder.getCertificatePublicKey("-----BEGIN CERTIFICATE-----\nMIICDzCCAXigAwIBAgIEWBw0IzANBgkqhkiG9w0BAQUFADBMMQswCQYDVQQGEwJD\nTjEPMA0GA1UEChMGeGlhb21pMQ8wDQYDVQQLEwZ4aWFvbWkxGzAZBgNVBAMTEmFj\nY291bnQueGlhb21pLmNvbTAeFw0xNjExMDQwNzA5MjNaFw0xNzExMDQwNzA5MjNa\nMEwxCzAJBgNVBAYTAkNOMQ8wDQYDVQQKEwZ4aWFvbWkxDzANBgNVBAsTBnhpYW9t\naTEbMBkGA1UEAxMSYWNjb3VudC54aWFvbWkuY29tMIGfMA0GCSqGSIb3DQEBAQUA\nA4GNADCBiQKBgQCHcPEm9Wo8/LWHL8mohOV5YalTgZLzng+nWCEkIRP//6GohYlI\nh3dvGpueJvQ3Sany/3dLx0x6MQKA34NxRyoO37R/LgPZUfe6eWzHQeColBBHxTED\nbCqDh46Gv5vogjqHRl4+q2WGCmZOIfmPjNHQWG8sMIZyTqFCLc6gk9vSewIDAQAB\nMA0GCSqGSIb3DQEBBQUAA4GBAHaPnscaxSPh0N0Z5OgQ6PcWr5uYPLMweatYGZRH\nSFxwSqYXpqIowuRxmrBj+oE5rG5rzFCtNjCBoeMVy/7JXZr9Juaw9NCWaTaqrmIV\nP4nK/0kizCvkx3088OOCGextGeZUC9/PCbVUEcRvGLwSrvgqiC1KG4ufeIdQWBaJ\n8ZlG\n-----END CERTIFICATE-----\n");
            }
            return Base64.encodeToString(RSACoder.encrypt(str.getBytes("UTF-8"), sRSAPublicKey), 0);
        } catch (CryptoException e) {
            AccountLog.w("IpFilterHelper", e);
            return null;
        } catch (UnsupportedEncodingException e2) {
            AccountLog.w("IpFilterHelper", e2);
            return null;
        }
    }
}
