package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;

public class EditTextViewWithSingleWatcher extends AppCompatEditText {
    public O000000o mEditListener;
    private TextWatcher mWatcher;

    public interface O000000o {
        boolean O000000o(String str);

        void O00000Oo(String str);
    }

    public EditTextViewWithSingleWatcher(Context context) {
        this(context, null);
    }

    public EditTextViewWithSingleWatcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditTextViewWithSingleWatcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWatcher = new TextWatcher() {
            /* class com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (EditTextViewWithSingleWatcher.this.mEditListener != null && editable != null) {
                    EditTextViewWithSingleWatcher.this.mEditListener.O00000Oo(editable.toString());
                }
            }
        };
        init();
    }

    private void init() {
        setImeOptions(6);
        setInputType(528385);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.xiaomi.smarthome.newui.widget.$$Lambda$EditTextViewWithSingleWatcher$8U9_8UwBSpsHu1xL4aQheMjjiQ */

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return EditTextViewWithSingleWatcher.this.lambda$init$0$EditTextViewWithSingleWatcher(textView, i, keyEvent);
            }
        });
        addTextChangedListener(this.mWatcher);
    }

    public /* synthetic */ boolean lambda$init$0$EditTextViewWithSingleWatcher(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
            return false;
        }
        hideSoftInput();
        O000000o o000000o = this.mEditListener;
        if (o000000o == null) {
            return false;
        }
        o000000o.O000000o(textView.getText().toString());
        return true;
    }

    public void hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void showSoftInput() {
        requestFocus();
        setSelection(getText() == null ? 0 : getText().length());
        post(new Runnable() {
            /* class com.xiaomi.smarthome.newui.widget.$$Lambda$EditTextViewWithSingleWatcher$ecHFkux4H0yXzCVfkU4hNvSrY */

            public final void run() {
                EditTextViewWithSingleWatcher.this.lambda$showSoftInput$1$EditTextViewWithSingleWatcher();
            }
        });
    }

    public /* synthetic */ void lambda$showSoftInput$1$EditTextViewWithSingleWatcher() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher == this.mWatcher) {
            super.addTextChangedListener(textWatcher);
            return;
        }
        throw new IllegalArgumentException("Only one watcher allowed.");
    }

    public void setEditListener(O000000o o000000o) {
        this.mEditListener = o000000o;
    }

    public void removeTextWatcher() {
        removeTextChangedListener(this.mWatcher);
    }

    public void addTextWatcher() {
        removeTextWatcher();
        addTextChangedListener(this.mWatcher);
    }
}
