package _m_j;

import _m_j.awv;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class aws<T extends awv> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final awn f12669O000000o;
    protected final List<T> O00000Oo = new ArrayList();
    protected final List<RecyclerView.O000OOo0> O00000o = new ArrayList();
    protected final List<List<T>> O00000o0 = new ArrayList();

    /* access modifiers changed from: protected */
    public abstract void O000000o(awv awv);

    /* access modifiers changed from: protected */
    public abstract void O000000o(awv awv, RecyclerView.O000OOo0 o000OOo0);

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(T t, RecyclerView.O000OOo0 o000OOo0);

    public abstract void O00000o(T t, RecyclerView.O000OOo0 o000OOo0);

    /* access modifiers changed from: protected */
    public abstract void O00000o0(T t, RecyclerView.O000OOo0 o000OOo0);

    public abstract void O00000oO(T t, RecyclerView.O000OOo0 o000OOo0);

    /* access modifiers changed from: protected */
    public abstract boolean O00000oo(T t, RecyclerView.O000OOo0 o000OOo0);

    public aws(awn awn) {
        this.f12669O000000o = awn;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        return this.f12669O000000o.O00000oo();
    }

    public final boolean O00000Oo() {
        return !this.O00000Oo.isEmpty();
    }

    public final boolean O00000o0() {
        return !this.O00000Oo.isEmpty() || !this.O00000o.isEmpty() || !this.O00000o0.isEmpty();
    }

    public final boolean O00000Oo(RecyclerView.O000OOo0 o000OOo0) {
        return this.O00000o.remove(o000OOo0);
    }

    public final void O00000o() {
        List<RecyclerView.O000OOo0> list = this.O00000o;
        for (int size = list.size() - 1; size >= 0; size--) {
            cb.O0000o(list.get(size).itemView).O00000Oo();
        }
    }

    public final void O000000o(boolean z, long j) {
        final ArrayList<awv> arrayList = new ArrayList<>();
        arrayList.addAll(this.O00000Oo);
        this.O00000Oo.clear();
        if (z) {
            this.O00000o0.add(arrayList);
            cb.O000000o(((awv) arrayList.get(0)).O000000o().itemView, new Runnable() {
                /* class _m_j.aws.AnonymousClass1 */

                public final void run() {
                    for (awv O00000Oo2 : arrayList) {
                        aws.this.O00000Oo(O00000Oo2);
                    }
                    arrayList.clear();
                    aws.this.O00000o0.remove(arrayList);
                }
            }, j);
            return;
        }
        for (awv O000000o2 : arrayList) {
            O000000o(O000000o2);
        }
        arrayList.clear();
    }

    public final void O00000o0(RecyclerView.O000OOo0 o000OOo0) {
        List<T> list = this.O00000Oo;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (O00000oo((awv) list.get(size), o000OOo0) && o000OOo0 != null) {
                list.remove(size);
            }
        }
        if (o000OOo0 == null) {
            list.clear();
        }
    }

    public final void O00000oO() {
        O00000o0((RecyclerView.O000OOo0) null);
    }

    public final void O00000o(RecyclerView.O000OOo0 o000OOo0) {
        for (int size = this.O00000o0.size() - 1; size >= 0; size--) {
            List list = this.O00000o0.get(size);
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (O00000oo((awv) list.get(size2), o000OOo0) && o000OOo0 != null) {
                    list.remove(size2);
                }
            }
            if (o000OOo0 == null) {
                list.clear();
            }
            if (list.isEmpty()) {
                this.O00000o0.remove(list);
            }
        }
    }

    public final void O00000oo() {
        O00000o(null);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(awv awv) {
        O000000o(awv);
    }

    /* access modifiers changed from: protected */
    public final void O00000oO(RecyclerView.O000OOo0 o000OOo0) {
        this.f12669O000000o.O00000o0(o000OOo0);
    }

    /* access modifiers changed from: protected */
    public final void O0000O0o() {
        this.f12669O000000o.O00000o0();
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(awv awv) {
        this.O00000Oo.add(awv);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(T t, RecyclerView.O000OOo0 o000OOo0, ce ceVar) {
        ceVar.O000000o(new O000000o(this, t, o000OOo0, ceVar));
        O000000o(o000OOo0);
        ceVar.O00000o0();
    }

    private void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        if (o000OOo0 != null) {
            this.O00000o.add(o000OOo0);
            return;
        }
        throw new IllegalStateException("item is null");
    }

    public static class O000000o implements cf {

        /* renamed from: O000000o  reason: collision with root package name */
        private aws f12671O000000o;
        private awv O00000Oo;
        private ce O00000o;
        private RecyclerView.O000OOo0 O00000o0;

        public O000000o(aws aws, awv awv, RecyclerView.O000OOo0 o000OOo0, ce ceVar) {
            this.f12671O000000o = aws;
            this.O00000Oo = awv;
            this.O00000o0 = o000OOo0;
            this.O00000o = ceVar;
        }

        public final void O000000o(View view) {
            this.f12671O000000o.O00000o(this.O00000Oo, this.O00000o0);
        }

        public final void O00000Oo(View view) {
            aws aws = this.f12671O000000o;
            awv awv = this.O00000Oo;
            RecyclerView.O000OOo0 o000OOo0 = this.O00000o0;
            this.O00000o.O000000o((cf) null);
            this.f12671O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            aws.O00000o0(awv, o000OOo0);
            aws.O00000oO(awv, o000OOo0);
            awv.O000000o(o000OOo0);
            aws.O00000o.remove(o000OOo0);
            aws.O0000O0o();
        }

        public final void O00000o0(View view) {
            this.f12671O000000o.O000000o(this.O00000Oo, this.O00000o0);
        }
    }
}
