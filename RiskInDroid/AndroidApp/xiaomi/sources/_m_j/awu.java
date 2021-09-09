package _m_j;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

public abstract class awu extends aws<awr> {
    public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0);

    public final /* synthetic */ void O00000oO(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        O00000oo(o000OOo0);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean O00000oo(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        awr awr = (awr) awv;
        if (awr.f12668O000000o == null) {
            return false;
        }
        if (o000OOo0 != null && awr.f12668O000000o != o000OOo0) {
            return false;
        }
        O00000Oo(awr, awr.f12668O000000o);
        O00000oo(awr.f12668O000000o);
        awr.O000000o(awr.f12668O000000o);
        return true;
    }

    public awu(awn awn) {
        super(awn);
    }

    public final long O0000OOo() {
        return this.f12669O000000o.O0000Oo0;
    }

    private void O00000oo(RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemAddAnimMgr", "dispatchAddFinished(" + o000OOo0 + ")");
        }
        this.f12669O000000o.O00000oo(o000OOo0);
    }

    public final /* synthetic */ void O00000o(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemAddAnimMgr", "dispatchAddStarting(" + o000OOo0 + ")");
        }
    }
}
