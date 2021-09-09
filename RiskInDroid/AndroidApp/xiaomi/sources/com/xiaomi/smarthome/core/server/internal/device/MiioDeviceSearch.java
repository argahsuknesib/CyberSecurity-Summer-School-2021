package com.xiaomi.smarthome.core.server.internal.device;

import _m_j.fjf;
import _m_j.fjk;
import _m_j.fjl;
import _m_j.fqe;
import _m_j.gog;
import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.device.ScanType;
import com.xiaomi.smarthome.device.Device;
import java.util.List;

public class MiioDeviceSearch extends fjl {
    private Context O00000Oo;

    public MiioDeviceSearch(Context context) {
        this.O00000Oo = context;
    }

    public final void O000000o(ScanType scanType, final fjf.O000000o o000000o) {
        if (scanType.ordinal() != ScanType.ALL.ordinal() || gog.O000000o(CommonApplication.getAppContext()) == null) {
            o000000o.O000000o(O000000o(null));
        } else {
            fqe.O000000o().O000000o(this.O00000Oo, new fjk<List<Device>>() {
                /* class com.xiaomi.smarthome.core.server.internal.device.MiioDeviceSearch.AnonymousClass1 */

                public final void O000000o(int i) {
                }

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    List list = (List) obj;
                    fjf.O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O000000o(MiioDeviceSearch.this.O000000o(list));
                    }
                }
            });
        }
    }
}
