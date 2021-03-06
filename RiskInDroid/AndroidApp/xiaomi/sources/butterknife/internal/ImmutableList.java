package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {
    private final T[] views;

    ImmutableList(T[] tArr) {
        this.views = tArr;
    }

    public final T get(int i) {
        return this.views[i];
    }

    public final int size() {
        return this.views.length;
    }

    public final boolean contains(Object obj) {
        for (T t : this.views) {
            if (t == obj) {
                return true;
            }
        }
        return false;
    }
}
