package com.xiaomi.passport.ui.internal;

import _m_j.ixe;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/xiaomi/passport/ui/internal/AddAccountActivity$registerBroadcast$1", "Landroid/content/BroadcastReceiver;", "(Lcom/xiaomi/passport/ui/internal/AddAccountActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class AddAccountActivity$registerBroadcast$1 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ AddAccountActivity f6228O000000o;

    AddAccountActivity$registerBroadcast$1(AddAccountActivity addAccountActivity) {
        this.f6228O000000o = addAccountActivity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            boolean O000000o2 = ixe.O000000o((Object) intent.getStringExtra("sns_result"), (Object) "ok");
            this.f6228O000000o.onSnsResultReturned(O000000o2);
            if (!O000000o2 && this.f6228O000000o.isSnsDirectlySignInMode()) {
                this.f6228O000000o.setLoginCancelledResult();
            }
        }
    }
}
