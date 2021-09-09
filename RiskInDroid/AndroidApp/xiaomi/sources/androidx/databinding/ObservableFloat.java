package androidx.databinding;

import _m_j.dj;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableFloat extends dj implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new Parcelable.Creator<ObservableFloat>() {
        /* class androidx.databinding.ObservableFloat.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ObservableFloat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableFloat(parcel.readFloat());
        }
    };
    static final long serialVersionUID = 1;
    private float mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableFloat(float f) {
        this.mValue = f;
    }

    public ObservableFloat() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.mValue);
    }
}
