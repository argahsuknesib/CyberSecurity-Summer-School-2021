package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

public class v extends k<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public v(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        if (((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(s.a(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getFrom()));
            if (!z.i(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(s.a(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getTo()));
            if (!z.i(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getDestinationPoiID());
            }
            if (!z.i(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getOriginType());
            }
            if (!z.i(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getDestinationType());
            }
            if (!z.i(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getPlateProvince());
            }
            if (!z.i(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3422a).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) this.f3422a).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3422a).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DrivePlanQuery) this.f3422a).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DrivePlanQuery) this.f3422a).getCarType());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&firsttime=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearch.DrivePlanQuery) this.f3422a).getFirstTime());
        stringBuffer.append(sb3.toString());
        stringBuffer.append("&interval=");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((RouteSearch.DrivePlanQuery) this.f3422a).getInterval());
        stringBuffer.append(sb4.toString());
        stringBuffer.append("&count=");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((RouteSearch.DrivePlanQuery) this.f3422a).getCount());
        stringBuffer.append(sb5.toString());
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public DriveRoutePlanResult a(String str) throws AMapException {
        return z.s(str);
    }

    public String i() {
        return r.b() + "/etd/driving?";
    }
}
