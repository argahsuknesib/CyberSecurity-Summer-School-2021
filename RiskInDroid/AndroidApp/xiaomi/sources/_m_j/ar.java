package _m_j;

import android.os.Parcel;

@Deprecated
public interface ar<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
