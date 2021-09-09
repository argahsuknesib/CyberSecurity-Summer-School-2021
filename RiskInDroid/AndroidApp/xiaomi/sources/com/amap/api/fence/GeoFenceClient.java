package com.amap.api.fence;

import _m_j.bvz;
import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.location.DPoint;
import com.loc.j;
import java.util.ArrayList;
import java.util.List;

public class GeoFenceClient {

    /* renamed from: a  reason: collision with root package name */
    Context f3249a = null;
    GeoFenceManagerBase b = null;

    public GeoFenceClient(Context context) {
        if (context != null) {
            try {
                this.f3249a = context.getApplicationContext();
                this.b = new j(context);
            } catch (Throwable th) {
                bvz.O000000o(th, "GeoFenceClient", "<init>");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    public void addGeoFence(DPoint dPoint, float f, String str) {
        try {
            this.b.addRoundGeoFence(dPoint, f, str);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.b.addDistrictGeoFence(str, str2);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "addGeoFence district");
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            this.b.addNearbyGeoFence(str, str2, dPoint, f, i, str3);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            this.b.addKeywordGeoFence(str, str2, str3, i, str4);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.b.addPolygonGeoFence(list, str);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.b.createPendingIntent(str);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.b.getAllGeoFence();
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.b.isPause();
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.b.pauseGeoFence();
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.b.removeGeoFence();
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.b.removeGeoFence(geoFence);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void resumeGeoFence() {
        try {
            this.b.resumeGeoFence();
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i) {
        try {
            this.b.setActivateAction(i);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z) {
        try {
            this.b.setGeoFenceAble(str, z);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.b.setGeoFenceListener(geoFenceListener);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }
}
