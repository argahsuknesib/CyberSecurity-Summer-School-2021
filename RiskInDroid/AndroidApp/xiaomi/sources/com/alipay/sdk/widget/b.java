package com.alipay.sdk.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.alipay.sdk.util.c;

public class b {
    public static Dialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder a2 = a(context, str, str3, onClickListener, str4, onClickListener2);
        a2.setTitle(str);
        a2.setMessage(str2);
        AlertDialog create = a2.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new DialogInterface.OnKeyListener() {
            /* class com.alipay.sdk.widget.b.AnonymousClass1 */

            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
        try {
            create.show();
        } catch (Throwable th) {
            c.a("mspl", "showDialog ", th);
        }
        return create;
    }

    private static AlertDialog.Builder a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(str3) && onClickListener2 != null) {
            builder.setPositiveButton(str3, onClickListener2);
        }
        if (!TextUtils.isEmpty(str2) && onClickListener != null) {
            builder.setNegativeButton(str2, onClickListener);
        }
        return builder;
    }
}
