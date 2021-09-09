package _m_j;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

public final class hru {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f572O000000o;
    int O00000Oo;
    int O00000o;
    int O00000o0;
    boolean O00000oO;
    public boolean O00000oo;
    private RecyclerView.O0000o O0000O0o = new RecyclerView.O0000o() {
        /* class _m_j.hru.AnonymousClass1 */

        public final void O000000o(boolean z) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            if (r1 != 3) goto L_0x005e;
         */
        public final boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent) {
            hru hru = hru.this;
            if (hru.O00000oO) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked == 2) {
                            if (!hru.f572O000000o) {
                                hru.O00000o0 = (int) (motionEvent.getY() + 0.5f);
                                int i = hru.O00000o0 - hru.O00000Oo;
                                if (hru.O00000oo && Math.abs(i) > hru.O00000o) {
                                    RecyclerView.O0000OOo itemAnimator = recyclerView.getItemAnimator();
                                    if (itemAnimator != null && itemAnimator.O00000Oo()) {
                                        hru.f572O000000o = true;
                                    }
                                }
                            }
                            if (hru.f572O000000o) {
                                return true;
                            }
                        }
                    }
                    hru.O000000o();
                } else {
                    int y = (int) (motionEvent.getY() + 0.5f);
                    hru.O00000o0 = y;
                    hru.O00000Oo = y;
                    hru.f572O000000o = false;
                }
            }
            return false;
        }

        public final void O00000Oo(RecyclerView recyclerView, MotionEvent motionEvent) {
            hru hru = hru.this;
            if (hru.O00000oO) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 1 || actionMasked == 3) {
                    hru.O000000o();
                }
            }
        }
    };
    private RecyclerView O0000OOo;

    private boolean O00000o0() {
        return this.O0000O0o == null;
    }

    public final void O000000o(RecyclerView recyclerView) {
        if (O00000o0()) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.O0000OOo == null) {
            this.O0000OOo = recyclerView;
            this.O0000OOo.addOnItemTouchListener(this.O0000O0o);
            this.O00000o = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
        } else {
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.f572O000000o = false;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
    }

    public final void O00000Oo() {
        if (!this.O00000oO) {
            this.O00000oO = true;
            if (!this.O00000oO) {
                O000000o();
            }
        }
    }
}
