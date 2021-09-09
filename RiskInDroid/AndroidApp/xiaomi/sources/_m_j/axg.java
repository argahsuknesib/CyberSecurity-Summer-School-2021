package _m_j;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.O000OOo0;
import java.util.List;

class axg<VH extends RecyclerView.O000OOo0> extends ayc<VH> {

    /* renamed from: O000000o  reason: collision with root package name */
    axe f12679O000000o;
    RecyclerView.O000OOo0 O00000Oo;
    axj O00000o;
    axi O00000o0;
    int O00000oO = -1;
    int O00000oo = -1;
    private axl O0000Oo0;

    private static int O00000o0(int i, int i2, int i3) {
        return (i2 < 0 || i3 < 0 || i2 == i3) ? i : (i >= i2 || i >= i3) ? (i <= i2 || i <= i3) ? i3 < i2 ? i == i3 ? i2 : i - 1 : i == i3 ? i2 : i + 1 : i : i;
    }

    public axg(axl axl, RecyclerView.O000000o<VH> o000000o) {
        super(o000000o);
        this.f12679O000000o = O000000o(o000000o);
        if (O000000o(o000000o) != null) {
            this.O0000Oo0 = axl;
            return;
        }
        throw new IllegalArgumentException("adapter does not implement DraggableItemAdapter");
    }

    public final void O000000o() {
        super.O000000o();
        this.O00000Oo = null;
        this.f12679O000000o = null;
        this.O0000Oo0 = null;
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        VH onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        if (onCreateViewHolder instanceof axf) {
            ((axf) onCreateViewHolder).setDragStateFlags(-1);
        }
        return onCreateViewHolder;
    }

    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        VH vh2;
        if (O0000O0o()) {
            long j = this.O00000o0.O00000o0;
            long itemId = vh.getItemId();
            int O00000o02 = O00000o0(i, this.O00000oO, this.O00000oo);
            if (itemId == j && vh != (vh2 = this.O00000Oo)) {
                if (vh2 != null) {
                    O00000oo();
                }
                Log.i("ARVDraggableWrapper", "a new view holder object for the currently dragging item is assigned");
                this.O00000Oo = vh;
                axl axl = this.O0000Oo0;
                axl.O0000oOo = vh;
                axl.O0000oo0.O000000o(vh);
            }
            int i2 = 1;
            if (itemId == j) {
                i2 = 3;
            }
            if (this.O00000o.O000000o(i)) {
                i2 |= 4;
            }
            O000000o(vh, i2);
            super.onBindViewHolder(vh, O00000o02, list);
            return;
        }
        O000000o(vh, 0);
        super.onBindViewHolder(vh, i, list);
    }

    public long getItemId(int i) {
        if (O0000O0o()) {
            return super.getItemId(O00000o0(i, this.O00000oO, this.O00000oo));
        }
        return super.getItemId(i);
    }

    public int getItemViewType(int i) {
        if (O0000O0o()) {
            return super.getItemViewType(O00000o0(i, this.O00000oO, this.O00000oo));
        }
        return super.getItemViewType(i);
    }

    private void O00000oO() {
        axl axl = this.O0000Oo0;
        if (axl != null) {
            axl.O000000o(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        if (z && this.O00000oo != this.O00000oO) {
            ((axe) aye.O000000o(this.O0000O0o, axe.class)).b_(this.O00000oO, this.O00000oo);
        }
        this.O00000oO = -1;
        this.O00000oo = -1;
        this.O00000o = null;
        this.O00000o0 = null;
        this.O00000Oo = null;
        notifyDataSetChanged();
    }

    public void onViewRecycled(VH vh) {
        if (O0000O0o() && vh == this.O00000Oo) {
            O00000oo();
        }
        super.onViewRecycled(vh);
    }

    private void O00000oo() {
        Log.i("ARVDraggableWrapper", "a view holder object which is bound to currently dragging item is recycled");
        this.O00000Oo = null;
        this.O0000Oo0.O00000Oo();
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o(int i, int i2) {
        return this.f12679O000000o.O00000Oo(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final void O00000oO(int i, int i2) {
        int O00000o02 = O00000o0(i, this.O00000oO, this.O00000oo);
        if (O00000o02 == this.O00000oO) {
            this.O00000oo = i2;
            notifyItemMoved(i, i2);
            return;
        }
        throw new IllegalStateException("onMoveItem() - may be a bug or has duplicate IDs  --- mDraggingItemInitialPosition = " + this.O00000oO + ", mDraggingItemCurrentPosition = " + this.O00000oo + ", origFromPosition = " + O00000o02 + ", fromPosition = " + i + ", toPosition = " + i2);
    }

    private boolean O0000O0o() {
        return this.O00000o0 != null;
    }

    private static void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (o000OOo0 instanceof axf) {
            axf axf = (axf) o000OOo0;
            int dragStateFlags = axf.getDragStateFlags();
            if (dragStateFlags == -1 || ((dragStateFlags ^ i) & Integer.MAX_VALUE) != 0) {
                i |= Integer.MIN_VALUE;
            }
            axf.setDragStateFlags(i);
        }
    }

    private static axe O000000o(RecyclerView.O000000o o000000o) {
        return (axe) aye.O000000o(o000000o, axe.class);
    }

    public final void O00000Oo() {
        if (O0000O0o()) {
            O00000oO();
        } else {
            super.O00000Oo();
        }
    }

    public final void O000000o(int i, int i2) {
        if (O0000O0o()) {
            O00000oO();
        } else {
            super.O000000o(i, i2);
        }
    }

    public final void a_(int i, int i2) {
        if (O0000O0o()) {
            O00000oO();
        } else {
            super.a_(i, i2);
        }
    }

    public final void O00000o0(int i, int i2) {
        if (O0000O0o()) {
            O00000oO();
        } else {
            super.O00000o0(i, i2);
        }
    }

    public final void O000000o(int i, int i2, int i3) {
        if (O0000O0o()) {
            O00000oO();
        } else {
            super.O000000o(i, i2, i3);
        }
    }
}
