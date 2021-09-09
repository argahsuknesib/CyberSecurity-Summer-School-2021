package com.xiaomi.mico.common.util;

import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.smarthome.application.CommonApplication;

public class ToastUtil {
    private static Toast sToast;

    public static void showToastDebug(CharSequence charSequence) {
    }

    public static void showToast(int i) {
        showToast(CommonApplication.getAppContext().getString(i));
    }

    public static void showToast(CharSequence charSequence) {
        showToast(charSequence, 0);
    }

    public static void showToast(int i, int i2) {
        showToast(CommonApplication.getAppContext().getString(i), i2);
    }

    public static void showToast(CharSequence charSequence, int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            Toast toast = sToast;
            if (toast != null) {
                toast.cancel();
                sToast = null;
            }
            Toast makeText = Toast.makeText(CommonApplication.getAppContext(), charSequence, i);
            sToast = makeText;
            makeText.setText(charSequence);
            sToast.setDuration(i);
            sToast.show();
        }
    }
}
