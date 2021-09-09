package com.xiaomi.safedata.base;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

public class BaseBean implements Serializable {
    protected JSONObject jsonObject = new JSONObject();

    /* access modifiers changed from: protected */
    public JSONObject O000000o() {
        return this.jsonObject;
    }

    protected BaseBean() {
    }

    protected static String O000000o(String str) {
        return TextUtils.isEmpty(str) ? "$unknown" : str;
    }
}
