package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        this.mPresenter.setMenuView(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MenuBuilder menuBuilder;
        boolean z = this.mFormatItems;
        this.mFormatItems = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.mFormatItems || (menuBuilder = this.mMenu) == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        onMeasureExactFormat(i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x024c A[LOOP:5: B:135:0x024c->B:139:0x026a, LOOP_START, PHI: r13 10  PHI: (r13v3 int) = (r13v2 int), (r13v4 int) binds: [B:134:0x024a, B:139:0x026a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0272  */
    private void onMeasureExactFormat(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z3;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i12 = size - paddingLeft;
        int i13 = this.mMinCellSize;
        int i14 = i12 / i13;
        int i15 = i12 % i13;
        if (i14 == 0) {
            setMeasuredDimension(i12, 0);
            return;
        }
        int i16 = i13 + (i15 / i14);
        int childCount = getChildCount();
        int i17 = i14;
        int i18 = 0;
        int i19 = 0;
        boolean z4 = false;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        long j = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            int i23 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i24 = i20 + 1;
                if (z5) {
                    int i25 = this.mGeneratedItemPadding;
                    i11 = i24;
                    z3 = false;
                    childAt.setPadding(i25, 0, i25, 0);
                } else {
                    i11 = i24;
                    z3 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = z3;
                layoutParams.extraPixels = z3 ? 1 : 0;
                layoutParams.cellsUsed = z3;
                layoutParams.expandable = z3;
                layoutParams.leftMargin = z3;
                layoutParams.rightMargin = z3;
                layoutParams.preventEdgeOffset = z5 && ((ActionMenuItemView) childAt).hasText();
                int measureChildForCells = measureChildForCells(childAt, i16, layoutParams.isOverflowButton ? 1 : i17, childMeasureSpec, paddingTop);
                int max = Math.max(i21, measureChildForCells);
                if (layoutParams.expandable) {
                    i22++;
                }
                if (layoutParams.isOverflowButton) {
                    z4 = true;
                }
                i17 -= measureChildForCells;
                i19 = Math.max(i19, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j |= (long) (1 << i18);
                    i19 = i19;
                }
                i21 = max;
                i20 = i11;
            }
            i18++;
            size2 = i23;
        }
        int i26 = size2;
        boolean z6 = z4 && i20 == 2;
        boolean z7 = false;
        while (true) {
            if (i22 > 0 && i17 > 0) {
                int i27 = Integer.MAX_VALUE;
                int i28 = 0;
                int i29 = 0;
                long j2 = 0;
                while (i28 < childCount) {
                    boolean z8 = z7;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i28).getLayoutParams();
                    int i30 = i19;
                    if (layoutParams2.expandable) {
                        if (layoutParams2.cellsUsed < i27) {
                            i27 = layoutParams2.cellsUsed;
                            i10 = mode;
                            i9 = i12;
                            j2 = (long) (1 << i28);
                            i29 = 1;
                        } else if (layoutParams2.cellsUsed == i27) {
                            i10 = mode;
                            i9 = i12;
                            i29++;
                            j2 |= (long) (1 << i28);
                        }
                        i28++;
                        mode = i10;
                        i19 = i30;
                        z7 = z8;
                        i12 = i9;
                    }
                    i10 = mode;
                    i9 = i12;
                    i28++;
                    mode = i10;
                    i19 = i30;
                    z7 = z8;
                    i12 = i9;
                }
                i3 = i12;
                z = z7;
                i4 = i19;
                i5 = mode;
                j |= j2;
                if (i29 > i17) {
                    break;
                }
                int i31 = i27 + 1;
                int i32 = 0;
                while (i32 < childCount) {
                    View childAt2 = getChildAt(i32);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    long j3 = (long) (1 << i32);
                    if ((j2 & j3) == 0) {
                        if (layoutParams3.cellsUsed == i31) {
                            j |= j3;
                        }
                        i8 = i31;
                    } else {
                        if (!z6 || !layoutParams3.preventEdgeOffset || i17 != 1) {
                            i8 = i31;
                        } else {
                            int i33 = this.mGeneratedItemPadding;
                            i8 = i31;
                            childAt2.setPadding(i33 + i16, 0, i33, 0);
                        }
                        layoutParams3.cellsUsed++;
                        layoutParams3.expanded = true;
                        i17--;
                    }
                    i32++;
                    i31 = i8;
                }
                mode = i5;
                i19 = i4;
                i12 = i3;
                z7 = true;
            } else {
                i3 = i12;
                z = z7;
                i4 = i19;
                i5 = mode;
            }
        }
        if (!z4) {
            i6 = 1;
            if (i20 == 1) {
                z2 = true;
                if (i17 > 0 || j == 0 || (i17 >= i20 - i6 && !z2 && i21 <= i6)) {
                    i7 = 0;
                } else {
                    float bitCount = (float) Long.bitCount(j);
                    if (!z2) {
                        if ((j & 1) != 0) {
                            i7 = 0;
                            if (!((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                                bitCount -= 0.5f;
                            }
                        } else {
                            i7 = 0;
                        }
                        int i34 = childCount - 1;
                        if ((j & ((long) (1 << i34))) != 0 && !((LayoutParams) getChildAt(i34).getLayoutParams()).preventEdgeOffset) {
                            bitCount -= 0.5f;
                        }
                    } else {
                        i7 = 0;
                    }
                    int i35 = bitCount > 0.0f ? (int) (((float) (i17 * i16)) / bitCount) : 0;
                    boolean z9 = z;
                    for (int i36 = 0; i36 < childCount; i36++) {
                        if ((j & ((long) (1 << i36))) != 0) {
                            View childAt3 = getChildAt(i36);
                            LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams4.extraPixels = i35;
                                layoutParams4.expanded = true;
                                if (i36 == 0 && !layoutParams4.preventEdgeOffset) {
                                    layoutParams4.leftMargin = (-i35) / 2;
                                }
                            } else if (layoutParams4.isOverflowButton) {
                                layoutParams4.extraPixels = i35;
                                layoutParams4.expanded = true;
                                layoutParams4.rightMargin = (-i35) / 2;
                            } else {
                                if (i36 != 0) {
                                    layoutParams4.leftMargin = i35 / 2;
                                }
                                if (i36 != childCount - 1) {
                                    layoutParams4.rightMargin = i35 / 2;
                                }
                            }
                            z9 = true;
                        }
                    }
                    z = z9;
                }
                if (z) {
                    while (i7 < childCount) {
                        View childAt4 = getChildAt(i7);
                        LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                        if (layoutParams5.expanded) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i16) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                        }
                        i7++;
                    }
                }
                setMeasuredDimension(i3, i5 == 1073741824 ? i4 : i26);
            }
        } else {
            i6 = 1;
        }
        z2 = false;
        if (i17 > 0) {
        }
        i7 = 0;
        if (z) {
        }
        setMeasuredDimension(i3, i5 == 1073741824 ? i4 : i26);
    }

    static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
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
        if (layoutParams.isOverflowButton || !z2) {
            z = false;
        }
        layoutParams.expandable = z;
        layoutParams.cellsUsed = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i3 - i;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i11 = paddingRight;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
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
                    hasSupportDividerBeforeChildAt(i14);
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
        if (isLayoutRtl) {
            int width = getWidth() - getPaddingRight();
            while (i6 < childCount) {
                View childAt3 = getChildAt(i6);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
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
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
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
        dismissPopupMenus();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            this.mMenu = new MenuBuilder(context);
            this.mMenu.setCallback(new MenuBuilderCallback());
            this.mPresenter = new ActionMenuPresenter(context);
            this.mPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasSupportDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = false | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : z | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }

        ActionMenuPresenterCallback() {
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
        }
    }
}
