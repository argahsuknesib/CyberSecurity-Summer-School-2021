package _m_j;

import O000000o.O000000o.O000000o.O00000oO.o;
import O000000o.O000000o.O000000o.O00000oO.p;
import android.content.Context;
import android.os.Build;
import android.text.InputFilter;
import android.widget.LinearLayout;
import com.hannto.circledialog.params.ButtonParams;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.DialogParams;
import com.hannto.circledialog.params.InputParams;
import com.hannto.circledialog.params.TitleParams;

public final class O0000o0 extends p {

    /* renamed from: O000000o  reason: collision with root package name */
    public o f5253O000000o;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0125  */
    public O0000o0(Context context, CircleParams circleParams) {
        super(context);
        String str;
        int i;
        int[] iArr;
        O000000o o000000o;
        O000000o o000000o2;
        DialogParams dialogParams = circleParams.O00000Oo;
        TitleParams titleParams = circleParams.O00000o0;
        InputParams inputParams = circleParams.O0000Oo0;
        ButtonParams buttonParams = circleParams.O00000oO;
        ButtonParams buttonParams2 = circleParams.O00000oo;
        int i2 = inputParams.O0000Oo;
        int i3 = i2 == 0 ? -1 : i2;
        if (titleParams != null && buttonParams == null && buttonParams2 == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i4 = dialogParams.O0000OoO;
                o000000o2 = new O000000o(i3, 0, 0, i4, i4);
            } else {
                int i5 = dialogParams.O0000OoO;
                o000000o = new O000000o(i3, 0, 0, i5, i5);
                setBackgroundDrawable(o000000o);
                this.f5253O000000o = new o(context);
                this.f5253O000000o.setHint(inputParams.O00000o);
                this.f5253O000000o.setText(inputParams.O0000o0);
                this.f5253O000000o.setPadding(30, 0, 30, 0);
                this.f5253O000000o.setMaxLines(1);
                this.f5253O000000o.setSingleLine();
                str = inputParams.O0000o0;
                if (str != null) {
                }
                this.f5253O000000o.setHintTextColor(inputParams.O00000oO);
                this.f5253O000000o.setTextSize((float) inputParams.O0000OoO);
                this.f5253O000000o.setTextColor(inputParams.O0000Ooo);
                this.f5253O000000o.setHeight(inputParams.O00000o0);
                InputFilter inputFilter = inputParams.O0000o00;
                this.f5253O000000o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(inputParams.O0000o0O), inputFilter == null ? new O0000OOo() : inputFilter});
                i = inputParams.O00000oo;
                if (i != 0) {
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                iArr = inputParams.O00000Oo;
                if (iArr != null) {
                }
                addView(this.f5253O000000o, layoutParams);
            }
        } else if (titleParams != null || (buttonParams == null && buttonParams2 == null)) {
            if (titleParams != null || buttonParams != null || buttonParams2 != null) {
                setBackgroundColor(i3);
                this.f5253O000000o = new o(context);
                this.f5253O000000o.setHint(inputParams.O00000o);
                this.f5253O000000o.setText(inputParams.O0000o0);
                this.f5253O000000o.setPadding(30, 0, 30, 0);
                this.f5253O000000o.setMaxLines(1);
                this.f5253O000000o.setSingleLine();
                str = inputParams.O0000o0;
                if (str != null) {
                    this.f5253O000000o.setSelection(str.length());
                }
                this.f5253O000000o.setHintTextColor(inputParams.O00000oO);
                this.f5253O000000o.setTextSize((float) inputParams.O0000OoO);
                this.f5253O000000o.setTextColor(inputParams.O0000Ooo);
                this.f5253O000000o.setHeight(inputParams.O00000o0);
                InputFilter inputFilter2 = inputParams.O0000o00;
                this.f5253O000000o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(inputParams.O0000o0O), inputFilter2 == null ? new O0000OOo() : inputFilter2});
                i = inputParams.O00000oo;
                if (i != 0) {
                    this.f5253O000000o.setBackgroundResource(i);
                } else if (Build.VERSION.SDK_INT >= 16) {
                    this.f5253O000000o.setBackground(new O00000o0(inputParams.O0000O0o, inputParams.O0000OOo, inputParams.O0000Oo0));
                } else {
                    this.f5253O000000o.setBackgroundDrawable(new O00000o0(inputParams.O0000O0o, inputParams.O0000OOo, inputParams.O0000Oo0));
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                iArr = inputParams.O00000Oo;
                if (iArr != null) {
                    layoutParams2.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
                }
                addView(this.f5253O000000o, layoutParams2);
            } else if (Build.VERSION.SDK_INT >= 16) {
                o000000o2 = new O000000o(i3, dialogParams.O0000OoO);
            } else {
                o000000o = new O000000o(i3, dialogParams.O0000OoO);
                setBackgroundDrawable(o000000o);
                this.f5253O000000o = new o(context);
                this.f5253O000000o.setHint(inputParams.O00000o);
                this.f5253O000000o.setText(inputParams.O0000o0);
                this.f5253O000000o.setPadding(30, 0, 30, 0);
                this.f5253O000000o.setMaxLines(1);
                this.f5253O000000o.setSingleLine();
                str = inputParams.O0000o0;
                if (str != null) {
                }
                this.f5253O000000o.setHintTextColor(inputParams.O00000oO);
                this.f5253O000000o.setTextSize((float) inputParams.O0000OoO);
                this.f5253O000000o.setTextColor(inputParams.O0000Ooo);
                this.f5253O000000o.setHeight(inputParams.O00000o0);
                InputFilter inputFilter22 = inputParams.O0000o00;
                this.f5253O000000o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(inputParams.O0000o0O), inputFilter22 == null ? new O0000OOo() : inputFilter22});
                i = inputParams.O00000oo;
                if (i != 0) {
                }
                LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, -2);
                iArr = inputParams.O00000Oo;
                if (iArr != null) {
                }
                addView(this.f5253O000000o, layoutParams22);
            }
        } else if (Build.VERSION.SDK_INT >= 16) {
            int i6 = dialogParams.O0000OoO;
            o000000o2 = new O000000o(i3, i6, i6, 0, 0);
        } else {
            int i7 = dialogParams.O0000OoO;
            o000000o = new O000000o(i3, i7, i7, 0, 0);
            setBackgroundDrawable(o000000o);
            this.f5253O000000o = new o(context);
            this.f5253O000000o.setHint(inputParams.O00000o);
            this.f5253O000000o.setText(inputParams.O0000o0);
            this.f5253O000000o.setPadding(30, 0, 30, 0);
            this.f5253O000000o.setMaxLines(1);
            this.f5253O000000o.setSingleLine();
            str = inputParams.O0000o0;
            if (str != null) {
            }
            this.f5253O000000o.setHintTextColor(inputParams.O00000oO);
            this.f5253O000000o.setTextSize((float) inputParams.O0000OoO);
            this.f5253O000000o.setTextColor(inputParams.O0000Ooo);
            this.f5253O000000o.setHeight(inputParams.O00000o0);
            InputFilter inputFilter222 = inputParams.O0000o00;
            this.f5253O000000o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(inputParams.O0000o0O), inputFilter222 == null ? new O0000OOo() : inputFilter222});
            i = inputParams.O00000oo;
            if (i != 0) {
            }
            LinearLayout.LayoutParams layoutParams222 = new LinearLayout.LayoutParams(-1, -2);
            iArr = inputParams.O00000Oo;
            if (iArr != null) {
            }
            addView(this.f5253O000000o, layoutParams222);
        }
        setBackground(o000000o2);
        this.f5253O000000o = new o(context);
        this.f5253O000000o.setHint(inputParams.O00000o);
        this.f5253O000000o.setText(inputParams.O0000o0);
        this.f5253O000000o.setPadding(30, 0, 30, 0);
        this.f5253O000000o.setMaxLines(1);
        this.f5253O000000o.setSingleLine();
        str = inputParams.O0000o0;
        if (str != null) {
        }
        this.f5253O000000o.setHintTextColor(inputParams.O00000oO);
        this.f5253O000000o.setTextSize((float) inputParams.O0000OoO);
        this.f5253O000000o.setTextColor(inputParams.O0000Ooo);
        this.f5253O000000o.setHeight(inputParams.O00000o0);
        InputFilter inputFilter2222 = inputParams.O0000o00;
        this.f5253O000000o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(inputParams.O0000o0O), inputFilter2222 == null ? new O0000OOo() : inputFilter2222});
        i = inputParams.O00000oo;
        if (i != 0) {
        }
        LinearLayout.LayoutParams layoutParams2222 = new LinearLayout.LayoutParams(-1, -2);
        iArr = inputParams.O00000Oo;
        if (iArr != null) {
        }
        addView(this.f5253O000000o, layoutParams2222);
    }
}
