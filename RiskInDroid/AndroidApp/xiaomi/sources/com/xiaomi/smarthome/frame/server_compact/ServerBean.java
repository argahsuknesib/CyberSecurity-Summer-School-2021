package com.xiaomi.smarthome.frame.server_compact;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ServerBean> CREATOR = new Parcelable.Creator<ServerBean>() {
        /* class com.xiaomi.smarthome.frame.server_compact.ServerBean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ServerBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ServerBean(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f7546O000000o;
    public final String O00000Oo;
    public transient boolean O00000o = false;
    public transient String O00000o0 = "";
    public transient boolean O00000oO = false;

    public int describeContents() {
        return 0;
    }

    public ServerBean(String str, String str2, String str3) {
        this.f7546O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
    }

    protected ServerBean(Parcel parcel) {
        this.f7546O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public static List<ServerBean> O000000o(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("list");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(O00000Oo(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static ServerBean O00000Oo(JSONObject jSONObject) throws JSONException {
        return new ServerBean(jSONObject.getString("machineCode"), jSONObject.getString("countryCode"), jSONObject.optString("name"));
    }

    public static ServerBean O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return new ServerBean(str2, str, "");
        }
        throw new IllegalArgumentException("countryCode or machineCode is empty!");
    }

    public final String O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("machineCode", this.f7546O000000o);
            jSONObject.put("countryCode", this.O00000Oo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServerBean serverBean = (ServerBean) obj;
        if (!this.f7546O000000o.equals(serverBean.f7546O000000o)) {
            return false;
        }
        return this.O00000Oo.equals(serverBean.O00000Oo);
    }

    public int hashCode() {
        return (this.f7546O000000o.hashCode() * 31) + this.O00000Oo.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7546O000000o);
        parcel.writeString(this.O00000Oo);
    }

    public String toString() {
        return O000000o();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new ServerBean(this.f7546O000000o, this.O00000Oo, "");
        }
    }

    public final String O00000Oo() {
        return "ServerBean: " + this.O00000Oo + " : " + this.f7546O000000o + " ";
    }
}
