package com.xiaomi.smarthome.newui;

import _m_j.ggb;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.ixe;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class RoomPagerAdapter$renderPage$shouldChangeToMainAdPage$1 extends Lambda implements iwb<Boolean> {
    final /* synthetic */ List<MainPageDeviceModel> $devices;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomPagerAdapter$renderPage$shouldChangeToMainAdPage$1(List<MainPageDeviceModel> list) {
        super(0);
        this.$devices = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if ((r0 == null ? null : r0.f8988O000000o) == com.xiaomi.smarthome.homeroom.model.GridViewData.GridType.TYPE_IR) goto L_0x0037;
     */
    public final /* synthetic */ Object invoke() {
        boolean z = true;
        if (!(!this.$devices.isEmpty())) {
            List<GridViewData> O0000o0o = ggb.O00000Oo().O0000o0o();
            if (!O0000o0o.isEmpty()) {
                if (O0000o0o.size() == 1) {
                    ixe.O00000Oo(O0000o0o, "allDevices");
                    GridViewData gridViewData = (GridViewData) iuo.O00000o0((List) O0000o0o);
                }
            }
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
