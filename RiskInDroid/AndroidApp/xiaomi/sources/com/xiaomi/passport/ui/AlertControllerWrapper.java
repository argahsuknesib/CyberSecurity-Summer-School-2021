package com.xiaomi.passport.ui;

import _m_j.efq;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import android.view.Window;
import com.xiaomi.passport.ui.internal.AlertController;
import java.util.ArrayList;

public final class AlertControllerWrapper extends AlertController {

    /* renamed from: O000000o  reason: collision with root package name */
    public efq f6212O000000o;

    public AlertControllerWrapper(Context context, DialogInterface dialogInterface, Window window) {
        this.f6212O000000o = new efq(context, dialogInterface, window);
    }

    public final void O000000o(CharSequence charSequence) {
        efq efq = this.f6212O000000o;
        efq.O00000o = charSequence;
        if (efq.O00000oo != null) {
            efq.O00000oo.setText(charSequence);
        }
    }

    public final void O000000o(View view) {
        this.f6212O000000o.O0000OOo = view;
    }

    public final void O00000Oo(CharSequence charSequence) {
        efq efq = this.f6212O000000o;
        efq.O00000oO = charSequence;
        if (efq.O0000O0o != null) {
            efq.O0000O0o.setText(charSequence);
        }
    }

    public final void O00000Oo(View view) {
        this.f6212O000000o.O0000Oo0 = view;
    }

    public final void O000000o(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        efq efq = this.f6212O000000o;
        Message obtainMessage = onClickListener != null ? efq.O0000oOo.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            efq.O0000oO = charSequence;
            efq.O0000oOO = obtainMessage;
        } else if (i == -2) {
            efq.O0000o0o = charSequence;
            efq.O0000o = obtainMessage;
        } else if (i == -1) {
            efq.O0000o00 = charSequence;
            efq.O0000o0 = obtainMessage;
        } else {
            throw new IllegalStateException("Button does not exist");
        }
    }

    public static class AlertParams extends AlertController.AlertParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public DialogInterface.OnClickListener f6213O000000o;
        public DialogInterface.OnDismissListener O00000Oo;
        public ArrayList<O000000o> O00000o;
        public DialogInterface.OnShowListener O00000o0;
        public boolean O00000oO;

        public static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public CharSequence f6214O000000o;
            public int O00000Oo;
            public int O00000o0;
        }

        public AlertParams(Context context) {
            super(context);
        }
    }
}
