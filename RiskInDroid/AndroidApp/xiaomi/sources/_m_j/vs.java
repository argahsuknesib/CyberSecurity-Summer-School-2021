package _m_j;

import _m_j.vp;
import _m_j.vr;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import java.util.List;

public abstract class vs<T, V extends vr> extends vp<T, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected vz f2559O000000o;
    private SparseArray<vx> O0000o;

    /* access modifiers changed from: protected */
    public abstract int O000000o(Object obj);

    public abstract void O00000oO();

    public vs(List<T> list) {
        super(list);
    }

    public final void O00000o() {
        this.f2559O000000o = new vz();
        this.O0000o0o = new vy<T>() {
            /* class _m_j.vs.AnonymousClass1 */

            public final int O000000o(T t) {
                return vs.this.O000000o((Object) t);
            }
        };
        O00000oO();
        this.O0000o = this.f2559O000000o.f2566O000000o;
        int i = 0;
        while (i < this.O0000o.size()) {
            int keyAt = this.O0000o.keyAt(i);
            vx vxVar = this.O0000o.get(keyAt);
            vxVar.O00000Oo = this.O0000Ooo;
            vy<T> vyVar = this.O0000o0o;
            int O00000Oo = vxVar.O00000Oo();
            vyVar.O00000o = true;
            if (!vyVar.O00000o0) {
                if (vyVar.O00000Oo == null) {
                    vyVar.O00000Oo = new SparseIntArray();
                }
                vyVar.O00000Oo.put(keyAt, O00000Oo);
                i++;
            } else {
                throw new RuntimeException("Don't mess two register mode");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(V v, T t) {
        vx vxVar = this.O0000o.get(v.getItemViewType());
        vxVar.f2565O000000o = v.itemView.getContext();
        int layoutPosition = v.getLayoutPosition() - O00000Oo();
        vxVar.O000000o(v, t, layoutPosition);
        vp.O00000Oo o00000Oo = this.O00000oO;
        vp.O00000o0 o00000o0 = this.O00000oo;
        if (o00000Oo == null || o00000o0 == null) {
            View view = v.itemView;
            if (o00000Oo == null) {
                final vx vxVar2 = vxVar;
                final V v2 = v;
                final T t2 = t;
                final int i = layoutPosition;
                view.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.vs.AnonymousClass2 */

                    public final void onClick(View view) {
                        vxVar2.O00000Oo(v2, t2, i);
                    }
                });
            }
            if (o00000o0 == null) {
                final vx vxVar3 = vxVar;
                final V v3 = v;
                final T t3 = t;
                final int i2 = layoutPosition;
                view.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class _m_j.vs.AnonymousClass3 */

                    public final boolean onLongClick(View view) {
                        return vxVar3.O00000o0(v3, t3, i2);
                    }
                });
            }
        }
    }
}
