package _m_j;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.inuker.bluetooth.library.search.SearchTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class bkq implements Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    List<bkr> f13020O000000o = new ArrayList();
    bkw O00000Oo;
    private bkr O00000o;
    public Handler O00000o0;

    public bkq(SearchRequest searchRequest) {
        for (SearchTask bkr : searchRequest.f4494O000000o) {
            this.f13020O000000o.add(new bkr(bkr));
        }
        this.O00000o0 = new Handler(Looper.myLooper(), this);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 17) {
            if (i != 18) {
                return true;
            }
            SearchResult searchResult = (SearchResult) message.obj;
            bkw bkw = this.O00000Oo;
            if (bkw == null) {
                return true;
            }
            bkw.O000000o(searchResult);
            return true;
        } else if (this.f13020O000000o.size() > 0) {
            this.O00000o = this.f13020O000000o.remove(0);
            bkr bkr = this.O00000o;
            bkr.O000000o(new O000000o(bkr));
            return true;
        } else {
            this.O00000o = null;
            bkw bkw2 = this.O00000Oo;
            if (bkw2 == null) {
                return true;
            }
            bkw2.O00000Oo();
            return true;
        }
    }

    public final void O000000o() {
        bkr bkr = this.O00000o;
        if (bkr != null) {
            bkr.O00000o0();
            this.O00000o = null;
        }
        this.f13020O000000o.clear();
        bkw bkw = this.O00000Oo;
        if (bkw != null) {
            bkw.O00000o0();
        }
        this.O00000Oo = null;
    }

    public final void O000000o(SearchResult searchResult) {
        this.O00000o0.obtainMessage(18, searchResult).sendToTarget();
    }

    class O000000o implements bkw {

        /* renamed from: O000000o  reason: collision with root package name */
        bkr f13021O000000o;

        O000000o(bkr bkr) {
            this.f13021O000000o = bkr;
        }

        public final void O000000o() {
            bky.O00000Oo(String.format("%s onSearchStarted", this.f13021O000000o));
        }

        public final void O000000o(SearchResult searchResult) {
            bkq.this.O000000o(searchResult);
        }

        public final void O00000Oo() {
            bky.O00000Oo(String.format("%s onSearchStopped", this.f13021O000000o));
            bkq.this.O00000o0.sendEmptyMessageDelayed(17, 100);
        }

        public final void O00000o0() {
            bky.O00000Oo(String.format("%s onSearchCanceled", this.f13021O000000o));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (bkr bkr : this.f13020O000000o) {
            sb.append(bkr.toString() + ", ");
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        BluetoothManager bluetoothManager;
        ArrayList<BluetoothDevice> arrayList = new ArrayList<>();
        if (bkz.O000000o()) {
            if (bkz.f13029O000000o == null) {
                bkz.f13029O000000o = (BluetoothManager) bij.f13001O000000o.getSystemService("bluetooth");
            }
            bluetoothManager = bkz.f13029O000000o;
        } else {
            bluetoothManager = null;
        }
        if (bluetoothManager != null) {
            arrayList.addAll(bluetoothManager.getConnectedDevices(7));
        }
        for (BluetoothDevice searchResult : arrayList) {
            O000000o(new SearchResult(searchResult));
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        Set<BluetoothDevice> bondedDevices;
        BluetoothAdapter O00000o02 = bkz.O00000o0();
        ArrayList<BluetoothDevice> arrayList = new ArrayList<>();
        if (!(O00000o02 == null || (bondedDevices = O00000o02.getBondedDevices()) == null)) {
            arrayList.addAll(bondedDevices);
        }
        for (BluetoothDevice searchResult : arrayList) {
            O000000o(new SearchResult(searchResult));
        }
    }
}
