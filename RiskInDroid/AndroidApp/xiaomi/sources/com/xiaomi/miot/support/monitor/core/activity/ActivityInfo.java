package com.xiaomi.miot.support.monitor.core.activity;

import com.xiaomi.miot.support.monitor.core.BaseInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityInfo extends BaseInfo {
    public String activityName = "";
    public int lifeCycle = 0;
    public String pluginName = "";
    public String pluginVer = "";
    public int startType = 0;
    public long time = 0;

    public final void O00000Oo() {
        this.mId = -1;
        this.activityName = "";
        this.recordTime = 0;
        this.startType = 0;
        this.time = 0;
        this.lifeCycle = 0;
        this.pluginName = "";
        this.pluginVer = "";
    }

    public final JSONObject O000000o() throws JSONException {
        return super.O000000o().put("n", this.activityName).put("st", this.startType).put("t", this.time).put("lc", this.lifeCycle);
    }
}
