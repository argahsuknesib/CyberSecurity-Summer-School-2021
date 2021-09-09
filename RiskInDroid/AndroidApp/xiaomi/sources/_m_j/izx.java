package _m_j;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class izx extends izw implements izm {

    /* renamed from: O000000o  reason: collision with root package name */
    O0000OOo f1681O000000o;
    protected boolean O00000Oo;
    public float O00000o;
    public boolean O00000o0;
    public int O00000oO;
    private boolean O00000oo;
    private WeakReference<O00000o0> O0000O0o;
    private WeakReference<O00000o> O0000OOo;
    private final O000000o O0000Oo;
    private int O0000Oo0;
    private final O000000o O0000OoO;

    public static abstract class O00000Oo {
        public abstract void O000000o(int i, int i2);

        public abstract boolean O000000o(Canvas canvas);
    }

    public interface O00000o {
        void postPerformLongClick();
    }

    public interface O00000o0 {
        void postPerformClick();
    }

    public static abstract class O0000O0o {
        public abstract Shader O000000o();
    }

    /* synthetic */ izx(O0000OOo o0000OOo) {
        this(o0000OOo, (ColorStateList) null);
    }

    public izx() {
        this(new O0000OOo(), (ColorStateList) null);
    }

    public izx(jaa jaa, ColorStateList colorStateList) {
        this(new O0000OOo(), colorStateList);
        this.f1681O000000o.O00000o0 = jaa;
    }

    public final void O000000o(jaa jaa) {
        this.f1681O000000o.O00000o0 = jaa;
        O00000Oo();
    }

    public final void O000000o(O00000Oo o00000Oo) {
        this.f1681O000000o.O0000OOo = o00000Oo;
    }

    public final int getIntrinsicWidth() {
        return this.f1681O000000o.O00000oO;
    }

    public final int getIntrinsicHeight() {
        return this.f1681O000000o.O00000oo;
    }

    public final boolean getPadding(Rect rect) {
        if (this.f1681O000000o.O00000o == null) {
            return super.getPadding(rect);
        }
        rect.set(this.f1681O000000o.O00000o);
        return true;
    }

    public final void draw(Canvas canvas) {
        if (this.O00000o0) {
            super.draw(canvas);
        }
    }

    public final void O000000o(Canvas canvas, Paint paint) {
        Rect bounds = getBounds();
        O0000OOo o0000OOo = this.f1681O000000o;
        if (o0000OOo.O00000o0 != null) {
            int save = canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            if (o0000OOo.O0000OOo != null) {
                o0000OOo.O0000OOo.O000000o(canvas);
            } else {
                canvas.clipRect(0, 0, bounds.width(), bounds.height());
            }
            o0000OOo.O00000o0.O000000o(canvas, paint);
            canvas.restoreToCount(save);
        }
    }

    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1681O000000o.O00000Oo;
    }

    public final int getOpacity() {
        if (this.f1681O000000o.O00000o0 == null) {
            return super.getOpacity();
        }
        return -3;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        O00000Oo();
    }

    @TargetApi(21)
    public final void getOutline(Outline outline) {
        if (this.f1681O000000o.O00000o0 != null) {
            outline.setAlpha(((float) getAlpha()) / 255.0f);
        }
    }

    public final Drawable.ConstantState getConstantState() {
        this.f1681O000000o.O00000Oo = getChangingConfigurations();
        return this.f1681O000000o;
    }

    public final Drawable mutate() {
        if (!this.O00000oo && super.mutate() == this) {
            if (this.f1681O000000o.O00000o != null) {
                O0000OOo o0000OOo = this.f1681O000000o;
                o0000OOo.O00000o = new Rect(o0000OOo.O00000o);
            } else {
                this.f1681O000000o.O00000o = new Rect();
            }
            try {
                if (this.f1681O000000o.O00000o0 != null) {
                    this.f1681O000000o.O00000o0 = this.f1681O000000o.O00000o0.O000000o();
                }
                this.O00000oo = true;
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
        return this;
    }

    public final boolean O000000o(MotionEvent motionEvent) {
        float f;
        float f2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.O00000Oo = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.f1681O000000o.O00000o0 != null) {
                Rect bounds = getBounds();
                if (x > ((float) bounds.right)) {
                    f = (float) bounds.width();
                } else {
                    f = x - ((float) bounds.left);
                }
                if (y > ((float) bounds.bottom)) {
                    f2 = (float) bounds.height();
                } else {
                    f2 = y - ((float) bounds.top);
                }
                this.f1681O000000o.O00000o0.O000000o(f, f2);
                stop();
                O0000Oo0();
            }
        } else if (actionMasked == 1) {
            this.O00000Oo = true;
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (this.f1681O000000o.O00000o0 != null) {
                Rect bounds2 = getBounds();
                if (x2 > ((float) bounds2.right)) {
                    bounds2.width();
                } else {
                    int i = bounds2.left;
                }
                if (y2 > ((float) bounds2.bottom)) {
                    bounds2.height();
                } else {
                    int i2 = bounds2.top;
                }
                O00000o0(1);
                O0000Oo();
            }
        } else if (actionMasked == 2) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (this.f1681O000000o.O00000o0 != null) {
                Rect bounds3 = getBounds();
                if (x3 > ((float) bounds3.right)) {
                    bounds3.width();
                } else {
                    int i3 = bounds3.left;
                }
                if (y3 > ((float) bounds3.bottom)) {
                    bounds3.height();
                } else {
                    int i4 = bounds3.top;
                }
                O00000o0(3);
            }
        } else if (actionMasked != 3) {
            return false;
        } else {
            this.O00000Oo = true;
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            if (this.f1681O000000o.O00000o0 != null) {
                Rect bounds4 = getBounds();
                if (x4 > ((float) bounds4.right)) {
                    bounds4.width();
                } else {
                    int i5 = bounds4.left;
                }
                if (y4 > ((float) bounds4.bottom)) {
                    bounds4.height();
                } else {
                    int i6 = bounds4.top;
                }
                if (this.O00000o0) {
                    O00000o0(2);
                    O0000Oo();
                } else {
                    stop();
                }
            }
        }
        return true;
    }

    private void O00000Oo() {
        if (this.f1681O000000o.O00000o0 != null) {
            Rect bounds = getBounds();
            int width = bounds.width();
            int height = bounds.height();
            this.f1681O000000o.O00000o0.O00000Oo((float) width, (float) height);
            if (this.f1681O000000o.O0000O0o != null) {
                this.O0000o0.setShader(this.f1681O000000o.O0000O0o.O000000o());
            }
            if (this.f1681O000000o.O0000OOo != null) {
                this.f1681O000000o.O0000OOo.O000000o(width, height);
            }
        }
        invalidateSelf();
    }

    private izx(O0000OOo o0000OOo, ColorStateList colorStateList) {
        super(colorStateList);
        this.O00000Oo = false;
        this.O0000O0o = null;
        this.O0000OOo = null;
        this.O00000o0 = false;
        this.O00000o = 1.0f;
        this.O0000Oo0 = 1;
        this.O00000oO = 1;
        this.O0000Oo = new O000000o() {
            /* class _m_j.izx.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public final void O000000o() {
                this.O00000Oo = 280;
                this.O00000o0 = new DecelerateInterpolator(2.4f);
            }

            /* access modifiers changed from: package-private */
            public final void O000000o(float f) {
                izx izx = izx.this;
                if (izx.f1681O000000o.O00000o0 != null) {
                    izx.f1681O000000o.O00000o0.O000000o(f);
                }
            }

            /* access modifiers changed from: package-private */
            public final void O00000Oo() {
                izx.this.O000000o();
            }
        };
        this.O0000OoO = new O000000o() {
            /* class _m_j.izx.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public final void O000000o() {
                this.O00000Oo = 160;
                this.O00000o0 = new AccelerateInterpolator();
            }

            /* access modifiers changed from: package-private */
            public final void O000000o(float f) {
                izx izx = izx.this;
                if (izx.f1681O000000o.O00000o0 != null) {
                    izx.f1681O000000o.O00000o0.O00000Oo(f);
                }
            }

            /* access modifiers changed from: package-private */
            public final void O00000Oo() {
                izx.this.O00000o0 = false;
            }
        };
        this.f1681O000000o = o0000OOo;
    }

    public final boolean O000000o(O00000o0 o00000o0) {
        if ((this.O00000oO & 1) != 1) {
            return true;
        }
        if (O00000oO() == null) {
            synchronized (this) {
                this.O0000O0o = new WeakReference<>(o00000o0);
            }
            return false;
        } else if (this.O0000Oo.O00000o0()) {
            return false;
        } else {
            O0000O0o();
            return true;
        }
    }

    public final boolean O000000o(O00000o o00000o) {
        if ((this.O00000oO & 16) != 16) {
            return true;
        }
        if (O00000oo() == null) {
            synchronized (this) {
                this.O0000OOo = new WeakReference<>(o00000o);
            }
            return false;
        } else if (this.O0000Oo.O00000o0()) {
            return false;
        } else {
            O0000OOo();
            return true;
        }
    }

    private void O00000o0() {
        O00000o0 O00000oO2 = O00000oO();
        if (O00000oO2 != null) {
            O00000oO2.postPerformClick();
        }
    }

    private O00000o0 O00000oO() {
        synchronized (this) {
            if (this.O0000O0o == null) {
                return null;
            }
            O00000o0 o00000o0 = this.O0000O0o.get();
            return o00000o0;
        }
    }

    private O00000o O00000oo() {
        synchronized (this) {
            if (this.O0000OOo == null) {
                return null;
            }
            O00000o o00000o = this.O0000OOo.get();
            return o00000o;
        }
    }

    private void O0000O0o() {
        synchronized (this) {
            if (this.O0000O0o != null) {
                this.O0000O0o.clear();
                this.O0000O0o = null;
            }
        }
    }

    private void O0000OOo() {
        synchronized (this) {
            if (this.O0000OOo != null) {
                this.O0000OOo.clear();
                this.O0000OOo = null;
            }
        }
    }

    public final void start() {
        O0000Oo0();
    }

    public final void stop() {
        this.O0000Oo.O00000oO();
        this.O0000OoO.O00000oO();
        O00000o0(1);
    }

    public final boolean isRunning() {
        return this.O00000o0;
    }

    public final void O000000o(float f) {
        if (f > 0.0f) {
            this.O0000Oo.O00000Oo = (int) (f * 280.0f);
        }
    }

    public final void O00000Oo(float f) {
        if (f > 0.0f) {
            this.O0000OoO.O00000Oo = (int) (f * 160.0f);
        }
    }

    private void O0000Oo0() {
        O0000O0o();
        O0000OOo();
        this.O0000Oo.O000000o(90);
    }

    private void O0000Oo() {
        if (!this.O0000Oo.O00000o0()) {
            O00000o0();
            this.O0000OoO.O000000o(0);
        }
    }

    private void O00000o0(int i) {
        if (this.O0000Oo0 != i) {
            this.O0000Oo0 = i;
            float f = i != 2 ? i != 3 ? 1.0f : 0.28f : 2.0f;
            if (this.O00000o != f) {
                this.O00000o = f;
                this.O0000Oo.O00000o();
                this.O0000OoO.O00000o();
            }
        }
    }

    static final class O0000OOo extends Drawable.ConstantState {

        /* renamed from: O000000o  reason: collision with root package name */
        int[] f1685O000000o;
        int O00000Oo;
        Rect O00000o;
        jaa O00000o0;
        int O00000oO;
        int O00000oo;
        O0000O0o O0000O0o;
        O00000Oo O0000OOo;

        O0000OOo() {
        }

        public final boolean canApplyTheme() {
            return this.f1685O000000o != null;
        }

        public final Drawable newDrawable() {
            return new izx(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new izx(this);
        }

        public final int getChangingConfigurations() {
            return this.O00000Oo;
        }
    }

    abstract class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f1684O000000o = true;
        int O00000Oo;
        Interpolator O00000o0;
        private float O00000oO = 0.0f;
        private float O00000oo = 0.0f;

        /* access modifiers changed from: package-private */
        public abstract void O000000o();

        /* access modifiers changed from: package-private */
        public abstract void O000000o(float f);

        /* access modifiers changed from: package-private */
        public abstract void O00000Oo();

        O000000o() {
            O000000o();
        }

        public final boolean O00000o0() {
            return !this.f1684O000000o;
        }

        public final void O00000o() {
            this.O00000oo = (16.0f / ((float) this.O00000Oo)) * izx.this.O00000o;
        }

        public final void O000000o(int i) {
            this.f1684O000000o = false;
            O00000o();
            this.O00000oO = 0.0f;
            izx.this.scheduleSelf(this, SystemClock.uptimeMillis() + ((long) i));
        }

        public final void O00000oO() {
            izx.this.unscheduleSelf(this);
            this.f1684O000000o = true;
        }

        public void run() {
            if (!this.f1684O000000o) {
                izx izx = izx.this;
                izx.O00000o0 = true;
                this.O00000oO += this.O00000oo;
                float f = this.O00000oO;
                if (f < 1.0f) {
                    O000000o(this.O00000o0.getInterpolation(f));
                    izx.this.invalidateSelf();
                    izx.this.scheduleSelf(this, SystemClock.uptimeMillis() + 16);
                    return;
                }
                this.f1684O000000o = true;
                izx.unscheduleSelf(this);
                O000000o(1.0f);
                izx.this.invalidateSelf();
                O00000Oo();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        O00000o O00000oo2;
        if (this.O00000Oo) {
            O0000Oo();
        } else if (this.O0000Oo0 == 3 && (O00000oo2 = O00000oo()) != null) {
            O00000oo2.postPerformLongClick();
        }
    }
}
