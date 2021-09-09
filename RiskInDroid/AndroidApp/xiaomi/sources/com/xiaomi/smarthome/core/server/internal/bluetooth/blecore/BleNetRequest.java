package com.xiaomi.smarthome.core.server.internal.bluetooth.blecore;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class BleNetRequest implements Parcelable {
    public static final Parcelable.Creator<BleNetRequest> CREATOR = new Parcelable.Creator<BleNetRequest>() {
        /* class com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleNetRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleNetRequest(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6798O000000o;
    public String O00000Oo;
    public List<BleKeyValuePair> O00000o0;

    public int describeContents() {
        return 0;
    }

    public BleNetRequest(O000000o o000000o) {
        this.f6798O000000o = o000000o.f6799O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
    }

    protected BleNetRequest(Parcel parcel) {
        this.f6798O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.createTypedArrayList(BleKeyValuePair.CREATOR);
    }

    public String toString() {
        return "path:" + this.O00000Oo + " method:" + this.f6798O000000o + " params:" + this.O00000o0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6798O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeTypedList(this.O00000o0);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6799O000000o;
        public String O00000Oo;
        public List<BleKeyValuePair> O00000o0 = new ArrayList(8);

        public final BleNetRequest O000000o() {
            return new BleNetRequest(this);
        }
    }
}
