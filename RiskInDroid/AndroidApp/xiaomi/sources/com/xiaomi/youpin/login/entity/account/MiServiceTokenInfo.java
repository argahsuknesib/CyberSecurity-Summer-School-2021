package com.xiaomi.youpin.login.entity.account;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class MiServiceTokenInfo implements Parcelable {
    public static final Parcelable.Creator<MiServiceTokenInfo> CREATOR = new Parcelable.Creator<MiServiceTokenInfo>() {
        /* class com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiServiceTokenInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MiServiceTokenInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f12086O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public long O00000oO;
    public String O00000oo;

    public int describeContents() {
        return 0;
    }

    public MiServiceTokenInfo() {
    }

    public MiServiceTokenInfo(String str, String str2, String str3, String str4, String str5, long j) {
        this.f12086O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
        this.O00000o = str4;
        this.O00000oO = j;
        this.O00000oo = str5;
    }

    protected MiServiceTokenInfo(Parcel parcel) {
        this.f12086O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readLong();
        this.O00000oo = parcel.readString();
    }

    public static MiServiceTokenInfo O000000o(String str) {
        MiServiceTokenInfo miServiceTokenInfo = new MiServiceTokenInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            miServiceTokenInfo.f12086O000000o = jSONObject.optString("sid");
            miServiceTokenInfo.O00000Oo = jSONObject.optString("cUserId");
            miServiceTokenInfo.O00000o0 = jSONObject.optString("serviceToken");
            miServiceTokenInfo.O00000o = jSONObject.optString("ssecurity");
            miServiceTokenInfo.O00000oO = jSONObject.optLong("timeDiff");
            miServiceTokenInfo.O00000oo = jSONObject.optString("domain");
            return miServiceTokenInfo;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String O000000o() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sid", this.f12086O000000o);
            jSONObject.put("cUserId", this.O00000Oo);
            jSONObject.put("serviceToken", this.O00000o0);
            jSONObject.put("ssecurity", this.O00000o);
            jSONObject.put("timeDiff", this.O00000oO);
            jSONObject.put("domain", this.O00000oo);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12086O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeLong(this.O00000oO);
        parcel.writeString(this.O00000oo);
    }

    public String toString() {
        return "MiServiceTokenInfo{sid='" + this.f12086O000000o + '\'' + ", cUserId='" + this.O00000Oo + '\'' + ", serviceToken='" + this.O00000o0 + '\'' + ", ssecurity='" + this.O00000o + '\'' + ", timeDiff=" + this.O00000oO + ", domain='" + this.O00000oo + '\'' + '}';
    }
}
