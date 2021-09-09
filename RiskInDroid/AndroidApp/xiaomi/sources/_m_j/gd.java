package _m_j;

import _m_j.gb;
import android.media.session.MediaSessionManager;

final class gd extends gc {

    static final class O000000o implements gb.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f17548O000000o;

        O000000o(String str, int i, int i2) {
            this.f17548O000000o = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        O000000o(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f17548O000000o = remoteUserInfo;
        }

        public final int hashCode() {
            return bd.O000000o(this.f17548O000000o);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            return this.f17548O000000o.equals(((O000000o) obj).f17548O000000o);
        }
    }
}
