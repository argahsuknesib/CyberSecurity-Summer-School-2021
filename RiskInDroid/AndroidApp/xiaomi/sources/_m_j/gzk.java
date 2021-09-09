package _m_j;

import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;

public final class gzk extends fab {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18618O000000o;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static gzk f18619O000000o = new gzk((byte) 0);
    }

    /* synthetic */ gzk(byte b) {
        this();
    }

    private gzk() {
        this.f18618O000000o = false;
    }

    public final void O00000Oo() {
        super.O00000Oo();
        this.f18618O000000o = true;
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && ServiceApplication.getStateNotifier().f15923O000000o != 3) {
            dxq.O0000OOo();
        }
    }
}
