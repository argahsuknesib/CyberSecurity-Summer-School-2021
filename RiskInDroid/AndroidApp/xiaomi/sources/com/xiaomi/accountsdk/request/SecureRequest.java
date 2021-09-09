package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AESCoder;
import com.xiaomi.accountsdk.utils.CryptCoder;
import com.xiaomi.accountsdk.utils.DiagnosisLog;
import com.xiaomi.accountsdk.utils.DiagnosisLogInterface;
import com.xiaomi.accountsdk.utils.SignatureCoder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SecureRequest {
    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsString(str, map, map2, z, str2, null, null, null);
    }

    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsString(str, map, map2, z, str2, cryptCoder, null, null);
    }

    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsString(str, map, map2, z, str2, cryptCoder, num, null);
    }

    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num, Map<String, String> map3) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        if (cryptCoder == null) {
            cryptCoder = new AESCoder(str2);
        }
        return processStringResponse(SimpleRequest.getAsString(str, encryptParams("GET", str, map, str2, cryptCoder), map3, map2, z, num), str2, cryptCoder);
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsMap(str, map, map2, z, str2, null, null, null);
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsMap(str, map, map2, z, str2, cryptCoder, null, null);
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsMap(str, map, map2, z, str2, cryptCoder, num, null);
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num, Map<String, String> map3) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return SimpleRequest.convertStringToMap(getAsString(str, map, map2, z, str2, cryptCoder, num, map3));
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return postAsString(str, map, map2, z, str2, null, null, null);
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return postAsString(str, map, map2, z, str2, cryptCoder, null, null);
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return postAsString(str, map, map2, z, str2, cryptCoder, num, null);
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num, Map<String, String> map3) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        if (cryptCoder == null) {
            cryptCoder = new AESCoder(str2);
        }
        return processStringResponse(SimpleRequest.postAsString(str, encryptParams("POST", str, map, str2, cryptCoder), map2, map3, z, num), str2, cryptCoder);
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return postAsMap(str, map, map2, z, str2, null, null, null);
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return postAsMap(str, map, map2, z, str2, cryptCoder, null, null);
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return postAsMap(str, map, map2, z, str2, cryptCoder, num, null);
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num, Map<String, String> map3) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return SimpleRequest.convertStringToMap(postAsString(str, map, map2, z, str2, cryptCoder, num, map3));
    }

    private static SimpleRequest.StringContent processStringResponse(SimpleRequest.StringContent stringContent, String str, CryptCoder cryptCoder) throws IOException, InvalidResponseException, CipherException {
        if (stringContent != null) {
            String body = stringContent.getBody();
            if (body != null) {
                String decryptResponse = decryptResponse(body, cryptCoder);
                getDiagnosisLogger().logResponseDecryptedBody(decryptResponse);
                SimpleRequest.StringContent stringContent2 = new SimpleRequest.StringContent(decryptResponse);
                stringContent2.putHeaders(stringContent.getHeaders());
                stringContent2.setHttpCode(stringContent.getHttpCode());
                return stringContent2;
            }
            throw new InvalidResponseException("invalid response from server");
        }
        throw new IOException("no response from server");
    }

    private static DiagnosisLogInterface getDiagnosisLogger() {
        return DiagnosisLog.get();
    }

    public static Map<String, String> encryptParams(String str, String str2, Map<String, String> map, String str3, CryptCoder cryptCoder) throws CipherException {
        if (cryptCoder != null) {
            HashMap hashMap = new HashMap();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    String str4 = (String) next.getKey();
                    String str5 = (String) next.getValue();
                    if (!(str4 == null || str5 == null)) {
                        if (!str4.startsWith("_")) {
                            str5 = cryptCoder.encrypt(str5);
                        }
                        hashMap.put(str4, str5);
                    }
                }
            }
            hashMap.put("signature", SignatureCoder.generateSignature(str, str2, hashMap, str3));
            return hashMap;
        }
        throw new CipherException("no invalid cypt coder");
    }

    public static Map<String, String> encryptParams(String str, String str2, Map<String, String> map, String str3) throws CipherException {
        return encryptParams(str, str2, map, str3, new AESCoder(str3));
    }

    private static String decryptResponse(String str, CryptCoder cryptCoder) throws CipherException, InvalidResponseException {
        if (cryptCoder != null) {
            try {
                return cryptCoder.decrypt(str);
            } catch (CipherException e) {
                throw new InvalidResponseException("failed to decrypt response", e);
            }
        } else {
            throw new CipherException("no invalid coder");
        }
    }
}
