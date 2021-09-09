package com.xiaomi.smarthome.smartconfig.callback;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class ConfigNetRequest implements Parcelable {
    public static final Parcelable.Creator<ConfigNetRequest> CREATOR = new Parcelable.Creator<ConfigNetRequest>() {
        /* class com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ConfigNetRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ConfigNetRequest(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f11488O000000o;
    public String O00000Oo;
    public List<ConfigKeyValuePair> O00000o0;

    public int describeContents() {
        return 0;
    }

    public ConfigNetRequest(O000000o o000000o) {
        this.f11488O000000o = o000000o.f11489O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
    }

    protected ConfigNetRequest(Parcel parcel) {
        this.f11488O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.createTypedArrayList(ConfigKeyValuePair.CREATOR);
    }

    public String toString() {
        return "path:" + this.O00000Oo + " method:" + this.f11488O000000o + " params:" + this.O00000o0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11488O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeTypedList(this.O00000o0);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11489O000000o;
        public String O00000Oo;
        public List<ConfigKeyValuePair> O00000o0 = new ArrayList(8);

        public final O000000o O000000o(String str) {
            if (str != null) {
                this.O00000Oo = str;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public final ConfigNetRequest O000000o() {
            return new ConfigNetRequest(this);
        }
    }
}
