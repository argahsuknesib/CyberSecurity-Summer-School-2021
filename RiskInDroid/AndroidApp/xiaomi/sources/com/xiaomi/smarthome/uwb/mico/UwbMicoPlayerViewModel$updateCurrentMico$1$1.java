package com.xiaomi.smarthome.uwb.mico;

import _m_j.ixe;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiProvider;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.service.MinaService;
import com.xiaomi.smarthome.device.Device;
import kotlin.Metadata;
import rx.Observable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel$updateCurrentMico$1$1", "Lcom/xiaomi/mico/api/ApiHelper$ApiProviderWrapper;", "getApiProvider", "Lcom/xiaomi/mico/api/ApiProvider;", "Lcom/xiaomi/mico/api/model/Remote$Response;", "p", "Lcom/xiaomi/mico/api/ApiHelper$ApiProviderWrapper$Params;", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoPlayerViewModel$updateCurrentMico$1$1 extends ApiHelper.ApiProviderWrapper {
    final /* synthetic */ Device $this_apply;

    UwbMicoPlayerViewModel$updateCurrentMico$1$1(Device device) {
        this.$this_apply = device;
    }

    public final ApiProvider<Remote.Response> getApiProvider(ApiHelper.ApiProviderWrapper.Params params) {
        ixe.O00000o(params, "p");
        return new ApiProvider(params) {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$updateCurrentMico$1$1$U79jrm6570v1qIrBjraxFKuQd_M */
            private final /* synthetic */ ApiHelper.ApiProviderWrapper.Params f$1;

            {
                this.f$1 = r2;
            }

            public final Observable observable(MinaService minaService) {
                return UwbMicoPlayerViewModel$updateCurrentMico$1$1.m558getApiProvider$lambda0(Device.this, this.f$1, minaService);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: getApiProvider$lambda-0  reason: not valid java name */
    public static final Observable m558getApiProvider$lambda0(Device device, ApiHelper.ApiProviderWrapper.Params params, MinaService minaService) {
        ixe.O00000o(device, "$this_apply");
        ixe.O00000o(params, "$p");
        UwbMicoPlayerManager uwbMicoPlayerManager = UwbMicoPlayerManager.INSTANCE;
        String str = device.did;
        ixe.O00000Oo(str, "did");
        String str2 = params.path;
        ixe.O00000Oo(str2, "p.path");
        String str3 = params.method;
        ixe.O00000Oo(str3, "p.method");
        String str4 = params.message;
        ixe.O00000Oo(str4, "p.message");
        return uwbMicoPlayerManager.getUwbRemoteObservable(str, str2, str3, str4);
    }
}
