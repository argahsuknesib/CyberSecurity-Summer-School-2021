package com.miui.tsmclient.util;

import android.text.Editable;
import android.text.TextUtils;

public class CardNumFormatter extends Formatter {
    public void format(Editable editable) {
        clean(editable);
        if (editable.length() > 4) {
            int i = 0;
            int i2 = 0;
            while (i < editable.length()) {
                if (i2 % 4 == 0 && i2 != 0) {
                    editable.insert(i, Character.toString(this.SEPARATOR));
                    i++;
                }
                i++;
                i2++;
            }
        }
    }

    public boolean isValid(String str) {
        char c;
        if (!TextUtils.isEmpty(str) && str.matches("^\\d{14,19}$")) {
            String substring = str.substring(0, str.length() - 1);
            if (!TextUtils.isEmpty(substring) && substring.trim().length() != 0 && substring.matches("\\d+")) {
                char[] charArray = substring.trim().toCharArray();
                int length = charArray.length - 1;
                int i = 0;
                int i2 = 0;
                while (true) {
                    c = '0';
                    if (length < 0) {
                        break;
                    }
                    int i3 = charArray[length] - '0';
                    if (i2 % 2 == 0) {
                        int i4 = i3 * 2;
                        i3 = (i4 % 10) + (i4 / 10);
                    }
                    i += i3;
                    length--;
                    i2++;
                }
                int i5 = i % 10;
                if (i5 != 0) {
                    c = (char) ((10 - i5) + 48);
                }
                if (c == str.charAt(str.length() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
