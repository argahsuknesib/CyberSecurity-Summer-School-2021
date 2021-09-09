package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.services.a.ba;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

public class BusStationSearch {

    /* renamed from: a  reason: collision with root package name */
    private IBusStationSearch f3433a;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        if (this.f3433a == null) {
            try {
                this.f3433a = new ba(context, busStationQuery);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BusStationResult searchBusStation() throws AMapException {
        IBusStationSearch iBusStationSearch = this.f3433a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.searchBusStation();
        }
        return null;
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        IBusStationSearch iBusStationSearch = this.f3433a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void searchBusStationAsyn() {
        IBusStationSearch iBusStationSearch = this.f3433a;
        if (iBusStationSearch != null) {
            iBusStationSearch.searchBusStationAsyn();
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        IBusStationSearch iBusStationSearch = this.f3433a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setQuery(busStationQuery);
        }
    }

    public BusStationQuery getQuery() {
        IBusStationSearch iBusStationSearch = this.f3433a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.getQuery();
        }
        return null;
    }
}
