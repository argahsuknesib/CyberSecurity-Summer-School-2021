package _m_j;

import android.content.Context;
import android.view.View;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import java.util.ArrayList;
import java.util.List;

public class dco {
    private static volatile dco O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public fck f14476O000000o;
    public fcj O00000Oo;
    private fcj O00000o;

    private dco() {
    }

    public static dco O000000o() {
        if (O00000o0 == null) {
            synchronized (dco.class) {
                if (O00000o0 == null) {
                    O00000o0 = new dco();
                }
            }
        }
        return O00000o0;
    }

    public final void O000000o(fcj fcj) {
        dct.O00000Oo("setSelectHome home name = " + fcj.f16082O000000o);
        this.O00000Oo = fcj;
    }

    public final void O00000Oo(fcj fcj) {
        dct.O00000Oo("setSelectRoom room name = " + fcj.f16082O000000o);
        this.O00000o = fcj;
    }

    public final void O000000o(Device device) {
        fcj fcj;
        if (device != null && (fcj = this.O00000Oo) != null) {
            String str = fcj.O00000Oo;
            fcj fcj2 = this.O00000o;
            String str2 = fcj2 != null ? fcj2.O00000Oo : null;
            dco O000000o2 = O000000o();
            AnonymousClass1 r3 = new Callback<Void>() {
                /* class _m_j.dco.AnonymousClass1 */

                public final void onFailure(int i, String str) {
                    dct.O00000Oo("bind failed, error code = " + i + " errorInfo = " + str);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    dct.O00000Oo("bind home and room success");
                }
            };
            fck fck = O000000o2.f14476O000000o;
            if (fck == null) {
                r3.onFailure(-1, "no callback");
            } else {
                fck.O000000o(str, str2, device, r3);
            }
        }
    }

    public final void O000000o(fck fck) {
        if (this.f14476O000000o == null) {
            this.f14476O000000o = fck;
        }
    }

    public final ArrayList<fcj> O00000Oo() {
        fck fck = this.f14476O000000o;
        if (fck != null) {
            return fck.O000000o();
        }
        return null;
    }

    public final ArrayList<fcj> O000000o(String str) {
        fck fck = this.f14476O000000o;
        if (fck != null) {
            return fck.O000000o(str);
        }
        return null;
    }

    public final void O00000Oo(String str) {
        fck fck = this.f14476O000000o;
        if (fck != null) {
            fck.O00000Oo(str);
        }
    }

    public final void O000000o(BleDevice bleDevice, View view, Context context) {
        fck fck = this.f14476O000000o;
        if (fck != null) {
            fck.O000000o(bleDevice, view, context);
        }
    }

    public final boolean O00000o0() {
        fck fck = this.f14476O000000o;
        if (fck != null) {
            return fck.O00000o0();
        }
        return false;
    }

    public final List<fcj> O00000o() {
        fck fck = this.f14476O000000o;
        if (fck != null) {
            return fck.O00000Oo();
        }
        return null;
    }
}
