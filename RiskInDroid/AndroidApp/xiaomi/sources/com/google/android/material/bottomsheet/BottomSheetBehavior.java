package com.google.android.material.bottomsheet;

import _m_j.ak;
import _m_j.cb;
import _m_j.ci;
import _m_j.cl;
import _m_j.co;
import _m_j.dh;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEF_STYLE_RES = 2132739075;
    int activePointerId;
    private final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    private int childHeight;
    int collapsedOffset;
    private final dh.O000000o dragCallback = new dh.O000000o() {
        /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4 */

        public boolean tryCaptureView(View view, int i) {
            if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                return false;
            }
            if (BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == i) {
                View view2 = BottomSheetBehavior.this.nestedScrollingChildRef != null ? BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            return BottomSheetBehavior.this.viewRef != null && BottomSheetBehavior.this.viewRef.get() == view;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        private boolean releasedLow(View view) {
            return view.getTop() > (BottomSheetBehavior.this.parentHeight + BottomSheetBehavior.this.getExpandedOffset()) / 2;
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            int i2;
            int i3 = 3;
            if (f2 < 0.0f) {
                if (BottomSheetBehavior.this.fitToContents) {
                    i = BottomSheetBehavior.this.fitToContentsOffset;
                } else if (view.getTop() > BottomSheetBehavior.this.halfExpandedOffset) {
                    i = BottomSheetBehavior.this.halfExpandedOffset;
                } else {
                    i = BottomSheetBehavior.this.expandedOffset;
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
            } else if (!BottomSheetBehavior.this.hideable || !BottomSheetBehavior.this.shouldHide(view, f2)) {
                if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.fitToContents) {
                        if (Math.abs(top - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i = BottomSheetBehavior.this.fitToContentsOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                        }
                        i2 = BottomSheetBehavior.this.collapsedOffset;
                    } else if (top < BottomSheetBehavior.this.halfExpandedOffset) {
                        if (top < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i = BottomSheetBehavior.this.expandedOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                        }
                        i = BottomSheetBehavior.this.halfExpandedOffset;
                    } else if (Math.abs(top - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                        i = BottomSheetBehavior.this.halfExpandedOffset;
                    } else {
                        i2 = BottomSheetBehavior.this.collapsedOffset;
                    }
                } else {
                    if (!BottomSheetBehavior.this.fitToContents) {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            i = BottomSheetBehavior.this.halfExpandedOffset;
                        }
                    }
                    i2 = BottomSheetBehavior.this.collapsedOffset;
                }
                i3 = 4;
                BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
            } else if ((Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view)) {
                if (BottomSheetBehavior.this.fitToContents) {
                    i = BottomSheetBehavior.this.fitToContentsOffset;
                } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                    i = BottomSheetBehavior.this.expandedOffset;
                } else {
                    i = BottomSheetBehavior.this.halfExpandedOffset;
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
            } else {
                i = BottomSheetBehavior.this.parentHeight;
                i3 = 5;
                BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
            }
            i3 = 6;
            BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return ak.O000000o(i, BottomSheetBehavior.this.getExpandedOffset(), BottomSheetBehavior.this.hideable ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int getViewVerticalDragRange(View view) {
            if (BottomSheetBehavior.this.hideable) {
                return BottomSheetBehavior.this.parentHeight;
            }
            return BottomSheetBehavior.this.collapsedOffset;
        }
    };
    public boolean draggable = true;
    float elevation = -1.0f;
    private int expandHalfwayActionId = -1;
    int expandedOffset;
    public boolean fitToContents = true;
    int fitToContentsOffset;
    public int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio = 0.5f;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    public MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags = 0;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable = null;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    public boolean skipCollapsed;
    int state = 4;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings = false;
    private VelocityTracker velocityTracker;
    dh viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843840, R.attr.backgroundTint, R.attr.behavior_draggable, R.attr.behavior_expandedOffset, R.attr.behavior_fitToContents, R.attr.behavior_halfExpandedRatio, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_saveFlags, R.attr.behavior_skipCollapsed, R.attr.gestureInsetBottomIgnored, R.attr.shapeAppearance, R.attr.shapeAppearanceOverlay});
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(11);
        boolean hasValue = obtainStyledAttributes.hasValue(1);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, 1));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = obtainStyledAttributes.getDimension(0, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(7);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(7, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(obtainStyledAttributes.getBoolean(6, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(10, false));
        setFitToContents(obtainStyledAttributes.getBoolean(4, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(9, false));
        setDraggable(obtainStyledAttributes.getBoolean(2, true));
        setSaveFlags(obtainStyledAttributes.getInt(8, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(5, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(3);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        restoreOptionalState(savedState);
        if (savedState.state == 1 || savedState.state == 2) {
            this.state = 4;
        } else {
            this.state = savedState.state;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.O00000o o00000o) {
        super.onAttachedToLayoutParams(o00000o);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: V
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
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout r7, V r8, int r9) {
        /*
            r6 = this;
            boolean r0 = _m_j.cb.O0000ooo(r7)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = _m_j.cb.O0000ooo(r8)
            if (r0 != 0) goto L_0x0010
            r8.setFitsSystemWindows(r1)
        L_0x0010:
            java.lang.ref.WeakReference<V> r0 = r6.viewRef
            r2 = 3
            r3 = 0
            if (r0 != 0) goto L_0x006d
            android.content.res.Resources r0 = r7.getResources()
            r4 = 2132017484(0x7f14014c, float:1.9673248E38)
            int r0 = r0.getDimensionPixelSize(r4)
            r6.peekHeightMin = r0
            r6.setSystemGestureInsets(r8)
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r8)
            r6.viewRef = r0
            boolean r0 = r6.shapeThemingEnabled
            if (r0 == 0) goto L_0x0038
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.materialShapeDrawable
            if (r0 == 0) goto L_0x0038
            _m_j.cb.O000000o(r8, r0)
        L_0x0038:
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.materialShapeDrawable
            if (r0 == 0) goto L_0x0061
            float r4 = r6.elevation
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0048
            float r4 = _m_j.cb.O0000oOO(r8)
        L_0x0048:
            r0.setElevation(r4)
            int r0 = r6.state
            if (r0 != r2) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            r6.isShapeExpanded = r0
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.materialShapeDrawable
            boolean r4 = r6.isShapeExpanded
            if (r4 == 0) goto L_0x005c
            r4 = 0
            goto L_0x005e
        L_0x005c:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x005e:
            r0.setInterpolation(r4)
        L_0x0061:
            r6.updateAccessibilityActions()
            int r0 = _m_j.cb.O0000O0o(r8)
            if (r0 != 0) goto L_0x006d
            _m_j.cb.O00000oO(r8, r1)
        L_0x006d:
            _m_j.dh r0 = r6.viewDragHelper
            if (r0 != 0) goto L_0x0079
            _m_j.dh$O000000o r0 = r6.dragCallback
            _m_j.dh r0 = _m_j.dh.O000000o(r7, r0)
            r6.viewDragHelper = r0
        L_0x0079:
            int r0 = r8.getTop()
            r7.onLayoutChild(r8, r9)
            int r9 = r7.getWidth()
            r6.parentWidth = r9
            int r7 = r7.getHeight()
            r6.parentHeight = r7
            int r7 = r8.getHeight()
            r6.childHeight = r7
            int r7 = r6.parentHeight
            int r9 = r6.childHeight
            int r7 = r7 - r9
            int r7 = java.lang.Math.max(r3, r7)
            r6.fitToContentsOffset = r7
            r6.calculateHalfExpandedOffset()
            r6.calculateCollapsedOffset()
            int r7 = r6.state
            if (r7 != r2) goto L_0x00af
            int r7 = r6.getExpandedOffset()
            _m_j.cb.O0000Oo0(r8, r7)
            goto L_0x00dd
        L_0x00af:
            r9 = 6
            if (r7 != r9) goto L_0x00b8
            int r7 = r6.halfExpandedOffset
            _m_j.cb.O0000Oo0(r8, r7)
            goto L_0x00dd
        L_0x00b8:
            boolean r9 = r6.hideable
            if (r9 == 0) goto L_0x00c5
            r9 = 5
            if (r7 != r9) goto L_0x00c5
            int r7 = r6.parentHeight
            _m_j.cb.O0000Oo0(r8, r7)
            goto L_0x00dd
        L_0x00c5:
            int r7 = r6.state
            r9 = 4
            if (r7 != r9) goto L_0x00d0
            int r7 = r6.collapsedOffset
            _m_j.cb.O0000Oo0(r8, r7)
            goto L_0x00dd
        L_0x00d0:
            if (r7 == r1) goto L_0x00d5
            r9 = 2
            if (r7 != r9) goto L_0x00dd
        L_0x00d5:
            int r7 = r8.getTop()
            int r0 = r0 - r7
            _m_j.cb.O0000Oo0(r8, r0)
        L_0x00dd:
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference
            android.view.View r8 = r6.findScrollingChild(r8)
            r7.<init>(r8)
            r6.nestedScrollingChildRef = r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        dh dhVar;
        if (!v.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        View view = null;
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (dhVar = this.viewDragHelper) != null && dhVar.O000000o(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.ignoreEvents && this.state != 1 && !coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.viewDragHelper != null && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.O00000Oo);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        dh dhVar = this.viewDragHelper;
        if (dhVar != null) {
            dhVar.O00000Oo(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (this.viewDragHelper != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.O00000Oo)) {
            this.viewDragHelper.O000000o(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (!this.ignoreEvents) {
            return true;
        }
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000Oo0(android.view.View, int):void
     arg types: [V, int]
     candidates:
      _m_j.cb.O0000Oo0(android.view.View, float):void
      _m_j.cb.O0000Oo0(android.view.View, int):void */
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v.getTop();
                int i4 = top - i2;
                if (i2 > 0) {
                    if (i4 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        cb.O0000Oo0((View) v, -iArr[1]);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i2;
                        cb.O0000Oo0((View) v, -i2);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                    int i5 = this.collapsedOffset;
                    if (i4 > i5 && !this.hideable) {
                        iArr[1] = top - i5;
                        cb.O0000Oo0((View) v, -iArr[1]);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i2;
                        cb.O0000Oo0((View) v, -i2);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v.getTop());
                this.lastNestedScrollDy = i2;
                this.nestedScrolled = true;
            }
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3;
        int i4 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i2 = this.fitToContentsOffset;
                } else {
                    int top = v.getTop();
                    int i5 = this.halfExpandedOffset;
                    if (top > i5) {
                        i2 = i5;
                    } else {
                        i2 = this.expandedOffset;
                    }
                }
                startSettlingAnimation(v, i4, i2, false);
                this.nestedScrolled = false;
            } else if (!this.hideable || !shouldHide(v, getYVelocity())) {
                if (this.lastNestedScrollDy == 0) {
                    int top2 = v.getTop();
                    if (!this.fitToContents) {
                        int i6 = this.halfExpandedOffset;
                        if (top2 < i6) {
                            if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                                i2 = this.expandedOffset;
                                startSettlingAnimation(v, i4, i2, false);
                                this.nestedScrolled = false;
                            }
                            i2 = this.halfExpandedOffset;
                        } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        } else {
                            i3 = this.collapsedOffset;
                        }
                    } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i2 = this.fitToContentsOffset;
                        startSettlingAnimation(v, i4, i2, false);
                        this.nestedScrolled = false;
                    } else {
                        i3 = this.collapsedOffset;
                    }
                } else {
                    if (!this.fitToContents) {
                        int top3 = v.getTop();
                        if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        }
                    }
                    i3 = this.collapsedOffset;
                }
                i4 = 4;
                startSettlingAnimation(v, i4, i2, false);
                this.nestedScrolled = false;
            } else {
                i2 = this.parentHeight;
                i4 = 5;
                startSettlingAnimation(v, i4, i2, false);
                this.nestedScrolled = false;
            }
            i4 = 6;
            startSettlingAnimation(v, i4, i2, false);
            this.nestedScrolled = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get() || (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v, view, f, f2))) {
            return false;
        }
        return true;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents != z) {
            this.fitToContents = z;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((!this.fitToContents || this.state != 6) ? this.state : 3);
            updateAccessibilityActions();
        }
    }

    public void setPeekHeight(int i) {
        setPeekHeight(i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public final void setPeekHeight(int i, boolean z) {
        boolean z2 = true;
        if (i == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
                if (z2) {
                    updatePeekHeight(z);
                    return;
                }
                return;
            }
        } else if (this.peekHeightAuto || this.peekHeight != i) {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i);
            if (z2) {
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    public void updatePeekHeight(boolean z) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (view = (View) this.viewRef.get()) != null) {
                if (z) {
                    settleToStatePendingLayout(this.state);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public void setHalfExpandedRatio(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public void setExpandedOffset(int i) {
        if (i >= 0) {
            this.expandedOffset = i;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public int getExpandedOffset() {
        return this.fitToContents ? this.fitToContentsOffset : this.expandedOffset;
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setSaveFlags(int i) {
        this.saveFlags = i;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void removeBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    public void setState(int i) {
        if (i != this.state) {
            if (this.viewRef != null) {
                settleToStatePendingLayout(i);
            } else if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                this.state = i;
            }
        }
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    private void settleToStatePendingLayout(final int i) {
        final View view = (View) this.viewRef.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !cb.O000OO0o(view)) {
                settleToState(view, i);
            } else {
                view.post(new Runnable() {
                    /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass1 */

                    public void run() {
                        BottomSheetBehavior.this.settleToState(view, i);
                    }
                });
            }
        }
    }

    public int getState() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public void setStateInternal(int i) {
        View view;
        if (this.state != i) {
            this.state = i;
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i == 3) {
                    updateImportantForAccessibility(true);
                } else if (i == 6 || i == 5 || i == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i);
                for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
                    this.callbacks.get(i2).onStateChanged(view, i);
                }
                updateAccessibilityActions();
            }
        }
    }

    private void updateDrawableForTargetState(int i) {
        ValueAnimator valueAnimator;
        if (i != 2) {
            boolean z = i == 3;
            if (this.isShapeExpanded != z) {
                this.isShapeExpanded = z;
                if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                    if (valueAnimator.isRunning()) {
                        this.interpolatorAnimator.reverse();
                        return;
                    }
                    float f = z ? 0.0f : 1.0f;
                    this.interpolatorAnimator.setFloatValues(1.0f - f, f);
                    this.interpolatorAnimator.start();
                }
            }
        }
    }

    private int calculatePeekHeight() {
        int i;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
        }
        if (this.gestureInsetBottomIgnored || (i = this.gestureInsetBottom) <= 0) {
            return this.peekHeight;
        }
        return Math.max(this.peekHeight, i + this.peekHeightGestureInsetBuffer);
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (((float) this.parentHeight) * (1.0f - this.halfExpandedRatio));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i = this.saveFlags;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            int i2 = this.saveFlags;
            if (i2 == -1 || (i2 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            int i3 = this.saveFlags;
            if (i3 == -1 || (i3 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            int i4 = this.saveFlags;
            if (i4 == -1 || (i4 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public View findScrollingChild(View view) {
        if (cb.O00oOoOo(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z) {
        createMaterialShapeDrawable(context, attributeSet, z, null);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, (int) R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            this.materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable.initializeElevationOverlay(context);
            if (!z || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    private void createShapeValueAnimator() {
        this.interpolatorAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass2 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    private void setSystemGestureInsets(View view) {
        if (Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && !this.peekHeightAuto) {
            ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() {
                /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass3 */

                public ci onApplyWindowInsets(View view, ci ciVar, ViewUtils.RelativePadding relativePadding) {
                    BottomSheetBehavior.this.gestureInsetBottom = ciVar.O00000Oo.O0000Oo0().O00000oO;
                    BottomSheetBehavior.this.updatePeekHeight(false);
                    return ciVar;
                }
            });
        }
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    /* access modifiers changed from: package-private */
    public void settleToState(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.collapsedOffset;
        } else if (i == 6) {
            int i4 = this.halfExpandedOffset;
            if (!this.fitToContents || i4 > (i3 = this.fitToContentsOffset)) {
                i2 = i4;
            } else {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = getExpandedOffset();
        } else if (!this.hideable || i != 5) {
            throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(i)));
        } else {
            i2 = this.parentHeight;
        }
        startSettlingAnimation(view, i, i2, false);
    }

    /* access modifiers changed from: package-private */
    public void startSettlingAnimation(View view, int i, int i2, boolean z) {
        dh dhVar = this.viewDragHelper;
        if (dhVar != null && (!z ? dhVar.O000000o(view, view.getLeft(), i2) : dhVar.O000000o(view.getLeft(), i2))) {
            setStateInternal(2);
            updateDrawableForTargetState(i);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i);
            }
            if (!this.settleRunnable.isPosted) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable2 = this.settleRunnable;
                settleRunnable2.targetState = i;
                cb.O000000o(view, settleRunnable2);
                this.settleRunnable.isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i;
            return;
        }
        setStateInternal(i);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnSlide(int i) {
        float f;
        float f2;
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            int i2 = this.collapsedOffset;
            if (i > i2 || i2 == getExpandedOffset()) {
                int i3 = this.collapsedOffset;
                f = (float) (i3 - i);
                f2 = (float) (this.parentHeight - i3);
            } else {
                int i4 = this.collapsedOffset;
                f = (float) (i4 - i);
                f2 = (float) (i4 - getExpandedOffset());
            }
            float f3 = f / f2;
            for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
                this.callbacks.get(i5).onSlide(view, f3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    class SettleRunnable implements Runnable {
        public boolean isPosted;
        int targetState;
        private final View view;

        SettleRunnable(View view2, int i) {
            this.view = view2;
            this.targetState = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.viewDragHelper == null || !BottomSheetBehavior.this.viewDragHelper.O00000o0()) {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                cb.O000000o(this.view, this);
            }
            this.isPosted = false;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.AnonymousClass1 */

            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.O00000o) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.O00000o) layoutParams).f2811O000000o;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        this.updateImportantForAccessibilityOnSiblings = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [V, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    private void updateImportantForAccessibility(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    V childAt = coordinatorLayout.getChildAt(i);
                    if (childAt != this.viewRef.get()) {
                        if (z) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                cb.O00000oO((View) childAt, 4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                            cb.O00000oO((View) childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    }
                }
                if (!z) {
                    this.importantForAccessibilityMap = null;
                } else if (this.updateImportantForAccessibilityOnSiblings) {
                    ((View) this.viewRef.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    private void updateAccessibilityActions() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            cb.O00000oo(view, 524288);
            cb.O00000oo(view, 262144);
            cb.O00000oo(view, (int) ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
            int i = this.expandHalfwayActionId;
            if (i != -1) {
                cb.O00000oo(view, i);
            }
            char c = 6;
            if (this.state != 6) {
                this.expandHalfwayActionId = addAccessibilityActionForState(view, R.string.bottomsheet_action_expand_halfway, 6);
            }
            if (this.hideable && this.state != 5) {
                replaceAccessibilityActionForState(view, cl.O000000o.O0000oOo, 5);
            }
            int i2 = this.state;
            if (i2 == 3) {
                if (this.fitToContents) {
                    c = 4;
                }
                replaceAccessibilityActionForState(view, cl.O000000o.O0000oOO, c);
            } else if (i2 == 4) {
                if (this.fitToContents) {
                    c = 3;
                }
                replaceAccessibilityActionForState(view, cl.O000000o.O0000oO, c);
            } else if (i2 == 6) {
                replaceAccessibilityActionForState(view, cl.O000000o.O0000oOO, 4);
                replaceAccessibilityActionForState(view, cl.O000000o.O0000oO, 3);
            }
        }
    }

    private void replaceAccessibilityActionForState(V v, cl.O000000o o000000o, int i) {
        cb.O000000o(v, o000000o, createAccessibilityViewCommandForState(i));
    }

    private int addAccessibilityActionForState(V v, int i, int i2) {
        return cb.O000000o(v, v.getResources().getString(i), createAccessibilityViewCommandForState(i2));
    }

    private co createAccessibilityViewCommandForState(final int i) {
        return new co() {
            /* class com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5 */

            public boolean perform(View view, co.O000000o o000000o) {
                BottomSheetBehavior.this.setState(i);
                return true;
            }
        };
    }
}
