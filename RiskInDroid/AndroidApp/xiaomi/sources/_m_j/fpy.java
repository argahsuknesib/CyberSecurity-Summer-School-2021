package _m_j;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class fpy extends fqc {
    public final void O000000o() {
        fjg O000000o2 = fjg.O000000o();
        if (!O000000o2.O00000o.isAlive()) {
            O000000o2.O00000o.start();
            O000000o2.O00000oO = new Handler(O000000o2.O00000o.getLooper());
        }
    }

    public final void O00000Oo() {
        fjg O000000o2 = fjg.O000000o();
        O000000o2.O00000oO.post(new Runnable() {
            /* class _m_j.fjg.AnonymousClass1 */

            public final void run() {
                try {
                    if (fjg.this.O00000o0 != null) {
                        fjg.this.O00000o0.close();
                    }
                    int ipAddress = ((WifiManager) CommonApplication.getAppContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
                    InetAddress byAddress = InetAddress.getByAddress(new byte[]{(byte) (ipAddress & 255), (byte) ((ipAddress >> 8) & 255), (byte) ((ipAddress >> 16) & 255), (byte) ((ipAddress >> 24) & 255)});
                    fjg.this.O00000o0 = isq.O000000o(byAddress);
                    fjg.this.O00000o0.O000000o(fjg.f16465O000000o, new O000000o(fjg.this, (byte) 0));
                    fjg.this.O00000o0.O000000o(fjg.O00000Oo, new O00000Oo(fjg.this, (byte) 0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public final void O00000o0() {
        fjg O000000o2 = fjg.O000000o();
        O000000o2.O00000oO.post(new Runnable() {
            /* class _m_j.fjg.AnonymousClass2 */

            public final void run() {
                fjg.this.O00000Oo();
                try {
                    if (fjg.this.O00000o0 != null) {
                        fjg.this.O00000o0.close();
                        fjg.this.O00000o0 = null;
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    public final void O00000o() {
        fjg.O000000o().O00000Oo();
    }

    public final List<Device> O00000oO() {
        return fjn.O000000o().O00000o0();
    }

    public final void O000000o(fja fja) {
        fjn.O000000o().O000000o(fja);
    }

    public final List<Device> O00000oo() {
        fjg O000000o2 = fjg.O000000o();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : O000000o2.O0000O0o.entrySet()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public final void O00000Oo(fja fja) {
        fjg.O000000o().O000000o(fja);
    }
}
