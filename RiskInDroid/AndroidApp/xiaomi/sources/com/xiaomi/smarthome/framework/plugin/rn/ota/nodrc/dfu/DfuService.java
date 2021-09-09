package com.xiaomi.smarthome.framework.plugin.rn.ota.nodrc.dfu;

import _m_j.gbu;
import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

public class DfuService extends DfuBaseService {
    public boolean isDebug() {
        return true;
    }

    public Class<? extends Activity> getNotificationTarget() {
        gbu.O000000o("rn-nodrc-dfu, DfuService-->getNotificationTarget()..." + getClass().getName());
        return NotificationActivity.class;
    }
}
