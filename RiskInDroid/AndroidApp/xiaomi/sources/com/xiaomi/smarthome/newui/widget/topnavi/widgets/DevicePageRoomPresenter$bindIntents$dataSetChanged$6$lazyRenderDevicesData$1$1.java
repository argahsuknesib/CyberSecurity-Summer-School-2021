package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.gfz;
import _m_j.iwb;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DevicePageRoomPresenter$bindIntents$dataSetChanged$6$lazyRenderDevicesData$1$1 extends Lambda implements iwb<List<? extends MainPageDeviceModel>> {
    final /* synthetic */ PageBean $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevicePageRoomPresenter$bindIntents$dataSetChanged$6$lazyRenderDevicesData$1$1(PageBean pageBean) {
        super(0);
        this.$it = pageBean;
    }

    public final /* synthetic */ Object invoke() {
        Collection arrayList = new ArrayList();
        for (Device O000000o2 : gfz.f17670O000000o.O000000o(this.$it)) {
            MainPageDeviceModel O000000o3 = MainPageDeviceModel.CREATOR.O000000o(O000000o2);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        return (List) arrayList;
    }
}
