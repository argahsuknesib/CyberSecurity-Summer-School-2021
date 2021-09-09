package com.xiaomi.assemble.control;

import _m_j.azx;
import _m_j.azy;
import _m_j.bab;
import android.content.Context;
import com.heytap.mcssdk.AppPushService;

public class COSAppPushMessageService extends AppPushService {
    public void processMessage(Context context, azx azx) {
        super.processMessage(context, azx);
        COSPushMessageService.O000000o(azx);
    }

    public void processMessage(Context context, bab bab) {
        super.processMessage(context, bab);
        COSPushMessageService.O000000o(bab);
    }

    public void processMessage(Context context, azy azy) {
        super.processMessage(context, azy);
        COSPushMessageService.O000000o(azy);
    }
}
