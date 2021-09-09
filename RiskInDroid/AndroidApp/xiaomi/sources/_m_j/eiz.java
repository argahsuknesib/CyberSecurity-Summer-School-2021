package _m_j;

import android.content.Context;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;

public final class eiz extends eiv {
    private final efp O00000Oo;

    public eiz(efp efp, eiv eiv) {
        super(eiv);
        this.O00000Oo = efp;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof NeedNotificationException)) {
            return false;
        }
        String notificationUrl = ((NeedNotificationException) th).getNotificationUrl();
        efp efp = this.O00000Oo;
        new eih();
        efp.gotoFragment(eih.O000000o(notificationUrl), true);
        return true;
    }
}
