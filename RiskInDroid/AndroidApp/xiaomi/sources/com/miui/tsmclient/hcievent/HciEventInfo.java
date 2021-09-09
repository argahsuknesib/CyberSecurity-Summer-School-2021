package com.miui.tsmclient.hcievent;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class HciEventInfo implements Parcelable {
    public static final Parcelable.Creator<HciEventInfo> CREATOR = new Parcelable.Creator<HciEventInfo>() {
        /* class com.miui.tsmclient.hcievent.HciEventInfo.AnonymousClass1 */

        public final HciEventInfo createFromParcel(Parcel parcel) {
            return new HciEventInfo(parcel);
        }

        public final HciEventInfo[] newArray(int i) {
            return new HciEventInfo[i];
        }
    };
    public String mAid;
    public int mBalance;
    private String mData;
    private String mDescription;
    public HciEventType mHciEventType;
    private String mHeadAid;
    private boolean mIsTradeSuccess;
    public int mStatus;
    private String mTerminalNo;
    public int mTradeAmount;
    public long mTradeTime;

    public enum HciEventType {
        Bank,
        Ticket,
        TransCard,
        CpuCardActivated,
        QRPay,
        NonTransaction;

        public static HciEventType getHciEventType(String str) {
            for (HciEventType hciEventType : values()) {
                if (hciEventType.name().equals(str)) {
                    return hciEventType;
                }
            }
            return NonTransaction;
        }
    }

    public HciEventInfo(Parcel parcel) {
        this.mIsTradeSuccess = true;
        readFromParcel(parcel);
    }

    public HciEventInfo(String str, long j, int i) {
        this.mIsTradeSuccess = true;
        this.mAid = str;
        this.mTradeTime = j;
        this.mStatus = i;
        this.mHciEventType = HciEventType.Ticket;
    }

    public HciEventInfo(String str, long j, int i, int i2, boolean z) {
        this.mIsTradeSuccess = true;
        this.mAid = str;
        this.mTradeTime = j;
        this.mTradeAmount = i;
        this.mBalance = i2;
        this.mHciEventType = z ? HciEventType.Bank : HciEventType.TransCard;
    }

    public HciEventInfo(String str, long j, int i, boolean z) {
        this(str, j, i, 0, z);
    }

    public HciEventInfo(String str, long j, boolean z) {
        this(str, j, 0, z);
    }

    public HciEventInfo(String str, HciEventType hciEventType) {
        this.mIsTradeSuccess = true;
        this.mAid = str;
        this.mHciEventType = hciEventType;
    }

    public int describeContents() {
        return 0;
    }

    public String getData() {
        return this.mData;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getHeadAid() {
        return TextUtils.isEmpty(this.mHeadAid) ? this.mAid : this.mHeadAid;
    }

    public String getTerminalNo() {
        return this.mTerminalNo;
    }

    public boolean isTradeSuccess() {
        return this.mIsTradeSuccess;
    }

    public void readFromParcel(Parcel parcel) {
        this.mAid = parcel.readString();
        this.mTradeTime = parcel.readLong();
        this.mTradeAmount = parcel.readInt();
        this.mBalance = parcel.readInt();
        this.mHciEventType = (HciEventType) parcel.readValue(HciEventType.class.getClassLoader());
        this.mStatus = parcel.readInt();
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mIsTradeSuccess = z;
        this.mTerminalNo = parcel.readString();
        this.mHeadAid = parcel.readString();
        this.mData = parcel.readString();
    }

    public void setData(String str) {
        this.mData = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setHeadAid(String str) {
        this.mHeadAid = str;
    }

    public void setTerminalNo(String str) {
        this.mTerminalNo = str;
    }

    public void setTradeState(boolean z) {
        this.mIsTradeSuccess = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAid);
        parcel.writeLong(this.mTradeTime);
        parcel.writeInt(this.mTradeAmount);
        parcel.writeInt(this.mBalance);
        parcel.writeValue(this.mHciEventType);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.mIsTradeSuccess ^ true ? 1 : 0);
        parcel.writeString(this.mTerminalNo);
        parcel.writeString(this.mHeadAid);
        parcel.writeString(this.mData);
    }
}
