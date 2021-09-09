package _m_j;

import android.text.TextUtils;

final class ebm {

    /* renamed from: O000000o  reason: collision with root package name */
    int f15150O000000o = 0;
    String O00000Oo = "";

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ebm)) {
            return false;
        }
        ebm ebm = (ebm) obj;
        return !TextUtils.isEmpty(ebm.O00000Oo) && ebm.O00000Oo.equals(this.O00000Oo);
    }
}
