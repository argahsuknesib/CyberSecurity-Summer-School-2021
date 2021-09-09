package com.xiaomi.passport.ui.internal;

import _m_j.efa;
import _m_j.ixe;
import android.content.ComponentName;
import android.content.Context;
import com.xiaomi.passport.ui.page.AccountLoginActivity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AuthComponent;", "Lcom/xiaomi/passport/interfaces/AuthenticatorComponentNameInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAddAccountActivityComponentName", "Landroid/content/ComponentName;", "getConfirmCredentialActivityComponentName", "getNotificationActivityComponentName", "getProcessScanLoginQRCodeComponentName", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class AuthComponent implements efa {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f6239O000000o;

    public AuthComponent(Context context) {
        ixe.O00000o0(context, "context");
        this.f6239O000000o = context;
    }

    public final ComponentName O000000o() {
        return new ComponentName(this.f6239O000000o, AccountLoginActivity.class);
    }

    public final ComponentName O00000Oo() {
        return new ComponentName(this.f6239O000000o, QuickLoginActivity.class);
    }

    public final ComponentName O00000o0() {
        return new ComponentName(this.f6239O000000o, NotificationActivity.class);
    }

    public final ComponentName O00000o() {
        return new ComponentName(this.f6239O000000o, LoginQRCodeScanResultActivity.class);
    }
}
