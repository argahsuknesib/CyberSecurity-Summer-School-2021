package _m_j;

import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/RoomRenderData;", "", "page", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "data", "Lkotlin/Function0;", "", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "(Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;Lkotlin/jvm/functions/Function0;)V", "getData", "()Lkotlin/jvm/functions/Function0;", "getPage", "()Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hid {

    /* renamed from: O000000o  reason: collision with root package name */
    public final PageBean f18959O000000o;
    public final iwb<List<MainPageDeviceModel>> O00000Oo;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hid)) {
            return false;
        }
        hid hid = (hid) obj;
        return ixe.O000000o(this.f18959O000000o, hid.f18959O000000o) && ixe.O000000o(this.O00000Oo, hid.O00000Oo);
    }

    public final int hashCode() {
        return (this.f18959O000000o.hashCode() * 31) + this.O00000Oo.hashCode();
    }

    public final String toString() {
        return "RoomRenderData(page=" + this.f18959O000000o + ", data=" + this.O00000Oo + ')';
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [_m_j.iwb<java.util.List<com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel>>, _m_j.iwb<? extends java.util.List<com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel>>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public hid(PageBean pageBean, iwb<? extends List<MainPageDeviceModel>> r3) {
        ixe.O00000o(pageBean, "page");
        ixe.O00000o(r3, "data");
        this.f18959O000000o = pageBean;
        this.O00000Oo = r3;
    }
}
