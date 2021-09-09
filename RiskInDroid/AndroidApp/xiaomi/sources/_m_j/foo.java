package _m_j;

import com.xiaomi.smarthome.device.BleDevice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class foo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static O00000Oo f16767O000000o = new O00000Oo() {
        /* class _m_j.foo.AnonymousClass1 */

        public final int O000000o(O00000o0 o00000o0) {
            super.O00000Oo(o00000o0);
            for (int i = this.O00000Oo; i < this.O00000o0; i++) {
                this.O00000oO += O000000o(i);
            }
            return this.O00000oO / this.O00000o;
        }
    };
    private static HashMap<BleDevice, O00000o0> O00000Oo = new HashMap<>();
    private static O00000Oo O00000o = new O00000Oo() {
        /* class _m_j.foo.AnonymousClass3 */

        public final int O000000o(O00000o0 o00000o0) {
            super.O00000Oo(o00000o0);
            for (int i = this.O00000Oo; i < this.O00000o0; i++) {
                this.O00000oO += O000000o(i) * O000000o(i);
            }
            return ((int) Math.sqrt((double) this.O00000oO)) * -1;
        }
    };
    private static O00000Oo O00000o0 = new O00000Oo() {
        /* class _m_j.foo.AnonymousClass2 */

        public final int O000000o(O00000o0 o00000o0) {
            super.O00000Oo(o00000o0);
            return O000000o((this.O00000Oo + this.O00000o0) >>> 1);
        }
    };

    interface O000000o {
        int O000000o(O00000o0 o00000o0);
    }

    public static void O000000o(BleDevice bleDevice) {
        gnk.O00000oO(String.format("addRssiRecord for %s: rssi = %d", bleDevice.mac, Integer.valueOf(bleDevice.rssi)));
        O00000o0 o00000o0 = O00000Oo.get(bleDevice);
        if (o00000o0 == null) {
            o00000o0 = new O00000o0(bleDevice);
            O00000Oo.put(bleDevice, o00000o0);
        }
        int i = bleDevice.rssi;
        if (o00000o0.O00000o < 64) {
            int[] iArr = o00000o0.O00000oO;
            int i2 = o00000o0.O00000o;
            o00000o0.O00000o = i2 + 1;
            iArr[i2] = i;
        }
    }

    public static O00000o0 O00000Oo() {
        O00000o0 o00000o0 = null;
        int i = Integer.MIN_VALUE;
        for (Map.Entry next : O00000Oo.entrySet()) {
            O00000o0 o00000o02 = (O00000o0) next.getValue();
            o00000o02.O00000o0 = O00000o0.f16769O000000o.O000000o(o00000o02);
            int i2 = o00000o02.O00000o0;
            gnk.O00000o0(String.format("Rssi Avg for %s: %d", next.getKey(), Integer.valueOf(i2)));
            if (i2 > i) {
                o00000o0 = o00000o02;
                i = i2;
            }
        }
        return o00000o0;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final O00000Oo f16769O000000o = foo.f16767O000000o;
        public BleDevice O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int[] O00000oO = new int[64];

        public O00000o0(BleDevice bleDevice) {
            this.O00000Oo = bleDevice;
        }

        public final String toString() {
            return "RssiHolder{mac=" + this.O00000Oo.mac + ", avg=" + this.O00000o0 + '}';
        }
    }

    static abstract class O00000Oo implements O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        O00000o0 f16768O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(O00000o0 o00000o0) {
            this.f16768O000000o = o00000o0;
            this.O00000oO = 0;
            this.O00000o = o00000o0.O00000o;
            Arrays.sort(o00000o0.O00000oO, 0, o00000o0.O00000o);
            this.O00000Oo = (int) Math.floor((double) (((float) this.O00000o) * 0.1f));
            this.O00000o0 = (int) Math.ceil((double) (((float) this.O00000o) * 0.9f));
            this.O00000o = this.O00000o0 - this.O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final int O000000o(int i) {
            return this.f16768O000000o.O00000oO[i];
        }
    }

    public static void O000000o() {
        HashMap<BleDevice, O00000o0> hashMap = O00000Oo;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
