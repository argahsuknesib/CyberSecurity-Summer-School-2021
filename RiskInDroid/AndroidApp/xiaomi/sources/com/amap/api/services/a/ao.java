package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.traffic.RoadTrafficQuery;
import com.amap.api.services.traffic.TrafficStatusResult;

public class ao extends k<RoadTrafficQuery, TrafficStatusResult> {
    public ao(Context context, RoadTrafficQuery roadTrafficQuery) {
        super(context, roadTrafficQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.d));
        if (!TextUtils.isEmpty(((RoadTrafficQuery) this.f3422a).getName())) {
            stringBuffer.append("&name=");
            stringBuffer.append(((RoadTrafficQuery) this.f3422a).getName());
        }
        if (!TextUtils.isEmpty(((RoadTrafficQuery) this.f3422a).getAdCode())) {
            stringBuffer.append("&adcode=");
            stringBuffer.append(((RoadTrafficQuery) this.f3422a).getAdCode());
        }
        stringBuffer.append("&level=");
        stringBuffer.append(((RoadTrafficQuery) this.f3422a).getLevel());
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
        return r.a() + "/traffic/status/road?";
    }
}
