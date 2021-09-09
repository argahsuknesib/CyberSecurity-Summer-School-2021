package com.xiaomi.mico.setting.alarm;

import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.TimeUtil;
import java.util.Comparator;

/* renamed from: com.xiaomi.mico.setting.alarm.-$$Lambda$AlarmActivity$2$rN8KZXrg5md0kHMoC46LWRVSdzI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AlarmActivity$2$rN8KZXrg5md0kHMoC46LWRVSdzI implements Comparator {
    public static final /* synthetic */ $$Lambda$AlarmActivity$2$rN8KZXrg5md0kHMoC46LWRVSdzI INSTANCE = new $$Lambda$AlarmActivity$2$rN8KZXrg5md0kHMoC46LWRVSdzI();

    private /* synthetic */ $$Lambda$AlarmActivity$2$rN8KZXrg5md0kHMoC46LWRVSdzI() {
    }

    public final int compare(Object obj, Object obj2) {
        return TimeUtil.compareTimestampHourMinute(((Remote.Response.Alarm) obj).timestamp, ((Remote.Response.Alarm) obj2).timestamp);
    }
}
