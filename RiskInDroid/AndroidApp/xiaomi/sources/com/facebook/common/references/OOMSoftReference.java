package com.facebook.common.references;

import java.lang.ref.SoftReference;

public class OOMSoftReference<T> {
    SoftReference<T> softRef1 = null;
    SoftReference<T> softRef2 = null;
    SoftReference<T> softRef3 = null;

    public void set(T t) {
        this.softRef1 = new SoftReference<>(t);
        this.softRef2 = new SoftReference<>(t);
        this.softRef3 = new SoftReference<>(t);
    }

    public T get() {
        SoftReference<T> softReference = this.softRef1;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void clear() {
        SoftReference<T> softReference = this.softRef1;
        if (softReference != null) {
            softReference.clear();
            this.softRef1 = null;
        }
        SoftReference<T> softReference2 = this.softRef2;
        if (softReference2 != null) {
            softReference2.clear();
            this.softRef2 = null;
        }
        SoftReference<T> softReference3 = this.softRef3;
        if (softReference3 != null) {
            softReference3.clear();
            this.softRef3 = null;
        }
    }
}
