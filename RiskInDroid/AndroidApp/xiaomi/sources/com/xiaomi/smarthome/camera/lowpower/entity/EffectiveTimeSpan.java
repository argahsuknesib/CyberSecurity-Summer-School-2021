package com.xiaomi.smarthome.camera.lowpower.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EffectiveTimeSpan implements Parcelable {
    public static final Parcelable.Creator<EffectiveTimeSpan> CREATOR = new Parcelable.Creator<EffectiveTimeSpan>() {
        /* class com.xiaomi.smarthome.camera.lowpower.entity.EffectiveTimeSpan.AnonymousClass1 */

        public final EffectiveTimeSpan createFromParcel(Parcel parcel) {
            return new EffectiveTimeSpan(parcel);
        }

        public final EffectiveTimeSpan[] newArray(int i) {
            return new EffectiveTimeSpan[i];
        }
    };
    public int fromHour;
    public int fromMin;
    public String timezone;
    public int toHour;
    public int toMin;
    public int[] wDay;

    public int describeContents() {
        return 0;
    }

    public EffectiveTimeSpan() {
        int i = 0;
        this.fromHour = 0;
        this.toHour = 0;
        this.fromMin = 0;
        this.toMin = 0;
        this.timezone = "";
        this.fromHour = 0;
        this.toHour = 0;
        this.fromMin = 0;
        this.toMin = 0;
        this.wDay = new int[7];
        while (true) {
            int[] iArr = this.wDay;
            if (i < iArr.length) {
                iArr[i] = i;
                i++;
            } else {
                return;
            }
        }
    }

    public static EffectiveTimeSpan parseFromJsonObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        EffectiveTimeSpan effectiveTimeSpan = new EffectiveTimeSpan();
        JSONObject optJSONObject = jSONObject.optJSONObject("from");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("to");
        JSONArray optJSONArray = jSONObject.optJSONArray("wday");
        if (optJSONObject != null) {
            effectiveTimeSpan.fromHour = optJSONObject.optInt("hour");
            effectiveTimeSpan.fromMin = optJSONObject.optInt("min");
        }
        if (optJSONObject2 != null) {
            effectiveTimeSpan.toHour = optJSONObject2.optInt("hour");
            effectiveTimeSpan.toMin = optJSONObject2.optInt("min");
        }
        if (optJSONArray != null) {
            effectiveTimeSpan.wDay = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    effectiveTimeSpan.wDay[i] = optJSONArray.getInt(i);
                } catch (JSONException unused) {
                }
            }
        }
        effectiveTimeSpan.timezone = jSONObject.optString("timezone");
        return effectiveTimeSpan;
    }

    public boolean isEqual(EffectiveTimeSpan effectiveTimeSpan) {
        int[] iArr;
        if (effectiveTimeSpan == null || this.fromHour != effectiveTimeSpan.fromHour || this.toHour != effectiveTimeSpan.toHour || this.fromMin != effectiveTimeSpan.fromMin || this.toMin != effectiveTimeSpan.toMin) {
            return false;
        }
        int[] iArr2 = this.wDay;
        if (iArr2 == null || (iArr = effectiveTimeSpan.wDay) == null) {
            if (this.wDay == null && effectiveTimeSpan.wDay == null) {
                return true;
            }
            return false;
        } else if (iArr2.length != iArr.length) {
            return false;
        } else {
            int i = 0;
            while (true) {
                int[] iArr3 = this.wDay;
                if (i >= iArr3.length) {
                    return true;
                }
                if (iArr3[i] != effectiveTimeSpan.wDay[i]) {
                    return false;
                }
                i++;
            }
        }
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.fromHour != -1) {
                jSONObject2.put("hour", this.fromHour);
                jSONObject2.put("min", this.fromMin);
                jSONObject3.put("hour", this.toHour);
                jSONObject3.put("min", this.toMin);
                if (this.wDay != null) {
                    for (int put : this.wDay) {
                        jSONArray.put(put);
                    }
                }
                jSONObject.put("from", jSONObject2);
                jSONObject.put("to", jSONObject3);
                jSONObject.put("wday", jSONArray);
                jSONObject.put("timezone", this.timezone);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "EffectiveTimeSpan{fromHour=" + this.fromHour + ", toHour=" + this.toHour + ", fromMin=" + this.fromMin + ", toMin=" + this.toMin + ", wDay=" + Arrays.toString(this.wDay) + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fromHour);
        parcel.writeInt(this.toHour);
        parcel.writeInt(this.fromMin);
        parcel.writeInt(this.toMin);
        parcel.writeIntArray(this.wDay);
        parcel.writeString(this.timezone);
    }

    protected EffectiveTimeSpan(Parcel parcel) {
        this.fromHour = 0;
        this.toHour = 0;
        this.fromMin = 0;
        this.toMin = 0;
        this.timezone = "";
        this.fromHour = parcel.readInt();
        this.toHour = parcel.readInt();
        this.fromMin = parcel.readInt();
        this.toMin = parcel.readInt();
        this.wDay = parcel.createIntArray();
        this.timezone = parcel.readString();
    }
}
