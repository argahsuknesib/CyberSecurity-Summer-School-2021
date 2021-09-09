package _m_j;

import android.content.Context;
import android.content.Intent;

public final class azm extends azn {
    public final azz O000000o(Context context, int i, Intent intent) {
        if (4105 == i) {
            return O000000o(intent);
        }
        return null;
    }

    private static azz O000000o(Intent intent) {
        try {
            azy azy = new azy();
            azy.O00000o = Integer.parseInt(bad.O000000o(intent.getStringExtra("command")));
            azy.O00000oo = Integer.parseInt(bad.O000000o(intent.getStringExtra("code")));
            azy.O00000oO = bad.O000000o(intent.getStringExtra("content"));
            azy.O00000Oo = bad.O000000o(intent.getStringExtra("appKey"));
            azy.O00000o0 = bad.O000000o(intent.getStringExtra("appSecret"));
            azy.O0000OoO = bad.O000000o(intent.getStringExtra("appPackage"));
            bae.O000000o("OnHandleIntent-message:" + azy.toString());
            return azy;
        } catch (Exception e) {
            bae.O000000o("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
