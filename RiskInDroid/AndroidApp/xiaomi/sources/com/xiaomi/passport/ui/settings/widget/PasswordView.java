package com.xiaomi.passport.ui.settings.widget;

import _m_j.eis;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;

public class PasswordView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public EditText f6323O000000o;
    ImageView O00000Oo;
    private boolean O00000o;
    boolean O00000o0;

    public PasswordView(Context context) {
        super(context);
        O000000o(context, null);
    }

    public PasswordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.checkPasswordRule, R.attr.passwordHint, R.attr.provision});
        obtainStyledAttributes.getBoolean(2, false);
        String string = obtainStyledAttributes.getString(1);
        this.O00000o = obtainStyledAttributes.getBoolean(0, false);
        O000000o(context, string);
        obtainStyledAttributes.recycle();
    }

    private void O000000o(Context context, String str) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.passport_password, this);
        this.f6323O000000o = (EditText) inflate.findViewById(R$id.input_pwd_view);
        if (!TextUtils.isEmpty(str)) {
            this.f6323O000000o.setHint(str);
        }
        this.f6323O000000o.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.xiaomi.passport.ui.settings.widget.PasswordView.AnonymousClass1 */

            public final void onFocusChange(View view, boolean z) {
                PasswordView.this.f6323O000000o.setError(null);
            }
        });
        this.O00000Oo = (ImageView) inflate.findViewById(R$id.show_pwd_img);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.passport.ui.settings.widget.PasswordView.AnonymousClass2 */

            public final void onClick(View view) {
                PasswordView passwordView = PasswordView.this;
                passwordView.O00000o0 = !passwordView.O00000o0;
                if (passwordView.f6323O000000o != null && passwordView.O00000Oo != null) {
                    passwordView.f6323O000000o.setInputType(eis.O000000o(passwordView.O00000o0));
                    passwordView.f6323O000000o.setTypeface(Typeface.DEFAULT);
                    passwordView.f6323O000000o.setSelection(passwordView.f6323O000000o.getText().length());
                    passwordView.O00000Oo.setImageResource(passwordView.O00000o0 ? R.drawable.passport_password_show : R.drawable.passport_password_not_show);
                }
            }
        });
    }

    public String getPassword() {
        int length;
        EditText editText = this.f6323O000000o;
        if (editText == null) {
            return null;
        }
        String obj = editText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.f6323O000000o.requestFocus();
            this.f6323O000000o.setError(getContext().getString(R.string.passport_error_empty_pwd));
            return null;
        }
        if (this.O00000o) {
            boolean z = false;
            if (obj != null && (length = obj.length()) >= 8 && length <= 16) {
                int i = 0;
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    if (i < length) {
                        char charAt = obj.charAt(i);
                        if (charAt < ' ' || charAt > '~') {
                            break;
                        }
                        if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                            z2 = true;
                        } else if (charAt < '0' || charAt > '9') {
                            z4 = true;
                        } else {
                            z3 = true;
                        }
                        i++;
                    } else if ((z2 && z3) || ((z2 && z4) || (z3 && z4))) {
                        z = true;
                    }
                }
            }
            if (!z) {
                this.f6323O000000o.requestFocus();
                this.f6323O000000o.setError(getContext().getString(R.string.passport_error_illegal_pwd));
                return null;
            }
        }
        return obj;
    }

    public void setPassword(CharSequence charSequence) {
        if (this.f6323O000000o != null && !TextUtils.isEmpty(charSequence)) {
            this.f6323O000000o.setText(charSequence);
            this.f6323O000000o.setSelection(charSequence.length());
        }
    }

    public void setError(CharSequence charSequence) {
        EditText editText = this.f6323O000000o;
        if (editText != null) {
            editText.setError(charSequence);
        }
    }

    public final void O000000o(TextWatcher textWatcher) {
        EditText editText = this.f6323O000000o;
        if (editText != null) {
            editText.addTextChangedListener(textWatcher);
        }
    }
}
