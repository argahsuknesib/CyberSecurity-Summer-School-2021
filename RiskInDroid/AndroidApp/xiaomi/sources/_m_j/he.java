package _m_j;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class he extends RecyclerView.O0000o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    RecyclerView f18829O000000o;
    private Scroller O00000Oo;
    private final RecyclerView.O00oOooO O00000o0 = new RecyclerView.O00oOooO() {
        /* class _m_j.he.AnonymousClass1 */

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f18830O000000o = false;

        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f18830O000000o) {
                this.f18830O000000o = false;
                he.this.O000000o();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f18830O000000o = true;
            }
        }
    };

    public abstract int O000000o(RecyclerView.LayoutManager layoutManager, int i, int i2);

    public abstract View O000000o(RecyclerView.LayoutManager layoutManager);

    public abstract int[] O000000o(RecyclerView.LayoutManager layoutManager, View view);

    public final boolean O000000o(int i, int i2) {
        boolean z;
        LinearSmoothScroller O00000Oo2;
        int O000000o2;
        RecyclerView.LayoutManager layoutManager = this.f18829O000000o.getLayoutManager();
        if (layoutManager == null || this.f18829O000000o.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f18829O000000o.getMinFlingVelocity();
        if (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) {
            if (!(layoutManager instanceof RecyclerView.O000OO00.O00000Oo) || (O00000Oo2 = O00000Oo(layoutManager)) == null || (O000000o2 = O000000o(layoutManager, i, i2)) == -1) {
                z = false;
            } else {
                O00000Oo2.setTargetPosition(O000000o2);
                layoutManager.startSmoothScroll(O00000Oo2);
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void O000000o(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f18829O000000o;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeOnScrollListener(this.O00000o0);
                this.f18829O000000o.setOnFlingListener(null);
            }
            this.f18829O000000o = recyclerView;
            RecyclerView recyclerView3 = this.f18829O000000o;
            if (recyclerView3 == null) {
                return;
            }
            if (recyclerView3.getOnFlingListener() == null) {
                this.f18829O000000o.addOnScrollListener(this.O00000o0);
                this.f18829O000000o.setOnFlingListener(this);
                this.O00000Oo = new Scroller(this.f18829O000000o.getContext(), new DecelerateInterpolator());
                O000000o();
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    public final int[] O00000Oo(int i, int i2) {
        this.O00000Oo.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.O00000Oo.getFinalX(), this.O00000Oo.getFinalY()};
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        RecyclerView.LayoutManager layoutManager;
        View O000000o2;
        RecyclerView recyclerView = this.f18829O000000o;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (O000000o2 = O000000o(layoutManager)) != null) {
            int[] O000000o3 = O000000o(layoutManager, O000000o2);
            if (O000000o3[0] != 0 || O000000o3[1] != 0) {
                this.f18829O000000o.smoothScrollBy(O000000o3[0], O000000o3[1]);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public LinearSmoothScroller O00000Oo(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.O000OO00.O00000Oo)) {
            return null;
        }
        return new LinearSmoothScroller(this.f18829O000000o.getContext()) {
            /* class _m_j.he.AnonymousClass2 */

            public final void onTargetFound(View view, RecyclerView.O000OO0o o000OO0o, RecyclerView.O000OO00.O000000o o000000o) {
                if (he.this.f18829O000000o != null) {
                    he heVar = he.this;
                    int[] O000000o2 = heVar.O000000o(heVar.f18829O000000o.getLayoutManager(), view);
                    int i = O000000o2[0];
                    int i2 = O000000o2[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        o000000o.O000000o(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }

            public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
