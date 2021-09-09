package _m_j;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

public abstract class awy extends aws<axa> {
    public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0);

    public final /* synthetic */ void O00000oO(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        O00000oo(o000OOo0);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean O00000oo(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        axa axa = (axa) awv;
        if (axa.f12674O000000o == null) {
            return false;
        }
        if (o000OOo0 != null && axa.f12674O000000o != o000OOo0) {
            return false;
        }
        O00000Oo(axa, axa.f12674O000000o);
        O00000oo(axa.f12674O000000o);
        axa.O000000o(axa.f12674O000000o);
        return true;
    }

    public awy(awn awn) {
        super(awn);
    }

    public final long O0000OOo() {
        return this.f12669O000000o.O0000Oo;
    }

    private void O00000oo(RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemRemoveAnimMgr", "dispatchRemoveFinished(" + o000OOo0 + ")");
        }
        this.f12669O000000o.O00000oo(o000OOo0);
    }

    public final /* synthetic */ void O00000o(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemRemoveAnimMgr", "dispatchRemoveStarting(" + o000OOo0 + ")");
        }
    }
}
