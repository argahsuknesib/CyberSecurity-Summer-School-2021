package com.xiaomi.smarthome.camera.activity.setting;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LongTimeAlarm implements Parcelable {
    public static final Parcelable.Creator<LongTimeAlarm> CREATOR = new Parcelable.Creator<LongTimeAlarm>() {
        /* class com.xiaomi.smarthome.camera.activity.setting.LongTimeAlarm.AnonymousClass1 */

        public final LongTimeAlarm createFromParcel(Parcel parcel) {
            return new LongTimeAlarm(parcel);
        }

        public final LongTimeAlarm[] newArray(int i) {
            return new LongTimeAlarm[i];
        }
    };
    public String alarmValue;
    public boolean enable;
    public int key;
    public int repeat;
    public String time_end;
    public String time_start;

    public int describeContents() {
        return 0;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable", this.enable);
            jSONObject.put("key", this.key);
            jSONObject.put("time_start", this.time_start);
            jSONObject.put("time_end", this.time_end);
            jSONObject.put("repeat", this.repeat);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static JSONObject toJSON(List<LongTimeAlarm> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            LongTimeAlarm longTimeAlarm = list.get(i);
            if (longTimeAlarm != null) {
                jSONArray.put(longTimeAlarm.toJSON());
            }
        }
        try {
            jSONObject.put("values", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.enable) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.key);
        parcel.writeString(this.time_start);
        parcel.writeString(this.time_end);
        parcel.writeInt(this.repeat);
        parcel.writeString(this.alarmValue);
    }

    public LongTimeAlarm() {
        this.enable = false;
        this.key = -1;
        this.time_start = null;
        this.time_end = null;
        this.repeat = 0;
        this.alarmValue = null;
    }

    protected LongTimeAlarm(Parcel parcel) {
        if (parcel.readInt() > 0) {
            this.enable = true;
        } else {
            this.enable = false;
        }
        this.key = parcel.readInt();
        this.time_start = parcel.readString();
        this.time_end = parcel.readString();
        this.repeat = parcel.readInt();
        this.alarmValue = parcel.readString();
    }
}
