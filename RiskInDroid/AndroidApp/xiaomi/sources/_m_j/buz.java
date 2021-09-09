package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

final class buz extends BroadcastReceiver {
    buz() {
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            if (!isInitialStickyBroadcast() && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                String O000000o2 = buy.O000000o();
                if (O000000o2 != "None_Network" && !O000000o2.equalsIgnoreCase(buy.O00000o0)) {
                    buu.O000000o("[BroadcastReceiver.onReceive] - Network state changed");
                    buq.O000000o();
                    ArrayList O00000o = buq.O00000o();
                    buq.O000000o();
                    buq.O00000o0();
                    if (buy.f13302O000000o && bun.f13293O000000o != null) {
                        buu.O000000o("[BroadcastReceiver.onReceive] - refresh host");
                        bun.f13293O000000o.O000000o(O00000o);
                    }
                }
                String unused = buy.O00000o0 = O000000o2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
