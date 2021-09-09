package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.RemoteViews;
import com.xiaomi.smarthome.R;

@RemoteViews.RemoteView
public class BaseProgressBar extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f9140O000000o;
    int O00000Oo;
    int O00000o;
    int O00000o0;
    public O000000o O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private Transformation O0000OoO;
    private AlphaAnimation O0000Ooo;
    private Interpolator O0000o;
    private Drawable O0000o0;
    private Drawable O0000o00;
    private Drawable O0000o0O;
    private boolean O0000o0o;
    private boolean O0000oO;
    private long O0000oO0;
    private long O0000oOO;
    private boolean O0000oOo;

    /* access modifiers changed from: package-private */
    public void O000000o(float f, boolean z) {
    }

    public BaseProgressBar(Context context) {
        this(context, null);
    }

    public BaseProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000OOo = 1000;
        this.O00000oo = 0;
        this.O0000O0o = 0;
        this.O0000Oo = 4000;
        this.O0000Oo0 = 1;
        this.f9140O000000o = 24;
        this.O00000Oo = 48;
        this.O00000o0 = gri.O000000o(2.0f);
        this.O00000o = gri.O000000o(2.0f);
        int i = this.O0000Oo;
        int i2 = this.f9140O000000o;
        int i3 = this.O00000o0;
        int i4 = this.O00000Oo;
        int i5 = this.O00000o;
        int i6 = this.O0000Oo0;
        int i7 = this.O0000OOo;
        int i8 = this.O00000oo;
        Drawable drawable = getResources().getDrawable(R.drawable.base_seekbar_progress);
        this.O0000oO0 = Thread.currentThread().getId();
        this.O0000o0o = true;
        if (drawable != null) {
            setProgressDrawable(drawable);
        }
        this.O0000Oo = i;
        this.f9140O000000o = i2;
        this.O00000Oo = i4;
        this.O00000o0 = i3;
        this.O00000o = i5;
        this.O0000Oo0 = i6;
        setMax(i7);
        setProgress(i8);
        this.O0000o0o = false;
    }

    /* access modifiers changed from: package-private */
    public Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Drawable getProgressDrawable() {
        return this.O0000o0;
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.O0000o0 = drawable;
        this.O0000o0O = drawable;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public Drawable getCurrentDrawable() {
        return this.O0000o0O;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.O0000o0 || drawable == this.O0000o00 || super.verifyDrawable(drawable);
    }

    public void postInvalidate() {
        if (!this.O0000o0o) {
            super.postInvalidate();
        }
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        int f9141O000000o = 16908301;
        int O00000Oo;
        boolean O00000o0;

        O000000o(int i, int i2, boolean z) {
            this.O00000Oo = i2;
            this.O00000o0 = z;
        }

        public final void run() {
            BaseProgressBar.this.O000000o(this.f9141O000000o, this.O00000Oo, this.O00000o0);
            BaseProgressBar.this.O00000oO = this;
        }
    }

    public final synchronized void O000000o(int i, int i2, boolean z) {
        float f = this.O0000OOo > 0 ? ((float) i2) / ((float) this.O0000OOo) : 0.0f;
        Drawable drawable = this.O0000o0O;
        if (drawable != null) {
            Drawable drawable2 = null;
            if (drawable instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i);
            }
            int i3 = (int) (10000.0f * f);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            drawable.setLevel(i3);
        } else {
            invalidate();
        }
        if (i == 16908301) {
            O000000o(f, z);
        }
    }

    private synchronized void O00000Oo(int i, boolean z) {
        O000000o o000000o;
        if (this.O0000oO0 == Thread.currentThread().getId()) {
            O000000o(16908301, i, z);
            return;
        }
        if (this.O00000oO != null) {
            o000000o = this.O00000oO;
            this.O00000oO = null;
            o000000o.f9141O000000o = 16908301;
            o000000o.O00000Oo = i;
            o000000o.O00000o0 = z;
        } else {
            o000000o = new O000000o(16908301, i, z);
        }
        post(o000000o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(float, boolean):void
      com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(int, boolean):void */
    public synchronized void setProgress(int i) {
        O000000o(i, false);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.O0000OOo) {
            i = this.O0000OOo;
        }
        if (i != this.O00000oo) {
            this.O00000oo = i;
            O00000Oo(this.O00000oo, z);
        }
    }

    public synchronized int getProgress() {
        return this.O00000oo;
    }

    public synchronized int getMax() {
        return this.O0000OOo;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.O0000OOo) {
            this.O0000OOo = i;
            postInvalidate();
            if (this.O00000oo > i) {
                this.O00000oo = i;
            }
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        this.O0000o = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.O0000o;
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.O0000oOo) {
            return;
        }
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (i - getPaddingRight()) - getPaddingLeft();
        int paddingBottom = (i2 - getPaddingBottom()) - getPaddingTop();
        Drawable drawable = this.O0000o00;
        if (drawable != null) {
            drawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        Drawable drawable2 = this.O0000o0;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.O0000o0O;
        if (drawable != null) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            long drawingTime = getDrawingTime();
            if (this.O0000Ooo != null) {
                this.O0000Ooo.getTransformation(drawingTime, this.O0000OoO);
                float alpha = this.O0000OoO.getAlpha();
                try {
                    this.O0000oOo = true;
                    drawable.setLevel((int) (alpha * 10000.0f));
                    this.O0000oOo = false;
                    if (SystemClock.uptimeMillis() - this.O0000oOO >= 200) {
                        this.O0000oOO = SystemClock.uptimeMillis();
                        postInvalidateDelayed(200);
                    }
                } catch (Throwable th) {
                    this.O0000oOo = false;
                    throw th;
                }
            }
            drawable.draw(canvas);
            canvas.restore();
            if (this.O0000oO && (drawable instanceof AnimationDrawable)) {
                ((AnimationDrawable) drawable).start();
                this.O0000oO = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        Drawable drawable = this.O0000o0O;
        int i4 = 0;
        if (drawable != null) {
            i4 = Math.max(this.f9140O000000o, Math.min(this.O00000Oo, drawable.getIntrinsicWidth()));
            i3 = Math.max(this.O00000o0, Math.min(this.O00000o, drawable.getIntrinsicHeight()));
        } else {
            i3 = 0;
        }
        setMeasuredDimension(resolveSize(i4 + getPaddingLeft() + getPaddingRight(), i), resolveSize(i3 + getPaddingTop() + getPaddingBottom(), i2));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.O0000o0;
        if (drawable != null && drawable.isStateful()) {
            this.O0000o0.setState(drawableState);
        }
        Drawable drawable2 = this.O0000o00;
        if (drawable2 != null && drawable2.isStateful()) {
            this.O0000o00.setState(drawableState);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.library.common.widget.BaseProgressBar.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f9142O000000o;
        int O00000Oo;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f9142O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9142O000000o);
            parcel.writeInt(this.O00000Oo);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f9142O000000o = this.O00000oo;
        savedState.O00000Oo = this.O0000O0o;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f9142O000000o);
    }
}
