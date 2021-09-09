package com.amap.api.services.a;

import java.util.Map;

public class da extends df {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3392a;
    private Map<String, String> b;

    public Map<String, String> e() {
        return null;
    }

    public String i() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    public da(byte[] bArr, Map<String, String> map) {
        this.f3392a = bArr;
        this.b = map;
    }

    public Map<String, String> d() {
        return this.b;
    }

    public byte[] h() {
        return this.f3392a;
    }
}
