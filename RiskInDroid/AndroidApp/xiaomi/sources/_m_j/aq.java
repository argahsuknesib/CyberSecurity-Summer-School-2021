package _m_j;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class aq {
    @Deprecated
    public static <T> Parcelable.Creator<T> O000000o(ar<T> arVar) {
        return new O000000o(arVar);
    }

    static class O000000o<T> implements Parcelable.ClassLoaderCreator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ar<T> f12518O000000o;

        O000000o(ar<T> arVar) {
            this.f12518O000000o = arVar;
        }

        public final T createFromParcel(Parcel parcel) {
            return this.f12518O000000o.createFromParcel(parcel, null);
        }

        public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f12518O000000o.createFromParcel(parcel, classLoader);
        }

        public final T[] newArray(int i) {
            return this.f12518O000000o.newArray(i);
        }
    }
}
