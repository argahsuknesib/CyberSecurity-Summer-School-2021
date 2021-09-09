package com.amap.api.services.a;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class db {

    /* renamed from: a  reason: collision with root package name */
    public static int f3393a = 0;
    public static String b = "";
    private static db c;

    public interface a {
        URLConnection a(Proxy proxy, URL url);
    }

    public static db a() {
        if (c == null) {
            c = new db();
        }
        return c;
    }

    public byte[] a(df dfVar) throws bo {
        try {
            dh a2 = a(dfVar, true);
            if (a2 != null) {
                return a2.f3399a;
            }
            return null;
        } catch (bo e) {
            throw e;
        } catch (Throwable unused) {
            throw new bo("未知的错误");
        }
    }

    public byte[] b(df dfVar) throws bo {
        try {
            dh a2 = a(dfVar, false);
            if (a2 != null) {
                return a2.f3399a;
            }
            return null;
        } catch (bo e) {
            throw e;
        } catch (Throwable th) {
            ci.a(th, "bm", "msp");
            throw new bo("未知的错误");
        }
    }

    /* access modifiers changed from: protected */
    public void c(df dfVar) throws bo {
        if (dfVar == null) {
            throw new bo("requeust is null");
        } else if (dfVar.i() == null || "".equals(dfVar.i())) {
            throw new bo("request url is empty");
        }
    }

    public dh a(df dfVar, boolean z) throws bo {
        Proxy proxy;
        try {
            c(dfVar);
            if (dfVar.h == null) {
                proxy = null;
            } else {
                proxy = dfVar.h;
            }
            return new dd(dfVar.f, dfVar.g, proxy, z).a(dfVar.m(), dfVar.o(), dfVar.n(), dfVar.e(), dfVar.q(), dfVar.p());
        } catch (bo e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bo("未知的错误");
        }
    }
}
