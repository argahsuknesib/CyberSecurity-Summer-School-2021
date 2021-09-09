package com.mibi.sdk.common.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.utils.MibiLog;

public class AccountInteractActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = (Intent) getIntent().getParcelableExtra("intent");
        int intExtra = getIntent().getIntExtra("requestCode", 1001);
        if (intent != null) {
            Log.d("AccountInteractAC", "start account throtting intent");
            startActivityForResult(intent, intExtra);
            return;
        }
        Log.d("AccountInteractAC", "intent is null");
        AccountInteractHelper.notifyInteractionResult(false);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder("handle result req : ");
        sb.append(i);
        sb.append(" res : ");
        sb.append(i2);
        sb.append(" ; data is null : ");
        boolean z = true;
        sb.append(intent == null);
        MibiLog.d("AccountInteractAC", sb.toString());
        if (i == 1001) {
            if (i2 != -1) {
                z = false;
            }
            AccountInteractHelper.notifyInteractionResult(z);
        } else {
            AccountInteractHelper.notifyInteractionResult(false);
        }
        finish();
    }

    public static void startActivity(Context context, Intent intent, int i) {
        Intent intent2 = new Intent(context, AccountInteractActivity.class);
        intent2.putExtra("intent", intent);
        intent2.putExtra("requestCode", i);
        intent2.addFlags(268435456);
        context.startActivity(intent2);
    }
}
