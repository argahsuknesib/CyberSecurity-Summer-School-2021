package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.services.a.az;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

public class BusLineSearch {

    /* renamed from: a  reason: collision with root package name */
    private IBusLineSearch f3429a = null;

    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) {
        if (this.f3429a == null) {
            try {
                this.f3429a = new az(context, busLineQuery);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BusLineResult searchBusLine() throws AMapException {
        IBusLineSearch iBusLineSearch = this.f3429a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.searchBusLine();
        }
        return null;
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        IBusLineSearch iBusLineSearch = this.f3429a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setOnBusLineSearchListener(onBusLineSearchListener);
        }
    }

    public void searchBusLineAsyn() {
        IBusLineSearch iBusLineSearch = this.f3429a;
        if (iBusLineSearch != null) {
            iBusLineSearch.searchBusLineAsyn();
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        IBusLineSearch iBusLineSearch = this.f3429a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setQuery(busLineQuery);
        }
    }

    public BusLineQuery getQuery() {
        IBusLineSearch iBusLineSearch = this.f3429a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.getQuery();
        }
        return null;
    }
}
