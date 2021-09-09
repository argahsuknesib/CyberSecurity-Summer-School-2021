package O000000o.O000000o.O000000o.O00000oO;

import _m_j.O000000o;
import android.content.Context;
import android.os.Build;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.DialogParams;
import com.hannto.circledialog.params.TitleParams;

public class u extends q {
    public u(Context context, CircleParams circleParams) {
        super(context);
        O000000o o000000o;
        O000000o o000000o2;
        DialogParams dialogParams = circleParams.O00000Oo;
        TitleParams titleParams = circleParams.O00000o0;
        setGravity(titleParams.O00000oo);
        int i = titleParams.O00000oO;
        int i2 = i == 0 ? -1 : i;
        if (circleParams.O00000o == null && circleParams.O0000O0o == null && circleParams.O0000OOo == null && circleParams.O0000Oo0 == null && circleParams.O0000Oo == 0) {
            if (Build.VERSION.SDK_INT >= 16) {
                o000000o2 = new O000000o(i2, dialogParams.O0000OoO);
            } else {
                o000000o = new O000000o(i2, dialogParams.O0000OoO);
                setBackgroundDrawable(o000000o);
                setHeight(titleParams.O00000Oo);
                setTextColor(titleParams.O00000o);
                setTextSize((float) titleParams.O00000o0);
                setText(titleParams.f4345O000000o);
                getPaint().setFakeBoldText(true);
            }
        } else if (Build.VERSION.SDK_INT >= 16) {
            int i3 = dialogParams.O0000OoO;
            o000000o2 = new O000000o(i2, i3, i3, 0, 0);
        } else {
            int i4 = dialogParams.O0000OoO;
            o000000o = new O000000o(i2, i4, i4, 0, 0);
            setBackgroundDrawable(o000000o);
            setHeight(titleParams.O00000Oo);
            setTextColor(titleParams.O00000o);
            setTextSize((float) titleParams.O00000o0);
            setText(titleParams.f4345O000000o);
            getPaint().setFakeBoldText(true);
        }
        setBackground(o000000o2);
        setHeight(titleParams.O00000Oo);
        setTextColor(titleParams.O00000o);
        setTextSize((float) titleParams.O00000o0);
        setText(titleParams.f4345O000000o);
        getPaint().setFakeBoldText(true);
    }
}
