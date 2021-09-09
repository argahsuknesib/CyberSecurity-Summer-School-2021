package _m_j;

import android.os.RemoteException;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.ad.api.Advertisement;

public final class eyy {
    public static void O000000o(Advertisement advertisement) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().reportAdShow(advertisement);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static void O000000o() {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().reportAdClick();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static void O00000Oo(Advertisement advertisement) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().reportAdClose(advertisement);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static Advertisement O000000o(AdPosition adPosition) {
        Advertisement advertisement = adPosition.O00000Oo.get(0);
        for (Advertisement next : adPosition.O00000Oo) {
            if (advertisement.O0000Oo0 < next.O0000Oo0) {
                advertisement = next;
            }
        }
        return advertisement;
    }
}
