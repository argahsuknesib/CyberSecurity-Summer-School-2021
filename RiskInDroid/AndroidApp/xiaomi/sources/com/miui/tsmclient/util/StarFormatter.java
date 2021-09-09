package com.miui.tsmclient.util;

import android.text.Editable;

public class StarFormatter extends Formatter {
    public boolean isValid(String str) {
        return true;
    }

    public boolean isValidCharacter(char c) {
        return '*' != c;
    }

    public void format(Editable editable) {
        if (editable.length() == 2) {
            editable.replace(1, 2, Character.toString('*'));
        } else if (editable.length() > 2) {
            int i = 1;
            while (i < editable.length() - 1) {
                int i2 = i + 1;
                editable.replace(i, i2, Character.toString('*'));
                i = i2;
            }
        }
    }
}
