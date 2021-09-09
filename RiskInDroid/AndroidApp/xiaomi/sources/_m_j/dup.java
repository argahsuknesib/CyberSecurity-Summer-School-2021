package _m_j;

import android.net.Uri;
import android.text.TextUtils;

public final class dup {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14954O000000o;
        public int O00000Oo;

        O000000o(int i, int i2) {
            this.O00000Oo = i;
            this.f14954O000000o = i2;
        }
    }

    public static O000000o O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getQueryParameter("w")) || TextUtils.isEmpty(parse.getQueryParameter("h"))) {
            return null;
        }
        int parseInt = Integer.parseInt(parse.getQueryParameter("w"));
        int parseInt2 = Integer.parseInt(parse.getQueryParameter("h"));
        if (parseInt <= 0 || parseInt2 <= 0) {
            return null;
        }
        return new O000000o((int) (((float) (parseInt * dum.f14951O000000o)) / 1080.0f), (int) (((float) (parseInt2 * dum.f14951O000000o)) / 1080.0f));
    }
}
