package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.ac;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

public final class be implements IGeocodeSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f3304a;
    /* access modifiers changed from: private */
    public GeocodeSearch.OnGeocodeSearchListener b;
    /* access modifiers changed from: private */
    public Handler c = ac.a();

    public be(Context context) {
        this.f3304a = context.getApplicationContext();
    }

    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            aa.a(this.f3304a);
            if (a(regeocodeQuery)) {
                return (RegeocodeAddress) new am(this.f3304a, regeocodeQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            s.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            aa.a(this.f3304a);
            if (geocodeQuery != null) {
                return (List) new x(this.f3304a, geocodeQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            s.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }

    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.be.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 2;
                        obtainMessage.what = 201;
                        ac.i iVar = new ac.i();
                        iVar.b = be.this.b;
                        obtainMessage.obj = iVar;
                        iVar.f3281a = new RegeocodeResult(regeocodeQuery, be.this.getFromLocation(regeocodeQuery));
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        be.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    be.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.be.AnonymousClass2 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    try {
                        obtainMessage.what = 200;
                        obtainMessage.arg1 = 2;
                        obtainMessage.arg2 = 1000;
                        ac.e eVar = new ac.e();
                        eVar.b = be.this.b;
                        obtainMessage.obj = eVar;
                        eVar.f3277a = new GeocodeResult(geocodeQuery, be.this.getFromLocationName(geocodeQuery));
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        be.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    be.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    private boolean a(RegeocodeQuery regeocodeQuery) {
        if (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) {
            return false;
        }
        return true;
    }
}
