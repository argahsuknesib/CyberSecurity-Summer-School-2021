package com.xiaomi.smarthome.frame.plugin.runtime.util;

import _m_j.fde;
import _m_j.fdg;
import _m_j.fko;
import _m_j.fsp;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.plugin.runtime.util.CheckUpdateDialogHelper;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import org.json.JSONObject;

public class CheckUpdateDialogHelper {
    public static long INTERVAL_7_DAY = 604800000;
    public static String SP_NAME = "plugin_check_update";

    public static void showUploadDialogIfNeeded(final Activity activity, final DeviceStat deviceStat) {
        if (deviceStat.authFlag != 1) {
            fko.O000000o().O000000o(activity, deviceStat, new fde<JSONObject, fdg>() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.util.CheckUpdateDialogHelper.AnonymousClass1 */

                public final void onFailure(fdg fdg) {
                }

                public final void onSuccess(JSONObject jSONObject) {
                    if (jSONObject == null || activity.isFinishing()) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
                        boolean optBoolean = jSONObject.optBoolean("rec");
                        String optString = jSONObject.optString("curr");
                        String optString2 = jSONObject.optString("latest");
                        String optString3 = jSONObject.optString("description");
                        long currentTimeMillis = System.currentTimeMillis();
                        CheckUpdateDialogHelper.removeFromSp(activity, deviceStat.did, optString);
                        if (currentTimeMillis - CheckUpdateDialogHelper.getLastShow(activity, deviceStat.did, optString2) >= CheckUpdateDialogHelper.INTERVAL_7_DAY && optBoolean && !TextUtils.equals(optString, optString2)) {
                            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
                            if (TextUtils.isEmpty(optString3)) {
                                builder.O00000Oo((int) R.string.check_device_version_title);
                            } else {
                                builder.O000000o((int) R.string.check_device_version_title);
                                builder.O00000Oo(optString3);
                            }
                            builder.O00000Oo((int) R.string.check_device_version_cancel, new DialogInterface.OnClickListener(activity, deviceStat, optString2) {
                                /* class com.xiaomi.smarthome.frame.plugin.runtime.util.$$Lambda$CheckUpdateDialogHelper$1$Sto0GDAfXH_GEI0P5G6ZhXohjsQ */
                                private final /* synthetic */ Activity f$0;
                                private final /* synthetic */ DeviceStat f$1;
                                private final /* synthetic */ String f$2;

                                {
                                    this.f$0 = r1;
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    CheckUpdateDialogHelper.AnonymousClass1.lambda$onSuccess$0(this.f$0, this.f$1, this.f$2, dialogInterface, i);
                                }
                            });
                            builder.O000000o((int) R.string.check_device_version_ok, new DialogInterface.OnClickListener(activity, deviceStat, optString2) {
                                /* class com.xiaomi.smarthome.frame.plugin.runtime.util.$$Lambda$CheckUpdateDialogHelper$1$rw3Vx1TSb5CVYHzh7uQC1MP3k */
                                private final /* synthetic */ Activity f$0;
                                private final /* synthetic */ DeviceStat f$1;
                                private final /* synthetic */ String f$2;

                                {
                                    this.f$0 = r1;
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    CheckUpdateDialogHelper.AnonymousClass1.lambda$onSuccess$1(this.f$0, this.f$1, this.f$2, dialogInterface, i);
                                }
                            });
                            builder.O00000o().show();
                        }
                    }
                }

                static /* synthetic */ void lambda$onSuccess$0(Activity activity, DeviceStat deviceStat, String str, DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    CheckUpdateDialogHelper.saveSp(activity, deviceStat.did, str);
                }

                static /* synthetic */ void lambda$onSuccess$1(Activity activity, DeviceStat deviceStat, String str, DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    fsp.O000000o().O0000Oo.goUpdateActivity(activity, deviceStat);
                    CheckUpdateDialogHelper.saveSp(activity, deviceStat.did, str);
                }
            });
        }
    }

    public static void saveSp(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SP_NAME, 0).edit();
        edit.putLong(str + "_" + str2, System.currentTimeMillis());
        edit.commit();
    }

    public static void removeFromSp(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SP_NAME, 0).edit();
        edit.putLong(str + "_" + str2, 0);
        edit.commit();
    }

    public static long getLastShow(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
        return sharedPreferences.getLong(str + "_" + str2, 0);
    }
}
