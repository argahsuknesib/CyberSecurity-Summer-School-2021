package com.xiaomi.smarthome.library.common.widget;

import _m_j.gsy;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class MaterialRippleLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f9209O000000o;
    int O00000Oo;
    public boolean O00000o;
    public int O00000o0;
    public boolean O00000oO;
    public boolean O00000oo;
    public View O0000O0o;
    ObjectAnimator O0000OOo;
    public boolean O0000Oo;
    boolean O0000Oo0;
    public boolean O0000OoO;
    Path O0000Ooo;
    private boolean O0000o;
    private final Paint O0000o0;
    Property<MaterialRippleLayout, Float> O0000o00;
    private final Rect O0000o0O;
    private int O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private Drawable O0000oOO;
    private float O0000oOo;
    private AdapterView O0000oo;
    private float O0000oo0;
    private AnimatorSet O0000ooO;
    private Point O0000ooo;
    private int O000O00o;
    private GestureDetector O000O0OO;
    private O000000o O000O0Oo;
    private int O000O0o;
    private GestureDetector.SimpleOnGestureListener O000O0o0;
    private boolean O000O0oO;
    private Property<MaterialRippleLayout, Integer> O000O0oo;
    private boolean O000OO00;
    private boolean O000OO0o;
    private O00000Oo O00oOoOo;
    private Point O00oOooO;
    private int O00oOooo;

    public boolean isInEditMode() {
        return true;
    }

    public MaterialRippleLayout(Context context) {
        this(context, null, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000o0 = new Paint(1);
        this.O0000o0O = new Rect();
        this.O0000ooo = new Point();
        this.O00oOooO = new Point();
        this.O000O0o0 = new GestureDetector.SimpleOnGestureListener() {
            /* class com.xiaomi.smarthome.library.common.widget.MaterialRippleLayout.AnonymousClass2 */

            public final void onLongPress(MotionEvent motionEvent) {
                MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                materialRippleLayout.O0000OoO = materialRippleLayout.O0000O0o != null && MaterialRippleLayout.this.O0000O0o.performLongClick();
                if (MaterialRippleLayout.this.O0000OoO) {
                    if (MaterialRippleLayout.this.f9209O000000o) {
                        MaterialRippleLayout.this.O000000o(null);
                    }
                    MaterialRippleLayout.this.O000000o();
                }
            }

            public final boolean onDown(MotionEvent motionEvent) {
                MaterialRippleLayout.this.O0000OoO = false;
                return super.onDown(motionEvent);
            }
        };
        this.O000O0oO = false;
        this.O0000Ooo = null;
        this.O0000o00 = new Property<MaterialRippleLayout, Float>(Float.class, "radius") {
            /* class com.xiaomi.smarthome.library.common.widget.MaterialRippleLayout.AnonymousClass4 */

            public final /* synthetic */ Object get(Object obj) {
                return Float.valueOf(((MaterialRippleLayout) obj).getRadius());
            }

            public final /* synthetic */ void set(Object obj, Object obj2) {
                ((MaterialRippleLayout) obj).setRadius(((Float) obj2).floatValue());
            }
        };
        this.O000O0oo = new Property<MaterialRippleLayout, Integer>(Integer.class, "rippleAlpha") {
            /* class com.xiaomi.smarthome.library.common.widget.MaterialRippleLayout.AnonymousClass5 */

            public final /* synthetic */ Object get(Object obj) {
                return Integer.valueOf(((MaterialRippleLayout) obj).getRippleAlpha());
            }

            public final /* synthetic */ void set(Object obj, Object obj2) {
                ((MaterialRippleLayout) obj).setRippleAlpha((Integer) obj2);
            }
        };
        this.O000OO00 = false;
        this.O000OO0o = true;
        setWillNotDraw(false);
        this.O000O0OO = new GestureDetector(context, this.O000O0o0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mrl_rippleAlpha, R.attr.mrl_rippleBackground, R.attr.mrl_rippleColor, R.attr.mrl_rippleDelayClick, R.attr.mrl_rippleDimension, R.attr.mrl_rippleDuration, R.attr.mrl_rippleFadeDuration, R.attr.mrl_rippleHover, R.attr.mrl_rippleInAdapter, R.attr.mrl_rippleOverlay, R.attr.mrl_ripplePersistent, R.attr.mrl_rippleRoundedCorners});
        this.O0000o0o = obtainStyledAttributes.getColor(2, -16777216);
        this.O00000Oo = obtainStyledAttributes.getDimensionPixelSize(4, (int) TypedValue.applyDimension(1, 35.0f, getResources().getDisplayMetrics()));
        this.O0000o = obtainStyledAttributes.getBoolean(9, false);
        this.f9209O000000o = obtainStyledAttributes.getBoolean(7, true);
        this.O0000oO0 = obtainStyledAttributes.getInt(5, 350);
        this.O00000o0 = (int) (obtainStyledAttributes.getFloat(0, 0.2f) * 255.0f);
        this.O00000o = obtainStyledAttributes.getBoolean(3, true);
        this.O0000oO = obtainStyledAttributes.getInteger(6, 75);
        this.O0000oOO = new ColorDrawable(obtainStyledAttributes.getColor(1, 0));
        this.O00000oO = obtainStyledAttributes.getBoolean(10, false);
        this.O00000oo = obtainStyledAttributes.getBoolean(8, false);
        this.O0000oOo = (float) obtainStyledAttributes.getDimensionPixelSize(11, 0);
        obtainStyledAttributes.recycle();
        this.O0000o0.setColor(this.O0000o0o);
        this.O0000o0.setAlpha(this.O00000o0);
        O00000o();
    }

    public <T extends View> T getChildView() {
        return this.O0000O0o;
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            this.O0000O0o = view;
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout can host only one child");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view = this.O0000O0o;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        View view = this.O0000O0o;
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r0.isFocusableInTouchMode() != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (r0.isFocusableInTouchMode() != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r10 = true;
     */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view = this.O0000O0o;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        loop0:
        while (true) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i = 0;
                while (i < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i);
                    Rect rect = new Rect();
                    childAt.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        x -= rect.left;
                        y -= rect.top;
                        view = childAt;
                    } else {
                        i++;
                    }
                }
                break loop0;
            } else if (view != this.O0000O0o) {
                if (view.isEnabled()) {
                    if (!view.isClickable()) {
                        if (!view.isLongClickable()) {
                        }
                    }
                }
            }
        }
        if (view != null) {
        }
        boolean z = false;
        return !z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!isEnabled() || ((view = this.O0000O0o) != null && !view.isEnabled())) {
            return onTouchEvent;
        }
        boolean contains = this.O0000o0O.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (contains) {
            this.O00oOooO.set(this.O0000ooo.x, this.O0000ooo.y);
            this.O0000ooo.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.O000O0OO.onTouchEvent(motionEvent) && !this.O0000OoO) {
            int actionMasked = motionEvent.getActionMasked();
            boolean z = false;
            if (actionMasked == 0) {
                if (this.O00000oo) {
                    this.O000O00o = O00000Oo().getPositionForView(this);
                }
                this.O0000Oo0 = false;
                this.O00oOoOo = new O00000Oo(motionEvent);
                ViewParent parent = getParent();
                while (true) {
                    if (parent == null || !(parent instanceof ViewGroup)) {
                        break;
                    } else if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (z) {
                    O000000o();
                    this.O0000Oo = true;
                    postDelayed(this.O00oOoOo, (long) ViewConfiguration.getTapTimeout());
                } else {
                    this.O00oOoOo.run();
                }
            } else if (actionMasked == 1) {
                this.O000O0Oo = new O000000o(this, (byte) 0);
                if (this.O0000Oo) {
                    View view2 = this.O0000O0o;
                    if (view2 != null) {
                        view2.setPressed(true);
                    }
                    postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.library.common.widget.MaterialRippleLayout.AnonymousClass1 */

                        public final void run() {
                            if (MaterialRippleLayout.this.O0000O0o != null) {
                                MaterialRippleLayout.this.O0000O0o.setPressed(false);
                            }
                        }
                    }, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (contains) {
                    O000000o(this.O000O0Oo);
                } else if (!this.f9209O000000o) {
                    setRadius(0.0f);
                }
                if (!this.O00000o && contains) {
                    this.O000O0Oo.run();
                }
                O000000o();
            } else if (actionMasked == 2) {
                if (this.f9209O000000o) {
                    if (contains && !this.O0000Oo0) {
                        invalidate();
                    } else if (!contains) {
                        O000000o(null);
                    }
                }
                if (!contains) {
                    O000000o();
                    ObjectAnimator objectAnimator = this.O0000OOo;
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                    }
                    View view3 = this.O0000O0o;
                    if (view3 != null) {
                        view3.onTouchEvent(motionEvent);
                    }
                    this.O0000Oo0 = true;
                }
            } else if (actionMasked == 3) {
                if (this.O00000oo) {
                    this.O0000ooo.set(this.O00oOooO.x, this.O00oOooO.y);
                    this.O00oOooO = new Point();
                }
                View view4 = this.O0000O0o;
                if (view4 != null) {
                    view4.onTouchEvent(motionEvent);
                }
                if (!this.f9209O000000o) {
                    View view5 = this.O0000O0o;
                    if (view5 != null) {
                        view5.setPressed(false);
                    }
                } else if (!this.O0000Oo) {
                    O000000o(null);
                }
                O000000o();
            }
        }
        return true;
    }

    public final void O000000o() {
        O00000Oo o00000Oo = this.O00oOoOo;
        if (o00000Oo != null) {
            removeCallbacks(o00000Oo);
            this.O0000Oo = false;
        }
    }

    public void setExpandedColor(int i) {
        this.O000O0o = i;
        setBackgroundColor(i);
    }

    public final void O000000o(final Runnable runnable) {
        if (!this.O0000Oo0) {
            float endRadius = getEndRadius();
            O00000o0();
            setBackgroundColor(0);
            this.O0000ooO = new AnimatorSet();
            this.O0000ooO.addListener(new AnimatorListenerAdapter() {
                /* class com.xiaomi.smarthome.library.common.widget.MaterialRippleLayout.AnonymousClass3 */

                public final void onAnimationEnd(Animator animator) {
                    if (!MaterialRippleLayout.this.O00000oO) {
                        MaterialRippleLayout.this.setRadius(0.0f);
                        MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                        materialRippleLayout.setRippleAlpha(Integer.valueOf(materialRippleLayout.O00000o0));
                    }
                    if (runnable != null && MaterialRippleLayout.this.O00000o) {
                        runnable.run();
                    }
                    if (MaterialRippleLayout.this.O0000O0o != null) {
                        MaterialRippleLayout.this.O0000O0o.setPressed(false);
                    }
                }
            });
            Property<MaterialRippleLayout, Float> property = this.O0000o00;
            float[] fArr = new float[2];
            fArr[0] = this.O000O0oO ? this.O0000oo0 : endRadius;
            fArr[1] = this.O000O0oO ? endRadius : 0.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, property, fArr);
            ofFloat.setDuration((long) this.O0000oO0);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, this.O000O0oo, this.O00000o0, 0);
            ofInt.setDuration((long) this.O0000oO);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setStartDelay((long) ((this.O0000oO0 - this.O0000oO) - 50));
            if (this.O00000oO) {
                this.O0000ooO.play(ofFloat);
            } else if (getRadius() > endRadius) {
                ofInt.setStartDelay(0);
                this.O0000ooO.play(ofInt);
            } else {
                this.O0000ooO.playTogether(ofFloat, ofInt);
            }
            this.O0000ooO.start();
        }
    }

    private void O00000o0() {
        AnimatorSet animatorSet = this.O0000ooO;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.O0000ooO.removeAllListeners();
        }
        ObjectAnimator objectAnimator = this.O0000OOo;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private float getEndRadius() {
        int width = getWidth();
        int height = getHeight();
        return ((float) Math.sqrt(Math.pow((double) ((float) (width / 2 > this.O0000ooo.x ? width - this.O0000ooo.x : this.O0000ooo.x)), 2.0d) + Math.pow((double) ((float) (height / 2 > this.O0000ooo.y ? height - this.O0000ooo.y : this.O0000ooo.y)), 2.0d))) * 1.2f;
    }

    public final AdapterView O00000Oo() {
        AdapterView adapterView = this.O0000oo;
        if (adapterView != null) {
            return adapterView;
        }
        ViewParent parent = getParent();
        while (!(parent instanceof AdapterView)) {
            try {
                parent = parent.getParent();
            } catch (NullPointerException unused) {
                throw new RuntimeException("Could not find a parent AdapterView");
            }
        }
        this.O0000oo = (AdapterView) parent;
        return this.O0000oo;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O0000o0O.set(0, 0, i, i2);
        this.O0000oOO.setBounds(this.O0000o0O);
    }

    public void draw(Canvas canvas) {
        if (!this.O000OO0o) {
            super.draw(canvas);
            return;
        }
        if (this.O000OO00 && this.O0000Ooo == null) {
            this.O0000Ooo = new Path();
            this.O0000Ooo.addCircle((float) (getWidth() / 2), (float) (getWidth() / 2), (float) (getWidth() / 2), Path.Direction.CW);
        }
        if (this.O000OO00) {
            canvas.clipPath(this.O0000Ooo, Region.Op.INTERSECT);
        } else {
            gsy.O000000o(3, "hzd1", "");
        }
        boolean z = false;
        if (this.O00000oo) {
            int positionForView = O00000Oo().getPositionForView(this);
            boolean z2 = positionForView != this.O000O00o;
            this.O000O00o = positionForView;
            if (z2) {
                O000000o();
                O00000o0();
                View view = this.O0000O0o;
                if (view != null) {
                    view.setPressed(false);
                }
                setRadius(0.0f);
            }
            z = z2;
        }
        if (this.O0000o) {
            if (!z) {
                this.O0000oOO.draw(canvas);
            }
            super.draw(canvas);
            if (!z) {
                if (this.O0000oOo != 0.0f) {
                    Path path = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
                    float f = this.O0000oOo;
                    path.addRoundRect(rectF, f, f, Path.Direction.CW);
                    canvas.clipPath(path);
                }
                canvas.drawCircle((float) this.O0000ooo.x, (float) this.O0000ooo.y, this.O0000oo0, this.O0000o0);
            }
        } else {
            if (!z) {
                this.O0000oOO.draw(canvas);
                canvas.drawCircle((float) this.O0000ooo.x, (float) this.O0000ooo.y, this.O0000oo0, this.O0000o0);
            }
            super.draw(canvas);
        }
        if (this.O000OO00) {
            gsy.O000000o(3, "hzd1", "round clip radius=" + this.O0000oo0 + ",rippleOverlay=" + this.O0000o);
            return;
        }
        gsy.O000000o(3, "hzd1", "normal radius=" + this.O0000oo0 + ",rippleOverlay=" + this.O0000o);
    }

    public float getRadius() {
        return this.O0000oo0;
    }

    public void setRadius(float f) {
        this.O0000oo0 = f;
        invalidate();
    }

    public int getRippleAlpha() {
        return this.O0000o0.getAlpha();
    }

    public void setRippleAlpha(Integer num) {
        this.O0000o0.setAlpha(num.intValue());
        invalidate();
    }

    public void setRippleColor(int i) {
        this.O0000o0o = i;
        this.O0000o0.setColor(i);
        this.O0000o0.setAlpha(this.O00000o0);
        invalidate();
    }

    public void setRippleOverlay(boolean z) {
        this.O0000o = z;
    }

    public void setRippleDiameter(int i) {
        this.O00000Oo = i;
    }

    public void setRippleDuration(int i) {
        this.O0000oO0 = i;
    }

    public void setRippleBackground(int i) {
        this.O0000oOO = new ColorDrawable(i);
        this.O0000oOO.setBounds(this.O0000o0O);
        invalidate();
    }

    public void setRippleHover(boolean z) {
        this.f9209O000000o = z;
    }

    public void setRippleDelayClick(boolean z) {
        this.O00000o = z;
    }

    public void setRippleFadeDuration(int i) {
        this.O0000oO = i;
    }

    public void setRipplePersistent(boolean z) {
        this.O00000oO = z;
    }

    public void setRippleInAdapter(boolean z) {
        this.O00000oo = z;
    }

    public void setRippleRoundedCorners(int i) {
        this.O0000oOo = (float) i;
        O00000o();
    }

    public void setDefaultRippleAlpha(float f) {
        this.O00000o0 = (int) (f * 255.0f);
        this.O0000o0.setAlpha(this.O00000o0);
        invalidate();
    }

    private void O00000o() {
        if (Build.VERSION.SDK_INT > 17) {
            return;
        }
        if (this.O0000oOo != 0.0f) {
            this.O00oOooo = getLayerType();
            setLayerType(1, null);
            return;
        }
        setLayerType(this.O00oOooo, null);
    }

    class O000000o implements Runnable {
        private O000000o() {
        }

        /* synthetic */ O000000o(MaterialRippleLayout materialRippleLayout, byte b) {
            this();
        }

        public final void run() {
            if (!MaterialRippleLayout.this.O0000OoO) {
                if (MaterialRippleLayout.this.getParent() instanceof AdapterView) {
                    if (MaterialRippleLayout.this.O0000O0o != null && !MaterialRippleLayout.this.O0000O0o.performClick()) {
                        O000000o((AdapterView) MaterialRippleLayout.this.getParent());
                    }
                } else if (MaterialRippleLayout.this.O00000oo) {
                    O000000o(MaterialRippleLayout.this.O00000Oo());
                } else if (MaterialRippleLayout.this.O0000O0o != null) {
                    MaterialRippleLayout.this.O0000O0o.performClick();
                }
            }
        }

        private void O000000o(AdapterView adapterView) {
            int positionForView = adapterView.getPositionForView(MaterialRippleLayout.this);
            long itemId = adapterView.getAdapter() != null ? adapterView.getAdapter().getItemId(positionForView) : 0;
            if (positionForView != -1) {
                adapterView.performItemClick(MaterialRippleLayout.this, positionForView, itemId);
            }
        }
    }

    final class O00000Oo implements Runnable {
        private final MotionEvent O00000Oo;

        public O00000Oo(MotionEvent motionEvent) {
            this.O00000Oo = motionEvent;
        }

        public final void run() {
            MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
            materialRippleLayout.O0000Oo = false;
            if (materialRippleLayout.O0000O0o != null) {
                MaterialRippleLayout.this.O0000O0o.setLongClickable(false);
                MaterialRippleLayout.this.O0000O0o.onTouchEvent(this.O00000Oo);
                MaterialRippleLayout.this.O0000O0o.setPressed(true);
            }
            if (MaterialRippleLayout.this.f9209O000000o) {
                MaterialRippleLayout materialRippleLayout2 = MaterialRippleLayout.this;
                if (!materialRippleLayout2.O0000Oo0) {
                    if (materialRippleLayout2.O0000OOo != null) {
                        materialRippleLayout2.O0000OOo.cancel();
                    }
                    materialRippleLayout2.O0000OOo = ObjectAnimator.ofFloat(materialRippleLayout2, materialRippleLayout2.O0000o00, (float) materialRippleLayout2.O00000Oo, (float) (Math.sqrt(Math.pow((double) materialRippleLayout2.getWidth(), 2.0d) + Math.pow((double) materialRippleLayout2.getHeight(), 2.0d)) * 1.2000000476837158d)).setDuration(2500L);
                    materialRippleLayout2.O0000OOo.setInterpolator(new LinearInterpolator());
                    materialRippleLayout2.O0000OOo.start();
                }
            }
        }
    }

    public void setRoundClipEnabled(boolean z) {
        this.O000OO00 = z;
    }

    public void setRippleAnim(boolean z) {
        this.O000OO0o = z;
    }
}
