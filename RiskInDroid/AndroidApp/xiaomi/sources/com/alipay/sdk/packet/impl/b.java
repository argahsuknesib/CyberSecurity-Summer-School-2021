package com.alipay.sdk.packet.impl;

import com.alipay.sdk.packet.e;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends e {
    public String b() {
        return "5.0.0";
    }

    public JSONObject a() throws JSONException {
        return e.a("sdkConfig", "obtain");
    }
}
