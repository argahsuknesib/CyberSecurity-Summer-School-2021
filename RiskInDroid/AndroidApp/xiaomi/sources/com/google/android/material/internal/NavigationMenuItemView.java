package com.google.android.material.internal;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.ab;
import _m_j.bh;
import _m_j.cb;
import _m_j.cl;
import _m_j.cy;
import _m_j.m;
import _m_j.o000000;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.xiaomi.smarthome.R;

public class NavigationMenuItemView extends ForegroundLinearLayout implements OO0o00.O000000o {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private final bh accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    private OO0OOOO itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean z, char c) {
    }

    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.google.android.material.internal.NavigationMenuItemView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.accessibilityDelegate = new bh() {
            /* class com.google.android.material.internal.NavigationMenuItemView.AnonymousClass1 */

            public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
                super.onInitializeAccessibilityNodeInfo(view, clVar);
                clVar.O000000o(NavigationMenuItemView.this.checkable);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate((int) R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        this.textView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.textView.setDuplicateParentStateEnabled(true);
        cb.O000000o(this.textView, this.accessibilityDelegate);
    }

    public void initialize(OO0OOOO oo0oooo, int i) {
        this.itemData = oo0oooo;
        if (oo0oooo.getItemId() > 0) {
            setId(oo0oooo.getItemId());
        }
        setVisibility(oo0oooo.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            cb.O000000o(this, createDefaultBackground());
        }
        setCheckable(oo0oooo.isCheckable());
        setChecked(oo0oooo.isChecked());
        setEnabled(oo0oooo.isEnabled());
        setTitle(oo0oooo.getTitle());
        setIcon(oo0oooo.getIcon());
        setActionView(oo0oooo.getActionView());
        setContentDescription(oo0oooo.getContentDescription());
        o000000.O000000o(this, oo0oooo.getTooltipText());
        adjustAppearance();
    }

    private boolean shouldExpandActionArea() {
        return this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null;
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea()) {
            this.textView.setVisibility(8);
            FrameLayout frameLayout = this.actionArea;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.width = -1;
                this.actionArea.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.textView.setVisibility(0);
        FrameLayout frameLayout2 = this.actionArea;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            layoutParams2.width = -2;
            this.actionArea.setLayoutParams(layoutParams2);
        }
    }

    public void recycle() {
        FrameLayout frameLayout = this.actionArea;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(view);
        }
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public OO0OOOO getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.checkable != z) {
            this.checkable = z;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.textView.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.hasIconTintList) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = ab.O00000oo(drawable).mutate();
                ab.O000000o(drawable, this.iconTintList);
            }
            int i = this.iconSize;
            drawable.setBounds(0, 0, i, i);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                this.emptyDrawable = m.O000000o(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.emptyDrawable;
                if (drawable2 != null) {
                    int i2 = this.iconSize;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.emptyDrawable;
        }
        cy.O000000o(this.textView, drawable, null, null, null);
    }

    public void setIconSize(int i) {
        this.iconSize = i;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        OO0OOOO oo0oooo = this.itemData;
        if (oo0oooo != null && oo0oooo.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.hasIconTintList = this.iconTintList != null;
        OO0OOOO oo0oooo = this.itemData;
        if (oo0oooo != null) {
            setIcon(oo0oooo.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        cy.O000000o(this.textView, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.needsEmptyIcon = z;
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIconPadding(int i) {
        this.textView.setCompoundDrawablePadding(i);
    }

    public void setMaxLines(int i) {
        this.textView.setMaxLines(i);
    }
}
