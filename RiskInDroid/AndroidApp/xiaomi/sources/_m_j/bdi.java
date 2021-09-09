package _m_j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class bdi<T> {
    public static final Type LIST_STRING = new bdi<List<String>>() {
        /* class _m_j.bdi.AnonymousClass1 */
    }.getType();
    private final Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected bdi() {
    }

    public Type getType() {
        return this.type;
    }
}
