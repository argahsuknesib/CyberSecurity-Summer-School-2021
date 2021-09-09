package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ITrafficSearch;
import com.amap.api.services.traffic.CircleTrafficQuery;
import com.amap.api.services.traffic.RoadTrafficQuery;
import com.amap.api.services.traffic.TrafficSearch;
import com.amap.api.services.traffic.TrafficStatusResult;

public class bl implements ITrafficSearch {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3333a = "bl";
    /* access modifiers changed from: private */
    public TrafficSearch.OnTrafficSearchListener b;
    private Context c;
    /* access modifiers changed from: private */
    public Handler d = ac.a();

    public bl(Context context) {
        this.c = context.getApplicationContext();
    }

    public void setTrafficSearchListener(TrafficSearch.OnTrafficSearchListener onTrafficSearchListener) {
        this.b = onTrafficSearchListener;
    }

    public TrafficStatusResult loadTrafficByRoad(RoadTrafficQuery roadTrafficQuery) throws AMapException {
        try {
            aa.a(this.c);
            if (roadTrafficQuery != null) {
                return (TrafficStatusResult) new ao(this.c, roadTrafficQuery.clone()).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            s.a(e, f3333a, "loadTrafficByRoad");
            throw e;
        }
    }

    public void loadTrafficByRoadAsyn(final RoadTrafficQuery roadTrafficQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bl.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 300;
                    obtainMessage.arg1 = 15;
                    Bundle bundle = new Bundle();
                    TrafficStatusResult trafficStatusResult = null;
                    try {
                        trafficStatusResult = bl.this.loadTrafficByRoad(roadTrafficQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bl.this.b;
                        bundle.putParcelable("result", trafficStatusResult);
                        obtainMessage.setData(bundle);
                        bl.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bl.this.b;
                    bundle.putParcelable("result", trafficStatusResult);
                    obtainMessage.setData(bundle);
                    bl.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, f3333a, "loadTrafficByRoadAsyn");
        }
    }

    public TrafficStatusResult loadTrafficByCircle(CircleTrafficQuery circleTrafficQuery) throws AMapException {
        try {
            aa.a(this.c);
            if (circleTrafficQuery != null) {
                return (TrafficStatusResult) new n(this.c, circleTrafficQuery.clone()).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            s.a(e, f3333a, "loadTrafficByCircle");
            throw e;
        }
    }

    public void loadTrafficByCircleAsyn(final CircleTrafficQuery circleTrafficQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bl.AnonymousClass2 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 301;
                    obtainMessage.arg1 = 15;
                    Bundle bundle = new Bundle();
                    TrafficStatusResult trafficStatusResult = null;
                    try {
                        trafficStatusResult = bl.this.loadTrafficByCircle(circleTrafficQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bl.this.b;
                        bundle.putParcelable("result", trafficStatusResult);
                        obtainMessage.setData(bundle);
                        bl.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bl.this.b;
                    bundle.putParcelable("result", trafficStatusResult);
                    obtainMessage.setData(bundle);
                    bl.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, f3333a, "loadTrafficByCircleAsyn");
        }
    }
}
