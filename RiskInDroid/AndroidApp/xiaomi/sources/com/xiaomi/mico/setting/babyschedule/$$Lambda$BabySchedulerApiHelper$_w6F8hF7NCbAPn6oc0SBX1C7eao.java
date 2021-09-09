package com.xiaomi.mico.setting.babyschedule;

import com.xiaomi.mico.api.ApiProviderV2;
import com.xiaomi.mico.api.service.BabySchedulerService;
import com.xiaomi.mico.application.MicoManager;
import rx.Observable;

/* renamed from: com.xiaomi.mico.setting.babyschedule.-$$Lambda$BabySchedulerApiHelper$_w6F8hF7NCbAPn6oc0SBX1C7eao  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$BabySchedulerApiHelper$_w6F8hF7NCbAPn6oc0SBX1C7eao implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$BabySchedulerApiHelper$_w6F8hF7NCbAPn6oc0SBX1C7eao INSTANCE = new $$Lambda$BabySchedulerApiHelper$_w6F8hF7NCbAPn6oc0SBX1C7eao();

    private /* synthetic */ $$Lambda$BabySchedulerApiHelper$_w6F8hF7NCbAPn6oc0SBX1C7eao() {
    }

    public final Observable observable(Object obj) {
        return ((BabySchedulerService) obj).loadDeviceCourses(MicoManager.getInstance().getCurrentMicoID(), "");
    }
}
