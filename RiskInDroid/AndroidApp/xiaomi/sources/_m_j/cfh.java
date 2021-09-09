package _m_j;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.widget.AlertDialog;
import com.xiaomi.smarthome.R;

public final class cfh {

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public static void O000000o(final Activity activity, final O000000o o000000o) {
        Log.d("WxUtils", "showInstallPromtDialog");
        AlertDialog create = new AlertDialog.Builder(activity).setMessage(activity.getResources().getString(R.string.mibi_paytool_wxpay_not_installed)).setClickable(true).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            /* class _m_j.cfh.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                Log.d("WxUtils", "onCancel");
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O00000Oo();
                }
                dialogInterface.dismiss();
            }
        }).setPositiveButton((int) R.string.mibi_button_confirm, new DialogInterface.OnClickListener() {
            /* class _m_j.cfh.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                Log.d("WxUtils", "onConfirm");
                MarketUtils.openDetailInMarket(activity.getApplicationContext(), "com.tencent.mm");
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
                dialogInterface.dismiss();
            }
        }).create();
        create.setCancelable(false);
        create.show();
    }
}
