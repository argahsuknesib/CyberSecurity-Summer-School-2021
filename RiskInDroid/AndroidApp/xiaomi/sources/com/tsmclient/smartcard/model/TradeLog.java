package com.tsmclient.smartcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class TradeLog implements Parcelable, Comparable<TradeLog> {
    public static final Parcelable.Creator<TradeLog> CREATOR = new Parcelable.Creator<TradeLog>() {
        /* class com.tsmclient.smartcard.model.TradeLog.AnonymousClass1 */

        public final TradeLog createFromParcel(Parcel parcel) {
            TradeLog tradeLog = new TradeLog();
            tradeLog.setTradeDate(parcel.readString());
            tradeLog.setTradeTime(parcel.readString());
            tradeLog.setAuAmount(parcel.readFloat());
            tradeLog.setCountryCode(parcel.readString());
            tradeLog.setCurCode(parcel.readInt());
            tradeLog.setBusinessName(parcel.readString());
            tradeLog.setTradeType(parcel.readInt());
            tradeLog.setAtc(parcel.readString());
            tradeLog.setTradeID(parcel.readInt());
            tradeLog.setTerminalNo(parcel.readString());
            tradeLog.setTrafficType(parcel.readString());
            tradeLog.setStartToEndStartion(parcel.readString());
            return tradeLog;
        }

        public final TradeLog[] newArray(int i) {
            return new TradeLog[i];
        }
    };
    @SerializedName("atc")
    private String mAtc;
    @SerializedName("auAmount")
    private float mAuAmount;
    @SerializedName("businessName")
    private String mBusinessName;
    @SerializedName("countryCode")
    private String mCountryCode;
    @SerializedName("curCode")
    private int mCurCode;
    private String mStartToEndStation;
    @SerializedName("terminalNo")
    private String mTerminalNo;
    @SerializedName("tradeDate")
    private String mTradeDate;
    @SerializedName("tradeID")
    private int mTradeID;
    @SerializedName("tradeTime")
    private String mTradeTime;
    @SerializedName("tradeType")
    private int mTradeType;
    private String mTrafficType;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTradeDate);
        parcel.writeString(this.mTradeTime);
        parcel.writeFloat(this.mAuAmount);
        parcel.writeString(this.mCountryCode);
        parcel.writeInt(this.mCurCode);
        parcel.writeString(this.mBusinessName);
        parcel.writeInt(this.mTradeType);
        parcel.writeString(this.mAtc);
        parcel.writeInt(this.mTradeID);
        parcel.writeString(this.mTerminalNo);
        parcel.writeString(this.mTrafficType);
        parcel.writeString(this.mStartToEndStation);
    }

    public String getTradeDate() {
        return this.mTradeDate;
    }

    public void setTradeDate(String str) {
        this.mTradeDate = str;
    }

    public String getTradeTime() {
        return this.mTradeTime;
    }

    public void setTradeTime(String str) {
        this.mTradeTime = str;
    }

    public float getAuAmount() {
        return this.mAuAmount;
    }

    public void setAuAmount(float f) {
        this.mAuAmount = f;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public void setCountryCode(String str) {
        this.mCountryCode = str;
    }

    public int getCurCode() {
        return this.mCurCode;
    }

    public void setCurCode(int i) {
        this.mCurCode = i;
    }

    public String getBusinessName() {
        return this.mBusinessName;
    }

    public void setBusinessName(String str) {
        this.mBusinessName = str;
    }

    public int getTradeType() {
        return this.mTradeType;
    }

    public void setTradeType(int i) {
        this.mTradeType = i;
    }

    public String getAtc() {
        return this.mAtc;
    }

    public void setAtc(String str) {
        this.mAtc = str;
    }

    public int getTradeID() {
        return this.mTradeID;
    }

    public void setTradeID(int i) {
        this.mTradeID = i;
    }

    public String getTerminalNo() {
        return this.mTerminalNo;
    }

    public void setTerminalNo(String str) {
        this.mTerminalNo = str;
    }

    public String getTrafficType() {
        return this.mTrafficType;
    }

    public void setTrafficType(String str) {
        this.mTrafficType = str;
    }

    public String getStartToEndStation() {
        return this.mStartToEndStation;
    }

    public void setStartToEndStartion(String str) {
        this.mStartToEndStation = str;
    }

    public String toString() {
        return "\nTrade Date :" + getTradeDate() + "\nTrade Time :" + getTradeTime() + "\nAuAmount :" + getAuAmount() + "\nCountry Code :" + getCountryCode() + "\nCurrency code :" + getCurCode() + "\nBusiness Name :" + getBusinessName() + "\nTrade type :" + getTradeType() + "\nAtc :" + getAtc() + "\nTrade ID :" + getTradeID() + "\nTerminal No :" + getTerminalNo();
    }

    public int compareTo(TradeLog tradeLog) {
        long parseLong = Long.parseLong(getTradeDate() + getTradeTime());
        long parseLong2 = parseLong - Long.parseLong(tradeLog.getTradeDate() + tradeLog.getTradeTime());
        if (parseLong2 > 0) {
            return -1;
        }
        return parseLong2 < 0 ? 1 : 0;
    }
}
