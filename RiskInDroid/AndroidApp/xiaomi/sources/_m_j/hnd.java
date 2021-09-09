package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/xiaomi/smarthome/rx_receiver/BroadcastReceiverDisposable;", "Lio/reactivex/disposables/Disposable;", "context", "Landroid/content/Context;", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dispose", "", "isDisposed", "", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hnd implements Disposable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f19066O000000o;
    private final BroadcastReceiver O00000Oo;
    private final AtomicBoolean O00000o0 = new AtomicBoolean(false);

    public hnd(Context context, BroadcastReceiver broadcastReceiver) {
        ixe.O00000o(context, "context");
        ixe.O00000o(broadcastReceiver, "broadcastReceiver");
        this.f19066O000000o = context;
        this.O00000Oo = broadcastReceiver;
    }

    public final boolean isDisposed() {
        return this.O00000o0.get();
    }

    public final void dispose() {
        if (!this.O00000o0.getAndSet(true)) {
            ft.O000000o(this.f19066O000000o).O000000o(this.O00000Oo);
        }
    }
}
