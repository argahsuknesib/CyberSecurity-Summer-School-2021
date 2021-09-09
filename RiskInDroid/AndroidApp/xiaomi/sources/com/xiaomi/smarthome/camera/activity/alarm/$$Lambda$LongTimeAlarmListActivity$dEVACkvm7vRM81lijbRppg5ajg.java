package com.xiaomi.smarthome.camera.activity.alarm;

import android.view.View;
import com.xiaomi.smarthome.camera.activity.setting.ModeController;

/* renamed from: com.xiaomi.smarthome.camera.activity.alarm.-$$Lambda$LongTimeAlarmListActivity$dEVACkvm7vRM81lijb-Rppg5ajg  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$LongTimeAlarmListActivity$dEVACkvm7vRM81lijbRppg5ajg implements View.OnClickListener {
    public static final /* synthetic */ $$Lambda$LongTimeAlarmListActivity$dEVACkvm7vRM81lijbRppg5ajg INSTANCE = new $$Lambda$LongTimeAlarmListActivity$dEVACkvm7vRM81lijbRppg5ajg();

    private /* synthetic */ $$Lambda$LongTimeAlarmListActivity$dEVACkvm7vRM81lijbRppg5ajg() {
    }

    public final void onClick(View view) {
        ModeController.getInstance().changeMode(1);
    }
}
