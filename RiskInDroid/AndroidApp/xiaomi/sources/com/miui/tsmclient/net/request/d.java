package com.miui.tsmclient.net.request;

import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.e;
import com.miui.tsmclient.util.a;
import java.util.Locale;

public class d extends SecureRequest<e> {
    public d(String str) {
        super(0, "api/%s/nfcConfigs", TypeToken.get(e.class));
        addParams("deviceModel", a.b((CardInfo) null)).addParams("lang", Locale.getDefault().toString()).addParams("miuiRomType", a.a((CardInfo) null)).addParams("miuiSystemVersion", a.a()).addParams("cplc", str);
    }
}
