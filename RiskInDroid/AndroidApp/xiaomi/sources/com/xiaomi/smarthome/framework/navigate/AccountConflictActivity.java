package com.xiaomi.smarthome.framework.navigate;

import _m_j.cub;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gpc;
import _m_j.izb;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class AccountConflictActivity extends CommonActivity {
    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.open_device_account_erro)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.navigate.AccountConflictActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                MijiaLoginManager.O000000o().O000000o(new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.framework.navigate.AccountConflictActivity.AnonymousClass3.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        izb.O000000o(AccountConflictActivity.this.getApplicationContext(), AccountConflictActivity.this.getString(R.string.open_device_logout_error), 1).show();
                        AccountConflictActivity.this.finish();
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher");
                        if (O00000Oo != null) {
                            Intent intent = new Intent(CommonApplication.getAppContext(), O00000Oo);
                            intent.setData(Uri.parse("https://home.mi.com/main/login"));
                            AccountConflictActivity.this.startActivity(intent);
                            AccountConflictActivity.this.finish();
                        }
                    }
                }, "AccountConflictActivity#onCreate");
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.framework.navigate.AccountConflictActivity.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AccountConflictActivity.this.finish();
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.navigate.AccountConflictActivity.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AccountConflictActivity.this.finish();
            }
        }).O00000oo();
    }
}
