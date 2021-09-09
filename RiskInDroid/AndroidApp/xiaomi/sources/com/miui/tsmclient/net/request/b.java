package com.miui.tsmclient.net.request;

import android.content.Context;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.i;
import java.util.Map;

public class b extends SecureRequest<CommonResponseInfo> {
    public b(Context context, i iVar, ResponseListener responseListener) {
        super(1, "api/%s/acl/checkServiceAvailable", CommonResponseInfo.class, responseListener);
        if (iVar != null) {
            for (Map.Entry next : iVar.a(context).entrySet()) {
                addParams((String) next.getKey(), (String) next.getValue());
            }
        }
    }
}
