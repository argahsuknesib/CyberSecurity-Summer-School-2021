package com.amap.api.services.geocoder;

public class GeocodeQuery {

    /* renamed from: a  reason: collision with root package name */
    private String f3455a;
    private String b;

    public GeocodeQuery(String str, String str2) {
        this.f3455a = str;
        this.b = str2;
    }

    public String getLocationName() {
        return this.f3455a;
    }

    public void setLocationName(String str) {
        this.f3455a = str;
    }

    public String getCity() {
        return this.b;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f3455a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        String str = this.b;
        if (str == null) {
            if (geocodeQuery.b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.b)) {
            return false;
        }
        String str2 = this.f3455a;
        if (str2 == null) {
            if (geocodeQuery.f3455a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.f3455a)) {
            return false;
        }
        return true;
    }
}
