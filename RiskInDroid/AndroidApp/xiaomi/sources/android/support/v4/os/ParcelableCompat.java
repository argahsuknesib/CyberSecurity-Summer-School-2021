package android.support.v4.os;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public final class ParcelableCompat {
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        if (Build.VERSION.SDK_INT >= 13) {
            return ParcelableCompatCreatorHoneycombMR2Stub.instantiate(parcelableCompatCreatorCallbacks);
        }
        return new CompatCreator(parcelableCompatCreatorCallbacks);
    }

    static class CompatCreator<T> implements Parcelable.Creator<T> {
        final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        public CompatCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.mCallbacks = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.mCallbacks.createFromParcel(parcel, null);
        }

        public T[] newArray(int i) {
            return this.mCallbacks.newArray(i);
        }
    }

    private ParcelableCompat() {
    }
}
