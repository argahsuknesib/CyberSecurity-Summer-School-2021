package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.MinaService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ApiHelper$-YqQOaTyspNPZTRgGQwlqdiUhpE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ApiHelper$YqQOaTyspNPZTRgGQwlqdiUhpE implements ApiProvider {
    public static final /* synthetic */ $$Lambda$ApiHelper$YqQOaTyspNPZTRgGQwlqdiUhpE INSTANCE = new $$Lambda$ApiHelper$YqQOaTyspNPZTRgGQwlqdiUhpE();

    private /* synthetic */ $$Lambda$ApiHelper$YqQOaTyspNPZTRgGQwlqdiUhpE() {
    }

    public final Observable observable(MinaService minaService) {
        return minaService.getHistoryV3();
    }
}
