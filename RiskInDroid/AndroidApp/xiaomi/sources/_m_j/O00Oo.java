package _m_j;

import android.view.View;
import com.hannto.print.bean.PhotoBean;

public final class O00Oo implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ PhotoBean f6638O000000o;
    public final /* synthetic */ O00Oo0OO O00000Oo;

    public O00Oo(O00Oo0OO o00Oo0OO, PhotoBean photoBean) {
        this.O00000Oo = o00Oo0OO;
        this.f6638O000000o = photoBean;
    }

    public final void onClick(View view) {
        this.O00000Oo.O0000Oo0.add(this.f6638O000000o);
        this.O00000Oo.O0000Oo.notifyDataSetChanged();
    }
}
