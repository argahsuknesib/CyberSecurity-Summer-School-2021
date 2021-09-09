package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.h;

public class l extends SecureRequest<h> {
    public l(String str, String str2, String str3) {
        super(1, "api/%s/busCard/outApp/wrapSeInfo", h.class);
        addParams("spId", str).addParams("cardName", str2).addParams("cplc", str3);
    }
}
