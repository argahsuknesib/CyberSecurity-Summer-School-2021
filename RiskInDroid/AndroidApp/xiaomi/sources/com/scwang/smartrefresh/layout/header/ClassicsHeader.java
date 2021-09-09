package com.scwang.smartrefresh.layout.header;

import _m_j.czu;
import _m_j.czx;
import _m_j.dad;
import _m_j.dag;
import _m_j.dao;
import _m_j.ee;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.xiaomi.smarthome.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f5582O000000o;
    public static String O00000Oo;
    public static String O00000o;
    public static String O00000o0;
    public static String O00000oO;
    public static String O00000oo;
    public static String O0000O0o;
    public static String O0000OOo;
    protected Date O0000Oo;
    protected String O0000Oo0;
    protected TextView O0000OoO;
    protected SharedPreferences O0000Ooo;
    protected boolean O0000o0;
    protected DateFormat O0000o00;

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ee supportFragmentManager;
        List<Fragment> O00000oo2;
        this.O0000Oo0 = "LAST_UPDATE_TIME";
        this.O0000o0 = true;
        if (f5582O000000o == null) {
            f5582O000000o = context.getString(R.string.srl_header_pulling);
        }
        if (O00000Oo == null) {
            O00000Oo = context.getString(R.string.srl_header_refreshing);
        }
        if (O00000o0 == null) {
            O00000o0 = context.getString(R.string.srl_header_loading);
        }
        if (O00000o == null) {
            O00000o = context.getString(R.string.srl_header_release);
        }
        if (O00000oO == null) {
            O00000oO = context.getString(R.string.srl_header_finish);
        }
        if (O00000oo == null) {
            O00000oo = context.getString(R.string.srl_header_failed);
        }
        if (O0000O0o == null) {
            O0000O0o = context.getString(R.string.srl_header_update);
        }
        if (O0000OOo == null) {
            O0000OOo = context.getString(R.string.srl_header_secondary);
        }
        this.O0000OoO = new TextView(context);
        this.O0000OoO.setTextColor(-8618884);
        this.O0000o00 = new SimpleDateFormat(O0000O0o, Locale.getDefault());
        ImageView imageView = this.O0000o0o;
        TextView textView = this.O0000OoO;
        ImageView imageView2 = this.O0000o;
        LinearLayout linearLayout = this.O0000oO0;
        dao dao = new dao();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.srlAccentColor, R.attr.srlClassicsSpinnerStyle, R.attr.srlDrawableArrow, R.attr.srlDrawableArrowSize, R.attr.srlDrawableMarginRight, R.attr.srlDrawableProgress, R.attr.srlDrawableProgressSize, R.attr.srlDrawableSize, R.attr.srlEnableLastTime, R.attr.srlFinishDuration, R.attr.srlPrimaryColor, R.attr.srlTextSizeTime, R.attr.srlTextSizeTitle, R.attr.srlTextTimeMarginTop});
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = obtainStyledAttributes.getDimensionPixelSize(13, dao.O00000Oo(0.0f));
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
        this.O0000ooo = obtainStyledAttributes.getInt(9, this.O0000ooo);
        int i2 = 8;
        this.O0000o0 = obtainStyledAttributes.getBoolean(8, this.O0000o0);
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
        if (obtainStyledAttributes.hasValue(12)) {
            this.O0000o0O.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(12, dao.O000000o(16.0f)));
        } else {
            this.O0000o0O.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(11)) {
            this.O0000OoO.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(11, dao.O000000o(12.0f)));
        } else {
            this.O0000OoO.setTextSize(12.0f);
        }
        if (obtainStyledAttributes.hasValue(10)) {
            O00000Oo(obtainStyledAttributes.getColor(10, 0));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            O000000o(obtainStyledAttributes.getColor(0, 0));
        }
        obtainStyledAttributes.recycle();
        textView.setId(4);
        textView.setVisibility(this.O0000o0 ? 0 : i2);
        linearLayout.addView(textView, layoutParams3);
        this.O0000o0O.setText(isInEditMode() ? O00000Oo : f5582O000000o);
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (O00000oo2 = supportFragmentManager.O00000oo()) != null && O00000oo2.size() > 0) {
                O000000o(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.O0000Oo0 += context.getClass().getName();
        this.O0000Ooo = context.getSharedPreferences("ClassicsHeader", 0);
        O000000o(new Date(this.O0000Ooo.getLong(this.O0000Oo0, System.currentTimeMillis())));
    }

    public final int O000000o(czx czx, boolean z) {
        if (z) {
            this.O0000o0O.setText(O00000oO);
            if (this.O0000Oo != null) {
                O000000o(new Date());
            }
        } else {
            this.O0000o0O.setText(O00000oo);
        }
        return super.O000000o(czx, z);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.O0000o0o;
        TextView textView = this.O0000OoO;
        int i = 8;
        switch (refreshState2) {
            case None:
                if (this.O0000o0) {
                    i = 0;
                }
                textView.setVisibility(i);
                break;
            case PullDownToRefresh:
                break;
            case Refreshing:
            case RefreshReleased:
                this.O0000o0O.setText(O00000Oo);
                imageView.setVisibility(8);
                return;
            case ReleaseToRefresh:
                this.O0000o0O.setText(O00000o);
                imageView.animate().rotation(180.0f);
                return;
            case ReleaseToTwoLevel:
                this.O0000o0O.setText(O0000OOo);
                imageView.animate().rotation(0.0f);
                return;
            case Loading:
                imageView.setVisibility(8);
                if (this.O0000o0) {
                    i = 4;
                }
                textView.setVisibility(i);
                this.O0000o0O.setText(O00000o0);
                return;
            default:
                return;
        }
        this.O0000o0O.setText(f5582O000000o);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    private ClassicsHeader O000000o(Date date) {
        this.O0000Oo = date;
        this.O0000OoO.setText(this.O0000o00.format(date));
        if (this.O0000Ooo != null && !isInEditMode()) {
            this.O0000Ooo.edit().putLong(this.O0000Oo0, date.getTime()).apply();
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public ClassicsHeader O000000o(int i) {
        this.O0000OoO.setTextColor((16777215 & i) | -872415232);
        return (ClassicsHeader) super.O000000o(i);
    }
}
