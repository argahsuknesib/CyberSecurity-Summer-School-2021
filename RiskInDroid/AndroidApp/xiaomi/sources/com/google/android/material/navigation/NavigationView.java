package com.google.android.material.navigation;

import _m_j.OO0000o;
import _m_j.OO0OOOO;
import _m_j.Oo;
import _m_j.cb;
import _m_j.ci;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = 2132739078;
    private static final int[] DISABLED_STATE_SET = {-16842910};
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    public final NavigationMenuPresenter presenter;
    public final int[] tmpLocation;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.Oo.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.Oo.O000000o(int, int):int
      _m_j.Oo.O000000o(int, boolean):boolean */
    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        ColorStateList colorStateList;
        boolean z;
        int i2;
        this.presenter = new NavigationMenuPresenter();
        this.tmpLocation = new int[2];
        Context context2 = getContext();
        this.menu = new NavigationMenu(context2);
        Oo obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, new int[]{16842964, 16842973, 16843039, R.attr.elevation, R.attr.headerLayout, R.attr.itemBackground, R.attr.itemHorizontalPadding, R.attr.itemIconPadding, R.attr.itemIconSize, R.attr.itemIconTint, R.attr.itemMaxLines, R.attr.itemShapeAppearance, R.attr.itemShapeAppearanceOverlay, R.attr.itemShapeFillColor, R.attr.itemShapeInsetBottom, R.attr.itemShapeInsetEnd, R.attr.itemShapeInsetStart, R.attr.itemShapeInsetTop, R.attr.itemTextAppearance, R.attr.itemTextColor, R.attr.menu, R.attr.shapeAppearance, R.attr.shapeAppearanceOverlay}, i, DEF_STYLE_RES, new int[0]);
        if (obtainTintedStyledAttributes.O0000O0o(0)) {
            cb.O000000o(this, obtainTintedStyledAttributes.O000000o(0));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ShapeAppearanceModel build = ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build();
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            cb.O000000o(this, materialShapeDrawable);
        }
        if (obtainTintedStyledAttributes.O0000O0o(3)) {
            setElevation((float) obtainTintedStyledAttributes.O00000oO(3, 0));
        }
        setFitsSystemWindows(obtainTintedStyledAttributes.O000000o(1, false));
        this.maxWidth = obtainTintedStyledAttributes.O00000oO(2, 0);
        if (obtainTintedStyledAttributes.O0000O0o(9)) {
            colorStateList = obtainTintedStyledAttributes.O00000oO(9);
        } else {
            colorStateList = createDefaultColorStateList(16842808);
        }
        if (obtainTintedStyledAttributes.O0000O0o(18)) {
            i2 = obtainTintedStyledAttributes.O0000O0o(18, 0);
            z = true;
        } else {
            z = false;
            i2 = 0;
        }
        if (obtainTintedStyledAttributes.O0000O0o(8)) {
            setItemIconSize(obtainTintedStyledAttributes.O00000oO(8, 0));
        }
        ColorStateList O00000oO = obtainTintedStyledAttributes.O0000O0o(19) ? obtainTintedStyledAttributes.O00000oO(19) : null;
        if (!z && O00000oO == null) {
            O00000oO = createDefaultColorStateList(16842806);
        }
        Drawable O000000o2 = obtainTintedStyledAttributes.O000000o(5);
        if (O000000o2 == null && hasShapeAppearance(obtainTintedStyledAttributes)) {
            O000000o2 = createDefaultItemBackground(obtainTintedStyledAttributes);
        }
        if (obtainTintedStyledAttributes.O0000O0o(6)) {
            this.presenter.setItemHorizontalPadding(obtainTintedStyledAttributes.O00000oO(6, 0));
        }
        int O00000oO2 = obtainTintedStyledAttributes.O00000oO(7, 0);
        setItemMaxLines(obtainTintedStyledAttributes.O000000o(10, 1));
        this.menu.setCallback(new MenuBuilder.O000000o() {
            /* class com.google.android.material.navigation.NavigationView.AnonymousClass1 */

            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }

            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                return NavigationView.this.listener != null && NavigationView.this.listener.onNavigationItemSelected(menuItem);
            }
        });
        this.presenter.setId(1);
        this.presenter.initForMenu(context2, this.menu);
        this.presenter.setItemIconTintList(colorStateList);
        this.presenter.setOverScrollMode(getOverScrollMode());
        if (z) {
            this.presenter.setItemTextAppearance(i2);
        }
        this.presenter.setItemTextColor(O00000oO);
        this.presenter.setItemBackground(O000000o2);
        this.presenter.setItemIconPadding(O00000oO2);
        this.menu.addMenuPresenter(this.presenter);
        addView((View) this.presenter.getMenuView(this));
        if (obtainTintedStyledAttributes.O0000O0o(20)) {
            inflateMenu(obtainTintedStyledAttributes.O0000O0o(20, 0));
        }
        if (obtainTintedStyledAttributes.O0000O0o(4)) {
            inflateHeaderView(obtainTintedStyledAttributes.O0000O0o(4, 0));
        }
        obtainTintedStyledAttributes.f12340O000000o.recycle();
        setupInsetScrimsListener();
    }

    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i);
        }
    }

    private boolean hasShapeAppearance(Oo oo) {
        return oo.O0000O0o(11) || oo.O0000O0o(12);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    public void setElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f);
        }
        MaterialShapeUtils.setElevation(this, f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
     arg types: [com.google.android.material.shape.MaterialShapeDrawable, int, int, int, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
    private final Drawable createDefaultItemBackground(Oo oo) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), oo.O0000O0o(11, 0), oo.O0000O0o(12, 0)).build());
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), oo, 13));
        return new InsetDrawable((Drawable) materialShapeDrawable, oo.O00000oO(16, 0), oo.O00000oO(17, 0), oo.O00000oO(15, 0), oo.O00000oO(14, 0));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        this.menu.savePresenterStates(savedState.menuState);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void onInsetsChanged(ci ciVar) {
        this.presenter.dispatchApplyWindowInsets(ciVar);
    }

    public void inflateMenu(int i) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int i) {
        return this.presenter.inflateHeaderView(i);
    }

    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int i) {
        return this.presenter.getHeaderView(i);
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.O000000o(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public void setItemHorizontalPadding(int i) {
        this.presenter.setItemHorizontalPadding(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public void setItemIconPadding(int i) {
        this.presenter.setItemIconPadding(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            this.presenter.setCheckedItem((OO0OOOO) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.setCheckedItem((OO0OOOO) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public void setItemTextAppearance(int i) {
        this.presenter.setItemTextAppearance(i);
    }

    public void setItemIconSize(int i) {
        this.presenter.setItemIconSize(i);
    }

    public void setItemMaxLines(int i) {
        this.presenter.setItemMaxLines(i);
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList O000000o2 = OO0000o.O000000o(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = O000000o2.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{O000000o2.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.google.android.material.navigation.NavigationView.AnonymousClass2 */

            public void onGlobalLayout() {
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z = true;
                boolean z2 = NavigationView.this.tmpLocation[1] == 0;
                NavigationView.this.presenter.setBehindStatusBar(z2);
                NavigationView.this.setDrawTopInsetForeground(z2);
                Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
                if (activity != null && Build.VERSION.SDK_INT >= 21) {
                    boolean z3 = activity.findViewById(16908290).getHeight() == NavigationView.this.getHeight();
                    boolean z4 = Color.alpha(activity.getWindow().getNavigationBarColor()) != 0;
                    NavigationView navigationView2 = NavigationView.this;
                    if (!z3 || !z4) {
                        z = false;
                    }
                    navigationView2.setDrawBottomInsetForeground(z);
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class com.google.android.material.navigation.NavigationView.SavedState.AnonymousClass1 */

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
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }
}
