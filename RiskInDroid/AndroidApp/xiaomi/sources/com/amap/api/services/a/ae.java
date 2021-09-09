package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ae extends k<NearbySearch.NearbyQuery, NearbySearchResult> {
    private Context i;
    private NearbySearch.NearbyQuery j;

    public ae(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.i = context;
        this.j = nearbyQuery;
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.i));
        LatLonPoint centerPoint = this.j.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.j.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.j.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.j.getTimeRange());
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public NearbySearchResult a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            if (this.j.getType() != 1) {
                z = false;
            }
            ArrayList<NearbyInfo> a2 = z.a(jSONObject, z);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(a2);
            return nearbySearchResult;
        } catch (JSONException e) {
            s.a(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    public String i() {
        return r.c() + "/nearby/around";
    }
}
