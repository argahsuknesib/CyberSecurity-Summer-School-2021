package androidx.databinding;

import _m_j.dj;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableByte extends dj implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new Parcelable.Creator<ObservableByte>() {
        /* class androidx.databinding.ObservableByte.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ObservableByte[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableByte(parcel.readByte());
        }
    };
    static final long serialVersionUID = 1;
    private byte mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableByte(byte b) {
        this.mValue = b;
    }

    public ObservableByte() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mValue);
    }
}
