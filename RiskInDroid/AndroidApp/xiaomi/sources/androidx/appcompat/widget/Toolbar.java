package androidx.appcompat.widget;

import _m_j.OO0000o;
import _m_j.OO00O;
import _m_j.OO0OOOO;
import _m_j.OO0o000;
import _m_j.OOO00O0;
import _m_j.OOOOO0o;
import _m_j.OOo0;
import _m_j.Oo;
import _m_j.bk;
import _m_j.bn;
import _m_j.cb;
import _m_j.o00;
import _m_j.o0000000;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private OO0o000.O000000o mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private OOo0 mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private O000000o mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.O000000o mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.O00000o mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    O00000Oo mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private o0000000 mWrapper;

    public interface O00000Oo {
        boolean O000000o(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.O00000o() {
            /* class androidx.appcompat.widget.Toolbar.AnonymousClass1 */

            public final boolean O000000o(MenuItem menuItem) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.O000000o(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() {
            /* class androidx.appcompat.widget.Toolbar.AnonymousClass2 */

            public final void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        Oo O000000o2 = Oo.O000000o(getContext(), attributeSet, new int[]{16842927, 16843072, R.attr.buttonGravity, R.attr.collapseContentDescription, R.attr.collapseIcon, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.logo, R.attr.logoDescription, R.attr.maxButtonHeight, R.attr.menu, R.attr.navigationContentDescription, R.attr.navigationIcon, R.attr.popupTheme, R.attr.subtitle, R.attr.subtitleTextAppearance, R.attr.subtitleTextColor, R.attr.title, R.attr.titleMargin, R.attr.titleMarginBottom, R.attr.titleMarginEnd, R.attr.titleMarginStart, R.attr.titleMarginTop, R.attr.titleMargins, R.attr.titleTextAppearance, R.attr.titleTextColor}, i, 0);
        cb.O000000o(this, context, new int[]{16842927, 16843072, R.attr.buttonGravity, R.attr.collapseContentDescription, R.attr.collapseIcon, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.logo, R.attr.logoDescription, R.attr.maxButtonHeight, R.attr.menu, R.attr.navigationContentDescription, R.attr.navigationIcon, R.attr.popupTheme, R.attr.subtitle, R.attr.subtitleTextAppearance, R.attr.subtitleTextColor, R.attr.title, R.attr.titleMargin, R.attr.titleMarginBottom, R.attr.titleMarginEnd, R.attr.titleMarginStart, R.attr.titleMarginTop, R.attr.titleMargins, R.attr.titleTextAppearance, R.attr.titleTextColor}, attributeSet, O000000o2.f12340O000000o, i);
        this.mTitleTextAppearance = O000000o2.O0000O0o(28, 0);
        this.mSubtitleTextAppearance = O000000o2.O0000O0o(19, 0);
        this.mGravity = O000000o2.O00000o0(0, this.mGravity);
        this.mButtonGravity = O000000o2.O00000o0(2, 48);
        int O00000o = O000000o2.O00000o(22, 0);
        O00000o = O000000o2.O0000O0o(27) ? O000000o2.O00000o(27, O00000o) : O00000o;
        this.mTitleMarginBottom = O00000o;
        this.mTitleMarginTop = O00000o;
        this.mTitleMarginEnd = O00000o;
        this.mTitleMarginStart = O00000o;
        int O00000o2 = O000000o2.O00000o(25, -1);
        if (O00000o2 >= 0) {
            this.mTitleMarginStart = O00000o2;
        }
        int O00000o3 = O000000o2.O00000o(24, -1);
        if (O00000o3 >= 0) {
            this.mTitleMarginEnd = O00000o3;
        }
        int O00000o4 = O000000o2.O00000o(26, -1);
        if (O00000o4 >= 0) {
            this.mTitleMarginTop = O00000o4;
        }
        int O00000o5 = O000000o2.O00000o(23, -1);
        if (O00000o5 >= 0) {
            this.mTitleMarginBottom = O00000o5;
        }
        this.mMaxButtonHeight = O000000o2.O00000oO(13, -1);
        int O00000o6 = O000000o2.O00000o(9, Integer.MIN_VALUE);
        int O00000o7 = O000000o2.O00000o(5, Integer.MIN_VALUE);
        int O00000oO = O000000o2.O00000oO(7, 0);
        int O00000oO2 = O000000o2.O00000oO(8, 0);
        ensureContentInsets();
        this.mContentInsets.O00000Oo(O00000oO, O00000oO2);
        if (!(O00000o6 == Integer.MIN_VALUE && O00000o7 == Integer.MIN_VALUE)) {
            this.mContentInsets.O000000o(O00000o6, O00000o7);
        }
        this.mContentInsetStartWithNavigation = O000000o2.O00000o(10, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = O000000o2.O00000o(6, Integer.MIN_VALUE);
        this.mCollapseIcon = O000000o2.O000000o(4);
        this.mCollapseDescription = O000000o2.O00000o0(3);
        CharSequence O00000o0 = O000000o2.O00000o0(21);
        if (!TextUtils.isEmpty(O00000o0)) {
            setTitle(O00000o0);
        }
        CharSequence O00000o02 = O000000o2.O00000o0(18);
        if (!TextUtils.isEmpty(O00000o02)) {
            setSubtitle(O00000o02);
        }
        this.mPopupContext = getContext();
        setPopupTheme(O000000o2.O0000O0o(17, 0));
        Drawable O000000o3 = O000000o2.O000000o(16);
        if (O000000o3 != null) {
            setNavigationIcon(O000000o3);
        }
        CharSequence O00000o03 = O000000o2.O00000o0(15);
        if (!TextUtils.isEmpty(O00000o03)) {
            setNavigationContentDescription(O00000o03);
        }
        Drawable O000000o4 = O000000o2.O000000o(11);
        if (O000000o4 != null) {
            setLogo(O000000o4);
        }
        CharSequence O00000o04 = O000000o2.O00000o0(12);
        if (!TextUtils.isEmpty(O00000o04)) {
            setLogoDescription(O00000o04);
        }
        if (O000000o2.O0000O0o(29)) {
            setTitleTextColor(O000000o2.O00000oO(29));
        }
        if (O000000o2.O0000O0o(20)) {
            setSubtitleTextColor(O000000o2.O00000oO(20));
        }
        if (O000000o2.O0000O0o(14)) {
            inflateMenu(O000000o2.O0000O0o(14, 0));
        }
        O000000o2.f12340O000000o.recycle();
    }

    public void setPopupTheme(int i) {
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
        OOo0 oOo0 = this.mContentInsets;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        if (z != oOo0.O0000O0o) {
            oOo0.O0000O0o = z;
            if (!oOo0.O0000OOo) {
                oOo0.f12338O000000o = oOo0.O00000oO;
                oOo0.O00000Oo = oOo0.O00000oo;
            } else if (z) {
                oOo0.f12338O000000o = oOo0.O00000o != Integer.MIN_VALUE ? oOo0.O00000o : oOo0.O00000oO;
                oOo0.O00000Oo = oOo0.O00000o0 != Integer.MIN_VALUE ? oOo0.O00000o0 : oOo0.O00000oo;
            } else {
                oOo0.f12338O000000o = oOo0.O00000o0 != Integer.MIN_VALUE ? oOo0.O00000o0 : oOo0.O00000oO;
                oOo0.O00000Oo = oOo0.O00000o != Integer.MIN_VALUE ? oOo0.O00000o : oOo0.O00000oo;
            }
        }
    }

    public void setLogo(int i) {
        setLogo(OO0000o.O00000Oo(getContext(), i));
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.O00000Oo;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            if (actionMenuView.O00000o0 != null && actionMenuView.O00000o0.O0000O0o()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[RETURN] */
    public boolean isOverflowMenuShowPending() {
        boolean z;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            if (actionMenuView.O00000o0 != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.O00000o0;
                if (actionMenuPresenter.O0000o0O != null || actionMenuPresenter.O0000O0o()) {
                    z = true;
                    if (!z) {
                        return true;
                    }
                }
            }
            z = false;
            if (!z) {
                return false;
            }
        }
        return false;
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            if (actionMenuView.O00000o0 != null && actionMenuView.O00000o0.O00000o0()) {
                return true;
            }
        }
        return false;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            if (actionMenuView.O00000o0 != null && actionMenuView.O00000o0.O00000o()) {
                return true;
            }
        }
        return false;
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder menuBuilder2 = this.mMenuView.f2693O000000o;
            if (menuBuilder2 != menuBuilder) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    menuBuilder2.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new O000000o();
                }
                actionMenuPresenter.O0000Ooo = true;
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
            actionMenuView.O00000Oo();
        }
    }

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

    public void setLogoDescription(int i) {
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
        O000000o o000000o = this.mExpandedMenuPresenter;
        return (o000000o == null || o000000o.O00000Oo == null) ? false : true;
    }

    public void collapseActionView() {
        OO0OOOO oo0oooo;
        O000000o o000000o = this.mExpandedMenuPresenter;
        if (o000000o == null) {
            oo0oooo = null;
        } else {
            oo0oooo = o000000o.O00000Oo;
        }
        if (oo0oooo != null) {
            oo0oooo.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int i) {
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
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
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

    public void setSubtitle(int i) {
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
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
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

    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mSubtitleTextAppearance = i;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(OO0000o.O00000Oo(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
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

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(OO0000o.O00000Oo(getContext(), i));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.mCollapseIcon);
        }
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.f2693O000000o == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new O000000o();
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
            this.mMenuView.O000000o(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f2633O000000o = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(O00000Oo o00000Oo) {
        this.mOnMenuItemClickListener = o00000Oo;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.O000000o(i, i2);
    }

    public int getContentInsetStart() {
        OOo0 oOo0 = this.mContentInsets;
        if (oOo0 != null) {
            return oOo0.O0000O0o ? oOo0.O00000Oo : oOo0.f12338O000000o;
        }
        return 0;
    }

    public int getContentInsetEnd() {
        OOo0 oOo0 = this.mContentInsets;
        if (oOo0 != null) {
            return oOo0.O0000O0o ? oOo0.f12338O000000o : oOo0.O00000Oo;
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.O00000Oo(i, i2);
    }

    public int getContentInsetLeft() {
        OOo0 oOo0 = this.mContentInsets;
        if (oOo0 != null) {
            return oOo0.f12338O000000o;
        }
        return 0;
    }

    public int getContentInsetRight() {
        OOo0 oOo0 = this.mContentInsets;
        if (oOo0 != null) {
            return oOo0.O00000Oo;
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
        MenuBuilder menuBuilder;
        ActionMenuView actionMenuView = this.mMenuView;
        if ((actionMenuView == null || (menuBuilder = actionMenuView.f2693O000000o) == null || !menuBuilder.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (cb.O0000Oo0(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (cb.O0000Oo0(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f2633O000000o = 8388611 | (this.mButtonGravity & 112);
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
            generateDefaultLayoutParams.f2633O000000o = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.O00000Oo = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() {
                /* class androidx.appcompat.widget.Toolbar.AnonymousClass3 */

                public final void onClick(View view) {
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
        layoutParams.O00000Oo = 1;
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
        O000000o o000000o = this.mExpandedMenuPresenter;
        if (!(o000000o == null || o000000o.O00000Oo == null)) {
            savedState.f2756O000000o = this.mExpandedMenuPresenter.O00000Oo.getItemId();
        }
        savedState.O00000Oo = isOverflowMenuShowing();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            menuBuilder = actionMenuView.f2693O000000o;
        } else {
            menuBuilder = null;
        }
        if (!(savedState.f2756O000000o == 0 || this.mExpandedMenuPresenter == null || menuBuilder == null || (findItem = menuBuilder.findItem(savedState.f2756O000000o)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.O00000Oo) {
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
        int actionMasked = motionEvent.getActionMasked();
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
        int actionMasked = motionEvent.getActionMasked();
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
        if (o00.O000000o(this)) {
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
            i3 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i5 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i4 = Math.max(i4, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i3 = View.combineMeasuredStates(i3, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i5) + 0;
        iArr[c2] = Math.max(0, currentContentInsetStart - i5);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max, i2, 0, this.mMaxButtonHeight);
            i6 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i4 = Math.max(i4, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i3 = View.combineMeasuredStates(i3, this.mMenuView.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c] = Math.max(0, currentContentInsetEnd - i6);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i3 = View.combineMeasuredStates(i3, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i3 = View.combineMeasuredStates(i3, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((LayoutParams) childAt.getLayoutParams()).O00000Oo == 0 && shouldLayout(childAt)) {
                i11 += measureChildCollapseMargins(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
            }
        }
        int i13 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i14 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i7 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i9 = View.combineMeasuredStates(i3, this.mTitleTextView.getMeasuredState());
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
            i9 = View.combineMeasuredStates(i9, this.mSubtitleTextView.getMeasuredState());
        }
        int max3 = Math.max(i10, i7);
        int paddingLeft = i11 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i9);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i9 << 16);
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
        boolean z3 = cb.O0000Oo0(this) == 1;
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
        int O0000o0o = cb.O0000o0o(this);
        int min = O0000o0o >= 0 ? Math.min(O0000o0o, i4 - i2) : 0;
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
        int childVerticalGravity = getChildVerticalGravity(layoutParams.f2633O000000o);
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
        boolean z = cb.O0000Oo0(this) == 1;
        int childCount = getChildCount();
        int O000000o2 = bk.O000000o(i, cb.O0000Oo0(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.O00000Oo == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.f2633O000000o) == O000000o2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.O00000Oo == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.f2633O000000o) == O000000o2) {
                list.add(childAt2);
            }
        }
    }

    private int getChildHorizontalGravity(int i) {
        int O0000Oo0 = cb.O0000Oo0(this);
        int O000000o2 = bk.O000000o(i, O0000Oo0) & 7;
        if (O000000o2 == 1 || O000000o2 == 3 || O000000o2 == 5) {
            return O000000o2;
        }
        return O0000Oo0 == 1 ? 5 : 3;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return bn.O000000o(marginLayoutParams) + bn.O00000Oo(marginLayoutParams);
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
        return new LayoutParams(-2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public OOOOO0o getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new o0000000(this, true);
        }
        return this.mWrapper;
    }

    /* access modifiers changed from: package-private */
    public void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).O00000Oo == 2 || childAt == this.mMenuView)) {
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

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setMenuCallbacks(OO0o000.O000000o o000000o, MenuBuilder.O000000o o000000o2) {
        this.mActionMenuPresenterCallback = o000000o;
        this.mMenuBuilderCallback = o000000o2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.O000000o(o000000o, o000000o2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new OOo0();
        }
    }

    /* access modifiers changed from: package-private */
    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    /* access modifiers changed from: package-private */
    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        int O00000Oo = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i) {
            super(-2, i);
            this.f2633O000000o = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.O00000Oo = layoutParams.O00000Oo;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.appcompat.widget.Toolbar.SavedState.AnonymousClass1 */

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f2756O000000o;
        boolean O00000Oo;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2756O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2756O000000o);
            parcel.writeInt(this.O00000Oo ? 1 : 0);
        }
    }

    class O000000o implements OO0o000 {

        /* renamed from: O000000o  reason: collision with root package name */
        MenuBuilder f2755O000000o;
        OO0OOOO O00000Oo;

        public final boolean flagActionItems() {
            return false;
        }

        public final int getId() {
            return 0;
        }

        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
        }

        public final Parcelable onSaveInstanceState() {
            return null;
        }

        public final boolean onSubMenuSelected(OOO00O0 ooo00o0) {
            return false;
        }

        public final void setCallback(OO0o000.O000000o o000000o) {
        }

        O000000o() {
        }

        public final void initForMenu(Context context, MenuBuilder menuBuilder) {
            OO0OOOO oo0oooo;
            MenuBuilder menuBuilder2 = this.f2755O000000o;
            if (!(menuBuilder2 == null || (oo0oooo = this.O00000Oo) == null)) {
                menuBuilder2.collapseItemActionView(oo0oooo);
            }
            this.f2755O000000o = menuBuilder;
        }

        public final void updateMenuView(boolean z) {
            if (this.O00000Oo != null) {
                MenuBuilder menuBuilder = this.f2755O000000o;
                boolean z2 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f2755O000000o.getItem(i) == this.O00000Oo) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.f2755O000000o, this.O00000Oo);
                }
            }
        }

        public final boolean expandItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = oo0oooo.getActionView();
            this.O00000Oo = oo0oooo;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f2633O000000o = 8388611 | (Toolbar.this.mButtonGravity & 112);
                generateDefaultLayoutParams.O00000Oo = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar4 = Toolbar.this;
                toolbar4.addView(toolbar4.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            oo0oooo.O00000oO(true);
            if (Toolbar.this.mExpandedActionView instanceof OO00O) {
                ((OO00O) Toolbar.this.mExpandedActionView).O000000o();
            }
            return true;
        }

        public final boolean collapseItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
            if (Toolbar.this.mExpandedActionView instanceof OO00O) {
                ((OO00O) Toolbar.this.mExpandedActionView).O00000Oo();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.O00000Oo = null;
            Toolbar.this.requestLayout();
            oo0oooo.O00000oO(false);
            return true;
        }
    }
}
