package _m_j;

import android.content.Context;
import android.content.Intent;

public final class azp extends azn {
    public final azz O000000o(Context context, int i, Intent intent) {
        if (4103 != i) {
            return null;
        }
        azz O000000o2 = O000000o(intent);
        azj.O000000o(context, (bab) O000000o2, "push_transmit");
        return O000000o2;
    }

    private static azz O000000o(Intent intent) {
        try {
            bab bab = new bab();
            bab.O0000Oo = Integer.parseInt(bad.O000000o(intent.getStringExtra("messageID")));
            bab.O0000Ooo = bad.O000000o(intent.getStringExtra("taskID"));
            bab.O0000OoO = bad.O000000o(intent.getStringExtra("appPackage"));
            bab.O00000Oo = bad.O000000o(intent.getStringExtra("content"));
            bab.O00000o0 = bad.O000000o(intent.getStringExtra("description"));
            bab.O00000o = bad.O000000o(intent.getStringExtra("appID"));
            bab.f12741O000000o = bad.O000000o(intent.getStringExtra("globalID"));
            return bab;
        } catch (Exception e) {
            bae.O000000o("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
