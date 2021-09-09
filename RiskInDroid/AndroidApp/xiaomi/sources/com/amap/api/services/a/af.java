package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

public class af extends k<UploadInfo, Integer> {
    private Context i;
    private UploadInfo j;

    public af(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.i = context;
        this.j = uploadInfo;
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.i));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.j.getUserID());
        LatLonPoint point = this.j.getPoint();
        stringBuffer.append("&location=");
        stringBuffer.append(((float) ((int) (point.getLongitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((float) ((int) (point.getLatitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.j.getCoordType());
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Integer a(String str) throws AMapException {
        return 0;
    }

    public String i() {
        return r.c() + "/nearby/data/create";
    }
}
