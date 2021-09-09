package _m_j;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public final class fn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final O00000Oo f16681O000000o;
    private final fp O00000Oo;

    public interface O00000Oo {
        <T extends fm> T O000000o(Class<T> cls);
    }

    static abstract class O00000o0 implements O00000Oo {
        public abstract <T extends fm> T O000000o();

        O00000o0() {
        }
    }

    public fn(fp fpVar, O00000Oo o00000Oo) {
        this.f16681O000000o = o00000Oo;
        this.O00000Oo = fpVar;
    }

    public final <T extends fm> T O000000o(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return O000000o("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(canonicalName)), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    private <T extends fm> T O000000o(String str, Class<T> cls) {
        T t;
        T O000000o2 = this.O00000Oo.O000000o(str);
        if (cls.isInstance(O000000o2)) {
            return O000000o2;
        }
        O00000Oo o00000Oo = this.f16681O000000o;
        if (o00000Oo instanceof O00000o0) {
            t = ((O00000o0) o00000Oo).O000000o();
        } else {
            t = o00000Oo.O000000o(cls);
        }
        this.O00000Oo.O000000o(str, t);
        return t;
    }

    public static class O00000o implements O00000Oo {
        public <T extends fm> T O000000o(Class<T> cls) {
            try {
                return (fm) cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            }
        }
    }

    public static class O000000o extends O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static O000000o f16682O000000o;
        private Application O00000Oo;

        public O000000o(Application application) {
            this.O00000Oo = application;
        }

        public final <T extends fm> T O000000o(Class<T> cls) {
            if (!er.class.isAssignableFrom(cls)) {
                return super.O000000o(cls);
            }
            try {
                return (fm) cls.getConstructor(Application.class).newInstance(this.O00000Oo);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
            }
        }
    }
}
