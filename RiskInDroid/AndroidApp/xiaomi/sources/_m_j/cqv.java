package _m_j;

import android.content.Context;
import rx.Observable;

public interface cqv {

    public interface O000000o {
        Observable<cqv> O000000o(Context context, boolean z);
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O00000Oo f14261O000000o = new O00000Oo("CONNECTING");
        public static final O00000Oo O00000Oo = new O00000Oo("CONNECTED");
        public static final O00000Oo O00000o = new O00000Oo("DISCONNECTING");
        public static final O00000Oo O00000o0 = new O00000Oo("DISCONNECTED");
        private final String O00000oO;

        private O00000Oo(String str) {
            this.O00000oO = str;
        }

        public final String toString() {
            return "RxBleConnectionState{" + this.O00000oO + '}';
        }
    }
}
