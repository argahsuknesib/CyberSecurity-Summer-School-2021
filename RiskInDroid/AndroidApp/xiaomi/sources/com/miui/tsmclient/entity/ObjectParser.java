package com.miui.tsmclient.entity;

import org.json.JSONObject;

public interface ObjectParser<T> {
    T parse(JSONObject jSONObject);
}
