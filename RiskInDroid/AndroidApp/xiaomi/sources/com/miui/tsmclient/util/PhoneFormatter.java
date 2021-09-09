package com.miui.tsmclient.util;

import android.text.Editable;
import android.text.TextUtils;

public class PhoneFormatter extends Formatter {
    private static int[] PHONE_NUM_SEP = {3, 7};

    public void format(Editable editable) {
        clean(editable);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < editable.length()) {
            int[] iArr = PHONE_NUM_SEP;
            if (i2 < iArr.length && i3 == iArr[i2]) {
                editable.insert(i, Character.toString(this.SEPARATOR));
                i2++;
                i++;
            }
            i++;
            i3++;
        }
    }

    public boolean isValid(String str) {
        return !TextUtils.isEmpty(str) && str.matches("^1\\d{10}$");
    }
}
