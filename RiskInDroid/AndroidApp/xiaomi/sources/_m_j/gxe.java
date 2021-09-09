package _m_j;

import androidx.fragment.app.Fragment;
import java.util.List;

public final class gxe extends eh {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<Fragment> f18449O000000o;

    public gxe(ee eeVar, List<Fragment> list) {
        super(eeVar);
        this.f18449O000000o = list;
    }

    public final Fragment getItem(int i) {
        List<Fragment> list = this.f18449O000000o;
        if (list == null || i < 0 || list.size() <= i) {
            return null;
        }
        return this.f18449O000000o.get(i);
    }

    public final int getCount() {
        List<Fragment> list = this.f18449O000000o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
