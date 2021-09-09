package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

public class an extends k<RouteSearch.RideRouteQuery, RideRouteResult> {
    public an(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        stringBuffer.append("&origin=");
        stringBuffer.append(s.a(((RouteSearch.RideRouteQuery) this.f3422a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(s.a(((RouteSearch.RideRouteQuery) this.f3422a).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public RideRouteResult a(String str) throws AMapException {
        return z.o(str);
    }

    public String i() {
        return r.b() + "/direction/bicycling?";
    }
}
