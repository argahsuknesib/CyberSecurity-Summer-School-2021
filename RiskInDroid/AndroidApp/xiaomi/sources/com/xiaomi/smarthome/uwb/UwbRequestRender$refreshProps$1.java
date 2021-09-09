package com.xiaomi.smarthome.uwb;

import _m_j.fsm;
import _m_j.fso;
import _m_j.hcv;
import com.xiaomi.smarthome.device.Device;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$refreshProps$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$refreshProps$1 extends fsm<Object, fso> {
    final /* synthetic */ long $requestTime;
    final /* synthetic */ UwbRequestRender<C, E, T> this$0;

    UwbRequestRender$refreshProps$1(UwbRequestRender<C, E, T> uwbRequestRender, long j) {
        this.this$0 = uwbRequestRender;
        this.$requestTime = j;
    }

    public final void onSuccess(Object obj) {
        this.this$0.setDelayTime(System.currentTimeMillis() - this.$requestTime);
    }

    public final void onFailure(fso fso) {
        Device device = this.this$0.device;
        UwbDevice uwbDevice = device instanceof UwbDevice ? (UwbDevice) device : null;
        if ((uwbDevice == null ? null : uwbDevice.getBaseDevice()) != null) {
            hcv.getInstance().loadCardPropsFromServerAsync(this.this$0.device, null, "updatePropValue");
        }
        this.this$0.setDelayTime(System.currentTimeMillis() - this.$requestTime);
    }
}
