package _m_j;

import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

final class awk implements Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    String f12663O000000o;
    Handler O00000Oo;
    final Map<ee, awm> O00000o;
    final Map<FragmentManager, awj> O00000o0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final awk f12664O000000o = new awk((byte) 0);
    }

    /* synthetic */ awk(byte b) {
        this();
    }

    static awk O000000o() {
        return O000000o.f12664O000000o;
    }

    private awk() {
        this.f12663O000000o = awb.class.getName();
        this.O00000o0 = new HashMap();
        this.O00000o = new HashMap();
        this.O00000Oo = new Handler(Looper.getMainLooper(), this);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.O00000o0.remove((FragmentManager) message.obj);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.O00000o.remove((ee) message.obj);
            return true;
        }
    }

    static <T> void O000000o(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
    }
}
