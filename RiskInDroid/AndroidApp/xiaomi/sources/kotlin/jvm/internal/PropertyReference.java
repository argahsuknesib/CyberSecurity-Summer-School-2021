package kotlin.jvm.internal;

import _m_j.ixe;
import _m_j.ixs;
import _m_j.ixy;

public abstract class PropertyReference extends CallableReference implements ixy {
    /* access modifiers changed from: protected */
    public final ixy O0000Oo0() {
        return (ixy) super.O00000o();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return O00000oO().equals(propertyReference.O00000oO()) && O00000oo().equals(propertyReference.O00000oo()) && O0000O0o().equals(propertyReference.O0000O0o()) && ixe.O000000o(O00000Oo(), propertyReference.O00000Oo());
        } else if (obj instanceof ixy) {
            return obj.equals(O00000o0());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((O00000oO().hashCode() * 31) + O00000oo().hashCode()) * 31) + O0000O0o().hashCode();
    }

    public String toString() {
        ixs O00000o0 = O00000o0();
        if (O00000o0 != this) {
            return O00000o0.toString();
        }
        return "property " + O00000oo() + " (Kotlin reflection is not available)";
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ ixs O00000o() {
        return (ixy) super.O00000o();
    }
}
