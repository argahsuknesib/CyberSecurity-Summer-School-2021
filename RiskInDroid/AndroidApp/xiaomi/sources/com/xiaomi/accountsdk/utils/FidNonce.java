package com.xiaomi.accountsdk.utils;

import android.util.Base64;
import com.xiaomi.accountsdk.utils.FidSigningUtil;
import com.xiaomi.accountsdk.utils.ServerTimeUtil;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class FidNonce extends FidNonceBase {

    public enum Type {
        NATIVE,
        WEB_VIEW
    }

    public FidNonce(String str, String str2) {
        super(str, str2);
    }

    public static class Builder {
        public FidNonce build(Type type) {
            return new Builder().build(type, ServerTimeUtil.getComputer(), FidSigningUtil.getFidSigner());
        }

        /* access modifiers changed from: package-private */
        public FidNonce build(Type type, ServerTimeUtil.IServerTimeComputer iServerTimeComputer, FidSigningUtil.IFidSigner iFidSigner) {
            if (type == null) {
                throw new IllegalArgumentException("type == null");
            } else if (iServerTimeComputer == null || iFidSigner == null) {
                return null;
            } else {
                try {
                    if (!iFidSigner.canSign()) {
                        return null;
                    }
                    String buildPlain = buildPlain(type == Type.NATIVE ? "n" : "wb", generateNonce(iServerTimeComputer.computeServerTime()), getVersion());
                    try {
                        String encodeToString = Base64.encodeToString(buildPlain.getBytes("UTF-8"), 10);
                        try {
                            byte[] sign = iFidSigner.sign(buildPlain.getBytes("UTF-8"));
                            if (sign == null) {
                                return null;
                            }
                            try {
                                return new FidNonce(encodeToString, new String(Base64.encode(sign, 10), "UTF-8"));
                            } catch (UnsupportedEncodingException e) {
                                AccountLog.w("FidNonce", e);
                                return null;
                            }
                        } catch (FidSigningUtil.FidSignException e2) {
                            AccountLog.w("FidNonce", e2);
                            return null;
                        } catch (UnsupportedEncodingException e3) {
                            AccountLog.w("FidNonce", e3);
                            return null;
                        }
                    } catch (UnsupportedEncodingException e4) {
                        AccountLog.w("FidNonce", e4);
                        return null;
                    }
                } catch (FidSigningUtil.FidSignException e5) {
                    AccountLog.w("FidNonce", e5);
                    return null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public String buildPlain(String str, String str2, String str3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tp", str);
                jSONObject.put("nonce", str2);
                jSONObject.put("v", str3);
                return jSONObject.toString();
            } catch (JSONException unused) {
                throw new IllegalStateException("should not happen");
            }
        }

        /* access modifiers changed from: package-private */
        public String getVersion() {
            return VersionUtils.getVersion();
        }

        /* access modifiers changed from: package-private */
        public String generateNonce(long j) {
            return NonceCoder.generateNonce(j);
        }
    }
}
