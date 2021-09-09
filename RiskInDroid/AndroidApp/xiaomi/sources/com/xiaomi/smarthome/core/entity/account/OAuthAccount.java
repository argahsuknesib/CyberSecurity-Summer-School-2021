package com.xiaomi.smarthome.core.entity.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class OAuthAccount implements Parcelable {
    public static final Parcelable.Creator<OAuthAccount> CREATOR = new Parcelable.Creator<OAuthAccount>() {
        /* class com.xiaomi.smarthome.core.entity.account.OAuthAccount.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OAuthAccount[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OAuthAccount(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private String f6719O000000o;
    private String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public OAuthAccount() {
    }

    protected OAuthAccount(Parcel parcel) {
        this.f6719O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public static OAuthAccount O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OAuthAccount oAuthAccount = new OAuthAccount();
        try {
            JSONObject jSONObject = new JSONObject(str);
            oAuthAccount.f6719O000000o = jSONObject.optString("userId");
            oAuthAccount.O00000Oo = jSONObject.optString("accessToken");
            return oAuthAccount;
        } catch (Exception unused) {
            return null;
        }
    }

    public final synchronized String O000000o() {
        String str;
        str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", this.f6719O000000o);
            jSONObject.put("accessToken", this.O00000Oo);
            str = jSONObject.toString();
        } catch (JSONException unused) {
        }
        return str;
    }

    public final synchronized void O000000o(String str, String str2) {
        this.f6719O000000o = str;
        this.O00000Oo = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6719O000000o);
        parcel.writeString(this.O00000Oo);
    }
}
