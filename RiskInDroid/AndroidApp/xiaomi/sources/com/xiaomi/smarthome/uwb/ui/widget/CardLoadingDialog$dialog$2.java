package com.xiaomi.smarthome.uwb.ui.widget;

import _m_j.iwb;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/app/Dialog;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class CardLoadingDialog$dialog$2 extends Lambda implements iwb<Dialog> {
    final /* synthetic */ CardLoadingDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardLoadingDialog$dialog$2(CardLoadingDialog cardLoadingDialog) {
        super(0);
        this.this$0 = cardLoadingDialog;
    }

    public final Dialog invoke() {
        Dialog dialog = new Dialog(this.this$0.context);
        CardLoadingDialog cardLoadingDialog = this.this$0;
        View inflate = LayoutInflater.from(dialog.getContext()).inflate((int) R.layout.mj_card_loading_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.loading_text)).setText(cardLoadingDialog.msg);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.setCancelable(cardLoadingDialog.cancelable);
        return dialog;
    }
}
