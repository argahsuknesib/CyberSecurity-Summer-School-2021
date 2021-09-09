package _m_j;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

public abstract class aww extends aws<awt> {
    /* access modifiers changed from: protected */
    public abstract void O000000o(awt awt);

    public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, int i, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(awt awt);

    /* access modifiers changed from: protected */
    public final /* synthetic */ void O000000o(awv awv) {
        awt awt = (awt) awv;
        if (!(awt.O00000Oo == null || awt.O00000Oo.itemView == null)) {
            O000000o(awt);
        }
        if (awt.f12672O000000o != null && awt.f12672O000000o.itemView != null) {
            O00000Oo(awt);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean O00000oo(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        awt awt = (awt) awv;
        if (awt.O00000Oo != null && (o000OOo0 == null || awt.O00000Oo == o000OOo0)) {
            O00000Oo(awt, awt.O00000Oo);
            O00000oO(awt, awt.O00000Oo);
            awt.O000000o(awt.O00000Oo);
        }
        if (awt.f12672O000000o != null && (o000OOo0 == null || awt.f12672O000000o == o000OOo0)) {
            O00000Oo(awt, awt.f12672O000000o);
            O00000oO(awt, awt.f12672O000000o);
            awt.O000000o(awt.f12672O000000o);
        }
        return awt.O00000Oo == null && awt.f12672O000000o == null;
    }

    public aww(awn awn) {
        super(awn);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public void O00000oO(awt awt, RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemChangeAnimMgr", "dispatchChangeFinished(" + o000OOo0 + ")");
        }
        this.f12669O000000o.O00000oo(o000OOo0);
    }

    public final long O0000OOo() {
        return this.f12669O000000o.O0000Ooo;
    }

    public final /* synthetic */ void O00000o(awv awv, RecyclerView.O000OOo0 o000OOo0) {
        if (O000000o()) {
            Log.d("ARVItemChangeAnimMgr", "dispatchChangeStarting(" + o000OOo0 + ")");
        }
    }
}
