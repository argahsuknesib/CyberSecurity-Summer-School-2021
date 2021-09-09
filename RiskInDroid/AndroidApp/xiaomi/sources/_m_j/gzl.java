package _m_j;

import _m_j.gs;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class gzl extends RecyclerView.O000000o implements gzn {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<gzm> f18620O000000o = new ArrayList();
    public gzm O00000Oo;
    private final RecyclerView.O0000Oo O00000o = new RecyclerView.O0000Oo() {
        /* class _m_j.gzl.AnonymousClass3 */

        public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            try {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                if (gridLayoutManager != null) {
                    for (int i = 0; i < gridLayoutManager.getItemCount(); i++) {
                        View findViewByPosition = gridLayoutManager.findViewByPosition(i);
                        if (findViewByPosition != null) {
                            gzm O000000o2 = gzl.this.O000000o(gzl.this.getItemViewType(i));
                            O000000o2.O000000o(canvas, recyclerView, findViewByPosition, i - gzl.this.O00000o0(O000000o2), o000OO0o);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            try {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                if (gridLayoutManager != null) {
                    for (int i = 0; i < gridLayoutManager.getItemCount(); i++) {
                        if (gridLayoutManager.getChildAt(i) != null) {
                            gzl.this.O00000o0(gzl.this.O000000o(gzl.this.getItemViewType(i)));
                            gridLayoutManager.getChildAt(i);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            try {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                gzm O000000o2 = gzl.this.O000000o(gzl.this.getItemViewType(childAdapterPosition));
                O000000o2.O000000o(rect, view, childAdapterPosition - gzl.this.O00000o0(O000000o2), recyclerView, o000OO0o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private gs O00000o0;

    public final void O000000o(gzm gzm) {
        if (!this.f18620O000000o.contains(gzm)) {
            gzm.O0000O0o = this;
            this.f18620O000000o.add(gzm);
        }
    }

    public final int O000000o(gzm gzm, int i) {
        if (gzm != null && (this.f18620O000000o.contains(gzm) || gzm == this.O00000Oo)) {
            return O00000o0(gzm) + i;
        }
        return -1;
    }

    public final void O00000Oo(gzm gzm) {
        this.O00000Oo = gzm;
        gzm.O0000O0o = this;
    }

    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return O000000o(i).onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        gzm O000000o2 = O000000o(getItemViewType(i));
        O000000o2.onBindViewHolder(o000OOo0, i - O00000o0(O000000o2));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List list) {
        gzm O000000o2 = O000000o(getItemViewType(i));
        O000000o2.onBindViewHolder(o000OOo0, i - O00000o0(O000000o2), list);
    }

    public final gzm O000000o(int i) {
        for (gzm next : this.f18620O000000o) {
            if (next.hashCode() == i) {
                return next;
            }
        }
        O000000o(this.O00000Oo == null, "illegal viewType: ".concat(String.valueOf(i)));
        return this.O00000Oo;
    }

    public final int O00000o0(gzm gzm) {
        if (gzm != null && gzm == this.O00000Oo) {
            return 0;
        }
        int i = 0;
        for (gzm next : this.f18620O000000o) {
            if (gzm == next) {
                return i;
            }
            i += next.getItemCount();
        }
        O000000o(this.O00000Oo == null, "illegal target: ".concat(String.valueOf(gzm)));
        return 0;
    }

    public int getItemViewType(int i) {
        boolean z = false;
        int i2 = 0;
        for (gzm next : this.f18620O000000o) {
            i2 += next.getItemCount();
            if (i < i2) {
                return next.hashCode();
            }
        }
        if (this.O00000Oo == null) {
            z = true;
        }
        O000000o(z, "illegal position: ".concat(String.valueOf(i)));
        return this.O00000Oo.hashCode();
    }

    public int getItemCount() {
        gzm gzm;
        int i = 0;
        for (gzm itemCount : this.f18620O000000o) {
            i += itemCount.getItemCount();
        }
        return (i != 0 || (gzm = this.O00000Oo) == null) ? i : gzm.getItemCount();
    }

    /* access modifiers changed from: protected */
    public int O000000o() {
        int i;
        gzm gzm;
        int[] iArr = new int[this.f18620O000000o.size()];
        for (int i2 = 0; i2 < this.f18620O000000o.size(); i2++) {
            iArr[i2] = this.f18620O000000o.get(i2).O000000o();
        }
        if (this.f18620O000000o.size() != 0 || (gzm = this.O00000Oo) == null) {
            int i3 = iArr[0];
            for (int i4 = 1; i4 < iArr.length; i4++) {
                int i5 = iArr[i4];
                int i6 = i3 * i5;
                while (true) {
                    int i7 = i3 % i5;
                    if (i7 == 0) {
                        break;
                    }
                    int i8 = i5;
                    i5 = i7;
                    i3 = i8;
                }
                i3 = i6 / i5;
            }
            i = i3;
        } else {
            i = gzm.O000000o();
        }
        return i * 2;
    }

    private void O000000o(boolean z, String str) {
        if (z) {
            String deepToString = Arrays.deepToString(this.f18620O000000o.toArray());
            throw new IllegalStateException(deepToString + " : " + str);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        for (gzm onAttachedToRecyclerView : this.f18620O000000o) {
            onAttachedToRecyclerView.onAttachedToRecyclerView(recyclerView);
        }
        gzm gzm = this.O00000Oo;
        if (gzm != null) {
            gzm.onAttachedToRecyclerView(recyclerView);
        }
        if (((GridLayoutManager) recyclerView.getLayoutManager()) != null) {
            recyclerView.addItemDecoration(this.O00000o);
            O00000Oo(recyclerView);
            O00000o0(recyclerView);
            return;
        }
        throw new RuntimeException("setAdapter should be invoked after setLayoutManager");
    }

    private void O00000Oo(RecyclerView recyclerView) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (gridLayoutManager != null) {
            final int O000000o2 = O000000o();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.O00000Oo() {
                /* class _m_j.gzl.AnonymousClass1 */

                public final int getSpanSize(int i) {
                    gzl gzl = gzl.this;
                    gzm O000000o2 = gzl.O000000o(gzl.getItemViewType(i));
                    int O000000o3 = O000000o2.O000000o();
                    int k_ = O000000o2.k_();
                    if (k_ != -1) {
                        return k_;
                    }
                    return O000000o2 / O000000o3;
                }
            });
            gridLayoutManager.setSpanCount(O000000o2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void O00000o0(final RecyclerView recyclerView) {
        this.O00000o0 = new gs(new gs.O000000o() {
            /* class _m_j.gzl.AnonymousClass2 */
            private int O00000o = Integer.MIN_VALUE;
            private int O00000o0 = Integer.MAX_VALUE;
            private final Interpolator O00000oO = new Interpolator() {
                /* class _m_j.gzl.AnonymousClass2.AnonymousClass1 */

                public final float getInterpolation(float f) {
                    float f2 = f - 1.0f;
                    return (f2 * f2 * f2) + 1.0f;
                }
            };
            private final Interpolator O00000oo = new Interpolator() {
                /* class _m_j.gzl.AnonymousClass2.AnonymousClass2 */

                public final float getInterpolation(float f) {
                    return f * f * f * f * f;
                }
            };

            public final boolean O000000o() {
                return false;
            }

            public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
                try {
                    return gzl.this.O000000o(gzl.this.getItemViewType(o000OOo0.getAdapterPosition())).O000000o(recyclerView, o000OOo0);
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }

            public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02) {
                if (o000OOo0.getClass() != o000OOo02.getClass()) {
                    return false;
                }
                int adapterPosition = o000OOo0.getAdapterPosition();
                int adapterPosition2 = o000OOo02.getAdapterPosition();
                gzl gzl = gzl.this;
                gzm O000000o2 = gzl.O000000o(gzl.getItemViewType(adapterPosition));
                gzl gzl2 = gzl.this;
                gzm O000000o3 = gzl2.O000000o(gzl2.getItemViewType(adapterPosition2));
                if (O000000o2 != O000000o3) {
                    return false;
                }
                this.O00000o0 = Math.min(Math.min(adapterPosition, adapterPosition2), this.O00000o0);
                this.O00000o = Math.max(Math.max(adapterPosition, adapterPosition2), this.O00000o);
                int O00000o02 = gzl.this.O00000o0(O000000o2);
                return O000000o3.O000000o(adapterPosition - O00000o02, adapterPosition2 - O00000o02);
            }

            public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
                int adapterPosition = o000OOo0.getAdapterPosition();
                gzl gzl = gzl.this;
                gzl.this.O00000o0(gzl.O000000o(gzl.getItemViewType(adapterPosition)));
            }

            public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
                super.O000000o(o000OOo0, i);
                if (i == 0) {
                    for (gzm O0000OOo : gzl.this.f18620O000000o) {
                        O0000OOo.O0000OOo();
                    }
                    if (gzl.this.O00000Oo != null) {
                        gzl.this.O00000Oo.O0000OOo();
                    }
                }
                if (i != 0 || this.O00000o0 == Integer.MAX_VALUE || this.O00000o == Integer.MIN_VALUE) {
                    if (i == 2) {
                        int adapterPosition = o000OOo0.getAdapterPosition();
                        gzl gzl = gzl.this;
                        gzl.this.O00000o0(gzl.O000000o(gzl.getItemViewType(adapterPosition)));
                    }
                } else if (!recyclerView.isComputingLayout()) {
                    gzl gzl2 = gzl.this;
                    int i2 = this.O00000o0;
                    gzl2.notifyItemRangeChanged(i2, (this.O00000o - i2) + 1);
                    this.O00000o0 = Integer.MAX_VALUE;
                    this.O00000o = Integer.MIN_VALUE;
                }
            }

            public final void O00000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
                super.O00000o(recyclerView, o000OOo0);
                int adapterPosition = o000OOo0.getAdapterPosition();
                gzl gzl = gzl.this;
                gzm O000000o2 = gzl.O000000o(gzl.getItemViewType(adapterPosition));
                O000000o2.O000000o(recyclerView, o000OOo0, adapterPosition - gzl.this.O00000o0(O000000o2));
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(float, float):float}
             arg types: [int, float]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(long, long):long}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(float, float):float} */
            public final int O000000o(RecyclerView recyclerView, int i, int i2, int i3, long j) {
                int dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.dimen_15);
                float min = Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i));
                int signum = (int) (((float) (((int) Math.signum((float) i2)) * dimensionPixelSize)) * this.O00000oO.getInterpolation(min));
                gsy.O000000o(4, "DelegateAdapter", "interpolateOutOfBoundsScroll: cappedScroll " + signum + " " + min + " " + this.O00000oO.getInterpolation(min));
                if (signum == 0) {
                    return i2 > 0 ? 1 : -1;
                }
                gsy.O000000o(4, "DelegateAdapter", "interpolateOutOfBoundsScroll: " + i + " " + i2 + " " + i3 + " " + j + " value = " + signum);
                return signum;
            }
        });
        this.O00000o0.O000000o(recyclerView);
        for (gzm O000000o2 : this.f18620O000000o) {
            O000000o2.O000000o(this.O00000o0);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        for (gzm onDetachedFromRecyclerView : this.f18620O000000o) {
            onDetachedFromRecyclerView.onDetachedFromRecyclerView(recyclerView);
        }
        gzm gzm = this.O00000Oo;
        if (gzm != null) {
            gzm.onDetachedFromRecyclerView(recyclerView);
        }
        recyclerView.removeItemDecoration(this.O00000o);
        recyclerView.setOnTouchListener(null);
        gs gsVar = this.O00000o0;
        if (gsVar != null) {
            gsVar.O000000o((RecyclerView) null);
            this.O00000o0 = null;
        }
    }

    public final void O000000o(gzm gzm, int i, int i2) {
        gsy.O00000Oo("DelegateAdapter", "onChildAdapterItemRangeChanged: " + gzm.getClass().getSimpleName());
        notifyItemRangeChanged(O00000o0(gzm) + i, i2);
    }

    public final void O000000o(gzm gzm, int i, int i2, Object obj) {
        gsy.O00000Oo("DelegateAdapter", "onChildAdapterItemRangeChanged: " + gzm.getClass().getSimpleName());
        notifyItemRangeChanged(O00000o0(gzm) + i, i2, obj);
    }

    public final void O00000Oo(gzm gzm, int i, int i2) {
        gsy.O00000Oo("DelegateAdapter", "onChildAdapterItemRangeInserted: " + gzm.getClass().getSimpleName());
        notifyItemRangeInserted(O00000o0(gzm) + i, i2);
    }

    public final void O00000o0(gzm gzm, int i, int i2) {
        gsy.O00000Oo("DelegateAdapter", "onChildAdapterItemRangeRemoved: " + gzm.getClass().getSimpleName());
        notifyItemRangeRemoved(O00000o0(gzm) + i, i2);
    }

    public final void O00000o(gzm gzm, int i, int i2) {
        gsy.O00000Oo("DelegateAdapter", "onChildAdapterItemRangeMoved: " + gzm.getClass().getSimpleName());
        int O00000o02 = O00000o0(gzm);
        notifyItemMoved(i + O00000o02, O00000o02 + i2);
    }

    public final void O00000o(gzm gzm) {
        gsy.O00000Oo("DelegateAdapter", "onChildAdapterChanged: " + gzm.getClass().getSimpleName());
        notifyItemRangeChanged(O00000o0(gzm), gzm.getItemCount());
    }

    public final boolean O00000oO(gzm gzm) {
        if (gzm == this.O00000Oo) {
            return true;
        }
        int indexOf = this.f18620O000000o.indexOf(gzm);
        for (int i = 0; i < indexOf; i++) {
            if (this.f18620O000000o.get(i).l_()) {
                return false;
            }
        }
        return true;
    }

    public final <C extends gzm> C O000000o(Class cls) {
        Iterator<gzm> it = this.f18620O000000o.iterator();
        while (it.hasNext()) {
            C c = (gzm) it.next();
            if (cls.isInstance(c)) {
                return c;
            }
        }
        return null;
    }

    public final <C extends gzm> C O000000o(String str) {
        Iterator<gzm> it = this.f18620O000000o.iterator();
        while (it.hasNext()) {
            C c = (gzm) it.next();
            if (TextUtils.equals(c.O0000OOo, str)) {
                return c;
            }
        }
        return null;
    }

    public final void O000000o(RecyclerView recyclerView) {
        for (gzm O000000o2 : this.f18620O000000o) {
            O000000o2.O000000o(recyclerView);
        }
        gzm gzm = this.O00000Oo;
        if (gzm != null) {
            gzm.O000000o(recyclerView);
        }
        O00000Oo(recyclerView);
    }

    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        try {
            O000000o(getItemViewType(o000OOo0.getAdapterPosition())).onViewAttachedToWindow(o000OOo0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        try {
            O000000o(getItemViewType(o000OOo0.getAdapterPosition())).onViewDetachedFromWindow(o000OOo0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onViewRecycled(RecyclerView.O000OOo0 o000OOo0) {
        try {
            O000000o(getItemViewType(o000OOo0.getAdapterPosition())).onViewRecycled(o000OOo0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.O000OOo0 o000OOo0) {
        try {
            return O000000o(getItemViewType(o000OOo0.getAdapterPosition())).onFailedToRecycleView(o000OOo0);
        } catch (Exception e) {
            e.printStackTrace();
            return super.onFailedToRecycleView(o000OOo0);
        }
    }
}
