package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

public class w extends k<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public w(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        if (((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(s.a(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getFrom()));
            if (!z.i(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(s.a(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getTo()));
            if (!z.i(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getDestinationPoiID());
            }
            if (!z.i(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getOriginType());
            }
            if (!z.i(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getDestinationType());
            }
            if (!z.i(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getPlateProvince());
            }
            if (!z.i(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) this.f3422a).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&ferry=");
        stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).isUseFerry() ^ true ? 1 : 0);
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) this.f3422a).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearch.DriveRouteQuery) this.f3422a).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f3422a).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3422a).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f3422a).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(c(((RouteSearch.DriveRouteQuery) this.f3422a).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public DriveRouteResult a(String str) throws AMapException {
        return z.b(str);
    }

    public String i() {
        return r.a() + "/direction/driving?";
    }
}
