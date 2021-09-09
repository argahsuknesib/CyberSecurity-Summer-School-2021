package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.DeviceUtils;
import java.util.List;

public class RiskInfo implements Parcelable {
    public static final Parcelable.Creator<RiskInfo> CREATOR = new Parcelable.Creator<RiskInfo>() {
        /* class com.miui.tsmclient.entity.RiskInfo.AnonymousClass1 */

        public final RiskInfo createFromParcel(Parcel parcel) {
            return new RiskInfo(parcel);
        }

        public final RiskInfo[] newArray(int i) {
            return new RiskInfo[i];
        }
    };
    private String mAccountEmailLife;
    private String mAccountIDHash;
    private int mAccountScore;
    private TsmRpcModels.ApplyChannel mApplyChannel;
    private String mBillingAddress;
    private String mBillingZip;
    private TsmRpcModels.CaptureMethod mCaptureMethod;
    private String mCardHolderName;
    private String mDeviceLanguage;
    private String mDeviceLocation;
    private String mDeviceName;
    private String mDeviceNumber;
    private int mDeviceSIMNumber;
    private int mDeviceScore;
    private TsmRpcModels.DeviceType mDeviceType;
    private String mExtensiveDeviceLocation;
    private List<String> mFullDeviceNumber;
    private int mPhoneNumberScore;
    private List<String> mRiskReasonCode;
    private int mRiskScore;
    private String mRiskStandardVersion;
    private String mSourceIP;

    public int describeContents() {
        return 0;
    }

    public TsmRpcModels.DeviceType getDeviceType() {
        return this.mDeviceType;
    }

    public void setDeviceType(TsmRpcModels.DeviceType deviceType) {
        this.mDeviceType = deviceType;
    }

    public String getDeviceLanguage() {
        return this.mDeviceLanguage;
    }

    public void setDeviceLanguage(String str) {
        this.mDeviceLanguage = str;
    }

    public TsmRpcModels.ApplyChannel getApplyChannel() {
        return this.mApplyChannel;
    }

    public void setApplyChannel(TsmRpcModels.ApplyChannel applyChannel) {
        this.mApplyChannel = applyChannel;
    }

    public String getDeviceLocation() {
        return this.mDeviceLocation;
    }

    public void setDeviceLocation(String str) {
        this.mDeviceLocation = str;
    }

    public String getExtensiveDeviceLocation() {
        return this.mExtensiveDeviceLocation;
    }

    public void setExtensiveDeviceLocation(String str) {
        this.mExtensiveDeviceLocation = str;
    }

    public TsmRpcModels.CaptureMethod getCaptureMethod() {
        return this.mCaptureMethod;
    }

    public void setCaptureMethod(TsmRpcModels.CaptureMethod captureMethod) {
        this.mCaptureMethod = captureMethod;
    }

    public String getAccountEmailLife() {
        return this.mAccountEmailLife;
    }

    public void setAccountEmailLife(String str) {
        this.mAccountEmailLife = str;
    }

    public String getCardHolderName() {
        return this.mCardHolderName;
    }

    public void setCardHolderName(String str) {
        this.mCardHolderName = str;
    }

    public String getBillingAddress() {
        return this.mBillingAddress;
    }

    public void setBillingAddress(String str) {
        this.mBillingAddress = str;
    }

    public String getBillingZip() {
        return this.mBillingZip;
    }

    public void setBillingZip(String str) {
        this.mBillingZip = str;
    }

    public int getRiskScore() {
        return this.mRiskScore;
    }

    public void setRiskScore(int i) {
        this.mRiskScore = i;
    }

    public String getRiskStandardVersion() {
        return this.mRiskStandardVersion;
    }

    public void setRiskStandardVersion(String str) {
        this.mRiskStandardVersion = str;
    }

    public int getDeviceScore() {
        return this.mDeviceScore;
    }

    public void setDeviceScore(int i) {
        this.mDeviceScore = i;
    }

    public int getAccountScore() {
        return this.mAccountScore;
    }

    public void setAccountScore(int i) {
        this.mAccountScore = i;
    }

    public int getPhoneNumberScore() {
        return this.mPhoneNumberScore;
    }

    public void setPhoneNumberScore(int i) {
        this.mPhoneNumberScore = i;
    }

    public List<String> getRiskReasonCode() {
        return this.mRiskReasonCode;
    }

    public void setRiskReasonCode(List<String> list) {
        this.mRiskReasonCode = list;
    }

    public String getSourceIP() {
        return this.mSourceIP;
    }

    public void setSourceIP(String str) {
        this.mSourceIP = str;
    }

    public int getDeviceSIMNumber() {
        return this.mDeviceSIMNumber;
    }

    public void setDeviceSIMNumber(int i) {
        this.mDeviceSIMNumber = i;
    }

    public String getAccountIDHash() {
        return this.mAccountIDHash;
    }

    public void setAccountIDHash(String str) {
        this.mAccountIDHash = str;
    }

    public List<String> getFullDeviceNumber() {
        return this.mFullDeviceNumber;
    }

    public void setFullDeviceNumber(List<String> list) {
        this.mFullDeviceNumber = list;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public String getDeviceNumber() {
        return this.mDeviceNumber;
    }

    public void setDeviceNumber(String str) {
        this.mDeviceNumber = str;
    }

    public static class Builder {
        private RiskInfo mRiskInfo = new RiskInfo();

        public Builder setDeviceType(TsmRpcModels.DeviceType deviceType) {
            this.mRiskInfo.setDeviceType(deviceType);
            return this;
        }

        public Builder setApplyChannel(TsmRpcModels.ApplyChannel applyChannel) {
            this.mRiskInfo.setApplyChannel(applyChannel);
            return this;
        }

        public Builder setCaptureMethod(TsmRpcModels.CaptureMethod captureMethod) {
            this.mRiskInfo.setCaptureMethod(captureMethod);
            return this;
        }

        public Builder setAccountEmailLife(String str) {
            this.mRiskInfo.setAccountEmailLife(str);
            return this;
        }

        public Builder setCardHolerName(String str) {
            this.mRiskInfo.setCardHolderName(str);
            return this;
        }

        public Builder setBillingAddress(String str) {
            this.mRiskInfo.setBillingAddress(str);
            return this;
        }

        public Builder setBillingZip(String str) {
            this.mRiskInfo.setBillingZip(str);
            return this;
        }

        public RiskInfo build() {
            this.mRiskInfo.setDeviceLanguage(DeviceUtils.getDeviceLanguage6393());
            List<String> sIMNumber = DeviceUtils.getSIMNumber(null);
            this.mRiskInfo.setFullDeviceNumber(sIMNumber);
            this.mRiskInfo.setDeviceSIMNumber(sIMNumber.size());
            this.mRiskInfo.setDeviceName(DeviceUtils.getDeviceModel(null));
            return this.mRiskInfo;
        }
    }

    private RiskInfo() {
        this.mDeviceLanguage = "";
        this.mDeviceName = "";
        this.mDeviceLocation = "";
        this.mExtensiveDeviceLocation = "";
        this.mAccountEmailLife = "";
        this.mCardHolderName = "";
        this.mBillingAddress = "";
        this.mBillingZip = "";
        this.mRiskStandardVersion = "";
        this.mDeviceNumber = "";
        this.mSourceIP = "";
        this.mAccountIDHash = "";
    }

    public TsmRpcModels.RiskInfo.Builder buildTSMRiskInfoBuilder() {
        TsmRpcModels.RiskInfo.Builder newBuilder = TsmRpcModels.RiskInfo.newBuilder();
        newBuilder.setDeviceType(getDeviceType());
        newBuilder.setDeviceLanguage(getDeviceLanguage());
        newBuilder.setDeviceName(getDeviceName());
        newBuilder.setApplyChannel(getApplyChannel());
        newBuilder.setDeviceLocation(getDeviceLocation());
        newBuilder.setExtensiveDeviceLocation(getExtensiveDeviceLocation());
        newBuilder.setCaptureMethod(getCaptureMethod());
        newBuilder.setAccountEmailLife(getAccountEmailLife());
        newBuilder.setCardHolderName(getCardHolderName());
        newBuilder.setBillingAddress(getBillingAddress());
        newBuilder.setBillingZip(getBillingZip());
        newBuilder.setRiskScore(getRiskScore());
        newBuilder.setRiskStandardVersion(getRiskStandardVersion());
        newBuilder.setDeviceScore(getDeviceScore());
        newBuilder.setAccountScore(getAccountScore());
        newBuilder.setPhoneNumberScore(getPhoneNumberScore());
        newBuilder.setDeviceType(getDeviceType());
        newBuilder.setDeviceNumber(getDeviceNumber());
        newBuilder.addAllFullDeviceNumber(getFullDeviceNumber());
        newBuilder.setSourceIP(getSourceIP());
        newBuilder.setDeviceSIMNumber(getDeviceSIMNumber());
        newBuilder.setAccountIDHash(getAccountIDHash());
        return newBuilder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        TsmRpcModels.DeviceType deviceType = this.mDeviceType;
        int i2 = -1;
        parcel.writeInt(deviceType == null ? -1 : deviceType.ordinal());
        parcel.writeString(this.mDeviceLanguage);
        parcel.writeString(this.mDeviceName);
        TsmRpcModels.ApplyChannel applyChannel = this.mApplyChannel;
        parcel.writeInt(applyChannel == null ? -1 : applyChannel.ordinal());
        parcel.writeString(this.mDeviceLocation);
        parcel.writeString(this.mExtensiveDeviceLocation);
        TsmRpcModels.CaptureMethod captureMethod = this.mCaptureMethod;
        if (captureMethod != null) {
            i2 = captureMethod.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.mAccountEmailLife);
        parcel.writeString(this.mCardHolderName);
        parcel.writeString(this.mBillingAddress);
        parcel.writeString(this.mBillingZip);
        parcel.writeInt(this.mRiskScore);
        parcel.writeString(this.mRiskStandardVersion);
        parcel.writeInt(this.mDeviceScore);
        parcel.writeInt(this.mAccountScore);
        parcel.writeInt(this.mPhoneNumberScore);
        parcel.writeStringList(this.mRiskReasonCode);
        parcel.writeString(this.mDeviceNumber);
        parcel.writeStringList(this.mFullDeviceNumber);
        parcel.writeString(this.mSourceIP);
        parcel.writeInt(this.mDeviceSIMNumber);
        parcel.writeString(this.mAccountIDHash);
    }

    protected RiskInfo(Parcel parcel) {
        TsmRpcModels.DeviceType deviceType;
        TsmRpcModels.ApplyChannel applyChannel;
        this.mDeviceLanguage = "";
        this.mDeviceName = "";
        this.mDeviceLocation = "";
        this.mExtensiveDeviceLocation = "";
        this.mAccountEmailLife = "";
        this.mCardHolderName = "";
        this.mBillingAddress = "";
        this.mBillingZip = "";
        this.mRiskStandardVersion = "";
        this.mDeviceNumber = "";
        this.mSourceIP = "";
        this.mAccountIDHash = "";
        int readInt = parcel.readInt();
        TsmRpcModels.CaptureMethod captureMethod = null;
        if (readInt == -1) {
            deviceType = null;
        } else {
            deviceType = TsmRpcModels.DeviceType.values()[readInt];
        }
        this.mDeviceType = deviceType;
        this.mDeviceLanguage = parcel.readString();
        this.mDeviceName = parcel.readString();
        int readInt2 = parcel.readInt();
        if (readInt2 == -1) {
            applyChannel = null;
        } else {
            applyChannel = TsmRpcModels.ApplyChannel.values()[readInt2];
        }
        this.mApplyChannel = applyChannel;
        this.mDeviceLocation = parcel.readString();
        this.mExtensiveDeviceLocation = parcel.readString();
        int readInt3 = parcel.readInt();
        this.mCaptureMethod = readInt3 != -1 ? TsmRpcModels.CaptureMethod.values()[readInt3] : captureMethod;
        this.mAccountEmailLife = parcel.readString();
        this.mCardHolderName = parcel.readString();
        this.mBillingAddress = parcel.readString();
        this.mBillingZip = parcel.readString();
        this.mRiskScore = parcel.readInt();
        this.mRiskStandardVersion = parcel.readString();
        this.mDeviceScore = parcel.readInt();
        this.mAccountScore = parcel.readInt();
        this.mPhoneNumberScore = parcel.readInt();
        this.mRiskReasonCode = parcel.createStringArrayList();
        this.mDeviceNumber = parcel.readString();
        this.mFullDeviceNumber = parcel.createStringArrayList();
        this.mSourceIP = parcel.readString();
        this.mDeviceSIMNumber = parcel.readInt();
        this.mAccountIDHash = parcel.readString();
    }
}
