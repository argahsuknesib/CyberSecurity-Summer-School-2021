package _m_j;

import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AMapLocationServer;

public final class bue {

    /* renamed from: O000000o  reason: collision with root package name */
    public AMapLocationServer f13284O000000o = null;
    public long O00000Oo = 0;
    public boolean O00000o = true;
    public long O00000o0 = 0;
    public int O00000oO = 0;
    public long O00000oo = 0;
    AMapLocation O0000O0o = null;
    long O0000OOo = 0;

    public final AMapLocationServer O000000o(AMapLocationServer aMapLocationServer) {
        int i;
        if (bwi.O000000o(aMapLocationServer)) {
            if (!this.O00000o || !bvy.O00000Oo(aMapLocationServer.getTime())) {
                i = this.O00000oO;
            } else if (aMapLocationServer.getLocationType() == 5 || aMapLocationServer.getLocationType() == 6) {
                i = 4;
            }
            aMapLocationServer.setLocationType(i);
        }
        return aMapLocationServer;
    }

    public final void O000000o() {
        this.f13284O000000o = null;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O0000O0o = null;
        this.O0000OOo = 0;
    }
}
