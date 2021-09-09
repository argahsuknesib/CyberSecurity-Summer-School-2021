package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.request.SecureRequest;

public class k extends SecureRequest<CommonResponseInfo> {
    public k(String str, String str2, String str3) {
        super(1, "api/%s/busCard/outApp/verifySpInfo", CommonResponseInfo.class);
        addParams("spId", str).addParams("cardName", str2).addParams("appSign", str3);
    }
}
