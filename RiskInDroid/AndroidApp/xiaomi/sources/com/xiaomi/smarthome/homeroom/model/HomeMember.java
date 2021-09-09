package com.xiaomi.smarthome.homeroom.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import org.json.JSONObject;

public class HomeMember implements Parcelable {
    public static final Parcelable.Creator<HomeMember> CREATOR = new Parcelable.Creator<HomeMember>() {
        /* class com.xiaomi.smarthome.homeroom.model.HomeMember.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new HomeMember[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new HomeMember(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f8990O000000o;
    public long O00000Oo;
    public UserInfo O00000o0;

    public int describeContents() {
        return 0;
    }

    public HomeMember() {
    }

    protected HomeMember(Parcel parcel) {
        this.f8990O000000o = parcel.readInt();
        this.O00000Oo = parcel.readLong();
        this.O00000o0 = (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader());
    }

    public static HomeMember O000000o(JSONObject jSONObject) {
        HomeMember homeMember = new HomeMember();
        try {
            UserInfo userInfo = new UserInfo();
            if (!jSONObject.isNull("uid")) {
                homeMember.O00000Oo = jSONObject.optLong("uid");
                userInfo.f7549O000000o = jSONObject.optString("uid");
                userInfo.O00000oO = jSONObject.optString("uid");
                userInfo.O00000Oo = jSONObject.optString("uid");
                homeMember.O00000o0 = userInfo;
            }
            if (!jSONObject.isNull("permit_level")) {
                homeMember.f8990O000000o = jSONObject.optInt("permit_level");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeMember;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8990O000000o);
        parcel.writeLong(this.O00000Oo);
        parcel.writeParcelable(this.O00000o0, i);
    }
}
