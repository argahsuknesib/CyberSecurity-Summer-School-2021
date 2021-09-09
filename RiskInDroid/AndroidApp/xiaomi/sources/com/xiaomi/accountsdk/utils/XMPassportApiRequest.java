package com.xiaomi.accountsdk.utils;

import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import java.io.IOException;
import org.json.JSONException;

public abstract class XMPassportApiRequest {

    public enum WebMethod {
        POST,
        GET
    }

    /* access modifiers changed from: protected */
    public abstract void addParams(EasyMap<String, String> easyMap);

    /* access modifiers changed from: protected */
    public abstract boolean allowRetryAuthToken();

    /* access modifiers changed from: protected */
    public abstract String getAuthToken();

    /* access modifiers changed from: protected */
    public abstract String getCUserId();

    /* access modifiers changed from: protected */
    public abstract String getUrl();

    /* access modifiers changed from: protected */
    public abstract String getUserId();

    /* access modifiers changed from: protected */
    public abstract WebMethod getWebMethod();

    /* access modifiers changed from: protected */
    public abstract String handleDataResult(Object obj) throws JSONException;

    /* access modifiers changed from: protected */
    public abstract void invalidateAuthToken(String str);

    public String execute() throws AccessDeniedException, InvalidResponseException, CipherException, IOException, JSONException {
        String authToken;
        ExtendedAuthToken parse;
        SimpleRequest.MapContent mapContent;
        int i = 0;
        while (i < 2 && (parse = ExtendedAuthToken.parse((authToken = getAuthToken()))) != null) {
            String str = parse.authToken;
            String str2 = parse.security;
            if (str == null || str2 == null) {
                return null;
            }
            EasyMap easyMap = new EasyMap();
            addParams(easyMap);
            EasyMap easyMap2 = new EasyMap();
            easyMap2.easyPut("serviceToken", str);
            String cUserId = getCUserId();
            if (cUserId != null) {
                easyMap2.easyPut("cUserId", cUserId);
            } else {
                easyMap2.easyPut("userId", getUserId());
            }
            try {
                if (getWebMethod() == WebMethod.GET) {
                    mapContent = SecureRequestForAccount.getAsMap(getUrl(), easyMap, easyMap2, true, str2, new AESCoder(str2));
                } else {
                    mapContent = SecureRequestForAccount.postAsMap(getUrl(), easyMap, easyMap2, true, str2, new AESCoder(str2));
                }
                if (mapContent != null) {
                    return handleDataResult(mapContent.getFromBody("data"));
                }
                return null;
            } catch (AuthenticationFailureException unused) {
                if (!allowRetryAuthToken()) {
                    return null;
                }
                invalidateAuthToken(authToken);
                i++;
            }
        }
        return null;
    }
}
