package _m_j;

import android.location.Location;
import com.qti.location.sdk.IZatDBCommon;
import com.qti.location.sdk.IZatStaleDataException;
import com.qti.location.sdk.IZatWWANDBReceiver;

public abstract class cst {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O00000Oo f14316O000000o;

    public interface O00000Oo {
    }

    public static class O000000o extends IZatWWANDBReceiver.IZatBSLocationDataBase {
        private long O00000oo;

        public O000000o(IZatDBCommon.O00000Oo o00000Oo, Location location, IZatWWANDBReceiver.IZatBSLocationDataBase.IZatReliablityTypes iZatReliablityTypes, IZatWWANDBReceiver.IZatBSLocationDataBase.IZatReliablityTypes iZatReliablityTypes2) {
            super(o00000Oo, location, iZatReliablityTypes, iZatReliablityTypes2);
        }

        public final long O000000o() {
            if ((this.O00000oO & 16) != 0) {
                return this.O00000oo;
            }
            throw new IZatStaleDataException("Timestamp information is not valid");
        }

        public final void O000000o(long j) {
            this.O00000oo = j;
            this.O00000oO |= 16;
        }
    }
}
