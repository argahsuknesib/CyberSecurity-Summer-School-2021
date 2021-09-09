package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

public class NearbySearchResult {

    /* renamed from: a  reason: collision with root package name */
    private List<NearbyInfo> f3471a = new ArrayList();
    private int b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f3471a;
    }

    public int getTotalNum() {
        return this.b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f3471a = list;
        this.b = list.size();
    }
}
