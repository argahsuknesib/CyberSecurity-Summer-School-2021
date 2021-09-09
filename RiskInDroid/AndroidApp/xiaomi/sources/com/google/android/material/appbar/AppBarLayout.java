package com.google.android.material.appbar;

import _m_j.OO0000o;
import _m_j.ab;
import _m_j.ak;
import _m_j.bd;
import _m_j.bo;
import _m_j.bw;
import _m_j.cb;
import _m_j.ci;
import _m_j.cl;
import _m_j.co;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.O000000o {
    private static final int DEF_STYLE_RES = 2132739073;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;
    private ci lastInsets;
    private boolean liftOnScroll;
    private WeakReference<View> liftOnScrollTargetView;
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        void onOffsetChanged(AppBarLayout appBarLayout, int i);
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        Context context2 = getContext();
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
            ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, i, DEF_STYLE_RES);
        }
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, new int[]{16842964, 16843919, 16844096, R.attr.elevation, R.attr.expanded, R.attr.liftOnScroll, R.attr.liftOnScrollTargetViewId, R.attr.statusBarForeground}, i, DEF_STYLE_RES, new int[0]);
        cb.O000000o(this, obtainStyledAttributes.getDrawable(0));
        if (getBackground() instanceof ColorDrawable) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            cb.O000000o(this, materialShapeDrawable);
        }
        if (obtainStyledAttributes.hasValue(4)) {
            setExpanded(obtainStyledAttributes.getBoolean(4, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(3)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, (float) obtainStyledAttributes.getDimensionPixelSize(3, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(2)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(2, false));
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(1, false));
            }
        }
        this.liftOnScroll = obtainStyledAttributes.getBoolean(5, false);
        this.liftOnScrollTargetViewId = obtainStyledAttributes.getResourceId(6, -1);
        setStatusBarForeground(obtainStyledAttributes.getDrawable(7));
        obtainStyledAttributes.recycle();
        cb.O000000o(this, new bw() {
            /* class com.google.android.material.appbar.AppBarLayout.AnonymousClass1 */

            public ci onApplyWindowInsets(View view, ci ciVar) {
                return AppBarLayout.this.onWindowInsetChanged(ciVar);
            }
        });
    }

    public void addOnOffsetChangedListener(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (baseOnOffsetChangedListener != null && !this.listeners.contains(baseOnOffsetChangedListener)) {
            this.listeners.add(baseOnOffsetChangedListener);
        }
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null && baseOnOffsetChangedListener != null) {
            list.remove(baseOnOffsetChangedListener);
        }
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarForeground = drawable3;
            Drawable drawable4 = this.statusBarForeground;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                ab.O00000Oo(this.statusBarForeground, cb.O0000Oo0(this));
                this.statusBarForeground.setVisible(getVisibility() == 0, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            cb.O00000oo(this);
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(OO0000o.O00000Oo(getContext(), i));
    }

    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.currentOffset));
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.statusBarForeground;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && cb.O0000ooo(this) && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = ak.O000000o(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (cb.O0000ooo(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                cb.O0000Oo0(getChildAt(childCount), topInset);
            }
        }
        invalidateScrollRanges();
        boolean z2 = false;
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i5).getLayoutParams()).getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
                break;
            } else {
                i5++;
            }
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.liftableOverride) {
            if (this.liftOnScroll || hasCollapsibleChild()) {
                z2 = true;
            }
            setLiftableState(z2);
        }
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    private boolean shouldDrawStatusBarForeground() {
        return this.statusBarForeground != null && getTopInset() > 0;
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).isCollapsible()) {
                return true;
            }
        }
        return false;
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, cb.O000O0oO(this));
    }

    public void setExpanded(boolean z, boolean z2) {
        setExpanded(z, z2, true);
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i = 8;
        }
        this.pendingAction = i2 | i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    /* access modifiers changed from: package-private */
    public boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public final int getTotalScrollRange() {
        int i = this.totalScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.scrollFlags;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if (i2 == 0 && cb.O0000ooo(childAt)) {
                i3 -= getTopInset();
            }
            if ((i4 & 2) != 0) {
                i3 -= cb.O0000o0o(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.totalScrollRange = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i;
        int O0000o0o;
        int i2 = this.downPreScrollRange;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.scrollFlags;
            if ((i4 & 5) != 5) {
                if (i3 > 0) {
                    break;
                }
            } else {
                int i5 = layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i4 & 8) != 0) {
                    O0000o0o = cb.O0000o0o(childAt);
                } else if ((i4 & 2) != 0) {
                    O0000o0o = measuredHeight - cb.O0000o0o(childAt);
                } else {
                    i = i5 + measuredHeight;
                    if (childCount == 0 && cb.O0000ooo(childAt)) {
                        i = Math.min(i, measuredHeight - getTopInset());
                    }
                    i3 += i;
                }
                i = i5 + O0000o0o;
                i = Math.min(i, measuredHeight - getTopInset());
                i3 += i;
            }
        }
        int max = Math.max(0, i3);
        this.downPreScrollRange = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i = this.downScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i4 = layoutParams.scrollFlags;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= cb.O0000o0o(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.downScrollRange = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public void onOffsetChanged(int i) {
        this.currentOffset = i;
        if (!willNotDraw()) {
            cb.O00000oo(this);
        }
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i2);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int O0000o0o = cb.O0000o0o(this);
        if (O0000o0o == 0) {
            int childCount = getChildCount();
            O0000o0o = childCount > 0 ? cb.O0000o0o(getChildAt(childCount - 1)) : 0;
            if (O0000o0o == 0) {
                return getHeight() / 3;
            }
        }
        return (O0000o0o * 2) + topInset;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.liftable ? R.attr.state_liftable : -2131822094;
        iArr[1] = (!this.liftable || !this.lifted) ? -2131822095 : R.attr.state_lifted;
        iArr[2] = this.liftable ? R.attr.state_collapsible : -2131822084;
        iArr[3] = (!this.liftable || !this.lifted) ? -2131822083 : R.attr.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public boolean setLiftable(boolean z) {
        this.liftableOverride = true;
        return setLiftableState(z);
    }

    private boolean setLiftableState(boolean z) {
        if (this.liftable == z) {
            return false;
        }
        this.liftable = z;
        refreshDrawableState();
        return true;
    }

    public boolean setLifted(boolean z) {
        return setLiftedState(z);
    }

    public boolean isLifted() {
        return this.lifted;
    }

    /* access modifiers changed from: package-private */
    public boolean setLiftedState(boolean z) {
        if (this.lifted == z) {
            return false;
        }
        this.lifted = z;
        refreshDrawableState();
        if (!this.liftOnScroll || !(getBackground() instanceof MaterialShapeDrawable)) {
            return true;
        }
        startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable) getBackground(), z);
        return true;
    }

    private void startLiftOnScrollElevationOverlayAnimation(final MaterialShapeDrawable materialShapeDrawable, boolean z) {
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.elevationOverlayAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.elevationOverlayAnimator = ValueAnimator.ofFloat(f, dimension);
        this.elevationOverlayAnimator.setDuration((long) getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.elevationOverlayAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.appbar.AppBarLayout.AnonymousClass2 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                materialShapeDrawable.setElevation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.elevationOverlayAnimator.start();
    }

    public void setLiftOnScroll(boolean z) {
        this.liftOnScroll = z;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.liftOnScrollTargetViewId = i;
        clearLiftOnScrollTargetView();
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldLift(View view) {
        View findLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (findLiftOnScrollTargetView != null) {
            view = findLiftOnScrollTargetView;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    private View findLiftOnScrollTargetView(View view) {
        int i;
        if (this.liftOnScrollTargetView == null && (i = this.liftOnScrollTargetViewId) != -1) {
            View findViewById = view != null ? view.findViewById(i) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (findViewById != null) {
                this.liftOnScrollTargetView = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f);
        }
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.pendingAction;
    }

    /* access modifiers changed from: package-private */
    public void resetPendingAction() {
        this.pendingAction = 0;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        ci ciVar = this.lastInsets;
        if (ciVar != null) {
            return ciVar.O00000Oo();
        }
        return 0;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() == 8 || cb.O0000ooo(childAt)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public ci onWindowInsetChanged(ci ciVar) {
        ci ciVar2 = cb.O0000ooo(this) ? ciVar : null;
        if (!bd.O000000o(this.lastInsets, ciVar2)) {
            this.lastInsets = ciVar2;
            updateWillNotDraw();
            requestLayout();
        }
        return ciVar;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        int scrollFlags = 1;
        Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_scrollFlags, R.attr.layout_scrollInterpolator});
            this.scrollFlags = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }

        public void setScrollFlags(int i) {
            this.scrollFlags = i;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.scrollInterpolator = interpolator;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        /* access modifiers changed from: package-private */
        public boolean isCollapsible() {
            int i = this.scrollFlags;
            return (i & 1) == 1 && (i & 10) != 0;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
        }

        public /* bridge */ /* synthetic */ void setDragCallback(BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        public int offsetDelta;
        private int offsetToChildIndexOnLayout = -1;
        private boolean offsetToChildIndexOnLayoutIsMinHeight;
        private float offsetToChildIndexOnLayoutPerc;
        private BaseDragCallback onDragCallback;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(T t);
        }

        private static boolean checkFlag(int i, int i2) {
            return (i & i2) == i2;
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i2;
            return z;
        }

        private boolean canScrollChildren(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r7, T r8, android.view.View r9, int r10, int r11, int[] r12, int r13) {
            /*
                r6 = this;
                if (r11 == 0) goto L_0x0026
                if (r11 >= 0) goto L_0x0011
                int r10 = r8.getTotalScrollRange()
                int r10 = -r10
                int r13 = r8.getDownNestedPreScrollRange()
                int r13 = r13 + r10
                r4 = r10
                r5 = r13
                goto L_0x0019
            L_0x0011:
                int r10 = r8.getUpNestedPreScrollRange()
                int r10 = -r10
                r13 = 0
                r4 = r10
                r5 = 0
            L_0x0019:
                if (r4 == r5) goto L_0x0026
                r10 = 1
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = r11
                int r7 = r0.scroll(r1, r2, r3, r4, r5)
                r12[r10] = r7
            L_0x0026:
                boolean r7 = r8.isLiftOnScroll()
                if (r7 == 0) goto L_0x0033
                boolean r7 = r8.shouldLift(r9)
                r8.setLiftedState(r7)
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int, int[], int):void");
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = scroll(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                updateAccessibilityActions(coordinatorLayout, t);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, T r3, android.view.View r4, int r5) {
            /*
                r1 = this;
                int r0 = r1.lastStartedType
                if (r0 == 0) goto L_0x0007
                r0 = 1
                if (r5 != r0) goto L_0x0017
            L_0x0007:
                r1.snapToChildIfNeeded(r2, r3)
                boolean r2 = r3.isLiftOnScroll()
                if (r2 == 0) goto L_0x0017
                boolean r2 = r3.shouldLift(r4)
                r3.setLiftedState(r2)
            L_0x0017:
                java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
                r2.<init>(r4)
                r1.lastNestedScrollingChildRef = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int):void");
        }

        public void setDragCallback(BaseDragCallback baseDragCallback) {
            this.onDragCallback = baseDragCallback;
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int i2;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                i2 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i2 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, t, i, i2);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final T t, int i, int i2) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                this.offsetAnimator = new ValueAnimator();
                this.offsetAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.google.android.material.appbar.AppBarLayout.BaseBehavior.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration((long) Math.min(i2, 600));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
            this.offsetAnimator.start();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        private int getChildIndexOnOffset(T r8, int r9) {
            /*
                r7 = this;
                int r0 = r8.getChildCount()
                r1 = 0
            L_0x0005:
                if (r1 >= r0) goto L_0x0034
                android.view.View r2 = r8.getChildAt(r1)
                int r3 = r2.getTop()
                int r4 = r2.getBottom()
                android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r2 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r2
                int r5 = r2.getScrollFlags()
                r6 = 32
                boolean r5 = checkFlag(r5, r6)
                if (r5 == 0) goto L_0x002b
                int r5 = r2.topMargin
                int r3 = r3 - r5
                int r2 = r2.bottomMargin
                int r4 = r4 + r2
            L_0x002b:
                int r2 = -r9
                if (r3 > r2) goto L_0x0031
                if (r4 < r2) goto L_0x0031
                return r1
            L_0x0031:
                int r1 = r1 + 1
                goto L_0x0005
            L_0x0034:
                r8 = -1
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.getChildIndexOnOffset(com.google.android.material.appbar.AppBarLayout, int):int");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        private void snapToChildIfNeeded(androidx.coordinatorlayout.widget.CoordinatorLayout r9, T r10) {
            /*
                r8 = this;
                int r0 = r8.getTopBottomOffsetForScrollingSibling()
                int r1 = r8.getChildIndexOnOffset(r10, r0)
                if (r1 < 0) goto L_0x0075
                android.view.View r2 = r10.getChildAt(r1)
                android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r3 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r3
                int r4 = r3.getScrollFlags()
                r5 = r4 & 17
                r6 = 17
                if (r5 != r6) goto L_0x0075
                int r5 = r2.getTop()
                int r5 = -r5
                int r6 = r2.getBottom()
                int r6 = -r6
                int r7 = r10.getChildCount()
                int r7 = r7 + -1
                if (r1 != r7) goto L_0x0035
                int r1 = r10.getTopInset()
                int r6 = r6 + r1
            L_0x0035:
                r1 = 2
                boolean r7 = checkFlag(r4, r1)
                if (r7 == 0) goto L_0x0042
                int r2 = _m_j.cb.O0000o0o(r2)
                int r6 = r6 + r2
                goto L_0x0053
            L_0x0042:
                r7 = 5
                boolean r7 = checkFlag(r4, r7)
                if (r7 == 0) goto L_0x0053
                int r2 = _m_j.cb.O0000o0o(r2)
                int r2 = r2 + r6
                if (r0 >= r2) goto L_0x0052
                r5 = r2
                goto L_0x0053
            L_0x0052:
                r6 = r2
            L_0x0053:
                r2 = 32
                boolean r2 = checkFlag(r4, r2)
                if (r2 == 0) goto L_0x0061
                int r2 = r3.topMargin
                int r5 = r5 + r2
                int r2 = r3.bottomMargin
                int r6 = r6 - r2
            L_0x0061:
                int r2 = r6 + r5
                int r2 = r2 / r1
                if (r0 >= r2) goto L_0x0067
                r5 = r6
            L_0x0067:
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                r1 = 0
                int r0 = _m_j.ak.O000000o(r5, r0, r1)
                r1 = 0
                r8.animateOffsetTo(r9, r10, r0, r1)
            L_0x0075:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.snapToChildIfNeeded(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout):void");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int, int):boolean
         arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, T, int, int, int, int]
         candidates:
          com.google.android.material.appbar.AppBarLayout.BaseBehavior.onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, int, int):boolean
          androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int, int):boolean */
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.O00000o) t.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, (View) t, i, i2, i3, i4);
            }
            coordinatorLayout.onMeasureChild(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.material.appbar.ViewOffsetBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean
         arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, T, int]
         candidates:
          com.google.android.material.appbar.AppBarLayout.BaseBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int):boolean
          com.google.android.material.appbar.ViewOffsetBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean */
        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout r8, T r9, int r10) {
            /*
                r7 = this;
                boolean r10 = super.onLayoutChild(r8, r9, r10)
                int r0 = r9.getPendingAction()
                int r1 = r7.offsetToChildIndexOnLayout
                r2 = 0
                if (r1 < 0) goto L_0x003a
                r3 = r0 & 8
                if (r3 != 0) goto L_0x003a
                android.view.View r0 = r9.getChildAt(r1)
                int r1 = r0.getBottom()
                int r1 = -r1
                boolean r3 = r7.offsetToChildIndexOnLayoutIsMinHeight
                if (r3 == 0) goto L_0x0028
                int r0 = _m_j.cb.O0000o0o(r0)
                int r3 = r9.getTopInset()
                int r0 = r0 + r3
                goto L_0x0035
            L_0x0028:
                int r0 = r0.getHeight()
                float r0 = (float) r0
                float r3 = r7.offsetToChildIndexOnLayoutPerc
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
            L_0x0035:
                int r1 = r1 + r0
                r7.setHeaderTopBottomOffset(r8, r9, r1)
                goto L_0x0064
            L_0x003a:
                if (r0 == 0) goto L_0x0064
                r1 = r0 & 4
                r3 = 1
                if (r1 == 0) goto L_0x0043
                r1 = 1
                goto L_0x0044
            L_0x0043:
                r1 = 0
            L_0x0044:
                r4 = r0 & 2
                r5 = 0
                if (r4 == 0) goto L_0x0058
                int r0 = r9.getUpNestedPreScrollRange()
                int r0 = -r0
                if (r1 == 0) goto L_0x0054
                r7.animateOffsetTo(r8, r9, r0, r5)
                goto L_0x0064
            L_0x0054:
                r7.setHeaderTopBottomOffset(r8, r9, r0)
                goto L_0x0064
            L_0x0058:
                r0 = r0 & r3
                if (r0 == 0) goto L_0x0064
                if (r1 == 0) goto L_0x0061
                r7.animateOffsetTo(r8, r9, r2, r5)
                goto L_0x0064
            L_0x0061:
                r7.setHeaderTopBottomOffset(r8, r9, r2)
            L_0x0064:
                r9.resetPendingAction()
                r0 = -1
                r7.offsetToChildIndexOnLayout = r0
                int r0 = r7.getTopAndBottomOffset()
                int r1 = r9.getTotalScrollRange()
                int r1 = -r1
                int r0 = _m_j.ak.O000000o(r0, r1, r2)
                r7.setTopAndBottomOffset(r0)
                int r4 = r7.getTopAndBottomOffset()
                r5 = 0
                r6 = 1
                r1 = r7
                r2 = r8
                r3 = r9
                r1.updateAppBarLayoutDrawableState(r2, r3, r4, r5, r6)
                int r0 = r7.getTopAndBottomOffset()
                r9.onOffsetChanged(r0)
                r7.updateAccessibilityActions(r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int):boolean");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O00000oo(android.view.View, int):void
         arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, int]
         candidates:
          _m_j.cb.O00000oo(android.view.View, float):void
          _m_j.cb.O00000oo(android.view.View, int):void */
        private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, T t) {
            cb.O00000oo((View) coordinatorLayout, cl.O000000o.O0000o00.O000000o());
            cb.O00000oo((View) coordinatorLayout, cl.O000000o.O0000o0.O000000o());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild != null && t.getTotalScrollRange() != 0 && (((CoordinatorLayout.O00000o) findFirstScrollingChild.getLayoutParams()).f2811O000000o instanceof ScrollingViewBehavior)) {
                addAccessibilityScrollActions(coordinatorLayout, t, findFirstScrollingChild);
            }
        }

        private void addAccessibilityScrollActions(CoordinatorLayout coordinatorLayout, T t, View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                addActionToExpand(coordinatorLayout, t, cl.O000000o.O0000o00, false);
            }
            if (getTopBottomOffsetForScrollingSibling() == 0) {
                return;
            }
            if (view.canScrollVertically(-1)) {
                final int i = -t.getDownNestedPreScrollRange();
                if (i != 0) {
                    final CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
                    final T t2 = t;
                    final View view2 = view;
                    cb.O000000o(coordinatorLayout, cl.O000000o.O0000o0, new co() {
                        /* class com.google.android.material.appbar.AppBarLayout.BaseBehavior.AnonymousClass2 */

                        public boolean perform(View view, co.O000000o o000000o) {
                            BaseBehavior.this.onNestedPreScroll(coordinatorLayout2, t2, view2, 0, i, new int[]{0, 0}, 1);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            addActionToExpand(coordinatorLayout, t, cl.O000000o.O0000o0, true);
        }

        private void addActionToExpand(CoordinatorLayout coordinatorLayout, final T t, cl.O000000o o000000o, final boolean z) {
            cb.O000000o(coordinatorLayout, o000000o, new co() {
                /* class com.google.android.material.appbar.AppBarLayout.BaseBehavior.AnonymousClass3 */

                public boolean perform(View view, co.O000000o o000000o) {
                    t.setExpanded(z);
                    return true;
                }
            });
        }

        /* access modifiers changed from: package-private */
        public boolean canDragView(T t) {
            BaseDragCallback baseDragCallback = this.onDragCallback;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t);
            }
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onFlingFinished(androidx.coordinatorlayout.widget.CoordinatorLayout r2, T r3) {
            /*
                r1 = this;
                r1.snapToChildIfNeeded(r2, r3)
                boolean r0 = r3.isLiftOnScroll()
                if (r0 == 0) goto L_0x0014
                android.view.View r2 = r1.findFirstScrollingChild(r2)
                boolean r2 = r3.shouldLift(r2)
                r3.setLiftedState(r2)
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onFlingFinished(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout):void");
        }

        /* access modifiers changed from: package-private */
        public int getMaxDragOffset(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* access modifiers changed from: package-private */
        public int getScrollRangeForDragFling(T t) {
            return t.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public int setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout r9, T r10, int r11, int r12, int r13) {
            /*
                r8 = this;
                int r0 = r8.getTopBottomOffsetForScrollingSibling()
                r1 = 0
                if (r12 == 0) goto L_0x0048
                if (r0 < r12) goto L_0x0048
                if (r0 > r13) goto L_0x0048
                int r5 = _m_j.ak.O000000o(r11, r12, r13)
                if (r0 == r5) goto L_0x004a
                boolean r11 = r10.hasChildWithInterpolator()
                if (r11 == 0) goto L_0x001c
                int r11 = r8.interpolateOffset(r10, r5)
                goto L_0x001d
            L_0x001c:
                r11 = r5
            L_0x001d:
                boolean r12 = r8.setTopAndBottomOffset(r11)
                int r1 = r0 - r5
                int r11 = r5 - r11
                r8.offsetDelta = r11
                if (r12 != 0) goto L_0x0032
                boolean r11 = r10.hasChildWithInterpolator()
                if (r11 == 0) goto L_0x0032
                r9.dispatchDependentViewsChanged(r10)
            L_0x0032:
                int r11 = r8.getTopAndBottomOffset()
                r10.onOffsetChanged(r11)
                if (r5 >= r0) goto L_0x003e
                r11 = -1
                r6 = -1
                goto L_0x0040
            L_0x003e:
                r11 = 1
                r6 = 1
            L_0x0040:
                r7 = 0
                r2 = r8
                r3 = r9
                r4 = r10
                r2.updateAppBarLayoutDrawableState(r3, r4, r5, r6, r7)
                goto L_0x004a
            L_0x0048:
                r8.offsetDelta = r1
            L_0x004a:
                r8.updateAccessibilityActions(r9, r10)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, int):int");
        }

        /* access modifiers changed from: package-private */
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        private int interpolateOffset(T r9, int r10) {
            /*
                r8 = this;
                int r0 = java.lang.Math.abs(r10)
                int r1 = r9.getChildCount()
                r2 = 0
                r3 = 0
            L_0x000a:
                if (r3 >= r1) goto L_0x0072
                android.view.View r4 = r9.getChildAt(r3)
                android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r5 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r5
                android.view.animation.Interpolator r6 = r5.getScrollInterpolator()
                int r7 = r4.getTop()
                if (r0 < r7) goto L_0x006f
                int r7 = r4.getBottom()
                if (r0 > r7) goto L_0x006f
                if (r6 == 0) goto L_0x0072
                int r1 = r5.getScrollFlags()
                r3 = r1 & 1
                if (r3 == 0) goto L_0x0044
                int r3 = r4.getHeight()
                int r7 = r5.topMargin
                int r3 = r3 + r7
                int r5 = r5.bottomMargin
                int r3 = r3 + r5
                int r2 = r2 + r3
                r1 = r1 & 2
                if (r1 == 0) goto L_0x0044
                int r1 = _m_j.cb.O0000o0o(r4)
                int r2 = r2 - r1
            L_0x0044:
                boolean r1 = _m_j.cb.O0000ooo(r4)
                if (r1 == 0) goto L_0x004f
                int r9 = r9.getTopInset()
                int r2 = r2 - r9
            L_0x004f:
                if (r2 <= 0) goto L_0x0072
                int r9 = r4.getTop()
                int r0 = r0 - r9
                float r9 = (float) r2
                float r0 = (float) r0
                float r0 = r0 / r9
                float r0 = r6.getInterpolation(r0)
                float r9 = r9 * r0
                int r9 = java.lang.Math.round(r9)
                int r10 = java.lang.Integer.signum(r10)
                int r0 = r4.getTop()
                int r0 = r0 + r9
                int r10 = r10 * r0
                return r10
            L_0x006f:
                int r3 = r3 + 1
                goto L_0x000a
            L_0x0072:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.interpolateOffset(com.google.android.material.appbar.AppBarLayout, int):int");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        private void updateAppBarLayoutDrawableState(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = getAppBarChildOnOffset(r7, r8)
                if (r0 == 0) goto L_0x0060
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r1 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r1
                int r1 = r1.getScrollFlags()
                r2 = r1 & 1
                r3 = 0
                if (r2 == 0) goto L_0x0041
                int r2 = _m_j.cb.O0000o0o(r0)
                r4 = 1
                if (r9 <= 0) goto L_0x002f
                r9 = r1 & 12
                if (r9 == 0) goto L_0x002f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
            L_0x002d:
                r3 = 1
                goto L_0x0041
            L_0x002f:
                r9 = r1 & 2
                if (r9 == 0) goto L_0x0041
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
                goto L_0x002d
            L_0x0041:
                boolean r8 = r7.isLiftOnScroll()
                if (r8 == 0) goto L_0x004f
                android.view.View r8 = r5.findFirstScrollingChild(r6)
                boolean r3 = r7.shouldLift(r8)
            L_0x004f:
                boolean r8 = r7.setLiftedState(r3)
                if (r10 != 0) goto L_0x005d
                if (r8 == 0) goto L_0x0060
                boolean r6 = r5.shouldJumpElevationState(r6, r7)
                if (r6 == 0) goto L_0x0060
            L_0x005d:
                r7.jumpDrawablesToCurrentState()
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.updateAppBarLayoutDrawableState(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        private boolean shouldJumpElevationState(CoordinatorLayout coordinatorLayout, T t) {
            List<View> dependents = coordinatorLayout.getDependents(t);
            int size = dependents.size();
            int i = 0;
            while (i < size) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.O00000o) dependents.get(i).getLayoutParams()).f2811O000000o;
                if (!(behavior instanceof ScrollingViewBehavior)) {
                    i++;
                } else if (((ScrollingViewBehavior) behavior).getOverlayTop() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof bo) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View):android.os.Parcelable
         arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, T]
         candidates:
          com.google.android.material.appbar.AppBarLayout.BaseBehavior.onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout):android.os.Parcelable
          androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View):android.os.Parcelable */
        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public android.os.Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout r8, T r9) {
            /*
                r7 = this;
                android.os.Parcelable r8 = super.onSaveInstanceState(r8, r9)
                int r0 = r7.getTopAndBottomOffset()
                int r1 = r9.getChildCount()
                r2 = 0
                r3 = 0
            L_0x000e:
                if (r3 >= r1) goto L_0x0044
                android.view.View r4 = r9.getChildAt(r3)
                int r5 = r4.getBottom()
                int r5 = r5 + r0
                int r6 = r4.getTop()
                int r6 = r6 + r0
                if (r6 > 0) goto L_0x0041
                if (r5 < 0) goto L_0x0041
                com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState r0 = new com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState
                r0.<init>(r8)
                r0.firstVisibleChildIndex = r3
                int r8 = _m_j.cb.O0000o0o(r4)
                int r9 = r9.getTopInset()
                int r8 = r8 + r9
                if (r5 != r8) goto L_0x0035
                r2 = 1
            L_0x0035:
                r0.firstVisibleChildAtMinimumHeight = r2
                float r8 = (float) r5
                int r9 = r4.getHeight()
                float r9 = (float) r9
                float r8 = r8 / r9
                r0.firstVisibleChildPercentageShown = r8
                return r0
            L_0x0041:
                int r3 = r3 + 1
                goto L_0x000e
            L_0x0044:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout):android.os.Parcelable");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onRestoreInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.os.Parcelable):void
         arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, T, android.os.Parcelable]
         candidates:
          com.google.android.material.appbar.AppBarLayout.BaseBehavior.onRestoreInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.os.Parcelable):void
          androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onRestoreInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.os.Parcelable):void */
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, (View) t, savedState.getSuperState());
                this.offsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
                this.offsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
                this.offsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, (View) t, parcelable);
            this.offsetToChildIndexOnLayout = -1;
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* class com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.AnonymousClass1 */

                public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                public final SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                public final SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : 0);
            }
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.behavior_overlapTop});
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            obtainStyledAttributes.recycle();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O00000oo(android.view.View, int):void
         arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, int]
         candidates:
          _m_j.cb.O00000oo(android.view.View, float):void
          _m_j.cb.O00000oo(android.view.View, int):void */
        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                cb.O00000oo((View) coordinatorLayout, cl.O000000o.O0000o00.O000000o());
                cb.O00000oo((View) coordinatorLayout, cl.O000000o.O0000o0.O000000o());
            }
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.tempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.O00000o) view2.getLayoutParams()).f2811O000000o;
            if (behavior instanceof BaseBehavior) {
                cb.O0000Oo0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        /* access modifiers changed from: package-private */
        public float getOverlapRatioForOffset(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) appBarLayoutOffset) / ((float) i)) + 1.0f;
                }
            }
            return 0.0f;
        }

        private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.O00000o) appBarLayout.getLayoutParams()).f2811O000000o;
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }
    }
}
