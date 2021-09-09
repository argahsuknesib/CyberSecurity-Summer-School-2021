package com.xiaomi.smarthome.uwb;

import _m_j.iwb;
import _m_j.ixe;
import android.content.Context;
import com.xiaomi.smarthome.uwb.ui.widget.CardLoadingDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\u0004\b\u0002\u0010\u0005H\n"}, d2 = {"<anonymous>", "Lcom/xiaomi/smarthome/uwb/ui/widget/CardLoadingDialog;", "C", "Lcom/xiaomi/smarthome/newui/card/Card;", "E", "T", "Lcom/xiaomi/smarthome/newui/card/Card$CardType;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class UwbCardActivity$mLoadingDialog$2 extends Lambda implements iwb<CardLoadingDialog> {
    final /* synthetic */ UwbCardActivity<C, E, T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UwbCardActivity$mLoadingDialog$2(UwbCardActivity<C, E, T> uwbCardActivity) {
        super(0);
        this.this$0 = uwbCardActivity;
    }

    public final CardLoadingDialog invoke() {
        Context context = this.this$0.getContext();
        ixe.O00000Oo(context, "context");
        return new CardLoadingDialog(context, null, true, null, 10, null);
    }
}
