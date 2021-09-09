package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mipay.sdk.IMipayAccountProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

final class cfb {
    static boolean O000000o() {
        try {
            return Class.forName("com.mibi.sdk.account.BuildConfig").getField("ACCOUNT_MODULE_EXIST").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    static IMipayAccountProvider O000000o(Context context) {
        try {
            Object newInstance = Class.forName("com.mibi.sdk.account.AccountProviderImpl").getConstructor(Context.class).newInstance(context);
            return (IMipayAccountProvider) Proxy.newProxyInstance(IMipayAccountProvider.class.getClassLoader(), new Class[]{IMipayAccountProvider.class}, new O000000o(newInstance, (byte) 0));
        } catch (Exception e) {
            Log.d("AccountUtil", "no account module", e);
            return null;
        }
    }

    static class O000000o implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private Object f13707O000000o;

        /* synthetic */ O000000o(Object obj, byte b) {
            this(obj);
        }

        private O000000o(Object obj) {
            this.f13707O000000o = obj;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Method method2;
            String name = method.getName();
            Log.d("AccountUtil", "call:".concat(String.valueOf(name)));
            boolean z = false;
            if (objArr != null) {
                method2 = this.f13707O000000o.getClass().getMethod(name, method.getParameterTypes());
            } else {
                method2 = this.f13707O000000o.getClass().getMethod(name, new Class[0]);
            }
            Object invoke = method2.invoke(this.f13707O000000o, objArr);
            if (!TextUtils.equals(name, "isUseSystem")) {
                return invoke;
            }
            if (cfb.O000000o() && ((Boolean) invoke).booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }
}
