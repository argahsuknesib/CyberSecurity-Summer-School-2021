package com.xiaomi.smarthome.scene.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class WifiGroupData implements Parcelable {
    public static final Parcelable.Creator<WifiGroupData> CREATOR = new Parcelable.Creator<WifiGroupData>() {
        /* class com.xiaomi.smarthome.scene.location.model.WifiGroupData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WifiGroupData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WifiGroupData(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f11159O000000o;
    public List<String> O00000Oo;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11159O000000o);
        parcel.writeStringList(this.O00000Oo);
    }

    public WifiGroupData() {
    }

    protected WifiGroupData(Parcel parcel) {
        this.f11159O000000o = parcel.readString();
        this.O00000Oo = parcel.createStringArrayList();
    }
}
