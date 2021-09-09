package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ah extends ag<String, PoiItem> {
    public ah(Context context, String str) {
        super(context, str);
    }

    public String i() {
        return r.a() + "/place/detail?";
    }

    /* renamed from: f */
    public PoiItem a(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            s.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            s.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    private PoiItem a(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("pois")) == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return z.d(optJSONObject);
    }

    /* access modifiers changed from: protected */
    public String g() {
        return j();
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.f3422a);
        sb.append("&output=json");
        sb.append("&extensions=all");
        sb.append("&children=1");
        sb.append("&key=" + bp.f(this.d));
        return sb.toString();
    }
}
