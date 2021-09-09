package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Iterator;

@DoNotStrip
public class IteratorHelper {
    @DoNotStrip
    private Object mElement;
    private final Iterator mIterator;

    @DoNotStrip
    public IteratorHelper(Iterator it) {
        this.mIterator = it;
    }

    @DoNotStrip
    public IteratorHelper(Iterable iterable) {
        this.mIterator = iterable.iterator();
    }

    /* access modifiers changed from: package-private */
    @DoNotStrip
    public boolean hasNext() {
        if (this.mIterator.hasNext()) {
            this.mElement = this.mIterator.next();
            return true;
        }
        this.mElement = null;
        return false;
    }
}
