package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.miui.tsmclient.database.JSONSerializable;
import com.miui.tsmclient.util.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomInfo implements Parcelable, JSONSerializable, ObjectParser<CustomInfo> {
    public static final Parcelable.Creator<CustomInfo> CREATOR = new Parcelable.Creator<CustomInfo>() {
        /* class com.miui.tsmclient.entity.CustomInfo.AnonymousClass1 */

        public final CustomInfo createFromParcel(Parcel parcel) {
            return new CustomInfo(parcel);
        }

        public final CustomInfo[] newArray(int i) {
            return new CustomInfo[i];
        }
    };
    private long mCustomConfigId;
    private int mCustomIssueFee;
    private String mExtra;
    private int mMaxFee;
    private int mMinFee;

    public int describeContents() {
        return 0;
    }

    public CustomInfo() {
    }

    private CustomInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMinFee);
        parcel.writeInt(this.mMaxFee);
        parcel.writeInt(this.mCustomIssueFee);
        parcel.writeString(this.mExtra);
        parcel.writeLong(this.mCustomConfigId);
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("minFee", this.mMinFee);
            jSONObject.put("maxFee", this.mMaxFee);
            jSONObject.put("customIssueFee", this.mCustomIssueFee);
            if (!TextUtils.isEmpty(this.mExtra)) {
                jSONObject.put("extra", this.mExtra);
            }
            jSONObject.put("configId", this.mCustomConfigId);
        } catch (JSONException e) {
            LogUtils.e("serialize customInfo info failed.", e);
        }
        return jSONObject;
    }

    public CustomInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mMinFee = jSONObject.optInt("minFee");
            this.mMaxFee = jSONObject.optInt("maxFee");
            this.mCustomIssueFee = jSONObject.optInt("customIssueFee");
            if (jSONObject.has("extra")) {
                this.mExtra = jSONObject.optString("extra");
            }
            if (jSONObject.has("configId")) {
                this.mCustomConfigId = jSONObject.optLong("configId");
            }
        }
        return this;
    }

    private void readFromParcel(Parcel parcel) {
        this.mMinFee = parcel.readInt();
        this.mMaxFee = parcel.readInt();
        this.mCustomIssueFee = parcel.readInt();
        this.mExtra = parcel.readString();
        this.mCustomConfigId = parcel.readLong();
    }

    public int getMinFee() {
        return this.mMinFee;
    }

    public int getMaxFee() {
        return this.mMaxFee;
    }

    public int getCustomIssueFee() {
        return this.mCustomIssueFee;
    }

    public void restoreCustomIssueFee() {
        this.mCustomIssueFee = 0;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public long getCustomConfigId() {
        return this.mCustomConfigId;
    }

    public void setCustomConfigId(long j) {
        this.mCustomConfigId = j;
    }
}
