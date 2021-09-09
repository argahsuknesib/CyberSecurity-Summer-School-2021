package com.xiaomi.miot.support.monitor.core;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseInfo implements IInfo {
    protected int mId = -1;
    protected String params;
    protected long recordTime;

    public JSONObject O000000o() throws JSONException {
        return new JSONObject();
    }

    public String toString() {
        try {
            return O000000o().toString();
        } catch (Exception unused) {
            return super.toString();
        }
    }
}
