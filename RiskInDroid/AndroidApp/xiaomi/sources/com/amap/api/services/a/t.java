package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

public class t extends k<DistanceSearch.DistanceQuery, DistanceResult> {
    private final String i = "/distance?";
    private final String j = "|";
    private final String k = ",";

    public t(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.f3422a).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i2 = 0; i2 < size; i2++) {
                LatLonPoint latLonPoint = origins.get(i2);
                if (latLonPoint != null) {
                    double a2 = s.a(latLonPoint.getLatitude());
                    stringBuffer.append(s.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a2);
                    if (i2 < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.f3422a).getDestination();
        if (destination != null) {
            double a3 = s.a(destination.getLatitude());
            double a4 = s.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a4);
            stringBuffer.append(",");
            stringBuffer.append(a3);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.f3422a).getType());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public DistanceResult a(String str) throws AMapException {
        return z.q(str);
    }

    public String i() {
        return r.a() + "/distance?";
    }
}
