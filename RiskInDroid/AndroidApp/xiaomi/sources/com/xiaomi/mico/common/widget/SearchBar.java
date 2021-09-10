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
import com.xiaomi.smarthome.R;

public class SearchBar extends LinearLayout {
    View mClear;
    EditText mEditor;
    public Listener mListener;

    public interface Listener {
        void onBack();

        void onClear();

        void onSearch(String str);
    }

    public SearchBar(Context context) {
        super(context);
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mEditor = (EditText) findViewById(R.id.search_bar_editor);
        this.mClear = findViewById(R.id.search_bar_clear);
        findViewById(R.id.search_bar_cancle).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SearchBar$sDJH2iHW5Tr8luGbM9jYBeiLRU */

            public final void onClick(View view) {
                SearchBar.this.lambda$onFinishInflate$0$SearchBar(view);
            }
        });
        findViewById(R.id.search_bar_clear).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SearchBar$kCug7OOoalZ3LdeTAO5dsStf94 */

            public final void onClick(View view) {
                SearchBar.this.lambda$onFinishInflate$1$SearchBar(view);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            ImmersionUtil.addImmersivePaddingIfNeeded((Activity) getContext(), this);
            this.mEditor.addTextChangedListener(new TextWatcher() {
                /* class com.xiaomi.mico.common.widget.SearchBar.AnonymousClass1 */

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (!TextUtils.isEmpty(editable.toString())) {
                        SearchBar.this.mClear.setVisibility(0);
                        return;
                    }
                    SearchBar.this.mClear.setVisibility(8);
                    if (SearchBar.this.mListener != null) {
                        SearchBar.this.mListener.onClear();
                    }
                }
            });
            this.mEditor.setText("");
            this.mEditor.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                /* class com.xiaomi.mico.common.widget.SearchBar.AnonymousClass2 */

                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3) {
                        return false;
                    }
                    SearchBar.this.doSearch(textView.getText().toString());
                    return true;
                }
            });
            this.mEditor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.xiaomi.mico.common.widget.SearchBar.AnonymousClass3 */

                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        KeyboardUtils.showKeyboard(SearchBar.this.mEditor);
                    } else {
                        KeyboardUtils.hideKeyboard(SearchBar.this.mEditor);
                    }
                }
            });
            this.mEditor.requestFocus();
        }
    }

    /* renamed from: onClick */
    public void lambda$onFinishInflate$1$SearchBar(View view) {
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
