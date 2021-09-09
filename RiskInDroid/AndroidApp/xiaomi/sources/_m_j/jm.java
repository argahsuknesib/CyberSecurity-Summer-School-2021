package _m_j;

import android.view.View;
import android.view.WindowId;

final class jm implements jn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final WindowId f1950O000000o;

    jm(View view) {
        this.f1950O000000o = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof jm) && ((jm) obj).f1950O000000o.equals(this.f1950O000000o);
    }

    public final int hashCode() {
        return this.f1950O000000o.hashCode();
    }
}
