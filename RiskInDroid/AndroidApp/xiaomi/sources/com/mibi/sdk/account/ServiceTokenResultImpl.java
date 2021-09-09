package com.mibi.sdk.account;

import android.content.Intent;
import com.mibi.sdk.common.account.IServiceTokenResult;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;

public class ServiceTokenResultImpl implements IServiceTokenResult {
    private ServiceTokenResult mServiceTokenResult;

    public ServiceTokenResultImpl(ServiceTokenResult serviceTokenResult) {
        this.mServiceTokenResult = serviceTokenResult;
    }

    public String getSid() {
        return this.mServiceTokenResult.f6200O000000o;
    }

    public String getServiceToken() {
        return this.mServiceTokenResult.O00000Oo;
    }

    public String getSecurity() {
        return this.mServiceTokenResult.O00000o0;
    }

    public String getErrorMessage() {
        return this.mServiceTokenResult.O00000oO;
    }

    public String getErrorCodeName() {
        return this.mServiceTokenResult.O00000o.name();
    }

    public String getErrorStackTrace() {
        return this.mServiceTokenResult.O00000oo;
    }

    public Intent getIntent() {
        return this.mServiceTokenResult.O0000O0o;
    }

    public String getSlh() {
        return this.mServiceTokenResult.O0000OOo;
    }

    public String getPh() {
        return this.mServiceTokenResult.O0000Oo0;
    }

    public String getCUserId() {
        return this.mServiceTokenResult.O0000Oo;
    }

    public String getUserId() {
        return this.mServiceTokenResult.O0000o00;
    }

    public boolean isPeeked() {
        return this.mServiceTokenResult.O0000OoO;
    }
}
