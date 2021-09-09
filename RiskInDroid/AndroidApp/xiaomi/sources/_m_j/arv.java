package _m_j;

import java.util.Collection;

public abstract class arv<T extends Collection<?>> extends asb<T> {
    public final /* synthetic */ boolean O000000o(Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.size() == 0;
    }

    protected arv(Class<?> cls) {
        super(cls, (byte) 0);
    }
}
