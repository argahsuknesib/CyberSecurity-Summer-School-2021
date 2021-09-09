package com.xiaomi.smarthome.core.entity.message;

import android.os.Parcel;
import android.os.Parcelable;

public enum CoreMessageType implements Parcelable {
    UNKNOWN,
    UPDATE_DEVICE_LIST;
    
    public static final Parcelable.Creator<CoreMessageType> CREATOR = new Parcelable.Creator<CoreMessageType>() {
        /* class com.xiaomi.smarthome.core.entity.message.CoreMessageType.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CoreMessageType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return CoreMessageType.values()[parcel.readInt()];
        }
    };

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
