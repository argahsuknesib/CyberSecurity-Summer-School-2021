package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;

public final class gzv {
    private static gzv O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public BehaviorSubject<PageBean> f18673O000000o = BehaviorSubject.create();
    final List<PageBean.O00000Oo> O00000Oo = new ArrayList();
    final List<PageBean> O00000o0 = new ArrayList();
    private PageBean O00000oO;

    private gzv() {
    }

    public static gzv O000000o() {
        if (O00000o == null) {
            O00000o = new gzv();
            gsy.O00000Oo("DropMenuStateHelper", "getInstance: init");
        }
        return O00000o;
    }

    public final PageBean O00000Oo() {
        if (this.O00000oO == null) {
            this.O00000oO = PageBean.O000000o();
        }
        return this.O00000oO;
    }

    public final void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            while (i < this.O00000o0.size()) {
                PageBean pageBean = this.O00000o0.get(i);
                if (pageBean == null || !TextUtils.equals(pageBean.O00000Oo, str)) {
                    i++;
                } else {
                    this.O00000oO = pageBean;
                    this.f18673O000000o.onNext(pageBean);
                    gsy.O000000o(3, "DropMenuStateHelper", "selectRoom: pageBean: " + pageBean.O00000Oo + " ; " + pageBean.f10340O000000o);
                    return;
                }
            }
        }
    }

    public final void O000000o(List<PageBean.O00000Oo> list) {
        if (!this.O00000Oo.equals(list)) {
            this.O00000Oo.clear();
            this.O00000o0.clear();
            this.O00000Oo.addAll(list);
            for (PageBean.O00000Oo o00000Oo : this.O00000Oo) {
                List<PageBean> list2 = o00000Oo.O00000Oo;
                if (list2 != null && list2.size() > 0) {
                    this.O00000o0.addAll(list2);
                }
            }
        }
    }

    public final void O00000o0() {
        this.O00000oO = null;
        this.O00000o0.clear();
        this.O00000Oo.clear();
    }
}
