package com.xiaomi.smarthome.devicelistswitch.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Operation implements Parcelable {
    public static final Parcelable.Creator<Operation> CREATOR = new Parcelable.Creator<Operation>() {
        /* class com.xiaomi.smarthome.devicelistswitch.model.Operation.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Operation[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Operation(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f7304O000000o;
    public String O00000Oo;
    private String[] O00000o;
    public String O00000o0;
    private String O00000oO;
    private Map<String, String> O00000oo;
    private String O0000O0o;

    public int describeContents() {
        return 0;
    }

    public static Operation O000000o(JSONObject jSONObject) {
        Operation operation = new Operation();
        if (jSONObject != null) {
            if (!jSONObject.isNull("prop_name")) {
                operation.f7304O000000o = jSONObject.optString("prop_name");
            }
            if (!jSONObject.isNull("prop_value")) {
                operation.O00000Oo = jSONObject.optString("prop_value");
            }
            if (!jSONObject.isNull("rpc_method")) {
                operation.O00000o0 = jSONObject.optString("rpc_method");
            }
            if (!jSONObject.isNull("rpc_params")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("rpc_params");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    String[] strArr = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        strArr[i] = optJSONArray.optString(i);
                    }
                    operation.O00000o = strArr;
                }
                operation.f7304O000000o = jSONObject.optString("prop_name");
            }
            if (!jSONObject.isNull("next_value")) {
                operation.O00000oO = jSONObject.optString("next_value");
            }
            if (!jSONObject.isNull("desc")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("desc");
                HashMap hashMap = new HashMap();
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, optJSONObject.optString(next));
                }
                operation.O00000oo = hashMap;
            }
            if (!jSONObject.isNull("state")) {
                operation.O0000O0o = jSONObject.optString("state");
            }
        }
        return operation;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prop_name", this.f7304O000000o);
            jSONObject.put("prop_value", this.O00000Oo);
            jSONObject.put("rpc_method", this.O00000o0);
            String[] strArr = this.O00000o;
            if (strArr != null && strArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("rpc_params", jSONArray);
            }
            jSONObject.put("next_value", this.O00000oO);
            Map<String, String> map = this.O00000oo;
            if (map != null && map.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (String next : map.keySet()) {
                    jSONObject2.put(next, map.get(next));
                }
                jSONObject.put("desc", jSONObject2);
            }
            jSONObject.put("state", this.O0000O0o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7304O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeStringArray(this.O00000o);
        parcel.writeString(this.O00000oO);
        Map<String, String> map = this.O00000oo;
        if (map == null || map.isEmpty()) {
            parcel.writeInt(0);
        } else {
            Map<String, String> map2 = this.O00000oo;
            parcel.writeInt(map2.size() * 2);
            for (String next : map2.keySet()) {
                parcel.writeString(next);
                parcel.writeString(map2.get(next));
            }
        }
        parcel.writeString(this.O0000O0o);
    }

    public Operation() {
    }

    protected Operation(Parcel parcel) {
        this.f7304O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.createStringArray();
        this.O00000oO = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < readInt; i++) {
                hashMap.put(parcel.readString(), parcel.readString());
            }
            this.O00000oo = hashMap;
        }
        this.O0000O0o = parcel.readString();
    }
}
