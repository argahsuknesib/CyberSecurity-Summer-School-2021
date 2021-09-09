package com.mobikwik.sdk.lib.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class UIFunctions {
    public static void displayAlertDialogWithParams(Context context, String str, String str2, String str3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str2);
        builder.setTitle(str);
        if (str3.equals("FAILURE")) {
            builder.setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                /* class com.mobikwik.sdk.lib.utils.UIFunctions.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        } else {
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                /* class com.mobikwik.sdk.lib.utils.UIFunctions.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.create().show();
    }

    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void showToastLong(Context context, String str) {
        Toast.makeText(context, str, 1).show();
    }
}
