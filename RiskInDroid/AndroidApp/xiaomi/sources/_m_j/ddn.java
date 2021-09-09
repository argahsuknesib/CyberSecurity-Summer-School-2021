package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class ddn extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f14503O000000o;
    public String O00000Oo;
    public String O00000o0;

    public interface O000000o {
        void O000000o();

        void O000000o(String str);
    }

    public final void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (getActivity() != null) {
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.miconnect_input_password_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_wifi_name)).setText(String.format(getContext().getResources().getString(R.string.miconnect_wifi_name), this.O00000Oo));
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.change_password_state);
            final EditText editText = (EditText) inflate.findViewById(R.id.password_input_et);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class _m_j.ddn.AnonymousClass1 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    editText.setInputType(z ? 144 : 129);
                    EditText editText = editText;
                    editText.setSelection(editText.getText().toString().length());
                }
            });
            checkBox.setChecked(true);
            final TextView textView = (TextView) inflate.findViewById(R.id.tv_confirm);
            textView.setEnabled(false);
            ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.ddn.AnonymousClass2 */

                public final void onClick(View view) {
                    if (ddn.this.f14503O000000o != null) {
                        ddn.this.f14503O000000o.O000000o();
                    }
                    ddn.this.dismiss();
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.ddn.AnonymousClass3 */

                public final void onClick(View view) {
                    if (ddn.this.f14503O000000o != null) {
                        ddn.this.f14503O000000o.O000000o(editText.getText().toString());
                    }
                    ddn.this.dismiss();
                }
            });
            if (this.O00000o0 != null) {
                checkBox.setChecked(false);
                editText.setText(this.O00000o0);
                textView.setEnabled(true);
                textView.setTextColor(getResources().getColor(R.color.mj_color_highlight_blue_text_color));
            } else {
                checkBox.setChecked(true);
            }
            editText.addTextChangedListener(new TextWatcher() {
                /* class _m_j.ddn.AnonymousClass4 */

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (ddn.this.getContext() != null) {
                        if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                            textView.setEnabled(false);
                            textView.setTextColor(ddn.this.getResources().getColor(R.color.mj_color_black_30_transparent));
                            return;
                        }
                        textView.setEnabled(true);
                        textView.setTextColor(ddn.this.getResources().getColor(R.color.mj_color_highlight_blue_text_color));
                    }
                }
            });
            builder.setView(inflate);
        }
        AlertDialog create = builder.create();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.mj_color_black_00_transparent);
        }
        return create;
    }
}
