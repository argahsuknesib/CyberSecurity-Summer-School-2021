package com.xiaomi.passport.ui.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

public abstract class AlertController {
    public abstract void O000000o(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener);

    public abstract void O000000o(View view);

    public abstract void O000000o(CharSequence charSequence);

    public abstract void O00000Oo(View view);

    public abstract void O00000Oo(CharSequence charSequence);

    public static abstract class AlertParams {
        public Context O00000oo;
        public int O0000O0o = 0;
        public CharSequence O0000OOo;
        public CharSequence O0000Oo;
        public View O0000Oo0;
        public CharSequence O0000OoO;
        public DialogInterface.OnClickListener O0000Ooo;
        public boolean O0000o;
        public DialogInterface.OnClickListener O0000o0;
        public CharSequence O0000o00;
        public CharSequence O0000o0O;
        public DialogInterface.OnClickListener O0000o0o;
        public DialogInterface.OnKeyListener O0000oO;
        public DialogInterface.OnCancelListener O0000oO0;
        public View O0000oOO;
        public int O0000oOo = -1;

        public AlertParams(Context context) {
            this.O00000oo = context;
        }
    }
}
