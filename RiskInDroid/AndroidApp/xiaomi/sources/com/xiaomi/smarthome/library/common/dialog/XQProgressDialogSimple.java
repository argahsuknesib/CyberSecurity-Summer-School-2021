package com.xiaomi.smarthome.library.common.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class XQProgressDialogSimple extends AlertDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f9116O000000o;
    private CharSequence O00000Oo;
    private Context O00000o0;

    public XQProgressDialogSimple(Context context) {
        this(context, (byte) 0);
    }

    private XQProgressDialogSimple(Context context, byte b) {
        super(context, R.style.XQProgressDialogSimple);
        this.O00000o0 = context;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.xq_progress_dialog_simple, (ViewGroup) null);
        setContentView(inflate);
        this.f9116O000000o = (TextView) inflate.findViewById(R.id.progress_message);
        setCanceledOnTouchOutside(false);
        CharSequence charSequence = this.O00000Oo;
        if (charSequence != null) {
            setMessage(charSequence);
        }
    }

    public void setMessage(CharSequence charSequence) {
        TextView textView = this.f9116O000000o;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.O00000Oo = charSequence;
        }
    }
}
