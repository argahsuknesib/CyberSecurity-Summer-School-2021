package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    private T nextOrNull;

    /* access modifiers changed from: protected */
    public abstract T computeNext(Object obj);

    protected AbstractSequentialIterator(T t) {
        this.nextOrNull = t;
    }

    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                return this.nextOrNull;
            } finally {
                this.nextOrNull = computeNext(this.nextOrNull);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
