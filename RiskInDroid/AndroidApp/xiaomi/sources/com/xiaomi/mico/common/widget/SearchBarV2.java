package com.xiaomi.mico.common.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.mico.common.util.ImmersionUtil;
import com.xiaomi.mico.common.util.KeyboardUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.smarthome.R;

public class SearchBarV2 extends LinearLayout {
    View mClear;
    EditText mEditor;
    public Listener mListener;

    public interface Listener {
        void onBack();

        void onClear();

        void onSearch(String str);
    }

    public SearchBarV2(Context context) {
        super(context);
    }

    public SearchBarV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mEditor = (EditText) findViewById(R.id.search_bar_editor);
        this.mClear = findViewById(R.id.search_bar_clear);
        findViewById(R.id.search_bar_cancle).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SearchBarV2$d2kCoRHMhmDms1ZWVSGqYVwrzFk */

            public final void onClick(View view) {
                SearchBarV2.this.lambda$onFinishInflate$0$SearchBarV2(view);
            }
        });
        findViewById(R.id.search_bar_clear).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SearchBarV2$2mfwSVvrn5emPkgQQ4znTPRQkkQ */

            public final void onClick(View view) {
                SearchBarV2.this.lambda$onFinishInflate$1$SearchBarV2(view);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            ImmersionUtil.addImmersivePaddingIfNeeded((Activity) getContext(), this);
            this.mEditor.addTextChangedListener(new TextWatcher() {
                /* class com.xiaomi.mico.common.widget.SearchBarV2.AnonymousClass1 */

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (!TextUtils.isEmpty(editable.toString())) {
                        SearchBarV2.this.mClear.setVisibility(0);
                        return;
                    }
                    SearchBarV2.this.mClear.setVisibility(8);
                    if (SearchBarV2.this.mListener != null) {
                        SearchBarV2.this.mListener.onClear();
                    }
                }
            });
            this.mEditor.setText("");
            this.mEditor.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                /* class com.xiaomi.mico.common.widget.SearchBarV2.AnonymousClass2 */

                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3) {
                        return false;
                    }
                    String trim = SearchBarV2.this.mEditor.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        SearchBarV2.this.doSearch(trim);
                        SearchBarV2.this.mEditor.clearFocus();
                        KeyboardUtils.hideKeyboard(SearchBarV2.this.mEditor);
                        return true;
                    }
                    ToastUtil.showToast((int) R.string.common_input_is_empty);
                    return true;
                }
            });
            this.mEditor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.xiaomi.mico.common.widget.SearchBarV2.AnonymousClass3 */

                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        KeyboardUtils.showKeyboard(SearchBarV2.this.mEditor);
                    } else {
                        KeyboardUtils.hideKeyboard(SearchBarV2.this.mEditor);
                    }
                }
            });
            this.mEditor.requestFocus();
        }
    }

    /* renamed from: onClick */
    public void lambda$onFinishInflate$1$SearchBarV2(View view) {
        int id = view.getId();
        if (id == R.id.search_bar_cancle) {
            KeyboardUtils.hideKeyboard(this.mEditor);
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onBack();
            }
        } else if (id == R.id.search_bar_clear) {
            this.mEditor.setText("");
            this.mEditor.requestFocus();
        }
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void search(String str) {
        this.mEditor.setText(str);
        doSearch(str);
    }

    public void clearEditorFocus() {
        if (this.mEditor.hasFocus()) {
            this.mEditor.clearFocus();
            requestFocus();
        }
    }

    public void doSearch(String str) {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onSearch(str);
        }
    }

    public void setHint(String str) {
        this.mEditor.setHint(str);
    }

    public void setHint(int i) {
        this.mEditor.setHint(i);
    }

    public String getHint() {
        return this.mEditor.getHint().toString();
    }
}
