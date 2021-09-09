package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.MinaService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ApiHelper$QQoISRl3VrYbWemJpSkVBJG7SQM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ApiHelper$QQoISRl3VrYbWemJpSkVBJG7SQM implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$ApiHelper$QQoISRl3VrYbWemJpSkVBJG7SQM INSTANCE = new $$Lambda$ApiHelper$QQoISRl3VrYbWemJpSkVBJG7SQM();

    private /* synthetic */ $$Lambda$ApiHelper$QQoISRl3VrYbWemJpSkVBJG7SQM() {
    }

    public final Observable observable(Object obj) {
        return ((MinaService) obj).lanAwakeGroup(LoginManager.getInstance().getPassportInfo().getUserId());
    }
}
