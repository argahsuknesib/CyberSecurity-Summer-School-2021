package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudTransitCardInfo extends PayableCardInfo {
    public static final Parcelable.Creator<CloudTransitCardInfo> CREATOR = new Parcelable.Creator<CloudTransitCardInfo>() {
        /* class com.miui.tsmclient.entity.CloudTransitCardInfo.AnonymousClass1 */

        public final CloudTransitCardInfo createFromParcel(Parcel parcel) {
            CloudTransitCardInfo cloudTransitCardInfo = new CloudTransitCardInfo(null, null);
            cloudTransitCardInfo.readFromParcel(parcel);
            return cloudTransitCardInfo;
        }

        public final CloudTransitCardInfo[] newArray(int i) {
            return new CloudTransitCardInfo[i];
        }
    };
    private String mCardBalanceTitle;
    private String mCardLastUsedDeviceModel = "";

    public CloudTransitCardInfo(String str, JSONObject jSONObject) {
        super(str);
        parse(jSONObject);
        parseExtra();
    }

    public String getCardBalanceTitle() {
        return this.mCardBalanceTitle;
    }

    public String getCardLastUsedDeviceModel() {
        return this.mCardLastUsedDeviceModel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mCardBalanceTitle);
        parcel.writeString(this.mCardLastUsedDeviceModel);
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mCardBalanceTitle = parcel.readString();
        this.mCardLastUsedDeviceModel = parcel.readString();
    }

    public boolean canTransferIn() {
        return hasTransferInOrder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudTransitCardInfo)) {
            return false;
        }
        CardInfo cardInfo = (CardInfo) obj;
        return TextUtils.equals(this.mCardType, cardInfo.mCardType) && TextUtils.equals(this.mCardDevice, cardInfo.mCardDevice);
    }

    public CardInfo parseToPayableCardInfo() {
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(this.mCardType, serialize());
        if (makeCardInfo instanceof PayableCardInfo) {
            makeCardInfo.mHasIssue = false;
            makeCardInfo.mIsReadSECorrectly = true;
            ((PayableCardInfo) makeCardInfo).mUnfinishOrderInfos = this.mUnfinishOrderInfos;
        }
        return makeCardInfo;
    }

    public CardInfo removeUnfinishedOrder() {
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(this.mCardType, serialize());
        if (makeCardInfo instanceof PayableCardInfo) {
            makeCardInfo.mHasIssue = false;
            makeCardInfo.mIsReadSECorrectly = true;
            ((PayableCardInfo) makeCardInfo).mUnfinishOrderInfos = new ArrayList();
        }
        return makeCardInfo;
    }

    private void parseExtra() {
        try {
            if (!TextUtils.isEmpty(getExtra())) {
                JSONObject jSONObject = new JSONObject(getExtra());
                this.mCardBalanceTitle = jSONObject.optString("cardTitle");
                this.mCardLastUsedDeviceModel = jSONObject.optString("fromDeviceModel");
                String optString = jSONObject.optString("transferOrder");
                if (!TextUtils.isEmpty(optString)) {
                    OrderInfo orderInfo = new OrderInfo();
                    orderInfo.parse(new JSONObject(optString));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(orderInfo);
                    this.mUnfinishOrderInfos = arrayList;
                }
            }
        } catch (JSONException e) {
            LogUtils.e("parse card extra failed", e);
        }
    }
}
