package com.xiaomi.mico.setting.babyschedule;

import com.xiaomi.mico.api.ApiProviderV2;
import com.xiaomi.mico.api.service.BabySchedulerService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.setting.babyschedule.-$$Lambda$kutH7SpUKUrdwUzvHq6uwXL9Y2Q  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$kutH7SpUKUrdwUzvHq6uwXL9Y2Q implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$kutH7SpUKUrdwUzvHq6uwXL9Y2Q INSTANCE = new $$Lambda$kutH7SpUKUrdwUzvHq6uwXL9Y2Q();

    private /* synthetic */ $$Lambda$kutH7SpUKUrdwUzvHq6uwXL9Y2Q() {
    }

    public final Observable observable(Object obj) {
        return ((BabySchedulerService) obj).loadSchedulerCategories();
    }
}
