package com.xiaomi.smarthome.multikey;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PowerMultikeyBean implements Parcelable {
    public static final Parcelable.Creator<PowerMultikeyBean> CREATOR = new Parcelable.Creator<PowerMultikeyBean>() {
        /* class com.xiaomi.smarthome.multikey.PowerMultikeyBean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PowerMultikeyBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PowerMultikeyBean(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f10066O000000o;
    String O00000Oo;
    public String O00000o;
    String O00000o0;
    String O00000oO;
    public String O00000oo;

    public int describeContents() {
        return 0;
    }

    private PowerMultikeyBean(String str) {
        this.f10066O000000o = str;
    }

    protected PowerMultikeyBean(Parcel parcel) {
        this.f10066O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10066O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
    }

    public static ArrayList<PowerMultikeyBean> O000000o(JSONArray jSONArray) {
        ArrayList<PowerMultikeyBean> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(O000000o(jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }

    public static PowerMultikeyBean O000000o(JSONObject jSONObject) {
        PowerMultikeyBean powerMultikeyBean = new PowerMultikeyBean(jSONObject.optString("bean"));
        powerMultikeyBean.f10066O000000o = jSONObject.optString("id");
        powerMultikeyBean.O00000o = jSONObject.optString("name");
        powerMultikeyBean.O00000Oo = jSONObject.optString("room_id");
        powerMultikeyBean.O00000o0 = jSONObject.optString("home_id");
        powerMultikeyBean.O00000oO = jSONObject.optString("icon");
        powerMultikeyBean.O00000oo = jSONObject.optString("ai_desc");
        return powerMultikeyBean;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.O00000o);
            try {
                jSONObject.put("room_id", Long.parseLong(this.O00000Oo));
            } catch (NumberFormatException e) {
                jSONObject.put("room_id", this.O00000Oo);
                Log.e("PowerMultikeyBean", "toJson", e);
            }
            try {
                jSONObject.put("home_id", Long.parseLong(this.O00000o0));
            } catch (NumberFormatException e2) {
                jSONObject.put("home_id", this.O00000o0);
                Log.e("PowerMultikeyBean", "toJson", e2);
            }
            jSONObject.put("icon", this.O00000oO);
            try {
                jSONObject.put("id", Long.parseLong(this.f10066O000000o));
            } catch (NumberFormatException e3) {
                jSONObject.put("id", this.f10066O000000o);
                Log.e("PowerMultikeyBean", "toJson", e3);
            }
            jSONObject.put("ai_desc", this.O00000oo);
        } catch (JSONException e4) {
            Log.e("PowerMultikeyBean", "toJson", e4);
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PowerMultikeyBean powerMultikeyBean = (PowerMultikeyBean) obj;
            return TextUtils.equals(this.f10066O000000o, powerMultikeyBean.f10066O000000o) && TextUtils.equals(this.O00000Oo, powerMultikeyBean.O00000Oo) && TextUtils.equals(this.O00000o0, powerMultikeyBean.O00000o0) && TextUtils.equals(this.O00000o, powerMultikeyBean.O00000o) && TextUtils.equals(this.O00000oO, powerMultikeyBean.O00000oO) && TextUtils.equals(this.O00000oo, powerMultikeyBean.O00000oo);
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        ArrayList<PowerMultikeyBean> f10067O000000o;
        String O00000Oo;

        public O000000o(ArrayList<PowerMultikeyBean> arrayList, String str) {
            this.f10067O000000o = arrayList;
            this.O00000Oo = str;
        }
    }
}
