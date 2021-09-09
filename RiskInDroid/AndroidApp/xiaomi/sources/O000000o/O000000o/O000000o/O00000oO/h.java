package O000000o.O000000o.O000000o.O00000oO;

import _m_j.O000000o;
import android.content.Context;
import android.os.Build;
import com.hannto.circledialog.params.ButtonParams;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.DialogParams;
import com.hannto.circledialog.params.TextParams;
import com.hannto.circledialog.params.TitleParams;

public class h extends q {

    /* renamed from: a  reason: collision with root package name */
    public CircleParams f376a;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    public h(Context context, CircleParams circleParams) {
        super(context);
        int[] iArr;
        O000000o o000000o;
        O000000o o000000o2;
        this.f376a = circleParams;
        DialogParams dialogParams = circleParams.O00000Oo;
        TitleParams titleParams = circleParams.O00000o0;
        TextParams textParams = circleParams.O00000o;
        ButtonParams buttonParams = circleParams.O00000oO;
        ButtonParams buttonParams2 = circleParams.O00000oo;
        setGravity(textParams.O0000O0o);
        int i = textParams.O00000o;
        int i2 = i == 0 ? -1 : i;
        if (titleParams != null && buttonParams == null && buttonParams2 == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i3 = dialogParams.O0000OoO;
                o000000o2 = new O000000o(i2, 0, 0, i3, i3);
            } else {
                int i4 = dialogParams.O0000OoO;
                o000000o = new O000000o(i2, 0, 0, i4, i4);
                setBackgroundDrawable(o000000o);
                setMinHeight(textParams.O00000o0);
                setTextColor(textParams.O00000oO);
                setTextSize((float) textParams.O00000oo);
                setText(textParams.O00000Oo);
                iArr = textParams.f4344O000000o;
                if (iArr != null) {
                }
            }
        } else if (titleParams != null || (buttonParams == null && buttonParams2 == null)) {
            if (titleParams != null || buttonParams != null || buttonParams2 != null) {
                setBackgroundColor(i2);
                setMinHeight(textParams.O00000o0);
                setTextColor(textParams.O00000oO);
                setTextSize((float) textParams.O00000oo);
                setText(textParams.O00000Oo);
                iArr = textParams.f4344O000000o;
                if (iArr != null) {
                    a(iArr[0], iArr[1], iArr[2], iArr[3]);
                    return;
                }
                return;
            } else if (Build.VERSION.SDK_INT >= 16) {
                o000000o2 = new O000000o(i2, dialogParams.O0000OoO);
            } else {
                o000000o = new O000000o(i2, dialogParams.O0000OoO);
                setBackgroundDrawable(o000000o);
                setMinHeight(textParams.O00000o0);
                setTextColor(textParams.O00000oO);
                setTextSize((float) textParams.O00000oo);
                setText(textParams.O00000Oo);
                iArr = textParams.f4344O000000o;
                if (iArr != null) {
                }
            }
        } else if (Build.VERSION.SDK_INT >= 16) {
            int i5 = dialogParams.O0000OoO;
            o000000o2 = new O000000o(i2, i5, i5, 0, 0);
        } else {
            int i6 = dialogParams.O0000OoO;
            o000000o = new O000000o(i2, i6, i6, 0, 0);
            setBackgroundDrawable(o000000o);
            setMinHeight(textParams.O00000o0);
            setTextColor(textParams.O00000oO);
            setTextSize((float) textParams.O00000oo);
            setText(textParams.O00000Oo);
            iArr = textParams.f4344O000000o;
            if (iArr != null) {
            }
        }
        setBackground(o000000o2);
        setMinHeight(textParams.O00000o0);
        setTextColor(textParams.O00000oO);
        setTextSize((float) textParams.O00000oo);
        setText(textParams.O00000Oo);
        iArr = textParams.f4344O000000o;
        if (iArr != null) {
        }
    }
}
