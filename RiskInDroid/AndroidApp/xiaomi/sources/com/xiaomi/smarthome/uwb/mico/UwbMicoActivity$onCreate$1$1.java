package com.xiaomi.smarthome.uwb.mico;

import _m_j.fsm;
import _m_j.fso;
import com.xiaomi.smarthome.device.Device;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/uwb/mico/UwbMicoActivity$onCreate$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoActivity$onCreate$1$1 extends fsm<Object, fso> {
    final /* synthetic */ Device $first;
    final /* synthetic */ UwbMicoActivity this$0;

    UwbMicoActivity$onCreate$1$1(UwbMicoActivity uwbMicoActivity, Device device) {
        this.this$0 = uwbMicoActivity;
        this.$first = device;
    }

    public final void onSuccess(Object obj) {
        UwbMicoActivity uwbMicoActivity = this.this$0;
        uwbMicoActivity.updatePlainDid(uwbMicoActivity.matchDevice());
    }

    public final void onFailure(fso fso) {
        this.this$0.updatePlainDid(this.$first);
    }
}
