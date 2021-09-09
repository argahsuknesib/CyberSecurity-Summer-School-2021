package com.xiaomi.mico.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class GPSUtil {
    public static void checkGpsEnabled(final Context context) {
        if (!((LocationManager) context.getSystemService("location")).isProviderEnabled("network")) {
            new MLAlertDialog.Builder(context).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.bind_gps_not_enable).O00000Oo((int) R.string.common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.common.util.GPSUtil.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).O000000o((int) R.string.common_goto_settting, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.common.util.GPSUtil.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    dialogInterface.dismiss();
                    Context context = context;
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            }).O00000o().show();
        }
    }
}
