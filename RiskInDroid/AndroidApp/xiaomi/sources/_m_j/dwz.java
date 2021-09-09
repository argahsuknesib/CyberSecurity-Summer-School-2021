package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.library.log.LogType;

public final class dwz {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f15013O000000o = false;
    public String O00000Oo;
    public Runnable O00000o = new Runnable() {
        /* class _m_j.dwz.AnonymousClass1 */

        public final void run() {
            if (dwz.this.f15013O000000o) {
                if (fob.O00000Oo()) {
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(20000, 4).O000000o(), dwz.this.O00000oO);
                } else {
                    CommonApplication.getGlobalHandler().postDelayed(dwz.this.O00000o, 1500);
                }
            }
        }
    };
    public O000000o O00000o0;
    public final fon O00000oO = new fon() {
        /* class _m_j.dwz.AnonymousClass2 */

        public final void O000000o() {
        }

        public final /* synthetic */ void O000000o(Object obj) {
            String[] split;
            BleDevice bleDevice = (BleDevice) obj;
            hzg O000000o2 = hzj.O000000o();
            if (O000000o2 != null) {
                O000000o2.logD("UwbBleDeviceFinder", "onDeviceFounded " + bleDevice.getName() + "," + bleDevice.getMac() + ",mMacSuffix=" + dwz.this.O00000Oo);
            } else {
                LogType logType = LogType.LOG_UWB;
                gsy.O00000o0(logType, "UwbBleDeviceFinder", "onDeviceFounded " + bleDevice.getName() + "," + bleDevice.getMac() + ",mMacSuffix=" + dwz.this.O00000Oo);
            }
            if (dwz.this.f15013O000000o && !TextUtils.isEmpty(bleDevice.mac) && (split = bleDevice.mac.split(":")) != null && split.length >= 2 && bleDevice != null && !TextUtils.isEmpty(bleDevice.mac)) {
                if ((split[split.length - 2] + split[split.length - 1]).equalsIgnoreCase(dwz.this.O00000Oo)) {
                    dwz.this.f15013O000000o = false;
                    fpo.O00000Oo();
                    dwz.this.O00000o0.O000000o(bleDevice);
                }
            }
        }

        public final void O00000Oo() {
            if (dwz.this.f15013O000000o) {
                dwz.this.f15013O000000o = false;
            }
        }

        public final void O00000o0() {
            if (dwz.this.f15013O000000o) {
                dwz.this.f15013O000000o = false;
            }
        }
    };

    public interface O000000o {
        void O000000o(BleDevice bleDevice);
    }

    public final void O000000o() {
        fte.O00000Oo("UwbBleDeviceFinder stopFindDevice, mIsFinding = " + this.f15013O000000o);
        if (this.f15013O000000o) {
            this.f15013O000000o = false;
            CommonApplication.getGlobalHandler().removeCallbacks(this.O00000o);
            fpo.O00000Oo();
        }
    }

    public final void O000000o(String str, O000000o o000000o) {
        fte.O00000Oo("UwbBleDeviceFinder startFindDevice");
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo("UwbBleDeviceFinder macSuffix is empty");
            return;
        }
        this.f15013O000000o = true;
        this.O00000Oo = str;
        this.O00000o0 = o000000o;
        if (fob.O00000Oo()) {
            fob.O000000o(new SearchRequest.O000000o().O00000Oo(20000, 4).O000000o(), this.O00000oO);
            return;
        }
        fob.O00000o0();
        CommonApplication.getGlobalHandler().removeCallbacks(this.O00000o);
        CommonApplication.getGlobalHandler().postDelayed(this.O00000o, 1500);
    }
}
