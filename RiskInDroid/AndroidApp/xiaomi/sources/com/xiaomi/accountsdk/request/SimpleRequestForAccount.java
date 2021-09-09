package com.xiaomi.accountsdk.request;

import android.text.TextUtils;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.FidNonce;
import com.xiaomi.accountsdk.utils.UserSpaceIdUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleRequestForAccount {
    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return getAsString(str, map, null, map2, z, null);
    }

    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return getAsString(str, map, map2, map3, z, null);
    }

    public static SimpleRequest.StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z, Integer num) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return SimpleRequest.getAsString(str, map, map2, addFidNonceInCookieIfNeeded(addDeviceIdInCookieIfNeeded(map3)), z, num);
    }

    public static SimpleRequest.StreamContent getAsStream(String str, Map<String, String> map, Map<String, String> map2) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return SimpleRequest.getAsStream(str, map, addFidNonceInCookieIfNeeded(addDeviceIdInCookieIfNeeded(map2)), null);
    }

    public static SimpleRequest.MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return SimpleRequest.getAsMap(str, map, addFidNonceInCookieIfNeeded(addDeviceIdInCookieIfNeeded(map2)), null, z);
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return postAsString(str, map, map2, null, null, z, null);
    }

    public static SimpleRequest.StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, boolean z, Integer num) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return SimpleRequest.postAsString(str, map, addFidNonceInCookieIfNeeded(addDeviceIdInCookieIfNeeded(map2)), map3, map4, z, num);
    }

    public static SimpleRequest.MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return SimpleRequest.postAsMap(str, map, addFidNonceInCookieIfNeeded(addDeviceIdInCookieIfNeeded(map2)), null, z);
    }

    static Map<String, String> addDeviceIdInCookieIfNeeded(Map<String, String> map) {
        return addDeviceIdInCookieIfNeeded(map, new HashedDeviceIdUtil(XMPassportSettings.getApplicationContext()).getHashedDeviceIdNoThrow());
    }

    static Map<String, String> addDeviceIdInCookieIfNeeded(Map<String, String> map, String str) {
        if (map != null && map.containsKey("deviceId")) {
            return map;
        }
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("deviceId", str);
        String nullableUserSpaceIdCookie = UserSpaceIdUtil.getNullableUserSpaceIdCookie();
        if (!TextUtils.isEmpty(nullableUserSpaceIdCookie)) {
            hashMap.put("userSpaceId", nullableUserSpaceIdCookie);
        }
        return hashMap;
    }

    static Map<String, String> addFidNonceInCookieIfNeeded(Map<String, String> map) {
        return addFidNonceInCookieIfNeeded(map, new FidNonce.Builder());
    }

    static Map<String, String> addFidNonceInCookieIfNeeded(Map<String, String> map, FidNonce.Builder builder) {
        FidNonce build;
        if (map == null || builder == null || !map.containsKey("deviceId") || map.containsKey("fidNonce") || map.containsKey("fidNonceSign") || (build = builder.build(FidNonce.Type.NATIVE)) == null || TextUtils.isEmpty(build.plain) || TextUtils.isEmpty(build.sign)) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("fidNonce", build.plain);
        hashMap.put("fidNonceSign", build.sign);
        return hashMap;
    }
}
