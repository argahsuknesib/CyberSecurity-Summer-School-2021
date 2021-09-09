package androidx.databinding;

import _m_j.dj;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableInt extends dj implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new Parcelable.Creator<ObservableInt>() {
        /* class androidx.databinding.ObservableInt.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ObservableInt[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }
    };
    static final long serialVersionUID = 1;
    private int mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableInt(int i) {
        this.mValue = i;
    }

    public ObservableInt() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mValue);
    }
}
