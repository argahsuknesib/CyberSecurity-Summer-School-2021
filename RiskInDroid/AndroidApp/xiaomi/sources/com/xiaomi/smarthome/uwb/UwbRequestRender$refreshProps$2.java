package com.xiaomi.smarthome.uwb;

import _m_j.fsm;
import _m_j.fso;
import _m_j.hcz;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$refreshProps$2", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/device/api/spec/operation/PropertyParam;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$refreshProps$2 extends fsm<List<PropertyParam>, fso> {
    final /* synthetic */ long $requestTime;
    final /* synthetic */ UwbRequestRender<C, E, T> this$0;

    UwbRequestRender$refreshProps$2(UwbRequestRender<C, E, T> uwbRequestRender, long j) {
        this.this$0 = uwbRequestRender;
        this.$requestTime = j;
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        onSuccess((List<PropertyParam>) ((List) obj));
    }

    public final void onSuccess(List<PropertyParam> list) {
        this.this$0.setDelayTime(System.currentTimeMillis() - this.$requestTime);
    }

    public final void onFailure(fso fso) {
        Device device = this.this$0.device;
        UwbDevice uwbDevice = device instanceof UwbDevice ? (UwbDevice) device : null;
        if ((uwbDevice == null ? null : uwbDevice.getBaseDevice()) != null) {
            hcz.getInstance().getDevicePropFromServer(this.this$0.specParam, this.this$0.getList(), null);
        }
        this.this$0.setDelayTime(System.currentTimeMillis() - this.$requestTime);
    }
}
