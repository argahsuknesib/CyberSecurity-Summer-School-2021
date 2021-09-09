package com.xiaomi.smarthome.camera.activity.timelapse;

import android.content.Context;
import android.content.DialogInterface;
import com.xiaomi.smarthome.R;

public abstract class BottomBaseDialog extends CustomBaseDialog {
    public BottomBaseDialog(Context context) {
        super(context, 80);
    }

    public BottomBaseDialog(Context context, int i) {
        super(context, i, 80);
    }

    public BottomBaseDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener, 80);
    }

    public void onAttachedToWindow() {
        showByAnim(R.anim.slide_in_bottom);
    }

    public void dismiss() {
        dismissByAnim(R.anim.slide_out_bottom);
    }
}
