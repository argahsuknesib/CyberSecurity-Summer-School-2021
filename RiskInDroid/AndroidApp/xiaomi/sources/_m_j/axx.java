package _m_j;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

public final class axx {

    /* renamed from: O000000o  reason: collision with root package name */
    public RecyclerView.O0000o f12691O000000o = new RecyclerView.O0000o() {
        /* class _m_j.axx.AnonymousClass1 */

        public final void O000000o(boolean z) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            if (r1 != 3) goto L_0x005e;
         */
        public final boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent) {
            axx axx = axx.this;
            if (axx.O0000O0o) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked == 2) {
                            if (!axx.O00000o0) {
                                axx.O00000oO = (int) (motionEvent.getY() + 0.5f);
                                int i = axx.O00000oO - axx.O00000o;
                                if (axx.O0000OOo && Math.abs(i) > axx.O00000oo) {
                                    RecyclerView.O0000OOo itemAnimator = recyclerView.getItemAnimator();
                                    if (itemAnimator != null && itemAnimator.O00000Oo()) {
                                        axx.O00000o0 = true;
                                    }
                                }
                            }
                            if (axx.O00000o0) {
                                return true;
                            }
                        }
                    }
                    axx.O000000o();
                } else {
                    int y = (int) (motionEvent.getY() + 0.5f);
                    axx.O00000oO = y;
                    axx.O00000o = y;
                    axx.O00000o0 = false;
                }
            }
            return false;
        }

        public final void O00000Oo(RecyclerView recyclerView, MotionEvent motionEvent) {
            axx axx = axx.this;
            if (axx.O0000O0o) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 1 || actionMasked == 3) {
                    axx.O000000o();
                }
            }
        }
    };
    public RecyclerView O00000Oo;
    int O00000o;
    boolean O00000o0;
    int O00000oO;
    int O00000oo;
    boolean O0000O0o;
    public boolean O0000OOo;

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.O00000o0 = false;
        this.O00000o = 0;
        this.O00000oO = 0;
    }

    public final void O00000Oo() {
        if (!this.O0000O0o) {
            this.O0000O0o = true;
            if (!this.O0000O0o) {
                O000000o();
            }
        }
    }

    public final void O000000o(RecyclerView recyclerView) {
        if (this.f12691O000000o == null) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.O00000Oo == null) {
            this.O00000Oo = recyclerView;
            this.O00000Oo.addOnItemTouchListener(this.f12691O000000o);
            this.O00000oo = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
        } else {
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
    }
}
