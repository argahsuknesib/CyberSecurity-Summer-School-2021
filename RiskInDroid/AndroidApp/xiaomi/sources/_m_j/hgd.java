package _m_j;

import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.Collections;
import java.util.List;

public final class hgd {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<MainPageDeviceModel> f18895O000000o;
    public final PageBean O00000Oo;

    public hgd(List<MainPageDeviceModel> list, PageBean pageBean) {
        LogType logType = LogType.MAIN_PAGE;
        StringBuilder sb = new StringBuilder("deviceData=");
        sb.append(list == null ? null : Integer.valueOf(list.size()));
        gsy.O00000Oo(logType, "MVI-MainPageViewState", sb.toString());
        this.f18895O000000o = list;
        this.O00000Oo = pageBean;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        List<MainPageDeviceModel> f18896O000000o;
        PageBean O00000Oo;

        public O000000o() {
            this.f18896O000000o = Collections.emptyList();
        }

        public O000000o(hgd hgd) {
            if (hgd != null) {
                this.f18896O000000o = hgd.f18895O000000o;
            }
        }
    }
}
