package _m_j;

import _m_j.O00O0O0o;
import android.view.View;
import com.hannto.print.bean.PhotoBean;
import com.xiaomi.smarthome.R;

public final class O00Oo0o0 implements O00O0O0o.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ O00Oo0OO f6649O000000o;

    public O00Oo0o0(O00Oo0OO o00Oo0OO) {
        this.f6649O000000o = o00Oo0OO;
    }

    public final void O000000o(View view, int i) {
        PhotoBean photoBean = ((O00O00o0) this.f6649O000000o.O00000oo.get(this.f6649O000000o.O0000OOo)).O00000o.get(i);
        if (view.getId() == R.id.checkbox_container || view.getId() == R.id.checkbox) {
            O00Oo0OO.O000000o(this.f6649O000000o, photoBean);
        } else {
            O00Oo0OO.O000000o(this.f6649O000000o, photoBean, i);
        }
    }
}
