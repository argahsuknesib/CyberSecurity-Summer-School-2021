package com.xiaomi.smarthome.upnp;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.KeyValuePair;
import java.util.List;

public abstract class UPnPApi {
    protected static volatile UPnPApi _instance;

    public abstract String getRootNodeValue(String str, String str2);

    public abstract void invokeServiceAction(String str, String str2, String str3, List<KeyValuePair> list, Callback<String> callback);

    public static UPnPApi instance() {
        return _instance;
    }

    public static class EventData implements Parcelable {
        public static final Parcelable.Creator<EventData> CREATOR = new Parcelable.Creator<EventData>() {
            /* class com.xiaomi.smarthome.upnp.UPnPApi.EventData.AnonymousClass1 */

            public final EventData createFromParcel(Parcel parcel) {
                return new EventData(parcel);
            }

            public final EventData[] newArray(int i) {
                return new EventData[i];
            }
        };
        public String name;
        public long seq;
        public String udn;
        public String value;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.udn);
            parcel.writeLong(this.seq);
            parcel.writeString(this.name);
            parcel.writeString(this.value);
        }

        public EventData() {
        }

        protected EventData(Parcel parcel) {
            this.udn = parcel.readString();
            this.seq = parcel.readLong();
            this.name = parcel.readString();
            this.value = parcel.readString();
        }
    }
}
