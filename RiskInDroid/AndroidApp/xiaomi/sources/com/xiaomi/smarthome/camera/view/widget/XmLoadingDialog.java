package com.xiaomi.smarthome.camera.view.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class XmLoadingDialog extends AlertDialog {
    private Context mContext;
    private CharSequence mMessage;
    private TextView mMessageView;

    public boolean isIndeterminate() {
        return true;
    }

    public void setIndeterminate(boolean z) {
    }

    public XmLoadingDialog(Context context) {
        this(context, R.style.XQProgressDialogSimple);
    }

    public XmLoadingDialog(Context context, int i) {
        super(context, i);
        this.mContext = context;
        setIndeterminate(true);
    }

    public static XmLoadingDialog show(Context context) {
        return show(context, context.getString(R.string.mj_refreshing_no_point));
    }

    public static XmLoadingDialog show(Context context, CharSequence charSequence) {
        return show(context, charSequence, true);
    }

    public static XmLoadingDialog show(Context context, CharSequence charSequence, boolean z) {
        return show(context, charSequence, z, null);
    }

    public static XmLoadingDialog show(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        XmLoadingDialog xmLoadingDialog = new XmLoadingDialog(context);
        xmLoadingDialog.setMessage(charSequence);
        xmLoadingDialog.setCancelable(z);
        xmLoadingDialog.setOnCancelListener(onCancelListener);
        xmLoadingDialog.setCanceledOnTouchOutside(false);
        xmLoadingDialog.show();
        return xmLoadingDialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.mContext).inflate((int) R.layout.xm_loading_dialog, (ViewGroup) null);
        setContentView(inflate);
        this.mMessageView = (TextView) inflate.findViewById(R.id.progress_message);
        setCanceledOnTouchOutside(false);
        CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            setMessage(charSequence);
        }
    }

    public void setMessage(CharSequence charSequence) {
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.mMessage = charSequence;
        }
    }
}
