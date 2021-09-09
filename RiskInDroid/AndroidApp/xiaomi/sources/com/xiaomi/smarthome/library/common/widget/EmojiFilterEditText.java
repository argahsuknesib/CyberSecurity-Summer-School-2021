package com.xiaomi.smarthome.library.common.widget;

import _m_j.gqb;
import _m_j.izb;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;

public class EmojiFilterEditText extends EditText {
    public int cursorPos;
    public String inputAfterText;
    public Context mContext;
    public boolean resetText = false;

    public EmojiFilterEditText(Context context) {
        super(context);
        this.mContext = context;
        initEditTextWatcher();
    }

    public EmojiFilterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initEditTextWatcher();
    }

    public EmojiFilterEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initEditTextWatcher();
    }

    static class O000000o implements TextWatcher {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<EmojiFilterEditText> f9178O000000o;

        public final void afterTextChanged(Editable editable) {
        }

        public O000000o(EmojiFilterEditText emojiFilterEditText) {
            this.f9178O000000o = new WeakReference<>(emojiFilterEditText);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EmojiFilterEditText emojiFilterEditText = this.f9178O000000o.get();
            if (emojiFilterEditText != null && !emojiFilterEditText.resetText) {
                emojiFilterEditText.inputAfterText = charSequence.toString();
                emojiFilterEditText.cursorPos = emojiFilterEditText.getSelectionEnd();
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EmojiFilterEditText emojiFilterEditText = this.f9178O000000o.get();
            if (emojiFilterEditText != null) {
                if (emojiFilterEditText.resetText) {
                    emojiFilterEditText.resetText = false;
                } else if (i3 > 0 && gqb.O00000Oo(charSequence.subSequence(i, i3 + i).toString())) {
                    emojiFilterEditText.resetText = true;
                    izb.O000000o(emojiFilterEditText.mContext, (int) R.string.input_contains_emoji, 0).show();
                    emojiFilterEditText.setText(emojiFilterEditText.inputAfterText);
                    emojiFilterEditText.setSelection(emojiFilterEditText.cursorPos);
                }
            }
        }
    }

    private void initEditTextWatcher() {
        addTextChangedListener(new O000000o(this));
    }
}
