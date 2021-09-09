package com.xiaomi.passport.ui.internal;

import _m_j.egc;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.view.View;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class CommonErrorHandler$showCaptcha$1$2 extends Lambda implements iwc<Throwable, iuh> {
    final /* synthetic */ egc.O00000o0 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonErrorHandler$showCaptcha$1$2(egc.O00000o0 o00000o0) {
        super(1);
        this.this$0 = o00000o0;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        ixe.O00000o0(th, "it");
        AccountLog.e("Passport", "captcha", th);
        if (th instanceof IOException) {
            this.this$0.f15243O000000o.O000000o((IOException) th, this.this$0.O00000oO, (View) null);
        } else {
            this.this$0.f15243O000000o.O000000o(th, this.this$0.O00000oO);
        }
        return iuh.f1631O000000o;
    }
}
