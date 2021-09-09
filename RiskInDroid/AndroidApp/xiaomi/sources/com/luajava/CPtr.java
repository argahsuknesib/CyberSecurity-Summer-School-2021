package com.luajava;

public class CPtr {
    private long peer;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return CPtr.class == obj.getClass() && this.peer == ((CPtr) obj).peer;
    }

    /* access modifiers changed from: protected */
    public long getPeer() {
        return this.peer;
    }

    CPtr() {
    }
}
