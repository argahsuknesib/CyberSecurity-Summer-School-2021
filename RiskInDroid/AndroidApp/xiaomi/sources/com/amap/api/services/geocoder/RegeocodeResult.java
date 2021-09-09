package com.amap.api.services.geocoder;

public class RegeocodeResult {

    /* renamed from: a  reason: collision with root package name */
    private RegeocodeQuery f3460a;
    private RegeocodeAddress b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f3460a = regeocodeQuery;
        this.b = regeocodeAddress;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f3460a;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f3460a = regeocodeQuery;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.b;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.b = regeocodeAddress;
    }
}
