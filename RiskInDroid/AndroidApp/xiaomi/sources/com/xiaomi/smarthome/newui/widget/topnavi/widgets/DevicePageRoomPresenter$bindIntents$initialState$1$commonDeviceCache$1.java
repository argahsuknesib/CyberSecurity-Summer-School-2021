package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.iwb;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DevicePageRoomPresenter$bindIntents$initialState$1$commonDeviceCache$1 extends Lambda implements iwb<List<? extends MainPageDeviceModel>> {
    final /* synthetic */ List<MainPageDeviceModel> $commonDeviceViewCache;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevicePageRoomPresenter$bindIntents$initialState$1$commonDeviceCache$1(List<MainPageDeviceModel> list) {
        super(0);
        this.$commonDeviceViewCache = list;
    }

    public final /* synthetic */ Object invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : this.$commonDeviceViewCache) {
            if (((MainPageDeviceModel) next).O0000o00) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
