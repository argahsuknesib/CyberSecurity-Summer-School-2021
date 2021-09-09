package androidx.appcompat.view.menu;

import _m_j.OO0OOOO;
import _m_j.OO0o;
import _m_j.OO0o00;
import _m_j.OOOo00;
import _m_j.o000000;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;

public class ActionMenuItemView extends AppCompatTextView implements OO0o00.O000000o, View.OnClickListener, ActionMenuView.O000000o {
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private OOOo00 mForwardingListener;
    private Drawable mIcon;
    OO0OOOO mItemData;
    MenuBuilder.O00000Oo mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    O00000Oo mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public static abstract class O00000Oo {
        public abstract OO0o O000000o();
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setShortcut(boolean z, char c) {
    }

    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843071}, i, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mSavedPaddingLeft = i;
        super.setPadding(i, i2, i3, i4);
    }

    public OO0OOOO getItemData() {
        return this.mItemData;
    }

    public void initialize(OO0OOOO oo0oooo, int i) {
        this.mItemData = oo0oooo;
        setIcon(oo0oooo.getIcon());
        setTitle(oo0oooo.O000000o((OO0o00.O000000o) this));
        setId(oo0oooo.getItemId());
        setVisibility(oo0oooo.isVisible() ? 0 : 8);
        setEnabled(oo0oooo.isEnabled());
        if (oo0oooo.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new O000000o();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OOOo00 oOOo00;
        if (!this.mItemData.hasSubMenu() || (oOOo00 = this.mForwardingListener) == null || !oOOo00.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onClick(View view) {
        MenuBuilder.O00000Oo o00000Oo = this.mItemInvoker;
        if (o00000Oo != null) {
            o00000Oo.O000000o(this.mItemData);
        }
    }

    public void setItemInvoker(MenuBuilder.O00000Oo o00000Oo) {
        this.mItemInvoker = o00000Oo;
    }

    public void setPopupCallback(O00000Oo o00000Oo) {
        this.mPopupCallback = o00000Oo;
    }

    public void setExpandedFormat(boolean z) {
        if (this.mExpandedFormat != z) {
            this.mExpandedFormat = z;
            OO0OOOO oo0oooo = this.mItemData;
            if (oo0oooo != null) {
                oo0oooo.O00000o.onItemActionRequestChanged(oo0oooo);
            }
        }
    }

    private void updateTextButtonVisibility() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null) {
            if (!((this.mItemData.O00000oO & 4) == 4) || (!this.mAllowTextWithIcon && !this.mExpandedFormat)) {
                z = false;
            }
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.mTitle : null);
        CharSequence contentDescription = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.mItemData.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.mItemData.getTitle();
            }
            o000000.O000000o(this, charSequence2);
            return;
        }
        o000000.O000000o(this, tooltipText);
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.mMaxIconSize;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            int i2 = this.mMaxIconSize;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        updateTextButtonVisibility();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        updateTextButtonVisibility();
    }

    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean hasText = hasText();
        if (hasText && (i4 = this.mSavedPaddingLeft) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(size, this.mMinWidth);
        } else {
            i3 = this.mMinWidth;
        }
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
        if (!hasText && this.mIcon != null) {
            super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    class O000000o extends OOOo00 {
        public O000000o() {
            super(ActionMenuItemView.this);
        }

        public final OO0o O000000o() {
            if (ActionMenuItemView.this.mPopupCallback != null) {
                return ActionMenuItemView.this.mPopupCallback.O000000o();
            }
            return null;
        }

        public final boolean O00000Oo() {
            OO0o O000000o2;
            if (ActionMenuItemView.this.mItemInvoker == null || !ActionMenuItemView.this.mItemInvoker.O000000o(ActionMenuItemView.this.mItemData) || (O000000o2 = O000000o()) == null || !O000000o2.O00000o0()) {
                return false;
            }
            return true;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
