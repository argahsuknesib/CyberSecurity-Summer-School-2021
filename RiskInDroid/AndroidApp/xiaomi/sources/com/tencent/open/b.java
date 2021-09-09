package com.tencent.open;

import _m_j.dit;
import _m_j.diz;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

public abstract class b extends Dialog {
    @SuppressLint({"NewApi"})
    protected final WebChromeClient O00000o = new WebChromeClient() {
        /* class com.tencent.open.b.AnonymousClass1 */

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            diz.O00000o0("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            if (Build.VERSION.SDK_INT <= 7) {
                return true;
            }
            b.this.O000000o(consoleMessage == null ? "" : consoleMessage.message());
            return true;
        }

        public void onConsoleMessage(String str, int i, String str2) {
            diz.O00000o0("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i + " of " + str2);
            if (Build.VERSION.SDK_INT == 7) {
                b.this.O000000o(str);
            }
        }
    };
    protected dit O00000o0;

    /* access modifiers changed from: protected */
    public abstract void O000000o(String str);

    public b(Context context) {
        super(context, 16973840);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000o0 = new dit();
    }
}
