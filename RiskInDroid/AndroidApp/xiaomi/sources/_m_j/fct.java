package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.BleCoreProviderImpl$2;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class fct implements fej {
    public final void O000000o(String str, UUID uuid, UUID uuid2, byte[] bArr) {
        IClientApi O000000o2 = fcy.O000000o().O000000o("com.xiaomi.smarthome");
        if (O000000o2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_device_address", str);
            bundle.putSerializable("key_service_uuid", uuid);
            bundle.putSerializable("key_character_uuid", uuid2);
            bundle.putByteArray("key_character_value", bArr);
            try {
                O000000o2.onBleCharacterChanged(bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final String O000000o(int i) {
        return PluginDeviceManager.instance.getModelByProductId(i);
    }

    public final int O000000o(String str) {
        return PluginDeviceManager.instance.getProductIdByModel(str);
    }

    public final String O000000o() {
        return fdk.O000000o().O0000Oo();
    }

    public final String O00000Oo(String str) {
        PluginDeviceInfo pluginInfo;
        if (!TextUtils.isEmpty(str) && (pluginInfo = PluginDeviceManager.instance.getPluginInfo(str)) != null) {
            return pluginInfo.O0000Oo0();
        }
        return "";
    }

    public final void O000000o(String str, String str2) {
        gsy.O000000o(LogType.BLUETOOTH, str, str2);
    }

    public final void O00000Oo(String str, String str2) {
        gsy.O00000Oo(LogType.BLUETOOTH, str, str2);
    }

    public final void O00000o0(String str, String str2) {
        gsy.O00000o0(LogType.BLUETOOTH, str, str2);
    }

    public final int O00000o0(String str) {
        PluginDeviceInfo pluginInfo;
        if (!TextUtils.isEmpty(str) && (pluginInfo = PluginDeviceManager.instance.getPluginInfo(str)) != null) {
            return pluginInfo.O0000oOO();
        }
        return 0;
    }

    public final void O00000o(String str, String str2) {
        fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", str, str2, null, false);
    }

    public final Pair<Boolean, String> O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        Iterator<Device> it = fjd.O000000o().O00000Oo().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Device next = it.next();
            if (TextUtils.equals(str, next.getMac())) {
                if (next.getPid() == 16) {
                    return new Pair<>(Boolean.TRUE, next.getDid());
                }
            }
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public final boolean O00000oO(String str) {
        return CoreApi.O000000o().O00000o(str);
    }

    public final Device O00000oo(String str) {
        return fjd.O000000o().O000000o(str);
    }

    public final void O000000o(BleNetRequest bleNetRequest, final fer fer) {
        ArrayList arrayList = new ArrayList();
        if (bleNetRequest.O00000o0 != null && bleNetRequest.O00000o0.size() > 0) {
            for (BleKeyValuePair next : bleNetRequest.O00000o0) {
                arrayList.add(new KeyValuePair(next.f6797O000000o, next.O00000Oo));
            }
        }
        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o(bleNetRequest.f6798O000000o).O00000Oo(bleNetRequest.O00000Oo).O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
            /* class _m_j.fct.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                fer fer = fer;
                if (fer == null) {
                    return;
                }
                if (netError != null) {
                    fer.O000000o(netError.f6718O000000o, netError.O00000Oo);
                } else {
                    fer.O000000o(-9999, "error is null");
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                fer fer = fer;
                if (fer == null) {
                    return;
                }
                if (netResult != null) {
                    fer.O000000o(netResult.O00000o0);
                } else {
                    fer.O000000o(-9999, "response is null");
                }
            }
        });
    }

    public final void O000000o(List<String> list, fep fep) {
        fjd.O000000o().O000000o(list, new BleCoreProviderImpl$2(this, fep));
    }

    public final List<Device> O00000Oo() {
        return fjd.O000000o().O00000Oo();
    }

    public final void O000000o(String str, String str2, final feu feu) {
        fjq.O000000o().O000000o(str, str2, new fjo<String>() {
            /* class _m_j.fct.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                feu feu = feu;
                if (feu != null) {
                    feu.O000000o(str);
                }
            }

            public final void O000000o(int i) {
                feu feu = feu;
                if (feu != null) {
                    feu.O000000o(i);
                }
            }

            public final void O000000o(int i, Object obj) {
                feu feu = feu;
                if (feu != null) {
                    feu.O000000o(i, obj);
                }
            }
        });
    }

    public final String O00000o0() {
        ServerBean O00000o = fju.O000000o().O00000o();
        if (O00000o == null) {
            return "";
        }
        return O00000o.f7546O000000o;
    }

    public final boolean O00000o() {
        return fju.O000000o().O00000oO();
    }

    public final boolean O0000O0o(String str) {
        PluginDeviceInfo O00000oO;
        if (!TextUtils.isEmpty(str) && (O00000oO = CoreApi.O000000o().O00000oO(str)) != null && O00000oO.O000O0OO() == 1) {
            return true;
        }
        return false;
    }

    public final boolean O0000OOo(String str) {
        return fqx.O000000o(str);
    }
}
