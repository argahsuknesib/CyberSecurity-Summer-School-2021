package com.xiaomi.accountsdk.utils;

import java.util.Map;

public class SignatureCoder {
    public static String generateSignature(String str, String str2, Map<String, String> map, String str3) {
        return Coder.generateSignature(str, str2, map, str3);
    }
}
