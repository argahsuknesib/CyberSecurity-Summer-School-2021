package _m_j;

import android.content.Context;
import com.xiaomi.passport.ui.view.LoadingDialog;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/ProgressHolder;", "", "()V", "mProgressDialog", "Lcom/xiaomi/passport/ui/view/LoadingDialog;", "dismissProgress", "", "showProgress", "context", "Landroid/content/Context;", "title", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehh {

    /* renamed from: O000000o  reason: collision with root package name */
    private LoadingDialog f15283O000000o;

    public final void O000000o(Context context) {
        ixe.O00000o0(context, "context");
        O000000o(context, context.getString(R.string.loading));
    }

    private final void O000000o(Context context, CharSequence charSequence) {
        this.f15283O000000o = new LoadingDialog(context);
        LoadingDialog loadingDialog = this.f15283O000000o;
        boolean z = false;
        if (loadingDialog != null) {
            loadingDialog.setCanceledOnTouchOutside(false);
        }
        LoadingDialog loadingDialog2 = this.f15283O000000o;
        if (loadingDialog2 != null) {
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (z) {
                charSequence = context.getString(R.string.loading);
            } else if (charSequence == null) {
                ixe.O000000o();
            }
            loadingDialog2.O000000o(charSequence);
        }
    }

    public final void O000000o() {
        LoadingDialog loadingDialog = this.f15283O000000o;
        if (loadingDialog != null) {
            if (loadingDialog == null) {
                ixe.O000000o();
            }
            if (loadingDialog.isShowing()) {
                LoadingDialog loadingDialog2 = this.f15283O000000o;
                if (loadingDialog2 != null) {
                    loadingDialog2.dismiss();
                }
                this.f15283O000000o = null;
            }
        }
    }
}
