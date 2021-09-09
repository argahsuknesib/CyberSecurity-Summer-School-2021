package _m_j;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.smarthome.rx_receiver.BroadcastReceiverObservable$subscribeActual$receiver$1;
import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0013H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/xiaomi/smarthome/rx_receiver/BroadcastReceiverObservable;", "Lio/reactivex/Observable;", "Landroid/content/Intent;", "action", "", "application", "Landroid/app/Application;", "once", "", "(Ljava/lang/String;Landroid/app/Application;Z)V", "getAction", "()Ljava/lang/String;", "getApplication", "()Landroid/app/Application;", "getOnce", "()Z", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hne extends Observable<Intent> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f19067O000000o;
    public final Application O00000Oo;
    public final boolean O00000o0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public hne(String str, Application application, byte b) {
        this(str, application);
        ixe.O00000o(str, "action");
        ixe.O00000o(application, "application");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hne.<init>(java.lang.String, android.app.Application, boolean):void
     arg types: [java.lang.String, android.app.Application, int]
     candidates:
      _m_j.hne.<init>(java.lang.String, android.app.Application, byte):void
      _m_j.hne.<init>(java.lang.String, android.app.Application, boolean):void */
    public /* synthetic */ hne(String str, Application application) {
        this(str, application, false);
    }

    public hne(String str, Application application, boolean z) {
        ixe.O00000o(str, "action");
        ixe.O00000o(application, "application");
        this.f19067O000000o = str;
        this.O00000Oo = application;
        this.O00000o0 = z;
    }

    public final void subscribeActual(Observer<? super Intent> observer) {
        ixe.O00000o(observer, "observer");
        BroadcastReceiverObservable$subscribeActual$receiver$1 broadcastReceiverObservable$subscribeActual$receiver$1 = new BroadcastReceiverObservable$subscribeActual$receiver$1(this, observer);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.f19067O000000o);
        BroadcastReceiver broadcastReceiver = broadcastReceiverObservable$subscribeActual$receiver$1;
        ft.O000000o(this.O00000Oo).O000000o(broadcastReceiver, intentFilter);
        observer.onSubscribe(new hnd(this.O00000Oo, broadcastReceiver));
    }
}
