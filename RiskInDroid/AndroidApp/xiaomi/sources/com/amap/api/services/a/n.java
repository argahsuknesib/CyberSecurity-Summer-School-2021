package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.traffic.CircleTrafficQuery;
import com.amap.api.services.traffic.TrafficStatusResult;

public class n extends k<CircleTrafficQuery, TrafficStatusResult> {
    public n(Context context, CircleTrafficQuery circleTrafficQuery) {
        super(context, circleTrafficQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        if (((CircleTrafficQuery) this.f3422a).getCenterPoint() != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(s.a(((CircleTrafficQuery) this.f3422a).getCenterPoint()));
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(((CircleTrafficQuery) this.f3422a).getRadius());
        stringBuffer.append("&level=");
        stringBuffer.append(((CircleTrafficQuery) this.f3422a).getLevel());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public TrafficStatusResult a(String str) throws AMapException {
        return z.p(str);
    }

    public String i() {
        return r.a() + "/traffic/status/circle?";
    }
}
