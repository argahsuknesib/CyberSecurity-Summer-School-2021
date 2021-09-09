package _m_j;

import com.typesafe.config.ConfigException;
import java.util.Iterator;

public final class dtb {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f14916O000000o;
    public final dtb O00000Oo;

    dtb(String str, dtb dtb) {
        this.f14916O000000o = str;
        this.O00000Oo = dtb;
    }

    dtb(Iterator<dtb> it) {
        if (it.hasNext()) {
            dtb next = it.next();
            this.f14916O000000o = next.f14916O000000o;
            dtc dtc = new dtc();
            dtb dtb = next.O00000Oo;
            if (dtb != null) {
                dtc.O000000o(dtb);
            }
            while (it.hasNext()) {
                dtc.O000000o(it.next());
            }
            this.O00000Oo = dtc.O000000o();
            return;
        }
        throw new ConfigException.BugOrBroken("empty path");
    }

    /* access modifiers changed from: package-private */
    public final dtb O000000o() {
        if (this.O00000Oo == null) {
            return null;
        }
        dtc dtc = new dtc();
        for (dtb dtb = this; dtb.O00000Oo != null; dtb = dtb.O00000Oo) {
            dtc.O000000o(dtb.f14916O000000o);
        }
        return dtc.O000000o();
    }

    /* access modifiers changed from: package-private */
    public final String O00000Oo() {
        dtb dtb = this;
        while (true) {
            dtb dtb2 = dtb.O00000Oo;
            if (dtb2 == null) {
                return dtb.f14916O000000o;
            }
            dtb = dtb2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int O00000o0() {
        int i = 1;
        for (dtb dtb = this.O00000Oo; dtb != null; dtb = dtb.O00000Oo) {
            i++;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dtb) {
            dtb dtb = (dtb) obj;
            if (!this.f14916O000000o.equals(dtb.f14916O000000o) || !dst.O000000o(this.O00000Oo, dtb.O00000Oo)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f14916O000000o.hashCode() + 41) * 41;
        dtb dtb = this.O00000Oo;
        return hashCode + (dtb == null ? 0 : dtb.hashCode());
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e A[LOOP:0: B:1:0x0001->B:22:0x004e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056 A[SYNTHETIC] */
    private void O000000o(StringBuilder sb) {
        dtb dtb = this;
        while (true) {
            String str = dtb.f14916O000000o;
            int length = str.length();
            boolean z = true;
            if (length != 0) {
                if (Character.isLetter(str.charAt(0))) {
                    int i = 1;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        char charAt = str.charAt(i);
                        if (!Character.isLetterOrDigit(charAt) && charAt != '-' && charAt != '_') {
                            break;
                        }
                        i++;
                    }
                }
                if (!z || dtb.f14916O000000o.isEmpty()) {
                    sb.append(dst.O000000o(dtb.f14916O000000o));
                } else {
                    sb.append(dtb.f14916O000000o);
                }
                if (dtb.O00000Oo == null) {
                    sb.append(".");
                    dtb = dtb.O00000Oo;
                } else {
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            sb.append(dst.O000000o(dtb.f14916O000000o));
            if (dtb.O00000Oo == null) {
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Path(");
        O000000o(sb);
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String O00000o() {
        StringBuilder sb = new StringBuilder();
        O000000o(sb);
        return sb.toString();
    }
}
