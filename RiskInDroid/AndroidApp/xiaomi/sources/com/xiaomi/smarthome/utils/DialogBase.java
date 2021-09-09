package com.xiaomi.smarthome.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogBase extends Dialog {
    private boolean mCancelable = true;

    public DialogBase(Context context) {
        super(context);
    }

    public DialogBase(Context context, int i) {
        super(context, i);
    }

    protected DialogBase(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mCancelable = z;
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.mCancelable = z;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }
}
