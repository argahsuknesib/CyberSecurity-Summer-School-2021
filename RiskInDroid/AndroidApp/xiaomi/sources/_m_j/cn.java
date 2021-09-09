package _m_j;

import android.view.accessibility.AccessibilityRecord;

public final class cn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final AccessibilityRecord f14132O000000o;

    @Deprecated
    public cn(Object obj) {
        this.f14132O000000o = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static cn O000000o() {
        return new cn(AccessibilityRecord.obtain());
    }

    @Deprecated
    public final void O000000o(boolean z) {
        this.f14132O000000o.setScrollable(z);
    }

    @Deprecated
    public final void O000000o(int i) {
        this.f14132O000000o.setItemCount(i);
    }

    @Deprecated
    public final void O00000Oo(int i) {
        this.f14132O000000o.setFromIndex(i);
    }

    @Deprecated
    public final void O00000o0(int i) {
        this.f14132O000000o.setToIndex(i);
    }

    @Deprecated
    public final int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f14132O000000o;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cn)) {
            return false;
        }
        cn cnVar = (cn) obj;
        AccessibilityRecord accessibilityRecord = this.f14132O000000o;
        if (accessibilityRecord == null) {
            if (cnVar.f14132O000000o != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(cnVar.f14132O000000o)) {
            return false;
        }
        return true;
    }
}
