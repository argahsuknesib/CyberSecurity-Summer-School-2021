package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.Coder;
import org.json.JSONException;
import org.json.JSONObject;

public class FmshCardInfo extends PayableCardInfo {
    public static final Parcelable.Creator<FmshCardInfo> CREATOR = new Parcelable.Creator<FmshCardInfo>() {
        /* class com.miui.tsmclient.entity.FmshCardInfo.AnonymousClass1 */

        public final FmshCardInfo createFromParcel(Parcel parcel) {
            FmshCardInfo fmshCardInfo = new FmshCardInfo();
            fmshCardInfo.readFromParcel(parcel);
            return fmshCardInfo;
        }

        public final FmshCardInfo[] newArray(int i) {
            return new FmshCardInfo[i];
        }
    };
    public byte[] mAppNo;

    public String getTradeTimeSourceFormat() {
        return "yyyyMMdd HHmmss";
    }

    public String getTradeTimeTargetFormat() {
        return "yyyy/MM/dd HH:mm:ss";
    }

    public FmshCardInfo() {
        super(null);
    }

    public FmshCardInfo(String str) {
        super(str);
    }

    public JSONObject serialize() {
        JSONObject serialize = super.serialize();
        try {
            serialize.put("app_no", Coder.bytesToHexString(this.mAppNo));
        } catch (JSONException e) {
            LogUtils.e("serialize cardinfo to jsonobject failed!", e);
        }
        return serialize;
    }

    public CardInfo parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.mAppNo = Coder.hexStringToBytes(jSONObject.optString("app_no"));
        }
        return this;
    }

    public void updateInfo(FmshCardInfo fmshCardInfo) {
        super.updateInfo((CardInfo) fmshCardInfo);
        this.mAppNo = fmshCardInfo.mRealCardNo == null ? null : Coder.hexStringToBytes(fmshCardInfo.mRealCardNo);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        writeBytesWithNull(parcel, this.mAppNo);
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mAppNo = readBytesWithNull(parcel);
    }

    private byte[] readBytesWithNull(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        parcel.readByteArray(bArr);
        return bArr;
    }

    private void writeBytesWithNull(Parcel parcel, byte[] bArr) {
        if (bArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
    }
}
