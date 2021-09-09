package _m_j;

import _m_j.gnb;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class gmx {

    /* renamed from: O000000o  reason: collision with root package name */
    Handler f18022O000000o;
    private gpq O00000Oo;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static gmx f18024O000000o = new gmx((byte) 0);
    }

    /* synthetic */ gmx(byte b) {
        this();
    }

    private gmx() {
        this.O00000Oo = new gpq("BluetoothDeviceHandler");
        this.O00000Oo.start();
        this.f18022O000000o = new Handler(this.O00000Oo.getLooper()) {
            /* class _m_j.gmx.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (message.what == 17) {
                    gna gna = (gna) message.obj;
                    BluetoothSearchResult bluetoothSearchResult = (BluetoothSearchResult) message.getData().getParcelable("device");
                    if (bluetoothSearchResult.f9076O000000o != null) {
                        try {
                            bluetoothSearchResult.O00000oO = bluetoothSearchResult.f9076O000000o.getName();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Message obtainMessage = gnb.O000000o.f18037O000000o.f18035O000000o.obtainMessage(112, gna);
                        obtainMessage.getData().putParcelable("device", bluetoothSearchResult);
                        obtainMessage.sendToTarget();
                    }
                    bluetoothSearchResult.O00000oO = "";
                    Message obtainMessage2 = gnb.O000000o.f18037O000000o.f18035O000000o.obtainMessage(112, gna);
                    obtainMessage2.getData().putParcelable("device", bluetoothSearchResult);
                    obtainMessage2.sendToTarget();
                }
            }
        };
    }
}
