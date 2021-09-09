package com.xiaomi.smarthome.device.utils;

import _m_j.gqb;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import java.util.Timer;
import java.util.TimerTask;

public class ClientRemarkInputView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f7297O000000o = null;
    public MLAlertDialog O00000Oo;
    public String O00000o;
    public EditText O00000o0;
    private TextView O00000oO;
    private View O00000oo;
    private CommonFlowGroup O0000O0o;
    private TextView O0000OOo;
    private int O0000Oo = 20;
    private boolean O0000Oo0 = true;

    public interface O000000o {
        void modifyBackName(String str);
    }

    public ClientRemarkInputView(Context context) {
        super(context);
    }

    public ClientRemarkInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.O00000o0 = (EditText) findViewById(R.id.client_remark_input_view_edit);
        this.O00000oO = (TextView) findViewById(R.id.client_remark_input_view_text);
        this.O00000oo = findViewById(R.id.client_remark_input_view_clear);
        this.O0000O0o = (CommonFlowGroup) findViewById(R.id.room_tag);
        this.O0000OOo = (TextView) findViewById(R.id.tv_room_tag);
        this.O00000o0.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.device.utils.ClientRemarkInputView.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                ClientRemarkInputView.this.O000000o();
            }
        });
        this.O00000o0.requestFocus();
        new Timer().schedule(new TimerTask() {
            /* class com.xiaomi.smarthome.device.utils.ClientRemarkInputView.AnonymousClass2 */

            public final void run() {
                ((InputMethodManager) ClientRemarkInputView.this.getContext().getSystemService("input_method")).showSoftInput(ClientRemarkInputView.this.O00000o0, 2);
            }
        }, 200);
        ViewParent parent = this.O00000o0.getParent();
        if (parent instanceof LinearLayout) {
            ((LinearLayout) parent).setSelected(true);
        }
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.utils.ClientRemarkInputView.AnonymousClass3 */

            public final void onClick(View view) {
                ClientRemarkInputView.this.O00000o0.setText((CharSequence) null);
                ClientRemarkInputView.this.O00000o0.setError(null);
            }
        });
    }

    public final void O000000o(O000000o o000000o, MLAlertDialog mLAlertDialog, String str, String str2) {
        this.O00000o = null;
        this.f7297O000000o = o000000o;
        this.O00000Oo = mLAlertDialog;
        this.O0000Oo0 = false;
        String O0000O0o2 = gqb.O0000O0o(str);
        String O0000O0o3 = gqb.O0000O0o(str2);
        this.O00000o0.setText(O0000O0o2);
        this.O00000o0.setSelection(Math.min(O0000O0o2.length(), this.O00000o0.length()));
        this.O00000o0.setHint(O0000O0o3);
        O000000o();
    }

    public final void O000000o(O000000o o000000o, MLAlertDialog mLAlertDialog, String str) {
        this.O00000o = str;
        this.f7297O000000o = o000000o;
        this.O00000Oo = mLAlertDialog;
        String O0000O0o2 = gqb.O0000O0o(this.O00000o);
        if (O0000O0o2.length() > 40) {
            O0000O0o2 = O0000O0o2.substring(0, 40);
        }
        this.O00000o0.setText(O0000O0o2);
        this.O00000o0.setSelection(Math.min(O0000O0o2.length(), this.O00000o0.length()));
        this.O00000o0.setHint(O0000O0o2);
        O000000o();
    }

    public void setHint(String str) {
        this.O00000o0.setHint(gqb.O0000O0o(str));
    }

    public void setInputText(String str) {
        String O0000O0o2 = gqb.O0000O0o(str);
        this.O00000o0.setText(O0000O0o2);
        try {
            this.O00000o0.setSelection(Math.min(O0000O0o2.length(), this.O00000o0.length()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O000000o() {
        if (this.O0000Oo0) {
            Button button = null;
            MLAlertDialog mLAlertDialog = this.O00000Oo;
            if (mLAlertDialog != null) {
                button = mLAlertDialog.getButton(-1);
            }
            if (button != null) {
                String obj = this.O00000o0.getText().toString();
                if (TextUtils.isEmpty(obj) || gqb.O000000o((CharSequence) obj) > this.O0000Oo * 2) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        }
    }

    public EditText getEditText() {
        return this.O00000o0;
    }

    public CommonFlowGroup getCommonFlowGroup() {
        return this.O0000O0o;
    }

    public TextView getTitleRoomRecommend() {
        return this.O0000OOo;
    }

    public String getInputText() {
        return gqb.O0000O0o(this.O00000o0.getText().toString());
    }

    public final void O000000o(DialogInterface dialogInterface) {
        if (this.f7297O000000o != null) {
            String obj = this.O00000o0.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                this.O00000o0.setError(getContext().getString(R.string.back_name_less_limit_not_null));
            } else if (obj.length() > 40) {
                this.O00000o0.setError(getContext().getString(R.string.room_name_too_long));
            } else {
                if (dialogInterface != null && (dialogInterface instanceof MLAlertDialog)) {
                    ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                }
                this.f7297O000000o.modifyBackName(obj);
            }
        }
    }

    public void setAlertText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.O00000oO.setVisibility(8);
            return;
        }
        this.O00000oO.setText(str);
        this.O00000oO.setVisibility(0);
    }

    public void setNeedVerifyConfirm(boolean z) {
        this.O0000Oo0 = z;
    }

    public void setLimitSize(int i) {
        this.O0000Oo = i;
    }
}
