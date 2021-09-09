package _m_j;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ftw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f17128O000000o = {"0d9805094a28781efa59445967e590841a04066ba", "000ce04dfe5a94ac1280083c1f520dcde1e2a011f", "0f0ce41dfb5e98ac2480013c11020bc1e8e421fd0", "0d980a59402b741e00594a5966259b83108f7e46d", "0b980a59402b741e00594a5966559b84108f7e46d", "01980a59402b741e00594a5966c59b88108fae46d", "06980a59402b741e00594a5966e59b8b108fce46d", "060ce04dfe5b94ac8280023c1f020dc3e1e27011f", "0d9805094b28701ef959405966e59e841304066ba", "0af465f08ba2c7effc250827fc4ba6d76a340264c", "0af465f08ba2c7effc250a27fd4ba3d76a340264c", "040ce04dfe5a94ac82800b3c1f520dcbe1e22011f", "0a980a59402d741e20594f5966559b82108ffe46d", "0d9805094d28721eff59475963e59d841c04066ba", "0f0ce41dfa5e98ac2b800a3c1b0207c1ede421fd0", "0af465f088a2c2effb250527f74ba9d76a340264c", "03f46c5083a8c4ef20250b27f67ba4d16f2ff472a", "060ce04dfe5a94ac82800a3c1f020dc2e1e2f011f", "0f0ce41dfa5e98ac2a80023c120202c1e4e421fd0", "0f0ce41dfa5e98ac2a80043c110207c1ece421fd0", "040ce04dfe5a94ac82800a3c1f620dc0e1e29011f", "0af465f088a2c2effb250927f24ba0d76e340264c", "0ff46c5083a8c4ef20250b27f6bba4d36f2fd472a", "0f0ce41dfa5e98ac2a800c3c1b020ec1e5e421fd0", "07980a59402a741e80594a5966959b89108f5e46d", "04980a59402a741e80594a5966c59b85108ffe46d", "0d9805094a28781ef459485962e598841d04066ba", "080ce04dfe5a94acb280033c1f520dcae1e2a011f", "0f0ce41dfa5e9fac2d80023c100204c1e2e421fd0", "02980a59402b741ea0594c5966859b8e108f7e46d"};
    private static Object O00000Oo = new Object();
    private static volatile ftw O00000o0;
    private Class O00000o;
    private Class O00000oO;
    private Object O00000oo;

    public static ftw O000000o() {
        if (O00000o0 == null) {
            synchronized (O00000Oo) {
                if (O00000o0 == null) {
                    O00000o0 = new ftw();
                }
            }
        }
        if (O00000o0.O00000oo == null) {
            return null;
        }
        return O00000o0;
    }

    private ftw() {
        Class<?> cls;
        Class<?> cls2;
        Method method;
        try {
            this.O00000o = Class.forName("miui.vip.VipService");
            if (!(this.O00000o == null || (method = this.O00000o.getMethod("instance", new Class[0])) == null)) {
                this.O00000oo = method.invoke(null, new Object[0]);
            }
            if (this.O00000oo != null) {
                this.O00000oO = Class.forName("miui.vip.QueryCallback");
                if (!(this.O00000oO == null || (cls = Class.forName("miui.vip.VipAchievement")) == null || cls.getField("url") == null || cls.getField("isOwned") == null || (cls2 = Class.forName("miui.vip.VipUserInfo")) == null || cls2.getField("level") == null)) {
                    return;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
        }
        this.O00000oo = null;
    }

    public final boolean O000000o(Context context) {
        Class cls = this.O00000o;
        if (cls == null) {
            return false;
        }
        try {
            Method method = cls.getMethod("startVipActivity", Context.class, String.class);
            if (method != null) {
                method.invoke(null, context, "com.xiaomi.vip.action.VIP_LEVEL_LIST");
                return true;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return false;
    }

    public final boolean O00000Oo(Context context) {
        Class cls = this.O00000o;
        if (cls == null) {
            return false;
        }
        try {
            Method method = cls.getMethod("startVipActivity", Context.class, String.class);
            if (method != null) {
                method.invoke(null, context, "com.xiaomi.vip.action.VIP_ACHIEVEMENT_LIST");
                return true;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return false;
    }
}
