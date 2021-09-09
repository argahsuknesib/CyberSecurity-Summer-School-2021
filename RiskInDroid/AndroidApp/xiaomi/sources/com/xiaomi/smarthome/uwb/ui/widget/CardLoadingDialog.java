package com.xiaomi.smarthome.uwb.ui.widget;

import _m_j.itz;
import _m_j.iua;
import _m_j.iuh;
import _m_j.iwb;
import _m_j.ixc;
import _m_j.ixe;
import android.app.Dialog;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/uwb/ui/widget/CardLoadingDialog;", "", "context", "Landroid/content/Context;", "msg", "", "cancelable", "", "onCancel", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "dialog$delegate", "Lkotlin/Lazy;", "dismiss", "show", "Companion", "uwb-resource_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CardLoadingDialog {
    public static final Companion Companion = new Companion(null);
    public final boolean cancelable;
    public final Context context;
    private final itz dialog$delegate;
    public final String msg;
    private final iwb<iuh> onCancel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardLoadingDialog(Context context2) {
        this(context2, null, false, null, 14, null);
        ixe.O00000o(context2, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardLoadingDialog(Context context2, String str) {
        this(context2, str, false, null, 12, null);
        ixe.O00000o(context2, "context");
        ixe.O00000o(str, "msg");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardLoadingDialog(Context context2, String str, boolean z) {
        this(context2, str, z, null, 8, null);
        ixe.O00000o(context2, "context");
        ixe.O00000o(str, "msg");
    }

    public CardLoadingDialog(Context context2, String str, boolean z, iwb<iuh> iwb) {
        ixe.O00000o(context2, "context");
        ixe.O00000o(str, "msg");
        this.context = context2;
        this.msg = str;
        this.cancelable = z;
        this.onCancel = iwb;
        this.dialog$delegate = iua.O000000o(new CardLoadingDialog$dialog$2(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ CardLoadingDialog(Context context2, String str, boolean z, iwb iwb, int i, ixc ixc) {
        this(context2, str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : iwb);
        if ((i & 2) != 0) {
            str = context2.getString(R.string.common_device_loading);
            ixe.O00000Oo(str, "<init>");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/ui/widget/CardLoadingDialog$Companion;", "", "()V", "TAG", "", "uwb-resource_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    private final Dialog getDialog() {
        return (Dialog) this.dialog$delegate.O000000o();
    }

    public final void show() {
        getDialog().show();
        Dialog dialog = getDialog();
        ProgressBar progressBar = dialog == null ? null : (ProgressBar) dialog.findViewById(R.id.progress);
        if (progressBar != null) {
            progressBar.startAnimation(AnimationUtils.loadAnimation(getDialog().getContext(), R.anim.rotate_loading));
        }
    }

    public final void dismiss() {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
            Dialog dialog = getDialog();
            ProgressBar progressBar = dialog == null ? null : (ProgressBar) dialog.findViewById(R.id.progress);
            if (progressBar != null) {
                progressBar.clearAnimation();
            }
        }
    }
}
