package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class gmz {

    /* renamed from: O000000o  reason: collision with root package name */
    List<gnc> f18029O000000o = new ArrayList();
    gna O00000Oo;
    private Handler O00000o;
    gnc O00000o0;

    public final void O000000o(int i) {
        if (this.O00000o == null) {
            this.O00000o = new Handler(Looper.myLooper()) {
                /* class _m_j.gmz.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (message.what == 17) {
                        gmz gmz = gmz.this;
                        if (gmz.f18029O000000o.size() > 0) {
                            gmz.O00000o0 = gmz.f18029O000000o.remove(0);
                            gmz.O00000o0.O000000o(new O000000o(gmz.O00000o0));
                            return;
                        }
                        gmz.O00000o0 = null;
                        if (gmz.O00000Oo != null) {
                            gmz.O00000Oo.O00000Oo();
                        }
                    }
                }
            };
        }
        this.O00000o.sendMessageDelayed(this.O00000o.obtainMessage(17), (long) i);
    }

    class O000000o implements gna {

        /* renamed from: O000000o  reason: collision with root package name */
        gnc f18031O000000o;

        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
            gmz.this.O000000o((BluetoothSearchResult) obj);
        }

        O000000o(gnc gnc) {
            this.f18031O000000o = gnc;
        }

        public final void O000000o() {
            gnk.O00000o0(String.format("%s onSearchStarted", this.f18031O000000o.toString()));
        }

        public final void O00000Oo() {
            gnk.O00000o0(String.format("%s onSearchStopped", this.f18031O000000o.toString()));
            gmz.this.O000000o(100);
        }

        public final void O00000o0() {
            gnk.O00000o0(String.format("%s onSearchCanceled", this.f18031O000000o.toString()));
        }
    }

    public final void O000000o() {
        gnc gnc = this.O00000o0;
        if (gnc != null) {
            gnc.O00000o();
            this.O00000o0 = null;
        }
        this.f18029O000000o.clear();
        gna gna = this.O00000Oo;
        if (gna != null) {
            gna.O00000o0();
        }
        this.O00000Oo = null;
    }

    /* access modifiers changed from: package-private */
    public void O00000Oo() {
        gnk.O00000o0(String.format("scan for connected le devices", new Object[0]));
        for (BluetoothSearchResult O000000o2 : gnl.O00000oO()) {
            O000000o(O000000o2);
        }
    }

    /* access modifiers changed from: package-private */
    public void O00000o0() {
        gnk.O00000o0(String.format("scan for bonded classic devices", new Object[0]));
        for (BluetoothSearchResult O000000o2 : gnl.O00000oo()) {
            O000000o(O000000o2);
        }
    }

    public final void O000000o(BluetoothSearchResult bluetoothSearchResult) {
        gna gna = this.O00000Oo;
        if (gna != null) {
            gna.O000000o(bluetoothSearchResult);
        }
    }

    public final void O000000o(List<gnc> list) {
        this.f18029O000000o.clear();
        this.f18029O000000o.addAll(list);
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private List<gnc> f18032O000000o = new ArrayList();
        private gna O00000Oo;

        private void O000000o(gnc gnc) {
            if (gnc instanceof gni) {
                if (gnl.O000000o()) {
                    this.f18032O000000o.add(gnc);
                }
            } else if (gnc instanceof gnf) {
                this.f18032O000000o.add(gnc);
            }
        }

        public final O00000Oo O000000o(int i, UUID[] uuidArr) {
            gni gni = new gni();
            gni.f18038O000000o = i;
            gni.O00000Oo = uuidArr;
            O000000o(gni);
            return this;
        }

        public final O00000Oo O000000o(int i, int i2) {
            return O00000Oo(i, i2);
        }

        private O00000Oo O00000Oo(int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                O000000o(i, (UUID[]) null);
            }
            return this;
        }

        public final O00000Oo O000000o(int i) {
            gnf gnf = new gnf();
            gnf.f18038O000000o = i;
            O000000o(gnf);
            return this;
        }

        public final gmz O000000o() {
            gmz gmz = new gmz();
            gmz.O000000o(this.f18032O000000o);
            gmz.O00000Oo = this.O00000Oo;
            return gmz;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (gnc gnc : this.f18029O000000o) {
            sb.append(gnc.toString() + ", ");
        }
        return sb.toString();
    }
}
