package _m_j;

import com.google.android.exoplayer2.C;

final class ifn extends ifr {
    /* access modifiers changed from: protected */
    public final int O000000o(int i) {
        return i < 10000 ? i : i - C.MSG_CUSTOM_BASE;
    }

    ifn(idl idl) {
        super(idl);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
