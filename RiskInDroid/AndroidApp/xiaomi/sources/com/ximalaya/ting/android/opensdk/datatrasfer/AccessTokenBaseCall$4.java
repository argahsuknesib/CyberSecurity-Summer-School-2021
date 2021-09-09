package com.ximalaya.ting.android.opensdk.datatrasfer;

import _m_j.ilp;
import java.util.HashMap;

public class AccessTokenBaseCall$4 extends HashMap<String, String> {
    final /* synthetic */ ilp val$preferencesUtil;
    final /* synthetic */ String val$ssoCode;

    public AccessTokenBaseCall$4(String str, ilp ilp) {
        this.val$ssoCode = str;
        this.val$preferencesUtil = ilp;
        put("sso_code", this.val$ssoCode);
        put("redirect_uri", this.val$preferencesUtil.O00000o0("simple_redirect_uri"));
    }
}
