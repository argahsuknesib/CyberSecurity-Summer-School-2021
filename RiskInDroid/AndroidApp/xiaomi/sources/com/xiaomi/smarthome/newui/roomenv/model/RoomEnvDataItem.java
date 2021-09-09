package com.xiaomi.smarthome.newui.roomenv.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public class RoomEnvDataItem implements Parcelable {
    public static final Parcelable.Creator<RoomEnvDataItem> CREATOR = new Parcelable.Creator<RoomEnvDataItem>() {
        /* class com.xiaomi.smarthome.newui.roomenv.model.RoomEnvDataItem.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RoomEnvDataItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RoomEnvDataItem(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f10271O000000o;
    public long O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;

    public int describeContents() {
        return 0;
    }

    public static RoomEnvDataItem O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RoomEnvDataItem roomEnvDataItem = new RoomEnvDataItem();
        roomEnvDataItem.O00000oO = jSONObject.optString("attr_type");
        roomEnvDataItem.f10271O000000o = jSONObject.optString("desc");
        roomEnvDataItem.O00000oo = jSONObject.optString("did");
        roomEnvDataItem.O00000o0 = jSONObject.optString("prop");
        roomEnvDataItem.O00000Oo = jSONObject.optLong("timestamp");
        roomEnvDataItem.O00000o = jSONObject.optString("value");
        return roomEnvDataItem;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10271O000000o);
        parcel.writeLong(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
    }

    public RoomEnvDataItem() {
    }

    protected RoomEnvDataItem(Parcel parcel) {
        this.f10271O000000o = parcel.readString();
        this.O00000Oo = parcel.readLong();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
    }
}
