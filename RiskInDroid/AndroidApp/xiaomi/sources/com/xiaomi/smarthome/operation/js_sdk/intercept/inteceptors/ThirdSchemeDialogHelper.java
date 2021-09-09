package com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors;

import android.content.Context;
import android.content.DialogInterface;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class ThirdSchemeDialogHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f10517O000000o;
    private MLAlertDialog O00000Oo;

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
    }

    public ThirdSchemeDialogHelper(Context context) {
        this.f10517O000000o = context;
    }

    public final void O000000o(Runnable runnable) {
        MLAlertDialog mLAlertDialog = this.O00000Oo;
        if (mLAlertDialog != null) {
            mLAlertDialog.dismiss();
        }
        this.O00000Oo = new MLAlertDialog.Builder(this.f10517O000000o).O00000Oo((int) R.string.requset_open_third_app).O000000o(true).O00000Oo((int) R.string.sh_common_lib_cancel, $$Lambda$ThirdSchemeDialogHelper$2_c4K4ta4ULENyzlr6zXVmgbDM.INSTANCE).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(runnable) {
            /* class com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.$$Lambda$ThirdSchemeDialogHelper$iFiiKCUm9J1VCgxnP1dbkOBHOJ4 */
            private final /* synthetic */ Runnable f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.run();
            }
        }).O00000o();
        this.O00000Oo.show();
    }

    public final void O000000o() {
        MLAlertDialog mLAlertDialog = this.O00000Oo;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000Oo.dismiss();
        }
    }

    public final boolean O00000Oo() {
        MLAlertDialog mLAlertDialog = this.O00000Oo;
        return mLAlertDialog != null && mLAlertDialog.isShowing();
    }
}
