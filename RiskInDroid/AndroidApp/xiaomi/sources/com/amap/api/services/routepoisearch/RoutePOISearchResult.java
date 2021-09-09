package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

public class RoutePOISearchResult {

    /* renamed from: a  reason: collision with root package name */
    private List<RoutePOIItem> f3534a = new ArrayList();
    private RoutePOISearchQuery b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        this.f3534a = arrayList;
        this.b = routePOISearchQuery;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f3534a;
    }

    public RoutePOISearchQuery getQuery() {
        return this.b;
    }
}
