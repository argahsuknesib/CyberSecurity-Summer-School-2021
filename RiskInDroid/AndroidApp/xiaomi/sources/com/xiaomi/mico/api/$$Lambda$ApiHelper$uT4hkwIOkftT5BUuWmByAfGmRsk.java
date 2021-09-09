package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.MinaService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ApiHelper$uT4hkwIOkftT5BUuWmByAfGmRsk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ApiHelper$uT4hkwIOkftT5BUuWmByAfGmRsk implements ApiProvider {
    public static final /* synthetic */ $$Lambda$ApiHelper$uT4hkwIOkftT5BUuWmByAfGmRsk INSTANCE = new $$Lambda$ApiHelper$uT4hkwIOkftT5BUuWmByAfGmRsk();

    private /* synthetic */ $$Lambda$ApiHelper$uT4hkwIOkftT5BUuWmByAfGmRsk() {
    }

    public final Observable observable(MinaService minaService) {
        return minaService.getQQBindStatus("");
    }
}
