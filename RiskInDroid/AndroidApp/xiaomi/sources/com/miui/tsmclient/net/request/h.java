package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.request.SecureRequest;

public class h extends SecureRequest<CommonResponseInfo> {
    public h(String str, String str2, String str3, String str4) {
        super(0, "api/%s/busCard/outApp/serviceAvailable", CommonResponseInfo.class);
        addParams("spId", str).addParams("cardName", str2).addParams("cplc", str3).addParams("actionType", str4);
    }
}
