package com.xiaomi.smarthome.nfctag.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class NFCConnectWifiActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new MLAlertDialog.Builder(this).O00000Oo(getResources().getString(R.string.nfc_wlan_not_open)).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCConnectWifiActivity$lIUCYfgR8_Wvcmu2efVsNY774w */

            public final void onClick(DialogInterface dialogInterface, int i) {
                NFCConnectWifiActivity.this.O00000Oo(dialogInterface, i);
            }
        }).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCConnectWifiActivity$TZGJp74Q9lyKUynP47rU0ZLIoUY */

            public final void onClick(DialogInterface dialogInterface, int i) {
                NFCConnectWifiActivity.this.O000000o(dialogInterface, i);
            }
        }).O00000oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
        startActivity(intent);
        dialogInterface.dismiss();
        finish();
    }
}
