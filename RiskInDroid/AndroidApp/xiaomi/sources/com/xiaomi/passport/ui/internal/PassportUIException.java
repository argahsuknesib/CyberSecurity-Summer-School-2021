package com.xiaomi.passport.ui.internal;

import _m_j.ixe;
import android.accounts.AccountsException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportUIException;", "Landroid/accounts/AccountsException;", "()V", "msg", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public class PassportUIException extends AccountsException {
    public PassportUIException(String str, Throwable th) {
        super(str, th);
    }

    public PassportUIException() {
        this(null, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PassportUIException(String str) {
        this(str, null);
        ixe.O00000o0(str, "msg");
    }
}
