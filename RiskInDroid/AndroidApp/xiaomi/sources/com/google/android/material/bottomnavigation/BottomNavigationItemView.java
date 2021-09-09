package com.google.android.material.bottomnavigation;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.ab;
import _m_j.by;
import _m_j.cb;
import _m_j.cl;
import _m_j.cy;
import _m_j.o000000;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.xiaomi.smarthome.R;

public class BottomNavigationItemView extends FrameLayout implements OO0o00.O000000o {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    public ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private OO0OOOO itemData;
    private int itemPosition;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean z, char c) {
    }

    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.google.android.material.bottomnavigation.BottomNavigationItemView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [android.widget.TextView, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itemPosition = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate((int) R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(R.id.icon);
        this.labelGroup = (ViewGroup) findViewById(R.id.labelGroup);
        this.smallLabel = (TextView) findViewById(R.id.smallLabel);
        this.largeLabel = (TextView) findViewById(R.id.largeLabel);
        ViewGroup viewGroup = this.labelGroup;
        viewGroup.setTag(R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        cb.O00000oO((View) this.smallLabel, 2);
        cb.O00000oO((View) this.largeLabel, 2);
        setFocusable(true);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                /* class com.google.android.material.bottomnavigation.BottomNavigationItemView.AnonymousClass1 */

                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (BottomNavigationItemView.this.icon.getVisibility() == 0) {
                        BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                        bottomNavigationItemView.tryUpdateBadgeBounds(bottomNavigationItemView.icon);
                    }
                }
            });
        }
    }

    public void initialize(OO0OOOO oo0oooo, int i) {
        CharSequence charSequence;
        this.itemData = oo0oooo;
        setCheckable(oo0oooo.isCheckable());
        setChecked(oo0oooo.isChecked());
        setEnabled(oo0oooo.isEnabled());
        setIcon(oo0oooo.getIcon());
        setTitle(oo0oooo.getTitle());
        setId(oo0oooo.getItemId());
        if (!TextUtils.isEmpty(oo0oooo.getContentDescription())) {
            setContentDescription(oo0oooo.getContentDescription());
        }
        if (!TextUtils.isEmpty(oo0oooo.getTooltipText())) {
            charSequence = oo0oooo.getTooltipText();
        } else {
            charSequence = oo0oooo.getTitle();
        }
        o000000.O000000o(this, charSequence);
        setVisibility(oo0oooo.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int i) {
        this.itemPosition = i;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setShifting(boolean z) {
        if (this.isShifting != z) {
            this.isShifting = z;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        if (this.labelVisibilityMode != i) {
            this.labelVisibilityMode = i;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    public OO0OOOO getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        OO0OOOO oo0oooo = this.itemData;
        if (oo0oooo == null || TextUtils.isEmpty(oo0oooo.getContentDescription())) {
            setContentDescription(charSequence);
        }
        OO0OOOO oo0oooo2 = this.itemData;
        if (oo0oooo2 != null && !TextUtils.isEmpty(oo0oooo2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        o000000.O000000o(this, charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.largeLabel;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.largeLabel;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.smallLabel;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.smallLabel;
        textView4.setPivotY((float) textView4.getBaseline());
        int i = this.labelVisibilityMode;
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    ViewGroup viewGroup = this.labelGroup;
                    updateViewPaddingBottom(viewGroup, ((Integer) viewGroup.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                    this.largeLabel.setVisibility(0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(4);
                }
                this.smallLabel.setVisibility(4);
            } else if (i == 1) {
                ViewGroup viewGroup2 = this.labelGroup;
                updateViewPaddingBottom(viewGroup2, ((Integer) viewGroup2.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                if (z) {
                    setViewLayoutParams(this.icon, (int) (((float) this.defaultMargin) + this.shiftAmount), 49);
                    setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                    TextView textView5 = this.smallLabel;
                    float f = this.scaleUpFactor;
                    setViewScaleValues(textView5, f, f, 4);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    TextView textView6 = this.largeLabel;
                    float f2 = this.scaleDownFactor;
                    setViewScaleValues(textView6, f2, f2, 4);
                    setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
                }
            } else if (i == 2) {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                this.largeLabel.setVisibility(8);
                this.smallLabel.setVisibility(8);
            }
        } else if (this.isShifting) {
            if (z) {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                ViewGroup viewGroup3 = this.labelGroup;
                updateViewPaddingBottom(viewGroup3, ((Integer) viewGroup3.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                this.largeLabel.setVisibility(0);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(4);
            }
            this.smallLabel.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.labelGroup;
            updateViewPaddingBottom(viewGroup4, ((Integer) viewGroup4.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z) {
                setViewLayoutParams(this.icon, (int) (((float) this.defaultMargin) + this.shiftAmount), 49);
                setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView7 = this.smallLabel;
                float f3 = this.scaleUpFactor;
                setViewScaleValues(textView7, f3, f3, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                TextView textView8 = this.largeLabel;
                float f4 = this.scaleDownFactor;
                setViewScaleValues(textView8, f4, f4, 4);
                setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
        }
        cl O000000o2 = cl.O000000o(accessibilityNodeInfo);
        O000000o2.O00000Oo(cl.O00000o0.O000000o(0, 1, getItemVisiblePosition(), 1, isSelected()));
        if (isSelected()) {
            O000000o2.O0000OOo(false);
            O000000o2.O00000Oo(cl.O000000o.O00000oO);
        }
        O000000o2.O0000O0o(getResources().getString(R.string.item_view_role_description));
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < indexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof BottomNavigationItemView) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private static void setViewLayoutParams(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private static void updateViewPaddingBottom(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.icon.setEnabled(z);
        if (z) {
            cb.O000000o(this, by.O000000o(getContext()));
        } else {
            cb.O000000o(this, (by) null);
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        OO0OOOO oo0oooo = this.itemData;
        if (oo0oooo != null && oo0oooo.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != this.originalIconDrawable) {
            this.originalIconDrawable = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = ab.O00000oo(drawable).mutate();
                this.wrappedIconDrawable = drawable;
                ColorStateList colorStateList = this.iconTint;
                if (colorStateList != null) {
                    ab.O000000o(this.wrappedIconDrawable, colorStateList);
                }
            }
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData != null && (drawable = this.wrappedIconDrawable) != null) {
            ab.O000000o(drawable, this.iconTint);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int i) {
        cy.O000000o(this.smallLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActive(int i) {
        cy.O000000o(this.largeLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    private void calculateTextScaleFactors(float f, float f2) {
        this.shiftAmount = f - f2;
        this.scaleUpFactor = (f2 * 1.0f) / f;
        this.scaleDownFactor = (f * 1.0f) / f2;
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : ContextCompat.O000000o(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        cb.O000000o(this, drawable);
    }

    /* access modifiers changed from: package-private */
    public void setBadge(BadgeDrawable badgeDrawable2) {
        this.badgeDrawable = badgeDrawable2;
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    /* access modifiers changed from: package-private */
    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    public void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryAttachBadgeToAnchor(View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    private FrameLayout getCustomParentForBadge(View view) {
        if (view != this.icon || !BadgeUtils.USE_COMPAT_PARENT) {
            return null;
        }
        return (FrameLayout) this.icon.getParent();
    }
}
