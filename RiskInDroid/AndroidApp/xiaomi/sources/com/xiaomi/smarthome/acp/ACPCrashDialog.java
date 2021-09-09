package com.xiaomi.smarthome.acp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class ACPCrashDialog extends FragmentActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.app_name).O00000Oo(getString(R.string.open_tips)).O00000Oo((int) R.string.sh_common_lib_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.acp.ACPCrashDialog.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ACPCrashDialog.this.finish();
            }
        }).O000000o("ok", new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.acp.ACPCrashDialog.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(ACPCrashDialog.this.getApplicationContext(), ACPService.class);
                intent.setAction("acp_action");
                intent.putExtra("acp_repeated_crash", 2);
                ACPCrashDialog.this.startService(intent);
                ACPCrashDialog.this.finish();
            }
        }).O00000o().show();
    }
}
