package com.smarthome.uwb.ui.manager;

import _m_j.ddw;
import _m_j.iwb;
import _m_j.ixe;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
final class UwbManagerTagActivity$initView$3$menus$2 extends Lambda implements iwb<Boolean> {
    final /* synthetic */ UwbManagerTagActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UwbManagerTagActivity$initView$3$menus$2(UwbManagerTagActivity uwbManagerTagActivity) {
        super(0);
        this.this$0 = uwbManagerTagActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        if (_m_j.ixe.O000000o(r2, java.lang.Boolean.TRUE) != false) goto L_0x0036;
     */
    public final /* synthetic */ Object invoke() {
        boolean z = true;
        if (this.this$0.getCanEnterEditMode()) {
            ddw ddw = this.this$0.state;
            Boolean bool = null;
            if (ddw != null) {
                List value = ddw.O00000Oo.getValue();
                if (value != null) {
                    bool = Boolean.valueOf(!value.isEmpty());
                }
            } else {
                ixe.O000000o("state");
                throw null;
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
