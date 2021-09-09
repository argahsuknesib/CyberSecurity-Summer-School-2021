package com.smarthome.uwb.ui;

import _m_j.ddt;
import _m_j.ggb;
import _m_j.gtf;
import _m_j.hzk;
import _m_j.hzq;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.ixe;
import _m_j.iyo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/xiaomi/smarthome/device/Device;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class UwbBindHelper$getHomeUnBindDevices$1$result$1$querySupport$1 extends Lambda implements iwb<List<? extends Device>> {
    final /* synthetic */ hzk $config;
    final /* synthetic */ String $homeId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UwbBindHelper$getHomeUnBindDevices$1$result$1$querySupport$1(String str, hzk hzk) {
        super(0);
        this.$homeId = str;
        this.$config = hzk;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, int, int):int
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055 A[SYNTHETIC] */
    public final /* synthetic */ Object invoke() {
        boolean z;
        String str;
        List<Device> O0000Oo = ggb.O00000Oo().O0000Oo(this.$homeId);
        ixe.O00000Oo(O0000Oo, "getInstance().getDeviceByHomeId(homeId)");
        List O000000o2 = iuo.O000000o((Iterable) O0000Oo);
        UwbLogUtil.d("UwbBindHelper", "getHomeUnBindDevices supportConfig: " + this.$config + ",  ,currentHomeDevices " + O000000o2.size() + " , isHomeInit: " + ggb.O00000Oo().O0000OoO.O00000oo);
        hzk hzk = this.$config;
        Collection arrayList = new ArrayList();
        for (Object next : O000000o2) {
            Device device = (Device) next;
            boolean z2 = true;
            if (device.isOnline) {
                ddt ddt = ddt.f14518O000000o;
                ixe.O00000Oo(hzk, "config");
                String str2 = device.model;
                ixe.O00000Oo(str2, "it.model");
                if (ddt.O000000o(hzk, str2) && (device.comFlag & 8) != 8) {
                    z = true;
                    StringBuilder sb = new StringBuilder("getHomeUnBindDevices supportConfig:isOnline ");
                    sb.append(device.isOnline);
                    sb.append(" model:  ");
                    sb.append((Object) device.model);
                    sb.append(", flag ");
                    if ((device.comFlag & 8) == 8) {
                        z2 = false;
                    }
                    sb.append(z2);
                    sb.append(" isSupport: ");
                    sb.append(z);
                    UwbLogUtil.d("UwbBindHelper", sb.toString());
                    gtf.O000000o();
                    if (gtf.O00000Oo(device) || hzq.O00000o(device.model)) {
                        z = false;
                    }
                    str = device.model;
                    ixe.O00000Oo(str, "it.model");
                    if (iyo.O000000o(str, "miir.", false)) {
                        z = false;
                    }
                    if (!z) {
                        arrayList.add(next);
                    }
                }
            }
            z = false;
            StringBuilder sb2 = new StringBuilder("getHomeUnBindDevices supportConfig:isOnline ");
            sb2.append(device.isOnline);
            sb2.append(" model:  ");
            sb2.append((Object) device.model);
            sb2.append(", flag ");
            if ((device.comFlag & 8) == 8) {
            }
            sb2.append(z2);
            sb2.append(" isSupport: ");
            sb2.append(z);
            UwbLogUtil.d("UwbBindHelper", sb2.toString());
            gtf.O000000o();
            z = false;
            str = device.model;
            ixe.O00000Oo(str, "it.model");
            if (iyo.O000000o(str, "miir.", false)) {
            }
            if (!z) {
            }
        }
        return (List) arrayList;
    }
}
