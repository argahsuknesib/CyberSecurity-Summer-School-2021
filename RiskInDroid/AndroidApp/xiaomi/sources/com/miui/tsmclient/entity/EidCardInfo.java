package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.miui.tsmclient.util.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class EidCardInfo extends CardInfo {
    public static final Parcelable.Creator<EidCardInfo> CREATOR = new Parcelable.Creator<EidCardInfo>() {
        /* class com.miui.tsmclient.entity.EidCardInfo.AnonymousClass1 */

        public final EidCardInfo createFromParcel(Parcel parcel) {
            EidCardInfo eidCardInfo = new EidCardInfo();
            eidCardInfo.readFromParcel(parcel);
            return eidCardInfo;
        }

        public final EidCardInfo[] newArray(int i) {
            return new EidCardInfo[i];
        }
    };
    private String mCardArt;
    private int mVCStatus;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.entity.CardInfo.<init>(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.miui.tsmclient.entity.CardInfo.<init>(android.os.Parcel, com.miui.tsmclient.entity.CardInfo$1):void
      com.miui.tsmclient.entity.CardInfo.<init>(java.lang.String, boolean):void */
    public EidCardInfo() {
        super("EID", true);
        this.mCardGroupId = CardGroupType.EIDCARD.getId();
    }

    public JSONObject serialize() {
        JSONObject serialize = super.serialize();
        try {
            serialize.put("card_art", this.mCardArt);
            serialize.put("card_vc_status", this.mVCStatus);
        } catch (JSONException e) {
            LogUtils.e("serialize bankcard info to json object failed!", e);
        }
        return serialize;
    }

    public CardInfo parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.mCardArt = jSONObject.optString("card_art");
            this.mVCStatus = jSONObject.optInt("card_vc_status");
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mCardArt);
        parcel.writeInt(this.mVCStatus);
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mCardArt = parcel.readString();
        this.mVCStatus = parcel.readInt();
    }

    public String getCardArt() {
        return this.mCardArt;
    }

    public int getVCStatus() {
        return this.mVCStatus;
    }

    public void setCardArt(String str) {
        this.mCardArt = str;
    }

    public void setVCStatus(int i) {
        this.mVCStatus = i;
    }
}
