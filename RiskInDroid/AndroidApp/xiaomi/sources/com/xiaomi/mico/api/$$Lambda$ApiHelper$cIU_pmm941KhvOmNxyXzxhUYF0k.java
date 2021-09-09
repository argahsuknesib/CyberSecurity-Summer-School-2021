package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.MinaService;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ApiHelper$cIU_pmm941KhvOmNxyXzxhUYF0k  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ApiHelper$cIU_pmm941KhvOmNxyXzxhUYF0k implements ApiProvider {
    public static final /* synthetic */ $$Lambda$ApiHelper$cIU_pmm941KhvOmNxyXzxhUYF0k INSTANCE = new $$Lambda$ApiHelper$cIU_pmm941KhvOmNxyXzxhUYF0k();

    private /* synthetic */ $$Lambda$ApiHelper$cIU_pmm941KhvOmNxyXzxhUYF0k() {
    }

    public final Observable observable(MinaService minaService) {
        return minaService.getPlateInfo(LoginManager.getInstance().getPassportInfo().getUserId());
    }
}
