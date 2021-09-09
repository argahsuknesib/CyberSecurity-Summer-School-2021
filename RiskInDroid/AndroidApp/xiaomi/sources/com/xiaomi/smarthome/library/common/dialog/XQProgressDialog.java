package com.xiaomi.smarthome.library.common.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CustomCircleProgressBar;
import java.text.NumberFormat;

public class XQProgressDialog extends MLAlertDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public CustomCircleProgressBar f9113O000000o;
    public TextView O00000Oo;
    int O00000o;
    public NumberFormat O00000o0;
    int O00000oO;
    private Context O00000oo;
    private ProgressBar O0000O0o;
    private TextView O0000OOo;
    private CharSequence O0000Oo;
    private TextView O0000Oo0;
    private String O0000OoO;
    private boolean O0000Ooo;
    private Handler O0000o0;
    private boolean O0000o00;

    public static XQProgressDialog O000000o(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return O000000o(context, charSequence, charSequence2, true, z2, null);
    }

    public static XQProgressDialog O000000o(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        XQProgressDialog xQProgressDialog = new XQProgressDialog(context);
        xQProgressDialog.setTitle(charSequence);
        xQProgressDialog.setMessage(charSequence2);
        xQProgressDialog.O000000o(z);
        xQProgressDialog.setCancelable(z2);
        xQProgressDialog.setOnCancelListener(onCancelListener);
        xQProgressDialog.show();
        return xQProgressDialog;
    }

    public XQProgressDialog(Context context) {
        this(context, (byte) 0);
    }

    private XQProgressDialog(Context context, byte b) {
        super(context, 2132739282);
        this.O0000Oo = null;
        this.O0000OoO = "%1d/%2d";
        this.O00000o0 = NumberFormat.getPercentInstance();
        this.O00000o0.setMaximumFractionDigits(0);
        this.O00000oo = context;
        O000000o(true);
        setCancelable(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Handler handler;
        View inflate = LayoutInflater.from(this.O00000oo).inflate((int) R.layout.xq_progress_dialog_commonui, (ViewGroup) null);
        this.O0000o0 = new Handler() {
            /* class com.xiaomi.smarthome.library.common.dialog.XQProgressDialog.AnonymousClass1 */

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                int max = XQProgressDialog.this.f9113O000000o.getMax();
                int progress = XQProgressDialog.this.f9113O000000o.getProgress();
                if (XQProgressDialog.this.O00000o0 != null) {
                    double d = (double) progress;
                    double d2 = (double) max;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    XQProgressDialog.this.O00000Oo.setText(new SpannableString(XQProgressDialog.this.O00000o0.format(d / d2)));
                    return;
                }
                XQProgressDialog.this.O00000Oo.setText("");
            }
        };
        this.O0000O0o = (ProgressBar) inflate.findViewById(R.id.indeterminate_progress);
        this.f9113O000000o = (CustomCircleProgressBar) inflate.findViewById(R.id.determinate_progress);
        this.O00000Oo = (TextView) inflate.findViewById(R.id.progress_percent);
        this.O0000OOo = (TextView) inflate.findViewById(R.id.progress_message);
        this.O0000Oo0 = (TextView) inflate.findViewById(R.id.cancel_btn);
        setView(inflate);
        this.O0000O0o.setIndeterminate(true);
        CharSequence charSequence = this.O0000Oo;
        if (charSequence != null) {
            setMessage(charSequence);
        }
        O000000o(this.O0000Ooo);
        if (this.O0000o00) {
            this.O0000Oo0.setVisibility(0);
            this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.library.common.dialog.XQProgressDialog.AnonymousClass2 */

                public final void onClick(View view) {
                    XQProgressDialog.this.cancel();
                }
            });
        } else {
            this.O0000Oo0.setVisibility(8);
        }
        int i = this.O00000o;
        if (i > 0) {
            this.f9113O000000o.setProgress(i);
        }
        int i2 = this.O00000oO;
        if (i2 > 0) {
            this.f9113O000000o.setMax(i2);
        }
        if (!this.O0000Ooo && (handler = this.O0000o0) != null && !handler.hasMessages(0)) {
            this.O0000o0.sendEmptyMessage(0);
        }
        super.onCreate(bundle);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.O0000o00 = z;
    }

    public final void O000000o(boolean z) {
        this.O0000Ooo = z;
        ProgressBar progressBar = this.O0000O0o;
        if (!(progressBar == null || this.f9113O000000o == null)) {
            if (z) {
                progressBar.setVisibility(0);
                this.f9113O000000o.setVisibility(8);
            } else {
                progressBar.setVisibility(8);
                this.f9113O000000o.setVisibility(0);
            }
        }
        TextView textView = this.O00000Oo;
        if (textView != null && this.O0000Ooo) {
            textView.setText("");
        }
    }

    public void setMessage(CharSequence charSequence) {
        TextView textView = this.O0000OOo;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.O0000Oo = charSequence;
        }
    }

    public static XQProgressDialog O000000o(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return O000000o(context, charSequence, charSequence2, true, true);
    }
}
