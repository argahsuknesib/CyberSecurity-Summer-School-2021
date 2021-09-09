package _m_j;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class gzm extends RecyclerView.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private final RecyclerView.O00000o0 f18626O000000o = new RecyclerView.O00000o0() {
        /* class _m_j.gzm.AnonymousClass1 */

        public final void onChanged() {
            gzm.this.O0000O0o.O00000o(gzm.this);
        }

        public final void onItemRangeChanged(int i, int i2) {
            gzm.this.O0000O0o.O000000o(gzm.this, i, i2);
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            gzm.this.O0000O0o.O000000o(gzm.this, i, i2, obj);
        }

        public final void onItemRangeInserted(int i, int i2) {
            gzm.this.O0000O0o.O00000Oo(gzm.this, i, i2);
        }

        public final void onItemRangeRemoved(int i, int i2) {
            gzm.this.O0000O0o.O00000o0(gzm.this, i, i2);
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            gzm.this.O0000O0o.O00000o(gzm.this, i, i2);
        }
    };
    public gzn O0000O0o;
    public String O0000OOo = getClass().getSimpleName();

    public int O000000o() {
        return 1;
    }

    public int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        return 0;
    }

    public void O000000o(gs gsVar) {
    }

    public void O000000o(Canvas canvas, RecyclerView recyclerView, View view, int i, RecyclerView.O000OO0o o000OO0o) {
    }

    public void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
    }

    public void O000000o(RecyclerView recyclerView) {
    }

    public void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, int i) {
    }

    public boolean O000000o(int i, int i2) {
        return false;
    }

    public void O0000OOo() {
    }

    /* access modifiers changed from: protected */
    public int k_() {
        return -1;
    }

    public final boolean j_() {
        return this.O0000O0o.O00000oO(this);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        registerAdapterDataObserver(this.f18626O000000o);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        unregisterAdapterDataObserver(this.f18626O000000o);
    }

    public boolean l_() {
        return getItemCount() != 0;
    }
}
