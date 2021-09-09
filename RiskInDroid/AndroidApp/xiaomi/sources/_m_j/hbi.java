package _m_j;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public final class hbi extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    private o0OO00o0<View> f18741O000000o = new o0OO00o0<>();
    private o0OO00o0<View> O00000Oo = new o0OO00o0<>();
    private RecyclerView.O000000o O00000o0;

    public hbi(RecyclerView.O000000o o000000o) {
        this.O00000o0 = o000000o;
    }

    public final void O000000o(View view) {
        o0OO00o0<View> o0oo00o0 = this.O00000Oo;
        o0oo00o0.O00000Oo(o0oo00o0.O00000Oo() + 200000, view);
    }

    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.f18741O000000o.O000000o(i, null) != null) {
            return new O000000o(this.f18741O000000o.O000000o(i, null));
        }
        if (this.O00000Oo.O000000o(i, null) != null) {
            return new O000000o(this.O00000Oo.O000000o(i, null));
        }
        return this.O00000o0.onCreateViewHolder(viewGroup, i);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (!O000000o(i) && !O00000Oo(i)) {
            this.O00000o0.onBindViewHolder(o000OOo0, i - this.f18741O000000o.O00000Oo());
        }
    }

    public final int getItemViewType(int i) {
        if (O000000o(i)) {
            return this.f18741O000000o.O00000Oo(i);
        }
        if (O00000Oo(i)) {
            return this.O00000Oo.O00000Oo((i - this.f18741O000000o.O00000Oo()) - this.O00000o0.getItemCount());
        }
        return this.O00000o0.getItemViewType(i - this.f18741O000000o.O00000Oo());
    }

    public class O000000o extends RecyclerView.O000OOo0 {
        public O000000o(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private boolean O000000o(int i) {
        return i < this.f18741O000000o.O00000Oo();
    }

    private boolean O00000Oo(int i) {
        return i >= this.f18741O000000o.O00000Oo() + this.O00000o0.getItemCount();
    }

    public final int getItemCount() {
        return this.f18741O000000o.O00000Oo() + this.O00000Oo.O00000Oo() + this.O00000o0.getItemCount();
    }
}
