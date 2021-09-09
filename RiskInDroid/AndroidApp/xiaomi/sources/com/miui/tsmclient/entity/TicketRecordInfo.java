package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.miui.tsmclient.database.JSONSerializable;
import com.miui.tsmclient.util.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TicketRecordInfo implements Parcelable, JSONSerializable, ObjectParser<TicketRecordInfo> {
    public static final Parcelable.Creator<TicketRecordInfo> CREATOR = new Parcelable.Creator<TicketRecordInfo>() {
        /* class com.miui.tsmclient.entity.TicketRecordInfo.AnonymousClass1 */

        public final TicketRecordInfo createFromParcel(Parcel parcel) {
            TicketRecordInfo ticketRecordInfo = new TicketRecordInfo();
            ticketRecordInfo.readFromParcel(parcel);
            return ticketRecordInfo;
        }

        public final TicketRecordInfo[] newArray(int i) {
            return new TicketRecordInfo[i];
        }
    };
    private String mDate;
    private int mInOutFlag = -1;
    private String mStationName;
    private String mTime;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mInOutFlag);
        parcel.writeString(this.mDate);
        parcel.writeString(this.mTime);
        parcel.writeString(this.mStationName);
    }

    public void readFromParcel(Parcel parcel) {
        this.mInOutFlag = parcel.readInt();
        this.mDate = parcel.readString();
        this.mTime = parcel.readString();
        this.mStationName = parcel.readString();
    }

    public TicketRecordInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mInOutFlag = jSONObject.optInt("mInOutFlag");
            this.mDate = jSONObject.optString("mDate");
            this.mTime = jSONObject.optString("mTime");
            this.mStationName = jSONObject.optString("mStationName");
        }
        return this;
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mInOutFlag", this.mInOutFlag);
            jSONObject.put("mDate", this.mDate);
            jSONObject.put("mTime", this.mTime);
            jSONObject.put("mStationName", this.mStationName);
        } catch (JSONException e) {
            LogUtils.e("serialize TicketRecordInfo failed.", e);
        }
        return jSONObject;
    }

    public int getInOutFlag() {
        return this.mInOutFlag;
    }

    public void setInOutFlag(int i) {
        this.mInOutFlag = i;
    }

    public String getDate() {
        return this.mDate;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public String getTime() {
        return this.mTime;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public String getStationName() {
        return this.mStationName;
    }

    public void setStationName(String str) {
        this.mStationName = str;
    }
}
