package androidx.versionedparcelable;

import _m_j.jx;
import _m_j.jy;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
        /* class androidx.versionedparcelable.ParcelImpl.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelImpl[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private final jy f3025O000000o;

    public int describeContents() {
        return 0;
    }

    protected ParcelImpl(Parcel parcel) {
        this.f3025O000000o = new jx(parcel).O0000Oo0();
    }

    public void writeToParcel(Parcel parcel, int i) {
        new jx(parcel).O00000Oo(this.f3025O000000o);
    }
}
