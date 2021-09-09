package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ben {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final bid f12908O000000o;
    protected final Class<?> O00000Oo;

    public int O000000o() {
        return 0;
    }

    public abstract void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map);

    public ben(Class<?> cls, bid bid) {
        this.O00000Oo = cls;
        this.f12908O000000o = bid;
    }

    public final Method O00000Oo() {
        return this.f12908O000000o.O00000Oo;
    }

    public final Field O00000o0() {
        return this.f12908O000000o.O00000o0;
    }

    public final Class<?> O00000o() {
        return this.f12908O000000o.O00000o;
    }

    public final Type O00000oO() {
        return this.f12908O000000o.O00000oO;
    }

    public final void O000000o(Object obj, boolean z) {
        O000000o(obj, Boolean.valueOf(z));
    }

    public void O000000o(Object obj, Object obj2) {
        Method method = this.f12908O000000o.O00000Oo;
        if (method != null) {
            try {
                if (!this.f12908O000000o.O00000oo) {
                    method.invoke(obj, obj2);
                } else if (this.f12908O000000o.O00000o == AtomicInteger.class) {
                    AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, new Object[0]);
                    if (atomicInteger != null) {
                        atomicInteger.set(((AtomicInteger) obj2).get());
                    }
                } else if (this.f12908O000000o.O00000o == AtomicLong.class) {
                    AtomicLong atomicLong = (AtomicLong) method.invoke(obj, new Object[0]);
                    if (atomicLong != null) {
                        atomicLong.set(((AtomicLong) obj2).get());
                    }
                } else if (this.f12908O000000o.O00000o == AtomicBoolean.class) {
                    AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, new Object[0]);
                    if (atomicBoolean != null) {
                        atomicBoolean.set(((AtomicBoolean) obj2).get());
                    }
                } else if (Map.class.isAssignableFrom(method.getReturnType())) {
                    Map map = (Map) method.invoke(obj, new Object[0]);
                    if (map != null) {
                        map.putAll((Map) obj2);
                    }
                } else {
                    Collection collection = (Collection) method.invoke(obj, new Object[0]);
                    if (collection != null) {
                        collection.addAll((Collection) obj2);
                    }
                }
            } catch (Exception e) {
                throw new JSONException("set property error, " + this.f12908O000000o.f12989O000000o, e);
            }
        } else {
            Field field = this.f12908O000000o.O00000o0;
            if (field != null) {
                try {
                    field.set(obj, obj2);
                } catch (Exception e2) {
                    throw new JSONException("set property error, " + this.f12908O000000o.f12989O000000o, e2);
                }
            }
        }
    }
}
