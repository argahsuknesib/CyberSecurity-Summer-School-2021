package com.xiaomi.smarthome.operation.js_sdk.share;

import android.content.Context;
import android.content.DialogInterface;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class LoadingDialogHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f10523O000000o = false;
    private final Context O00000Oo;
    private XQProgressDialog O00000o0;

    public LoadingDialogHelper(Context context) {
        this.O00000Oo = context;
    }

    public final void O000000o() {
        this.f10523O000000o = false;
        if (this.O00000o0 == null) {
            this.O00000o0 = new XQProgressDialog(this.O00000Oo);
            this.O00000o0.setMessage(this.O00000Oo.getString(R.string.loading));
            this.O00000o0.setCancelable(true);
            this.O00000o0.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.operation.js_sdk.share.$$Lambda$LoadingDialogHelper$qyxjNnAVt2IAbtJRp_HX1bmXCTY */

                public final void onCancel(DialogInterface dialogInterface) {
                    LoadingDialogHelper.this.O000000o(dialogInterface);
                }
            });
        }
        this.O00000o0.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface) {
        this.f10523O000000o = true;
    }

    public final void O00000Oo() {
        XQProgressDialog xQProgressDialog = this.O00000o0;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
        this.f10523O000000o = false;
    }
}
