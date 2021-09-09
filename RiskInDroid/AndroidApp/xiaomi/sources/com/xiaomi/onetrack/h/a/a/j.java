package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import com.xiaomi.onetrack.h.q;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<a> f6152a = new LinkedBlockingQueue<>(1);

    public String a(Context context) {
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            Class<?> cls2 = Class.forName("com.bun.supplier.IIdentifierListener");
            b bVar = new b();
            Object newProxyInstance = Proxy.newProxyInstance(context.getClassLoader(), new Class[]{cls2}, bVar);
            cls.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, cls2).invoke(cls, context, Boolean.TRUE, newProxyInstance);
            a poll = this.f6152a.poll(1, TimeUnit.SECONDS);
            if (poll != null) {
                return poll.c[1].getClass().getMethod("getOAID", new Class[0]).invoke(poll.c[1], new Object[0]).toString();
            }
            return "";
        } catch (Exception e) {
            q.a("MsaSDKHelper", e.getMessage());
            return "";
        }
    }

    public class b implements InvocationHandler {
        public b() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                j.this.f6152a.offer(new a(obj, method, objArr), 1, TimeUnit.SECONDS);
                return null;
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                    return null;
                } catch (Exception e2) {
                    q.a("MsaSDKHelper", e2.getMessage());
                    return null;
                }
            }
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        Object f6153a;
        Method b;
        Object[] c;

        public a(Object obj, Method method, Object[] objArr) {
            this.f6153a = obj;
            this.b = method;
            this.c = objArr;
        }
    }
}
