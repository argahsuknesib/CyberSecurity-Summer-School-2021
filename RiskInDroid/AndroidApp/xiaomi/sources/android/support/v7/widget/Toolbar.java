package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener() {
            /* class android.support.v7.widget.Toolbar.AnonymousClass1 */

            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() {
            /* class android.support.v7.widget.Toolbar.AnonymousClass2 */

            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, new int[]{16842927, 16843072, R.attr.buttonGravity, R.attr.collapseContentDescription, R.attr.collapseIcon, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.logo, R.attr.logoDescription, R.attr.maxButtonHeight, R.attr.menu, R.attr.navigationContentDescription, R.attr.navigationIcon, R.attr.popupTheme, R.attr.subtitle, R.attr.subtitleTextAppearance, R.attr.subtitleTextColor, R.attr.title, R.attr.titleMargin, R.attr.titleMarginBottom, R.attr.titleMarginEnd, R.attr.titleMarginStart, R.attr.titleMarginTop, R.attr.titleMargins, R.attr.titleTextAppearance, R.attr.titleTextColor}, i, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(28, 0);
        this.mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(19, 0);
        this.mGravity = obtainStyledAttributes.getInteger(0, this.mGravity);
        this.mButtonGravity = obtainStyledAttributes.getInteger(2, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = obtainStyledAttributes.hasValue(27) ? obtainStyledAttributes.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            this.mContentInsets.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = obtainStyledAttributes.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = obtainStyledAttributes.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(4);
        this.mCollapseDescription = obtainStyledAttributes.getText(3);
        CharSequence text = obtainStyledAttributes.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(17, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(16);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(11);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(29)) {
            setTitleTextColor(obtainStyledAttributes.getColor(29, -1));
        }
        if (obtainStyledAttributes.hasValue(20)) {
            setSubtitleTextColor(obtainStyledAttributes.getColor(20, -1));
        }
        obtainStyledAttributes.recycle();
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

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.mTitleMarginStart = i;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        rtlSpacingHelper.setDirection(z);
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(AppCompatResources.getDrawable(getContext(), i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.isOverflowReserved();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.hideOverflowMenu();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                    menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                    actionMenuPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.mOuterActionMenuPresenter = actionMenuPresenter;
            }
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.mCurrentExpandedItem;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mTitleTextAppearance;
                if (i != 0) {
                    this.mTitleTextView.setTextAppearance(context, i);
                }
                int i2 = this.mTitleTextColor;
                if (i2 != 0) {
                    this.mTitleTextView.setTextColor(i2);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mSubtitleTextAppearance;
                if (i != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i);
                }
                int i2 = this.mSubtitleTextColor;
                if (i2 != 0) {
                    this.mSubtitleTextView.setTextColor(i2);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        this.mTitleTextAppearance = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        this.mSubtitleTextAppearance = i;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.mTitleTextColor = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.mSubtitleTextColor = i;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(@MenuRes int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.setRelative(i, i2);
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getStart();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getEnd();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(i, i2);
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getLeft();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getRight();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.mContentInsetStartWithNavigation;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int i = this.mContentInsetEndWithActions;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder peekMenu;
        ActionMenuView actionMenuView = this.mMenuView;
        if ((actionMenuView == null || (peekMenu = actionMenuView.peekMenu()) == null || !peekMenu.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() {
                /* class android.support.v7.widget.Toolbar.AnonymousClass3 */

                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.mViewType = 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.mHiddenViews.add(view);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (!(expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null)) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        MenuBuilder peekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
        if (!(savedState.expandedMenuItemId == 0 || this.mExpandedMenuPresenter == null || peekMenu == null || (findItem = peekMenu.findItem(savedState.expandedMenuItemId)) == null)) {
            MenuItemCompat.expandActionView(findItem);
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.mTempMargins;
        if (ViewUtils.isLayoutRtl(this)) {
            c2 = 1;
            c = 0;
        } else {
            c2 = 0;
            c = 1;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i5 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i4 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i3 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i5 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i4 = Math.max(i4, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.getMeasuredState(this.mCollapseButtonView));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i5) + 0;
        iArr[c2] = Math.max(0, currentContentInsetStart - i5);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max, i2, 0, this.mMaxButtonHeight);
            i6 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i4 = Math.max(i4, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.getMeasuredState(this.mMenuView));
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c] = Math.max(0, currentContentInsetEnd - i6);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.getMeasuredState(this.mExpandedActionView));
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.getMeasuredState(this.mLogoView));
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                i11 += measureChildCollapseMargins(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.getMeasuredState(childAt));
            }
        }
        int i13 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i14 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i7 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i9 = ViewUtils.combineMeasuredStates(i3, ViewCompat.getMeasuredState(this.mTitleTextView));
            i8 = measuredWidth;
        } else {
            i9 = i3;
            i8 = 0;
            i7 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            int i15 = i7 + i13;
            i8 = Math.max(i8, measureChildCollapseMargins(this.mSubtitleTextView, i, i11 + i14, i2, i15, iArr));
            i7 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i9 = ViewUtils.combineMeasuredStates(i9, ViewCompat.getMeasuredState(this.mSubtitleTextView));
        }
        int max3 = Math.max(i10, i7);
        int paddingLeft = i11 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i9);
        int resolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i9 << 16);
        if (shouldCollapse()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a5 A[LOOP:0: B:101:0x02a3->B:102:0x02a5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c7 A[LOOP:1: B:104:0x02c5->B:105:0x02c7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0301 A[LOOP:2: B:112:0x02ff->B:113:0x0301, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022b  */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int size;
        int i14;
        int i15;
        int size2;
        int i16;
        int i17;
        int size3;
        boolean z2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        char c;
        int i24;
        int i25;
        boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i26 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        int min = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (!shouldLayout(this.mNavButtonView)) {
            i6 = paddingLeft;
        } else if (z3) {
            i5 = layoutChildRight(this.mNavButtonView, i26, iArr, min);
            i6 = paddingLeft;
            if (shouldLayout(this.mCollapseButtonView)) {
                if (z3) {
                    i5 = layoutChildRight(this.mCollapseButtonView, i5, iArr, min);
                } else {
                    i6 = layoutChildLeft(this.mCollapseButtonView, i6, iArr, min);
                }
            }
            if (shouldLayout(this.mMenuView)) {
                if (z3) {
                    i6 = layoutChildLeft(this.mMenuView, i6, iArr, min);
                } else {
                    i5 = layoutChildRight(this.mMenuView, i5, iArr, min);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i6);
            iArr[1] = Math.max(0, currentContentInsetRight - (i26 - i5));
            int max = Math.max(i6, currentContentInsetLeft);
            int min2 = Math.min(i5, i26 - currentContentInsetRight);
            if (shouldLayout(this.mExpandedActionView)) {
                if (z3) {
                    min2 = layoutChildRight(this.mExpandedActionView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mExpandedActionView, max, iArr, min);
                }
            }
            if (shouldLayout(this.mLogoView)) {
                if (z3) {
                    min2 = layoutChildRight(this.mLogoView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mLogoView, max, iArr, min);
                }
            }
            shouldLayout = shouldLayout(this.mTitleTextView);
            shouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (!shouldLayout) {
                LayoutParams layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                i8 = paddingRight;
                i9 = layoutParams.topMargin + this.mTitleTextView.getMeasuredHeight() + layoutParams.bottomMargin + 0;
            } else {
                i8 = paddingRight;
                i9 = 0;
            }
            if (!shouldLayout2) {
                LayoutParams layoutParams2 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                i10 = width;
                i9 += layoutParams2.topMargin + this.mSubtitleTextView.getMeasuredHeight() + layoutParams2.bottomMargin;
            } else {
                i10 = width;
            }
            if (!shouldLayout || shouldLayout2) {
                TextView textView = !shouldLayout ? this.mTitleTextView : this.mSubtitleTextView;
                TextView textView2 = !shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView;
                LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
                LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
                if ((shouldLayout || this.mTitleTextView.getMeasuredWidth() <= 0) && (!shouldLayout2 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) {
                    i12 = paddingLeft;
                    z2 = false;
                } else {
                    i12 = paddingLeft;
                    z2 = true;
                }
                i18 = this.mGravity & 112;
                i11 = min;
                if (i18 != 48) {
                    i19 = max;
                    i20 = getPaddingTop() + layoutParams3.topMargin + this.mTitleMarginTop;
                } else if (i18 != 80) {
                    int i27 = (((height - paddingTop) - paddingBottom) - i9) / 2;
                    i19 = max;
                    if (i27 < layoutParams3.topMargin + this.mTitleMarginTop) {
                        i27 = layoutParams3.topMargin + this.mTitleMarginTop;
                    } else {
                        int i28 = (((height - paddingBottom) - i9) - i27) - paddingTop;
                        if (i28 < layoutParams3.bottomMargin + this.mTitleMarginBottom) {
                            i27 = Math.max(0, i27 - ((layoutParams4.bottomMargin + this.mTitleMarginBottom) - i28));
                        }
                    }
                    i20 = paddingTop + i27;
                } else {
                    i19 = max;
                    i20 = (((height - paddingBottom) - layoutParams4.bottomMargin) - this.mTitleMarginBottom) - i9;
                }
                if (!z3) {
                    if (z2) {
                        i23 = this.mTitleMarginStart;
                        c = 1;
                    } else {
                        c = 1;
                        i23 = 0;
                    }
                    int i29 = i23 - iArr[c];
                    i7 -= Math.max(0, i29);
                    iArr[c] = Math.max(0, -i29);
                    if (shouldLayout) {
                        int measuredWidth = i7 - this.mTitleTextView.getMeasuredWidth();
                        int measuredHeight = this.mTitleTextView.getMeasuredHeight() + i20;
                        this.mTitleTextView.layout(measuredWidth, i20, i7, measuredHeight);
                        i24 = measuredWidth - this.mTitleMarginEnd;
                        i20 = measuredHeight + ((LayoutParams) this.mTitleTextView.getLayoutParams()).bottomMargin;
                    } else {
                        i24 = i7;
                    }
                    if (shouldLayout2) {
                        LayoutParams layoutParams5 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                        int i30 = i20 + layoutParams5.topMargin;
                        this.mSubtitleTextView.layout(i7 - this.mSubtitleTextView.getMeasuredWidth(), i30, i7, this.mSubtitleTextView.getMeasuredHeight() + i30);
                        i25 = i7 - this.mTitleMarginEnd;
                        int i31 = layoutParams5.bottomMargin;
                    } else {
                        i25 = i7;
                    }
                    if (z2) {
                        i7 = Math.min(i24, i25);
                    }
                    max = i19;
                } else {
                    i13 = 0;
                    int i32 = (z2 ? this.mTitleMarginStart : 0) - iArr[0];
                    max = i19 + Math.max(0, i32);
                    iArr[0] = Math.max(0, -i32);
                    if (shouldLayout) {
                        int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + max;
                        int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + i20;
                        this.mTitleTextView.layout(max, i20, measuredWidth2, measuredHeight2);
                        i21 = measuredWidth2 + this.mTitleMarginEnd;
                        i20 = measuredHeight2 + ((LayoutParams) this.mTitleTextView.getLayoutParams()).bottomMargin;
                    } else {
                        i21 = max;
                    }
                    if (shouldLayout2) {
                        LayoutParams layoutParams6 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                        int i33 = i20 + layoutParams6.topMargin;
                        int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                        this.mSubtitleTextView.layout(max, i33, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i33);
                        i22 = measuredWidth3 + this.mTitleMarginEnd;
                        int i34 = layoutParams6.bottomMargin;
                    } else {
                        i22 = max;
                    }
                    if (z2) {
                        max = Math.max(i21, i22);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 3);
                    size = this.mTempViews.size();
                    i14 = max;
                    for (i15 = 0; i15 < size; i15++) {
                        i14 = layoutChildLeft(this.mTempViews.get(i15), i14, iArr, i11);
                    }
                    int i35 = i11;
                    addCustomViewsWithGravity(this.mTempViews, 5);
                    size2 = this.mTempViews.size();
                    for (i16 = 0; i16 < size2; i16++) {
                        i7 = layoutChildRight(this.mTempViews.get(i16), i7, iArr, i35);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 1);
                    int viewListMeasuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
                    i17 = (i12 + (((i10 - i12) - i8) / 2)) - (viewListMeasuredWidth / 2);
                    int i36 = viewListMeasuredWidth + i17;
                    if (i17 >= i14) {
                        i14 = i36 > i7 ? i17 - (i36 - i7) : i17;
                    }
                    size3 = this.mTempViews.size();
                    while (i13 < size3) {
                        i14 = layoutChildLeft(this.mTempViews.get(i13), i14, iArr, i35);
                        i13++;
                    }
                    this.mTempViews.clear();
                    return;
                }
            } else {
                i12 = paddingLeft;
                i11 = min;
            }
            i13 = 0;
            addCustomViewsWithGravity(this.mTempViews, 3);
            size = this.mTempViews.size();
            i14 = max;
            while (i15 < size) {
            }
            int i352 = i11;
            addCustomViewsWithGravity(this.mTempViews, 5);
            size2 = this.mTempViews.size();
            while (i16 < size2) {
            }
            addCustomViewsWithGravity(this.mTempViews, 1);
            int viewListMeasuredWidth2 = getViewListMeasuredWidth(this.mTempViews, iArr);
            i17 = (i12 + (((i10 - i12) - i8) / 2)) - (viewListMeasuredWidth2 / 2);
            int i362 = viewListMeasuredWidth2 + i17;
            if (i17 >= i14) {
            }
            size3 = this.mTempViews.size();
            while (i13 < size3) {
            }
            this.mTempViews.clear();
            return;
        } else {
            i6 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, min);
        }
        i5 = i26;
        if (shouldLayout(this.mCollapseButtonView)) {
        }
        if (shouldLayout(this.mMenuView)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i6);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i26 - i5));
        int max2 = Math.max(i6, currentContentInsetLeft2);
        int min22 = Math.min(i5, i26 - currentContentInsetRight2);
        if (shouldLayout(this.mExpandedActionView)) {
        }
        if (shouldLayout(this.mLogoView)) {
        }
        shouldLayout = shouldLayout(this.mTitleTextView);
        shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        if (!shouldLayout) {
        }
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        LayoutParams layoutParams32 = (LayoutParams) textView.getLayoutParams();
        LayoutParams layoutParams42 = (LayoutParams) textView2.getLayoutParams();
        if (shouldLayout) {
        }
        i12 = paddingLeft;
        z2 = false;
        i18 = this.mGravity & 112;
        i11 = min;
        if (i18 != 48) {
        }
        if (!z3) {
        }
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i7 = layoutParams.leftMargin - i4;
            int i8 = layoutParams.rightMargin - i3;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i3 = max4;
            i4 = max3;
        }
        return i6;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int getChildTop(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i2;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (i3 < layoutParams.topMargin) {
            i3 = layoutParams.topMargin;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            if (i4 < layoutParams.bottomMargin) {
                i3 = Math.max(0, i3 - (layoutParams.bottomMargin - i4));
            }
        }
        return paddingTop + i3;
    }

    private int getChildVerticalGravity(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(List<View> list, int i) {
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private int getChildHorizontalGravity(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    private static boolean isCustomView(View view) {
        return ((LayoutParams) view.getLayoutParams()).mViewType == 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    /* access modifiers changed from: package-private */
    public void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).mViewType == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        int mViewType;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        /* access modifiers changed from: package-private */
        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            /* class android.support.v7.widget.Toolbar.SavedState.AnonymousClass1 */

            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void setCallback(MenuPresenter.Callback callback) {
        }

        ExpandedActionViewMenuPresenter() {
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (!(menuBuilder2 == null || (menuItemImpl = this.mCurrentExpandedItem) == null)) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        public void updateMenuView(boolean z) {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                boolean z2 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                toolbar.addView(toolbar.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar2 = Toolbar.this;
            if (parent2 != toolbar2) {
                LayoutParams generateDefaultLayoutParams = toolbar2.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = 8388611 | (Toolbar.this.mButtonGravity & 112);
                generateDefaultLayoutParams.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar3 = Toolbar.this;
                toolbar3.addView(toolbar3.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }
    }
}
