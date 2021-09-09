package com.miui.tsmclient.util;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class Formatter {
    protected char SEPARATOR = ' ';
    protected EditText mEditText;
    private TextWatcher mFormattingTextWatcher = new FormattingTextWatcher();

    public abstract void format(Editable editable);

    public abstract boolean isValid(String str);

    class FormattingTextWatcher implements TextWatcher {
        private int mDeletedIndex;
        private boolean mDeletedIsSeparator;
        private boolean mStopFormatting = false;

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        FormattingTextWatcher() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.mStopFormatting && i2 > 0 && hasSeparator(charSequence, i, i2)) {
                this.mDeletedIsSeparator = true;
                this.mDeletedIndex = i;
            }
        }

        public void afterTextChanged(Editable editable) {
            if (this.mDeletedIsSeparator) {
                this.mDeletedIsSeparator = false;
                Formatter.this.mEditText.getEditableText().insert(this.mDeletedIndex, Character.toString(Formatter.this.getSeparator()));
                Formatter.this.mEditText.setSelection(this.mDeletedIndex);
            } else if (!this.mStopFormatting) {
                this.mStopFormatting = true;
                Formatter.this.format(editable);
                this.mStopFormatting = false;
            }
        }

        private boolean hasSeparator(CharSequence charSequence, int i, int i2) {
            for (int i3 = i; i3 < i + i2; i3++) {
                if (Formatter.this.isSeparator(charSequence.charAt(i3))) {
                    return true;
                }
            }
            return false;
        }
    }

    public char getSeparator() {
        return this.SEPARATOR;
    }

    public boolean isSeparator(char c) {
        return this.SEPARATOR == c;
    }

    public boolean isValidCharacter(char c) {
        return Character.isDigit(c);
    }

    public String format(String str) {
        if (str == null) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        format(spannableStringBuilder);
        return spannableStringBuilder.toString();
    }

    public String clean(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        clean(spannableStringBuilder);
        return spannableStringBuilder.toString();
    }

    /* access modifiers changed from: protected */
    public void clean(Editable editable) {
        int i = 0;
        while (i < editable.length()) {
            if (!isValidCharacter(editable.charAt(i))) {
                editable.delete(i, i + 1);
            } else {
                i++;
            }
        }
    }

    public String cover(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        cover(spannableStringBuilder);
        return spannableStringBuilder.toString();
    }

    /* access modifiers changed from: protected */
    public void cover(Editable editable) {
        format(editable);
        int i = 0;
        for (int length = editable.length() - 1; length >= 0; length--) {
            if (!isSeparator(editable.charAt(length)) && (i = i + 1) > 4) {
                editable.replace(length, length + 1, "*");
            }
        }
    }

    public void bindFormattingTextWatcher(EditText editText) {
        this.mEditText = editText;
        this.mEditText.removeTextChangedListener(this.mFormattingTextWatcher);
        this.mEditText.addTextChangedListener(this.mFormattingTextWatcher);
    }
}
