package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

public class InputtipsQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f3464a;
    private String b;
    private boolean c = false;
    private String d = null;
    private LatLonPoint e;

    public InputtipsQuery(String str, String str2) {
        this.f3464a = str;
        this.b = str2;
    }

    public String getKeyword() {
        return this.f3464a;
    }

    public String getCity() {
        return this.b;
    }

    public void setType(String str) {
        this.d = str;
    }

    public String getType() {
        return this.d;
    }

    public void setCityLimit(boolean z) {
        this.c = z;
    }

    public boolean getCityLimit() {
        return this.c;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public LatLonPoint getLocation() {
        return this.e;
    }
}
