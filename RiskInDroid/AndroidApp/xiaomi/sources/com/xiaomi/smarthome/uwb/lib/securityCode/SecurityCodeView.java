package com.xiaomi.smarthome.uwb.lib.securityCode;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class SecurityCodeView extends RelativeLayout {
    public InputCompleteListener inputCompleteListener;
    public EditText mEditText;
    public StringBuffer mStringBuffer;
    public CursorTextView[] mTextViews;

    public interface InputCompleteListener {
        void afterTextChanged(Editable editable);

        void deleteContent(boolean z);

        void inputComplete();
    }

    public SecurityCodeView(Context context) {
        this(context, null);
    }

    public SecurityCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SecurityCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStringBuffer = new StringBuffer();
        this.mTextViews = new CursorTextView[4];
        View.inflate(context, R.layout.security_code_view, this);
        this.mEditText = (EditText) findViewById(R.id.code_et);
        this.mTextViews[0] = (CursorTextView) findViewById(R.id.item_code_tv1);
        setShowSoftInputOnClick(this.mTextViews[0]);
        this.mTextViews[1] = (CursorTextView) findViewById(R.id.item_code_tv2);
        setShowSoftInputOnClick(this.mTextViews[1]);
        this.mTextViews[2] = (CursorTextView) findViewById(R.id.item_code_tv3);
        setShowSoftInputOnClick(this.mTextViews[2]);
        this.mTextViews[3] = (CursorTextView) findViewById(R.id.item_code_tv4);
        setShowSoftInputOnClick(this.mTextViews[3]);
        this.mEditText.setCursorVisible(false);
        setListener();
    }

    public void setShowSoftInputOnClick(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeView.AnonymousClass1 */

            public void onClick(View view) {
                SecurityCodeView.this.showSoftInput();
            }
        });
    }

    private void setListener() {
        this.mEditText.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeView.AnonymousClass2 */

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus afterTextChanged: " + editable.toString());
                if (!editable.toString().equals("")) {
                    if (SecurityCodeView.this.inputCompleteListener != null) {
                        SecurityCodeView.this.inputCompleteListener.afterTextChanged(editable);
                    }
                    if (SecurityCodeView.this.mStringBuffer.length() > 3) {
                        SecurityCodeView.this.mEditText.setText("");
                        return;
                    }
                    SecurityCodeView.this.mStringBuffer.append((CharSequence) editable);
                    SecurityCodeView.this.mEditText.setText("");
                    if (SecurityCodeView.this.mStringBuffer.length() == 4 && SecurityCodeView.this.inputCompleteListener != null) {
                        SecurityCodeView.this.inputCompleteListener.inputComplete();
                    }
                    String stringBuffer = SecurityCodeView.this.mStringBuffer.toString();
                    for (int i = 0; i < SecurityCodeView.this.mStringBuffer.length(); i++) {
                        SecurityCodeView.this.mTextViews[i].setText(String.valueOf(stringBuffer.charAt(i)));
                    }
                    SecurityCodeView.this.showCursor();
                }
            }
        });
        this.mEditText.setOnKeyListener(new View.OnKeyListener() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeView.AnonymousClass3 */

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                SecurityCodeView.this.onKeyDelete();
                return true;
            }
        });
    }

    public void onKeyDelete() {
        if (this.mStringBuffer.length() > 0) {
            int length = this.mStringBuffer.length();
            this.mStringBuffer.delete(length - 1, length);
            this.mTextViews[this.mStringBuffer.length()].setText("");
            showCursor();
            InputCompleteListener inputCompleteListener2 = this.inputCompleteListener;
            if (inputCompleteListener2 != null) {
                inputCompleteListener2.deleteContent(true);
            }
        }
    }

    public void clearEditText() {
        StringBuffer stringBuffer = this.mStringBuffer;
        int i = 0;
        stringBuffer.delete(0, stringBuffer.length());
        while (true) {
            CursorTextView[] cursorTextViewArr = this.mTextViews;
            if (i < cursorTextViewArr.length) {
                cursorTextViewArr[i].setText("");
                i++;
            } else {
                showCursor();
                return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void setInputCompleteListener(InputCompleteListener inputCompleteListener2) {
        this.inputCompleteListener = inputCompleteListener2;
    }

    public String getEditContent() {
        return this.mStringBuffer.toString();
    }

    public void showSoftInput() {
        this.mEditText.setFocusable(true);
        this.mEditText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.mEditText, 0);
        }
        showCursor();
    }

    public void hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void showCursor() {
        int length = this.mStringBuffer.length();
        CursorTextView[] cursorTextViewArr = this.mTextViews;
        if (length < cursorTextViewArr.length) {
            cursorTextViewArr[this.mStringBuffer.length()].setDrawLine(true);
            int length2 = this.mStringBuffer.length() + 1;
            if (length2 < this.mTextViews.length) {
                while (true) {
                    CursorTextView[] cursorTextViewArr2 = this.mTextViews;
                    if (length2 < cursorTextViewArr2.length) {
                        cursorTextViewArr2[length2].setDrawLine(false);
                        length2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (CursorTextView drawLine : this.mTextViews) {
            drawLine.setDrawLine(false);
        }
    }
}
