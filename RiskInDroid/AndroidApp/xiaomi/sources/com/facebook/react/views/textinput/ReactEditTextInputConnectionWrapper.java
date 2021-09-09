package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;

class ReactEditTextInputConnectionWrapper extends InputConnectionWrapper {
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private boolean mIsBatchEdit;
    private String mKey = null;

    public ReactEditTextInputConnectionWrapper(InputConnection inputConnection, ReactContext reactContext, ReactEditText reactEditText) {
        super(inputConnection, false);
        this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.mEditText = reactEditText;
    }

    public boolean beginBatchEdit() {
        this.mIsBatchEdit = true;
        return super.beginBatchEdit();
    }

    public boolean endBatchEdit() {
        this.mIsBatchEdit = false;
        String str = this.mKey;
        if (str != null) {
            dispatchKeyEvent(str);
            this.mKey = null;
        }
        return super.endBatchEdit();
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        int selectionStart = this.mEditText.getSelectionStart();
        int selectionEnd = this.mEditText.getSelectionEnd();
        boolean composingText = super.setComposingText(charSequence, i);
        int selectionStart2 = this.mEditText.getSelectionStart();
        boolean z = false;
        boolean z2 = selectionStart == selectionEnd;
        boolean z3 = selectionStart2 == selectionStart;
        if (selectionStart2 < selectionStart || selectionStart2 <= 0) {
            z = true;
        }
        dispatchKeyEventOrEnqueue((z || (!z2 && z3)) ? "Backspace" : String.valueOf(this.mEditText.getText().charAt(selectionStart2 - 1)));
        return composingText;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= 2) {
            if (charSequence2.equals("")) {
                charSequence2 = "Backspace";
            }
            dispatchKeyEventOrEnqueue(charSequence2);
        }
        return super.commitText(charSequence, i);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        dispatchKeyEvent("Backspace");
        return super.deleteSurroundingText(i, i2);
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 67) {
                dispatchKeyEvent("Backspace");
            } else if (keyEvent.getKeyCode() == 66) {
                dispatchKeyEvent("Enter");
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    private void dispatchKeyEventOrEnqueue(String str) {
        if (this.mIsBatchEdit) {
            this.mKey = str;
        } else {
            dispatchKeyEvent(str);
        }
    }

    private void dispatchKeyEvent(String str) {
        if (str.equals("\n")) {
            str = "Enter";
        }
        this.mEventDispatcher.dispatchEvent(new ReactTextInputKeyPressEvent(this.mEditText.getId(), str));
    }
}
