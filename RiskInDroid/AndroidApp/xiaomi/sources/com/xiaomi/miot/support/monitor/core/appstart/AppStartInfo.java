package com.xiaomi.miot.support.monitor.core.appstart;

import com.xiaomi.miot.support.monitor.core.BaseInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class AppStartInfo extends BaseInfo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f6036O000000o = "t";
    public static String O00000Oo = "st";
    private int mStartTime;
    private int mStartType = 1;

    public AppStartInfo(int i, int i2) {
        this.mStartTime = i;
        this.mStartType = i2;
    }

    public final JSONObject O000000o() throws JSONException {
        return super.O000000o().put(f6036O000000o, this.mStartTime).put(O00000Oo, this.mStartType);
    }

    public String toString() {
        try {
            return O000000o().toString();
        } catch (Exception unused) {
            return super.toString();
        }
    }
}
