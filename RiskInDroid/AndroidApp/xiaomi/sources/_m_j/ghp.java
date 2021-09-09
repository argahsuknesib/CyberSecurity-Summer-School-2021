package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IBleCallback;

@RouterService
public class ghp implements fms {
    public String getModelByMacFromRnruntime() {
        DeviceStat deviceStat = hmq.O00000o0().getDeviceStat();
        return deviceStat != null ? deviceStat.model : "";
    }

    public void deviceRename(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().renameBluetoothDevice(str, str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void secureConnect(String str, IBleCallback iBleCallback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().secureConnect(str, iBleCallback);
            }
        } catch (RemoteException unused) {
        }
    }

    public void callBleApi(String str, int i, Bundle bundle, IBleCallback iBleCallback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().callBleApi(str, i, bundle, iBleCallback);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void registerMediaButtonReceiver(String str) {
        if (!TextUtils.isEmpty(str) && etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().registerMediaButtonReceiver(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public String getMediaButtonModel() {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            return etx.O000000o().O00000Oo().getMediaButtonModel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void unRegisterMediaButtonReceiver(String str) {
        if (!TextUtils.isEmpty(str) && etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().unRegisterMediaButtonReceiver(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void securityChipConnect(String str, IBleCallback iBleCallback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().securityChipConnect(str, iBleCallback);
            }
        } catch (RemoteException unused) {
        }
    }

    public void securityChipSharedDeviceConnect(String str, IBleCallback iBleCallback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().securityChipSharedDeviceConnect(str, iBleCallback);
            }
        } catch (RemoteException unused) {
        }
    }

    public void isBleGatewayExistInDeviceList(IBleCallback iBleCallback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().isBleGatewayExistInDeviceList(iBleCallback);
            }
        } catch (RemoteException unused) {
        }
    }

    public void bleMeshConnect(String str, String str2, IBleCallback iBleCallback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().bleMeshConnect(str, str2, iBleCallback);
            }
        } catch (RemoteException unused) {
        }
    }

    public void bleStandardAuthConnect(String str, IBleCallback iBleCallback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().bleStandardAuthConnect(str, iBleCallback);
            }
        } catch (RemoteException unused) {
        }
    }
}
