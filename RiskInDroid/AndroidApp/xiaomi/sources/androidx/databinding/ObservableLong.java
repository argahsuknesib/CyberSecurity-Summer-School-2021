package androidx.databinding;

import _m_j.dj;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableLong extends dj implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new Parcelable.Creator<ObservableLong>() {
        /* class androidx.databinding.ObservableLong.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ObservableLong[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableLong(parcel.readLong());
        }
    };
    static final long serialVersionUID = 1;
    private long mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableLong(long j) {
        this.mValue = j;
    }

    public ObservableLong() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mValue);
    }
}
