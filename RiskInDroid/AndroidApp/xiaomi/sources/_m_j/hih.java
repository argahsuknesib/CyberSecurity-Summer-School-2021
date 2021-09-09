package _m_j;

import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;

public final class hih {
    public static void O000000o(String str, String str2) {
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0(str, str2) {
            /* class _m_j.$$Lambda$hih$qZnRjOE7xIYybiLZaBIqYxZNQNs */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onCoreReady() {
                gsy.O00000Oo(LogType.SCENE, this.f$0, this.f$1);
            }
        });
    }
}
