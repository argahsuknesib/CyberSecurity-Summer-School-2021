package _m_j;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

public final class gqr extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<View> f18156O000000o = new ArrayList<>(2);
    private RecyclerView.O000000o O00000Oo;
    private RecyclerView.O00000o0 O00000o = new RecyclerView.O00000o0() {
        /* class _m_j.gqr.AnonymousClass1 */

        public final void onChanged() {
            super.onChanged();
            gqr.this.notifyDataSetChanged();
        }

        public final void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            gqr gqr = gqr.this;
            gqr.notifyItemRangeChanged(i + gqr.f18156O000000o.size(), i2);
        }

        public final void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            gqr gqr = gqr.this;
            gqr.notifyItemRangeInserted(i + gqr.f18156O000000o.size(), i2);
        }

        public final void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            gqr gqr = gqr.this;
            gqr.notifyItemRangeRemoved(i + gqr.f18156O000000o.size(), i2);
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            int size = gqr.this.f18156O000000o.size();
            gqr.this.notifyItemRangeChanged(i + size, i2 + size + i3);
        }
    };
    private ArrayList<View> O00000o0 = new ArrayList<>(1);

    public gqr(RecyclerView.O000000o o000000o) {
        if (this.O00000Oo != null) {
            notifyItemRangeRemoved(this.f18156O000000o.size(), this.O00000Oo.getItemCount());
            this.O00000Oo.unregisterAdapterDataObserver(this.O00000o);
        }
        this.O00000Oo = o000000o;
        this.O00000Oo.registerAdapterDataObserver(this.O00000o);
        notifyItemRangeInserted(this.f18156O000000o.size(), this.O00000Oo.getItemCount());
    }

    public final gqr O000000o(View view) {
        if (view != null) {
            int indexOf = this.f18156O000000o.indexOf(view);
            if (indexOf < 0) {
                this.f18156O000000o.add(view);
                notifyItemInserted(this.f18156O000000o.size() - 1);
                notifyItemRangeChanged(this.f18156O000000o.size(), getItemCount() - 1);
            } else if (indexOf != this.f18156O000000o.size() - 1) {
                notifyItemMoved(indexOf, this.f18156O000000o.size() - 1);
            }
            return this;
        }
        throw new RuntimeException("header is null");
    }

    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i < this.f18156O000000o.size() - 2147483648) {
            return new RecyclerView.O000OOo0(this.f18156O000000o.get(i - Integer.MIN_VALUE)) {
                /* class _m_j.gqr.AnonymousClass2 */
            };
        }
        if (i < 1073741823 || this.O00000o0.size() <= 0) {
            return this.O00000Oo.onCreateViewHolder(viewGroup, i + 0);
        }
        return new RecyclerView.O000OOo0(this.O00000o0.get(i - 1073741823)) {
            /* class _m_j.gqr.AnonymousClass3 */
        };
    }

    public final int getItemViewType(int i) {
        int size = this.f18156O000000o.size();
        if (i < size) {
            return i - 2147483648;
        }
        if (size > i || i >= this.O00000Oo.getItemCount() + size) {
            return ((i - size) - this.O00000Oo.getItemCount()) + 1073741823;
        }
        return this.O00000Oo.getItemViewType(i - size) + 0;
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        int size = this.f18156O000000o.size();
        if (i < size || i >= this.O00000Oo.getItemCount() + size) {
            ViewGroup.LayoutParams layoutParams = o000OOo0.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).O00000Oo = true;
                return;
            }
            return;
        }
        this.O00000Oo.onBindViewHolder(o000OOo0, i - size);
    }

    public final int getItemCount() {
        return this.f18156O000000o.size() + this.O00000o0.size() + this.O00000Oo.getItemCount();
    }
}
