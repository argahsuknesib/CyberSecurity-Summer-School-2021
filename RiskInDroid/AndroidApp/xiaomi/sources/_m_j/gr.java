package _m_j;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class gr implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ThreadLocal<gr> f18171O000000o = new ThreadLocal<>();
    static Comparator<O00000Oo> O00000oO = new Comparator<O00000Oo>() {
        /* class _m_j.gr.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            O00000Oo o00000Oo = (O00000Oo) obj;
            O00000Oo o00000Oo2 = (O00000Oo) obj2;
            if ((o00000Oo.O00000o == null) != (o00000Oo2.O00000o == null)) {
                return o00000Oo.O00000o == null ? 1 : -1;
            }
            if (o00000Oo.f18173O000000o != o00000Oo2.f18173O000000o) {
                return o00000Oo.f18173O000000o ? -1 : 1;
            }
            int i = o00000Oo2.O00000Oo - o00000Oo.O00000Oo;
            if (i != 0) {
                return i;
            }
            int i2 = o00000Oo.O00000o0 - o00000Oo2.O00000o0;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    public ArrayList<RecyclerView> O00000Oo = new ArrayList<>();
    public long O00000o;
    long O00000o0;
    private ArrayList<O00000Oo> O00000oo = new ArrayList<>();

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f18173O000000o;
        public int O00000Oo;
        public RecyclerView O00000o;
        public int O00000o0;
        public int O00000oO;

        O00000Oo() {
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class O000000o implements RecyclerView.LayoutManager.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f18172O000000o;
        int O00000Oo;
        int O00000o;
        int[] O00000o0;

        /* access modifiers changed from: package-private */
        public final void O000000o(RecyclerView recyclerView, boolean z) {
            this.O00000o = 0;
            int[] iArr = this.O00000o0;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.O00000o()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.f18172O000000o, this.O00000Oo, recyclerView.mState, this);
                }
                if (this.O00000o > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = this.O00000o;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.O00000Oo();
                }
            }
        }

        public final void O000000o(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.O00000o * 2;
                int[] iArr = this.O00000o0;
                if (iArr == null) {
                    this.O00000o0 = new int[4];
                    Arrays.fill(this.O00000o0, -1);
                } else if (i3 >= iArr.length) {
                    this.O00000o0 = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.O00000o0, 0, iArr.length);
                }
                int[] iArr2 = this.O00000o0;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.O00000o++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public final boolean O000000o(int i) {
            if (this.O00000o0 != null) {
                int i2 = this.O00000o * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.O00000o0[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void O000000o() {
            int[] iArr = this.O00000o0;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.O00000o = 0;
        }
    }

    public final void O000000o(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.O00000o0 == 0) {
            this.O00000o0 = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        O000000o o000000o = recyclerView.mPrefetchRegistry;
        o000000o.f18172O000000o = i;
        o000000o.O00000Oo = i2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gr.O000000o.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):void
     arg types: [androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      _m_j.gr.O000000o.O000000o(int, int):void
      androidx.recyclerview.widget.RecyclerView.LayoutManager.O000000o.O000000o(int, int):void
      _m_j.gr.O000000o.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):void */
    public final void run() {
        RecyclerView recyclerView;
        O00000Oo o00000Oo;
        long j = 0;
        try {
            as.O000000o("RV Prefetch");
            if (!this.O00000Oo.isEmpty()) {
                int size = this.O00000Oo.size();
                long j2 = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView2 = this.O00000Oo.get(i);
                    if (recyclerView2.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView2.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j2) + this.O00000o;
                    int size2 = this.O00000Oo.size();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size2; i3++) {
                        RecyclerView recyclerView3 = this.O00000Oo.get(i3);
                        if (recyclerView3.getWindowVisibility() == 0) {
                            recyclerView3.mPrefetchRegistry.O000000o(recyclerView3, false);
                            i2 += recyclerView3.mPrefetchRegistry.O00000o;
                        }
                    }
                    this.O00000oo.ensureCapacity(i2);
                    int i4 = 0;
                    for (int i5 = 0; i5 < size2; i5++) {
                        RecyclerView recyclerView4 = this.O00000Oo.get(i5);
                        if (recyclerView4.getWindowVisibility() == 0) {
                            O000000o o000000o = recyclerView4.mPrefetchRegistry;
                            int abs = Math.abs(o000000o.f18172O000000o) + Math.abs(o000000o.O00000Oo);
                            int i6 = i4;
                            int i7 = 0;
                            while (i7 < o000000o.O00000o * 2) {
                                if (i6 >= this.O00000oo.size()) {
                                    o00000Oo = new O00000Oo();
                                    this.O00000oo.add(o00000Oo);
                                } else {
                                    o00000Oo = this.O00000oo.get(i6);
                                }
                                int i8 = o000000o.O00000o0[i7 + 1];
                                try {
                                    o00000Oo.f18173O000000o = i8 <= abs;
                                    o00000Oo.O00000Oo = abs;
                                    o00000Oo.O00000o0 = i8;
                                    o00000Oo.O00000o = recyclerView4;
                                    o00000Oo.O00000oO = o000000o.O00000o0[i7];
                                    i6++;
                                    i7 += 2;
                                } catch (Throwable th) {
                                    th = th;
                                    j = 0;
                                    this.O00000o0 = j;
                                    as.O000000o();
                                    throw th;
                                }
                            }
                            i4 = i6;
                        }
                    }
                    Collections.sort(this.O00000oo, O00000oO);
                    for (int i9 = 0; i9 < this.O00000oo.size(); i9++) {
                        O00000Oo o00000Oo2 = this.O00000oo.get(i9);
                        if (o00000Oo2.O00000o == null) {
                            break;
                        }
                        RecyclerView.O000OOo0 O000000o2 = O000000o(o00000Oo2.O00000o, o00000Oo2.O00000oO, o00000Oo2.f18173O000000o ? Long.MAX_VALUE : nanos);
                        if (!(O000000o2 == null || O000000o2.mNestedRecyclerView == null || !O000000o2.isBound() || O000000o2.isInvalid() || (recyclerView = O000000o2.mNestedRecyclerView.get()) == null)) {
                            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.O00000Oo() != 0) {
                                recyclerView.removeAndRecycleViews();
                            }
                            O000000o o000000o2 = recyclerView.mPrefetchRegistry;
                            o000000o2.O000000o(recyclerView, true);
                            if (o000000o2.O00000o != 0) {
                                as.O000000o("RV Nested Prefetch");
                                RecyclerView.O000OO0o o000OO0o = recyclerView.mState;
                                RecyclerView.O000000o o000000o3 = recyclerView.mAdapter;
                                o000OO0o.O00000o = 1;
                                o000OO0o.O00000oO = o000000o3.getItemCount();
                                o000OO0o.O0000O0o = false;
                                o000OO0o.O0000OOo = false;
                                o000OO0o.O0000Oo0 = false;
                                for (int i10 = 0; i10 < o000000o2.O00000o * 2; i10 += 2) {
                                    O000000o(recyclerView, o000000o2.O00000o0[i10], nanos);
                                }
                                as.O000000o();
                            }
                        }
                        o00000Oo2.f18173O000000o = false;
                        o00000Oo2.O00000Oo = 0;
                        o00000Oo2.O00000o0 = 0;
                        o00000Oo2.O00000o = null;
                        o00000Oo2.O00000oO = 0;
                    }
                    j = 0;
                }
            }
            this.O00000o0 = j;
            as.O000000o();
        } catch (Throwable th2) {
            th = th2;
            this.O00000o0 = j;
            as.O000000o();
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean, long):androidx.recyclerview.widget.RecyclerView$O000OOo0
     arg types: [int, int, long]
     candidates:
      androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(long, int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
      androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean, long):androidx.recyclerview.widget.RecyclerView$O000OOo0 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
     arg types: [androidx.recyclerview.widget.RecyclerView$O000OOo0, int]
     candidates:
      androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
      androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void
      androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void */
    private static RecyclerView.O000OOo0 O000000o(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int O00000Oo2 = recyclerView.mChildHelper.O00000Oo();
        int i2 = 0;
        while (true) {
            if (i2 >= O00000Oo2) {
                z = false;
                break;
            }
            RecyclerView.O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.O00000o0(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.O000O0OO o000o0oo = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.O000OOo0 O000000o2 = o000o0oo.O000000o(i, false, j);
            if (O000000o2 != null) {
                if (!O000000o2.isBound() || O000000o2.isInvalid()) {
                    o000o0oo.O000000o(O000000o2, false);
                } else {
                    o000o0oo.O000000o(O000000o2.itemView);
                }
            }
            return O000000o2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }
}
