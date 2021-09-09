package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class am extends k<RegeocodeQuery, RegeocodeAddress> {
    public am(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    public String i() {
        return r.a() + "/geocode/regeo?";
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public RegeocodeAddress a(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject == null) {
                return regeocodeAddress;
            }
            regeocodeAddress.setFormatAddress(z.a(optJSONObject, "formatted_address"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            if (optJSONObject2 != null) {
                z.a(optJSONObject2, regeocodeAddress);
            }
            regeocodeAddress.setPois(z.c(optJSONObject));
            JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
            if (optJSONArray != null) {
                z.b(optJSONArray, regeocodeAddress);
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
            if (optJSONArray2 != null) {
                z.a(optJSONArray2, regeocodeAddress);
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
            if (optJSONArray3 != null) {
                z.c(optJSONArray3, regeocodeAddress);
            }
            return regeocodeAddress;
        } catch (JSONException e) {
            s.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&extensions=all&location=");
        stringBuffer.append(((RegeocodeQuery) this.f3422a).getPoint().getLongitude());
        stringBuffer.append(",");
        stringBuffer.append(((RegeocodeQuery) this.f3422a).getPoint().getLatitude());
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f3422a).getPoiType())) {
            stringBuffer.append("&poitype=");
            stringBuffer.append(((RegeocodeQuery) this.f3422a).getPoiType());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append((int) ((RegeocodeQuery) this.f3422a).getRadius());
        stringBuffer.append("&coordsys=");
        stringBuffer.append(((RegeocodeQuery) this.f3422a).getLatLonType());
        stringBuffer.append("&key=" + bp.f(this.d));
        return stringBuffer.toString();
    }
}
