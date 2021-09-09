package com.xiaomi.smarthome.homeroom.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.Device;

public class GridViewData implements Parcelable {
    public static final Parcelable.Creator<GridViewData> CREATOR = new Parcelable.Creator<GridViewData>() {
        /* class com.xiaomi.smarthome.homeroom.model.GridViewData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GridViewData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GridViewData(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public GridType f8988O000000o;
    public Device O00000Oo;
    public String O00000o0;

    public int describeContents() {
        return 0;
    }

    public enum GridType implements Parcelable {
        TYPE_NORMAL,
        TYPE_IR,
        TYPE_ADD_TO_COMMON,
        TYPE_TIPS;
        
        public static final Parcelable.Creator<GridType> CREATOR = new Parcelable.Creator<GridType>() {
            /* class com.xiaomi.smarthome.homeroom.model.GridViewData.GridType.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GridType[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return GridType.values()[parcel.readInt()];
            }
        };

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(ordinal());
        }
    }

    public GridViewData() {
    }

    protected GridViewData(Parcel parcel) {
        GridType gridType;
        try {
            int readInt = parcel.readInt();
            if (readInt == -1) {
                gridType = null;
            } else {
                gridType = GridType.values()[readInt];
            }
            this.f8988O000000o = gridType;
            this.O00000Oo = (Device) parcel.readParcelable(Device.class.getClassLoader());
            this.O00000o0 = parcel.readString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "GVD{[" + this.O00000Oo.did + "," + this.O00000Oo.name + "]}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        GridType gridType = this.f8988O000000o;
        parcel.writeInt(gridType == null ? -1 : gridType.ordinal());
        parcel.writeParcelable(this.O00000Oo, i);
        parcel.writeString(this.O00000o0);
    }
}
