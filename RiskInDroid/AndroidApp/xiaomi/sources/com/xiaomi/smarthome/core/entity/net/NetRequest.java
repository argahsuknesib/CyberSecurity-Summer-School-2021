package com.xiaomi.smarthome.core.entity.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class NetRequest implements Parcelable {
    public static final Parcelable.Creator<NetRequest> CREATOR = new Parcelable.Creator<NetRequest>() {
        /* class com.xiaomi.smarthome.core.entity.net.NetRequest.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NetRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NetRequest(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6729O000000o;
    public String O00000Oo;
    public List<KeyValuePair> O00000o;
    public String O00000o0;
    public List<KeyValuePair> O00000oO;
    public List<KeyValuePair> O00000oo;

    public int describeContents() {
        return 0;
    }

    public NetRequest(O000000o o000000o) {
        this.f6729O000000o = o000000o.f6730O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
    }

    protected NetRequest(Parcel parcel) {
        this.f6729O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.createTypedArrayList(KeyValuePair.CREATOR);
        this.O00000oO = parcel.createTypedArrayList(KeyValuePair.CREATOR);
        this.O00000oo = parcel.createTypedArrayList(KeyValuePair.CREATOR);
    }

    public String toString() {
        return "prefix:" + this.O00000o0 + "path:" + this.O00000Oo + " method:" + this.f6729O000000o + " params:" + this.O00000oO;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6729O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeTypedList(this.O00000o);
        parcel.writeTypedList(this.O00000oO);
        parcel.writeTypedList(this.O00000oo);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6730O000000o;
        public String O00000Oo;
        public List<KeyValuePair> O00000o = new ArrayList(8);
        public String O00000o0;
        public List<KeyValuePair> O00000oO = new ArrayList(8);
        public List<KeyValuePair> O00000oo = new ArrayList(4);

        public final O000000o O000000o(String str) {
            if (str != null) {
                this.f6730O000000o = str;
                return this;
            }
            throw new IllegalArgumentException("method == null");
        }

        public final O000000o O00000Oo(String str) {
            if (str != null) {
                this.O00000Oo = str;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public final O000000o O00000o0(String str) {
            if (str != null) {
                this.O00000o0 = str;
                return this;
            }
            throw new IllegalArgumentException("prefix == null");
        }

        public final O000000o O000000o(List<KeyValuePair> list) {
            if (list != null) {
                this.O00000oO = list;
                return this;
            }
            throw new IllegalArgumentException("queries == null");
        }

        public final NetRequest O000000o() {
            return new NetRequest(this);
        }
    }
}
