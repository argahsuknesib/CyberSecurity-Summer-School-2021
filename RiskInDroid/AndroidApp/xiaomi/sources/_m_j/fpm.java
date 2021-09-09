package _m_j;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public final class fpm extends eh {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<fpi> f16822O000000o;

    public fpm(ee eeVar, List<fpi> list) {
        super(eeVar);
        this.f16822O000000o = list;
        if (list == null) {
            this.f16822O000000o = new ArrayList();
        }
    }

    public final Fragment getItem(int i) {
        if (i < 0 || i >= this.f16822O000000o.size()) {
            return null;
        }
        return this.f16822O000000o.get(i);
    }

    public final int getCount() {
        List<fpi> list = this.f16822O000000o;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
