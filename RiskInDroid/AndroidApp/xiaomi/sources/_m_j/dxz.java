package _m_j;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class dxz {

    /* renamed from: O000000o  reason: collision with root package name */
    public dxy f15050O000000o;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static dxz f15051O000000o = new dxz((byte) 0);
    }

    /* synthetic */ dxz(byte b) {
        this();
    }

    private dxz() {
        this.f15050O000000o = new dxy();
    }

    public final dxz O000000o(String str) {
        this.f15050O000000o.O00000Oo.switchFlag = false;
        this.f15050O000000o.O00000o0.switchFlag = false;
        this.f15050O000000o.O00000o.switchFlag = false;
        this.f15050O000000o.O00000oO.switchFlag = false;
        this.f15050O000000o.O00000oo.switchFlag = false;
        this.f15050O000000o.O0000O0o.switchFlag = false;
        this.f15050O000000o.O0000OOo.switchFlag = false;
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("memory_leak_monitor_config");
            if (optJSONObject != null) {
                this.f15050O000000o.O00000Oo.switchFlag = TextUtils.equals(optJSONObject.optString("switch"), "1");
                this.f15050O000000o.O00000Oo.report_type = optJSONObject.optString("report_type");
                this.f15050O000000o.O00000Oo.min_check_interval_sec = optJSONObject.optLong("min_check_interval_sec");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ui_block_monitor_config");
            if (optJSONObject2 != null) {
                this.f15050O000000o.O00000o0.switchFlag = TextUtils.equals(optJSONObject2.optString("switch"), "1");
                this.f15050O000000o.O00000o0.report_type = optJSONObject2.optString("report_type");
                this.f15050O000000o.O00000o0.threshold_ms = optJSONObject2.optLong("threshold_ms");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("activity_monitor_config");
            if (optJSONObject3 != null) {
                this.f15050O000000o.O00000o.switchFlag = TextUtils.equals(optJSONObject3.optString("switch"), "1");
                this.f15050O000000o.O00000o.report_type = optJSONObject3.optString("report_type");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("fps_monitor_config");
            if (optJSONObject4 != null) {
                this.f15050O000000o.O00000oO.switchFlag = TextUtils.equals(optJSONObject4.optString("switch"), "1");
                this.f15050O000000o.O00000oO.report_type = optJSONObject4.optString("report_type");
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("appstart_monitor_config");
            if (optJSONObject5 != null) {
                this.f15050O000000o.O00000oo.switchFlag = TextUtils.equals(optJSONObject5.optString("switch"), "1");
                this.f15050O000000o.O00000oo.report_type = optJSONObject5.optString("report_type");
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("memory_monitor_config");
            if (optJSONObject6 != null) {
                this.f15050O000000o.O0000O0o.switchFlag = TextUtils.equals(optJSONObject6.optString("switch"), "1");
                this.f15050O000000o.O0000O0o.report_type = optJSONObject6.optString("report_type");
                this.f15050O000000o.O0000O0o.min_check_interval_sec = optJSONObject6.optLong("min_check_interval_sec");
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("net_monitor_config");
            if (optJSONObject7 != null) {
                this.f15050O000000o.O0000OOo.switchFlag = TextUtils.equals(optJSONObject7.optString("switch"), "1");
                this.f15050O000000o.O0000OOo.report_type = optJSONObject7.optString("report_type");
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("dns_monitor_config");
            if (optJSONObject8 != null) {
                this.f15050O000000o.O0000Oo0.switchFlag = TextUtils.equals(optJSONObject8.optString("switch"), "1");
                this.f15050O000000o.O0000Oo0.report_type = optJSONObject8.optString("report_type");
                this.f15050O000000o.O0000Oo0.http_dns_priority = optJSONObject8.optInt("http_dns_priority");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }
}
