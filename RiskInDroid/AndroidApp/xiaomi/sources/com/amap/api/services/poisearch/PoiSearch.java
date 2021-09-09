package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.services.a.bh;
import com.amap.api.services.a.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import java.util.List;

public class PoiSearch {

    /* renamed from: a  reason: collision with root package name */
    private IPoiSearch f3477a = null;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i);

        void onPoiSearched(PoiResult poiResult, int i);
    }

    public PoiSearch(Context context, Query query) {
        if (this.f3477a == null) {
            try {
                this.f3477a = new bh(context, query);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public SearchBound getBound() {
        IPoiSearch iPoiSearch = this.f3477a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public static class Query implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private String f3478a;
        private String b;
        private String c;
        private int d;
        private int e;
        private String f;
        private boolean g;
        private boolean h;
        private String i;
        private boolean j;
        private LatLonPoint k;

        private String a() {
            return "";
        }

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public Query(String str, String str2, String str3) {
            this.d = 1;
            this.e = 20;
            this.f = "zh-CN";
            this.g = false;
            this.h = false;
            this.j = true;
            this.f3478a = str;
            this.b = str2;
            this.c = str3;
        }

        public String getBuilding() {
            return this.i;
        }

        public void setBuilding(String str) {
            this.i = str;
        }

        public String getQueryString() {
            return this.f3478a;
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f = "en";
            } else {
                this.f = "zh-CN";
            }
        }

        /* access modifiers changed from: protected */
        public String getQueryLanguage() {
            return this.f;
        }

        public String getCategory() {
            String str = this.b;
            if (str == null || str.equals("00") || this.b.equals("00|")) {
                return a();
            }
            return this.b;
        }

        public String getCity() {
            return this.c;
        }

        public int getPageNum() {
            return this.d;
        }

        public void setPageNum(int i2) {
            if (i2 <= 0) {
                i2 = 1;
            }
            this.d = i2;
        }

        public void setPageSize(int i2) {
            if (i2 <= 0) {
                this.e = 20;
            } else if (i2 > 30) {
                this.e = 30;
            } else {
                this.e = i2;
            }
        }

        public int getPageSize() {
            return this.e;
        }

        public void setCityLimit(boolean z) {
            this.g = z;
        }

        public boolean getCityLimit() {
            return this.g;
        }

        public void requireSubPois(boolean z) {
            this.h = z;
        }

        public boolean isRequireSubPois() {
            return this.h;
        }

        public boolean isDistanceSort() {
            return this.j;
        }

        public void setDistanceSort(boolean z) {
            this.j = z;
        }

        public LatLonPoint getLocation() {
            return this.k;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.k = latLonPoint;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.b(query.f3478a, this.f3478a) && PoiSearch.b(query.b, this.b) && PoiSearch.b(query.f, this.f) && PoiSearch.b(query.c, this.c) && query.g == this.g && query.i == this.i && query.e == this.e && query.j == this.j;
        }

        public int hashCode() {
            String str = this.b;
            int i2 = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.c;
            int i3 = 1231;
            int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.g ? 1231 : 1237)) * 31;
            if (!this.h) {
                i3 = 1237;
            }
            int i4 = (hashCode2 + i3) * 31;
            String str3 = this.f;
            int hashCode3 = (((((i4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            String str4 = this.f3478a;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.i;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return hashCode4 + i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            String str = this.b;
            if (str == null) {
                if (query.b != null) {
                    return false;
                }
            } else if (!str.equals(query.b)) {
                return false;
            }
            String str2 = this.c;
            if (str2 == null) {
                if (query.c != null) {
                    return false;
                }
            } else if (!str2.equals(query.c)) {
                return false;
            }
            String str3 = this.f;
            if (str3 == null) {
                if (query.f != null) {
                    return false;
                }
            } else if (!str3.equals(query.f)) {
                return false;
            }
            if (this.d != query.d || this.e != query.e) {
                return false;
            }
            String str4 = this.f3478a;
            if (str4 == null) {
                if (query.f3478a != null) {
                    return false;
                }
            } else if (!str4.equals(query.f3478a)) {
                return false;
            }
            String str5 = this.i;
            if (str5 == null) {
                if (query.i != null) {
                    return false;
                }
            } else if (!str5.equals(query.i)) {
                return false;
            }
            return this.g == query.g && this.h == query.h;
        }

        public Query clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                s.a(e2, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f3478a, this.b, this.c);
            query.setPageNum(this.d);
            query.setPageSize(this.e);
            query.setQueryLanguage(this.f);
            query.setCityLimit(this.g);
            query.requireSubPois(this.h);
            query.setBuilding(this.i);
            query.setLocation(this.k);
            query.setDistanceSort(this.j);
            return query;
        }
    }

    public static class SearchBound implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f3479a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private boolean f;
        private List<LatLonPoint> g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.c = 3000;
            this.f = true;
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.c = 3000;
            this.f = true;
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
            this.f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.c = 3000;
            this.f = true;
            this.e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.c = 3000;
            this.f = true;
            this.e = "Polygon";
            this.g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.c = 3000;
            this.f = true;
            this.f3479a = latLonPoint;
            this.b = latLonPoint2;
            this.c = i;
            this.d = latLonPoint3;
            this.e = str;
            this.g = list;
            this.f = z;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f3479a = latLonPoint;
            this.b = latLonPoint2;
            if (this.f3479a.getLatitude() >= this.b.getLatitude() || this.f3479a.getLongitude() >= this.b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.d = new LatLonPoint((this.f3479a.getLatitude() + this.b.getLatitude()) / 2.0d, (this.f3479a.getLongitude() + this.b.getLongitude()) / 2.0d);
        }

        public LatLonPoint getLowerLeft() {
            return this.f3479a;
        }

        public LatLonPoint getUpperRight() {
            return this.b;
        }

        public LatLonPoint getCenter() {
            return this.d;
        }

        public int getRange() {
            return this.c;
        }

        public String getShape() {
            return this.e;
        }

        public boolean isDistanceSort() {
            return this.f;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.g;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.d;
            int i = 0;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f3479a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.c) * 31;
            String str = this.e;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode4 + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.d;
            if (latLonPoint == null) {
                if (searchBound.d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.d)) {
                return false;
            }
            if (this.f != searchBound.f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f3479a;
            if (latLonPoint2 == null) {
                if (searchBound.f3479a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f3479a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.b;
            if (latLonPoint3 == null) {
                if (searchBound.b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.b)) {
                return false;
            }
            List<LatLonPoint> list = this.g;
            if (list == null) {
                if (searchBound.g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.g)) {
                return false;
            }
            if (this.c != searchBound.c) {
                return false;
            }
            String str = this.e;
            if (str == null) {
                if (searchBound.e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.e)) {
                return false;
            }
            return true;
        }

        public SearchBound clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                s.a(e2, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f3479a, this.b, this.c, this.d, this.e, this.g, this.f);
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
