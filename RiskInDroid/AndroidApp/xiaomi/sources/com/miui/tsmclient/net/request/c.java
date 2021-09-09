package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;

public class c extends SecureRequest<com.miui.tsmclient.entity.c> {
    public c(String str, ResponseListener<com.miui.tsmclient.entity.c> responseListener) {
        super(0, "api/%s/doorCardV2/listArts", com.miui.tsmclient.entity.c.class, responseListener);
        addParams("productId", str);
    }
}
