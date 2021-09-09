package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AESWithIVCoder;
import com.xiaomi.accountsdk.utils.CloudCoder;
import java.io.IOException;
import java.util.Map;

public class AesWithIVRequest {
    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        if (!map.containsKey("_nonce")) {
            map.put("_nonce", CloudCoder.generateNonce());
        }
        return SecureRequest.getAsString(str, map, map2, z, str2, new AESWithIVCoder(str2));
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return SimpleRequest.convertStringToMap(getAsString(str, map, map2, z, str2));
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        if (!map.containsKey("_nonce")) {
            map.put("_nonce", CloudCoder.generateNonce());
        }
        return SecureRequest.postAsString(str, map, map2, z, str2, new AESWithIVCoder(str2));
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return SimpleRequest.convertStringToMap(postAsString(str, map, map2, z, str2));
    }
}
