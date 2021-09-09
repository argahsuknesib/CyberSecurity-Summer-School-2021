package _m_j;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

public final class djt extends InputConnectionWrapper {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f14731O000000o = null;
    public static boolean O00000Oo = false;
    public static boolean O00000o0 = false;

    public djt(InputConnection inputConnection) {
        super(inputConnection, false);
    }

    public final boolean setComposingText(CharSequence charSequence, int i) {
        O00000o0 = true;
        f14731O000000o = charSequence.toString();
        diz.O000000o("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }

    public final boolean commitText(CharSequence charSequence, int i) {
        O00000o0 = true;
        f14731O000000o = charSequence.toString();
        diz.O000000o("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            diz.O00000o0("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f14731O000000o = String.valueOf((char) keyEvent.getUnicodeChar());
            O00000o0 = true;
            diz.O00000Oo("openSDK_LOG.CaptureInputConnection", "s: " + f14731O000000o);
        }
        diz.O00000Oo("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f14731O000000o);
        return super.sendKeyEvent(keyEvent);
    }
}
