package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

public class au extends k<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    public au(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        stringBuffer.append("&origin=");
        stringBuffer.append(s.a(((RouteSearch.WalkRouteQuery) this.f3422a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(s.a(((RouteSearch.WalkRouteQuery) this.f3422a).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public WalkRouteResult a(String str) throws AMapException {
        return z.c(str);
    }

    public String i() {
        return r.a() + "/direction/walking?";
    }
}
