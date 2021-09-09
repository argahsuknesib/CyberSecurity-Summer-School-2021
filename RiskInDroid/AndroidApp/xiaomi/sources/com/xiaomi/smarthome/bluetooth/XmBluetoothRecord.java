package com.xiaomi.smarthome.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class XmBluetoothRecord implements Parcelable {
    public static final Parcelable.Creator<XmBluetoothRecord> CREATOR = new Parcelable.Creator<XmBluetoothRecord>() {
        /* class com.xiaomi.smarthome.bluetooth.XmBluetoothRecord.AnonymousClass1 */

        public final XmBluetoothRecord createFromParcel(Parcel parcel) {
            return new XmBluetoothRecord(parcel);
        }

        public final XmBluetoothRecord[] newArray(int i) {
            return new XmBluetoothRecord[i];
        }
    };
    public String key;
    public String trigger;
    public String type;
    public String value;

    public int describeContents() {
        return 0;
    }

    public XmBluetoothRecord() {
    }

    protected XmBluetoothRecord(Parcel parcel) {
        this.type = parcel.readString();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.trigger = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeString(this.trigger);
    }

    public JSONObject toJson() throws JSONException {
        if (!"prop".equals(this.type) && !"event".equals(this.type)) {
            throw new IllegalArgumentException("Record's type should be prop or event");
        } else if (TextUtils.isEmpty(this.key) || TextUtils.isEmpty(this.value)) {
            throw new IllegalArgumentException("Record's key and value should not be empty");
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.type);
            jSONObject.put("key", this.key);
            jSONObject.put("value", this.value);
            if (!TextUtils.isEmpty(this.trigger)) {
                jSONObject.put("trigger", this.trigger);
            }
            return jSONObject;
        }
    }
}
