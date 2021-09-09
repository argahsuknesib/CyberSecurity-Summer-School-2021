package _m_j;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;

public abstract class jgn implements jgp {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Class f1827O000000o;
    private final Class<? extends jgp> O00000Oo = null;
    private final boolean O00000o0 = true;

    protected jgn(Class cls, boolean z) {
        this.f1827O000000o = cls;
    }

    public final Class O000000o() {
        return this.f1827O000000o;
    }

    public final jgp O00000Oo() {
        Class<? extends jgp> cls = this.O00000Oo;
        if (cls == null) {
            return null;
        }
        try {
            return (jgp) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final jgk O000000o(String str, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        try {
            return new jgk(this.f1827O000000o.getDeclaredMethod(str, cls), cls, threadMode, i, z);
        } catch (NoSuchMethodException e) {
            throw new EventBusException("Could not find subscriber method in " + this.f1827O000000o + ". Maybe a missing ProGuard rule?", e);
        }
    }
}
