package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.Animation;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.layoutanimation.OpacityAnimation;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import com.facebook.yoga.YogaConstants;

public class ReactViewGroup extends ViewGroup implements ReactHitSlopView, ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactZIndexedViewGroup {
    private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    private static final Rect sHelperRect = new Rect();
    private View[] mAllChildren = null;
    private int mAllChildrenCount;
    private float mBackfaceOpacity = 1.0f;
    private String mBackfaceVisibility = "visible";
    private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;
    private Rect mClippingRect;
    private final ViewGroupDrawingOrderHelper mDrawingOrderHelper;
    private Rect mHitSlopRect;
    private int mLayoutDirection;
    private boolean mNeedsOffscreenAlphaCompositing = false;
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    private String mOverflow;
    private Path mPath;
    private PointerEvents mPointerEvents = PointerEvents.AUTO;
    private ReactViewBackgroundDrawable mReactBackgroundDrawable;
    private boolean mRemoveClippedSubviews = false;

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {
        private final ReactViewGroup mParent;

        private ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.mParent = reactViewGroup;
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.mParent.getRemoveClippedSubviews()) {
                this.mParent.updateSubviewClipStatus(view);
            }
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        setClipChildren(false);
        this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public void onRtlPropertiesChanged(int i) {
        ReactViewBackgroundDrawable reactViewBackgroundDrawable;
        if (Build.VERSION.SDK_INT >= 17 && (reactViewBackgroundDrawable = this.mReactBackgroundDrawable) != null) {
            reactViewBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
        }
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e) {
            FLog.e("ReactNative", "NullPointerException when executing dispatchProvideStructure", e);
        }
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            getOrCreateReactViewBackground().setColor(i);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setTranslucentBackgroundDrawable(Drawable drawable) {
        updateBackgroundDrawable(null);
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
        if (reactViewBackgroundDrawable != null && drawable != null) {
            updateBackgroundDrawable(new LayerDrawable(new Drawable[]{reactViewBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            updateBackgroundDrawable(drawable);
        }
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if ((onInterceptTouchEventListener != null && onInterceptTouchEventListener.onInterceptTouchEvent(this, motionEvent)) || this.mPointerEvents == PointerEvents.NONE || this.mPointerEvents == PointerEvents.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.mPointerEvents == PointerEvents.NONE || this.mPointerEvents == PointerEvents.BOX_NONE) ? false : true;
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.mNeedsOffscreenAlphaCompositing = z;
    }

    public void setBorderWidth(int i, float f) {
        getOrCreateReactViewBackground().setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        getOrCreateReactViewBackground().setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.setRadius(f);
        if (Build.VERSION.SDK_INT < 18) {
            int i = orCreateReactViewBackground.hasRoundedBorders() ? 1 : 2;
            if (i != getLayerType()) {
                setLayerType(i, null);
            }
        }
    }

    public void setBorderRadius(float f, int i) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.setRadius(f, i);
        if (Build.VERSION.SDK_INT < 18) {
            int i2 = orCreateReactViewBackground.hasRoundedBorders() ? 1 : 2;
            if (i2 != getLayerType()) {
                setLayerType(i2, null);
            }
        }
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public Drawable getBorderRadiusMask() {
        float[] fArr;
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
        if (reactViewBackgroundDrawable == null) {
            fArr = null;
        } else {
            float[] borderRadii = getBorderRadii(reactViewBackgroundDrawable);
            fArr = new float[]{borderRadii[0], borderRadii[0], borderRadii[1], borderRadii[1], borderRadii[2], borderRadii[2], borderRadii[3], borderRadii[3]};
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(-1);
        return shapeDrawable;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z;
            if (z) {
                this.mClippingRect = new Rect();
                ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
                this.mAllChildrenCount = getChildCount();
                this.mAllChildren = new View[Math.max(12, this.mAllChildrenCount)];
                this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener();
                for (int i = 0; i < this.mAllChildrenCount; i++) {
                    View childAt = getChildAt(i);
                    this.mAllChildren[i] = childAt;
                    childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                updateClippingRect();
                return;
            }
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            Assertions.assertNotNull(this.mChildrenLayoutChangeListener);
            for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
            getDrawingRect(this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
            this.mAllChildren = null;
            this.mClippingRect = null;
            this.mAllChildrenCount = 0;
            this.mChildrenLayoutChangeListener = null;
        }
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
        }
    }

    private void updateClippingToRect(Rect rect) {
        Assertions.assertNotNull(this.mAllChildren);
        int i = 0;
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            updateSubviewClipStatus(rect, i2, i);
            if (this.mAllChildren[i2].getParent() == null) {
                i++;
            }
        }
    }

    private void updateSubviewClipStatus(Rect rect, int i, int i2) {
        View view = ((View[]) Assertions.assertNotNull(this.mAllChildren))[i];
        sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        boolean intersects = rect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom);
        Animation animation = view.getAnimation();
        boolean z = true;
        boolean z2 = animation != null && !animation.hasEnded();
        if (!intersects && view.getParent() != null && !z2) {
            super.removeViewsInLayout(i - i2, 1);
        } else if (intersects && view.getParent() == null) {
            super.addViewInLayout(view, i - i2, sDefaultLayoutParam, true);
            invalidate();
        } else if (!intersects) {
            z = false;
        }
        if (z && (view instanceof ReactClippingViewGroup)) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) view;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.updateClippingRect();
            }
        }
    }

    public void updateSubviewClipStatus(View view) {
        if (this.mRemoveClippedSubviews && getParent() != null) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (this.mClippingRect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom) != (view.getParent() != null)) {
                int i = 0;
                for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                    View[] viewArr = this.mAllChildren;
                    if (viewArr[i2] == view) {
                        updateSubviewClipStatus(this.mClippingRect, i2, i);
                        return;
                    }
                    if (viewArr[i2].getParent() == null) {
                        i++;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        this.mDrawingOrderHelper.handleAddView(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        this.mDrawingOrderHelper.handleRemoveView(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        this.mDrawingOrderHelper.handleRemoveView(getChildAt(i));
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.removeViewAt(i);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        return this.mDrawingOrderHelper.getChildDrawingOrder(i, i2);
    }

    public int getZIndexMappedChildIndex(int i) {
        return this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder() ? this.mDrawingOrderHelper.getChildDrawingOrder(getChildCount(), i) : i;
    }

    public void updateDrawingOrder() {
        this.mDrawingOrderHelper.update();
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        invalidate();
    }

    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    /* access modifiers changed from: package-private */
    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    /* access modifiers changed from: package-private */
    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    /* access modifiers changed from: package-private */
    public View getChildAtWithSubviewClippingEnabled(int i) {
        return ((View[]) Assertions.assertNotNull(this.mAllChildren))[i];
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i) {
        addViewWithSubviewClippingEnabled(view, i, sDefaultLayoutParam);
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        addInArray(view, i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.mAllChildren[i3].getParent() == null) {
                i2++;
            }
        }
        updateSubviewClipStatus(this.mClippingRect, i, i2);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    }

    /* access modifiers changed from: package-private */
    public void removeViewWithSubviewClippingEnabled(View view) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int indexOfChildInAllChildren = indexOfChildInAllChildren(view);
        if (this.mAllChildren[indexOfChildInAllChildren].getParent() != null) {
            int i = 0;
            for (int i2 = 0; i2 < indexOfChildInAllChildren; i2++) {
                if (this.mAllChildren[i2].getParent() == null) {
                    i++;
                }
            }
            super.removeViewsInLayout(indexOfChildInAllChildren - i, 1);
        }
        removeFromArray(indexOfChildInAllChildren);
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsWithSubviewClippingEnabled() {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mAllChildren);
        for (int i = 0; i < this.mAllChildrenCount; i++) {
            this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    private int indexOfChildInAllChildren(View view) {
        int i = this.mAllChildrenCount;
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr[i2] == view) {
                return i2;
            }
        }
        return -1;
    }

    private void addInArray(View view, int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i == i2) {
            if (length == i2) {
                this.mAllChildren = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.mAllChildren, 0, length);
                viewArr = this.mAllChildren;
            }
            int i3 = this.mAllChildrenCount;
            this.mAllChildrenCount = i3 + 1;
            viewArr[i3] = view;
        } else if (i < i2) {
            if (length == i2) {
                this.mAllChildren = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.mAllChildren, 0, i);
                System.arraycopy(viewArr, i, this.mAllChildren, i + 1, i2 - i);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.mAllChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i + " count=" + i2);
        }
    }

    private void removeFromArray(int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        if (i == i2 - 1) {
            int i3 = i2 - 1;
            this.mAllChildrenCount = i3;
            viewArr[i3] = null;
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i + 1, viewArr, i, (i2 - i) - 1);
            int i4 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i4;
            viewArr[i4] = null;
        }
    }

    @VisibleForTesting
    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((ReactViewBackgroundDrawable) getBackground()).getColor();
        }
        return 0;
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
            Drawable background = getBackground();
            updateBackgroundDrawable(null);
            if (background == null) {
                updateBackgroundDrawable(this.mReactBackgroundDrawable);
            } else {
                updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                this.mLayoutDirection = I18nUtil.getInstance().isRTL(getContext()) ? 1 : 0;
                this.mReactBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
            }
        }
        return this.mReactBackgroundDrawable;
    }

    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    public void setHitSlopRect(Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public String getOverflow() {
        return this.mOverflow;
    }

    private void updateBackgroundDrawable(Drawable drawable) {
        super.setBackground(drawable);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            dispatchOverflowDraw(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            FLog.e("ReactNative", "NullPointerException when executing ViewGroup.dispatchDraw method", e);
        } catch (StackOverflowError e2) {
            RootView rootView = RootViewUtil.getRootView(this);
            if (rootView != null) {
                rootView.handleException(e2);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, e2));
            } else {
                throw e2;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    private void dispatchOverflowDraw(Canvas canvas) {
        boolean z;
        float f;
        float f2;
        Canvas canvas2 = canvas;
        String str = this.mOverflow;
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode == 466743410 && str.equals("visible")) {
                    c = 0;
                }
            } else if (str.equals("hidden")) {
                c = 1;
            }
            if (c == 0) {
                Path path = this.mPath;
                if (path != null) {
                    path.rewind();
                }
            } else if (c == 1) {
                float width = (float) getWidth();
                float height = (float) getHeight();
                ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
                if (reactViewBackgroundDrawable != null) {
                    RectF directionAwareBorderInsets = reactViewBackgroundDrawable.getDirectionAwareBorderInsets();
                    if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.right > 0.0f) {
                        f2 = directionAwareBorderInsets.left + 0.0f;
                        f = directionAwareBorderInsets.top + 0.0f;
                        width -= directionAwareBorderInsets.right;
                        height -= directionAwareBorderInsets.bottom;
                    } else {
                        f2 = 0.0f;
                        f = 0.0f;
                    }
                    float[] borderRadii = getBorderRadii(this.mReactBackgroundDrawable);
                    float f3 = borderRadii[0];
                    float f4 = borderRadii[1];
                    float f5 = borderRadii[2];
                    float f6 = borderRadii[3];
                    if (f3 > 0.0f || f4 > 0.0f || f5 > 0.0f || f6 > 0.0f) {
                        if (this.mPath == null) {
                            this.mPath = new Path();
                        }
                        this.mPath.rewind();
                        z = true;
                        this.mPath.addRoundRect(new RectF(f2, f, width, height), new float[]{Math.max(f3 - directionAwareBorderInsets.left, 0.0f), Math.max(f3 - directionAwareBorderInsets.top, 0.0f), Math.max(f4 - directionAwareBorderInsets.right, 0.0f), Math.max(f4 - directionAwareBorderInsets.top, 0.0f), Math.max(f5 - directionAwareBorderInsets.right, 0.0f), Math.max(f5 - directionAwareBorderInsets.bottom, 0.0f), Math.max(f6 - directionAwareBorderInsets.left, 0.0f), Math.max(f6 - directionAwareBorderInsets.bottom, 0.0f)}, Path.Direction.CW);
                        canvas2.clipPath(this.mPath);
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                    f2 = 0.0f;
                    f = 0.0f;
                }
                if (!z) {
                    canvas2.clipRect(new RectF(f2, f, width, height));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ad, code lost:
        if (com.facebook.yoga.YogaConstants.isUndefined(r13) == false) goto L_0x00b1;
     */
    private float[] getBorderRadii(ReactViewBackgroundDrawable reactViewBackgroundDrawable) {
        float f;
        float fullBorderRadius = reactViewBackgroundDrawable.getFullBorderRadius();
        float borderRadiusOrDefaultTo = reactViewBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT);
        float borderRadiusOrDefaultTo2 = reactViewBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT);
        float borderRadiusOrDefaultTo3 = reactViewBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT);
        float borderRadiusOrDefaultTo4 = reactViewBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT);
        if (Build.VERSION.SDK_INT >= 17) {
            boolean z = this.mLayoutDirection == 1;
            float borderRadius = reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_START);
            float borderRadius2 = reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_END);
            float borderRadius3 = reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_START);
            f = reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_END);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext())) {
                if (!YogaConstants.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo = borderRadius;
                }
                if (!YogaConstants.isUndefined(borderRadius2)) {
                    borderRadiusOrDefaultTo2 = borderRadius2;
                }
                if (!YogaConstants.isUndefined(borderRadius3)) {
                    borderRadiusOrDefaultTo3 = borderRadius3;
                }
                if (YogaConstants.isUndefined(f)) {
                    f = borderRadiusOrDefaultTo4;
                }
                float f2 = z ? borderRadiusOrDefaultTo2 : borderRadiusOrDefaultTo;
                if (z) {
                    borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo;
                }
                float f3 = z ? f : borderRadiusOrDefaultTo3;
                if (z) {
                    f = borderRadiusOrDefaultTo3;
                }
                borderRadiusOrDefaultTo3 = f3;
                borderRadiusOrDefaultTo = f2;
            } else {
                float f4 = z ? borderRadius2 : borderRadius;
                if (!z) {
                    borderRadius = borderRadius2;
                }
                float f5 = z ? f : borderRadius3;
                if (z) {
                    f = borderRadius3;
                }
                if (!YogaConstants.isUndefined(f4)) {
                    borderRadiusOrDefaultTo = f4;
                }
                if (!YogaConstants.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo2 = borderRadius;
                }
                if (!YogaConstants.isUndefined(f5)) {
                    borderRadiusOrDefaultTo3 = f5;
                }
            }
            return new float[]{borderRadiusOrDefaultTo, borderRadiusOrDefaultTo2, f, borderRadiusOrDefaultTo3};
        }
        f = borderRadiusOrDefaultTo4;
        return new float[]{borderRadiusOrDefaultTo, borderRadiusOrDefaultTo2, f, borderRadiusOrDefaultTo3};
    }

    public void setOpacityIfPossible(float f) {
        if ((getAnimation() instanceof OpacityAnimation) && f != ((OpacityAnimation) getAnimation()).getEndOpacity()) {
            Log.e("ReactNative", "clearAnimation mBackfaceOpacity = " + this.mBackfaceOpacity + "set opacity = " + f);
            clearAnimation();
        }
        this.mBackfaceOpacity = f;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisibility = str;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        if (this.mBackfaceVisibility.equals("visible")) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.mBackfaceOpacity);
        } else {
            setAlpha(0.0f);
        }
    }
}
