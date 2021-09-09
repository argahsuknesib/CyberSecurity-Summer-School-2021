package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.PaymentService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ho1Yl61PK_jhZUhAfzhRKfxGb9U  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ho1Yl61PK_jhZUhAfzhRKfxGb9U implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$ho1Yl61PK_jhZUhAfzhRKfxGb9U INSTANCE = new $$Lambda$ho1Yl61PK_jhZUhAfzhRKfxGb9U();

    private /* synthetic */ $$Lambda$ho1Yl61PK_jhZUhAfzhRKfxGb9U() {
    }

    public final Observable observable(Object obj) {
        return ((PaymentService) obj).getQQMusicMemberStatus();
    }
}
