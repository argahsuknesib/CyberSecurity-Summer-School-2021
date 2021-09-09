package _m_j;

import _m_j.gmy;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONObject;

public class fiz {
    private static volatile fiz O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<String, Device> f16432O000000o = new HashMap<>();
    public HashMap<String, Device> O00000Oo = new HashMap<>();
    public fem O00000o;
    public volatile boolean O00000o0;
    public ScheduledExecutorService O00000oO = Executors.newSingleThreadScheduledExecutor();
    public ScheduledFuture O00000oo;
    final gna O0000O0o = new gna() {
        /* class _m_j.fiz.AnonymousClass3 */

        public final void O000000o() {
        }

        public final /* synthetic */ void O000000o(Object obj) {
            BluetoothSearchResult bluetoothSearchResult = (BluetoothSearchResult) obj;
            ffx.O000000o().O000000o(bluetoothSearchResult, new ffy(bluetoothSearchResult) {
                /* class _m_j.fiz.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ BluetoothSearchResult f16434O000000o;

                {
                    this.f16434O000000o = r2;
                }

                public final void O000000o(ffw ffw) {
                    if (ffw != null && !TextUtils.isEmpty(ffw.f16248O000000o)) {
                        BtDevice btDevice = new BtDevice(this.f16434O000000o);
                        btDevice.setModel(ffw.f16248O000000o);
                        btDevice.O000000o(ffw.O00000o0);
                        fiz.O000000o(btDevice);
                        ffr.O000000o(this.f16434O000000o.O000000o(), this.f16434O000000o.O00000o0);
                        fiz.this.O00000Oo(btDevice);
                    }
                }
            });
        }

        public final void O00000Oo() {
            fiz fiz = fiz.this;
            fiz.O00000o0 = false;
            fiz.O00000oo = null;
            gnl.O000000o("action.search.stop");
            if (fiz.O00000o != null) {
                fiz.O00000o.O00000Oo();
            }
            fiz.O00000o = null;
        }

        public final void O00000o0() {
            fiz.this.O00000o();
        }
    };

    private fiz() {
    }

    public static fiz O000000o() {
        if (O0000OOo == null) {
            synchronized (fiz.class) {
                if (O0000OOo == null) {
                    O0000OOo = new fiz();
                }
            }
        }
        return O0000OOo;
    }

    public final void O00000Oo() {
        this.O00000oO.execute(new Runnable() {
            /* class _m_j.fiz.AnonymousClass1 */

            public final void run() {
                if (fiz.this.O00000oo != null && !fiz.this.O00000oo.isDone()) {
                    try {
                        fiz.this.O00000oo.cancel(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fiz.this.O00000o();
                }
                gmy.O000000o.f18027O000000o.O000000o(null);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ffr.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.ffr.O000000o(java.lang.String, int):void
      _m_j.ffr.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile):void
      _m_j.ffr.O000000o(java.lang.String, java.lang.String):void
      _m_j.ffr.O000000o(java.lang.String, byte[]):void
      _m_j.ffr.O000000o(java.lang.String, boolean):void */
    public final void O000000o(ArrayList<BtDevice> arrayList) {
        this.O00000Oo.clear();
        for (BtDevice next : ffr.O00000oO()) {
            if (!arrayList.contains(next)) {
                fea.O000000o(next.getMac(), 0);
                fea.O00000o(next.getMac());
            }
        }
        ArrayList<BtDevice> O00000o2 = ffr.O00000o();
        HashSet hashSet = new HashSet();
        if (O00000o2.size() > 0) {
            for (BtDevice mac : O00000o2) {
                hashSet.add(mac.getMac());
            }
        }
        if (!gpn.O000000o(arrayList)) {
            Iterator<BtDevice> it = arrayList.iterator();
            while (it.hasNext()) {
                BtDevice next2 = it.next();
                String mac2 = next2.getMac();
                this.O00000Oo.put(mac2, next2);
                ffr.O000000o(mac2, next2.getName());
                ffr.O00000oO(mac2, next2.getDid());
                String O0000o0O = ffr.O0000o0O(mac2);
                String str = "";
                if (!TextUtils.equals(next2.getToken(), O0000o0O)) {
                    fte.O00000Oo(String.format("check %s local(empty=%s) and remote(empty=%s) token not equal!", next2.getName(), String.valueOf(TextUtils.isEmpty(O0000o0O)), String.valueOf(TextUtils.isEmpty(next2.getToken()))));
                    ffr.O0000Oo0(mac2, str);
                    ffr.O0000Oo0(mac2, next2.getToken());
                    ffr.O0000Oo(mac2, str);
                    ffr.O0000OoO(mac2, str);
                    ffr.O00000oo(mac2, 0);
                    ffr.O000000o(mac2, true);
                }
                ffr.O0000O0o(mac2, next2.getModel());
                ffr.O0000o00(mac2, next2.getKeyId());
                ffr.O00000Oo(mac2, feb.O00000o0(mac2));
                try {
                    if (!TextUtils.isEmpty(next2.getPropInfo())) {
                        str = new JSONObject(next2.getPropInfo()).optString("smac", str);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ffr.O0000OOo(mac2, str);
                    }
                } catch (Throwable th) {
                    gnk.O000000o(th);
                }
                ffr.O000000o(mac2, next2.getPermitLevel());
                ffr.O00000Oo(mac2, next2.getOwnerName());
                if (!TextUtils.isEmpty(next2.getOwnerId())) {
                    ffr.O00000o(mac2, next2.getOwnerId());
                } else {
                    ffr.O00000o(mac2, fec.O00000o0().O000000o());
                }
                ffr.O00000o(mac2, 2);
                hashSet.remove(mac2);
            }
        }
        if (hashSet.size() > 0) {
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                fte.O00000Oo("BluetoothDeviceSearch set device NOT_BOUNDED: ".concat(String.valueOf(str2)));
                ffr.O00000o(str2, 0);
            }
        }
    }

    public final List<Device> O00000o0() {
        ArrayList<Device> arrayList = new ArrayList<>();
        ArrayList<BtDevice> O00000Oo2 = ffr.O00000Oo();
        synchronized (this.f16432O000000o) {
            for (BtDevice next : O00000Oo2) {
                if (!arrayList.contains(next)) {
                    arrayList.add(next);
                }
            }
        }
        for (Device device : arrayList) {
            ffe.O000000o().O000000o((BtDevice) device);
        }
        return arrayList;
    }

    public static void O000000o(BtDevice btDevice) {
        ffd.O000000o().O000000o(btDevice);
    }

    public final void O00000o() {
        this.O00000o0 = false;
        this.O00000oo = null;
        gnl.O000000o("action.search.cancel");
        fem fem = this.O00000o;
        if (fem != null) {
            fem.O00000o0();
        }
        this.O00000o = null;
    }

    public final void O00000Oo(BtDevice btDevice) {
        ffr.O00000o0(btDevice.getMac(), btDevice.getRssi());
        O00000o0(btDevice);
        fem fem = this.O00000o;
        if (fem != null) {
            fem.O000000o(btDevice);
        }
    }

    private boolean O00000o0(BtDevice btDevice) {
        synchronized (this.f16432O000000o) {
            if (this.f16432O000000o.containsKey(btDevice.getMac())) {
                return false;
            }
            this.f16432O000000o.put(btDevice.getMac(), btDevice);
            return true;
        }
    }

    public class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        SearchRequest f16436O000000o;

        public O000000o(SearchRequest searchRequest) {
            this.f16436O000000o = searchRequest == null ? new SearchRequest.O000000o().O000000o((int) C.MSG_CUSTOM_BASE, (UUID[]) null).O000000o(C.MSG_CUSTOM_BASE).O000000o() : searchRequest;
        }

        public final void run() {
            fiz fiz = fiz.this;
            gnl.O000000o("action.search.start");
            if (fiz.O00000o != null) {
                fiz.O00000o.O000000o();
            }
            fiz fiz2 = fiz.this;
            ArrayList<BluetoothSearchResult> arrayList = new ArrayList<>();
            arrayList.addAll(gnl.O00000oO());
            arrayList.addAll(gnl.O00000oo());
            if (!gpn.O000000o(arrayList)) {
                for (BluetoothSearchResult bluetoothSearchResult : arrayList) {
                    gnk.O00000o0(String.format("Connected Device: %s", bluetoothSearchResult));
                    ffw O000000o2 = ffx.O000000o().O000000o(bluetoothSearchResult, 30000);
                    gnk.O00000o0(String.format("Connected Device recognize Device: %s, result.model: %s, isBleDevice: %b, isBleDeviceConnected: %b", bluetoothSearchResult, O000000o2.f16248O000000o, Boolean.valueOf(bluetoothSearchResult.O00000o == 2), Boolean.valueOf(gnl.O000000o(bluetoothSearchResult.f9076O000000o))));
                    if (!TextUtils.isEmpty(O000000o2.f16248O000000o)) {
                        BtDevice btDevice = new BtDevice(bluetoothSearchResult);
                        btDevice.setModel(O000000o2.f16248O000000o);
                        fiz.O000000o(btDevice);
                        if (ffs.O00000Oo(btDevice.getModel())) {
                            ffr.O00000o(btDevice.getMac(), 1);
                        }
                        fiz2.O00000Oo(btDevice);
                    }
                }
            }
            gmy.O000000o.f18027O000000o.O000000o(this.f16436O000000o.O000000o(), fiz.this.O0000O0o);
        }
    }
}
