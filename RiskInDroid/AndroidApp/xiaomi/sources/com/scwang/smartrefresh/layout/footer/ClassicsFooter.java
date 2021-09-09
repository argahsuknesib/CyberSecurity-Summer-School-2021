package com.scwang.smartrefresh.layout.footer;

import _m_j.czt;
import _m_j.czx;
import _m_j.dad;
import _m_j.dag;
import _m_j.dao;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.xiaomi.smarthome.R;

public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements czt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f5576O000000o;
    public static String O00000Oo;
    public static String O00000o;
    public static String O00000o0;
    public static String O00000oO;
    public static String O00000oo;
    public static String O0000O0o;
    protected boolean O0000OOo;

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OOo = false;
        if (f5576O000000o == null) {
            f5576O000000o = context.getString(R.string.srl_footer_pulling);
        }
        if (O00000Oo == null) {
            O00000Oo = context.getString(R.string.srl_footer_release);
        }
        if (O00000o0 == null) {
            O00000o0 = context.getString(R.string.srl_footer_loading);
        }
        if (O00000o == null) {
            O00000o = context.getString(R.string.srl_footer_refreshing);
        }
        if (O00000oO == null) {
            O00000oO = context.getString(R.string.srl_footer_finish);
        }
        if (O00000oo == null) {
            O00000oo = context.getString(R.string.srl_footer_failed);
        }
        if (O0000O0o == null) {
            O0000O0o = context.getString(R.string.srl_footer_nothing);
        }
        ImageView imageView = this.O0000o0o;
        ImageView imageView2 = this.O0000o;
        dao dao = new dao();
        this.O0000o0O.setTextColor(-10066330);
        this.O0000o0O.setText(isInEditMode() ? O00000o0 : f5576O000000o);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.srlAccentColor, R.attr.srlClassicsSpinnerStyle, R.attr.srlDrawableArrow, R.attr.srlDrawableArrowSize, R.attr.srlDrawableMarginRight, R.attr.srlDrawableProgress, R.attr.srlDrawableProgressSize, R.attr.srlDrawableSize, R.attr.srlFinishDuration, R.attr.srlPrimaryColor, R.attr.srlTextSizeTitle});
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(4, dao.O00000Oo(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(3, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(3, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(6, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(6, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(7, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(7, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(7, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(7, layoutParams2.height);
        this.O0000ooo = obtainStyledAttributes.getInt(8, this.O0000ooo);
        this.O000OoOo = SpinnerStyle.values()[obtainStyledAttributes.getInt(1, this.O000OoOo.ordinal())];
        if (obtainStyledAttributes.hasValue(2)) {
            this.O0000o0o.setImageDrawable(obtainStyledAttributes.getDrawable(2));
        } else {
            this.O0000oOO = new dad();
            this.O0000oOO.O00000Oo(-10066330);
            this.O0000o0o.setImageDrawable(this.O0000oOO);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.O0000o.setImageDrawable(obtainStyledAttributes.getDrawable(5));
        } else {
            this.O0000oOo = new dag();
            this.O0000oOo.O00000Oo(-10066330);
            this.O0000o.setImageDrawable(this.O0000oOo);
        }
        if (obtainStyledAttributes.hasValue(10)) {
            this.O0000o0O.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(10, dao.O000000o(16.0f)));
        } else {
            this.O0000o0O.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(9)) {
            O00000Oo(obtainStyledAttributes.getColor(9, 0));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            O000000o(obtainStyledAttributes.getColor(0, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public final void O00000Oo(czx czx, int i, int i2) {
        if (!this.O0000OOo) {
            super.O00000Oo(czx, i, i2);
        }
    }

    public final int O000000o(czx czx, boolean z) {
        if (this.O0000OOo) {
            return 0;
        }
        this.O0000o0O.setText(z ? O00000oO : O00000oo);
        return super.O000000o(czx, z);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.O000OoOo == SpinnerStyle.FixedBehind) {
            super.setPrimaryColors(iArr);
        }
    }

    public final boolean O000000o(boolean z) {
        if (this.O0000OOo == z) {
            return true;
        }
        this.O0000OOo = z;
        ImageView imageView = this.O0000o0o;
        if (z) {
            this.O0000o0O.setText(O0000O0o);
            imageView.setVisibility(8);
            return true;
        }
        this.O0000o0O.setText(f5576O000000o);
        imageView.setVisibility(0);
        return true;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.O0000o0o;
        if (!this.O0000OOo) {
            switch (refreshState2) {
                case None:
                    imageView.setVisibility(0);
                    break;
                case PullUpToLoad:
                    break;
                case Loading:
                case LoadReleased:
                    imageView.setVisibility(8);
                    this.O0000o0O.setText(O00000o0);
                    return;
                case ReleaseToLoad:
                    this.O0000o0O.setText(O00000Oo);
                    imageView.animate().rotation(0.0f);
                    return;
                case Refreshing:
                    this.O0000o0O.setText(O00000o);
                    imageView.setVisibility(8);
                    return;
                default:
                    return;
            }
            this.O0000o0O.setText(f5576O000000o);
            imageView.animate().rotation(180.0f);
        }
    }
}
