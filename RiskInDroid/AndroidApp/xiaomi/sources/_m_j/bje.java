package _m_j;

import android.os.Message;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.model.BleGattProfile;

public final class bje extends bjl implements bjb {
    private BleConnectOptions O0000Oo;
    private int O0000OoO;
    private int O0000Ooo;

    public bje(BleConnectOptions bleConnectOptions, bjr bjr) {
        super(bjr);
        this.O0000Oo = bleConnectOptions == null ? new BleConnectOptions(new BleConnectOptions.O000000o()) : bleConnectOptions;
    }

    public final void O0000Oo0() {
        O0000o0();
    }

    private void O0000o0() {
        this.O00000oo.removeCallbacksAndMessages(null);
        this.O0000Ooo = 0;
        int O00000oO = O00000oO();
        if (O00000oO != 0) {
            if (O00000oO == 2) {
                O0000oO();
            } else if (O00000oO == 19) {
                O0000oOO();
            }
        } else if (!O0000o0O()) {
            O00000o0();
        } else {
            this.O00000oo.sendEmptyMessageDelayed(3, (long) this.O0000Oo.O00000o0);
        }
    }

    private boolean O0000o0O() {
        this.O0000OoO++;
        return O00000Oo();
    }

    private boolean O0000o0o() {
        this.O0000Ooo++;
        return O00000o();
    }

    private void O0000o() {
        if (this.O0000OoO < this.O0000Oo.f4487O000000o + 1) {
            O00000Oo(String.format("retry connect later", new Object[0]));
            this.O00000oo.removeCallbacksAndMessages(null);
            this.O00000oo.sendEmptyMessageDelayed(1, 1000);
            return;
        }
        O00000o0(-1);
    }

    private void O0000oO0() {
        bky.O00000Oo(String.format("onServiceDiscoverFailed", new Object[0]));
        O00000oo();
        this.O00000oo.sendEmptyMessage(5);
    }

    private void O0000oO() {
        bky.O00000Oo(String.format("processDiscoverService, status = %s", O0000Oo()));
        int O00000oO = O00000oO();
        if (O00000oO == 0) {
            O0000o();
        } else if (O00000oO != 2) {
            if (O00000oO == 19) {
                O0000oOO();
            }
        } else if (!O0000o0o()) {
            O0000oO0();
        } else {
            this.O00000oo.sendEmptyMessageDelayed(4, (long) this.O0000Oo.O00000o);
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            O0000o0();
        } else if (i == 2) {
            O0000oO();
        } else if (i == 3) {
            O00000Oo(String.format("connect timeout", new Object[0]));
            this.O00000oo.removeCallbacksAndMessages(null);
            O00000o0();
        } else if (i == 4) {
            O00000Oo(String.format("service discover timeout", new Object[0]));
            this.O00000oo.removeCallbacksAndMessages(null);
            O00000o0();
        } else if (i == 5) {
            if (this.O0000Ooo < this.O0000Oo.O00000Oo + 1) {
                O00000Oo(String.format("retry discover service later", new Object[0]));
                this.O00000oo.removeCallbacksAndMessages(null);
                this.O00000oo.sendEmptyMessageDelayed(2, 1000);
            } else {
                O00000o0();
            }
        }
        return super.handleMessage(message);
    }

    public final String toString() {
        return "BleConnectRequest{options=" + this.O0000Oo + '}';
    }

    public final void O000000o(boolean z) {
        O000000o();
        this.O00000oo.removeMessages(3);
        if (z) {
            this.O00000oo.sendEmptyMessageDelayed(2, 300);
            return;
        }
        this.O00000oo.removeCallbacksAndMessages(null);
        O0000o();
    }

    public final void O000000o(int i) {
        O000000o();
        this.O00000oo.removeMessages(4);
        if (i == 0) {
            O0000oOO();
        } else {
            O0000oO0();
        }
    }

    private void O0000oOO() {
        BleGattProfile O0000OOo = O0000OOo();
        if (O0000OOo != null) {
            O000000o("extra.gatt.profile", O0000OOo);
        }
        O00000o0(0);
    }
}
