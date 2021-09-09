package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.PaymentService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ApiHelper$7Na9Y8xzSyfHTuKBiun35zgdAZg  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ApiHelper$7Na9Y8xzSyfHTuKBiun35zgdAZg implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$ApiHelper$7Na9Y8xzSyfHTuKBiun35zgdAZg INSTANCE = new $$Lambda$ApiHelper$7Na9Y8xzSyfHTuKBiun35zgdAZg();

    private /* synthetic */ $$Lambda$ApiHelper$7Na9Y8xzSyfHTuKBiun35zgdAZg() {
    }

    public final Observable observable(Object obj) {
        return ((PaymentService) obj).getQQMusicVIPPriceList("android", true);
    }
}
