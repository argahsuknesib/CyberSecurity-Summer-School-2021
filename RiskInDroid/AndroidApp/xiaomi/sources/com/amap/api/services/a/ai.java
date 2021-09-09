package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ai extends ag<al, PoiResult> {
    private int i = 0;
    private List<String> j = new ArrayList();
    private List<SuggestionCity> k = new ArrayList();

    private String a(boolean z) {
        return z ? "distance" : "weight";
    }

    public ai(Context context, al alVar) {
        super(context, alVar);
    }

    public String i() {
        String str = r.a() + "/place";
        if (((al) this.f3422a).b == null) {
            return str + "/text?";
        } else if (((al) this.f3422a).b.getShape().equals("Bound")) {
            return str + "/around?";
        } else if (!((al) this.f3422a).b.getShape().equals("Rectangle") && !((al) this.f3422a).b.getShape().equals("Polygon")) {
            return str;
        } else {
            return str + "/polygon?";
        }
    }

    /* renamed from: f */
    public PoiResult a(String str) throws AMapException {
        ArrayList<PoiItem> arrayList;
        String str2 = str;
        ArrayList<PoiItem> arrayList2 = new ArrayList<>();
        if (str2 == null) {
            return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList2);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            this.i = jSONObject.optInt("count");
            arrayList = z.c(jSONObject);
            try {
                if (!jSONObject.has("suggestion")) {
                    return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
                if (optJSONObject == null) {
                    return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList);
                }
                this.k = z.a(optJSONObject);
                this.j = z.b(optJSONObject);
                return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList);
            } catch (JSONException e) {
                e = e;
                s.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
                return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList);
            } catch (Exception e2) {
                e = e2;
                s.a(e, "PoiSearchKeywordHandler", "paseJSONException");
                return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList);
            }
        } catch (JSONException e3) {
            e = e3;
            arrayList = arrayList2;
            s.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
            return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList);
        } catch (Exception e4) {
            e = e4;
            arrayList = arrayList2;
            s.a(e, "PoiSearchKeywordHandler", "paseJSONException");
            return PoiResult.createPagedResult(((al) this.f3422a).f3287a, ((al) this.f3422a).b, this.j, this.k, ((al) this.f3422a).f3287a.getPageSize(), this.i, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public String g() {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((al) this.f3422a).b != null) {
            if (((al) this.f3422a).b.getShape().equals("Bound")) {
                double a2 = s.a(((al) this.f3422a).b.getCenter().getLongitude());
                double a3 = s.a(((al) this.f3422a).b.getCenter().getLatitude());
                sb.append("&location=");
                sb.append(a2 + "," + a3);
                sb.append("&radius=");
                sb.append(((al) this.f3422a).b.getRange());
                sb.append("&sortrule=");
                sb.append(a(((al) this.f3422a).b.isDistanceSort()));
            } else if (((al) this.f3422a).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((al) this.f3422a).b.getLowerLeft();
                LatLonPoint upperRight = ((al) this.f3422a).b.getUpperRight();
                double a4 = s.a(lowerLeft.getLatitude());
                double a5 = s.a(lowerLeft.getLongitude());
                double a6 = s.a(upperRight.getLatitude());
                double a7 = s.a(upperRight.getLongitude());
                sb.append("&polygon=" + a5 + "," + a4 + ";" + a7 + "," + a6);
            } else if (((al) this.f3422a).b.getShape().equals("Polygon") && (polyGonList = ((al) this.f3422a).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + s.a(polyGonList));
            }
        }
        String city = ((al) this.f3422a).f3287a.getCity();
        if (!e(city)) {
            String c = c(city);
            sb.append("&city=");
            sb.append(c);
        }
        String c2 = c(((al) this.f3422a).f3287a.getQueryString());
        if (!e(c2)) {
            sb.append("&keywords=".concat(String.valueOf(c2)));
        }
        sb.append("&offset=" + ((al) this.f3422a).f3287a.getPageSize());
        sb.append("&page=" + ((al) this.f3422a).f3287a.getPageNum());
        String building = ((al) this.f3422a).f3287a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=" + ((al) this.f3422a).f3287a.getBuilding());
        }
        String c3 = c(((al) this.f3422a).f3287a.getCategory());
        if (!e(c3)) {
            sb.append("&types=".concat(String.valueOf(c3)));
        }
        sb.append("&extensions=all");
        sb.append("&key=" + bp.f(this.d));
        if (((al) this.f3422a).f3287a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((al) this.f3422a).f3287a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (((al) this.f3422a).b == null && ((al) this.f3422a).f3287a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(a(((al) this.f3422a).f3287a.isDistanceSort()));
            double a8 = s.a(((al) this.f3422a).f3287a.getLocation().getLongitude());
            double a9 = s.a(((al) this.f3422a).f3287a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a8 + "," + a9);
        }
        sb.append("&special=false");
        return sb.toString();
    }
}
