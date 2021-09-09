package com.xiaomi.smarthome.rx_receiver;

import _m_j.ft;
import _m_j.hne;
import _m_j.ixe;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.reactivex.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/xiaomi/smarthome/rx_receiver/BroadcastReceiverObservable$subscribeActual$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BroadcastReceiverObservable$subscribeActual$receiver$1 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ hne f10551O000000o;
    final /* synthetic */ Observer<? super Intent> O00000Oo;

    public BroadcastReceiverObservable$subscribeActual$receiver$1(hne hne, Observer<? super Intent> observer) {
        this.f10551O000000o = hne;
        this.O00000Oo = observer;
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
        ixe.O00000o(context, "context");
        ixe.O00000o(intent, "intent");
        if (ixe.O000000o((Object) intent.getAction(), (Object) this.f10551O000000o.f19067O000000o)) {
            this.O00000Oo.onNext(intent);
        }
        if (this.f10551O000000o.O00000o0) {
            this.O00000Oo.onComplete();
            ft.O000000o(this.f10551O000000o.O00000Oo).O000000o(this);
        }
    }
}
