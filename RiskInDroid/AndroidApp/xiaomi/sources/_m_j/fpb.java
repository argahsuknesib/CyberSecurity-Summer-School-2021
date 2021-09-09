package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;

public final class fpb {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f16794O000000o = false;
    public String O00000Oo;
    public Runnable O00000o = new Runnable() {
        /* class _m_j.fpb.AnonymousClass1 */

        public final void run() {
            if (fpb.this.f16794O000000o) {
                if (fob.O00000Oo()) {
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(8000, 2).O000000o(), fpb.this.O00000oO);
                } else {
                    CommonApplication.getGlobalHandler().postDelayed(fpb.this.O00000o, 1500);
                }
            }
        }
    };
    public O000000o O00000o0;
    public final fon O00000oO = new fon() {
        /* class _m_j.fpb.AnonymousClass2 */

        public final void O000000o() {
        }

        public final /* synthetic */ void O000000o(Object obj) {
            BleDevice bleDevice = (BleDevice) obj;
            if (fpb.this.f16794O000000o && bleDevice != null && TextUtils.equals(bleDevice.mac, fpb.this.O00000Oo)) {
                fpb.this.f16794O000000o = false;
                fpo.O00000Oo();
                fpb.this.O00000o0.O000000o();
            }
        }

        public final void O00000Oo() {
            if (fpb.this.f16794O000000o) {
                fpb fpb = fpb.this;
                fpb.f16794O000000o = false;
                fpb.O00000o0.O00000Oo();
            }
        }

        public final void O00000o0() {
            if (fpb.this.f16794O000000o) {
                fpb fpb = fpb.this;
                fpb.f16794O000000o = false;
                fpb.O00000o0.O00000Oo();
            }
        }
    };

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public final void O000000o() {
        fte.O00000Oo("BleDeviceFinder stopFindDevice, mIsFinding = " + this.f16794O000000o);
        if (this.f16794O000000o) {
            this.f16794O000000o = false;
            CommonApplication.getGlobalHandler().removeCallbacks(this.O00000o);
            fpo.O00000Oo();
        }
    }

    public final void O000000o(String str, O000000o o000000o) {
        fte.O00000Oo("BleDeviceFinder startFindDevice");
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo("BleDeviceFinder mac is empty");
        } else if (o000000o == null) {
            fte.O00000Oo("BleDeviceFinder callback is empty");
        } else {
            this.f16794O000000o = true;
            this.O00000Oo = str;
            this.O00000o0 = o000000o;
            if (fob.O00000Oo()) {
                fob.O000000o(new SearchRequest.O000000o().O00000Oo(8000, 2).O000000o(), this.O00000oO);
                return;
            }
            fob.O00000o0();
            CommonApplication.getGlobalHandler().removeCallbacks(this.O00000o);
            CommonApplication.getGlobalHandler().postDelayed(this.O00000o, 1500);
        }
    }
}
