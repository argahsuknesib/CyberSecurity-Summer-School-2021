package _m_j;

import android.os.Build;
import com.otaliastudios.cameraview.Facing;
import com.otaliastudios.cameraview.Flash;
import com.otaliastudios.cameraview.Hdr;
import com.otaliastudios.cameraview.WhiteBalance;
import java.util.HashMap;

abstract class cpx {
    /* access modifiers changed from: package-private */
    public abstract <T> Flash O000000o(Object obj);

    /* access modifiers changed from: package-private */
    public abstract <T> T O000000o(Facing facing);

    /* access modifiers changed from: package-private */
    public abstract <T> T O000000o(Flash flash);

    /* access modifiers changed from: package-private */
    public abstract <T> T O000000o(Hdr hdr);

    /* access modifiers changed from: package-private */
    public abstract <T> T O000000o(WhiteBalance whiteBalance);

    /* access modifiers changed from: package-private */
    public abstract <T> Facing O00000Oo(T t);

    /* access modifiers changed from: package-private */
    public abstract <T> Hdr O00000o(T t);

    /* access modifiers changed from: package-private */
    public abstract <T> WhiteBalance O00000o0(T t);

    cpx() {
    }

    static class O000000o extends cpx {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final HashMap<Flash, String> f14219O000000o = new HashMap<>();
        private static final HashMap<WhiteBalance, String> O00000Oo = new HashMap<>();
        private static final HashMap<Hdr, String> O00000o = new HashMap<>();
        private static final HashMap<Facing, Integer> O00000o0 = new HashMap<>();

        O000000o() {
        }

        static {
            f14219O000000o.put(Flash.OFF, "off");
            f14219O000000o.put(Flash.ON, "on");
            f14219O000000o.put(Flash.AUTO, "auto");
            f14219O000000o.put(Flash.TORCH, "torch");
            O00000o0.put(Facing.BACK, 0);
            O00000o0.put(Facing.FRONT, 1);
            O00000Oo.put(WhiteBalance.AUTO, "auto");
            O00000Oo.put(WhiteBalance.INCANDESCENT, "incandescent");
            O00000Oo.put(WhiteBalance.FLUORESCENT, "fluorescent");
            O00000Oo.put(WhiteBalance.DAYLIGHT, "daylight");
            O00000Oo.put(WhiteBalance.CLOUDY, "cloudy-daylight");
            O00000o.put(Hdr.OFF, "auto");
            if (Build.VERSION.SDK_INT >= 17) {
                O00000o.put(Hdr.ON, "hdr");
            } else {
                O00000o.put(Hdr.ON, "hdr");
            }
        }

        /* access modifiers changed from: package-private */
        public final <T> T O000000o(Flash flash) {
            return f14219O000000o.get(flash);
        }

        /* access modifiers changed from: package-private */
        public final <T> T O000000o(Facing facing) {
            return O00000o0.get(facing);
        }

        /* access modifiers changed from: package-private */
        public final <T> T O000000o(WhiteBalance whiteBalance) {
            return O00000Oo.get(whiteBalance);
        }

        /* access modifiers changed from: package-private */
        public final <T> T O000000o(Hdr hdr) {
            return O00000o.get(hdr);
        }

        private static <T> T O000000o(HashMap<T, ?> hashMap, Object obj) {
            for (T next : hashMap.keySet()) {
                if (hashMap.get(next).equals(obj)) {
                    return next;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final <T> Flash O000000o(T t) {
            return (Flash) O000000o(f14219O000000o, t);
        }

        /* access modifiers changed from: package-private */
        public final <T> Facing O00000Oo(T t) {
            return (Facing) O000000o(O00000o0, t);
        }

        /* access modifiers changed from: package-private */
        public final <T> WhiteBalance O00000o0(T t) {
            return (WhiteBalance) O000000o(O00000Oo, t);
        }

        /* access modifiers changed from: package-private */
        public final <T> Hdr O00000o(T t) {
            return (Hdr) O000000o(O00000o, t);
        }
    }
}
