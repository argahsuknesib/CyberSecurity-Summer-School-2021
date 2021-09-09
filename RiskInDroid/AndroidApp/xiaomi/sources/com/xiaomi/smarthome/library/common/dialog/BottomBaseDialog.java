package com.xiaomi.smarthome.library.common.dialog;

import android.content.Context;
import com.xiaomi.smarthome.R;

public abstract class BottomBaseDialog extends CustomBaseDialog {
    public BottomBaseDialog(Context context) {
        super(context);
    }

    public void onAttachedToWindow() {
        O000000o((int) R.anim.slide_in_bottom);
    }

    public void dismiss() {
        O00000Oo(R.anim.slide_out_bottom);
    }
}
