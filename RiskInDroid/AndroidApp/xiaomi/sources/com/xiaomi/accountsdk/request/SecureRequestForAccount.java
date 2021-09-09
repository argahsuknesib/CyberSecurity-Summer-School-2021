package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.CryptCoder;
import java.io.IOException;
import java.util.Map;

public class SecureRequestForAccount {
    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsString(str, map, map2, z, str2, null, null);
    }

    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsString(str, map, map2, z, str2, cryptCoder, null);
    }

    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder, Integer num) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return SecureRequest.getAsString(str, map, SimpleRequestForAccount.addFidNonceInCookieIfNeeded(SimpleRequestForAccount.addDeviceIdInCookieIfNeeded(map2)), z, str2, cryptCoder, num, null);
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return getAsMap(str, map, map2, z, str2, null);
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return SecureRequest.getAsMap(str, map, SimpleRequestForAccount.addFidNonceInCookieIfNeeded(SimpleRequestForAccount.addDeviceIdInCookieIfNeeded(map2)), z, str2, cryptCoder, null, null);
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return postAsMap(str, map, map2, z, str2, null);
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2, CryptCoder cryptCoder) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return SecureRequest.postAsMap(str, map, SimpleRequestForAccount.addFidNonceInCookieIfNeeded(SimpleRequestForAccount.addDeviceIdInCookieIfNeeded(map2)), z, str2, cryptCoder, null, null);
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws IOException, CipherException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        return SecureRequest.postAsString(str, map, SimpleRequestForAccount.addFidNonceInCookieIfNeeded(SimpleRequestForAccount.addDeviceIdInCookieIfNeeded(map2)), z, str2, null, null, null);
    }
}
