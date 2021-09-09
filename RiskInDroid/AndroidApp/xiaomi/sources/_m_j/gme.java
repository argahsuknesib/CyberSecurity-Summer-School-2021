package _m_j;

import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattService;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.ServiceDiscoverListener;

public final class gme extends gmj implements ServiceDiscoverListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private BleConnectOptions f18014O000000o;
    private int O00000Oo;
    private int O00000o0;

    public gme(BleConnectOptions bleConnectOptions, gma gma) {
        super(gma);
        this.f18014O000000o = bleConnectOptions == null ? new BleConnectOptions.O000000o().O000000o() : bleConnectOptions;
    }

    public final void O000000o() {
        O00000Oo();
    }

    private void O00000Oo() {
        this.O0000Ooo.removeCallbacksAndMessages(null);
        this.O00000o0 = 0;
        int currentStatus = getCurrentStatus();
        if (currentStatus != 0) {
            if (currentStatus == 2) {
                O0000Oo0();
            } else if (currentStatus == 19) {
                O0000Oo();
            }
        } else if (!O00000oO()) {
            O00000Oo(-6);
            closeGatt();
        } else {
            this.O0000Ooo.sendEmptyMessageDelayed(3, (long) this.f18014O000000o.O00000o0);
        }
    }

    private boolean O00000oO() {
        this.O00000Oo++;
        return openGatt();
    }

    private boolean O00000oo() {
        this.O00000o0++;
        return discoverService();
    }

    private boolean O0000O0o() {
        if (this.O00000Oo < this.f18014O000000o.f9072O000000o + 1) {
            O00000Oo(String.format("retry connect later", new Object[0]));
            this.O0000Ooo.removeCallbacksAndMessages(null);
            this.O0000Ooo.sendEmptyMessageDelayed(1, 2000);
            return true;
        }
        O00000Oo(-6);
        return false;
    }

    private void O0000OOo() {
        gnk.O00000o0(String.format("onServiceDiscoverFailed", new Object[0]));
        refreshDeviceCache();
        this.O0000Ooo.sendEmptyMessageDelayed(5, 2000);
    }

    private void O0000Oo0() {
        gnk.O00000o0(String.format("processDiscoverService, status = %s", gld.O000000o(getCurrentStatus())));
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            O0000O0o();
        } else if (currentStatus != 2) {
            if (currentStatus == 19) {
                O0000Oo();
            }
        } else if (!O00000oo()) {
            O0000OOo();
        } else {
            this.O0000Ooo.sendEmptyMessageDelayed(4, (long) this.f18014O000000o.O00000o);
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            O00000Oo();
        } else if (i == 2) {
            O0000Oo0();
        } else if (i == 3) {
            O00000Oo(String.format("connect timeout", new Object[0]));
            O00000Oo(-6);
            closeGatt();
        } else if (i == 4) {
            O00000Oo(String.format("service discover timeout", new Object[0]));
            O00000Oo(-6);
            closeGatt();
        } else if (i == 5) {
            if (this.O00000o0 < this.f18014O000000o.O00000Oo + 1) {
                O00000Oo(String.format("retry discover service later", new Object[0]));
                this.O0000Ooo.removeCallbacksAndMessages(null);
                this.O0000Ooo.sendEmptyMessageDelayed(2, 2000);
            } else {
                O00000Oo(-6);
                closeGatt();
            }
        }
        return super.handleMessage(message);
    }

    public final String toString() {
        return "BleConnectRequest{options=" + this.f18014O000000o + '}';
    }

    public final boolean onConnectStatusChanged(boolean z) {
        checkRuntime();
        this.O0000Ooo.removeMessages(3);
        if (z) {
            this.O0000Ooo.sendEmptyMessageDelayed(2, 300);
            return true;
        }
        this.O0000Ooo.removeCallbacksAndMessages(null);
        if (!O0000O0o()) {
            return true;
        }
        return false;
    }

    public final void onServicesDiscovered(int i, BleGattProfile bleGattProfile) {
        BleGattService O000000o2;
        checkRuntime();
        this.O0000Ooo.removeMessages(4);
        if (i == 0) {
            boolean z = true;
            if (bleGattProfile == null || gpn.O000000o(bleGattProfile.O000000o()) || ((O000000o2 = bleGattProfile.O000000o(glb.f17954O000000o)) != null && gpn.O000000o(O000000o2.O000000o()))) {
                z = false;
            }
            if (!z) {
                gnk.O00000Oo(String.format("checkService return false", new Object[0]));
            } else {
                O0000Oo();
                return;
            }
        }
        O0000OOo();
    }

    private void O0000Oo() {
        BleGattProfile gattProfile = getGattProfile();
        if (gattProfile != null) {
            O000000o("key_gatt_profile", gattProfile);
        }
        O00000Oo(0);
    }
}
