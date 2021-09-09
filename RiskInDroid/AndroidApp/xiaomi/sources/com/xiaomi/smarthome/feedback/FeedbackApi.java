package com.xiaomi.smarthome.feedback;

import _m_j.fju;
import _m_j.fsh;
import _m_j.fsi;
import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import _m_j.ftn;
import _m_j.grr;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsi;
import _m_j.gsj;
import _m_j.gso;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.ArrayList;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum FeedbackApi {
    INSTANCE;

    public final fsn getRedDotCount(Context context, fsm<Integer, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/stat/feedback_count").O000000o(arrayList).O000000o(), new fss<Integer>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackApi.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Integer.valueOf(jSONObject.optInt("count", 0));
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn getFeedbackList(Context context, int i, int i2, fsm<fsi, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", i);
            jSONObject.put("pageSize", i2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/stat/feedback_list").O000000o(arrayList).O000000o(), new fss<fsi>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackApi.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                fsi.O000000o o000000o;
                if (jSONObject == null) {
                    return null;
                }
                fsi fsi = new fsi();
                fsi.f17053O000000o = jSONObject.optInt("page");
                fsi.O00000Oo = jSONObject.optInt("totalPage");
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                fsi.O00000o0 = new ArrayList<>();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject == null) {
                            o000000o = null;
                        } else {
                            o000000o = new fsi.O000000o();
                            o000000o.f17054O000000o = optJSONObject.optString("id");
                            o000000o.O00000Oo = optJSONObject.optString("create_time");
                            o000000o.O00000o0 = optJSONObject.optBoolean("is_new");
                            o000000o.O00000o = optJSONObject.optString("model");
                            o000000o.O00000oO = optJSONObject.optInt("status");
                            o000000o.O00000oo = optJSONObject.optString("content");
                        }
                        if (o000000o != null) {
                            fsi.O00000o0.add(o000000o);
                        }
                    }
                }
                return fsi;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn deleteFeedback(Context context, String[] strArr, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList(2);
        JSONObject jSONObject = new JSONObject();
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            String str = strArr[i];
            if (!z) {
                sb.append(",");
            }
            sb.append(str);
            i++;
            z = false;
        }
        try {
            jSONObject.put("id", sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/stat/feedback_delete").O000000o(arrayList).O000000o();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, O000000o2, new fss<Boolean>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackApi.AnonymousClass3 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.optBoolean("result"));
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn getFeedbackDetail(Context context, String str, fsm<fsh, fso> fsm) {
        ArrayList arrayList = new ArrayList(2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/stat/feedback_detail").O000000o(arrayList).O000000o(), new fss<fsh>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackApi.AnonymousClass4 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    return null;
                }
                fsh fsh = new fsh();
                fsh.f17052O000000o = jSONObject.optString("id");
                fsh.O00000Oo = jSONObject.optString("create_time");
                fsh.O00000o0 = jSONObject.optBoolean("is_new");
                fsh.O00000o = jSONObject.optString("model");
                fsh.O00000oO = jSONObject.optInt("status");
                fsh.O00000oo = jSONObject.optString("reply");
                fsh.O0000O0o = jSONObject.optString("reply_time");
                return fsh;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn sendFeedBack2(Context context, Device device, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            grr.O000000o();
            jSONObject.put("version_code", grr.O00000o0(context));
            grr.O000000o();
            jSONObject.put("version_name", grr.O00000o(context));
            if (device != null) {
                jSONObject.put("did", device.did);
                str = device.model;
                jSONObject.put("fw_ver", device.version);
            }
            if (str != null && !str.isEmpty()) {
                jSONObject.put("model", str);
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
                if (O0000Oo != null) {
                    jSONObject.put("plugin_package_id", O0000Oo.O00000Oo());
                    jSONObject.put("plugin_id", O0000Oo.O000000o());
                    jSONObject.put("plugin_ver", O0000Oo.O00000oO());
                }
            }
            if (!TextUtils.isEmpty(str5)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("router_brand", str5);
                jSONObject.put("tags", jSONObject2);
            }
            jSONObject.put("logfile", str2);
            jSONObject.put("content", str4);
            jSONObject.put("contact", str3);
            jSONObject.put("wideTagId", str6);
            jSONObject.put("originate", i);
            jSONObject.put("tagId", str7);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/stat/feedback").O000000o(arrayList).O000000o(), new fss<Void>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackApi.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return null;
            }
        }, Crypto.RC4, fsm);
    }

    public final void sendFeedBackWithoutLogin(Context context, Device device, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, final fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            grr.O000000o();
            jSONObject.put("version_code", grr.O00000o0(context));
            grr.O000000o();
            jSONObject.put("version_name", grr.O00000o(context));
            if (device != null) {
                jSONObject.put("did", device.did);
                str = device.model;
            }
            if (str != null && !str.isEmpty()) {
                jSONObject.put("model", str);
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
                if (O0000Oo != null) {
                    jSONObject.put("plugin_package_id", O0000Oo.O00000Oo());
                    jSONObject.put("plugin_id", O0000Oo.O000000o());
                }
            }
            if (!TextUtils.isEmpty(str5)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("router_brand", str5);
                jSONObject.put("tags", jSONObject2);
            }
            jSONObject.put("logfile", str2);
            jSONObject.put("content", str4);
            jSONObject.put("contact", str3);
            jSONObject.put("wideTagId", str6);
            jSONObject.put("originate", i);
            jSONObject.put("tagId", str7);
        } catch (JSONException unused) {
        }
        arrayList.add(new gsi("data", jSONObject.toString()));
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "POST";
        gsj.O000000o O00000Oo = o000000o.O00000Oo(buildUrl("/app/v2/stat/feedback_public"));
        O00000Oo.O00000oO = arrayList;
        gsj O000000o2 = O00000Oo.O000000o();
        new fss<Void>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackApi.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return null;
            }
        };
        try {
            gsg.O000000o(O000000o2, new gso() {
                /* class com.xiaomi.smarthome.feedback.FeedbackApi.AnonymousClass7 */

                public final /* synthetic */ void onSuccess(Object obj, Response response) {
                    O000000o((String) obj);
                }

                public final void O000000o(String str) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onSuccess(null);
                    }
                }

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(null);
                        if (gsf != null) {
                            fsm.onFailure(new fso(gsf.f18205O000000o, gsf.O00000Oo));
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (fsm != null) {
                fsm.onFailure(null);
            }
        }
    }

    private String buildUrl(String str) {
        String str2;
        ServerBean O00000o = fju.O000000o().O00000o();
        String O00000oo = fju.O000000o().O00000oo();
        if (O00000o == null || ftn.O00000o0(O00000o)) {
            str2 = (TextUtils.isEmpty(O00000oo) || O00000oo.equalsIgnoreCase("release") || !O00000oo.equalsIgnoreCase("preview")) ? "api.io.mi.com" : "pv.api.io.mi.com";
        } else if (TextUtils.isEmpty(O00000oo) || O00000oo.equalsIgnoreCase("release") || !O00000oo.equalsIgnoreCase("preview")) {
            str2 = O00000o.f7546O000000o + ".api.io.mi.com";
        } else {
            str2 = "pv-" + O00000o.f7546O000000o + ".api.io.mi.com";
        }
        return "https://" + str2 + str;
    }

    public final fsn requestLabels(Context context, String str, fsm<ArrayList<FeedbackLabelEntity>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("model", str);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/stat/feedback_tags").O000000o(arrayList).O000000o(), $$Lambda$FeedbackApi$2LljlcE1QjtgYgvGNp9_XhvKsPM.INSTANCE, Crypto.RC4, fsm);
    }
}
