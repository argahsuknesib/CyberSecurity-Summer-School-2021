package com.mibi.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.widget.AlertDialog;

public class MarketUtils {

    public interface InstallPromtListener {
        void onCancel();

        void onConfirm();
    }

    public static boolean isAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean openDetailInMarket(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (isAppInstalled(context, "com.xiaomi.market")) {
                intent.setData(Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).appendQueryParameter("back", "true").build());
                intent.setPackage("com.xiaomi.market");
            } else {
                Uri parse = Uri.parse("http://app.mi.com");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(parse.buildUpon().appendQueryParameter("id", str).build());
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                Log.e("MarketUtils", "Utils openDetailInMarket exception ", e);
            }
        }
        return false;
    }

    public static void showInstallPromt(final Context context, String str, final String str2, final InstallPromtListener installPromtListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            /* class com.mibi.sdk.component.MarketUtils.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                MarketUtils.openDetailInMarket(context, str2);
                InstallPromtListener installPromtListener = installPromtListener;
                if (installPromtListener != null) {
                    installPromtListener.onConfirm();
                }
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            /* class com.mibi.sdk.component.MarketUtils.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                InstallPromtListener installPromtListener = installPromtListener;
                if (installPromtListener != null) {
                    installPromtListener.onCancel();
                }
            }
        });
        builder.create().show();
    }
}
