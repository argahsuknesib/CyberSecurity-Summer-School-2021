package com.amap.api.services.routepoisearch;

import android.content.Context;
import com.amap.api.services.a.bi;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;

public class RoutePOISearch {

    /* renamed from: a  reason: collision with root package name */
    private IRoutePOISearch f3531a;

    public interface OnRoutePOISearchListener {
        void onRoutePoiSearched(RoutePOISearchResult routePOISearchResult, int i);
    }

    public enum RoutePOISearchType {
        TypeGasStation,
        TypeMaintenanceStation,
        TypeATM,
        TypeToilet,
        TypeFillingStation,
        TypeServiceArea
    }

    public RoutePOISearch(Context context, RoutePOISearchQuery routePOISearchQuery) {
        if (this.f3531a == null) {
            try {
                this.f3531a = new bi(context, routePOISearchQuery);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPoiSearchListener(OnRoutePOISearchListener onRoutePOISearchListener) {
        IRoutePOISearch iRoutePOISearch = this.f3531a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setRoutePOISearchListener(onRoutePOISearchListener);
        }
    }

    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        IRoutePOISearch iRoutePOISearch = this.f3531a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setQuery(routePOISearchQuery);
        }
    }

    public void searchRoutePOIAsyn() {
        IRoutePOISearch iRoutePOISearch = this.f3531a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.searchRoutePOIAsyn();
        }
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        IRoutePOISearch iRoutePOISearch = this.f3531a;
        if (iRoutePOISearch != null) {
            return iRoutePOISearch.searchRoutePOI();
        }
        return null;
    }
}
