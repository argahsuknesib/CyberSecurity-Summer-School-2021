package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import org.json.JSONException;
import org.json.JSONObject;

public class MiioDevice extends Device {
    public static final Parcelable.Creator<MiioDevice> CREATOR = new Parcelable.Creator<MiioDevice>() {
        /* class com.xiaomi.smarthome.core.entity.device.MiioDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiioDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MiioDevice(parcel);
        }
    };
    private String mFwVersion;
    private boolean mIsFactory = false;
    private String mMcuVersion;

    protected MiioDevice(Parcel parcel) {
        super(parcel);
        boolean z = false;
        this.mIsFactory = parcel.readInt() == 1 ? true : z;
        this.mFwVersion = parcel.readString();
        this.mMcuVersion = parcel.readString();
    }

    public MiioDevice() {
    }

    public MiioDevice(String str, String str2) {
        super(str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mIsFactory ? 1 : 0);
        parcel.writeString(this.mFwVersion);
        parcel.writeString(this.mMcuVersion);
    }

    public void parseFromJSONObject(JSONObject jSONObject) {
        super.parseFromJSONObject(jSONObject);
        if (!TextUtils.isEmpty(getExtraInfo())) {
            try {
                JSONObject jSONObject2 = new JSONObject(getExtraInfo());
                this.mFwVersion = jSONObject2.optString("fw_version");
                this.mMcuVersion = jSONObject2.optString("mcu_version");
            } catch (JSONException unused) {
            }
        }
    }

    public void parseDBExtra() {
        super.parseDBExtra();
        if (!TextUtils.isEmpty(getExtraInfo())) {
            try {
                JSONObject jSONObject = new JSONObject(getExtraInfo());
                this.mFwVersion = jSONObject.optString("fw_version");
                this.mMcuVersion = jSONObject.optString("mcu_version");
            } catch (JSONException unused) {
            }
        }
    }

    public String getDBExtraInfo() {
        JSONObject jSONObject;
        String extraInfo = getExtraInfo();
        try {
            if (TextUtils.isEmpty(extraInfo)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(extraInfo);
            }
            jSONObject.put("is_factory", this.mIsFactory);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return extraInfo;
        }
    }
}
