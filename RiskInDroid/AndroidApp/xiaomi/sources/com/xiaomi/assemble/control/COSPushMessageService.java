package com.xiaomi.assemble.control;

import _m_j.azx;
import _m_j.azy;
import _m_j.bab;
import _m_j.dzm;
import android.content.Context;
import com.heytap.mcssdk.PushService;

public class COSPushMessageService extends PushService {
    public void processMessage(Context context, azx azx) {
        super.processMessage(context, azx);
        O000000o(azx);
    }

    public void processMessage(Context context, bab bab) {
        super.processMessage(context, bab);
        O000000o(bab);
    }

    public void processMessage(Context context, azy azy) {
        super.processMessage(context, azy);
        O000000o(azy);
    }

    static void O000000o(Object obj) {
        if (!(obj instanceof azx) && (obj instanceof bab)) {
            dzm.O000000o();
        }
    }
}
