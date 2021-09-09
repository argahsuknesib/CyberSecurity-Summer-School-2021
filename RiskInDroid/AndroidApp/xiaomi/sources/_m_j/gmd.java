package _m_j;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.WriteCharacterListener;
import java.util.List;
import java.util.UUID;

public final class gmd extends gmj implements WriteCharacterListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18012O000000o = 1;
    public int O00000Oo;
    Handler O00000o0 = new Handler(Looper.myLooper()) {
        /* class _m_j.gmd.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                gmd.this.f18012O000000o++;
                if (gmd.this.f18012O000000o >= gmd.this.O00000Oo * 2) {
                    gmd.this.O00000o0.removeCallbacksAndMessages(null);
                    gnk.O000000o("batchHandler ,try write more time ,stop try", new Object[0]);
                    gmd.this.O00000o();
                    gmd.this.O00000Oo(0);
                    return;
                }
                gmd.this.O00000Oo();
            }
        }
    };
    private List<byte[]> O0000o;
    private int O0000o0o = 2;

    public gmd(UUID uuid, UUID uuid2, List<byte[]> list, gma gma) {
        super(gma);
        this.O00000o = uuid;
        this.O00000oO = uuid2;
        this.O0000o = list;
        this.O00000Oo = list.size();
    }

    public final void O000000o() {
        int currentStatus = getCurrentStatus();
        if (currentStatus != 2 && currentStatus != 19) {
            O00000Oo(-1);
        } else if (O00000Oo()) {
            O00000o0();
        }
    }

    public final boolean O00000Oo() {
        List<byte[]> list = this.O0000o;
        if (list == null || list.isEmpty()) {
            O00000Oo(0);
            O00000o();
            return false;
        }
        if (writeCharacteristic(this.O00000o, this.O00000oO, this.O0000o.get(0))) {
            this.O0000o.remove(0);
            gnk.O00000o("OTARequest write success,add delay time to " + this.O0000o0o);
            return true;
        }
        gnk.O00000o("OTARequest write fail,add delay time to " + this.O0000o0o);
        return true;
    }

    public final void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        gnk.O00000o("BleBatchWriteRequest onCharacteristicWrite status=".concat(String.valueOf(i)));
        this.f18012O000000o++;
        if (this.f18012O000000o >= this.O00000Oo * 2) {
            O00000Oo(0);
            O00000o();
            return;
        }
        O00000Oo();
    }
}
