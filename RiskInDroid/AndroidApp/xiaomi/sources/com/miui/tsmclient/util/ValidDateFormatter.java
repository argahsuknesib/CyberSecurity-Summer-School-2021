package com.miui.tsmclient.util;

import android.text.Editable;
import android.text.TextUtils;
import java.util.Calendar;

public class ValidDateFormatter extends Formatter {
    public void cover(Editable editable) {
    }

    public boolean isSeparator(char c) {
        return c == '/';
    }

    public void clean(Editable editable) {
        int i = 0;
        while (i < editable.length()) {
            if (!isValidCharacter(editable.charAt(i))) {
                editable.delete(i, i + 1);
            } else if (i != 0 && editable.charAt(i) == '0' && editable.charAt(i - 1) == '0') {
                editable.delete(i, i + 1);
            } else {
                i++;
            }
        }
    }

    public void format(Editable editable) {
        StringBuilder sb = new StringBuilder(clean(editable.toString()));
        if (sb.length() > 4) {
            sb.delete(4, sb.length());
        }
        int i = 0;
        while (true) {
            if (i >= sb.length()) {
                break;
            }
            char charAt = sb.charAt(i);
            boolean z = true;
            if ((i != 0 || charAt <= '1' || charAt > '9') && (i != 1 || charAt <= '2' || sb.charAt(0) <= '0')) {
                z = false;
            }
            if (z) {
                sb.insert(0, "0");
                break;
            }
            i++;
        }
        if (sb.length() > 4) {
            sb.delete(4, sb.length());
        }
        if ((editable.length() != 3 && sb.length() == 2) || (sb.length() > 2 && sb.charAt(2) != '/')) {
            sb.insert(2, "/");
        }
        if (!TextUtils.equals(editable, sb)) {
            editable.replace(0, editable.length(), sb);
        }
    }

    public boolean isValid(String str) {
        return !TextUtils.isEmpty(str) && str.matches("^[01]\\d/?\\d{2}$") && !isExpired(str);
    }

    private boolean isExpired(String str) {
        int length;
        if (TextUtils.isEmpty(str) || (length = str.length()) < 4) {
            return true;
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(length - 2);
        int parseInt = Integer.parseInt(substring);
        int parseInt2 = Integer.parseInt(substring2);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        int i = instance.get(1) % 100;
        int i2 = instance.get(2);
        if (i > parseInt2 || (i == parseInt2 && parseInt < i2)) {
            return true;
        }
        return false;
    }
}
