package _m_j;

import _m_j.gd;
import _m_j.ge;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;

public final class gb {

    /* renamed from: O000000o  reason: collision with root package name */
    static final boolean f17476O000000o = Log.isLoggable("MediaSessionManager", 3);
    private static final Object O00000Oo = new Object();

    interface O00000Oo {
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        O00000Oo f17477O000000o;

        public O000000o(String str, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f17477O000000o = new gd.O000000o(str, i, i2);
            } else {
                this.f17477O000000o = new ge.O000000o(str, i, i2);
            }
        }

        public O000000o(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f17477O000000o = new gd.O000000o(remoteUserInfo);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            return this.f17477O000000o.equals(((O000000o) obj).f17477O000000o);
        }

        public final int hashCode() {
            return this.f17477O000000o.hashCode();
        }
    }
}
