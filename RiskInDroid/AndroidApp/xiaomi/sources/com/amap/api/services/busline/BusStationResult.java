package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class BusStationResult {

    /* renamed from: a  reason: collision with root package name */
    private int f3432a;
    private ArrayList<BusStationItem> b = new ArrayList<>();
    private BusStationQuery c;
    private List<String> d = new ArrayList();
    private List<SuggestionCity> e = new ArrayList();

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i, list, list2, arrayList);
    }

    private BusStationResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.c = busStationQuery;
        this.f3432a = a(i);
        this.e = list;
        this.d = list2;
        this.b = arrayList;
    }

    private int a(int i) {
        int pageSize = this.c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    public final int getPageCount() {
        return this.f3432a;
    }

    public final BusStationQuery getQuery() {
        return this.c;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.d;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public final List<BusStationItem> getBusStations() {
        return this.b;
    }
}
