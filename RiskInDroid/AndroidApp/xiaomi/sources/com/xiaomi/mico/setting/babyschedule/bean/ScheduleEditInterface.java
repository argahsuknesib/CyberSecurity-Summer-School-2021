package com.xiaomi.mico.setting.babyschedule.bean;

import android.content.Context;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ScheduleEditInterface {
    long getAlarmTime();

    int getCircle();

    String getEditPageTitle(Context context);

    List<ScheduleItem> getScheduleResource();

    TimedOffBean getTimedOffBean(Context context);

    /* renamed from: com.xiaomi.mico.setting.babyschedule.bean.ScheduleEditInterface$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long getDefaultTimeStamp() {
            return System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5);
        }
    }
}
