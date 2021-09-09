package _m_j;

import _m_j.gmx;
import _m_j.gnb;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class gmy {

    /* renamed from: O000000o  reason: collision with root package name */
    public gmz f18025O000000o;
    private gpq O00000Oo;
    private Handler O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static gmy f18027O000000o = new gmy((byte) 0);
    }

    /* synthetic */ gmy(byte b) {
        this();
    }

    public final void O000000o(gmz gmz, gna gna) {
        if (gmz != null && gna != null) {
            gmz.O00000Oo = new O00000Oo(this, gna, (byte) 0);
            if (gnl.O00000Oo()) {
                this.O00000o0.obtainMessage(16, gmz).sendToTarget();
            } else {
                O000000o(gmz);
            }
        }
    }

    public final void O000000o(gmz gmz) {
        this.O00000o0.obtainMessage(32, gmz).sendToTarget();
    }

    class O00000Oo implements gna {
        private gna O00000Oo;

        /* synthetic */ O00000Oo(gmy gmy, gna gna, byte b) {
            this(gna);
        }

        public final /* synthetic */ void O000000o(Object obj) {
            gmx gmx = gmx.O000000o.f18024O000000o;
            Message obtainMessage = gmx.f18022O000000o.obtainMessage(17, this.O00000Oo);
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", (BluetoothSearchResult) obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }

        private O00000Oo(gna gna) {
            this.O00000Oo = gna;
        }

        public final void O000000o() {
            gnk.O00000o0("Bluetooth search start");
            gnb gnb = gnb.O000000o.f18037O000000o;
            gnb.f18035O000000o.obtainMessage(64, this.O00000Oo).sendToTarget();
        }

        public final void O00000Oo() {
            gmy.this.f18025O000000o = null;
            gnk.O00000o0("Bluetooth search stop");
            gnb gnb = gnb.O000000o.f18037O000000o;
            gnb.f18035O000000o.obtainMessage(96, this.O00000Oo).sendToTarget();
        }

        public final void O00000o0() {
            gmy.this.f18025O000000o = null;
            gnk.O00000o0("Bluetooth search cancel");
            gnb gnb = gnb.O000000o.f18037O000000o;
            gnb.f18035O000000o.obtainMessage(80, this.O00000Oo).sendToTarget();
        }
    }

    private gmy() {
        this.O00000Oo = new gpq("BluetoothSearch");
        this.O00000Oo.start();
        this.O00000o0 = new Handler(this.O00000Oo.getLooper()) {
            /* class _m_j.gmy.AnonymousClass1 */

            public final void handleMessage(Message message) {
                gmz gmz = (gmz) message.obj;
                int i = message.what;
                if (i == 16) {
                    gmy gmy = gmy.this;
                    if (gmy.f18025O000000o != null) {
                        gmy.f18025O000000o.O000000o();
                    }
                    gmy.f18025O000000o = gmz;
                    gmz gmz2 = gmy.f18025O000000o;
                    if (gmz2.O00000Oo != null) {
                        gmz2.O00000Oo.O000000o();
                    }
                    boolean z = false;
                    boolean z2 = true;
                    boolean z3 = false;
                    for (gnc next : gmz2.f18029O000000o) {
                        if (next.O000000o()) {
                            if (next.O00000Oo == null || next.O00000Oo.length == 0) {
                                z = true;
                                z2 = false;
                            } else {
                                z = true;
                            }
                        } else if (next.O00000Oo()) {
                            z3 = true;
                        } else {
                            throw new IllegalArgumentException("unknown search task type!");
                        }
                    }
                    if (z && !z2) {
                        gmz2.O00000Oo();
                    }
                    if (z3) {
                        gmz2.O00000o0();
                    }
                    gmz2.O000000o(0);
                } else if (i == 32) {
                    gmy gmy2 = gmy.this;
                    if (gmy2.f18025O000000o != null) {
                        if (gmy2.f18025O000000o == gmz || gmz == null) {
                            gmy2.f18025O000000o.O000000o();
                            gmy2.f18025O000000o = null;
                        }
                    } else if (gmz != null) {
                        gmz.O000000o();
                    }
                }
            }
        };
    }
}
