package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.PaymentService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$nm5-y_FbUdCnkzliTUPdZEou-Lw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$nm5y_FbUdCnkzliTUPdZEouLw implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$nm5y_FbUdCnkzliTUPdZEouLw INSTANCE = new $$Lambda$nm5y_FbUdCnkzliTUPdZEouLw();

    private /* synthetic */ $$Lambda$nm5y_FbUdCnkzliTUPdZEouLw() {
    }

    public final Observable observable(Object obj) {
        return ((PaymentService) obj).getMiCoinBalance();
    }
}
