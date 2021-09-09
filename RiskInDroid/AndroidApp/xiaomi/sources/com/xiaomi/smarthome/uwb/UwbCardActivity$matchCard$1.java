package com.xiaomi.smarthome.uwb;

import _m_j.ddb;
import _m_j.fsm;
import _m_j.fso;
import _m_j.hzq;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/uwb/UwbCardActivity$matchCard$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbCardActivity$matchCard$1 extends fsm<Object, fso> {
    final /* synthetic */ UwbDevice $uwbDevice;
    final /* synthetic */ UwbCardActivity<C, E, T> this$0;

    UwbCardActivity$matchCard$1(UwbDevice uwbDevice, UwbCardActivity<C, E, T> uwbCardActivity) {
        this.$uwbDevice = uwbDevice;
        this.this$0 = uwbCardActivity;
    }

    public final void onSuccess(Object obj) {
        UwbDevice uwbDevice = this.$uwbDevice;
        Device O000000o2 = hzq.O000000o(uwbDevice == null ? null : uwbDevice.getUwbDevice());
        if (O000000o2 == null) {
            this.this$0.downSpecUrns(this.$uwbDevice);
            return;
        }
        UwbDevice uwbDevice2 = this.$uwbDevice;
        if (uwbDevice2 != null) {
            uwbDevice2.attachBaseDevice(O000000o2);
        }
        this.this$0.matchCardCheckSpec(this.$uwbDevice);
    }

    public final void onFailure(fso fso) {
        ddb.O000000o((int) R.string.code_infonull_error);
    }
}
