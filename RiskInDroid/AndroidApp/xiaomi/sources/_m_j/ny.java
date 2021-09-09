package _m_j;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;

public final class ny {

    /* renamed from: O000000o  reason: collision with root package name */
    public static ILogger f2212O000000o = null;
    private static volatile ny O00000Oo = null;
    private static volatile boolean O00000o0 = false;

    private ny() {
    }

    public static void O000000o(Application application) {
        if (!O00000o0) {
            f2212O000000o = nz.f2213O000000o;
            nz.f2213O000000o.info("ARouter::", "ARouter init start.");
            O00000o0 = nz.O000000o(application);
            nz.O00000o();
            nz.f2213O000000o.info("ARouter::", "ARouter init over.");
        }
    }

    public static ny O000000o() {
        if (O00000o0) {
            if (O00000Oo == null) {
                synchronized (ny.class) {
                    if (O00000Oo == null) {
                        O00000Oo = new ny();
                    }
                }
            }
            return O00000Oo;
        }
        throw new InitException("ARouter::Init::Invoke init(context) first!");
    }

    public static boolean O00000Oo() {
        return nz.O00000o0();
    }

    @Deprecated
    public static boolean O00000o0() {
        return nz.O00000Oo();
    }

    public static void O000000o(Object obj) {
        nz.O000000o(obj);
    }

    public static Postcard O000000o(String str) {
        nz.O000000o();
        return nz.O000000o(str);
    }

    public static <T> T O000000o(Class cls) {
        nz.O000000o();
        return nz.O000000o(cls);
    }

    public static Object O000000o(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        return nz.O000000o().O000000o(context, postcard, i, navigationCallback);
    }
}
