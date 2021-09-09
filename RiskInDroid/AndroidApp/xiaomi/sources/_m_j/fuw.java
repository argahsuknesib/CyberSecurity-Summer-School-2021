package _m_j;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.log.HookHelper;
import java.util.ArrayList;
import java.util.List;

public class fuw {
    private static volatile fuw O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public AMapLocationClient f17223O000000o;
    public boolean O00000Oo = false;
    public List<O000000o> O00000o = new ArrayList();
    public Object O00000o0 = new Object();
    private AMapLocationClientOption O00000oO = null;

    public interface O000000o {
        void O000000o();

        void O000000o(AMapLocation aMapLocation);
    }

    private fuw() {
    }

    public final AMapLocationClientOption O000000o(String str) {
        AMapLocationClientOption.AMapLocationMode aMapLocationMode;
        AMapLocationClientOption aMapLocationClientOption = this.O00000oO;
        if (aMapLocationClientOption != null) {
            return aMapLocationClientOption;
        }
        this.O00000oO = new AMapLocationClientOption();
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1074341483) {
            if (hashCode == 107348 && str.equals("low")) {
                c = 0;
            }
        } else if (str.equals("middle")) {
            c = 1;
        }
        if (c == 0) {
            aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
        } else if (c != 1) {
            aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        } else {
            aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Device_Sensors;
        }
        this.O00000oO.setLocationMode(aMapLocationMode);
        this.O00000oO.setNeedAddress(true);
        this.O00000oO.setOnceLocation(true);
        this.O00000oO.setWifiActiveScan(true);
        this.O00000oO.setMockEnable(false);
        return this.O00000oO;
    }

    public static fuw O000000o() {
        if (O00000oo == null) {
            synchronized (fuw.class) {
                if (O00000oo == null) {
                    O00000oo = new fuw();
                }
            }
        }
        return O00000oo;
    }

    public final void O000000o(O000000o o000000o, final String str) {
        if (HookHelper.interceptLocationRequestOnBackground() || o000000o == null) {
            return;
        }
        if (ftn.O0000O0o(CommonApplication.getAppContext())) {
            o000000o.O000000o();
            return;
        }
        synchronized (this.O00000o0) {
            this.O00000o.add(o000000o);
            if (!this.O00000Oo) {
                if (this.f17223O000000o != null) {
                    this.f17223O000000o.onDestroy();
                }
                this.f17223O000000o = new AMapLocationClient(CommonApplication.getAppContext());
                this.f17223O000000o.setLocationOption(O000000o(str));
                this.O00000Oo = true;
                this.f17223O000000o.setLocationListener(new AMapLocationListener() {
                    /* class _m_j.fuw.AnonymousClass1 */

                    public final void onLocationChanged(AMapLocation aMapLocation) {
                        ArrayList<O000000o> arrayList = new ArrayList<>();
                        synchronized (fuw.this.O00000o0) {
                            arrayList.addAll(fuw.this.O00000o);
                            fuw.this.O00000o.clear();
                            if (fuw.this.O000000o(str).isOnceLocation()) {
                                fuw.this.O00000Oo();
                                fuw.this.f17223O000000o.onDestroy();
                                fuw.this.f17223O000000o = null;
                            }
                            fuw.this.O00000Oo = false;
                        }
                        if (aMapLocation != null) {
                            for (O000000o O000000o2 : arrayList) {
                                O000000o2.O000000o(aMapLocation);
                            }
                        } else {
                            gsy.O000000o(5, "AMapLocationManager", "location Error, ErrCode:" + aMapLocation.getErrorCode() + ", errInfo:" + aMapLocation.getErrorInfo());
                            for (O000000o O000000o3 : arrayList) {
                                O000000o3.O000000o();
                            }
                        }
                        arrayList.clear();
                    }
                });
                this.f17223O000000o.startLocation();
            }
        }
    }

    public final void O00000Oo() {
        AMapLocationClient aMapLocationClient = this.f17223O000000o;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
