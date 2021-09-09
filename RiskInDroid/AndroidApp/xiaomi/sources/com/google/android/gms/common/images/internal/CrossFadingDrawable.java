package com.google.android.gms.common.images.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public final class CrossFadingDrawable extends Drawable implements Drawable.Callback {
    private int mAlpha;
    private int mFrom;
    private boolean zzpl;
    private int zzpw;
    private long zzpx;
    private int zzpy;
    private int zzpz;
    private int zzqa;
    private boolean zzqb;
    private zzb zzqc;
    private Drawable zzqd;
    private Drawable zzqe;
    private boolean zzqf;
    private boolean zzqg;
    private boolean zzqh;
    private int zzqi;

    static final class zza extends Drawable {
        /* access modifiers changed from: private */
        public static final zza zzqj = new zza();
        private static final zzb zzqk = new zzb();

        private zza() {
        }

        public final void draw(Canvas canvas) {
        }

        public final Drawable.ConstantState getConstantState() {
            return zzqk;
        }

        public final int getOpacity() {
            return -2;
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends Drawable.ConstantState {
        int mChangingConfigurations;
        int zzql;

        zzb(zzb zzb) {
            if (zzb != null) {
                this.mChangingConfigurations = zzb.mChangingConfigurations;
                this.zzql = zzb.zzql;
            }
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final Drawable newDrawable() {
            return new CrossFadingDrawable(this);
        }
    }

    public CrossFadingDrawable(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zza.zzqj : drawable;
        this.zzqd = drawable;
        drawable.setCallback(this);
        zzb zzb2 = this.zzqc;
        zzb2.zzql = drawable.getChangingConfigurations() | zzb2.zzql;
        drawable2 = drawable2 == null ? zza.zzqj : drawable2;
        this.zzqe = drawable2;
        drawable2.setCallback(this);
        zzb zzb3 = this.zzqc;
        zzb3.zzql = drawable2.getChangingConfigurations() | zzb3.zzql;
    }

    CrossFadingDrawable(zzb zzb2) {
        this.zzpw = 0;
        this.zzpz = 255;
        this.mAlpha = 0;
        this.zzpl = true;
        this.zzqc = new zzb(zzb2);
    }

    public final boolean canConstantState() {
        if (!this.zzqf) {
            this.zzqg = (this.zzqd.getConstantState() == null || this.zzqe.getConstantState() == null) ? false : true;
            this.zzqf = true;
        }
        return this.zzqg;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public final void draw(Canvas canvas) {
        int i = this.zzpw;
        boolean z = true;
        if (i == 1) {
            this.zzpx = SystemClock.uptimeMillis();
            this.zzpw = 2;
            z = false;
        } else if (i == 2 && this.zzpx >= 0) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzpx)) / ((float) this.zzqa);
            if (uptimeMillis < 1.0f) {
                z = false;
            }
            if (z) {
                this.zzpw = 0;
            }
            this.mAlpha = (int) ((((float) this.zzpy) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
        }
        int i2 = this.mAlpha;
        boolean z2 = this.zzpl;
        Drawable drawable = this.zzqd;
        Drawable drawable2 = this.zzqe;
        if (z) {
            if (!z2 || i2 == 0) {
                drawable.draw(canvas);
            }
            int i3 = this.zzpz;
            if (i2 == i3) {
                drawable2.setAlpha(i3);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z2) {
            drawable.setAlpha(this.zzpz - i2);
        }
        drawable.draw(canvas);
        if (z2) {
            drawable.setAlpha(this.zzpz);
        }
        if (i2 > 0) {
            drawable2.setAlpha(i2);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzpz);
        }
        invalidateSelf();
    }

    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzqc.mChangingConfigurations | this.zzqc.zzql;
    }

    public final Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzqc.mChangingConfigurations = getChangingConfigurations();
        return this.zzqc;
    }

    public final Drawable getEndDrawable() {
        return this.zzqe;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zzqd.getIntrinsicHeight(), this.zzqe.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zzqd.getIntrinsicWidth(), this.zzqe.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (!this.zzqh) {
            this.zzqi = Drawable.resolveOpacity(this.zzqd.getOpacity(), this.zzqe.getOpacity());
            this.zzqh = true;
        }
        return this.zzqi;
    }

    public final Drawable getStartDrawable() {
        return this.zzqd;
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final Drawable mutate() {
        if (!this.zzqb && super.mutate() == this) {
            if (canConstantState()) {
                this.zzqd.mutate();
                this.zzqe.mutate();
                this.zzqb = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        this.zzqd.setBounds(rect);
        this.zzqe.setBounds(rect);
    }

    public final void resetTransition() {
        this.mAlpha = 0;
        this.zzpw = 0;
        invalidateSelf();
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void setAlpha(int i) {
        if (this.mAlpha == this.zzpz) {
            this.mAlpha = i;
        }
        this.zzpz = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zzqd.setColorFilter(colorFilter);
        this.zzqe.setColorFilter(colorFilter);
    }

    public final void setCrossFadeEnabled(boolean z) {
        this.zzpl = z;
    }

    public final void startTransition(int i) {
        this.mFrom = 0;
        this.zzpy = this.zzpz;
        this.mAlpha = 0;
        this.zzqa = i;
        this.zzpw = 1;
        invalidateSelf();
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
