package _m_j;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

final class o00000 implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static o00000 O0000Oo;
    private static o00000 O0000OoO;

    /* renamed from: O000000o  reason: collision with root package name */
    private final View f2222O000000o;
    private final CharSequence O00000Oo;
    private final Runnable O00000o = new Runnable() {
        /* class _m_j.o00000.AnonymousClass1 */

        public final void run() {
            o00000.this.O000000o(false);
        }
    };
    private final int O00000o0;
    private final Runnable O00000oO = new Runnable() {
        /* class _m_j.o00000.AnonymousClass2 */

        public final void run() {
            o00000.this.O000000o();
        }
    };
    private int O00000oo;
    private int O0000O0o;
    private o0000 O0000OOo;
    private boolean O0000Oo0;

    public final void onViewAttachedToWindow(View view) {
    }

    public static void O000000o(View view, CharSequence charSequence) {
        o00000 o00000 = O0000Oo;
        if (o00000 != null && o00000.f2222O000000o == view) {
            O000000o((o00000) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            o00000 o000002 = O0000OoO;
            if (o000002 != null && o000002.f2222O000000o == view) {
                o000002.O000000o();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new o00000(view, charSequence);
    }

    private o00000(View view, CharSequence charSequence) {
        this.f2222O000000o = view;
        this.O00000Oo = charSequence;
        this.O00000o0 = cc.O00000Oo(ViewConfiguration.get(this.f2222O000000o.getContext()));
        O00000o();
        this.f2222O000000o.setOnLongClickListener(this);
        this.f2222O000000o.setOnHoverListener(this);
    }

    public final boolean onLongClick(View view) {
        this.O00000oo = view.getWidth() / 2;
        this.O0000O0o = view.getHeight() / 2;
        O000000o(true);
        return true;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.O0000OOo != null && this.O0000Oo0) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2222O000000o.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                O00000o();
                O000000o();
            }
        } else if (this.f2222O000000o.isEnabled() && this.O0000OOo == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.O00000oo) > this.O00000o0 || Math.abs(y - this.O0000O0o) > this.O00000o0) {
                this.O00000oo = x;
                this.O0000O0o = y;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                O000000o(this);
            }
        }
        return false;
    }

    public final void onViewDetachedFromWindow(View view) {
        O000000o();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        long j;
        int i;
        long j2;
        if (cb.O000OO0o(this.f2222O000000o)) {
            O000000o((o00000) null);
            o00000 o00000 = O0000OoO;
            if (o00000 != null) {
                o00000.O000000o();
            }
            O0000OoO = this;
            this.O0000Oo0 = z;
            this.O0000OOo = new o0000(this.f2222O000000o.getContext());
            this.O0000OOo.O000000o(this.f2222O000000o, this.O00000oo, this.O0000O0o, this.O0000Oo0, this.O00000Oo);
            this.f2222O000000o.addOnAttachStateChangeListener(this);
            if (this.O0000Oo0) {
                j = 2500;
            } else {
                if ((cb.O0000oo(this.f2222O000000o) & 1) == 1) {
                    j2 = 3000;
                    i = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    i = ViewConfiguration.getLongPressTimeout();
                }
                j = j2 - ((long) i);
            }
            this.f2222O000000o.removeCallbacks(this.O00000oO);
            this.f2222O000000o.postDelayed(this.O00000oO, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (O0000OoO == this) {
            O0000OoO = null;
            o0000 o0000 = this.O0000OOo;
            if (o0000 != null) {
                o0000.O000000o();
                this.O0000OOo = null;
                O00000o();
                this.f2222O000000o.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (O0000Oo == this) {
            O000000o((o00000) null);
        }
        this.f2222O000000o.removeCallbacks(this.O00000oO);
    }

    private static void O000000o(o00000 o00000) {
        o00000 o000002 = O0000Oo;
        if (o000002 != null) {
            o000002.O00000o0();
        }
        O0000Oo = o00000;
        if (o00000 != null) {
            O0000Oo.O00000Oo();
        }
    }

    private void O00000Oo() {
        this.f2222O000000o.postDelayed(this.O00000o, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void O00000o0() {
        this.f2222O000000o.removeCallbacks(this.O00000o);
    }

    private void O00000o() {
        this.O00000oo = Integer.MAX_VALUE;
        this.O0000O0o = Integer.MAX_VALUE;
    }
}
