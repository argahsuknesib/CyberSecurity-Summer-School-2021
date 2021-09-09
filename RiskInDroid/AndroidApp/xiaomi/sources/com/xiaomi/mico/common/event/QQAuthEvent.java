package com.xiaomi.mico.common.event;

import _m_j.dkb;
import org.json.JSONObject;

public class QQAuthEvent {
    public boolean cancel;
    public QQAuth qqAuth;
    public JSONObject result;
    public boolean success;
    public dkb uiError;
    public int warningCode;

    static QQAuthEvent completeEvent(Object obj) {
        QQAuthEvent qQAuthEvent = new QQAuthEvent();
        try {
            JSONObject jSONObject = (JSONObject) obj;
            qQAuthEvent.result = jSONObject;
            long optLong = jSONObject.optLong("ret", -1);
            String optString = jSONObject.optString("openid");
            String optString2 = jSONObject.optString("access_token");
            long optLong2 = jSONObject.optLong("expires_in");
            qQAuthEvent.success = optLong == 0;
            qQAuthEvent.qqAuth = new QQAuth(optLong, optString, optString2, optLong2);
        } catch (Exception unused) {
        }
        return qQAuthEvent;
    }

    public static class QQAuth {
        public String accessToken;
        public long expiresIn;
        public String openid;
        public long ret;

        public QQAuth() {
        }

        public QQAuth(long j, String str, String str2, long j2) {
            this.ret = j;
            this.openid = str;
            this.accessToken = str2;
            this.expiresIn = j2;
        }
    }

    static QQAuthEvent cancelEvent() {
        QQAuthEvent qQAuthEvent = new QQAuthEvent();
        qQAuthEvent.success = false;
        qQAuthEvent.cancel = true;
        return qQAuthEvent;
    }

    static QQAuthEvent errorEvent(dkb dkb) {
        QQAuthEvent qQAuthEvent = new QQAuthEvent();
        qQAuthEvent.success = false;
        qQAuthEvent.cancel = false;
        qQAuthEvent.uiError = dkb;
        return qQAuthEvent;
    }

    static QQAuthEvent warningEvent(int i) {
        QQAuthEvent qQAuthEvent = new QQAuthEvent();
        qQAuthEvent.warningCode = i;
        return qQAuthEvent;
    }
}
