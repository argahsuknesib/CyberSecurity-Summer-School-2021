package androidx.databinding;

import _m_j.dj;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableDouble extends dj implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableDouble> CREATOR = new Parcelable.Creator<ObservableDouble>() {
        /* class androidx.databinding.ObservableDouble.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ObservableDouble[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableDouble(parcel.readDouble());
        }
    };
    static final long serialVersionUID = 1;
    private double mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableDouble(double d) {
        this.mValue = d;
    }

    public ObservableDouble() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mValue);
    }
}
