package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;

public interface IDistrictSearch {
    DistrictSearchQuery getQuery();

    DistrictResult searchDistrict() throws AMapException;

    void searchDistrictAnsy();

    void searchDistrictAsyn();

    void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener);

    void setQuery(DistrictSearchQuery districtSearchQuery);
}
