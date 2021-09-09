package _m_j;

import android.os.Build;
import android.view.View;

public final class o000000 {
    public static void O000000o(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            o00000.O000000o(view, charSequence);
        }
    }
}
