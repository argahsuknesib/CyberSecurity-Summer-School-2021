package androidx.appcompat.widget;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.OO0o000;
import _m_j.o00;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements OO0o00, MenuBuilder.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    MenuBuilder f2693O000000o;
    boolean O00000Oo;
    MenuBuilder.O000000o O00000o;
    ActionMenuPresenter O00000o0;
    O00000o O00000oO;
    private Context O00000oo;
    private int O0000O0o;
    private OO0o000.O000000o O0000OOo;
    private int O0000Oo;
    private boolean O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;

    public interface O000000o {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public interface O00000o {
        boolean O000000o(MenuItem menuItem);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.O0000OoO = (int) (56.0f * f);
        this.O0000Ooo = (int) (f * 4.0f);
        this.O00000oo = context;
        this.O0000O0o = 0;
    }

    public void setPopupTheme(int i) {
        if (this.O0000O0o != i) {
            this.O0000O0o = i;
            if (i == 0) {
                this.O00000oo = getContext();
            } else {
                this.O00000oo = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.O0000O0o;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.O00000o0 = actionMenuPresenter;
        this.O00000o0.O000000o(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.O00000o0;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.O00000o0.O0000O0o()) {
                this.O00000o0.O00000o();
                this.O00000o0.O00000o0();
            }
        }
    }

    public void setOnMenuItemClickListener(O00000o o00000o) {
        this.O00000oO = o00000o;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x029c  */
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        MenuBuilder menuBuilder;
        boolean z4 = this.O0000Oo0;
        this.O0000Oo0 = View.MeasureSpec.getMode(i) == 1073741824;
        if (z4 != this.O0000Oo0) {
            this.O0000Oo = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.O0000Oo0 || (menuBuilder = this.f2693O000000o) == null || size == this.O0000Oo)) {
            this.O0000Oo = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.O0000Oo0 || childCount <= 0) {
            for (int i10 = 0; i10 < childCount; i10++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i11 = size2 - paddingLeft;
        int i12 = this.O0000OoO;
        int i13 = i11 / i12;
        int i14 = i11 % i12;
        if (i13 == 0) {
            setMeasuredDimension(i11, 0);
            return;
        }
        int i15 = i12 + (i14 / i13);
        int childCount2 = getChildCount();
        int i16 = i13;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        boolean z5 = false;
        int i20 = 0;
        int i21 = 0;
        long j = 0;
        while (i18 < childCount2) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                i20++;
                if (z6) {
                    int i22 = this.O0000Ooo;
                    i9 = size3;
                    z3 = false;
                    childAt.setPadding(i22, 0, i22, 0);
                } else {
                    i9 = size3;
                    z3 = false;
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.O00000oo = z3;
                layoutParams2.O00000o0 = z3 ? 1 : 0;
                layoutParams2.O00000Oo = z3;
                layoutParams2.O00000o = z3;
                layoutParams2.leftMargin = z3;
                layoutParams2.rightMargin = z3;
                layoutParams2.O00000oO = z6 && ((ActionMenuItemView) childAt).hasText();
                int O000000o2 = O000000o(childAt, i15, layoutParams2.f2694O000000o ? 1 : i16, childMeasureSpec, paddingTop);
                i17 = Math.max(i17, O000000o2);
                if (layoutParams2.O00000o) {
                    i21++;
                }
                if (layoutParams2.f2694O000000o) {
                    z5 = true;
                }
                i16 -= O000000o2;
                int max = Math.max(i19, childAt.getMeasuredHeight());
                if (O000000o2 == 1) {
                    j |= (long) (1 << i18);
                }
                i19 = max;
            } else {
                i9 = size3;
            }
            i18++;
            size3 = i9;
        }
        int i23 = size3;
        boolean z7 = z5 && i20 == 2;
        int i24 = i16;
        boolean z8 = false;
        while (true) {
            if (i21 > 0 && i24 > 0) {
                int i25 = Integer.MAX_VALUE;
                int i26 = 0;
                int i27 = 0;
                long j2 = 0;
                while (i26 < childCount2) {
                    boolean z9 = z8;
                    LayoutParams layoutParams3 = (LayoutParams) getChildAt(i26).getLayoutParams();
                    int i28 = i19;
                    if (layoutParams3.O00000o) {
                        if (layoutParams3.O00000Oo < i25) {
                            i25 = layoutParams3.O00000Oo;
                            j2 = 1 << i26;
                            i27 = 1;
                        } else if (layoutParams3.O00000Oo == i25) {
                            j2 |= 1 << i26;
                            i27++;
                        }
                    }
                    i26++;
                    i19 = i28;
                    z8 = z9;
                }
                z = z8;
                i4 = i19;
                j |= j2;
                if (i27 > i24) {
                    i5 = mode;
                    i3 = i11;
                    break;
                }
                int i29 = i25 + 1;
                int i30 = i24;
                int i31 = 0;
                while (i31 < childCount2) {
                    View childAt2 = getChildAt(i31);
                    LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                    int i32 = i11;
                    int i33 = mode;
                    long j3 = (long) (1 << i31);
                    if ((j2 & j3) == 0) {
                        if (layoutParams4.O00000Oo == i29) {
                            j |= j3;
                        }
                        i8 = i29;
                    } else {
                        if (!z7 || !layoutParams4.O00000oO || i30 != 1) {
                            i8 = i29;
                        } else {
                            int i34 = this.O0000Ooo;
                            i8 = i29;
                            childAt2.setPadding(i34 + i15, 0, i34, 0);
                        }
                        layoutParams4.O00000Oo++;
                        layoutParams4.O00000oo = true;
                        i30--;
                    }
                    i31++;
                    mode = i33;
                    i29 = i8;
                    i11 = i32;
                }
                i24 = i30;
                i19 = i4;
                z8 = true;
            } else {
                i5 = mode;
                i3 = i11;
                z = z8;
                i4 = i19;
            }
        }
        if (!z5) {
            i6 = 1;
            if (i20 == 1) {
                z2 = true;
                if (i24 > 0 && j != 0 && (i24 < i20 - i6 || z2 || i17 > i6)) {
                    float bitCount = (float) Long.bitCount(j);
                    if (!z2) {
                        if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).O00000oO) {
                            bitCount -= 0.5f;
                        }
                        int i35 = childCount2 - 1;
                        if ((j & ((long) (1 << i35))) != 0 && !((LayoutParams) getChildAt(i35).getLayoutParams()).O00000oO) {
                            bitCount -= 0.5f;
                        }
                    }
                    int i36 = bitCount <= 0.0f ? (int) (((float) (i24 * i15)) / bitCount) : 0;
                    boolean z10 = z;
                    for (i7 = 0; i7 < childCount2; i7++) {
                        if ((j & ((long) (1 << i7))) != 0) {
                            View childAt3 = getChildAt(i7);
                            LayoutParams layoutParams5 = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams5.O00000o0 = i36;
                                layoutParams5.O00000oo = true;
                                if (i7 == 0 && !layoutParams5.O00000oO) {
                                    layoutParams5.leftMargin = (-i36) / 2;
                                }
                            } else if (layoutParams5.f2694O000000o) {
                                layoutParams5.O00000o0 = i36;
                                layoutParams5.O00000oo = true;
                                layoutParams5.rightMargin = (-i36) / 2;
                            } else {
                                if (i7 != 0) {
                                    layoutParams5.leftMargin = i36 / 2;
                                }
                                if (i7 != childCount2 - 1) {
                                    layoutParams5.rightMargin = i36 / 2;
                                }
                            }
                            z10 = true;
                        }
                    }
                    z = z10;
                }
                if (z) {
                    for (int i37 = 0; i37 < childCount2; i37++) {
                        View childAt4 = getChildAt(i37);
                        LayoutParams layoutParams6 = (LayoutParams) childAt4.getLayoutParams();
                        if (layoutParams6.O00000oo) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams6.O00000Oo * i15) + layoutParams6.O00000o0, 1073741824), childMeasureSpec);
                        }
                    }
                }
                setMeasuredDimension(i3, i5 == 1073741824 ? i4 : i23);
            }
        } else {
            i6 = 1;
        }
        z2 = false;
        float bitCount2 = (float) Long.bitCount(j);
        if (!z2) {
        }
        if (bitCount2 <= 0.0f) {
        }
        boolean z102 = z;
        while (i7 < childCount2) {
        }
        z = z102;
        if (z) {
        }
        setMeasuredDimension(i3, i5 == 1073741824 ? i4 : i23);
    }

    static int O000000o(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (layoutParams.f2694O000000o || !z2) {
            z = false;
        }
        layoutParams.O00000o = z;
        layoutParams.O00000Oo = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (!this.O0000Oo0) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i3 - i;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean O000000o2 = o00.O000000o(this);
        int i11 = paddingRight;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2694O000000o) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (O000000o(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (O000000o2) {
                        i7 = getPaddingLeft() + layoutParams.leftMargin;
                        i8 = i7 + measuredWidth;
                    } else {
                        i8 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i7 = i8 - measuredWidth;
                    }
                    int i15 = i9 - (measuredHeight / 2);
                    childAt.layout(i7, i15, i8, measuredHeight + i15);
                    i11 -= measuredWidth;
                    i12 = 1;
                } else {
                    i11 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    O000000o(i14);
                    i13++;
                }
            }
        }
        if (childCount == 1 && i12 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i16 = (i10 / 2) - (measuredWidth2 / 2);
            int i17 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i16, i17, measuredWidth2 + i16, measuredHeight2 + i17);
            return;
        }
        int i18 = i13 - (i12 ^ 1);
        if (i18 > 0) {
            i5 = i11 / i18;
            i6 = 0;
        } else {
            i6 = 0;
            i5 = 0;
        }
        int max = Math.max(i6, i5);
        if (O000000o2) {
            int width = getWidth() - getPaddingRight();
            while (i6 < childCount) {
                View childAt3 = getChildAt(i6);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f2694O000000o) {
                    int i19 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width = i19 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
                i6++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i6 < childCount) {
            View childAt4 = getChildAt(i6);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f2694O000000o) {
                int i21 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
            i6++;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000Oo();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.O00000o0;
        if (actionMenuPresenter.O0000Oo0 != null) {
            actionMenuPresenter.O0000Oo0.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.O0000OoO = true;
        actionMenuPresenter.O0000Oo = drawable;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.O00000o0;
        if (actionMenuPresenter.O0000Oo0 != null) {
            return actionMenuPresenter.O0000Oo0.getDrawable();
        }
        if (actionMenuPresenter.O0000OoO) {
            return actionMenuPresenter.O0000Oo;
        }
        return null;
    }

    public void setOverflowReserved(boolean z) {
        this.O00000Oo = z;
    }

    private static LayoutParams O00000o0() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.O0000OOo = 16;
        return layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams O000000o(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return O00000o0();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.O0000OOo <= 0) {
            layoutParams2.O0000OOo = 16;
        }
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static LayoutParams O000000o() {
        LayoutParams O00000o02 = O00000o0();
        O00000o02.f2694O000000o = true;
        return O00000o02;
    }

    public final boolean O000000o(OO0OOOO oo0oooo) {
        return this.f2693O000000o.performItemAction(oo0oooo, 0);
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.f2693O000000o = menuBuilder;
    }

    public Menu getMenu() {
        if (this.f2693O000000o == null) {
            Context context = getContext();
            this.f2693O000000o = new MenuBuilder(context);
            this.f2693O000000o.setCallback(new O00000o0());
            this.O00000o0 = new ActionMenuPresenter(context);
            this.O00000o0.O00000Oo();
            ActionMenuPresenter actionMenuPresenter = this.O00000o0;
            OO0o000.O000000o o000000o = this.O0000OOo;
            if (o000000o == null) {
                o000000o = new O00000Oo();
            }
            actionMenuPresenter.setCallback(o000000o);
            this.f2693O000000o.addMenuPresenter(this.O00000o0, this.O00000oo);
            this.O00000o0.O000000o(this);
        }
        return this.f2693O000000o;
    }

    public final void O000000o(OO0o000.O000000o o000000o, MenuBuilder.O000000o o000000o2) {
        this.O0000OOo = o000000o;
        this.O00000o = o000000o2;
    }

    public final void O00000Oo() {
        ActionMenuPresenter actionMenuPresenter = this.O00000o0;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.O00000oO();
        }
    }

    private boolean O000000o(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof O000000o)) {
            z = false | ((O000000o) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof O000000o)) ? z : z | ((O000000o) childAt2).needsDividerBefore();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.O00000o0.O0000Ooo = z;
    }

    class O00000o0 implements MenuBuilder.O000000o {
        O00000o0() {
        }

        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.O00000oO != null && ActionMenuView.this.O00000oO.O000000o(menuItem);
        }

        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.O00000o != null) {
                ActionMenuView.this.O00000o.onMenuModeChange(menuBuilder);
            }
        }
    }

    static class O00000Oo implements OO0o000.O000000o {
        public final void O000000o(MenuBuilder menuBuilder, boolean z) {
        }

        public final boolean O000000o(MenuBuilder menuBuilder) {
            return false;
        }

        O00000Oo() {
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f2694O000000o;
        @ViewDebug.ExportedProperty
        public int O00000Oo;
        @ViewDebug.ExportedProperty
        public boolean O00000o;
        @ViewDebug.ExportedProperty
        public int O00000o0;
        @ViewDebug.ExportedProperty
        public boolean O00000oO;
        boolean O00000oo;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2694O000000o = layoutParams.f2694O000000o;
        }

        public LayoutParams() {
            super(-2, -2);
            this.f2694O000000o = false;
        }
    }
}
