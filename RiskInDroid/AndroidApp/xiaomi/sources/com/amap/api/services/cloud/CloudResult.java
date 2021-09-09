package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

public final class CloudResult {

    /* renamed from: a  reason: collision with root package name */
    private int f3436a = a(this.c);
    private ArrayList<CloudItem> b;
    private int c;
    private int d;
    private CloudSearch.Query e;
    private CloudSearch.SearchBound f;

    public static CloudResult createPagedResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i, searchBound, i2, arrayList);
    }

    private CloudResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        this.e = query;
        this.c = i;
        this.d = i2;
        this.b = arrayList;
        this.f = searchBound;
    }

    public final int getPageCount() {
        return this.f3436a;
    }

    public final CloudSearch.Query getQuery() {
        return this.e;
    }

    public final CloudSearch.SearchBound getBound() {
        return this.f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.b;
    }

    public final int getTotalCount() {
        return this.c;
    }

    private int a(int i) {
        int i2 = this.d;
        return ((i + i2) - 1) / i2;
    }
}
