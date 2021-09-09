package _m_j;

import android.util.Log;

public final class dnx extends dnh {
    public final int O000000o(Object obj) {
        int O000000o2 = super.O000000o(obj);
        byte O000000o3 = this.O0000Oo.O000000o();
        dmx O000000o4 = O000000o(O000000o3);
        if (O000000o3 == 0) {
            this.O00000Oo = this.O0000Oo.O000000o();
        }
        dmx O000000o5 = this.O0000OoO.O000000o(this.O00000Oo);
        if (O000000o4 == null || O000000o5 == null) {
            Log.e("MinusExecutor_TMTEST", "read data failed");
            return O000000o2;
        }
        int i = O000000o4.O00000Oo;
        if (i == 1) {
            O000000o5.O000000o(-O000000o4.O000000o());
        } else if (i != 2) {
            Log.e("MinusExecutor_TMTEST", "invalidate type:" + O000000o4.O00000Oo);
            return 2;
        } else {
            O000000o5.O000000o(-O000000o4.O00000Oo());
        }
        return 1;
    }
}
