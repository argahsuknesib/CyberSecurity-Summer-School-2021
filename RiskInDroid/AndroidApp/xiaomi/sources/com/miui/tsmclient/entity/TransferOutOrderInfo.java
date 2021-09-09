package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class TransferOutOrderInfo implements Parcelable {
    public static final Parcelable.Creator<TransferOutOrderInfo> CREATOR = new Parcelable.Creator<TransferOutOrderInfo>() {
        /* class com.miui.tsmclient.entity.TransferOutOrderInfo.AnonymousClass1 */

        public final TransferOutOrderInfo createFromParcel(Parcel parcel) {
            return new TransferOutOrderInfo(parcel);
        }

        public final TransferOutOrderInfo[] newArray(int i) {
            return new TransferOutOrderInfo[i];
        }
    };
    @SerializedName("cardName")
    private String mCardType;
    @SerializedName("cplc")
    private String mCplc;
    @SerializedName("createTime")
    private String mCreateTime;
    @SerializedName("deviceModel")
    private String mDeviceModel;
    @SerializedName("needPay")
    private boolean mNeedPay;
    @SerializedName("orderId")
    private String mOrderId;
    @SerializedName("paid")
    private boolean mPaid;
    @SerializedName("payDesc")
    private String mPayDesc;
    @SerializedName("transferOutToken")
    private String mTransferOutToken;
    @SerializedName("transferStatus")
    private String mTransferStatus;
    @SerializedName("typeCode")
    private String mType;
    @SerializedName("userId")
    private String mUserId;

    public int describeContents() {
        return 0;
    }

    private TransferOutOrderInfo(Parcel parcel) {
        this.mType = "TRANSFER";
        readFromParcel(parcel);
    }

    public TransferOutOrderInfo() {
        this.mType = "TRANSFER";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUserId);
        parcel.writeString(this.mOrderId);
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mCplc);
        parcel.writeString(this.mDeviceModel);
        parcel.writeString(this.mCreateTime);
        parcel.writeString(this.mTransferStatus);
        parcel.writeString(this.mTransferOutToken);
        parcel.writeString(this.mPayDesc);
        parcel.writeByte(this.mNeedPay ? (byte) 1 : 0);
        parcel.writeByte(this.mPaid ? (byte) 1 : 0);
        parcel.writeString(this.mType);
    }

    private void readFromParcel(Parcel parcel) {
        this.mUserId = parcel.readString();
        this.mOrderId = parcel.readString();
        this.mCardType = parcel.readString();
        this.mCplc = parcel.readString();
        this.mDeviceModel = parcel.readString();
        this.mCreateTime = parcel.readString();
        this.mTransferStatus = parcel.readString();
        this.mTransferOutToken = parcel.readString();
        this.mPayDesc = parcel.readString();
        boolean z = true;
        this.mNeedPay = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.mPaid = z;
        this.mType = parcel.readString();
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }

    public String getCplc() {
        return this.mCplc;
    }

    public void setCplc(String str) {
        this.mCplc = str;
    }

    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public void setDeviceModel(String str) {
        this.mDeviceModel = str;
    }

    public String getCreateTime() {
        return this.mCreateTime;
    }

    public void setCreateTime(String str) {
        this.mCreateTime = str;
    }

    public String getTransferStatus() {
        return this.mTransferStatus;
    }

    public void setTransferStatus(String str) {
        this.mTransferStatus = str;
    }

    public String getTransferOutToken() {
        return this.mTransferOutToken;
    }

    public void setTransferOutToken(String str) {
        this.mTransferOutToken = str;
    }

    public String getPayDesc() {
        return this.mPayDesc;
    }

    public void setPayDesc(String str) {
        this.mPayDesc = str;
    }

    public boolean isNeedPay() {
        return this.mNeedPay;
    }

    public void setNeedPay(boolean z) {
        this.mNeedPay = z;
    }

    public boolean isPaid() {
        return this.mPaid;
    }

    public void setPaid(boolean z) {
        this.mPaid = z;
    }

    public String getOrderType() {
        return this.mType;
    }

    public void setOrderType(String str) {
        this.mType = str;
    }

    public boolean isReturn() {
        return "RETURN".equals(this.mType);
    }

    public boolean isTransfer() {
        return "TRANSFER".endsWith(this.mType);
    }
}
