package com.xiaomi.mico.common.util;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyboardUtils {
    public static void showKeyboard(final EditText editText) {
        editText.requestFocus();
        editText.postDelayed(new Runnable() {
            /* class com.xiaomi.mico.common.util.KeyboardUtils.AnonymousClass1 */

            public final void run() {
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 2);
            }
        }, 300);
    }

    public static void hideKeyboard(EditText editText) {
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void hideKeyboard(Context context, IBinder iBinder) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 0);
    }
}
