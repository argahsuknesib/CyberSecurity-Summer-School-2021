package _m_j;

import android.text.TextUtils;
import android.util.Log;

public final class dnu extends dnh {
    public final int O000000o(Object obj) {
        super.O000000o(obj);
        int O00000Oo = this.O0000Oo.O00000Oo();
        dmx O000000o2 = O000000o(this.O0000Oo.O000000o());
        int i = O000000o2.O00000Oo;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        Log.e("JmpcExecutor_TMTEST", "type invalidate:".concat(String.valueOf(O000000o2)));
                        return 2;
                    } else if (O000000o2.O00000o() == null) {
                        this.O0000Oo.O000000o(O00000Oo);
                    }
                } else if (TextUtils.isEmpty(O000000o2.O00000o0())) {
                    this.O0000Oo.O000000o(O00000Oo);
                }
            } else if (O000000o2.O00000Oo() <= 0.0f) {
                this.O0000Oo.O000000o(O00000Oo);
            }
        } else if (O000000o2.O000000o() <= 0) {
            this.O0000Oo.O000000o(O00000Oo);
        }
        return 1;
    }
}
