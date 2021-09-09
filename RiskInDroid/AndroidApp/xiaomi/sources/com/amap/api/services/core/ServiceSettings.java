package com.amap.api.services.core;

import com.amap.api.services.a.as;
import com.amap.api.services.a.br;
import com.amap.api.services.a.bv;
import com.amap.api.services.a.s;

public class ServiceSettings {
    private static ServiceSettings c;

    /* renamed from: a  reason: collision with root package name */
    private String f3445a = "zh-CN";
    private int b = 1;
    private int d = 20000;
    private int e = 20000;

    public int getConnectionTimeOut() {
        return this.d;
    }

    public int getSoTimeOut() {
        return this.e;
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.d = 5000;
        } else if (i > 30000) {
            this.d = 30000;
        } else {
            this.d = i;
        }
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.e = 5000;
        } else if (i > 30000) {
            this.e = 30000;
        } else {
            this.e = i;
        }
    }

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (c == null) {
            c = new ServiceSettings();
        }
        return c;
    }

    public void setLanguage(String str) {
        if ("en".equals(str) || "zh-CN".equals(str)) {
            this.f3445a = str;
        }
    }

    public void setProtocol(int i) {
        this.b = i;
        bv.a().a(this.b == 2);
    }

    public String getLanguage() {
        return this.f3445a;
    }

    public int getProtocol() {
        return this.b;
    }

    public void setApiKey(String str) {
        br.a(str);
    }

    public void destroyInnerAsynThreadPool() {
        try {
            as.b();
        } catch (Throwable th) {
            s.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }
}
