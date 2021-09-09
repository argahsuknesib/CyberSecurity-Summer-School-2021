package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

@TargetApi(13)
@RequiresApi(13)
class ParcelableCompatCreatorHoneycombMR2Stub {
    ParcelableCompatCreatorHoneycombMR2Stub() {
    }

    static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
    }
}
