package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public final class fqr {
    public static MLAlertDialog O000000o(final Context context, final BleResponse bleResponse) {
        if (context == null || !(context instanceof Activity) || gnl.O00000Oo()) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setTextSize(2, 14.0f);
        textView.setGravity(19);
        textView.setText((int) R.string.opening_bluetooth);
        int applyDimension = (int) TypedValue.applyDimension(1, 16.0f, context.getResources().getDisplayMetrics());
        final MLAlertDialog O00000o = new MLAlertDialog.Builder(context).O000000o(textView, applyDimension, applyDimension, applyDimension, applyDimension).O00000o();
        new Handler(Looper.getMainLooper());
        final AnonymousClass1 r1 = new BroadcastReceiver() {
            /* class _m_j.fqr.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                    if (intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 0) != 12 && intExtra == 12) {
                        O00000o.dismiss();
                        try {
                            context.unregisterReceiver(this);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        BleResponse bleResponse = bleResponse;
                        if (bleResponse != null) {
                            bleResponse.onResponse(0, null);
                        }
                    }
                }
            }
        };
        MLAlertDialog O00000o2 = new MLAlertDialog.Builder(context).O00000Oo((int) R.string.open_bluetooth_tips).O00000Oo(true).O00000Oo((int) R.string.sh_common_lib_cancel, new DialogInterface.OnClickListener() {
            /* class _m_j.fqr.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                BleResponse bleResponse = bleResponse;
                if (bleResponse != null) {
                    bleResponse.onResponse(-2, null);
                }
            }
        }).O000000o((int) R.string.open_tips, new DialogInterface.OnClickListener() {
            /* class _m_j.fqr.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                O00000o.show();
                gor.O000000o(new AsyncTask<Object, Object, Boolean>() {
                    /* class _m_j.fqr.AnonymousClass2.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        if (((Boolean) obj).booleanValue()) {
                            context.registerReceiver(r1, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                            return;
                        }
                        O00000o.dismiss();
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return Boolean.valueOf(gnl.O0000O0o());
                    }
                }, new Object[0]);
            }
        }).O00000o();
        O00000o2.show();
        return O00000o2;
    }
}
