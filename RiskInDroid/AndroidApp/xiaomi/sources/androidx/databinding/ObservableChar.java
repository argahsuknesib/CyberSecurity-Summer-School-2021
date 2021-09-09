package androidx.databinding;

import _m_j.dj;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableChar extends dj implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new Parcelable.Creator<ObservableChar>() {
        /* class androidx.databinding.ObservableChar.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ObservableChar[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableChar((char) parcel.readInt());
        }
    };
    static final long serialVersionUID = 1;
    private char mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableChar(char c) {
        this.mValue = c;
    }

    public ObservableChar() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mValue);
    }
}
