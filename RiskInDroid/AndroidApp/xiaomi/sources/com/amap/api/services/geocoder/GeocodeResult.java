package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

public class GeocodeResult {

    /* renamed from: a  reason: collision with root package name */
    private GeocodeQuery f3456a;
    private List<GeocodeAddress> b = new ArrayList();

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        this.f3456a = geocodeQuery;
        this.b = list;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f3456a;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f3456a = geocodeQuery;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.b;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.b = list;
    }
}
