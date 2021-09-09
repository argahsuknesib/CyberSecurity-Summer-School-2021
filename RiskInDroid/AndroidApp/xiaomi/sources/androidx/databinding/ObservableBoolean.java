package androidx.databinding;

import _m_j.dj;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableBoolean extends dj implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new Parcelable.Creator<ObservableBoolean>() {
        /* class androidx.databinding.ObservableBoolean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ObservableBoolean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            return new ObservableBoolean(z);
        }
    };
    static final long serialVersionUID = 1;
    private boolean mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableBoolean(boolean z) {
        this.mValue = z;
    }

    public ObservableBoolean() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mValue ? 1 : 0);
    }
}
