package com.xiaomi.smarthome.wificonfig;

import _m_j.dxc;
import _m_j.fmw;
import _m_j.gfq;
import _m_j.gog;
import _m_j.gsy;
import _m_j.gwj;
import _m_j.iae;
import _m_j.iag;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.miui.whetstone.WhetstoneResult;
import com.miui.whetstone.WhetstoneResultBinder;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.lang.reflect.InvocationTargetException;

public class WifiSettingNormal extends BaseWifiSetting {
    private String O0000ooO;

    public void startConnection() {
        ScanResult scanResult;
        int i;
        long j;
        WifiManager wifiManager = (WifiManager) getSystemService("wifi");
        if (wifiManager.isWifiEnabled()) {
            this.O0000o = System.currentTimeMillis();
            this.O0000ooO = gog.O00000Oo(this);
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                if (this.O00000o0 != null) {
                    for (iag.O000000o o000000o : this.O00000o0) {
                        if (iag.O000000o(connectionInfo.getSSID(), o000000o.f1089O000000o.SSID) && !TextUtils.isEmpty(o000000o.f1089O000000o.BSSID)) {
                            this.O0000ooO = o000000o.f1089O000000o.BSSID;
                        }
                    }
                }
                gwj.O000000o O000000o2 = gfq.O000000o().O000000o(this.O0000ooO);
                if (O000000o2 != null) {
                    fmw.O000000o().O000000o(this, this.O00000oo);
                    if (this.O0000oO0 == null) {
                        scanResult = this.O0000Oo ? ((iag.O000000o) this.O00000o.get(this.O00000oO)).f1089O000000o : ((iag.O000000o) this.O00000o0.get(this.O00000oO)).f1089O000000o;
                    } else {
                        scanResult = null;
                    }
                    String str = "";
                    if (this.O00000oo == null) {
                        try {
                            j = Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue();
                        } catch (Exception unused) {
                            j = 0;
                        }
                        if (j > 0) {
                            if (this.O0000OoO && !this.O0000o0o && !this.O0000o00 && this.O0000oO0 == null) {
                                try {
                                    this.O0000Ooo.getDeclaredMethod("wifiSmartConfigAsyncWithUid", String.class, String.class, String.class, String.class, Integer.TYPE, IBinder.class).invoke(null, scanResult.SSID, null, scanResult.BSSID, scanResult.capabilities, Integer.valueOf((int) j), new WhetstoneResultBinder() {
                                        /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass1 */

                                        public void onResult(WhetstoneResult whetstoneResult) {
                                            super.onResult(whetstoneResult);
                                        }
                                    });
                                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                                }
                            } else if (O000000o2 != null) {
                                String str2 = O000000o2.O00000o0;
                                if (O000000o2.O00000o != null) {
                                    str = O000000o2.O00000o;
                                }
                                MiioLocalAPI.O000000o(str2, str, (String) null, O000000o2.O00000oo, j, new dxc() {
                                    /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass2 */
                                });
                            }
                        } else if (!this.O0000OoO || this.O0000o0o || this.O0000o00 || this.O0000oO0 != null) {
                            String str3 = O000000o2.O00000o0;
                            if (O000000o2.O00000o != null) {
                                str = O000000o2.O00000o;
                            }
                            MiioLocalAPI.O000000o(str3, str, (String) null, O000000o2.O00000oo, new dxc() {
                                /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass4 */
                            });
                        } else {
                            this.O0000Ooo.getDeclaredMethod("wifiSmartConfigAsync", String.class, String.class, String.class, String.class, Integer.TYPE, WhetstoneResultBinder.class).invoke(null, scanResult.SSID, null, scanResult.BSSID, scanResult.capabilities, new WhetstoneResultBinder() {
                                /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass3 */

                                public void onResult(WhetstoneResult whetstoneResult) {
                                    super.onResult(whetstoneResult);
                                }
                            });
                        }
                    } else {
                        String O0000Oo = DeviceFactory.O0000Oo(this.O00000oo);
                        try {
                            i = Integer.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).intValue();
                        } catch (Exception unused3) {
                            i = 0;
                        }
                        if (i > 0) {
                            if (!this.O0000OoO || this.O0000o0o || this.O0000o00 || this.O0000oO0 != null) {
                                String str4 = O000000o2.O00000o0;
                                if (O000000o2.O00000o != null) {
                                    str = O000000o2.O00000o;
                                }
                                MiioLocalAPI.O000000o(str4, str, (String) null, O000000o2.O00000oo, O0000Oo, (long) i, new dxc() {
                                    /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass6 */
                                });
                            } else {
                                this.O0000Ooo.getDeclaredMethod("wifiSmartConfigMacAsyncWithUid", String.class, String.class, String.class, String.class, String.class, Integer.TYPE, IBinder.class).invoke(null, scanResult.SSID, null, scanResult.BSSID, scanResult.capabilities, O0000Oo, Integer.valueOf(i), new WhetstoneResultBinder() {
                                    /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass5 */

                                    public void onResult(WhetstoneResult whetstoneResult) {
                                        super.onResult(whetstoneResult);
                                    }
                                });
                            }
                        } else if (!this.O0000OoO || this.O0000o0o || this.O0000o00 || this.O0000oO0 != null) {
                            String str5 = O000000o2.O00000o0;
                            if (O000000o2.O00000o != null) {
                                str = O000000o2.O00000o;
                            }
                            MiioLocalAPI.O000000o(str5, str, (String) null, O000000o2.O00000oo, O0000Oo, new dxc() {
                                /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass8 */
                            });
                        } else {
                            this.O0000Ooo.getDeclaredMethod("wifiSmartConfigMacAsync", String.class, String.class, String.class, String.class, String.class, WhetstoneResultBinder.class).invoke(null, scanResult.SSID, null, scanResult.BSSID, scanResult.capabilities, new WhetstoneResultBinder() {
                                /* class com.xiaomi.smarthome.wificonfig.WifiSettingNormal.AnonymousClass7 */

                                public void onResult(WhetstoneResult whetstoneResult) {
                                    super.onResult(whetstoneResult);
                                }
                            });
                        }
                    }
                    this.O0000o = System.currentTimeMillis();
                    iae.O00000oo.clear();
                }
            }
        }
    }

    public String getConnStatusText() {
        long currentTimeMillis = System.currentTimeMillis() - this.O0000o;
        if (currentTimeMillis < 15000) {
            return getString(R.string.kuailian_sub_main_title_3_1);
        }
        if (currentTimeMillis < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
            return getString(R.string.kuailian_sub_main_title_3_2);
        }
        if (currentTimeMillis < 45000) {
            return getString(R.string.kuailian_sub_main_title_3_3);
        }
        return getString(R.string.kuailian_sub_main_title_3_4);
    }

    public void startWriteLog(boolean z) {
        gsy.O00000o0(LogType.KUAILIAN, "", "kuailian_start - normal");
    }
}
