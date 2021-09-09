package com.tencent.open.b;

import _m_j.diz;
import _m_j.djs;
import _m_j.djt;
import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class c extends b {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f5875O000000o;
    private KeyEvent O00000Oo;
    private djt O00000o0;

    public c(Context context) {
        super(context);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        diz.O00000Oo("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f5875O000000o);
        if (!f5875O000000o) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 67) {
            djt.O00000Oo = true;
            return super.dispatchKeyEvent(keyEvent);
        } else if (keyEvent.getUnicodeChar() == 0) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (!djs.f14730O000000o || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.dispatchKeyEvent(keyEvent);
            }
            this.O00000Oo = new KeyEvent(0, 17);
            return super.dispatchKeyEvent(this.O00000Oo);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        diz.O00000Oo("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f5875O000000o);
        if (!f5875O000000o) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyCode == 66) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyCode == 67) {
            djt.O00000Oo = true;
            return super.onKeyDown(i, keyEvent);
        } else if (keyEvent.getUnicodeChar() == 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (!djs.f14730O000000o || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.onKeyDown(i, keyEvent);
            }
            this.O00000Oo = new KeyEvent(0, 17);
            return super.onKeyDown(this.O00000Oo.getKeyCode(), this.O00000Oo);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        diz.O00000o0("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + djs.f14730O000000o);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        diz.O000000o("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is ".concat(String.valueOf(onCreateInputConnection)));
        if (onCreateInputConnection != null) {
            f5875O000000o = true;
            this.O00000o0 = new djt(super.onCreateInputConnection(editorInfo));
            return this.O00000o0;
        }
        f5875O000000o = false;
        return onCreateInputConnection;
    }
}
