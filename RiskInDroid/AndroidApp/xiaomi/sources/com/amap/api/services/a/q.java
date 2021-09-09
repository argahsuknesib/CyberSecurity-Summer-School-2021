package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends o<CloudSearch.Query, CloudResult> {
    private int i = 0;

    public q(Context context, CloudSearch.Query query) {
        super(context, query);
    }

    public String i() {
        String str = r.c() + "/datasearch";
        String shape = ((CloudSearch.Query) this.f3422a).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around?";
        } else if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon?";
        } else if (!shape.equals("Local")) {
            return str;
        } else {
            return str + "/local?";
        }
    }

    /* renamed from: f */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str == null || str.equals("")) {
            return CloudResult.createPagedResult((CloudSearch.Query) this.f3422a, this.i, ((CloudSearch.Query) this.f3422a).getBound(), ((CloudSearch.Query) this.f3422a).getPageSize(), null);
        }
        try {
            arrayList = b(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return CloudResult.createPagedResult((CloudSearch.Query) this.f3422a, this.i, ((CloudSearch.Query) this.f3422a).getBound(), ((CloudSearch.Query) this.f3422a).getPageSize(), arrayList);
    }

    private ArrayList<CloudItem> b(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        if (jSONObject.has("datas")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("datas");
            this.i = jSONObject.getInt("count");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                CloudItemDetail a2 = a(optJSONObject);
                a(a2, optJSONObject);
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((CloudSearch.Query) this.f3422a).getBound() != null) {
            if (((CloudSearch.Query) this.f3422a).getBound().getShape().equals("Bound")) {
                double a2 = s.a(((CloudSearch.Query) this.f3422a).getBound().getCenter().getLongitude());
                double a3 = s.a(((CloudSearch.Query) this.f3422a).getBound().getCenter().getLatitude());
                sb.append("&center=");
                sb.append(a2 + "," + a3);
                sb.append("&radius=");
                sb.append(((CloudSearch.Query) this.f3422a).getBound().getRange());
            } else if (((CloudSearch.Query) this.f3422a).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.f3422a).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.f3422a).getBound().getUpperRight();
                double a4 = s.a(lowerLeft.getLatitude());
                double a5 = s.a(lowerLeft.getLongitude());
                double a6 = s.a(upperRight.getLatitude());
                double a7 = s.a(upperRight.getLongitude());
                sb.append("&polygon=" + a5 + "," + a4 + ";" + a7 + "," + a6);
            } else if (((CloudSearch.Query) this.f3422a).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.f3422a).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    sb.append("&polygon=" + s.a(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) this.f3422a).getBound().getShape().equals("Local")) {
                String c = c(((CloudSearch.Query) this.f3422a).getBound().getCity());
                sb.append("&city=");
                sb.append(c);
            }
        }
        sb.append("&tableid=" + ((CloudSearch.Query) this.f3422a).getTableID());
        if (!s.a(k())) {
            k();
            String c2 = c(k());
            sb.append("&filter=");
            sb.append(c2);
        }
        if (!s.a(j())) {
            sb.append("&sortrule=");
            sb.append(j());
        }
        String c3 = c(((CloudSearch.Query) this.f3422a).getQueryString());
        if (((CloudSearch.Query) this.f3422a).getQueryString() == null || ((CloudSearch.Query) this.f3422a).getQueryString().equals("")) {
            sb.append("&keywords=");
        } else {
            sb.append("&keywords=".concat(String.valueOf(c3)));
        }
        sb.append("&limit=" + ((CloudSearch.Query) this.f3422a).getPageSize());
        sb.append("&page=" + ((CloudSearch.Query) this.f3422a).getPageNum());
        sb.append("&key=" + bp.f(this.d));
        return sb.toString();
    }

    private String j() {
        return ((CloudSearch.Query) this.f3422a).getSortingrules() != null ? ((CloudSearch.Query) this.f3422a).getSortingrules().toString() : "";
    }

    private String k() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.f3422a).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.f3422a).getFilterNumString();
        stringBuffer.append(filterString);
        if (!s.a(filterString) && !s.a(filterNumString)) {
            stringBuffer.append("+");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }
}
