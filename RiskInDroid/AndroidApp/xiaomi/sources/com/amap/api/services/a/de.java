package com.amap.api.services.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Proxy;

public class de extends db {
    private static de c;
    private ee d;
    private Handler e;

    public static de a(boolean z) {
        return a(z, 5);
    }

    private static synchronized de a(boolean z, int i) {
        de deVar;
        synchronized (de.class) {
            try {
                if (c == null) {
                    c = new de(z, i);
                } else if (z && c.d == null) {
                    c.d = ee.a(i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            deVar = c;
        }
        return deVar;
    }

    private de(boolean z, int i) {
        if (z) {
            try {
                this.d = ee.a(i);
            } catch (Throwable th) {
                cl.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), null);
        } else {
            this.e = new a();
        }
    }

    /* renamed from: com.amap.api.services.a.de$1  reason: invalid class name */
    class AnonymousClass1 extends ef {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ df f3398a;
        final /* synthetic */ dg b;
        final /* synthetic */ de c;

        public void a() {
            try {
                this.c.a(this.c.b(this.f3398a, false), this.b);
            } catch (bo e) {
                this.c.a(e, this.b);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.db.a(com.amap.api.services.a.df, boolean):com.amap.api.services.a.dh
     arg types: [com.amap.api.services.a.df, int]
     candidates:
      com.amap.api.services.a.de.a(boolean, int):com.amap.api.services.a.de
      com.amap.api.services.a.de.a(com.amap.api.services.a.bo, com.amap.api.services.a.dg):void
      com.amap.api.services.a.de.a(com.amap.api.services.a.dh, com.amap.api.services.a.dg):void
      com.amap.api.services.a.db.a(com.amap.api.services.a.df, boolean):com.amap.api.services.a.dh */
    public byte[] b(df dfVar) throws bo {
        try {
            dh a2 = a(dfVar, false);
            if (a2 != null) {
                return a2.f3399a;
            }
            return null;
        } catch (bo e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            cl.d().b(th, "NetManager", "makeSyncPostRequest");
            throw new bo("未知的错误");
        }
    }

    public byte[] d(df dfVar) throws bo {
        try {
            dh b = b(dfVar, false);
            if (b != null) {
                return b.f3399a;
            }
            return null;
        } catch (bo e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new bo("未知的错误");
        }
    }

    public byte[] e(df dfVar) throws bo {
        try {
            dh b = b(dfVar, true);
            if (b != null) {
                return b.f3399a;
            }
            return null;
        } catch (bo e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new bo("未知的错误");
        }
    }

    public dh b(df dfVar, boolean z) throws bo {
        Proxy proxy;
        try {
            c(dfVar);
            if (dfVar.h == null) {
                proxy = null;
            } else {
                proxy = dfVar.h;
            }
            return new dd(dfVar.f, dfVar.g, proxy, z).a(dfVar.i(), dfVar.o(), dfVar.n(), dfVar.e(), dfVar.d(), dfVar.p());
        } catch (bo e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bo("未知的错误");
        }
    }

    /* access modifiers changed from: private */
    public void a(bo boVar, dg dgVar) {
        di diVar = new di();
        diVar.f3400a = boVar;
        diVar.b = dgVar;
        Message obtain = Message.obtain();
        obtain.obj = diVar;
        obtain.what = 1;
        this.e.sendMessage(obtain);
    }

    /* access modifiers changed from: private */
    public void a(dh dhVar, dg dgVar) {
        dgVar.a(dhVar.b, dhVar.f3399a);
        di diVar = new di();
        diVar.b = dgVar;
        Message obtain = Message.obtain();
        obtain.obj = diVar;
        obtain.what = 0;
        this.e.sendMessage(obtain);
    }

    static class a extends Handler {
        /* synthetic */ a(Looper looper, AnonymousClass1 r2) {
            this(looper);
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }

        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    ((di) message.obj).b.a();
                } else if (i == 1) {
                    di diVar = (di) message.obj;
                    diVar.b.a(diVar.f3400a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
