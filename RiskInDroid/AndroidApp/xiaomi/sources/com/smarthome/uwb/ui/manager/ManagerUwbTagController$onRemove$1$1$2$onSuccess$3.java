package com.smarthome.uwb.ui.manager;

import _m_j.iwc;
import com.xiaomi.smarthome.device.Device;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/xiaomi/smarthome/device/Device;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class ManagerUwbTagController$onRemove$1$1$2$onSuccess$3 extends Lambda implements iwc<Device, Boolean> {
    final /* synthetic */ List<String> $removed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ManagerUwbTagController$onRemove$1$1$2$onSuccess$3(List<String> list) {
        super(1);
        this.$removed = list;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(this.$removed.contains(((Device) obj).did));
    }
}
