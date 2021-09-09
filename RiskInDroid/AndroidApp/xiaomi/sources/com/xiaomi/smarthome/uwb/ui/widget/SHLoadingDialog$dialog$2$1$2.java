package com.xiaomi.smarthome.uwb.ui.widget;

import _m_j.iuh;
import _m_j.iwb;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/xiaomi/smarthome/uwb/ui/widget/SHLoadingDialog$dialog$2$1$2", "Lcom/xiaomi/smarthome/library/common/dialog/MLAlertDialog$DismissCallBack;", "afterDismissCallBack", "", "beforeDismissCallBack", "uwb-resource_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SHLoadingDialog$dialog$2$1$2 implements MLAlertDialog.O000000o {
    final /* synthetic */ SHLoadingDialog this$0;

    public final void beforeDismissCallBack() {
    }

    SHLoadingDialog$dialog$2$1$2(SHLoadingDialog sHLoadingDialog) {
        this.this$0 = sHLoadingDialog;
    }

    public final void afterDismissCallBack() {
        iwb<iuh> iwb = this.this$0.onDismiss;
        if (iwb != null) {
            iwb.invoke();
        }
    }
}
