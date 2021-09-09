package com.xiaomi.smarthome.framework.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public class UserInfo implements Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        /* class com.xiaomi.smarthome.framework.api.model.UserInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UserInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f7549O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public long O00000oo;
    public long O0000O0o;

    public int describeContents() {
        return 0;
    }

    public UserInfo() {
    }

    public static UserInfo O000000o(JSONObject jSONObject) {
        UserInfo userInfo = new UserInfo();
        if (!jSONObject.isNull("userId")) {
            userInfo.f7549O000000o = jSONObject.optString("userId");
        } else if (!jSONObject.isNull("userid")) {
            userInfo.f7549O000000o = jSONObject.optString("userid");
        }
        userInfo.O00000oO = jSONObject.optString("nickname");
        userInfo.O00000Oo = jSONObject.optString("userName");
        userInfo.O00000o0 = jSONObject.optString("icon");
        return userInfo;
    }

    public UserInfo(Parcel parcel) {
        this.f7549O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readLong();
    }

    private static void O000000o(String str, Parcel parcel) {
        if (str == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(str);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        O000000o(this.f7549O000000o, parcel);
        O000000o(this.O00000Oo, parcel);
        O000000o(this.O00000o0, parcel);
        O000000o(this.O00000o, parcel);
        O000000o(this.O00000oO, parcel);
        parcel.writeLong(this.O00000oo);
        parcel.writeLong(this.O0000O0o);
    }
}
