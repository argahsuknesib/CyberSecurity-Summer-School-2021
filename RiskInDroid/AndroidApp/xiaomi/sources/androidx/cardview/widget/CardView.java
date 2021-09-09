package androidx.cardview.widget;

import _m_j.o0O00o00;
import _m_j.o0O0O00O;
import _m_j.o0O0oo0o;
import _m_j.o0oO0O0o;
import _m_j.o0oO0Ooo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final o0O0oo0o IMPL;
    private final o0oO0O0o mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new o0O00o00();
        } else if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new o0oO0Ooo();
        } else {
            IMPL = new o0O0O00O();
        }
        IMPL.O000000o();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        ColorStateList valueOf;
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new o0oO0O0o() {
            /* class androidx.cardview.widget.CardView.AnonymousClass1 */
            private Drawable O00000Oo;

            public final void O000000o(Drawable drawable) {
                this.O00000Oo = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public final boolean O000000o() {
                return CardView.this.getUseCompatPadding();
            }

            public final boolean O00000Oo() {
                return CardView.this.getPreventCornerOverlap();
            }

            public final void O000000o(int i, int i2, int i3, int i4) {
                CardView.this.mShadowBounds.set(i, i2, i3, i4);
                CardView cardView = CardView.this;
                CardView.super.setPadding(i + cardView.mContentPadding.left, i2 + CardView.this.mContentPadding.top, i3 + CardView.this.mContentPadding.right, i4 + CardView.this.mContentPadding.bottom);
            }

            public final void O000000o(int i, int i2) {
                if (i > CardView.this.mUserSetMinWidth) {
                    CardView.super.setMinimumWidth(i);
                }
                if (i2 > CardView.this.mUserSetMinHeight) {
                    CardView.super.setMinimumHeight(i2);
                }
            }

            public final Drawable O00000o0() {
                return this.O00000Oo;
            }

            public final View O00000o() {
                return CardView.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843071, 16843072, R.attr.cardBackgroundColor, R.attr.cardCornerRadius, R.attr.cardElevation, R.attr.cardMaxElevation, R.attr.cardPreventCornerOverlap, R.attr.cardUseCompatPadding, R.attr.contentPadding, R.attr.contentPaddingBottom, R.attr.contentPaddingLeft, R.attr.contentPaddingRight, R.attr.contentPaddingTop}, i, R.style.CardView);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i2 = getResources().getColor(R.color.cardview_light_background);
            } else {
                i2 = getResources().getColor(R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i2);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(7, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.mContentPadding.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        this.mContentPadding.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        this.mContentPadding.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        this.mContentPadding.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        IMPL.O000000o(this.mCardViewDelegate, context, colorStateList, dimension, dimension2, f);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.O0000O0o(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.O00000oo(this.mCardViewDelegate);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!(IMPL instanceof o0O00o00)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.O00000Oo(this.mCardViewDelegate)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.O00000o0(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        IMPL.O000000o(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.O000000o(this.mCardViewDelegate, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.O0000Oo0(this.mCardViewDelegate);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float f) {
        IMPL.O000000o(this.mCardViewDelegate, f);
    }

    public float getRadius() {
        return IMPL.O00000o(this.mCardViewDelegate);
    }

    public void setCardElevation(float f) {
        IMPL.O00000o0(this.mCardViewDelegate, f);
    }

    public float getCardElevation() {
        return IMPL.O00000oO(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.O00000Oo(this.mCardViewDelegate, f);
    }

    public float getMaxCardElevation() {
        return IMPL.O000000o(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.O0000OOo(this.mCardViewDelegate);
        }
    }
}
