package com.miui.tsmclient.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class a {
    @SerializedName("couponTitle")

    /* renamed from: a  reason: collision with root package name */
    private String f3858a;
    @SerializedName("expireToast")
    private String b;
    @SerializedName("discountFee")
    private String c;
    @SerializedName("discountDesc")
    private String d;
    @SerializedName("highLight")
    private boolean e;

    public static a a(String str) {
        return (a) new Gson().fromJson(str, a.class);
    }

    public String a() {
        return this.f3858a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}
