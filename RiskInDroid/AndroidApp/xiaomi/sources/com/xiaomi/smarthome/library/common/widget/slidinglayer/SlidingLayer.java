package com.xiaomi.smarthome.library.common.widget.slidinglayer;

import _m_j.cb;
import _m_j.cc;
import _m_j.grm;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.xiaomi.smarthome.R;
import java.util.Random;

public class SlidingLayer extends FrameLayout {
    private static final Interpolator O00000oO = new Interpolator() {
        /* class com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.AnonymousClass1 */

        public final float getInterpolation(float f) {
            return ((float) Math.pow((double) (f - 1.0f), 5.0d)) + 1.0f;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f9330O000000o;
    protected VelocityTracker O00000Oo;
    protected Bundle O00000o;
    protected int O00000o0;
    private Random O00000oo;
    private Scroller O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo;
    private Drawable O0000Oo0;
    private int O0000OoO;
    private boolean O0000Ooo;
    private boolean O0000o;
    private boolean O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private boolean O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private int O0000oOO;
    private float O0000oOo;
    private float O0000oo;
    private float O0000oo0;
    private float O0000ooO;
    private float O0000ooo;
    private boolean O000O00o;
    private O000000o O000O0OO;
    private O00000Oo O000O0Oo;
    private grm O000O0o;
    private int O000O0o0;
    private int O00oOoOo;
    private float O00oOooO;
    private int O00oOooo;

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    public SlidingLayer(Context context) {
        this(context, null);
    }

    public SlidingLayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9330O000000o = -1;
        this.O0000o0 = true;
        this.O0000o0O = -1;
        this.O0000o0o = true;
        this.O0000o = true;
        this.O0000oOo = -1.0f;
        this.O0000oo0 = -1.0f;
        this.O0000oo = -1.0f;
        this.O0000ooO = -1.0f;
        this.O0000ooo = -1.0f;
        this.O00oOooO = -1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.changeStateOnTap, R.attr.offsetDistance, R.attr.previewOffsetDistance, R.attr.shadowDrawable, R.attr.shadowSize, R.attr.stickTo});
        setStickTo(obtainStyledAttributes.getInt(5, -1));
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        if (resourceId != -1) {
            setShadowDrawable(resourceId);
        }
        this.O0000OOo = (int) obtainStyledAttributes.getDimension(4, 0.0f);
        this.O0000o0 = obtainStyledAttributes.getBoolean(0, true);
        this.O0000OoO = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.O0000o0O = obtainStyledAttributes.getDimensionPixelOffset(2, -1);
        O00000Oo();
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(2, null);
        }
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.O0000O0o = new Scroller(context2, O00000oO);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        this.O0000oOO = cc.O000000o(viewConfiguration);
        this.O00oOoOo = viewConfiguration.getScaledMinimumFlingVelocity();
        this.O00000o0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O000O0o0 = (int) (context2.getResources().getDisplayMetrics().density * 10.0f);
        this.O00000oo = new Random();
    }

    private int getCurrentState() {
        return this.O00oOooo;
    }

    public final boolean O000000o() {
        return this.O00oOooo == 2;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, boolean z, boolean z2) {
        O000000o(i, z, z2, 0, 0);
    }

    private void O000000o(int i, boolean z, boolean z2, int i2, int i3) {
        if (z2 || this.O00oOooo != i) {
            int[] O000000o2 = O000000o(i);
            if (z) {
                if (O00000oo() != 0) {
                    i2 = i3;
                }
                O000000o(O000000o2[0], O000000o2[1], i2);
            } else {
                O00000oO();
                O000000o(O000000o2[0], O000000o2[1]);
            }
            this.O00oOooo = i;
            return;
        }
        setDrawingCacheEnabled(false);
    }

    public void setOnInteractListener(O000000o o000000o) {
        this.O000O0OO = o000000o;
    }

    public void setOnScrollListener(O00000Oo o00000Oo) {
        this.O000O0Oo = o00000Oo;
    }

    public void setLayerTransformer(grm grm) {
        this.O000O0o = grm;
    }

    public void setShadowSize(int i) {
        this.O0000OOo = i;
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    public void setShadowSizeRes(int i) {
        setShadowSize((int) getResources().getDimension(i));
    }

    public int getShadowSize() {
        return this.O0000OOo;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.O0000Oo0 = drawable;
        refreshDrawableState();
        setWillNotDraw(false);
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    public void setShadowDrawable(int i) {
        setShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setOffsetDistanceRes(int i) {
        setOffsetDistance((int) getResources().getDimension(i));
    }

    public void setOffsetDistance(int i) {
        this.O0000OoO = i;
        O00000Oo();
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    public int getOffsetDistance() {
        return this.O0000OoO;
    }

    public void setPreviewOffsetDistanceRes(int i) {
        setPreviewOffsetDistance((int) getResources().getDimension(i));
    }

    public void setPreviewOffsetDistance(int i) {
        this.O0000o0O = i;
        O00000Oo();
        invalidate(getLeft(), getTop(), getRight(), getBottom());
        int i2 = this.O00oOooo;
        if (i2 == 1) {
            int[] O000000o2 = O000000o(i2);
            O000000o(O000000o2[0], O000000o2[1], 0);
        }
    }

    private void O00000Oo() {
        if (O00000o0() && this.O0000OoO > this.O0000o0O) {
            throw new IllegalStateException("The showing offset of the layer can never be greater than the offset dimension of the preview mode");
        }
    }

    private boolean O00000o0() {
        return this.O0000o0O != -1;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.O0000Oo0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.O0000Oo0;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void setSlidingEnabled(boolean z) {
        this.O0000o0o = z;
    }

    public void setSlidingFromShadowEnabled(boolean z) {
        this.O0000o = z;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.O00000o == null) {
            this.O00000o = new Bundle();
        }
        this.O00000o.putInt("state", this.O00oOooo);
        savedState.f9331O000000o = this.O00000o;
        return savedState;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void */
    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O00000o = savedState.f9331O000000o;
        O000000o(this.O00000o.getInt("state"), true, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
     arg types: [float, float, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        boolean z = false;
        if (!this.O0000o0o) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.O0000oO0 = false;
            this.O0000oO = false;
            this.f9330O000000o = -1;
            VelocityTracker velocityTracker = this.O00000Oo;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.O00000Oo = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.O0000oO0) {
                return true;
            }
            if (this.O0000oO) {
                return false;
            }
        }
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.O0000ooo = rawX;
            this.O0000oOo = rawX;
            float rawY = motionEvent.getRawY();
            this.O00oOooO = rawY;
            this.O0000oo0 = rawY;
            this.O0000oo = motionEvent2.getX(0);
            this.O0000ooO = motionEvent2.getY(0);
            this.f9330O000000o = motionEvent2.getPointerId(0);
            if (O000000o(motionEvent.getX(), motionEvent.getY(), true)) {
                this.O0000oO0 = false;
                this.O0000oO = false;
                return super.onInterceptTouchEvent(motionEvent);
            }
            O00000oO();
            this.O0000oO0 = false;
            this.O0000oO = true;
        } else if (action == 2) {
            int i = this.f9330O000000o;
            if (i != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i);
                float rawX2 = motionEvent.getRawX();
                float f = rawX2 - this.O0000oOo;
                float abs = Math.abs(f);
                float rawY2 = motionEvent.getRawY();
                float f2 = rawY2 - this.O0000oo0;
                float abs2 = Math.abs(f2);
                if (!(f == 0.0f && f2 == 0.0f) && O000000o(this, false, (int) f, (int) f2, (int) rawX2, (int) rawY2)) {
                    this.O0000ooo = rawX2;
                    this.O0000oOo = rawX2;
                    this.O00oOooO = rawY2;
                    this.O0000oo0 = rawY2;
                    this.O0000oo = motionEvent2.getX(findPointerIndex);
                    this.O0000ooO = motionEvent2.getY(findPointerIndex);
                    return false;
                }
                boolean z2 = abs > ((float) this.O0000oOO) && abs > abs2;
                if (abs2 > ((float) this.O0000oOO) && abs2 > abs) {
                    z = true;
                }
                if (z2) {
                    this.O0000oOo = rawX2;
                } else if (z) {
                    this.O0000oo0 = rawY2;
                }
                if (z2 || z) {
                    this.O0000oO0 = true;
                    setDrawingCacheEnabled(true);
                }
            }
        } else if (action == 6) {
            O000000o(motionEvent);
        }
        if (!this.O0000oO0) {
            if (this.O00000Oo == null) {
                this.O00000Oo = VelocityTracker.obtain();
            }
            this.O00000Oo.addMovement(motionEvent2);
        }
        return this.O0000oO0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
     arg types: [float, float, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01fd, code lost:
        if ((O00000o0() && r4 > r6.O0000o0O && r11 < 9000) != false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01ff, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0219, code lost:
        if (r4 > (r6.O0000o0O / 2)) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x023d, code lost:
        if (O00000o0() == false) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0246, code lost:
        if (O00000o0() != false) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0248, code lost:
        r2 = 1;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        float f2;
        float f3;
        MotionEvent motionEvent2 = motionEvent;
        int i6 = 0;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || !this.O0000o0o || (!this.O0000oO0 && !O000000o(this.O0000oo, this.O0000ooO, true))) {
            return false;
        }
        if (this.O00000Oo == null) {
            this.O00000Oo = VelocityTracker.obtain();
        }
        this.O00000Oo.addMovement(motionEvent2);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            O00000oO();
            float rawX = motionEvent.getRawX();
            this.O0000ooo = rawX;
            this.O0000oOo = rawX;
            float rawY = motionEvent.getRawY();
            this.O00oOooO = rawY;
            this.O0000oo0 = rawY;
            this.O0000oo = motionEvent.getX();
            this.O0000ooO = motionEvent.getY();
            this.f9330O000000o = motionEvent2.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                motionEvent2.findPointerIndex(this.f9330O000000o);
                if (!O000000o(motionEvent.getX(), motionEvent.getY(), false)) {
                    return false;
                }
                float rawX2 = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                float f4 = this.O0000oOo - rawX2;
                float f5 = this.O0000oo0 - rawY2;
                this.O0000oOo = rawX2;
                this.O0000oo0 = rawY2;
                if (!this.O0000oO0) {
                    float abs = Math.abs(rawX2 - this.O0000ooo);
                    float abs2 = Math.abs(rawY2 - this.O00oOooO);
                    boolean z = abs > ((float) this.O0000oOO) && abs > abs2;
                    if (abs2 > ((float) this.O0000oOO) && abs2 > abs) {
                        i6 = 1;
                    }
                    if (z || i6 != 0) {
                        this.O0000oO0 = true;
                        setDrawingCacheEnabled(true);
                    }
                }
                if (this.O0000oO0) {
                    float scrollX = ((float) getScrollX()) + f4;
                    float scrollY = ((float) getScrollY()) + f5;
                    int i7 = this.O0000o00;
                    float f6 = 0.0f;
                    if (i7 != -4) {
                        if (i7 != -3) {
                            if (i7 == -2) {
                                f6 = (float) getWidth();
                            } else if (i7 == -1) {
                                f3 = (float) (-getWidth());
                                f2 = 0.0f;
                            }
                            f3 = 0.0f;
                            f2 = 0.0f;
                        } else {
                            f2 = (float) getHeight();
                            f3 = 0.0f;
                        }
                        f = 0.0f;
                    } else {
                        f = (float) (-getHeight());
                        f3 = 0.0f;
                        f2 = 0.0f;
                    }
                    if (scrollX > f6) {
                        scrollX = f6;
                    } else if (scrollX < f3) {
                        scrollX = f3;
                    }
                    if (scrollY > f2) {
                        scrollY = f2;
                    } else if (scrollY < f) {
                        scrollY = f;
                    }
                    int i8 = (int) scrollX;
                    this.O0000oOo += scrollX - ((float) i8);
                    int i9 = (int) scrollY;
                    this.O0000oo0 += scrollY - ((float) i9);
                    O000000o(i8, i9);
                }
            } else if (action != 3) {
                if (action == 5) {
                    this.f9330O000000o = motionEvent2.getPointerId(motionEvent.getActionIndex());
                    this.O0000oOo = motionEvent.getRawX();
                    this.O0000oo0 = motionEvent.getRawY();
                } else if (action == 6) {
                    O000000o(motionEvent);
                    motionEvent2.findPointerIndex(this.f9330O000000o);
                    this.O0000oOo = motionEvent.getRawX();
                    this.O0000oo0 = motionEvent.getRawY();
                }
            } else if (this.O0000oO0) {
                O000000o(this.O00oOooo, true, true);
                this.f9330O000000o = -1;
                O00000o();
            }
        } else if (this.O0000oO0) {
            VelocityTracker velocityTracker = this.O00000Oo;
            velocityTracker.computeCurrentVelocity(1000, (float) this.O00000o0);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f9330O000000o);
            int yVelocity = (int) velocityTracker.getYVelocity(this.f9330O000000o);
            int scrollX2 = getScrollX();
            int scrollY2 = getScrollY();
            motionEvent2.findPointerIndex(this.f9330O000000o);
            float rawX3 = motionEvent.getRawX();
            float rawY3 = motionEvent.getRawY();
            int i10 = (int) this.O0000ooo;
            int i11 = (int) this.O00oOooO;
            int i12 = (int) rawX3;
            int i13 = (int) rawY3;
            if (O00000oo() == 0) {
                int width = getWidth();
                int abs3 = Math.abs(width - Math.abs(scrollX2));
                int abs4 = Math.abs(i12 - i10);
                i2 = (this.O0000o00 == -2 ? 1 : -1) * xVelocity;
                int i14 = abs3;
                i3 = width;
                i4 = abs4;
                i = i14;
            } else {
                i3 = getHeight();
                int abs5 = Math.abs(i3 - Math.abs(scrollY2));
                i4 = Math.abs(i13 - i11);
                i = abs5;
                i2 = (this.O0000o00 == -3 ? 1 : -1) * yVelocity;
            }
            int abs6 = Math.abs(i2);
            if (!(i4 > this.O000O0o0 && abs6 > this.O00oOoOo)) {
                if (i <= (i3 + (O00000o0() ? this.O0000o0O : 0)) / 2) {
                    if (O00000o0()) {
                    }
                    i5 = 0;
                    O000000o(i5, true, true, xVelocity, yVelocity);
                    this.f9330O000000o = -1;
                    O00000o();
                }
            } else if (i2 <= 0) {
            }
            i5 = 2;
            O000000o(i5, true, true, xVelocity, yVelocity);
            this.f9330O000000o = -1;
            O00000o();
        } else if (this.O0000o0) {
            int i15 = this.O00oOooo;
            if (i15 != 0) {
                if (i15 != 1) {
                    if (i15 == 2) {
                    }
                    O000000o(i6, true, true);
                }
            }
            i6 = 2;
            O000000o(i6, true, true);
        }
        return true;
    }

    private boolean O000000o(float f, float f2, boolean z) {
        int i;
        if (O00000oo() == 0) {
            i = z ? getScrollX() : 0;
        } else {
            float f3 = f2;
            i = z ? getScrollY() : 0;
            f = f3;
        }
        int i2 = this.O0000o00;
        if (i2 != -4) {
            if (i2 != -3) {
                if (i2 != -2) {
                    if (i2 != -1) {
                        throw new IllegalStateException("The layer has to be stuck to one of the sides of the screen. Current value is: " + this.O0000o00);
                    }
                } else if (f <= ((float) (getWidth() - i))) {
                    return true;
                } else {
                    return false;
                }
            } else if (f <= ((float) (getHeight() - i))) {
                return true;
            } else {
                return false;
            }
        }
        if (f >= ((float) (-i))) {
            return true;
        }
        return false;
    }

    private boolean O000000o(View view, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (O000000o(childAt, true, i, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z) {
            return false;
        }
        if ((O00000oo() != 0 || !cb.O000000o(view, -i)) && (O00000oo() != 1 || !cb.O00000Oo(view, -i2))) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private void O000000o(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setDrawingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            O00000oO();
            return;
        }
        setDrawingCacheEnabled(true);
        this.O000O00o = true;
        int width = getWidth();
        float f = (float) (width / 2);
        float O000000o2 = f + (O000000o(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) width))) * f);
        int abs = Math.abs(i3);
        this.O0000O0o.startScroll(scrollX, scrollY, i4, i5, Math.min(abs > 0 ? Math.round(Math.abs(O000000o2 / ((float) abs)) * 1000.0f) * 4 : 600, 600));
        cb.O00000oo(this);
    }

    private static float O000000o(float f) {
        double d = (double) (f - 0.5f);
        Double.isNaN(d);
        return (float) Math.sin((double) ((float) (d * 0.4712389167638204d)));
    }

    private void O00000o() {
        this.O0000oO0 = false;
        this.O0000oO = false;
        VelocityTracker velocityTracker = this.O00000Oo;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O00000Oo = null;
        }
    }

    public void setDrawingCacheEnabled(boolean z) {
        if (this.O0000Ooo != z) {
            super.setDrawingCacheEnabled(z);
            this.O0000Ooo = z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    childAt.setDrawingCacheEnabled(z);
                }
            }
        }
    }

    private void O000000o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f9330O000000o) {
            int i = actionIndex == 0 ? 1 : 0;
            this.O0000oOo = motionEvent.getX(i);
            this.f9330O000000o = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.O00000Oo;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void O00000oO() {
        if (this.O000O00o) {
            setDrawingCacheEnabled(false);
            this.O0000O0o.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.O0000O0o.getCurrX();
            int currY = this.O0000O0o.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                O000000o(currX, currY);
            }
        }
        this.O000O00o = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private void O000000o(int i, int i2) {
        int i3;
        scrollTo(i, i2);
        if (this.O000O0Oo != null || this.O000O0o != null) {
            if (O00000oo() == 1) {
                i3 = getHeight() - Math.abs(i2);
            } else {
                i3 = getWidth() - Math.abs(i);
            }
            if (this.O000O0Oo != null) {
                Math.abs(i3);
            }
            if (this.O000O0o != null) {
                float abs = (float) Math.abs(i3);
                float measuredWidth = abs / ((float) (O00000oo() == 0 ? getMeasuredWidth() : getMeasuredHeight()));
                int i4 = this.O0000o0O;
                this.O000O0o.O000000o(this, i4 > 0 ? Math.min(1.0f, abs / ((float) i4)) : 0.0f, measuredWidth);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void */
    public void setStickTo(int i) {
        this.O0000Oo = true;
        this.O0000o00 = i;
        O000000o(0, false, true);
    }

    private int O00000oo() {
        int i = this.O0000o00;
        if (i == -3 || i == -4) {
            return 1;
        }
        if (i == -2 || i == -1) {
            return 0;
        }
        throw new IllegalStateException("The screen side of the layer is illegal");
    }

    public void setChangeStateOnTap(boolean z) {
        this.O0000o0 = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        grm grm = this.O000O0o;
        if (grm != null) {
            grm.O000000o(this, this.O0000o00);
        }
        super.onMeasure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (O00000oo() != 1 ? i != i3 : i2 != i4) {
            O00000oO();
            int[] O000000o2 = O000000o(this.O00oOooo);
            scrollTo(O000000o2[0], O000000o2[1]);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.O0000Oo) {
            this.O0000Oo = false;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                int i5 = this.O0000o00;
                if (i5 == -4) {
                    layoutParams2.gravity = 80;
                } else if (i5 == -3) {
                    layoutParams2.gravity = 48;
                } else if (i5 == -2) {
                    layoutParams2.gravity = 3;
                } else if (i5 == -1) {
                    layoutParams2.gravity = 5;
                }
                setLayoutParams(layoutParams);
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                int i6 = this.O0000o00;
                if (i6 == -4) {
                    layoutParams3.addRule(12);
                } else if (i6 == -3) {
                    layoutParams3.addRule(10);
                } else if (i6 == -2) {
                    layoutParams3.addRule(9);
                } else if (i6 == -1) {
                    layoutParams3.addRule(11);
                }
            }
            int i7 = this.O0000o00;
            if (i7 == -1) {
                setPadding(getPaddingLeft() + this.O0000OOo, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            } else if (i7 == -4) {
                setPadding(getPaddingLeft(), getPaddingTop() + this.O0000OOo, getPaddingRight(), getPaddingBottom());
            } else if (i7 == -2) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() + this.O0000OOo, getPaddingBottom());
            } else if (i7 == -3) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.O0000OOo);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private int[] O000000o(int i) {
        int[] iArr = new int[2];
        if (i == 2) {
            return iArr;
        }
        int i2 = i == 0 ? this.O0000OoO : this.O0000o0O;
        int i3 = this.O0000o00;
        if (i3 == -4) {
            iArr[1] = (-getHeight()) + i2;
        } else if (i3 == -3) {
            iArr[1] = getHeight() - i2;
        } else if (i3 == -2) {
            iArr[0] = getWidth() - i2;
        } else if (i3 == -1) {
            iArr[0] = (-getWidth()) + i2;
        }
        return iArr;
    }

    public int getContentLeft() {
        return getLeft() + getPaddingLeft();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        super.dispatchDraw(canvas);
        int i = this.O0000OOo;
        if (i > 0 && (drawable = this.O0000Oo0) != null) {
            if (this.O0000o00 == -1) {
                drawable.setBounds(0, 0, i, getHeight());
            }
            if (this.O0000o00 == -3) {
                this.O0000Oo0.setBounds(0, getHeight() - this.O0000OOo, getWidth(), getHeight());
            }
            if (this.O0000o00 == -2) {
                this.O0000Oo0.setBounds(getWidth() - this.O0000OOo, 0, getWidth(), getHeight());
            }
            if (this.O0000o00 == -4) {
                this.O0000Oo0.setBounds(0, 0, getWidth(), this.O0000OOo);
            }
            this.O0000Oo0.draw(canvas);
        }
    }

    public void computeScroll() {
        if (this.O0000O0o.isFinished() || !this.O0000O0o.computeScrollOffset()) {
            O00000oO();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.O0000O0o.getCurrX();
        int currY = this.O0000O0o.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            O000000o(currX, currY);
        }
        cb.O00000oo(this);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        Bundle f9331O000000o;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f9331O000000o = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f9331O000000o);
        }
    }
}
