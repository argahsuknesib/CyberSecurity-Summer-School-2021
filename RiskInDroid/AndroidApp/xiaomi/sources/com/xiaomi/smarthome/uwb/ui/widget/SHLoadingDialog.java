package com.xiaomi.smarthome.uwb.ui.widget;

import _m_j.itz;
import _m_j.iua;
import _m_j.iuh;
import _m_j.iwb;
import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.text.SimpleDateFormat;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/xiaomi/smarthome/uwb/ui/widget/SHLoadingDialog;", "", "context", "Landroid/content/Context;", "msg", "", "cancelable", "", "onCancel", "Lkotlin/Function0;", "", "onDismiss", "(Landroid/content/Context;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dialog", "Lcom/xiaomi/smarthome/library/common/dialog/MLAlertDialog;", "kotlin.jvm.PlatformType", "getDialog", "()Lcom/xiaomi/smarthome/library/common/dialog/MLAlertDialog;", "dialog$delegate", "Lkotlin/Lazy;", "formatter", "Ljava/text/SimpleDateFormat;", "getFormatter", "()Ljava/text/SimpleDateFormat;", "formatter$delegate", "appendDebugView", "dismiss", "show", "Companion", "uwb-resource_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SHLoadingDialog {
    public static final Companion Companion = new Companion(null);
    public final boolean cancelable;
    public final Context context;
    private final itz dialog$delegate;
    private final itz formatter$delegate;
    public final String msg;
    public final iwb<iuh> onCancel;
    public final iwb<iuh> onDismiss;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SHLoadingDialog(Context context2, String str) {
        this(context2, str, false, null, null, 28, null);
        ixe.O00000o(context2, "context");
        ixe.O00000o(str, "msg");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SHLoadingDialog(Context context2, String str, boolean z) {
        this(context2, str, z, null, null, 24, null);
        ixe.O00000o(context2, "context");
        ixe.O00000o(str, "msg");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SHLoadingDialog(Context context2, String str, boolean z, iwb<iuh> iwb) {
        this(context2, str, z, iwb, null, 16, null);
        ixe.O00000o(context2, "context");
        ixe.O00000o(str, "msg");
    }

    public SHLoadingDialog(Context context2, String str, boolean z, iwb<iuh> iwb, iwb<iuh> iwb2) {
        ixe.O00000o(context2, "context");
        ixe.O00000o(str, "msg");
        this.context = context2;
        this.msg = str;
        this.cancelable = z;
        this.onCancel = iwb;
        this.onDismiss = iwb2;
        this.dialog$delegate = iua.O000000o(new SHLoadingDialog$dialog$2(this));
        this.formatter$delegate = iua.O000000o(SHLoadingDialog$formatter$2.INSTANCE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SHLoadingDialog(Context context2, String str, boolean z, iwb iwb, iwb iwb2, int i, ixc ixc) {
        this(context2, str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : iwb, (i & 16) != 0 ? null : iwb2);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/ui/widget/SHLoadingDialog$Companion;", "", "()V", "TAG", "", "uwb-resource_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    private final MLAlertDialog getDialog() {
        return (MLAlertDialog) this.dialog$delegate.O000000o();
    }

    public final void show() {
        getDialog().show();
        View view = getDialog().getView();
        ProgressBar progressBar = view == null ? null : (ProgressBar) view.findViewById(R.id.progress);
        if (progressBar != null) {
            progressBar.startAnimation(AnimationUtils.loadAnimation(getDialog().getContext(), R.anim.uwb_mj_rotate_loading));
        }
    }

    public final void dismiss() {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
            View view = getDialog().getView();
            ProgressBar progressBar = view == null ? null : (ProgressBar) view.findViewById(R.id.progress);
            if (progressBar != null) {
                progressBar.clearAnimation();
            }
        }
    }

    private final SimpleDateFormat getFormatter() {
        return (SimpleDateFormat) this.formatter$delegate.O000000o();
    }

    public final void appendDebugView(String str) {
        ixe.O00000o(str, "msg");
        UwbLogUtil.d("SHLoadingDialog", str);
    }
}
