package com.xiaomi.accountsdk.account;

import com.xiaomi.account.data.PassportCAToken;
import com.xiaomi.account.exception.PassportCAException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.IPStatHelper;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.PassportRequestArguments;
import com.xiaomi.accountsdk.request.PassportSimpleRequest;
import com.xiaomi.accountsdk.utils.EasyMap;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

public class PassportCATokenManager {
    private static PassportCATokenManager sInstance = new PassportCATokenManager();
    private PassportCAExternal passportCAExternal = null;

    PassportCATokenManager() {
    }

    public boolean isReady() {
        if (this.passportCAExternal != null && !XMPassport.USE_PREVIEW) {
            if (System.currentTimeMillis() >= this.passportCAExternal.loadNextCAEnabledTime(0)) {
                return true;
            }
        }
        return false;
    }

    public String getCaUrl(String str) {
        return URLs.getCaUrl(str);
    }

    public void onCADisabledForSeconds(Long l) {
        if (this.passportCAExternal != null) {
            if (l == null) {
                l = 86400L;
            } else if (l.longValue() > 604800) {
                l = 604800L;
            }
            this.passportCAExternal.saveNextCAEnabledTime(System.currentTimeMillis() + (l.longValue() * 1000));
        }
    }

    /* access modifiers changed from: protected */
    public PassportCAToken getCATokenOnline(String str) throws IOException, CertificateException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, AccessDeniedException, AuthenticationFailureException, JSONException, InvalidResponseException, CipherException, PassportCAException {
        String format = String.format("https://%s/ca/getTokenCA", str);
        EasyMap easyMap = new EasyMap();
        easyMap.easyPut("deviceId", XMPassportSettings.getDeviceId());
        EasyMap easyMap2 = new EasyMap();
        easyMap2.put("_ver", PassportCAConstants.IMPL_VERSION);
        PassportRequestArguments passportRequestArguments = new PassportRequestArguments();
        passportRequestArguments.setUrl(format);
        passportRequestArguments.putAllParams(easyMap2);
        passportRequestArguments.putAllCookies(easyMap);
        passportRequestArguments.setReadBody(true);
        try {
            JSONObject jSONObject = new JSONObject(XMPassport.removeSafePrefixAndGetRealBody(new PassportSimpleRequest.GetAsString(passportRequestArguments).executeEx()));
            int i = jSONObject.getInt("code");
            if (i == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                return new PassportCAToken(jSONObject2.getString("passport_ca_token"), jSONObject2.getString("casecurity"));
            } else if (i == 10008) {
                throw new PassportCAException("when getting Token server returns code: ".concat(String.valueOf(i)));
            } else {
                throw new InvalidResponseException("error result");
            }
        } catch (InvalidCredentialException e) {
            throw new IllegalStateException(e);
        } catch (InvalidUserNameException e2) {
            throw new IllegalStateException(e2);
        } catch (NeedVerificationException e3) {
            throw new IllegalStateException(e3);
        } catch (NeedCaptchaException e4) {
            throw new IllegalStateException(e4);
        } catch (NeedNotificationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    @Deprecated
    public PassportCAToken getPassportCAToken(String str) throws IOException, CertificateException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, AccessDeniedException, AuthenticationFailureException, JSONException, InvalidResponseException, CipherException, PassportCAException {
        return getPassportCAToken();
    }

    public PassportCAToken getPassportCAToken() throws IOException, CertificateException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, AccessDeniedException, AuthenticationFailureException, JSONException, InvalidResponseException, CipherException, PassportCAException {
        PassportCAExternal passportCAExternal2 = this.passportCAExternal;
        if (passportCAExternal2 != null) {
            PassportCAToken loadCAToken = passportCAExternal2.loadCAToken();
            if (loadCAToken == null) {
                String host = new URL(URLs.URL_PASSPORT_CA_ACCOUNT_BASE).getHost();
                getTokenStatHelper gettokenstathelper = new getTokenStatHelper();
                gettokenstathelper.onGetTokenOnlineStart();
                try {
                    loadCAToken = getCATokenOnline(host);
                    if (loadCAToken != null) {
                        this.passportCAExternal.saveCAToken(loadCAToken);
                    }
                } finally {
                    gettokenstathelper.onGetTokenOnlineEnd(loadCAToken);
                }
            }
            return loadCAToken;
        }
        throw new IllegalStateException("passportCATokenExternal is null");
    }

    public void invalidateAllCAToken() {
        PassportCAExternal passportCAExternal2 = this.passportCAExternal;
        if (passportCAExternal2 != null) {
            passportCAExternal2.saveCAToken(PassportCAToken.INVALID_INSTANCE);
            return;
        }
        throw new IllegalStateException("passportCATokenExternal is null");
    }

    public void setPassportCAExternal(PassportCAExternal passportCAExternal2) {
        if (passportCAExternal2 != null) {
            this.passportCAExternal = passportCAExternal2;
            return;
        }
        throw new IllegalArgumentException("passportCAExternal should not be null");
    }

    public static PassportCATokenManager getInstance() {
        return sInstance;
    }

    static class getTokenStatHelper extends IPStatHelper {
        private long startTime = 0;

        getTokenStatHelper() {
        }

        public void onGetTokenOnlineStart() {
            this.startTime = System.currentTimeMillis();
        }

        public void onGetTokenOnlineEnd(PassportCAToken passportCAToken) {
            statDummyUrl(buildDummyUrl(passportCAToken, Long.valueOf(System.currentTimeMillis() - this.startTime), Boolean.valueOf(passportCAToken != null)));
        }

        /* access modifiers changed from: package-private */
        public String buildDummyUrl(PassportCAToken passportCAToken, Object obj, Object obj2) {
            return String.format("http://dummyurl/getTokenDiagnosis?_ver=%s&_time=%s&_result=%s&hdid=%s", PassportCAConstants.IMPL_VERSION, obj, obj2, new HashedDeviceIdUtil(XMPassportSettings.getApplicationContext()).getHashedDeviceIdNoThrow());
        }
    }
}
