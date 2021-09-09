package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p extends o<ak, CloudItemDetail> {
    public p(Context context, ak akVar) {
        super(context, akVar);
    }

    public String i() {
        return r.c() + "/datasearch/id?";
    }

    /* renamed from: f */
    public CloudItemDetail a(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private CloudItemDetail b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("datas")) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("datas");
        if (optJSONArray.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
        CloudItemDetail a2 = a(jSONObject2);
        a(a2, jSONObject2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + bp.f(this.d));
        sb.append("&tableid=" + ((ak) this.f3422a).f3286a);
        sb.append("&output=json");
        sb.append("&_id=" + ((ak) this.f3422a).b);
        return sb.toString();
    }
}
