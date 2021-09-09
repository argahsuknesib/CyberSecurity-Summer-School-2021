package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.xiaomi.smarthome.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ToolbarWidgetWrapper implements DecorToolbar {
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Window.Callback mWindowCallback;

    public void setHomeButtonEnabled(boolean z) {
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.support.v7.widget.Toolbar, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        this.mTitleSet = this.mTitle != null;
        this.mNavIcon = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(15);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(27);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(20);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(17);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.mNavIcon == null && (drawable = this.mDefaultNavigationIcon) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(10, 0));
            int resourceId = obtainStyledAttributes.getResourceId(9, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(resourceId, (ViewGroup) this.mToolbar, false));
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.mToolbar;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.mToolbar;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(22, 0);
            if (resourceId4 != 0) {
                this.mToolbar.setPopupTheme(resourceId4);
            }
        } else {
            this.mDisplayOpts = detectDisplayOptions();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class android.support.v7.widget.ToolbarWidgetWrapper.AnonymousClass1 */
            final ActionMenuItem mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.mTitle);

            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.mWindowCallback != null && ToolbarWidgetWrapper.this.mMenuPrepared) {
                    ToolbarWidgetWrapper.this.mWindowCallback.onMenuItemSelected(0, this.mNavItem);
                }
            }
        });
    }

    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = i;
            if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
                setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            }
        }
    }

    private int detectDisplayOptions() {
        if (this.mToolbar.getNavigationIcon() == null) {
            return 11;
        }
        this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        return 15;
    }

    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    public Context getContext() {
        return this.mToolbar.getContext();
    }

    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    public void setWindowCallback(Window.Callback callback) {
        this.mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            setTitleInt(charSequence);
        }
    }

    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        setTitleInt(charSequence);
    }

    private void setTitleInt(CharSequence charSequence) {
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setTitle(charSequence);
        }
    }

    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setSubtitle(charSequence);
        }
    }

    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean hasIcon() {
        return this.mIcon != null;
    }

    public boolean hasLogo() {
        return this.mLogo != null;
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        updateToolbarLogo();
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setLogo(Drawable drawable) {
        this.mLogo = drawable;
        updateToolbarLogo();
    }

    private void updateToolbarLogo() {
        Drawable drawable;
        int i = this.mDisplayOpts;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.mLogo;
            if (drawable == null) {
                drawable = this.mIcon;
            }
        } else {
            drawable = this.mIcon;
        }
        this.mToolbar.setLogo(drawable);
    }

    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mActionMenuPresenter == null) {
            this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            this.mActionMenuPresenter.setId(R.id.action_menu_presenter);
        }
        this.mActionMenuPresenter.setCallback(callback);
        this.mToolbar.setMenu((MenuBuilder) menu, this.mActionMenuPresenter);
    }

    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public void setDisplayOptions(int i) {
        View view;
        int i2 = this.mDisplayOpts ^ i;
        this.mDisplayOpts = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    updateHomeAccessibility();
                }
                updateNavigationIcon();
            }
            if ((i2 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.mToolbar.setTitle(this.mTitle);
                    this.mToolbar.setSubtitle(this.mSubtitle);
                } else {
                    this.mToolbar.setTitle((CharSequence) null);
                    this.mToolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && (view = this.mCustomView) != null) {
                if ((i & 16) != 0) {
                    this.mToolbar.addView(view);
                } else {
                    this.mToolbar.removeView(view);
                }
            }
        }
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.mTabView;
        if (view != null && view.getParent() == (toolbar = this.mToolbar)) {
            toolbar.removeView(this.mTabView);
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.mNavigationMode == 2) {
            this.mToolbar.addView(this.mTabView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public boolean hasEmbeddedTabs() {
        return this.mTabView != null;
    }

    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    public void setCollapsible(boolean z) {
        this.mToolbar.setCollapsible(z);
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public void setNavigationMode(int i) {
        Toolbar toolbar;
        View view;
        Toolbar toolbar2;
        int i2 = this.mNavigationMode;
        if (i != i2) {
            if (i2 == 1) {
                Spinner spinner = this.mSpinner;
                if (spinner != null && spinner.getParent() == (toolbar = this.mToolbar)) {
                    toolbar.removeView(this.mSpinner);
                }
            } else if (i2 == 2 && (view = this.mTabView) != null && view.getParent() == (toolbar2 = this.mToolbar)) {
                toolbar2.removeView(this.mTabView);
            }
            this.mNavigationMode = i;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                ensureSpinner();
                this.mToolbar.addView(this.mSpinner, 0);
            } else if (i == 2) {
                View view2 = this.mTabView;
                if (view2 != null) {
                    this.mToolbar.addView(view2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = 8388691;
                }
            } else {
                throw new IllegalArgumentException("Invalid navigation mode ".concat(String.valueOf(i)));
            }
        }
    }

    private void ensureSpinner() {
        if (this.mSpinner == null) {
            this.mSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
            this.mSpinner.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ensureSpinner();
        this.mSpinner.setAdapter(spinnerAdapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            spinner.setSelection(i);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    public int getDropdownSelectedPosition() {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    public int getDropdownItemCount() {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (!(view2 == null || (this.mDisplayOpts & 16) == 0)) {
            this.mToolbar.removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (this.mDisplayOpts & 16) != 0) {
            this.mToolbar.addView(this.mCustomView);
        }
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        return ViewCompat.animate(this.mToolbar).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter() {
            /* class android.support.v7.widget.ToolbarWidgetWrapper.AnonymousClass2 */
            private boolean mCanceled = false;

            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
            }

            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.mToolbar.setVisibility(i);
                }
            }

            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }
        });
    }

    public void setNavigationIcon(Drawable drawable) {
        this.mNavIcon = drawable;
        updateNavigationIcon();
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.mDefaultNavigationIcon != drawable) {
            this.mDefaultNavigationIcon = drawable;
            updateNavigationIcon();
        }
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) != 0) {
            Toolbar toolbar = this.mToolbar;
            Drawable drawable = this.mNavIcon;
            if (drawable == null) {
                drawable = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.mToolbar.setNavigationIcon((Drawable) null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mHomeDescription = charSequence;
        updateHomeAccessibility();
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.saveHierarchyState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.restoreHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.mToolbar, drawable);
    }

    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    public void setVisibility(int i) {
        this.mToolbar.setVisibility(i);
    }

    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mToolbar.setMenuCallbacks(callback, callback2);
    }

    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }
}
