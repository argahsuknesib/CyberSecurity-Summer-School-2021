package com.xiaomi.smarthome.newui;

import _m_j.han;
import _m_j.iwb;
import _m_j.ixe;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0007\n\u0000\n\u0000*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "com/xiaomi/smarthome/newui/TimeoutHandler$handler$2$handler$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class TimeoutHandler$handler$2 extends Lambda implements iwb<O000000o> {
    final /* synthetic */ han this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeoutHandler$handler$2(han han) {
        super(0);
        this.this$0 = han;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/TimeoutHandler$handler$2$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ han f10125O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O000000o(han han, Looper looper) {
            super(looper);
            this.f10125O000000o = han;
        }

        public final void handleMessage(Message message) {
            ixe.O00000o(message, "msg");
            this.f10125O000000o.f18710O000000o.O000000o(message.obj.toString(), message.arg1);
        }
    }

    public final /* synthetic */ Object invoke() {
        return new O000000o(this.this$0, this.this$0.O00000Oo);
    }
}
