package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.services.a.aj;
import com.amap.api.services.a.bb;
import com.amap.api.services.a.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CloudSearch {

    /* renamed from: a  reason: collision with root package name */
    private ICloudSearch f3437a;

    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i);

        void onCloudSearched(CloudResult cloudResult, int i);
    }

    public CloudSearch(Context context) {
        if (this.f3437a == null) {
            try {
                this.f3437a = new bb(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.f3437a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.f3437a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.f3437a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public static class Query implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private String f3438a;
        private int b = 1;
        private int c = 20;
        private String d;
        private SearchBound e;
        private Sortingrules f;
        private ArrayList<aj> g = new ArrayList<>();
        private HashMap<String, String> h = new HashMap<>();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (s.a(str) || searchBound == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            this.d = str;
            this.f3438a = str2;
            this.e = searchBound;
        }

        private Query() {
        }

        public String getQueryString() {
            return this.f3438a;
        }

        public void setTableID(String str) {
            this.d = str;
        }

        public String getTableID() {
            return this.d;
        }

        public int getPageNum() {
            return this.b;
        }

        public void setPageNum(int i) {
            this.b = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.c = 20;
            } else if (i > 100) {
                this.c = 100;
            } else {
                this.c = i;
            }
        }

        public int getPageSize() {
            return this.c;
        }

        public void setBound(SearchBound searchBound) {
            this.e = searchBound;
        }

        public SearchBound getBound() {
            return this.e;
        }

        public void addFilterString(String str, String str2) {
            this.h.put(str, str2);
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                for (Map.Entry next : this.h.entrySet()) {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    stringBuffer.append(key.toString());
                    stringBuffer.append(":");
                    stringBuffer.append(value.toString());
                    stringBuffer.append("+");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.g.add(new aj(str, str2, str3));
        }

        private ArrayList<aj> a() {
            if (this.g == null) {
                return null;
            }
            ArrayList<aj> arrayList = new ArrayList<>();
            arrayList.addAll(this.g);
            return arrayList;
        }

        private HashMap<String, String> b() {
            if (this.h == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.putAll(this.h);
            return hashMap;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                Iterator<aj> it = this.g.iterator();
                while (it.hasNext()) {
                    aj next = it.next();
                    stringBuffer.append(next.a());
                    stringBuffer.append(":[");
                    stringBuffer.append(next.b());
                    stringBuffer.append(",");
                    stringBuffer.append(next.c());
                    stringBuffer.append("]");
                    stringBuffer.append("+");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f = sortingrules;
        }

        public Sortingrules getSortingrules() {
            return this.f;
        }

        private boolean a(SearchBound searchBound, SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        private boolean a(Sortingrules sortingrules, Sortingrules sortingrules2) {
            if (sortingrules == null && sortingrules2 == null) {
                return true;
            }
            if (sortingrules == null || sortingrules2 == null) {
                return false;
            }
            return sortingrules.equals(sortingrules2);
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return CloudSearch.b(query.f3438a, this.f3438a) && CloudSearch.b(query.getTableID(), getTableID()) && CloudSearch.b(query.getFilterString(), getFilterString()) && CloudSearch.b(query.getFilterNumString(), getFilterNumString()) && query.c == this.c && a(query.getBound(), getBound()) && a(query.getSortingrules(), getSortingrules());
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            ArrayList<aj> arrayList = this.g;
            int i6 = 0;
            if (arrayList == null) {
                i = 0;
            } else {
                i = arrayList.hashCode();
            }
            int i7 = (i + 31) * 31;
            HashMap<String, String> hashMap = this.h;
            if (hashMap == null) {
                i2 = 0;
            } else {
                i2 = hashMap.hashCode();
            }
            int i8 = (i7 + i2) * 31;
            SearchBound searchBound = this.e;
            if (searchBound == null) {
                i3 = 0;
            } else {
                i3 = searchBound.hashCode();
            }
            int i9 = (((((i8 + i3) * 31) + this.b) * 31) + this.c) * 31;
            String str = this.f3438a;
            if (str == null) {
                i4 = 0;
            } else {
                i4 = str.hashCode();
            }
            int i10 = (i9 + i4) * 31;
            Sortingrules sortingrules = this.f;
            if (sortingrules == null) {
                i5 = 0;
            } else {
                i5 = sortingrules.hashCode();
            }
            int i11 = (i10 + i5) * 31;
            String str2 = this.d;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            return i11 + i6;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                return queryEquals(query) && query.b == this.b;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
        public Query clone() {
            Query query;
            AMapException e2;
            try {
                super.clone();
            } catch (CloneNotSupportedException e3) {
                e3.printStackTrace();
            }
            try {
                query = new Query(this.d, this.f3438a, this.e);
                try {
                    query.setPageNum(this.b);
                    query.setPageSize(this.c);
                    query.setSortingrules(getSortingrules());
                    query.g = a();
                    query.h = b();
                } catch (AMapException e4) {
                    e2 = e4;
                }
            } catch (AMapException e5) {
                AMapException aMapException = e5;
                query = null;
                e2 = aMapException;
                e2.printStackTrace();
                if (query != null) {
                }
            }
            return query != null ? new Query() : query;
        }
    }

    public static class Sortingrules {

        /* renamed from: a  reason: collision with root package name */
        private int f3440a = 0;
        private String b;
        private boolean c = true;

        public Sortingrules(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        public Sortingrules(int i) {
            this.f3440a = i;
        }

        public String toString() {
            if (s.a(this.b)) {
                int i = this.f3440a;
                if (i == 0) {
                    return "_weight";
                }
                return i == 1 ? "_distance" : "";
            } else if (this.c) {
                return this.b + ":1";
            } else {
                return this.b + ":0";
            }
        }

        public int hashCode() {
            int i = ((this.c ? 1231 : 1237) + 31) * 31;
            String str = this.b;
            return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.f3440a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sortingrules sortingrules = (Sortingrules) obj;
            if (this.c != sortingrules.c) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (sortingrules.b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.b)) {
                return false;
            }
            return this.f3440a == sortingrules.f3440a;
        }
    }

    public static class SearchBound implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f3439a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private List<LatLonPoint> f;
        private String g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.e = "Rectangle";
            if (!a(latLonPoint, latLonPoint2)) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
        }

        public SearchBound(List<LatLonPoint> list) {
            this.e = "Polygon";
            this.f = list;
        }

        public SearchBound(String str) {
            this.e = "Local";
            this.g = str;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f3439a = latLonPoint;
            this.b = latLonPoint2;
            LatLonPoint latLonPoint3 = this.f3439a;
            if (latLonPoint3 == null || this.b == null || latLonPoint3.getLatitude() >= this.b.getLatitude() || this.f3439a.getLongitude() >= this.b.getLongitude()) {
                return false;
            }
            return true;
        }

        public LatLonPoint getLowerLeft() {
            return this.f3439a;
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

        public String getCity() {
            return this.g;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f;
        }

        private boolean a(List<LatLonPoint> list, List<LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!list.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            LatLonPoint latLonPoint = this.d;
            int i5 = 0;
            if (latLonPoint == null) {
                i = 0;
            } else {
                i = latLonPoint.hashCode();
            }
            int i6 = (i + 31) * 31;
            LatLonPoint latLonPoint2 = this.f3439a;
            if (latLonPoint2 == null) {
                i2 = 0;
            } else {
                i2 = latLonPoint2.hashCode();
            }
            int i7 = (i6 + i2) * 31;
            LatLonPoint latLonPoint3 = this.b;
            if (latLonPoint3 == null) {
                i3 = 0;
            } else {
                i3 = latLonPoint3.hashCode();
            }
            int i8 = (i7 + i3) * 31;
            List<LatLonPoint> list = this.f;
            if (list == null) {
                i4 = 0;
            } else {
                i4 = list.hashCode();
            }
            int i9 = (((i8 + i4) * 31) + this.c) * 31;
            String str = this.e;
            int hashCode = (i9 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.g;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return hashCode + i5;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    if (!searchBound.d.equals(this.d) || searchBound.c != this.c) {
                        return false;
                    }
                    return true;
                } else if (getShape().equals("Polygon")) {
                    return a(searchBound.f, this.f);
                } else {
                    if (getShape().equals("Local")) {
                        return searchBound.g.equals(this.g);
                    }
                    if (!searchBound.f3439a.equals(this.f3439a) || !searchBound.b.equals(this.b)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        private List<LatLonPoint> a() {
            if (this.f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint next : this.f) {
                arrayList.add(new LatLonPoint(next.getLatitude(), next.getLongitude()));
            }
            return arrayList;
        }

        public SearchBound clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.d, this.c);
            }
            if (getShape().equals("Polygon")) {
                return new SearchBound(a());
            }
            if (getShape().equals("Local")) {
                return new SearchBound(this.g);
            }
            return new SearchBound(this.f3439a, this.b);
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
