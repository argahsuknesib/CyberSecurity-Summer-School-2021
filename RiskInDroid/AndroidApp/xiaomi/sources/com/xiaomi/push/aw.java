package com.xiaomi.push;

import _m_j.duv;
import _m_j.elv;
import _m_j.esu;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class aw implements elv, InvocationHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[][] f6363O000000o = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
    private Class O00000Oo = null;
    private Method O00000o = null;
    private Class O00000o0 = null;
    private Method O00000oO = null;
    private Method O00000oo = null;
    private Method O0000O0o = null;
    private Method O0000OOo = null;
    private Method O0000Oo = null;
    private Method O0000Oo0 = null;
    private Context O0000OoO;
    private final Object O0000Ooo = new Object();
    private volatile long O0000o0 = 0;
    private volatile int O0000o00 = 0;
    private volatile O000000o O0000o0O = null;

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Boolean f6364O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        String O00000oO;

        private O000000o() {
            this.f6364O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
        }

        /* synthetic */ O000000o(aw awVar, byte b) {
            this();
        }
    }

    public aw(Context context) {
        this.O0000OoO = context.getApplicationContext();
        O000000o(context);
        O00000Oo(context);
    }

    private static Class<?> O000000o(Context context, String str) {
        try {
            return esu.O000000o(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T O000000o(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method O000000o(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void O000000o(Context context) {
        Class<?> O000000o2 = O000000o(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = f6363O000000o;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> O000000o3 = O000000o(context, strArr2[0]);
            Class<?> O000000o4 = O000000o(context, strArr2[1]);
            if (O000000o3 != null && O000000o4 != null) {
                O00000Oo("found class in index ".concat(String.valueOf(i)));
                Class<?> cls3 = O000000o3;
                cls2 = O000000o4;
                cls = cls3;
                break;
            }
            i++;
            Class<?> cls4 = O000000o3;
            cls2 = O000000o4;
            cls = cls4;
        }
        this.O00000Oo = O000000o2;
        this.O00000o = O000000o(O000000o2, "InitSdk", Context.class, cls);
        this.O00000o0 = cls;
        this.O00000oO = O000000o(cls2, "getUDID", new Class[0]);
        this.O00000oo = O000000o(cls2, "getOAID", new Class[0]);
        this.O0000O0o = O000000o(cls2, "getVAID", new Class[0]);
        this.O0000OOo = O000000o(cls2, "getAAID", new Class[0]);
        this.O0000Oo0 = O000000o(cls2, "isSupported", new Class[0]);
        this.O0000Oo = O000000o(cls2, "shutDown", new Class[0]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|31|(2:33|34)|35|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0088 */
    private void O000000o(String str) {
        if (this.O0000o0O == null) {
            long j = this.O0000o0;
            long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
            int i = this.O0000o00;
            if (elapsedRealtime > 3000 && i < 3) {
                synchronized (this.O0000Ooo) {
                    if (this.O0000o0 == j && this.O0000o00 == i) {
                        O00000Oo("retry, current count is ".concat(String.valueOf(i)));
                        this.O0000o00++;
                        O00000Oo(this.O0000OoO);
                        j = this.O0000o0;
                        elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                    }
                }
            }
            if (this.O0000o0O == null && j >= 0 && elapsedRealtime <= 3000 && Looper.myLooper() != Looper.getMainLooper()) {
                synchronized (this.O0000Ooo) {
                    if (this.O0000o0O == null) {
                        O00000Oo(str + " wait...");
                        this.O0000Ooo.wait(3000);
                    }
                }
            }
        }
    }

    private void O00000Oo(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.O00000o0;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                Object newProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{this.O00000o0}, this);
                O000000o(this.O00000o, this.O00000Oo.newInstance(), context, newProxyInstance);
            } catch (Throwable th) {
                O00000Oo("call init sdk error:".concat(String.valueOf(th)));
            }
            this.O0000o0 = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.O0000o0 = elapsedRealtime;
    }

    private static void O00000Oo(String str) {
        duv.O000000o("mdid:".concat(String.valueOf(str)));
    }

    public final boolean O000000o() {
        O000000o("isSupported");
        return this.O0000o0O != null && Boolean.TRUE.equals(this.O0000o0O.f6364O000000o);
    }

    public final String O00000Oo() {
        O000000o("getUDID");
        if (this.O0000o0O == null) {
            return null;
        }
        return this.O0000o0O.O00000Oo;
    }

    public final String O00000o() {
        O000000o("getVAID");
        if (this.O0000o0O == null) {
            return null;
        }
        return this.O0000o0O.O00000o;
    }

    public final String O00000o0() {
        O000000o("getOAID");
        if (this.O0000o0O == null) {
            return null;
        }
        return this.O0000o0O.O00000o0;
    }

    public final String O00000oO() {
        O000000o("getAAID");
        if (this.O0000o0O == null) {
            return null;
        }
        return this.O0000o0O.O00000oO;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00e0 */
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.O0000o0 = SystemClock.elapsedRealtime();
        if (objArr != null) {
            boolean z = false;
            O000000o o000000o = new O000000o(this, (byte) 0);
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null) {
                    if (!((obj2 instanceof Boolean) || (obj2 instanceof Character) || (obj2 instanceof Byte) || (obj2 instanceof Short) || (obj2 instanceof Integer) || (obj2 instanceof Long) || (obj2 instanceof Float) || (obj2 instanceof Double))) {
                        o000000o.O00000Oo = (String) O000000o(this.O00000oO, obj2, new Object[0]);
                        o000000o.O00000o0 = (String) O000000o(this.O00000oo, obj2, new Object[0]);
                        o000000o.O00000o = (String) O000000o(this.O0000O0o, obj2, new Object[0]);
                        o000000o.O00000oO = (String) O000000o(this.O0000OOo, obj2, new Object[0]);
                        o000000o.f6364O000000o = (Boolean) O000000o(this.O0000Oo0, obj2, new Object[0]);
                        O000000o(this.O0000Oo, obj2, new Object[0]);
                        if (!TextUtils.isEmpty(o000000o.O00000Oo) || !TextUtils.isEmpty(o000000o.O00000o0) || !TextUtils.isEmpty(o000000o.O00000o) || !TextUtils.isEmpty(o000000o.O00000oO)) {
                            o000000o.f6364O000000o = Boolean.TRUE;
                        }
                        if (o000000o.f6364O000000o != null) {
                            StringBuilder sb = new StringBuilder("has get succ, check duplicate:");
                            if (this.O0000o0O != null) {
                                z = true;
                            }
                            sb.append(z);
                            O00000Oo(sb.toString());
                            synchronized (aw.class) {
                                if (this.O0000o0O == null) {
                                    this.O0000o0O = o000000o;
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            }
        }
        synchronized (this.O0000Ooo) {
            this.O0000Ooo.notifyAll();
        }
        return null;
    }
}
