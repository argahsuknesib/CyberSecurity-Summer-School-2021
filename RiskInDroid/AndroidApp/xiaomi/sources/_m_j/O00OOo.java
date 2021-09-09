package _m_j;

import android.view.View;
import com.hannto.print.bean.PhotoBean;

public final class O00OOo implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ PhotoBean f6636O000000o;
    public final /* synthetic */ O00OOOo O00000Oo;

    public O00OOo(O00OOOo o00OOOo, PhotoBean photoBean) {
        this.O00000Oo = o00OOOo;
        this.f6636O000000o = photoBean;
    }

    public final void onClick(View view) {
        this.O00000Oo.O0000OOo.add(this.f6636O000000o);
        this.O00000Oo.O0000Oo0.notifyDataSetChanged();
    }
}
