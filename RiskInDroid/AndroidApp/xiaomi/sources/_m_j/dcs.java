package _m_j;

import android.text.TextUtils;
import com.android.bluetooth.ble.app.IMiuiNearbyApiService;

public final class dcs implements dcq {

    /* renamed from: O000000o  reason: collision with root package name */
    private IMiuiNearbyApiService f14485O000000o;

    public dcs(IMiuiNearbyApiService iMiuiNearbyApiService) {
        this.f14485O000000o = iMiuiNearbyApiService;
    }

    public final void O000000o(String str) {
        dct.O00000oO("MiConnectMiuiServiceOld onBindSuccess");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                iMiuiNearbyApiService.addBonedDevice(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld onBindSuccess exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }

    public final void O00000Oo(String str) {
        dct.O00000oO("MiConnectMiuiServiceOld onDeleteDevice");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                iMiuiNearbyApiService.removeBonedDevice(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld onDeleteDevice exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }

    public final void O000000o(String str, String str2) {
        dct.O00000oO("MiConnectMiuiServiceOld onDeleteDevice(String mac, String comboKey)");
        if (TextUtils.isEmpty(str)) {
            dct.O00000o0("MiConnectMiuiServiceOld mac is null, return");
            return;
        }
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                iMiuiNearbyApiService.removeBonedDevice(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld onDeleteDevice(String mac, String comboKey) exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }

    public final String O00000o0(String str) {
        dct.O00000oO("MiConnectMiuiServiceOld getWifiInfo");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                return iMiuiNearbyApiService.getWifiPassword(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld getWifiInfo exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
            return "";
        }
    }

    public final void O000000o(boolean z) {
        dct.O00000oO("setMiuiCanPop ".concat(String.valueOf(z)));
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                iMiuiNearbyApiService.setDialogSwitchOnOff(z);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld setMiuiCanPop exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }

    public final boolean O00000o(String str) {
        boolean z;
        dct.O00000oO("isComboKeyIgnore");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                z = iMiuiNearbyApiService.getWifiMacIgnore(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld isComboKeyIgnore exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
            z = false;
        }
        dct.O00000Oo("isIgnore = ".concat(String.valueOf(z)));
        return z;
    }

    public final void O00000Oo(String str, String str2) {
        dct.O00000oO("MiConnectMiuiServiceOld setMiuiIgnoreTotal");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                iMiuiNearbyApiService.addBonedDevice(str);
                this.f14485O000000o.setWifiMacIgnore(str2);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld setMiuiIgnoreTotal exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }

    public final void O00000oO(String str) {
        dct.O00000oO("MiConnectMiuiServiceOld setMiuiIngorDevice");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                iMiuiNearbyApiService.addBonedDevice(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld setMiuiIngorDevice exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }

    public final boolean O00000oo(String str) {
        dct.O00000oO("MiConnectMiuiServiceOld getMiuiIngorDevice");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                return iMiuiNearbyApiService.getMiuiIgnoreDeviceList(str);
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld getMiuiIngorDevice exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
            return false;
        }
    }

    public final void O0000O0o(String str) {
        dct.O00000oO("MiConnectMiuiServiceOld setMiuiDissPop");
        if (this.f14485O000000o != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                dct.O00000Oo("MiConnectMiuiServiceOld set miui dismiss time = ".concat(String.valueOf(currentTimeMillis)));
                this.f14485O000000o.setDeviceExitTimeStamp(str, String.valueOf(currentTimeMillis));
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld setMiuiDissPop exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }

    public final long O0000OOo(String str) {
        long j;
        dct.O00000oO("MiConnectMiuiServiceOld getMiuiDissPop");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                String deviceExitTimeStamp = iMiuiNearbyApiService.getDeviceExitTimeStamp(str);
                if (!TextUtils.isEmpty(deviceExitTimeStamp)) {
                    dct.O00000Oo("getMiuiDissPop string = ".concat(String.valueOf(deviceExitTimeStamp)));
                    j = Long.parseLong(deviceExitTimeStamp);
                    dct.O00000Oo("miui dismiss time = ".concat(String.valueOf(j)));
                    return j;
                }
                dct.O00000o0("getMiuiDissPop timeString is empty ");
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld getMiuiDissPop exception");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
        j = -1;
        dct.O00000Oo("miui dismiss time = ".concat(String.valueOf(j)));
        return j;
    }

    public final void O0000Oo0(String str) {
        dct.O00000oO("setComboKeyIgnoreInMiui");
        IMiuiNearbyApiService iMiuiNearbyApiService = this.f14485O000000o;
        if (iMiuiNearbyApiService != null) {
            try {
                iMiuiNearbyApiService.setWifiMacIgnore(str);
                dct.O00000Oo("MiConnectMiuiServiceOld setWifiMacIgnore = " + dct.O000000o(str));
            } catch (Exception e) {
                dct.O00000oo("MiConnectMiuiServiceOld setWifiMacIgnore error");
                e.printStackTrace();
            }
        } else {
            dct.O00000o0("mMiuiNearbyApiService is null!");
        }
    }
}
