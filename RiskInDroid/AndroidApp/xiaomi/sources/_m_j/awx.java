package _m_j;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

public abstract class awx extends aws<awz> {
    public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, int i4);

    public final /* synthetic */ void O00000oO(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        O000000o(o000OOo0);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean O00000oo(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        awz awz = (awz) awv;
        if (awz.f12673O000000o == null) {
            return false;
        }
        if (o000OOo0 != null && awz.f12673O000000o != o000OOo0) {
            return false;
        }
        O00000Oo(awz, awz.f12673O000000o);
        O000000o(awz.f12673O000000o);
        awz.O000000o(awz.f12673O000000o);
        return true;
    }

    public awx(awn awn) {
        super(awn);
    }

    public final long O0000OOo() {
        return this.f12669O000000o.O0000OoO;
    }

    public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemMoveAnimMgr", "dispatchMoveFinished(" + o000OOo0 + ")");
        }
        this.f12669O000000o.O00000oo(o000OOo0);
    }

    public final /* synthetic */ void O00000o(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemMoveAnimMgr", "dispatchMoveStarting(" + o000OOo0 + ")");
        }
    }
}
