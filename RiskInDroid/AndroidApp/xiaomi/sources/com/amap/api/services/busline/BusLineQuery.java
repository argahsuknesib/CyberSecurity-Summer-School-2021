package com.amap.api.services.busline;

public class BusLineQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f3426a;
    private String b;
    private int c = 20;
    private int d = 1;
    private SearchType e;

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f3426a = str;
        this.e = searchType;
        this.b = str2;
    }

    public SearchType getCategory() {
        return this.e;
    }

    public String getQueryString() {
        return this.f3426a;
    }

    public void setQueryString(String str) {
        this.f3426a = str;
    }

    public String getCity() {
        return this.b;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public int getPageSize() {
        return this.c;
    }

    public void setPageSize(int i) {
        this.c = i;
    }

    public int getPageNumber() {
        return this.d;
    }

    public void setPageNumber(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.d = i;
    }

    public void setCategory(SearchType searchType) {
        this.e = searchType;
    }

    public BusLineQuery clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f3426a, this.e, this.b);
        busLineQuery.setPageNumber(this.d);
        busLineQuery.setPageSize(this.c);
        return busLineQuery;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f3426a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f3426a)) {
            return false;
        }
        if (this.b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.b)) {
            return false;
        }
        return this.c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.e) == 0;
    }

    public int hashCode() {
        int i;
        SearchType searchType = this.e;
        int i2 = 0;
        if (searchType == null) {
            i = 0;
        } else {
            i = searchType.hashCode();
        }
        int i3 = (i + 31) * 31;
        String str = this.b;
        int hashCode = (((((i3 + (str == null ? 0 : str.hashCode())) * 31) + this.d) * 31) + this.c) * 31;
        String str2 = this.f3426a;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.e != busLineQuery.e) {
            return false;
        }
        String str = this.b;
        if (str == null) {
            if (busLineQuery.b != null) {
                return false;
            }
        } else if (!str.equals(busLineQuery.b)) {
            return false;
        }
        if (this.d != busLineQuery.d || this.c != busLineQuery.c) {
            return false;
        }
        String str2 = this.f3426a;
        if (str2 == null) {
            if (busLineQuery.f3426a != null) {
                return false;
            }
        } else if (!str2.equals(busLineQuery.f3426a)) {
            return false;
        }
        return true;
    }
}
