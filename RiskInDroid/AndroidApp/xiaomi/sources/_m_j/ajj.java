package _m_j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class ajj<T> implements Comparable<ajj<T>> {
    protected final Type _type;

    public int compareTo(ajj<T> ajj) {
        return 0;
    }

    protected ajj() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            this._type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            return;
        }
        throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
    }

    public Type getType() {
        return this._type;
    }
}
