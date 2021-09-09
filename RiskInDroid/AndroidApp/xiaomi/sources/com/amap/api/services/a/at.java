package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

public class at extends k<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    private final String i = "/direction/truck?";
    private final String j = "|";
    private final String k = ",";

    public at(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        if (((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(s.a(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getFrom()));
            if (!z.i(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(s.a(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getTo()));
            if (!z.i(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getDestinationPoiID());
            }
            if (!z.i(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getOriginType());
            }
            if (!z.i(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getDestinationType());
            }
            if (!z.i(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getPlateProvince());
            }
            if (!z.i(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getMode());
        if (((RouteSearch.TruckRouteQuery) this.f3422a).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3422a).getTruckAxis());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public TruckRouteRestult a(String str) throws AMapException {
        return z.r(str);
    }

    public String i() {
        return r.b() + "/direction/truck?";
    }
}
