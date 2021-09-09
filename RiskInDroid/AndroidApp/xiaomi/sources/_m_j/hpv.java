package _m_j;

import com.amap.api.services.core.LatLonPoint;

public final class hpv {

    /* renamed from: O000000o  reason: collision with root package name */
    public final double f511O000000o;
    public final double O00000Oo;

    public hpv(double d, double d2) {
        this.f511O000000o = d2;
        this.O00000Oo = d;
    }

    public hpv(LatLonPoint latLonPoint) {
        this.f511O000000o = latLonPoint.getLongitude();
        this.O00000Oo = latLonPoint.getLatitude();
    }
}
