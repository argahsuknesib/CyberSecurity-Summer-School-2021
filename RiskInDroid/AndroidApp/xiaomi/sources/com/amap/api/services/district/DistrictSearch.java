package com.amap.api.services.district;

import android.content.Context;
import com.amap.api.services.a.bd;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistrictSearch;

public class DistrictSearch {

    /* renamed from: a  reason: collision with root package name */
    private IDistrictSearch f3450a;

    public interface OnDistrictSearchListener {
        void onDistrictSearched(DistrictResult districtResult);
    }

    public DistrictSearch(Context context) {
        if (this.f3450a == null) {
            try {
                this.f3450a = new bd(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public DistrictSearchQuery getQuery() {
        IDistrictSearch iDistrictSearch = this.f3450a;
        if (iDistrictSearch != null) {
            return iDistrictSearch.getQuery();
        }
        return null;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        IDistrictSearch iDistrictSearch = this.f3450a;
        if (iDistrictSearch != null) {
            iDistrictSearch.setQuery(districtSearchQuery);
        }
    }

    public DistrictResult searchDistrict() throws AMapException {
        IDistrictSearch iDistrictSearch = this.f3450a;
        if (iDistrictSearch != null) {
            return iDistrictSearch.searchDistrict();
        }
        return null;
    }

    public void searchDistrictAsyn() {
        IDistrictSearch iDistrictSearch = this.f3450a;
        if (iDistrictSearch != null) {
            iDistrictSearch.searchDistrictAsyn();
        }
    }

    public void searchDistrictAnsy() {
        IDistrictSearch iDistrictSearch = this.f3450a;
        if (iDistrictSearch != null) {
            iDistrictSearch.searchDistrictAnsy();
        }
    }

    public void setOnDistrictSearchListener(OnDistrictSearchListener onDistrictSearchListener) {
        IDistrictSearch iDistrictSearch = this.f3450a;
        if (iDistrictSearch != null) {
            iDistrictSearch.setOnDistrictSearchListener(onDistrictSearchListener);
        }
    }
}
