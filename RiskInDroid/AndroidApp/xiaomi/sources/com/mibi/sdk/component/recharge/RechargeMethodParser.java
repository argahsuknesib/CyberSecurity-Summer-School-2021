package com.mibi.sdk.component.recharge;

import org.json.JSONException;
import org.json.JSONObject;

public interface RechargeMethodParser {
    RechargeMethod parse(String str, JSONObject jSONObject) throws JSONException;
}
