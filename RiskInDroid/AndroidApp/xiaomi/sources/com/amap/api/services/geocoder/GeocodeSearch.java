package com.amap.api.services.geocoder;

import android.content.Context;
import com.amap.api.services.a.be;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

public final class GeocodeSearch {

    /* renamed from: a  reason: collision with root package name */
    private IGeocodeSearch f3457a;

    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(GeocodeResult geocodeResult, int i);

        void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i);
    }

    public GeocodeSearch(Context context) {
        if (this.f3457a == null) {
            try {
                this.f3457a = new be(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        IGeocodeSearch iGeocodeSearch = this.f3457a;
        if (iGeocodeSearch != null) {
            return iGeocodeSearch.getFromLocation(regeocodeQuery);
        }
        return null;
    }

    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        IGeocodeSearch iGeocodeSearch = this.f3457a;
        if (iGeocodeSearch != null) {
            return iGeocodeSearch.getFromLocationName(geocodeQuery);
        }
        return null;
    }

    public final void setOnGeocodeSearchListener(OnGeocodeSearchListener onGeocodeSearchListener) {
        IGeocodeSearch iGeocodeSearch = this.f3457a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.setOnGeocodeSearchListener(onGeocodeSearchListener);
        }
    }

    public final void getFromLocationAsyn(RegeocodeQuery regeocodeQuery) {
        IGeocodeSearch iGeocodeSearch = this.f3457a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.getFromLocationAsyn(regeocodeQuery);
        }
    }

    public final void getFromLocationNameAsyn(GeocodeQuery geocodeQuery) {
        IGeocodeSearch iGeocodeSearch = this.f3457a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.getFromLocationNameAsyn(geocodeQuery);
        }
    }
}
