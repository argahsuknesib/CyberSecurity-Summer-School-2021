package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.newui.TimeoutHandler$handler$2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/newui/TimeoutHandler;", "", "callback", "Lcom/xiaomi/smarthome/newui/TimeoutHandler$OnTimeout;", "looper", "Landroid/os/Looper;", "(Lcom/xiaomi/smarthome/newui/TimeoutHandler$OnTimeout;Landroid/os/Looper;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "clear", "", "did", "", "signal", "timeOut", "", "payload", "", "OnTimeout", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class han {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O000000o f18710O000000o;
    public final Looper O00000Oo;
    private final itz O00000o0 = iua.O000000o(new TimeoutHandler$handler$2(this));

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/xiaomi/smarthome/newui/TimeoutHandler$OnTimeout;", "", "onTimeout", "", "did", "", "payload", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void O000000o(String str, int i);
    }

    public han(O000000o o000000o, Looper looper) {
        ixe.O00000o(o000000o, "callback");
        ixe.O00000o(looper, "looper");
        this.f18710O000000o = o000000o;
        this.O00000Oo = looper;
    }

    public final Handler O000000o() {
        return (Handler) this.O00000o0.O000000o();
    }

    public final void O000000o(String str, long j, int i) {
        ixe.O00000o(str, "did");
        O000000o().removeMessages(str.hashCode());
        Message obtain = Message.obtain();
        obtain.what = str.hashCode();
        obtain.obj = str;
        obtain.arg1 = i;
        O000000o().sendMessageDelayed(obtain, j);
    }
}
