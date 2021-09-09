package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.d;

public class f extends SecureRequest<d> {
    public f(ResponseListener<d> responseListener) {
        super(0, "api/%s/doorCard/issuers", d.class, responseListener);
    }
}
