package com.xiaomi.youpin.login.entity.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginMiAccount implements Parcelable {
    public static final Parcelable.Creator<LoginMiAccount> CREATOR = new Parcelable.Creator<LoginMiAccount>() {
        /* class com.xiaomi.youpin.login.entity.account.LoginMiAccount.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LoginMiAccount[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LoginMiAccount(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private String f12084O000000o;
    private String O00000Oo;
    private final HashMap<String, MiServiceTokenInfo> O00000o = new HashMap<>();
    private boolean O00000o0;
    private final HashMap<String, Long> O00000oO = new HashMap<>();

    public int describeContents() {
        return 0;
    }

    public LoginMiAccount() {
    }

    protected LoginMiAccount(Parcel parcel) {
        O000000o(parcel.readString(), parcel.readString(), parcel.readByte() != 0, parcel.createTypedArrayList(MiServiceTokenInfo.CREATOR));
    }

    public final synchronized void O000000o(String str, String str2, boolean z, Collection<MiServiceTokenInfo> collection) {
        this.f12084O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = z;
        this.O00000o.clear();
        if (collection != null) {
            for (MiServiceTokenInfo next : collection) {
                this.O00000o.put(next.f12086O000000o, next);
            }
        }
    }

    public final synchronized String O000000o() {
        return this.f12084O000000o;
    }

    public final synchronized boolean O00000Oo() {
        return this.O00000o0;
    }

    public final synchronized String O00000o0() {
        return this.O00000Oo;
    }

    public final synchronized MiServiceTokenInfo O000000o(String str) {
        return this.O00000o.get(str);
    }

    public final synchronized long O00000Oo(String str) {
        Long l = this.O00000oO.get(str);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public final synchronized void O000000o(MiServiceTokenInfo miServiceTokenInfo) {
        this.O00000o.put(miServiceTokenInfo.f12086O000000o, miServiceTokenInfo);
        this.O00000oO.put(miServiceTokenInfo.f12086O000000o, Long.valueOf(System.currentTimeMillis()));
    }

    public final synchronized List<MiServiceTokenInfo> O00000o() {
        return new ArrayList(this.O00000o.values());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12084O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
        parcel.writeTypedList(O00000o());
    }

    public static LoginMiAccount O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LoginMiAccount loginMiAccount = new LoginMiAccount();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("serviceTokens");
            Iterator<String> keys = optJSONObject.keys();
            ArrayList arrayList = new ArrayList();
            while (keys.hasNext()) {
                arrayList.add(MiServiceTokenInfo.O000000o(optJSONObject.optString(keys.next())));
            }
            loginMiAccount.O000000o(jSONObject.optString("userId"), jSONObject.optString("passToken"), jSONObject.optBoolean("isSystemAccount"), arrayList);
            return loginMiAccount;
        } catch (Exception unused) {
            return null;
        }
    }

    public final synchronized String O00000oO() {
        String str;
        str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", this.f12084O000000o);
            jSONObject.put("passToken", this.O00000Oo);
            jSONObject.put("isSystemAccount", this.O00000o0);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry next : this.O00000o.entrySet()) {
                jSONObject2.put((String) next.getKey(), ((MiServiceTokenInfo) next.getValue()).O000000o());
            }
            jSONObject.put("serviceTokens", jSONObject2);
            str = jSONObject.toString();
        } catch (JSONException unused) {
        }
        return str;
    }

    public String toString() {
        return "LoginMiAccount{userId='" + this.f12084O000000o + '\'' + ", passToken='" + this.O00000Oo + '\'' + ", isSystemAccount=" + this.O00000o0 + ", mServiceTokenList=" + this.O00000o + '}';
    }
}
