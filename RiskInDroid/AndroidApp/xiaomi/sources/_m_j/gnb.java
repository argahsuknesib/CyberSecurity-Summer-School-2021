package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class gnb {

    /* renamed from: O000000o  reason: collision with root package name */
    final Handler f18035O000000o;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static gnb f18037O000000o = new gnb((byte) 0);
    }

    /* synthetic */ gnb(byte b) {
        this();
    }

    private gnb() {
        this.f18035O000000o = new Handler(Looper.getMainLooper()) {
            /* class _m_j.gnb.AnonymousClass1 */

            public final void handleMessage(Message message) {
                gna gna = (gna) message.obj;
                int i = message.what;
                if (i == 64) {
                    gna.O000000o();
                } else if (i == 80) {
                    gna.O00000o0();
                } else if (i == 96) {
                    gna.O00000Oo();
                } else if (i == 112) {
                    gna.O000000o((BluetoothSearchResult) message.getData().getParcelable("device"));
                }
            }
        };
    }
}
