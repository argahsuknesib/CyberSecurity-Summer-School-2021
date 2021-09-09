package com.ximalaya.ting.android.opensdk.httputil;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

public class Config implements Parcelable {
    public static final Parcelable.Creator<Config> CREATOR = new Parcelable.Creator<Config>() {
        /* class com.ximalaya.ting.android.opensdk.httputil.Config.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Config[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Config(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f12165O000000o = false;
    public boolean O00000Oo = true;
    public int O00000o;
    public String O00000o0;
    public int O00000oO;
    public String O00000oo;
    public int O0000O0o = 30000;
    public int O0000OOo = 30000;
    public String O0000Oo = "GET";
    public int O0000Oo0 = 30000;
    public Map<String, String> O0000OoO = new HashMap();
    public int O0000Ooo = -1;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f12165O000000o ? (byte) 1 : 0);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
        parcel.writeString(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeInt(this.O0000OoO.size());
        for (Map.Entry next : this.O0000OoO.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        parcel.writeInt(this.O0000Ooo);
    }

    public Config() {
    }

    public final void O000000o(Parcel parcel) {
        boolean z = true;
        this.f12165O000000o = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.O00000Oo = z;
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readString();
        int readInt = parcel.readInt();
        this.O0000OoO = new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            this.O0000OoO.put(parcel.readString(), parcel.readString());
        }
        this.O0000Ooo = parcel.readInt();
    }

    protected Config(Parcel parcel) {
        O000000o(parcel);
    }

    public String toString() {
        return "Config{useProxy=" + this.f12165O000000o + ", useCache=" + this.O00000Oo + ", proxyHost='" + this.O00000o0 + '\'' + ", proxyPort=" + this.O00000o + ", httpsProxyPort=" + this.O00000oO + ", authorization='" + this.O00000oo + '\'' + ", connectionTimeOut=" + this.O0000O0o + ", readTimeOut=" + this.O0000OOo + ", writeTimeOut=" + this.O0000Oo0 + ", method='" + this.O0000Oo + '\'' + ", property=" + this.O0000OoO + '}';
    }
}
