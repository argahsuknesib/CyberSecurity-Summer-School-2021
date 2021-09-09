package com.xiaomi.smarthome.uwb.lib.securityCode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

@SuppressLint({"AppCompatCustomView"})
public class KeyBackEditText extends EditText {
    public KeyBackEditText(Context context) {
        super(context);
    }

    public KeyBackEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeyBackEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            ((Activity) getContext()).onBackPressed();
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
