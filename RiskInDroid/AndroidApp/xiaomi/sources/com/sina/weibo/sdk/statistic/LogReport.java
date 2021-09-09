package com.sina.weibo.sdk.statistic;

import _m_j.dbo;
import _m_j.dbp;
import _m_j.dbt;
import _m_j.dby;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class LogReport {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5610O000000o = null;
    private static String O00000Oo = null;
    private static String O00000o = null;
    private static String O00000o0 = null;
    private static String O00000oO = null;
    private static String O00000oo = null;
    private static JSONObject O0000O0o = null;
    private static String O0000OOo = "uploadtime";
    private static String O0000Oo0 = "https://api.weibo.com/2/proxy/sdk/statistic.json";

    public LogReport(Context context) {
        try {
            if (O00000o0 == null) {
                O00000o0 = context.getPackageName();
            }
            O00000Oo = dbp.O000000o(context);
            O000000o(context);
            O00000o = dby.O000000o(context, O00000o0);
            O00000oO = dbo.O00000o0(context);
            O00000oo = dbp.O00000Oo(context);
        } catch (Exception e) {
            dbt.O00000o0("WBAgent", e.toString());
        }
        O000000o();
    }

    private static JSONObject O000000o() {
        if (O0000O0o == null) {
            O0000O0o = new JSONObject();
        }
        try {
            O0000O0o.put("appkey", O00000Oo);
            O0000O0o.put("platform", "Android");
            O0000O0o.put("packagename", O00000o0);
            O0000O0o.put("key_hash", O00000o);
            O0000O0o.put("version", O00000oO);
            O0000O0o.put("channel", O00000oo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return O0000O0o;
    }

    private static boolean O000000o(Context context) {
        if (TextUtils.isEmpty(f5610O000000o)) {
            f5610O000000o = dby.O00000Oo(context, O00000Oo);
        }
        if (O0000O0o == null) {
            O0000O0o = new JSONObject();
        }
        try {
            O0000O0o.put("aid", f5610O000000o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !TextUtils.isEmpty(f5610O000000o);
    }
}
