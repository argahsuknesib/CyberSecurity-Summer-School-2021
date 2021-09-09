package _m_j;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.O000OOo0;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class ayc<VH extends RecyclerView.O000OOo0> extends RecyclerView.O000000o<VH> {
    protected static final List<Object> O0000OOo = Collections.emptyList();

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f12700O000000o = new O000000o(this);
    protected RecyclerView.O000000o<VH> O0000O0o;

    /* access modifiers changed from: protected */
    public void O000000o() {
    }

    public ayc(RecyclerView.O000000o<VH> o000000o) {
        this.O0000O0o = o000000o;
        this.O0000O0o.registerAdapterDataObserver(this.f12700O000000o);
        super.setHasStableIds(this.O0000O0o.hasStableIds());
    }

    private boolean O00000oO() {
        return this.O0000O0o != null;
    }

    public final void O00000o0() {
        O000000o o000000o;
        O000000o();
        RecyclerView.O000000o<VH> o000000o2 = this.O0000O0o;
        if (!(o000000o2 == null || (o000000o = this.f12700O000000o) == null)) {
            o000000o2.unregisterAdapterDataObserver(o000000o);
        }
        this.O0000O0o = null;
        this.f12700O000000o = null;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (O00000oO()) {
            this.O0000O0o.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (O00000oO()) {
            this.O0000O0o.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public void onViewAttachedToWindow(VH vh) {
        if (O00000oO()) {
            this.O0000O0o.onViewAttachedToWindow(vh);
        }
    }

    public void onViewDetachedFromWindow(VH vh) {
        if (O00000oO()) {
            this.O0000O0o.onViewDetachedFromWindow(vh);
        }
    }

    public void onViewRecycled(VH vh) {
        if (O00000oO()) {
            this.O0000O0o.onViewRecycled(vh);
        }
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        if (O00000oO()) {
            this.O0000O0o.setHasStableIds(z);
        }
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.O0000O0o.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(VH vh, int i) {
        onBindViewHolder(vh, i, O0000OOo);
    }

    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        if (O00000oO()) {
            this.O0000O0o.onBindViewHolder(vh, i, list);
        }
    }

    public int getItemCount() {
        if (O00000oO()) {
            return this.O0000O0o.getItemCount();
        }
        return 0;
    }

    public long getItemId(int i) {
        return this.O0000O0o.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.O0000O0o.getItemViewType(i);
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void O000000o(int i, int i2) {
        notifyItemRangeChanged(i, i2);
    }

    /* access modifiers changed from: protected */
    public void a_(int i, int i2) {
        notifyItemRangeInserted(i, i2);
    }

    /* access modifiers changed from: protected */
    public void O00000o0(int i, int i2) {
        notifyItemRangeRemoved(i, i2);
    }

    /* access modifiers changed from: protected */
    public void O000000o(int i, int i2, int i3) {
        if (i3 == 1) {
            notifyItemMoved(i, i2);
            return;
        }
        throw new IllegalStateException("itemCount should be always 1  (actual: " + i3 + ")");
    }

    /* access modifiers changed from: package-private */
    public final void O00000o() {
        O00000Oo();
    }

    /* access modifiers changed from: package-private */
    public final void O00000oo(int i, int i2) {
        O000000o(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final void O0000O0o(int i, int i2) {
        a_(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final void O0000OOo(int i, int i2) {
        O00000o0(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i, int i2, int i3) {
        O000000o(i, i2, i3);
    }

    static final class O000000o<VH extends RecyclerView.O000OOo0> extends RecyclerView.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<ayc<VH>> f12701O000000o;

        public O000000o(ayc<VH> ayc) {
            this.f12701O000000o = new WeakReference<>(ayc);
        }

        public final void onChanged() {
            ayc ayc = this.f12701O000000o.get();
            if (ayc != null) {
                ayc.O00000o();
            }
        }

        public final void onItemRangeChanged(int i, int i2) {
            ayc ayc = this.f12701O000000o.get();
            if (ayc != null) {
                ayc.O00000oo(i, i2);
            }
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            ayc ayc = this.f12701O000000o.get();
            if (ayc != null) {
                ayc.notifyItemRangeChanged(i, i2, obj);
            }
        }

        public final void onItemRangeInserted(int i, int i2) {
            ayc ayc = this.f12701O000000o.get();
            if (ayc != null) {
                ayc.O0000O0o(i, i2);
            }
        }

        public final void onItemRangeRemoved(int i, int i2) {
            ayc ayc = this.f12701O000000o.get();
            if (ayc != null) {
                ayc.O0000OOo(i, i2);
            }
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            ayc ayc = this.f12701O000000o.get();
            if (ayc != null) {
                ayc.O00000Oo(i, i2, i3);
            }
        }
    }
}
