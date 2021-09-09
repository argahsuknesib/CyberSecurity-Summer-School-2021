package com.xiaomi.smarthome.uwb.mico;

import _m_j.iwb;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/xiaomi/smarthome/uwb/mico/RelativeSeekBarInjector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class VolumeBar$mInjector$2 extends Lambda implements iwb<RelativeSeekBarInjector> {
    final /* synthetic */ VolumeBar this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VolumeBar$mInjector$2(VolumeBar volumeBar) {
        super(0);
        this.this$0 = volumeBar;
    }

    public final RelativeSeekBarInjector invoke() {
        return new RelativeSeekBarInjector(this.this$0, false);
    }
}
