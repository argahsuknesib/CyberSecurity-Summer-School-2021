package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class x extends k<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public x(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public ArrayList<GeocodeAddress> a(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                return z.l(jSONObject);
            }
            return arrayList;
        } catch (JSONException e) {
            s.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            s.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    public String i() {
        return r.a() + "/geocode/geo?";
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(c(((GeocodeQuery) this.f3422a).getLocationName()));
        String city = ((GeocodeQuery) this.f3422a).getCity();
        if (!z.i(city)) {
            String c = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&key=" + bp.f(this.d));
        return stringBuffer.toString();
    }
}
