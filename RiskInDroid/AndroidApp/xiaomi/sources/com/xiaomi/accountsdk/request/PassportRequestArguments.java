package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.utils.EasyMap;
import java.util.Map;

public class PassportRequestArguments {
    protected final EasyMap<String, String> cookies = new EasyMap<>();
    protected final EasyMap<String, String> headers = new EasyMap<>();
    protected final EasyMap<String, String> params = new EasyMap<>();
    protected boolean readBody = true;
    protected Integer timeoutMillis = null;
    protected String url = null;
    protected final EasyMap<String, String> urlParams = new EasyMap<>();

    public void setReadBody(boolean z) {
        this.readBody = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void putAllParams(Map<String, String> map) {
        if (map != null) {
            this.params.putAll(map);
        }
    }

    public void putParamOpt(String str, String str2) {
        this.params.easyPutOpt(str, str2);
    }

    public void putAllHeaders(Map<String, String> map) {
        if (map != null) {
            this.headers.putAll(map);
        }
    }

    public void putHeaderOpt(String str, String str2) {
        this.headers.easyPutOpt(str, str2);
    }

    public void putAllUrlParamsForPost(Map<String, String> map) {
        if (map != null) {
            this.urlParams.putAll(map);
        }
    }

    public void putAllCookies(Map<String, String> map) {
        if (map != null) {
            this.cookies.putAll(map);
        }
    }

    public PassportRequestArguments copy() {
        PassportRequestArguments passportRequestArguments = new PassportRequestArguments();
        copyTo(passportRequestArguments);
        return passportRequestArguments;
    }

    /* access modifiers changed from: protected */
    public final void copyTo(PassportRequestArguments passportRequestArguments) {
        if (passportRequestArguments != null) {
            passportRequestArguments.putAllCookies(this.cookies);
            passportRequestArguments.putAllParams(this.params);
            passportRequestArguments.putAllUrlParamsForPost(this.urlParams);
            passportRequestArguments.putAllHeaders(this.headers);
            passportRequestArguments.setUrl(this.url);
            passportRequestArguments.setReadBody(this.readBody);
            passportRequestArguments.setTimeoutMillis(this.timeoutMillis);
        }
    }

    public void setTimeoutMillis(Integer num) {
        this.timeoutMillis = num;
    }
}
