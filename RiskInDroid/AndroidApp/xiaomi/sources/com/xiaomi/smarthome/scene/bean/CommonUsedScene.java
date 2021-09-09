package com.xiaomi.smarthome.scene.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonUsedScene implements Parcelable {
    public static final Parcelable.Creator<CommonUsedScene> CREATOR = new Parcelable.Creator<CommonUsedScene>() {
        /* class com.xiaomi.smarthome.scene.bean.CommonUsedScene.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonUsedScene[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommonUsedScene(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public long f11134O000000o;
    public String O00000Oo;
    public String O00000o;
    public int O00000o0;

    public int describeContents() {
        return 0;
    }

    public CommonUsedScene() {
    }

    protected CommonUsedScene(Parcel parcel) {
        this.f11134O000000o = parcel.readLong();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readString();
    }

    public static List<CommonUsedScene> O000000o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                CommonUsedScene commonUsedScene = new CommonUsedScene();
                commonUsedScene.f11134O000000o = Long.parseLong(optJSONObject.optString("scene_id"));
                commonUsedScene.O00000Oo = optJSONObject.optString("scene_name");
                commonUsedScene.O00000o0 = optJSONObject.optInt("scene_type");
                commonUsedScene.O00000o = optJSONObject.optString("icon");
                arrayList.add(commonUsedScene);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11134O000000o);
            jSONObject.put("scene_id", sb.toString());
            jSONObject.put("scene_type", this.O00000o0);
            jSONObject.put("common_use", true);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final JSONObject O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11134O000000o);
            jSONObject.put("scene_id", sb.toString());
            jSONObject.put("scene_type", this.O00000o0);
            jSONObject.put("common_use", false);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11134O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeString(this.O00000o);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CommonUsedScene commonUsedScene = (CommonUsedScene) obj;
            if (this.f11134O000000o != commonUsedScene.f11134O000000o || this.O00000o0 != commonUsedScene.O00000o0) {
                return false;
            }
            String str = this.O00000Oo;
            if (str == null ? commonUsedScene.O00000Oo != null : !str.equals(commonUsedScene.O00000Oo)) {
                return false;
            }
            String str2 = this.O00000o;
            if (str2 != null) {
                return str2.equals(commonUsedScene.O00000o);
            }
            if (commonUsedScene.O00000o == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f11134O000000o;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.O00000Oo;
        int i2 = 0;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.O00000o0) * 31;
        String str2 = this.O00000o;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }
}
