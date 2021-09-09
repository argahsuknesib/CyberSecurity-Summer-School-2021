package com.xiaomi.miot.support.monitor.core.fps;

import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.core.BaseInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class FpsInfo extends BaseInfo {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static int f6037O000000o = 0;
    protected static int O00000Oo = 1;
    private String activity;
    private int cycleType = 1;
    private int fps;
    private String processName;

    private FpsInfo() {
        this.mId = -1;
    }

    public FpsInfo(String str, int i, int i2) {
        this.activity = str;
        this.fps = i;
        this.cycleType = i2;
    }

    public final JSONObject O000000o() throws JSONException {
        JSONObject put = super.O000000o().put("fps", this.fps).put("ac", this.activity).put("ct", this.cycleType);
        if (!TextUtils.isEmpty(this.params)) {
            put.put("par", this.params);
        }
        return put;
    }
}
