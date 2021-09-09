package androidx.viewpager2.widget;

import _m_j.cb;
import _m_j.cl;
import _m_j.co;
import _m_j.ha;
import _m_j.kc;
import _m_j.ke;
import _m_j.kf;
import _m_j.kg;
import _m_j.kh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class ViewPager2 extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    static boolean f3042O000000o = true;
    public ke O00000Oo = new ke();
    boolean O00000o = false;
    int O00000o0;
    public RecyclerView O00000oO;
    kh O00000oo;
    kf O0000O0o;
    boolean O0000OOo = true;
    private final Rect O0000Oo = new Rect();
    O000000o O0000Oo0;
    private final Rect O0000OoO = new Rect();
    private RecyclerView.O00000o0 O0000Ooo = new O00000o0() {
        /* class androidx.viewpager2.widget.ViewPager2.AnonymousClass1 */

        public final void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.O00000o = true;
            viewPager2.O00000oo.O00000o0 = true;
        }
    };
    private ke O0000o;
    private int O0000o0 = -1;
    private LinearLayoutManager O0000o00;
    private Parcelable O0000o0O;
    private ha O0000o0o;
    private RecyclerView.O0000OOo O0000oO = null;
    private kg O0000oO0;
    private boolean O0000oOO = false;
    private int O0000oOo = -1;

    public static abstract class O0000O0o {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    public interface O0000Oo0 {
    }

    public ViewPager2(Context context) {
        super(context);
        O000000o(context, (AttributeSet) null);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        this.O0000Oo0 = f3042O000000o ? new O0000OOo() : new O00000Oo();
        this.O00000oO = new O0000o00(context);
        this.O00000oO.setId(cb.O000000o());
        this.O00000oO.setDescendantFocusability(131072);
        this.O0000o00 = new O00000o(context);
        this.O00000oO.setLayoutManager(this.O0000o00);
        this.O00000oO.setScrollingTouchSlop(1);
        O00000Oo(context, attributeSet);
        this.O00000oO.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.O00000oO.addOnChildAttachStateChangeListener(O00000o0());
        this.O00000oo = new kh(this);
        this.O0000O0o = new kf(this, this.O00000oo, this.O00000oO);
        this.O0000o0o = new O0000Oo();
        this.O0000o0o.O000000o(this.O00000oO);
        this.O00000oO.addOnScrollListener(this.O00000oo);
        this.O0000o = new ke();
        this.O00000oo.f2135O000000o = this.O0000o;
        AnonymousClass2 r3 = new O0000O0o() {
            /* class androidx.viewpager2.widget.ViewPager2.AnonymousClass2 */

            public final void onPageSelected(int i) {
                if (ViewPager2.this.O00000o0 != i) {
                    ViewPager2 viewPager2 = ViewPager2.this;
                    viewPager2.O00000o0 = i;
                    viewPager2.O0000Oo0.O00000oO();
                }
            }

            public final void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ViewPager2.this.O000000o();
                }
            }
        };
        AnonymousClass3 r4 = new O0000O0o() {
            /* class androidx.viewpager2.widget.ViewPager2.AnonymousClass3 */

            public final void onPageSelected(int i) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.O00000oO.requestFocus(2);
                }
            }
        };
        this.O0000o.O000000o(r3);
        this.O0000o.O000000o(r4);
        this.O0000Oo0.O000000o(this.O00000oO);
        this.O0000o.O000000o(this.O00000Oo);
        this.O0000oO0 = new kg(this.O0000o00);
        this.O0000o.O000000o(this.O0000oO0);
        RecyclerView recyclerView = this.O00000oO;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private RecyclerView.O0000o00 O00000o0() {
        return new RecyclerView.O0000o00() {
            /* class androidx.viewpager2.widget.ViewPager2.AnonymousClass4 */

            public final void O00000Oo(View view) {
            }

            public final void O000000o(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        };
    }

    public final CharSequence getAccessibilityClassName() {
        if (this.O0000Oo0.O000000o()) {
            return this.O0000Oo0.O00000Oo();
        }
        return super.getAccessibilityClassName();
    }

    private void O00000Oo(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948});
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, new int[]{16842948}, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(0, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3054O000000o = this.O00000oO.getId();
        int i = this.O0000o0;
        if (i == -1) {
            i = this.O00000o0;
        }
        savedState.O00000Oo = i;
        Parcelable parcelable = this.O0000o0O;
        if (parcelable != null) {
            savedState.O00000o0 = parcelable;
        } else {
            RecyclerView.O000000o adapter = this.O00000oO.getAdapter();
            if (adapter instanceof kc) {
                savedState.O00000o0 = ((kc) adapter).O000000o();
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O0000o0 = savedState.O00000Oo;
        this.O0000o0O = savedState.O00000o0;
    }

    private void O00000o() {
        RecyclerView.O000000o adapter;
        if (this.O0000o0 != -1 && (adapter = getAdapter()) != null) {
            if (this.O0000o0O != null) {
                this.O0000o0O = null;
            }
            this.O00000o0 = Math.max(0, Math.min(this.O0000o0, adapter.getItemCount() - 1));
            this.O0000o0 = -1;
            this.O00000oO.scrollToPosition(this.O00000o0);
            this.O0000Oo0.O00000o0();
        }
    }

    /* access modifiers changed from: protected */
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).f3054O000000o;
            sparseArray.put(this.O00000oO.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        O00000o();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.viewpager2.widget.ViewPager2.SavedState.AnonymousClass1 */

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return O000000o(parcel, classLoader);
            }

            private static SavedState O000000o(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return O000000o(parcel, null);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f3054O000000o;
        int O00000Oo;
        Parcelable O00000o0;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            O000000o(parcel, classLoader);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            O000000o(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void O000000o(Parcel parcel, ClassLoader classLoader) {
            this.f3054O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3054O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeParcelable(this.O00000o0, i);
        }
    }

    public final void setAdapter(RecyclerView.O000000o o000000o) {
        RecyclerView.O000000o adapter = this.O00000oO.getAdapter();
        this.O0000Oo0.O00000Oo(adapter);
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.O0000Ooo);
        }
        this.O00000oO.setAdapter(o000000o);
        this.O00000o0 = 0;
        O00000o();
        this.O0000Oo0.O000000o(o000000o);
        if (o000000o != null) {
            o000000o.registerAdapterDataObserver(this.O0000Ooo);
        }
    }

    public final RecyclerView.O000000o getAdapter() {
        return this.O00000oO.getAdapter();
    }

    public final void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        measureChild(this.O00000oO, i, i2);
        int measuredWidth = this.O00000oO.getMeasuredWidth();
        int measuredHeight = this.O00000oO.getMeasuredHeight();
        int measuredState = this.O00000oO.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.O00000oO.getMeasuredWidth();
        int measuredHeight = this.O00000oO.getMeasuredHeight();
        this.O0000Oo.left = getPaddingLeft();
        this.O0000Oo.right = (i3 - i) - getPaddingRight();
        this.O0000Oo.top = getPaddingTop();
        this.O0000Oo.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.O0000Oo, this.O0000OoO);
        this.O00000oO.layout(this.O0000OoO.left, this.O0000OoO.top, this.O0000OoO.right, this.O0000OoO.bottom);
        if (this.O00000o) {
            O000000o();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        ha haVar = this.O0000o0o;
        if (haVar != null) {
            View O000000o2 = haVar.O000000o(this.O0000o00);
            if (O000000o2 != null) {
                int position = this.O0000o00.getPosition(O000000o2);
                if (position != this.O00000o0 && getScrollState() == 0) {
                    this.O0000o.onPageSelected(position);
                }
                this.O00000o = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    /* access modifiers changed from: package-private */
    public final int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.O00000oO;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public final void setOrientation(int i) {
        this.O0000o00.setOrientation(i);
        this.O0000Oo0.O00000o();
    }

    public final int getOrientation() {
        return this.O0000o00.getOrientation();
    }

    public final boolean O00000Oo() {
        return this.O0000o00.getLayoutDirection() == 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.viewpager2.widget.ViewPager2.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      androidx.viewpager2.widget.ViewPager2.O000000o(android.content.Context, android.util.AttributeSet):void
      androidx.viewpager2.widget.ViewPager2.O000000o(int, boolean):void */
    public final void setCurrentItem(int i) {
        O000000o(i, true);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i, boolean z) {
        RecyclerView.O000000o adapter = getAdapter();
        if (adapter == null) {
            if (this.O0000o0 != -1) {
                this.O0000o0 = Math.max(i, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
            if (min == this.O00000o0 && this.O00000oo.O000000o()) {
                return;
            }
            if (min != this.O00000o0 || !z) {
                double d = (double) this.O00000o0;
                this.O00000o0 = min;
                this.O0000Oo0.O00000oO();
                if (!this.O00000oo.O000000o()) {
                    d = this.O00000oo.O00000Oo();
                }
                this.O00000oo.O000000o(min, z);
                if (!z) {
                    this.O00000oO.scrollToPosition(min);
                    return;
                }
                double d2 = (double) min;
                Double.isNaN(d2);
                if (Math.abs(d2 - d) > 3.0d) {
                    this.O00000oO.scrollToPosition(d2 > d ? min - 3 : min + 3);
                    RecyclerView recyclerView = this.O00000oO;
                    recyclerView.post(new O0000o0(min, recyclerView));
                    return;
                }
                this.O00000oO.smoothScrollToPosition(min);
            }
        }
    }

    public final int getCurrentItem() {
        return this.O00000o0;
    }

    public final int getScrollState() {
        return this.O00000oo.O00000Oo;
    }

    public final void setUserInputEnabled(boolean z) {
        this.O0000OOo = z;
        this.O0000Oo0.O00000oo();
    }

    public final void setOffscreenPageLimit(int i) {
        if (i > 0 || i == -1) {
            this.O0000oOo = i;
            this.O00000oO.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public final int getOffscreenPageLimit() {
        return this.O0000oOo;
    }

    public final boolean canScrollHorizontally(int i) {
        return this.O00000oO.canScrollHorizontally(i);
    }

    public final boolean canScrollVertically(int i) {
        return this.O00000oO.canScrollVertically(i);
    }

    public final void setPageTransformer(O0000Oo0 o0000Oo0) {
        if (o0000Oo0 != null) {
            if (!this.O0000oOO) {
                this.O0000oO = this.O00000oO.getItemAnimator();
                this.O0000oOO = true;
            }
            this.O00000oO.setItemAnimator(null);
        } else if (this.O0000oOO) {
            this.O00000oO.setItemAnimator(this.O0000oO);
            this.O0000oO = null;
            this.O0000oOO = false;
        }
        if (o0000Oo0 != this.O0000oO0.f2134O000000o) {
            kg kgVar = this.O0000oO0;
            kgVar.f2134O000000o = o0000Oo0;
            if (kgVar.f2134O000000o != null) {
                double O00000Oo2 = this.O00000oo.O00000Oo();
                int i = (int) O00000Oo2;
                double d = (double) i;
                Double.isNaN(d);
                float f = (float) (O00000Oo2 - d);
                this.O0000oO0.onPageScrolled(i, f, Math.round(((float) getPageSize()) * f));
            }
        }
    }

    public final void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.O0000Oo0.O0000O0o();
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.O0000Oo0.O000000o(accessibilityNodeInfo);
    }

    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.O0000Oo0.O000000o(i)) {
            return this.O0000Oo0.O00000Oo(i);
        }
        return super.performAccessibilityAction(i, bundle);
    }

    class O0000o00 extends RecyclerView {
        O0000o00(Context context) {
            super(context);
        }

        public final CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.O0000Oo0.O0000OOo()) {
                return ViewPager2.this.O0000Oo0.O0000Oo0();
            }
            return super.getAccessibilityClassName();
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.O00000o0);
            accessibilityEvent.setToIndex(ViewPager2.this.O00000o0);
            ViewPager2.this.O0000Oo0.O000000o(accessibilityEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.O0000OOo && super.onTouchEvent(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.O0000OOo && super.onInterceptTouchEvent(motionEvent);
        }
    }

    class O00000o extends LinearLayoutManager {
        public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        O00000o(Context context) {
            super(context);
        }

        public final boolean performAccessibilityAction(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i, Bundle bundle) {
            if (ViewPager2.this.O0000Oo0.O00000o0(i)) {
                return ViewPager2.this.O0000Oo0.O00000o(i);
            }
            return super.performAccessibilityAction(o000o0oo, o000OO0o, i, bundle);
        }

        public final void onInitializeAccessibilityNodeInfo(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, cl clVar) {
            super.onInitializeAccessibilityNodeInfo(o000o0oo, o000OO0o, clVar);
            ViewPager2.this.O0000Oo0.O000000o(clVar);
        }

        public final void calculateExtraLayoutSpace(RecyclerView.O000OO0o o000OO0o, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(o000OO0o, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    class O0000Oo extends ha {
        O0000Oo() {
        }

        public final View O000000o(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.O0000O0o.f2133O000000o.O00000o) {
                return null;
            }
            return super.O000000o(layoutManager);
        }
    }

    static class O0000o0 implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private final int f3052O000000o;
        private final RecyclerView O00000Oo;

        O0000o0(int i, RecyclerView recyclerView) {
            this.f3052O000000o = i;
            this.O00000Oo = recyclerView;
        }

        public final void run() {
            this.O00000Oo.smoothScrollToPosition(this.f3052O000000o);
        }
    }

    public final int getItemDecorationCount() {
        return this.O00000oO.getItemDecorationCount();
    }

    abstract class O000000o {
        /* access modifiers changed from: package-private */
        public void O000000o(cl clVar) {
        }

        /* access modifiers changed from: package-private */
        public void O000000o(AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void O000000o(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void O000000o(RecyclerView.O000000o<?> o000000o) {
        }

        /* access modifiers changed from: package-private */
        public void O000000o(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean O000000o() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean O000000o(int i) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void O00000Oo(RecyclerView.O000000o<?> o000000o) {
        }

        /* access modifiers changed from: package-private */
        public void O00000o() {
        }

        /* access modifiers changed from: package-private */
        public void O00000o0() {
        }

        /* access modifiers changed from: package-private */
        public boolean O00000o0(int i) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void O00000oO() {
        }

        /* access modifiers changed from: package-private */
        public void O00000oo() {
        }

        /* access modifiers changed from: package-private */
        public void O0000O0o() {
        }

        /* access modifiers changed from: package-private */
        public boolean O0000OOo() {
            return false;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(ViewPager2 viewPager2, byte b) {
            this();
        }

        /* access modifiers changed from: package-private */
        public String O00000Oo() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean O00000Oo(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean O00000o(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public CharSequence O0000Oo0() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class O00000Oo extends O000000o {
        public final boolean O0000OOo() {
            return true;
        }

        public final CharSequence O0000Oo0() {
            return "androidx.viewpager.widget.ViewPager";
        }

        O00000Oo() {
            super(ViewPager2.this, (byte) 0);
        }

        public final boolean O00000o0(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.O0000OOo;
        }

        public final boolean O00000o(int i) {
            if (O00000o0(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public final void O000000o(cl clVar) {
            if (!ViewPager2.this.O0000OOo) {
                clVar.O00000Oo(cl.O000000o.O0000o0);
                clVar.O00000Oo(cl.O000000o.O0000o00);
                clVar.O0000OoO(false);
            }
        }
    }

    class O0000OOo extends O000000o {
        private final co O00000o = new co() {
            /* class androidx.viewpager2.widget.ViewPager2.O0000OOo.AnonymousClass2 */

            public final boolean perform(View view, co.O000000o o000000o) {
                O0000OOo.this.O00000oO(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };
        private final co O00000o0 = new co() {
            /* class androidx.viewpager2.widget.ViewPager2.O0000OOo.AnonymousClass1 */

            public final boolean perform(View view, co.O000000o o000000o) {
                O0000OOo.this.O00000oO(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };
        private RecyclerView.O00000o0 O00000oO;

        public final boolean O000000o() {
            return true;
        }

        public final boolean O000000o(int i) {
            return i == 8192 || i == 4096;
        }

        public final String O00000Oo() {
            return "androidx.viewpager.widget.ViewPager";
        }

        O0000OOo() {
            super(ViewPager2.this, (byte) 0);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O00000oO(android.view.View, int):void
         arg types: [androidx.recyclerview.widget.RecyclerView, int]
         candidates:
          _m_j.cb.O00000oO(android.view.View, float):void
          _m_j.cb.O00000oO(android.view.View, int):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O00000oO(android.view.View, int):void
         arg types: [androidx.viewpager2.widget.ViewPager2, int]
         candidates:
          _m_j.cb.O00000oO(android.view.View, float):void
          _m_j.cb.O00000oO(android.view.View, int):void */
        public final void O000000o(RecyclerView recyclerView) {
            cb.O00000oO((View) recyclerView, 2);
            this.O00000oO = new O00000o0() {
                /* class androidx.viewpager2.widget.ViewPager2.O0000OOo.AnonymousClass3 */

                public final void onChanged() {
                    O0000OOo.this.O0000Oo();
                }
            };
            if (cb.O0000O0o(ViewPager2.this) == 0) {
                cb.O00000oO((View) ViewPager2.this, 1);
            }
        }

        public final void O00000o0() {
            O0000Oo();
        }

        public final void O000000o(RecyclerView.O000000o<?> o000000o) {
            O0000Oo();
            if (o000000o != null) {
                o000000o.registerAdapterDataObserver(this.O00000oO);
            }
        }

        public final void O00000Oo(RecyclerView.O000000o<?> o000000o) {
            if (o000000o != null) {
                o000000o.unregisterAdapterDataObserver(this.O00000oO);
            }
        }

        public final void O00000o() {
            O0000Oo();
        }

        public final void O00000oO() {
            O0000Oo();
        }

        public final void O00000oo() {
            O0000Oo();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        public final void O0000O0o() {
            O0000Oo();
        }

        public final boolean O00000Oo(int i) {
            int i2;
            if (O000000o(i)) {
                if (i == 8192) {
                    i2 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i2 = ViewPager2.this.getCurrentItem() + 1;
                }
                O00000oO(i2);
                return true;
            }
            throw new IllegalStateException();
        }

        public final void O000000o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.viewpager2.widget.ViewPager2.O00000Oo(int, boolean):void
         arg types: [int, int]
         candidates:
          androidx.viewpager2.widget.ViewPager2.O00000Oo(android.content.Context, android.util.AttributeSet):void
          androidx.viewpager2.widget.ViewPager2.O00000Oo(int, boolean):void */
        /* access modifiers changed from: package-private */
        public final void O00000oO(int i) {
            if (ViewPager2.this.O0000OOo) {
                ViewPager2.this.O00000Oo(i, true);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O00000oo(android.view.View, int):void
         arg types: [androidx.viewpager2.widget.ViewPager2, int]
         candidates:
          _m_j.cb.O00000oo(android.view.View, float):void
          _m_j.cb.O00000oo(android.view.View, int):void */
        /* access modifiers changed from: package-private */
        public final void O0000Oo() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = 16908360;
            cb.O00000oo((View) viewPager2, 16908360);
            cb.O00000oo((View) viewPager2, 16908361);
            cb.O00000oo((View) viewPager2, 16908358);
            cb.O00000oo((View) viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.O0000OOo) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean O00000Oo2 = ViewPager2.this.O00000Oo();
                    int i2 = O00000Oo2 ? 16908360 : 16908361;
                    if (O00000Oo2) {
                        i = 16908361;
                    }
                    if (ViewPager2.this.O00000o0 < itemCount - 1) {
                        cb.O000000o(viewPager2, new cl.O000000o(i2, (CharSequence) null), this.O00000o0);
                    }
                    if (ViewPager2.this.O00000o0 > 0) {
                        cb.O000000o(viewPager2, new cl.O000000o(i, (CharSequence) null), this.O00000o);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.O00000o0 < itemCount - 1) {
                    cb.O000000o(viewPager2, new cl.O000000o(16908359, (CharSequence) null), this.O00000o0);
                }
                if (ViewPager2.this.O00000o0 > 0) {
                    cb.O000000o(viewPager2, new cl.O000000o(16908358, (CharSequence) null), this.O00000o);
                }
            }
        }

        public final void O000000o(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            int i2;
            RecyclerView.O000000o adapter;
            int itemCount;
            if (ViewPager2.this.getAdapter() == null) {
                i2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i2 = ViewPager2.this.getAdapter().getItemCount();
            } else {
                i = ViewPager2.this.getAdapter().getItemCount();
                i2 = 0;
                cl.O000000o(accessibilityNodeInfo).O000000o(cl.O00000Oo.O000000o(i2, i, false, 0));
                if (Build.VERSION.SDK_INT >= 16 && (adapter = ViewPager2.this.getAdapter()) != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.O0000OOo) {
                    if (ViewPager2.this.O00000o0 > 0) {
                        accessibilityNodeInfo.addAction(8192);
                    }
                    if (ViewPager2.this.O00000o0 < itemCount - 1) {
                        accessibilityNodeInfo.addAction(4096);
                    }
                    accessibilityNodeInfo.setScrollable(true);
                    return;
                }
                return;
            }
            i = 0;
            cl.O000000o(accessibilityNodeInfo).O000000o(cl.O00000Oo.O000000o(i2, i, false, 0));
            if (Build.VERSION.SDK_INT >= 16) {
            }
        }
    }

    static abstract class O00000o0 extends RecyclerView.O00000o0 {
        public abstract void onChanged();

        private O00000o0() {
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }

        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }

    public final void O000000o(int i, boolean z) {
        if (!this.O0000O0o.f2133O000000o.O00000o) {
            O00000Oo(i, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }
}
