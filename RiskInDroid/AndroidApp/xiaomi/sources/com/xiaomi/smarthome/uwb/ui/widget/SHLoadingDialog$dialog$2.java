package com.xiaomi.smarthome.uwb.ui.widget;

import _m_j.iuh;
import _m_j.iwb;
import _m_j.ixe;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/xiaomi/smarthome/library/common/dialog/MLAlertDialog;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class SHLoadingDialog$dialog$2 extends Lambda implements iwb<MLAlertDialog> {
    final /* synthetic */ SHLoadingDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SHLoadingDialog$dialog$2(SHLoadingDialog sHLoadingDialog) {
        super(0);
        this.this$0 = sHLoadingDialog;
    }

    public final MLAlertDialog invoke() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this.this$0.context);
        SHLoadingDialog sHLoadingDialog = this.this$0;
        builder.O000000o(MLAlertDialog.ButtonStyle.Alert);
        builder.O00000o0(17039360, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.uwb.ui.widget.$$Lambda$SHLoadingDialog$dialog$2$L5GDcpSQncxTTGvWWwqF4tDeiI */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SHLoadingDialog$dialog$2.m560invoke$lambda1$lambda0(SHLoadingDialog.this, dialogInterface, i);
            }
        });
        builder.O000000o(new SHLoadingDialog$dialog$2$1$2(sHLoadingDialog));
        View inflate = LayoutInflater.from(sHLoadingDialog.context).inflate((int) R.layout.loading_flip_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.loading_text)).setText(sHLoadingDialog.msg);
        builder.O000000o(inflate);
        builder.O000000o(sHLoadingDialog.cancelable);
        return builder.O00000o();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m560invoke$lambda1$lambda0(SHLoadingDialog sHLoadingDialog, DialogInterface dialogInterface, int i) {
        ixe.O00000o(sHLoadingDialog, "this$0");
        dialogInterface.dismiss();
        iwb<iuh> iwb = sHLoadingDialog.onCancel;
        if (iwb != null) {
            iwb.invoke();
        }
    }
}
