package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ap extends k<RoutePOISearchQuery, RoutePOISearchResult> {
    public ap(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        stringBuffer.append("&range=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RoutePOISearchQuery) this.f3422a).getRange());
        stringBuffer.append(sb.toString());
        String str = "";
        try {
            switch (((RoutePOISearchQuery) this.f3422a).getSearchType()) {
                case TypeGasStation:
                    str = "0101";
                    break;
                case TypeMaintenanceStation:
                    str = "0300";
                    break;
                case TypeATM:
                    str = "1603";
                    break;
                case TypeToilet:
                    str = "2003";
                    break;
                case TypeFillingStation:
                    str = "0103";
                    break;
                case TypeServiceArea:
                    str = "180301";
                    break;
            }
        } catch (Exception unused) {
        }
        if (((RoutePOISearchQuery) this.f3422a).getPolylines() == null || ((RoutePOISearchQuery) this.f3422a).getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(s.a(((RoutePOISearchQuery) this.f3422a).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(s.a(((RoutePOISearchQuery) this.f3422a).getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((RoutePOISearchQuery) this.f3422a).getMode());
            stringBuffer.append(sb2.toString());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(s.a(((RoutePOISearchQuery) this.f3422a).getPolylines()));
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public RoutePOISearchResult a(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = z.w(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.f3422a);
    }

    public String i() {
        return r.a() + "/place/route?";
    }
}
