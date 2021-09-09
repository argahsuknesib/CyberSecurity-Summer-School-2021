package com.miui.tsmclient.util;

import android.text.Editable;

public class QRCodeFormatter extends Formatter {
    public boolean isValid(String str) {
        return true;
    }

    public void format(Editable editable) {
        if (editable != null) {
            clean(editable);
            for (int i = 4; i < editable.length(); i += 6) {
                editable.insert(i, "  ");
            }
        }
    }
}
