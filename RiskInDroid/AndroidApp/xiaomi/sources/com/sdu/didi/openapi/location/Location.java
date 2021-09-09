package com.sdu.didi.openapi.location;

import android.text.TextUtils;

public class Location {
    private String lat = "";
    private String lng = "";
    private String mapType = "";

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getMapType() {
        return this.mapType;
    }

    public boolean isAvail() {
        return !TextUtils.isEmpty(this.lat) && !TextUtils.isEmpty(this.lng) && !TextUtils.isEmpty(this.mapType);
    }

    public void reset() {
        this.lat = "";
        this.lng = "";
        this.mapType = "";
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setMapType(String str) {
        this.mapType = str;
    }

    public String toString() {
        return "Location{lat='" + this.lat + '\'' + ", lng='" + this.lng + '\'' + ", mapType='" + this.mapType + '\'' + '}';
    }
}
