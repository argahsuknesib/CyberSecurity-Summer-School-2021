package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

public class l extends k<RouteSearch.BusRouteQuery, BusRouteResult> {
    public l(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        stringBuffer.append("&origin=");
        stringBuffer.append(s.a(((RouteSearch.BusRouteQuery) this.f3422a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(s.a(((RouteSearch.BusRouteQuery) this.f3422a).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.f3422a).getCity();
        if (!z.i(city)) {
            city = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!z.i(((RouteSearch.BusRouteQuery) this.f3422a).getCity())) {
            String c = c(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) this.f3422a).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.f3422a).getNightFlag());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public BusRouteResult a(String str) throws AMapException {
        return z.a(str);
    }

    public String i() {
        return r.a() + "/direction/transit/integrated?";
    }
}
