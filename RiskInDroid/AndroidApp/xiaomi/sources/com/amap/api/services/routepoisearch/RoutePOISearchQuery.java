package com.amap.api.services.routepoisearch;

import com.amap.api.services.a.s;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

public class RoutePOISearchQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f3533a;
    private LatLonPoint b;
    private int c;
    private RoutePOISearch.RoutePOISearchType d;
    private int e = 250;
    private List<LatLonPoint> f;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, RoutePOISearch.RoutePOISearchType routePOISearchType, int i2) {
        this.f3533a = latLonPoint;
        this.b = latLonPoint2;
        this.c = i;
        this.d = routePOISearchType;
        this.e = i2;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i) {
        this.f = list;
        this.d = routePOISearchType;
        this.e = i;
    }

    public LatLonPoint getFrom() {
        return this.f3533a;
    }

    public LatLonPoint getTo() {
        return this.b;
    }

    public int getMode() {
        return this.c;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.d;
    }

    public int getRange() {
        return this.e;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f;
    }

    public RoutePOISearchQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            s.a(e2, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f;
        if (list == null || list.size() <= 0) {
            return new RoutePOISearchQuery(this.f3533a, this.b, this.c, this.d, this.e);
        }
        return new RoutePOISearchQuery(this.f, this.d, this.e);
    }
}
