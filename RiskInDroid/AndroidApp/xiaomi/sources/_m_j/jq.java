package _m_j;

import _m_j.jp;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class jq extends jv implements jp {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<jp.O000000o> f2046O000000o;
    final Drawable.Callback O00000Oo;
    private O000000o O00000o;
    private Context O00000oO;
    private ArgbEvaluator O00000oo;
    private Animator.AnimatorListener O0000O0o;

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    jq() {
        this(null, (byte) 0);
    }

    private jq(Context context) {
        this(context, (byte) 0);
    }

    private jq(Context context, byte b) {
        this.O00000oo = null;
        this.O0000O0o = null;
        this.f2046O000000o = null;
        this.O00000Oo = new Drawable.Callback() {
            /* class _m_j.jq.AnonymousClass1 */

            public final void invalidateDrawable(Drawable drawable) {
                jq.this.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                jq.this.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                jq.this.unscheduleSelf(runnable);
            }
        };
        this.O00000oO = context;
        this.O00000o = new O000000o(null, this.O00000Oo, null);
    }

    public final Drawable mutate() {
        if (this.O00000o0 != null) {
            this.O00000o0.mutate();
        }
        return this;
    }

    public static jq O000000o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        jq jqVar = new jq(context);
        jqVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return jqVar;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.O00000o0 == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new O00000Oo(this.O00000o0.getConstantState());
    }

    public final int getChangingConfigurations() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.O00000o.f2048O000000o;
    }

    public final void draw(Canvas canvas) {
        if (this.O00000o0 != null) {
            this.O00000o0.draw(canvas);
            return;
        }
        this.O00000o.O00000Oo.draw(canvas);
        if (this.O00000o.O00000o0.isStarted()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.O00000o0 != null) {
            this.O00000o0.setBounds(rect);
        } else {
            this.O00000o.O00000Oo.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.O00000o0 != null) {
            return this.O00000o0.setState(iArr);
        }
        return this.O00000o.O00000Oo.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public final boolean onLevelChange(int i) {
        if (this.O00000o0 != null) {
            return this.O00000o0.setLevel(i);
        }
        return this.O00000o.O00000Oo.setLevel(i);
    }

    public final int getAlpha() {
        if (this.O00000o0 != null) {
            return ab.O00000Oo(this.O00000o0);
        }
        return this.O00000o.O00000Oo.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.O00000o0 != null) {
            this.O00000o0.setAlpha(i);
        } else {
            this.O00000o.O00000Oo.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.O00000o0 != null) {
            this.O00000o0.setColorFilter(colorFilter);
        } else {
            this.O00000o.O00000Oo.setColorFilter(colorFilter);
        }
    }

    public final ColorFilter getColorFilter() {
        if (this.O00000o0 != null) {
            return ab.O00000o(this.O00000o0);
        }
        return this.O00000o.O00000Oo.getColorFilter();
    }

    public final void setTint(int i) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, i);
        } else {
            this.O00000o.O00000Oo.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, colorStateList);
        } else {
            this.O00000o.O00000Oo.setTintList(colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, mode);
        } else {
            this.O00000o.O00000Oo.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.O00000o0 != null) {
            return this.O00000o0.setVisible(z, z2);
        }
        this.O00000o.O00000Oo.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.O00000o0 != null) {
            return this.O00000o0.isStateful();
        }
        return this.O00000o.O00000Oo.isStateful();
    }

    public final int getOpacity() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getOpacity();
        }
        return this.O00000o.O00000Oo.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getIntrinsicWidth();
        }
        return this.O00000o.O00000Oo.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getIntrinsicHeight();
        }
        return this.O00000o.O00000Oo.getIntrinsicHeight();
    }

    public final boolean isAutoMirrored() {
        if (this.O00000o0 != null) {
            return ab.O000000o(this.O00000o0);
        }
        return this.O00000o.O00000Oo.isAutoMirrored();
    }

    public final void setAutoMirrored(boolean z) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, z);
        } else {
            this.O00000o.O00000Oo.setAutoMirrored(z);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Animator animator;
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray O000000o2 = n.O000000o(resources, theme, attributeSet, jo.O00000oO);
                    int resourceId = O000000o2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        jw O000000o3 = jw.O000000o(resources, resourceId, theme);
                        O000000o3.O00000o = false;
                        O000000o3.setCallback(this.O00000Oo);
                        if (this.O00000o.O00000Oo != null) {
                            this.O00000o.O00000Oo.setCallback(null);
                        }
                        this.O00000o.O00000Oo = O000000o3;
                    }
                    O000000o2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, jo.O00000oo);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.O00000oO;
                        if (context != null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                animator = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                animator = js.O000000o(context, context.getResources(), context.getTheme(), resourceId2);
                            }
                            animator.setTarget(this.O00000o.O00000Oo.O00000Oo.O00000Oo.O0000OoO.get(string));
                            if (Build.VERSION.SDK_INT < 21) {
                                O000000o(animator);
                            }
                            if (this.O00000o.O00000o == null) {
                                this.O00000o.O00000o = new ArrayList<>();
                                this.O00000o.O00000oO = new o0O0OOO0<>();
                            }
                            this.O00000o.O00000o.add(animator);
                            this.O00000o.O00000oO.put(animator, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        O000000o o000000o = this.O00000o;
        if (o000000o.O00000o0 == null) {
            o000000o.O00000o0 = new AnimatorSet();
        }
        o000000o.O00000o0.playTogether(o000000o.O00000o);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Resources.Theme theme) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.O00000o0 != null) {
            return ab.O00000o0(this.O00000o0);
        }
        return false;
    }

    static class O00000Oo extends Drawable.ConstantState {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Drawable.ConstantState f2049O000000o;

        public O00000Oo(Drawable.ConstantState constantState) {
            this.f2049O000000o = constantState;
        }

        public final Drawable newDrawable() {
            jq jqVar = new jq();
            jqVar.O00000o0 = this.f2049O000000o.newDrawable();
            jqVar.O00000o0.setCallback(jqVar.O00000Oo);
            return jqVar;
        }

        public final Drawable newDrawable(Resources resources) {
            jq jqVar = new jq();
            jqVar.O00000o0 = this.f2049O000000o.newDrawable(resources);
            jqVar.O00000o0.setCallback(jqVar.O00000Oo);
            return jqVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            jq jqVar = new jq();
            jqVar.O00000o0 = this.f2049O000000o.newDrawable(resources, theme);
            jqVar.O00000o0.setCallback(jqVar.O00000Oo);
            return jqVar;
        }

        public final boolean canApplyTheme() {
            return this.f2049O000000o.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.f2049O000000o.getChangingConfigurations();
        }
    }

    static class O000000o extends Drawable.ConstantState {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2048O000000o;
        jw O00000Oo;
        ArrayList<Animator> O00000o;
        AnimatorSet O00000o0;
        o0O0OOO0<Animator, String> O00000oO;

        public O000000o(O000000o o000000o, Drawable.Callback callback, Resources resources) {
        }

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final int getChangingConfigurations() {
            return this.f2048O000000o;
        }
    }

    private void O000000o(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                O000000o(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.O00000oo == null) {
                    this.O00000oo = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.O00000oo);
            }
        }
    }

    public final boolean isRunning() {
        if (this.O00000o0 != null) {
            return ((AnimatedVectorDrawable) this.O00000o0).isRunning();
        }
        return this.O00000o.O00000o0.isRunning();
    }

    public final void start() {
        if (this.O00000o0 != null) {
            ((AnimatedVectorDrawable) this.O00000o0).start();
        } else if (!this.O00000o.O00000o0.isStarted()) {
            this.O00000o.O00000o0.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.O00000o0 != null) {
            ((AnimatedVectorDrawable) this.O00000o0).stop();
        } else {
            this.O00000o.O00000o0.end();
        }
    }
}
