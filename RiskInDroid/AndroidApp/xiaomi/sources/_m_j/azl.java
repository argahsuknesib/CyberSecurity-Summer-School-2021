package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public final class azl extends azn {
    public final azz O000000o(Context context, int i, Intent intent) {
        if (4098 != i) {
            return null;
        }
        azz O000000o2 = O000000o(intent);
        azj.O000000o(context, (azx) O000000o2, "push_transmit");
        return O000000o2;
    }

    private static azz O000000o(Intent intent) {
        try {
            azx azx = new azx();
            azx.O0000Oo = Integer.parseInt(bad.O000000o(intent.getStringExtra("messageID")));
            azx.O0000Ooo = bad.O000000o(intent.getStringExtra("taskID"));
            azx.O0000OoO = bad.O000000o(intent.getStringExtra("appPackage"));
            azx.O00000Oo = bad.O000000o(intent.getStringExtra("content"));
            azx.O00000oO = Integer.parseInt(bad.O000000o(intent.getStringExtra("balanceTime")));
            azx.O00000o0 = Long.parseLong(bad.O000000o(intent.getStringExtra("startDate")));
            azx.O00000o = Long.parseLong(bad.O000000o(intent.getStringExtra("endDate")));
            String O000000o2 = bad.O000000o(intent.getStringExtra("timeRanges"));
            if (!TextUtils.isEmpty(O000000o2)) {
                azx.O00000oo = O000000o2;
            }
            azx.f12737O000000o = bad.O000000o(intent.getStringExtra("title"));
            azx.O0000O0o = bad.O000000o(intent.getStringExtra("rule"));
            azx.O0000OOo = Integer.parseInt(bad.O000000o(intent.getStringExtra("forcedDelivery")));
            azx.O0000Oo0 = Integer.parseInt(bad.O000000o(intent.getStringExtra("distinctBycontent")));
            bae.O000000o("OnHandleIntent-message:" + azx.toString());
            return azx;
        } catch (Exception e) {
            bae.O000000o("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
