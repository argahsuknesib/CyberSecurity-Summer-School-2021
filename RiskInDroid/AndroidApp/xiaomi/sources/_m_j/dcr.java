package _m_j;

import android.text.TextUtils;
import com.android.bluetooth.ble.app.IMiuiNearbyDialogService;

public final class dcr implements dcq {

    /* renamed from: O000000o  reason: collision with root package name */
    private IMiuiNearbyDialogService f14484O000000o;

    public dcr(IMiuiNearbyDialogService iMiuiNearbyDialogService) {
        this.f14484O000000o = iMiuiNearbyDialogService;
    }

    public final void O000000o(String str) {
        dct.O00000oO("MiConnectMiuiServiceNew onBindSuccess");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                iMiuiNearbyDialogService.addOrRemoveBonedDevice(str, "invalid", true);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew onBindSuccess exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }

    public final void O00000Oo(String str) {
        dct.O00000oO("MiConnectMiuiServiceNew onDeleteDevice");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                iMiuiNearbyDialogService.addOrRemoveBonedDevice(str, "invalid", false);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew onDeleteDevice exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }

    public final void O000000o(String str, String str2) {
        dct.O00000oO("MiConnectMiuiServiceNew onDeleteDevice(context, mac, comboKey)");
        if (TextUtils.isEmpty(str)) {
            str = "invalid";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "invalid";
        }
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                iMiuiNearbyDialogService.addOrRemoveBonedDevice(str, str2, false);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew onDeleteDevice(String mac, String comboKey) exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }

    public final String O00000o0(String str) {
        dct.O00000oO("MiConnectMiuiServiceNew getWifiInfo");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                return iMiuiNearbyDialogService.getWifiPassword(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew getWifiInfo exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
            return "";
        }
    }

    public final void O000000o(boolean z) {
        dct.O00000oO("MiConnectMiuiServiceNew setMiuiCanPop");
        if (this.f14484O000000o != null) {
            try {
                dct.O00000Oo("setDialogState ".concat(String.valueOf(z)));
                this.f14484O000000o.setDialogState(z);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew setMiuiCanPop exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }

    public final boolean O00000o(String str) {
        boolean z;
        dct.O00000Oo("MiConnectMiuiServiceNew isComboKeyIgnore");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                z = iMiuiNearbyDialogService.getDeviceIgnoreState(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew isComboKeyIgnore exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
            z = false;
        }
        dct.O00000Oo("isIgnore = ".concat(String.valueOf(z)));
        return z;
    }

    public final void O00000Oo(String str, String str2) {
        dct.O00000oO("MiConnectMiuiServiceNew setMiuiIgnoreTotal");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                iMiuiNearbyDialogService.addOrRemoveBonedDevice(str, str2, true);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew setMiuiIgnoreTotal exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }

    public final void O00000oO(String str) {
        dct.O00000oO("MiConnectMiuiServiceNew setMiuiIngorDevice");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                iMiuiNearbyDialogService.addOrRemoveBonedDevice(str, "invalid", true);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew setMiuiIngorDevice exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }

    public final boolean O00000oo(String str) {
        dct.O00000oO("MiConnectMiuiServiceNew getMiuiIngorDevice");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                return iMiuiNearbyDialogService.getDeviceIgnoreState(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew getMiuiIngorDevice exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
            return false;
        }
    }

    public final void O0000O0o(String str) {
        dct.O00000oO("MiConnectMiuiServiceNew setMiuiDissPop");
        if (this.f14484O000000o != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                dct.O00000Oo("set miui dismiss time = ".concat(String.valueOf(currentTimeMillis)));
                this.f14484O000000o.setDeviceExitTimeStamp(str, String.valueOf(currentTimeMillis));
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew setMiuiDissPop exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }

    public final long O0000OOo(String str) {
        long j;
        dct.O00000oO("MiConnectMiuiServiceNew getMiuiDissPop");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                String deviceExitTimeStamp = iMiuiNearbyDialogService.getDeviceExitTimeStamp(str);
                if (!TextUtils.isEmpty(deviceExitTimeStamp)) {
                    dct.O00000Oo("getMiuiDissPop string = ".concat(String.valueOf(deviceExitTimeStamp)));
                    j = Long.parseLong(deviceExitTimeStamp);
                    dct.O00000Oo("miui dismiss time = ".concat(String.valueOf(j)));
                    return j;
                }
                dct.O00000o0("getMiuiDissPop timeString is empty ");
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew getMiuiDissPop exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
        j = -1;
        dct.O00000Oo("miui dismiss time = ".concat(String.valueOf(j)));
        return j;
    }

    public final void O0000Oo0(String str) {
        dct.O00000oO("setComboKeyIgnoreInMiui");
        IMiuiNearbyDialogService iMiuiNearbyDialogService = this.f14484O000000o;
        if (iMiuiNearbyDialogService != null) {
            try {
                iMiuiNearbyDialogService.addOrRemoveBonedDevice("invalid", str, true);
                dct.O00000Oo("setWifiMacIgnore = " + dct.O000000o(str));
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceNew setComboKeyIgnoreInMiui exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("miuiNearbyDialogService is null!");
        }
    }
}
