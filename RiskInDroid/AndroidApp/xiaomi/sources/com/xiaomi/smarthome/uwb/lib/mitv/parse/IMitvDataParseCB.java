package com.xiaomi.smarthome.uwb.lib.mitv.parse;

import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvInfo;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvNotif;

public interface IMitvDataParseCB {
    void onFailed(int i, String str);

    void onSuccess(MitvInfo mitvInfo, MitvNotif mitvNotif);
}
