package _m_j;

import com.xiaomi.qrcode2.ViewfinderView;
import java.util.List;

public final class etq implements idh {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ViewfinderView f15803O000000o;

    public etq(ViewfinderView viewfinderView) {
        this.f15803O000000o = viewfinderView;
    }

    public final void O000000o(idg idg) {
        List<idg> list = this.f15803O000000o.O00000Oo;
        synchronized (list) {
            list.add(idg);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}
