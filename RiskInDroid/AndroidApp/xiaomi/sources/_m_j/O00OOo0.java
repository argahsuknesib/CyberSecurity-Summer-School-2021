package _m_j;

import _m_j.O00O0O0o;
import android.view.View;
import com.hannto.print.bean.PhotoBean;
import com.xiaomi.smarthome.R;

public final class O00OOo0 implements O00O0O0o.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ O00OOOo f6637O000000o;

    public O00OOo0(O00OOOo o00OOOo) {
        this.f6637O000000o = o00OOOo;
    }

    public final void O000000o(View view, int i) {
        PhotoBean photoBean = ((O00O00o0) this.f6637O000000o.O00000oO.get(this.f6637O000000o.O0000O0o)).O00000o.get(i);
        if (view.getId() == R.id.checkbox_container || view.getId() == R.id.checkbox) {
            O00OOOo.O000000o(this.f6637O000000o, photoBean);
        } else {
            O00OOOo.O000000o(this.f6637O000000o, photoBean, i);
        }
    }
}
