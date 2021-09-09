package com.facebook.react.devsupport;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class DoubleTapReloadRecognizer {
    public boolean mDoRefresh = false;

    public boolean didDoubleTapR(int i, View view) {
        if (i == 46 && !(view instanceof EditText)) {
            if (this.mDoRefresh) {
                this.mDoRefresh = false;
                return true;
            }
            this.mDoRefresh = true;
            new Handler().postDelayed(new Runnable() {
                /* class com.facebook.react.devsupport.DoubleTapReloadRecognizer.AnonymousClass1 */

                public void run() {
                    DoubleTapReloadRecognizer.this.mDoRefresh = false;
                }
            }, 200);
        }
        return false;
    }
}
