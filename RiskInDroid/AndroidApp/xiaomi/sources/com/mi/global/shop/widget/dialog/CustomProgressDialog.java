package com.mi.global.shop.widget.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import com.mi.global.shop.activity.BaseActivity;
import com.xiaomi.smarthome.R;

public class CustomProgressDialog extends ProgressDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f4992O000000o;

    public CustomProgressDialog(Context context) {
        super(context);
        this.f4992O000000o = context;
        setMessage(this.f4992O000000o.getString(R.string.please_wait));
        setIndeterminate(true);
        setCancelable(false);
    }

    public final void O000000o() {
        if (BaseActivity.isActivityAlive(this.f4992O000000o)) {
            show();
        }
    }

    public final void O00000Oo() {
        if (BaseActivity.isActivityAlive(this.f4992O000000o)) {
            dismiss();
        }
    }
}
