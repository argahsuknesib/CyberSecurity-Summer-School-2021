package com.xiaomi.safedata.debug;

import android.util.Log;
import com.xiaomi.safedata.base.BaseBean;
import org.json.JSONObject;

public class DebugBean extends BaseBean {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f6615O000000o = "DebugBean";
    public boolean isDebugVersion;
    public boolean isDebugging;
    public boolean isOpenDebug;

    public final JSONObject O000000o() {
        try {
            this.jsonObject.put("openDebug", this.isOpenDebug);
            this.jsonObject.put("debugVersion", this.isDebugVersion);
            this.jsonObject.put("debugging", this.isDebugging);
        } catch (Exception e) {
            Log.e(f6615O000000o, e.toString());
        }
        return super.O000000o();
    }
}
