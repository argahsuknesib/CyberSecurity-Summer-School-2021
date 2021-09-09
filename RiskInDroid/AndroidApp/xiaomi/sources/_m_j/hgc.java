package _m_j;

import _m_j.hgd;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.Collections;
import java.util.List;

public interface hgc extends hge<hgd> {

    public static class O000000o implements hgc {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<MainPageDeviceModel> f18894O000000o;

        public final /* synthetic */ Object O000000o(Object obj) {
            hgd hgd = (hgd) obj;
            PageBean O00000Oo = gzv.O000000o().O00000Oo();
            if (!O00000Oo.O00000o0) {
                Collections.sort(this.f18894O000000o, $$Lambda$hgc$O000000o$eRWFhzfMWA57omarJsPNx42jnxs.INSTANCE);
            }
            hgd.O000000o o000000o = new hgd.O000000o(hgd);
            o000000o.f18896O000000o = this.f18894O000000o;
            o000000o.O00000Oo = O00000Oo;
            return new hgd(o000000o.f18896O000000o, o000000o.O00000Oo);
        }

        public O000000o(List<MainPageDeviceModel> list) {
            this.f18894O000000o = list;
        }
    }
}
