package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u extends k<DistrictSearchQuery, DistrictResult> {
    public u(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.f3422a).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.f3422a).getPageSize());
        stringBuffer.append("&showChild=");
        stringBuffer.append(((DistrictSearchQuery) this.f3422a).isShowChild());
        if (((DistrictSearchQuery) this.f3422a).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.f3422a).checkKeyWords()) {
            String c = c(((DistrictSearchQuery) this.f3422a).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&key=" + bp.f(this.d));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public DistrictResult a(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.f3422a, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                return districtResult;
            }
            z.a(optJSONArray, arrayList, null);
            return districtResult;
        } catch (JSONException e) {
            s.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            s.a(e2, "DistrictServerHandler", "paseJSONException");
        }
    }

    public String i() {
        return r.a() + "/config/district?";
    }
}
