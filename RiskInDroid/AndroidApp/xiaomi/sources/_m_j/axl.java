package _m_j;

import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

public final class axl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Interpolator f12682O000000o = new axd();
    public static final Interpolator O00000Oo = new DecelerateInterpolator();
    public Interpolator O00000o = f12682O000000o;
    public RecyclerView O00000o0;
    public O00000o0 O00000oO = new O00000o0(this);
    public RecyclerView.O0000o O00000oo = new RecyclerView.O0000o() {
        /* class _m_j.axl.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent, boolean):boolean
         arg types: [androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent, int]
         candidates:
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, int, int):void
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent, boolean):boolean */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.axl.O000000o(int, boolean):boolean
         arg types: [int, int]
         candidates:
          _m_j.axl.O000000o(android.view.View, boolean):java.lang.Integer
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):void
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):void
          _m_j.axl.O000000o(int, boolean):boolean */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            if (r1 != 3) goto L_0x00c7;
         */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0069  */
        public final boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            axl axl = axl.this;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (axl.O000000o()) {
                            axl.O000000o(recyclerView, motionEvent);
                            return true;
                        }
                        if (axl.O0000o0) {
                            z2 = axl.O000000o(recyclerView, motionEvent, true);
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            return true;
                        }
                    }
                }
                axl.O000000o(actionMasked, true);
            } else if (!axl.O000000o()) {
                RecyclerView.O000OOo0 O000000o2 = ayd.O000000o(recyclerView, motionEvent.getX(), motionEvent.getY());
                if (O000000o2 instanceof axf) {
                    int adapterPosition = O000000o2.getAdapterPosition();
                    RecyclerView.O000000o adapter = recyclerView.getAdapter();
                    if (adapterPosition >= 0 && adapterPosition < adapter.getItemCount() && O000000o2.getItemId() == adapter.getItemId(adapterPosition)) {
                        z = true;
                        if (z) {
                            int O00000Oo = ayd.O00000Oo(axl.O00000o0.getLayoutManager());
                            int O00000Oo2 = ayd.O00000Oo(axl.O00000o0);
                            int x = (int) (motionEvent.getX() + 0.5f);
                            axl.O0000oo = x;
                            axl.O0000Oo = x;
                            int y = (int) (motionEvent.getY() + 0.5f);
                            axl.O0000ooO = y;
                            axl.O0000OoO = y;
                            axl.O0000Ooo = O000000o2.getItemId();
                            axl.O00oOooo = O00000Oo == 0 || (O00000Oo == 1 && O00000Oo2 > 1);
                            axl.O000O00o = O00000Oo == 1 || (O00000Oo == 0 && O00000Oo2 > 1);
                            if (axl.O0000o00) {
                                O000000o o000000o = axl.O0000ooo;
                                int i = axl.O0000o0O;
                                o000000o.O000000o();
                                o000000o.O00000Oo = MotionEvent.obtain(motionEvent);
                                o000000o.sendEmptyMessageAtTime(1, motionEvent.getDownTime() + ((long) i));
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
            return false;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.axl.O000000o(int, boolean):boolean
         arg types: [int, int]
         candidates:
          _m_j.axl.O000000o(android.view.View, boolean):java.lang.Integer
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):void
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):void
          _m_j.axl.O000000o(int, boolean):boolean */
        public final void O00000Oo(RecyclerView recyclerView, MotionEvent motionEvent) {
            axl axl = axl.this;
            int actionMasked = motionEvent.getActionMasked();
            if (axl.O000000o()) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        axl.O000000o(recyclerView, motionEvent);
                        return;
                    } else if (actionMasked != 3) {
                        return;
                    }
                }
                axl.O000000o(actionMasked, true);
            }
        }

        public final void O000000o(boolean z) {
            axl axl = axl.this;
            if (z) {
                axl.O000000o(true);
            }
        }
    };
    public RecyclerView.O00oOooO O0000O0o = new RecyclerView.O00oOooO() {
        /* class _m_j.axl.AnonymousClass2 */

        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            axl axl = axl.this;
            if (i == 1) {
                axl.O000000o(true);
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            axl axl = axl.this;
            if (axl.O0000o) {
                axl.O0000oO0 = i;
                axl.O0000oO = i2;
            } else if (axl.O000000o()) {
                cb.O000000o(axl.O00000o0, axl.O000O0OO, 500);
            }
        }
    };
    public axc O0000OOo;
    int O0000Oo;
    public NinePatchDrawable O0000Oo0;
    int O0000OoO;
    long O0000Ooo = -1;
    boolean O0000o;
    public boolean O0000o0 = true;
    public boolean O0000o00;
    public int O0000o0O = ViewConfiguration.getLongPressTimeout();
    public boolean O0000o0o;
    int O0000oO;
    int O0000oO0;
    public axg O0000oOO;
    RecyclerView.O000OOo0 O0000oOo;
    int O0000oo;
    axh O0000oo0;
    int O0000ooO;
    public O000000o O0000ooo;
    boolean O000O00o;
    final Runnable O000O0OO = new Runnable() {
        /* class _m_j.axl.AnonymousClass3 */

        public final void run() {
            if (axl.this.O0000oOo != null) {
                axl axl = axl.this;
                axl.O00000Oo(axl.O00000o0);
            }
        }
    };
    private float O000O0Oo;
    private final Rect O000O0o = new Rect();
    private int O000O0o0;
    private int O000O0oO = 200;
    private Interpolator O000O0oo = O00000Oo;
    private int O000OO;
    private axi O000OO00;
    private axm O000OO0o;
    private int O000OOOo;
    private int O000OOo;
    private int O000OOo0;
    private int O000OOoO;
    private int O000OOoo;
    private int O000Oo0;
    private int O000Oo00;
    private int O000Oo0O = 0;
    private int O000Oo0o;
    private O00000o O000OoO = new O00000o();
    private axj O000OoO0;
    private float O00O0Oo = 1.0f;
    private int O00oOoOo;
    public O00000Oo O00oOooO;
    boolean O00oOooo;

    public interface O00000Oo {
    }

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public RecyclerView.O000OOo0 f12687O000000o;
        public int O00000Oo;
        public boolean O00000o0;

        O00000o() {
        }

        public final void O000000o() {
            this.f12687O000000o = null;
            this.O00000Oo = -1;
            this.O00000o0 = false;
        }
    }

    public final RecyclerView.O000000o O000000o(RecyclerView.O000000o o000000o) {
        if (!o000000o.hasStableIds()) {
            throw new IllegalArgumentException("The passed adapter does not support stable IDs");
        } else if (this.O0000oOO == null) {
            this.O0000oOO = new axg(this, o000000o);
            return this.O0000oOO;
        } else {
            throw new IllegalStateException("already have a wrapped adapter");
        }
    }

    public final boolean O000000o() {
        return this.O000OO00 != null && !this.O0000ooo.hasMessages(2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axl.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.axl.O000000o(android.view.View, boolean):java.lang.Integer
      _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):void
      _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):void
      _m_j.axl.O000000o(int, boolean):boolean */
    public final void O000000o(boolean z) {
        O000000o(3, false);
        if (z) {
            O00000Oo(false);
        } else if (O000000o()) {
            this.O0000ooo.O00000Oo();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, int):void
     arg types: [androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, float):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, int):void */
    private void O00000Oo(boolean z) {
        if (O000000o()) {
            O000000o o000000o = this.O0000ooo;
            if (o000000o != null) {
                o000000o.removeMessages(2);
            }
            RecyclerView recyclerView = this.O00000o0;
            if (!(recyclerView == null || this.O0000oOo == null)) {
                cb.O00000o0((View) recyclerView, this.O000Oo0o);
            }
            axh axh = this.O0000oo0;
            if (axh != null) {
                axh.f12675O000000o = this.O000O0oO;
                axh.O00000Oo = this.O000O0oo;
                axh.O000000o();
            }
            axm axm = this.O000OO0o;
            if (axm != null) {
                axm.f12675O000000o = this.O000O0oO;
                this.O0000oo0.O00000Oo = this.O000O0oo;
                axm.O00000Oo();
            }
            axc axc = this.O0000OOo;
            if (axc != null) {
                axc.O00000Oo();
            }
            O00000o0();
            RecyclerView recyclerView2 = this.O00000o0;
            if (!(recyclerView2 == null || recyclerView2.getParent() == null)) {
                this.O00000o0.getParent().requestDisallowInterceptTouchEvent(false);
            }
            RecyclerView recyclerView3 = this.O00000o0;
            if (recyclerView3 != null) {
                recyclerView3.invalidate();
            }
            this.O000OoO0 = null;
            this.O0000oo0 = null;
            this.O000OO0o = null;
            this.O0000oOo = null;
            this.O000OO00 = null;
            this.O0000oo = 0;
            this.O0000ooO = 0;
            this.O000OO = 0;
            this.O000OOOo = 0;
            this.O000OOo0 = 0;
            this.O000OOo = 0;
            this.O000OOoO = 0;
            this.O000OOoo = 0;
            this.O000Oo00 = 0;
            this.O000Oo0 = 0;
            this.O00oOooo = false;
            this.O000O00o = false;
            axg axg = this.O0000oOO;
            if (axg != null) {
                axg.O000000o(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int i, boolean z) {
        boolean z2 = i == 1;
        O000000o o000000o = this.O0000ooo;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000oo = 0;
        this.O0000ooO = 0;
        this.O000OO = 0;
        this.O000OOOo = 0;
        this.O000OOo0 = 0;
        this.O000OOo = 0;
        this.O000OOoO = 0;
        this.O000OOoo = 0;
        this.O000Oo00 = 0;
        this.O000Oo0 = 0;
        this.O0000Ooo = -1;
        this.O00oOooo = false;
        this.O000O00o = false;
        if (z && O000000o()) {
            O00000Oo(z2);
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, int):void
     arg types: [androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, float):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, int):void */
    /* access modifiers changed from: package-private */
    public final boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent, boolean z) {
        RecyclerView.O000OOo0 O000000o2;
        int O000000o3;
        axl axl;
        RecyclerView recyclerView2;
        if (this.O000OO00 != null) {
            return false;
        }
        int x = (int) (motionEvent.getX() + 0.5f);
        int y = (int) (motionEvent.getY() + 0.5f);
        this.O0000oo = x;
        this.O0000ooO = y;
        if (this.O0000Ooo == -1) {
            return false;
        }
        if ((z && ((!this.O00oOooo || Math.abs(x - this.O0000Oo) <= this.O00oOoOo) && (!this.O000O00o || Math.abs(y - this.O0000OoO) <= this.O00oOoOo))) || (O000000o2 = ayd.O000000o(recyclerView, (float) this.O0000Oo, (float) this.O0000OoO)) == null || (O000000o3 = ayd.O000000o(O000000o2)) == -1) {
            return false;
        }
        View view = O000000o2.itemView;
        if (!this.O0000oOO.f12679O000000o.O000000o(O000000o2, O000000o3, x - (view.getLeft() + ((int) (cb.O0000o00(view) + 0.5f))), y - (view.getTop() + ((int) (cb.O0000o0(view) + 0.5f))))) {
            return false;
        }
        axj O000000o4 = this.O0000oOO.f12679O000000o.O000000o(O000000o2, O000000o3);
        if (O000000o4 == null) {
            O000000o4 = new axj(0, Math.max(0, this.O0000oOO.getItemCount() - 1));
        }
        int max = Math.max(0, this.O0000oOO.getItemCount() - 1);
        if (O000000o4.f12681O000000o > O000000o4.O00000Oo) {
            throw new IllegalStateException("Invalid range specified --- start > range (range = " + O000000o4 + ")");
        } else if (O000000o4.f12681O000000o < 0) {
            throw new IllegalStateException("Invalid range specified --- start < 0 (range = " + O000000o4 + ")");
        } else if (O000000o4.O00000Oo > max) {
            throw new IllegalStateException("Invalid range specified --- end >= count (range = " + O000000o4 + ")");
        } else if (O000000o4.O000000o(O000000o2.getAdapterPosition())) {
            RecyclerView.O0000OOo itemAnimator = recyclerView != null ? recyclerView.getItemAnimator() : null;
            if (itemAnimator != null) {
                itemAnimator.O00000o0(O000000o2);
            }
            this.O0000ooo.O000000o();
            this.O000OO00 = new axi(O000000o2, this.O0000oo, this.O0000ooO);
            this.O0000oOo = O000000o2;
            this.O000OoO0 = O000000o4;
            this.O000Oo0o = cb.O000000o((View) recyclerView);
            cb.O00000o0((View) recyclerView, 2);
            this.O0000oo = (int) (motionEvent.getX() + 0.5f);
            this.O0000ooO = (int) (motionEvent.getY() + 0.5f);
            int i = this.O0000ooO;
            this.O000OOoo = i;
            this.O000OOo = i;
            this.O000OOOo = i;
            int i2 = this.O0000oo;
            this.O000OOoO = i2;
            this.O000OOo0 = i2;
            this.O000OO = i2;
            this.O000Oo0O = 0;
            this.O00000o0.getParent().requestDisallowInterceptTouchEvent(true);
            O00000o0 o00000o0 = this.O00000oO;
            if (!(o00000o0.O00000Oo || (axl = o00000o0.f12688O000000o.get()) == null || (recyclerView2 = axl.O00000o0) == null)) {
                cb.O000000o(recyclerView2, o00000o0);
                o00000o0.O00000Oo = true;
            }
            axg axg = this.O0000oOO;
            axi axi = this.O000OO00;
            axj axj = this.O000OoO0;
            if (O000000o2.getItemId() != -1) {
                int adapterPosition = O000000o2.getAdapterPosition();
                axg.O00000oo = adapterPosition;
                axg.O00000oO = adapterPosition;
                axg.O00000o0 = axi;
                axg.O00000Oo = O000000o2;
                axg.O00000o = axj;
                axg.notifyDataSetChanged();
                this.O0000oOO.onBindViewHolder(O000000o2, O000000o2.getLayoutPosition());
                this.O0000oo0 = new axh(this.O00000o0, O000000o2, this.O000OoO0);
                axh axh = this.O0000oo0;
                axh.O0000OoO = this.O0000Oo0;
                if (axh.O0000OoO != null) {
                    axh.O0000OoO.getPadding(axh.O0000Ooo);
                }
                this.O0000oo0.O000000o(motionEvent, this.O000OO00);
                int O000000o5 = ayd.O000000o(this.O00000o0.getLayoutManager());
                if (O00000o() && !this.O0000o0o && (O000000o5 == 1 || O000000o5 == 0)) {
                    this.O000OO0o = new axm(this.O00000o0, O000000o2, this.O000OoO0, this.O000OO00);
                    axm axm = this.O000OO0o;
                    axm.O00000oO = this.O00000o;
                    axm.O000000o();
                    this.O000OO0o.O000000o(this.O0000oo0.O00000oO, this.O0000oo0.O00000oo);
                }
                axc axc = this.O0000OOo;
                if (axc != null && axc.O00000o) {
                    axc.f12677O000000o.removeItemDecoration(axc);
                    axc.f12677O000000o.addItemDecoration(axc);
                }
                return true;
            }
            throw new IllegalStateException("dragging target must provides valid ID");
        } else {
            throw new IllegalStateException("Invalid range specified --- does not contain drag target item (range = " + O000000o4 + ", position = " + O000000o2.getAdapterPosition() + ")");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axh.O000000o(android.view.MotionEvent, boolean):boolean
     arg types: [android.view.MotionEvent, int]
     candidates:
      _m_j.axh.O000000o(float, int):void
      _m_j.axh.O000000o(android.view.MotionEvent, _m_j.axi):void
      _m_j.axb.O000000o(android.view.View, boolean):void
      _m_j.axh.O000000o(android.view.MotionEvent, boolean):boolean */
    /* access modifiers changed from: package-private */
    public final void O000000o(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.O0000oo = (int) (motionEvent.getX() + 0.5f);
        this.O0000ooO = (int) (motionEvent.getY() + 0.5f);
        this.O000OOo0 = Math.min(this.O000OOo0, this.O0000oo);
        this.O000OOo = Math.min(this.O000OOo, this.O0000ooO);
        this.O000OOoO = Math.max(this.O000OOoO, this.O0000oo);
        this.O000OOoo = Math.max(this.O000OOoo, this.O0000ooO);
        if (ayd.O00000Oo(this.O00000o0.getLayoutManager()) == 1) {
            int i = this.O000OOOo - this.O000OOo;
            int i2 = this.O000O0o0;
            if (i > i2 || this.O000OOoo - this.O0000ooO > i2) {
                this.O000Oo0O |= 1;
            }
            int i3 = this.O000OOoo - this.O000OOOo;
            int i4 = this.O000O0o0;
            if (i3 > i4 || this.O0000ooO - this.O000OOo > i4) {
                this.O000Oo0O |= 2;
            }
        } else if (ayd.O00000Oo(this.O00000o0.getLayoutManager()) == 0) {
            int i5 = this.O000OO - this.O000OOo0;
            int i6 = this.O000O0o0;
            if (i5 > i6 || this.O000OOoO - this.O0000oo > i6) {
                this.O000Oo0O |= 4;
            }
            int i7 = this.O000OOoO - this.O000OO;
            int i8 = this.O000O0o0;
            if (i7 > i8 || this.O0000oo - this.O000OOo0 > i8) {
                this.O000Oo0O |= 8;
            }
        }
        if (this.O0000oo0.O000000o(motionEvent, false)) {
            axm axm = this.O000OO0o;
            if (axm != null) {
                axm.O000000o(this.O0000oo0.O00000oO, this.O0000oo0.O00000oo);
            }
            O00000Oo(recyclerView);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(RecyclerView recyclerView) {
        boolean z;
        RecyclerView.O000OOo0 o000OOo0 = this.O0000oOo;
        int i = this.O0000oo - this.O000OO00.O00000oo;
        int i2 = this.O0000ooO - this.O000OO00.O0000O0o;
        int i3 = this.O0000oOO.O00000oO;
        int i4 = this.O0000oOO.O00000oo;
        O00000o O000000o2 = O000000o(this.O000OoO, recyclerView, o000OOo0, this.O000OO00, i, i2, this.O000OoO0, this.O0000o0o, false);
        if (O000000o2.O00000Oo != -1) {
            boolean z2 = !this.O0000o0o;
            if (!z2) {
                z2 = this.O0000oOO.O00000o(i3, O000000o2.O00000Oo);
            }
            z = z2;
            if (!z) {
                O000000o2 = O000000o(this.O000OoO, recyclerView, o000OOo0, this.O000OO00, i, i2, this.O000OoO0, this.O0000o0o, true);
                if (O000000o2.O00000Oo != -1) {
                    z = this.O0000oOO.O00000o(i3, O000000o2.O00000Oo);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            O000000o(recyclerView, i4, o000OOo0, O000000o2.f12687O000000o);
        }
        axm axm = this.O000OO0o;
        if (axm != null) {
            axm.O000000o(z ? O000000o2.f12687O000000o : null);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x016a, code lost:
        if (r13 != false) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0179, code lost:
        if (r13 != false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0183, code lost:
        if (r13 != false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ae, code lost:
        if ((r7 & (r20 ? 8 : 2)) == 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bd, code lost:
        if ((r7 & (r20 ? 4 : 1)) == 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0160, code lost:
        if (r13 != false) goto L_0x016c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0115  */
    public final void O000000o(RecyclerView recyclerView, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
        if (width != 0) {
            float f3 = 1.0f / ((float) width);
            float f4 = (((float) (z ? this.O0000oo : this.O0000ooO)) * f3) - 0.5f;
            int i5 = this.O000Oo0O;
            axh axh = this.O0000oo0;
            int signum = ((int) Math.signum(f4)) * ((int) ((this.O00O0Oo * 25.0f * this.O000O0Oo * Math.max(0.0f, 0.3f - (0.5f - Math.abs(f4))) * 3.3333333f) + 0.5f));
            axj axj = this.O000OoO0;
            RecyclerView.LayoutManager layoutManager = this.O00000o0.getLayoutManager();
            int findFirstCompletelyVisibleItemPosition = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() : -1;
            RecyclerView.LayoutManager layoutManager2 = this.O00000o0.getLayoutManager();
            int findLastCompletelyVisibleItemPosition = layoutManager2 instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition() : -1;
            boolean z6 = false;
            if (findFirstCompletelyVisibleItemPosition != -1) {
                boolean z7 = findFirstCompletelyVisibleItemPosition <= axj.f12681O000000o;
                if (findFirstCompletelyVisibleItemPosition <= axj.f12681O000000o - 1) {
                    z2 = z7;
                    z3 = true;
                } else {
                    z2 = z7;
                    z3 = false;
                }
            } else {
                z3 = false;
                z2 = false;
            }
            if (findLastCompletelyVisibleItemPosition != -1) {
                z4 = findLastCompletelyVisibleItemPosition >= axj.O00000Oo;
                z5 = findLastCompletelyVisibleItemPosition >= axj.O00000Oo + 1;
            } else {
                z5 = false;
                z4 = false;
            }
            if (signum <= 0) {
                if (signum < 0) {
                }
                if ((!z3 || signum >= 0) && (z5 || signum <= 0)) {
                    axh.O00000Oo(false);
                    i = 0;
                } else {
                    if (this.O000OO0o != null) {
                        O00000o0(recyclerView);
                    }
                    if (z) {
                        this.O0000oO0 = 0;
                        this.O0000o = true;
                        this.O00000o0.scrollBy(signum, 0);
                        this.O0000o = false;
                        i = this.O0000oO0;
                    } else {
                        this.O0000oO = 0;
                        this.O0000o = true;
                        this.O00000o0.scrollBy(0, signum);
                        this.O0000o = false;
                        i = this.O0000oO;
                    }
                    if (signum < 0) {
                        axh.O00000Oo(!z2);
                    } else {
                        axh.O00000Oo(!z4);
                    }
                    axh.O000000o(true);
                    axm axm = this.O000OO0o;
                    if (axm != null) {
                        axm.O000000o(axh.O00000oO, axh.O00000oo);
                    }
                }
                boolean z8 = i == 0;
                if (this.O0000OOo != null) {
                    if (z) {
                        i2 = axh.O00000oO;
                    } else {
                        i2 = axh.O00000oo;
                    }
                    if (z) {
                        i4 = axh.O00000oO;
                        i3 = axh.O0000o00.f12680O000000o;
                    } else {
                        i4 = axh.O00000oo;
                        i3 = axh.O0000o00.O00000Oo;
                    }
                    int i6 = i4 + i3;
                    int i7 = (i2 + i6) / 2;
                    if (!(findFirstCompletelyVisibleItemPosition == 0 && findLastCompletelyVisibleItemPosition == 0) ? i7 >= width / 2 : signum >= 0) {
                        i6 = i2;
                    }
                    float f5 = (((float) i6) * f3) - 0.5f;
                    if (Math.abs(f5) > 0.4f && signum != 0 && !z8) {
                        if (f5 < 0.0f) {
                            if (z) {
                                if (axh.O00000oO == axh.O0000O0o) {
                                    z6 = true;
                                }
                            } else if (axh.O00000oo == axh.O0000Oo0) {
                                z6 = true;
                            }
                            f2 = -this.O000O0Oo;
                        } else {
                            if (z) {
                                if (axh.O00000oO == axh.O0000OOo) {
                                    z6 = true;
                                }
                            } else if (axh.O00000oo == axh.O0000Oo) {
                                z6 = true;
                            }
                            f2 = this.O000O0Oo;
                        }
                        f = f2 * 0.005f;
                        if (f != 0.0f) {
                            this.O0000OOo.O00000Oo();
                        } else if (f < 0.0f) {
                            axc axc = this.O0000OOo;
                            RecyclerView recyclerView2 = axc.f12677O000000o;
                            if (axc.O00000Oo == null) {
                                axc.O00000Oo = new EdgeEffectCompat(recyclerView2.getContext());
                            }
                            axc.O000000o(recyclerView2, axc.O00000Oo, axc.O00000oO);
                            axc.O00000Oo.O00000Oo(f);
                            cb.O00000oo(axc.f12677O000000o);
                        } else {
                            axc axc2 = this.O0000OOo;
                            RecyclerView recyclerView3 = axc2.f12677O000000o;
                            if (axc2.O00000o0 == null) {
                                axc2.O00000o0 = new EdgeEffectCompat(recyclerView3.getContext());
                            }
                            axc.O000000o(recyclerView3, axc2.O00000o0, axc2.O00000oo);
                            axc2.O00000o0.O00000Oo(f);
                            cb.O00000oo(axc2.f12677O000000o);
                        }
                    }
                    f = 0.0f;
                    if (f != 0.0f) {
                    }
                }
                cb.O000000o(this.O00000o0, this.O000O0OO);
                if (i != 0) {
                    return;
                }
                if (z) {
                    this.O000Oo00 += i;
                    return;
                } else {
                    this.O000Oo0 += i;
                    return;
                }
            }
            signum = 0;
            if (!z3) {
            }
            axh.O00000Oo(false);
            i = 0;
            if (i == 0) {
            }
            if (this.O0000OOo != null) {
            }
            cb.O000000o(this.O00000o0, this.O000O0OO);
            if (i != 0) {
            }
        }
    }

    private void O00000o0() {
        O00000o0 o00000o0 = this.O00000oO;
        if (o00000o0 != null) {
            o00000o0.O000000o();
        }
    }

    private void O000000o(RecyclerView recyclerView, int i, RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02) {
        Rect O000000o2 = ayd.O000000o(o000OOo02.itemView, this.O000O0o);
        int adapterPosition = o000OOo02.getAdapterPosition();
        int abs = Math.abs(i - adapterPosition);
        if (i != -1 && adapterPosition != -1 && recyclerView.getAdapter().getItemId(i) == this.O000OO00.O00000o0) {
            boolean z = false;
            boolean z2 = ayd.O00000Oo(ayd.O000000o(recyclerView.getLayoutManager())) && (!O00000o() || !this.O0000o0o);
            if (abs != 0) {
                if (abs == 1 && o000OOo0 != null && z2) {
                    View view = o000OOo0.itemView;
                    View view2 = o000OOo02.itemView;
                    Rect rect = this.O000OO00.O0000OOo;
                    if (this.O00oOooo) {
                        int min = Math.min(view.getLeft() - rect.left, view2.getLeft() - O000000o2.left);
                        float max = ((float) min) + (((float) (Math.max(view.getRight() + rect.right, view2.getRight() + O000000o2.right) - min)) * 0.5f);
                        float f = ((float) (this.O0000oo - this.O000OO00.O00000oo)) + (((float) this.O000OO00.f12680O000000o) * 0.5f);
                        if (adapterPosition >= i ? f > max : f < max) {
                            z = true;
                        }
                    }
                    if (!z && this.O000O00o) {
                        int min2 = Math.min(view.getTop() - rect.top, view2.getTop() - O000000o2.top);
                        float max2 = ((float) min2) + (((float) (Math.max(view.getBottom() + rect.bottom, view2.getBottom() + O000000o2.bottom) - min2)) * 0.5f);
                        float f2 = ((float) (this.O0000ooO - this.O000OO00.O0000O0o)) + (((float) this.O000OO00.O00000Oo) * 0.5f);
                        if (adapterPosition >= i) {
                        }
                    }
                }
                z = true;
            }
            if (z) {
                O000000o(recyclerView, i, adapterPosition);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):int
     arg types: [androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      _m_j.ayd.O000000o(android.view.View, android.graphics.Rect):android.graphics.Rect
      _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView$LayoutManager, int):android.view.View
      _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):int */
    private void O000000o(RecyclerView recyclerView, int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.O00000o0.getLayoutManager();
        boolean z = true;
        if (ayd.O000000o(ayd.O000000o(this.O00000o0.getLayoutManager())) != 1) {
            z = false;
        }
        int O000000o2 = ayd.O000000o(this.O00000o0, false);
        View O000000o3 = ayd.O000000o(layoutManager, i);
        View O000000o4 = ayd.O000000o(layoutManager, i2);
        View O000000o5 = ayd.O000000o(layoutManager, O000000o2);
        Integer O000000o6 = O000000o(O000000o3, z);
        Integer O000000o7 = O000000o(O000000o4, z);
        Integer O000000o8 = O000000o(O000000o5, z);
        this.O0000oOO.O00000oO(i, i2);
        if (O000000o2 == i && O000000o8 != null && O000000o7 != null) {
            recyclerView.scrollBy(0, -(O000000o7.intValue() - O000000o8.intValue()));
            O00000o0(recyclerView);
        } else if (O000000o2 == i2 && O000000o3 != null && O000000o6 != null && !O000000o6.equals(O000000o7)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) O000000o3.getLayoutParams();
            recyclerView.scrollBy(0, -(layoutManager.getDecoratedMeasuredHeight(O000000o3) + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin));
            O00000o0(recyclerView);
        }
    }

    private static Integer O000000o(View view, boolean z) {
        if (view == null) {
            return null;
        }
        return Integer.valueOf(z ? view.getTop() : view.getLeft());
    }

    private static boolean O00000o() {
        return Build.VERSION.SDK_INT >= 11;
    }

    private static void O00000o0(RecyclerView recyclerView) {
        RecyclerView.O0000OOo itemAnimator = recyclerView != null ? recyclerView.getItemAnimator() : null;
        if (itemAnimator != null) {
            itemAnimator.O00000o();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b1  */
    private static O00000o O000000o(O00000o o00000o, RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, axi axi, int i, int i2, axj axj, boolean z, boolean z2) {
        RecyclerView.O000OOo0 o000OOo02;
        int i3;
        int i4;
        O00000o o00000o2 = o00000o;
        RecyclerView.O000OOo0 o000OOo03 = o000OOo0;
        axi axi2 = axi;
        axj axj2 = axj;
        o00000o.O000000o();
        RecyclerView.O000OOo0 o000OOo04 = null;
        if (o000OOo03 == null || (o000OOo0.getAdapterPosition() != -1 && o000OOo0.getItemId() == axi2.O00000o0)) {
            int O000000o2 = ayd.O000000o(recyclerView.getLayoutManager());
            boolean z3 = ayd.O000000o(O000000o2) == 1;
            if (z3) {
                i3 = i2;
                i4 = Math.min(Math.max(i, recyclerView.getPaddingLeft()), Math.max(0, (recyclerView.getWidth() - recyclerView.getPaddingRight()) - axi2.f12680O000000o));
            } else {
                i4 = i;
                i3 = Math.min(Math.max(i2, recyclerView.getPaddingTop()), Math.max(0, (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - axi2.O00000Oo));
            }
            if (O000000o2 == 0 || O000000o2 == 1) {
                o000OOo02 = O000000o(recyclerView, o000OOo0, axi, i4, i3, z3, z, z2);
                if (o000OOo02 == o000OOo03) {
                    o00000o2.O00000o0 = true;
                    o000OOo02 = null;
                }
                if (o000OOo02 == null || axj2 == null || axj2.O000000o(o000OOo02.getAdapterPosition())) {
                    o000OOo04 = o000OOo02;
                }
                o00000o2.f12687O000000o = o000OOo04;
                o00000o2.O00000Oo = ayd.O00000Oo(o000OOo04);
                return o00000o2;
            } else if (O000000o2 == 2 || O000000o2 == 3) {
                o000OOo02 = O000000o(recyclerView, axi, i4, i3, z3, z2);
                if (o000OOo02 == o000OOo03) {
                }
                o000OOo04 = o000OOo02;
                o00000o2.f12687O000000o = o000OOo04;
                o00000o2.O00000Oo = ayd.O00000Oo(o000OOo04);
                return o00000o2;
            } else if (O000000o2 == 4 || O000000o2 == 5) {
                o000OOo02 = O000000o(recyclerView, o000OOo0, axi, i4, i3, z3, z2);
                if (o000OOo02 == o000OOo03) {
                }
                o000OOo04 = o000OOo02;
                o00000o2.f12687O000000o = o000OOo04;
                o00000o2.O00000Oo = ayd.O00000Oo(o000OOo04);
                return o00000o2;
            }
        }
        o000OOo02 = null;
        if (o000OOo02 == o000OOo03) {
        }
        o000OOo04 = o000OOo02;
        o00000o2.f12687O000000o = o000OOo04;
        o00000o2.O00000Oo = ayd.O00000Oo(o000OOo04);
        return o00000o2;
    }

    private static RecyclerView.O000OOo0 O000000o(RecyclerView recyclerView, axi axi, int i, int i2, boolean z, boolean z2) {
        if (z2) {
            return null;
        }
        RecyclerView.O000OOo0 O000000o2 = O000000o(recyclerView, axi, i, i2, z);
        return O000000o2 == null ? O00000Oo(recyclerView, axi, i, i2, z) : O000000o2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0158  */
    private static RecyclerView.O000OOo0 O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, axi axi, int i, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        RecyclerView.O000OOo0 o000OOo02;
        RecyclerView.O000OOo0 o000OOo03;
        int i5;
        RecyclerView.O000OOo0 o000OOo04;
        RecyclerView.O000OOo0 o000OOo05;
        int i6;
        RecyclerView.O000OOo0 o000OOo06;
        RecyclerView.O000OOo0 o000OOo07;
        int i7;
        RecyclerView.O000OOo0 o000OOo08;
        int i8;
        RecyclerView recyclerView2 = recyclerView;
        RecyclerView.O000OOo0 o000OOo09 = o000OOo0;
        axi axi2 = axi;
        if (z2 || o000OOo09 == null) {
            return null;
        }
        int O00000Oo2 = ayd.O00000Oo(recyclerView);
        int O00000o02 = ayd.O00000o0(o000OOo0);
        int i9 = 0;
        if (z) {
            int i10 = i + 1;
            int i11 = (i + axi2.f12680O000000o) - 2;
            int paddingLeft = recyclerView.getPaddingLeft();
            float width = ((float) ((recyclerView.getWidth() - paddingLeft) - recyclerView.getPaddingRight())) * (1.0f / ((float) O00000Oo2));
            int i12 = O00000Oo2 - 1;
            i5 = Math.min(Math.max((int) (((float) ((i10 - axi2.O0000OOo.left) - paddingLeft)) / width), 0), i12);
            i6 = Math.min(Math.max((int) (((float) ((i11 - axi2.O0000OOo.right) - paddingLeft)) / width), 0), i12);
            int top = o000OOo09.itemView.getTop();
            float f = (float) i10;
            float f2 = (float) (i2 + 1);
            o000OOo03 = ayd.O000000o(recyclerView2, f, f2);
            float f3 = (float) ((i2 + (axi2.O00000Oo / 2)) - 1);
            RecyclerView.O000OOo0 O000000o2 = ayd.O000000o(recyclerView2, f, f3);
            float f4 = (float) ((i2 + axi2.O00000Oo) - 2);
            RecyclerView.O000OOo0 O000000o3 = ayd.O000000o(recyclerView2, f, f4);
            float f5 = (float) i11;
            RecyclerView.O000OOo0 O000000o4 = ayd.O000000o(recyclerView2, f5, f2);
            o000OOo02 = ayd.O000000o(recyclerView2, f5, f3);
            RecyclerView.O000OOo0 O000000o5 = ayd.O000000o(recyclerView2, f5, f4);
            i4 = i2;
            int i13 = top;
            o000OOo06 = O000000o5;
            o000OOo07 = O000000o4;
            o000OOo04 = O000000o3;
            o000OOo05 = O000000o2;
            i3 = i13;
        } else {
            int i14 = i + 1;
            int i15 = (i + axi2.f12680O000000o) - 2;
            int paddingTop = recyclerView.getPaddingTop();
            float height = ((float) ((recyclerView.getHeight() - paddingTop) - recyclerView.getPaddingBottom())) * (1.0f / ((float) O00000Oo2));
            int i16 = O00000Oo2 - 1;
            i5 = Math.min(Math.max((int) (((float) ((i14 - axi2.O0000OOo.top) - paddingTop)) / height), 0), i16);
            i6 = Math.min(Math.max((int) (((float) ((i15 - axi2.O0000OOo.left) - paddingTop)) / height), 0), i16);
            int left = o000OOo09.itemView.getLeft();
            float f6 = (float) i14;
            float f7 = (float) (i2 + 1);
            RecyclerView.O000OOo0 O000000o6 = ayd.O000000o(recyclerView2, f6, f7);
            float f8 = (float) ((i + (axi2.f12680O000000o / 2)) - 1);
            RecyclerView.O000OOo0 O000000o7 = ayd.O000000o(recyclerView2, f8, f7);
            float f9 = (float) i15;
            o000OOo04 = ayd.O000000o(recyclerView2, f9, f7);
            float f10 = (float) ((i2 + axi2.O00000Oo) - 2);
            RecyclerView.O000OOo0 O000000o8 = ayd.O000000o(recyclerView2, f6, f10);
            RecyclerView.O000OOo0 O000000o9 = ayd.O000000o(recyclerView2, f8, f10);
            RecyclerView.O000OOo0 O000000o10 = ayd.O000000o(recyclerView2, f9, f10);
            i4 = i;
            int i17 = left;
            o000OOo06 = O000000o10;
            o000OOo07 = O000000o8;
            o000OOo05 = O000000o7;
            i3 = i17;
            RecyclerView.O000OOo0 o000OOo010 = O000000o6;
            o000OOo02 = O000000o9;
            o000OOo03 = o000OOo010;
        }
        if (o000OOo05 != null) {
            i7 = o000OOo05 == o000OOo03 ? 3 : 1;
            if (o000OOo05 == o000OOo04) {
                i7 |= 4;
            }
        } else {
            i7 = 0;
        }
        if (o000OOo02 != null) {
            i9 = o000OOo02 == o000OOo07 ? 3 : 1;
            if (o000OOo02 == o000OOo06) {
                i9 |= 4;
            }
        }
        int bitCount = Integer.bitCount(i7);
        int bitCount2 = Integer.bitCount(i9);
        if (i5 != O00000o02 && i5 == i6) {
            if (bitCount == 3) {
                o000OOo08 = o000OOo05;
            } else if (bitCount2 == 3) {
                o000OOo08 = o000OOo02;
            }
            if (o000OOo08 != null) {
                i8 = 2;
                if (bitCount != 2 || bitCount2 == 2) {
                    if (bitCount2 == 2 && bitCount != 2) {
                        o000OOo05 = o000OOo02;
                    }
                }
                if (o000OOo05 == null && O00000o02 == ayd.O00000o0(o000OOo05) && (i4 > i3 ? ((i7 | i9) & 4) != 0 : ((i7 | i9) & i8) != 0)) {
                    return null;
                }
                return o000OOo05;
            }
            i8 = 2;
            o000OOo05 = o000OOo08;
            if (o000OOo05 == null) {
            }
            return o000OOo05;
        }
        o000OOo08 = null;
        if (o000OOo08 != null) {
        }
        o000OOo05 = o000OOo08;
        if (o000OOo05 == null) {
        }
        return o000OOo05;
    }

    private static RecyclerView.O000OOo0 O000000o(RecyclerView recyclerView, axi axi, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            int i5 = axi.O0000OOo.left;
            i3 = i + ((int) ((((float) ((axi.f12680O000000o + (axi.O0000OOo.right + i5)) / axi.O0000Oo0)) * 0.5f) - ((float) i5)));
            i4 = axi.O00000Oo / 2;
        } else {
            int i6 = axi.O0000OOo.top;
            int i7 = axi.O0000OOo.bottom;
            i3 = i + (axi.f12680O000000o / 2);
            i4 = (int) ((((float) ((axi.O00000Oo + (i7 + i6)) / axi.O0000Oo0)) * 0.5f) - ((float) i6));
        }
        return ayd.O000000o(recyclerView, (float) i3, (float) (i2 + i4));
    }

    private static RecyclerView.O000OOo0 O00000Oo(RecyclerView recyclerView, axi axi, int i, int i2, boolean z) {
        int O00000Oo2 = ayd.O00000Oo(recyclerView);
        int height = recyclerView.getHeight();
        int width = recyclerView.getWidth();
        int i3 = 0;
        int paddingLeft = z ? recyclerView.getPaddingLeft() : 0;
        int paddingTop = !z ? recyclerView.getPaddingTop() : 0;
        int paddingRight = z ? recyclerView.getPaddingRight() : 0;
        if (!z) {
            i3 = recyclerView.getPaddingBottom();
        }
        int i4 = ((width - paddingLeft) - paddingRight) / O00000Oo2;
        int i5 = ((height - paddingTop) - i3) / O00000Oo2;
        int i6 = i + (axi.f12680O000000o / 2);
        int i7 = i2 + (axi.O00000Oo / 2);
        for (int i8 = O00000Oo2 - 1; i8 >= 0; i8--) {
            RecyclerView.O000OOo0 O000000o2 = ayd.O000000o(recyclerView, (float) (z ? (i4 * i8) + paddingLeft + (i4 / 2) : i6), (float) (!z ? (i5 * i8) + paddingTop + (i5 / 2) : i7));
            if (O000000o2 != null) {
                int itemCount = recyclerView.getLayoutManager().getItemCount();
                int adapterPosition = O000000o2.getAdapterPosition();
                if (adapterPosition == -1 || adapterPosition != itemCount - 1) {
                    return null;
                }
                return O000000o2;
            }
        }
        return null;
    }

    private static RecyclerView.O000OOo0 O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, axi axi, int i, int i2, boolean z, boolean z2, boolean z3) {
        if (o000OOo0 == null) {
            return null;
        }
        if (z2 || z3) {
            float f = o000OOo0.itemView.getResources().getDisplayMetrics().density * 8.0f;
            float min = Math.min(((float) axi.f12680O000000o) * 0.2f, f);
            float min2 = Math.min(((float) axi.O00000Oo) * 0.2f, f);
            float f2 = ((float) i) + (((float) axi.f12680O000000o) * 0.5f);
            float f3 = ((float) i2) + (((float) axi.O00000Oo) * 0.5f);
            RecyclerView.O000OOo0 O000000o2 = ayd.O000000o(recyclerView, f2 - min, f3 - min2);
            if (O000000o2 == ayd.O000000o(recyclerView, f2 + min, f3 + min2)) {
                return O000000o2;
            }
            return null;
        }
        int adapterPosition = o000OOo0.getAdapterPosition();
        int top = z ? o000OOo0.itemView.getTop() : o000OOo0.itemView.getLeft();
        if (z) {
            i = i2;
        }
        if (i < top) {
            if (adapterPosition > 0) {
                return recyclerView.findViewHolderForAdapterPosition(adapterPosition - 1);
            }
            return null;
        } else if (i <= top || adapterPosition >= recyclerView.getAdapter().getItemCount() - 1) {
            return null;
        } else {
            return recyclerView.findViewHolderForAdapterPosition(adapterPosition + 1);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.O0000oOo = null;
        this.O0000oo0.O00000Oo();
    }

    public static class O00000o0 implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final WeakReference<axl> f12688O000000o;
        public boolean O00000Oo;

        public O00000o0(axl axl) {
            this.f12688O000000o = new WeakReference<>(axl);
        }

        public final void O000000o() {
            if (this.O00000Oo) {
                this.O00000Oo = false;
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):void
         arg types: [androidx.recyclerview.widget.RecyclerView, int]
         candidates:
          _m_j.axl.O000000o(android.view.View, boolean):java.lang.Integer
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):void
          _m_j.axl.O000000o(int, boolean):boolean
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):void */
        public final void run() {
            axl axl = this.f12688O000000o.get();
            if (axl != null && this.O00000Oo) {
                RecyclerView recyclerView = axl.O00000o0;
                int O00000Oo2 = ayd.O00000Oo(recyclerView.getLayoutManager());
                if (O00000Oo2 == 0) {
                    axl.O000000o(recyclerView, true);
                } else if (O00000Oo2 == 1) {
                    axl.O000000o(recyclerView, false);
                }
                RecyclerView recyclerView2 = axl.O00000o0;
                if (recyclerView2 == null || !this.O00000Oo) {
                    this.O00000Oo = false;
                } else {
                    cb.O000000o(recyclerView2, this);
                }
            }
        }
    }

    public static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        public axl f12686O000000o;
        MotionEvent O00000Oo;

        public O000000o(axl axl) {
            this.f12686O000000o = axl;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent, boolean):boolean
         arg types: [androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent, int]
         candidates:
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, int, int):void
          _m_j.axl.O000000o(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent, boolean):boolean */
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                axl axl = this.f12686O000000o;
                MotionEvent motionEvent = this.O00000Oo;
                if (axl.O0000o00) {
                    axl.O000000o(axl.O00000o0, motionEvent, false);
                }
            } else if (i == 2) {
                this.f12686O000000o.O000000o(true);
            }
        }

        public final void O000000o() {
            removeMessages(1);
            MotionEvent motionEvent = this.O00000Oo;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.O00000Oo = null;
            }
        }

        public final void O00000Oo() {
            if (!hasMessages(2)) {
                sendEmptyMessage(2);
            }
        }
    }

    public final void O000000o(RecyclerView recyclerView) {
        boolean z = false;
        if (this.O00000oo == null) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.O00000o0 != null) {
            throw new IllegalStateException("RecyclerView instance has already been set");
        } else if (this.O0000oOO == null || ((axg) aye.O000000o(recyclerView.getAdapter(), axg.class)) != this.O0000oOO) {
            throw new IllegalStateException("adapter is not set properly");
        } else {
            this.O00000o0 = recyclerView;
            this.O00000o0.addOnScrollListener(this.O0000O0o);
            this.O00000o0.addOnItemTouchListener(this.O00000oo);
            this.O000O0Oo = this.O00000o0.getResources().getDisplayMetrics().density;
            this.O00oOoOo = ViewConfiguration.get(this.O00000o0.getContext()).getScaledTouchSlop();
            this.O000O0o0 = (int) ((((float) this.O00oOoOo) * 1.5f) + 0.5f);
            this.O0000ooo = new O000000o(this);
            if (Build.VERSION.SDK_INT >= 14) {
                z = true;
            }
            if (z) {
                int O00000Oo2 = ayd.O00000Oo(this.O00000o0.getLayoutManager());
                if (O00000Oo2 == 0) {
                    this.O0000OOo = new axk(this.O00000o0);
                } else if (O00000Oo2 == 1) {
                    this.O0000OOo = new axn(this.O00000o0);
                }
                axc axc = this.O0000OOo;
                if (axc != null) {
                    axc.O000000o();
                }
            }
        }
    }
}
