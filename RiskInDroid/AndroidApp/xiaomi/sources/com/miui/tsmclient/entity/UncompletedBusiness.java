package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.pay.OrderInfo;
import java.util.ArrayList;
import java.util.List;

public class UncompletedBusiness implements Parcelable {
    public static final Parcelable.Creator<UncompletedBusiness> CREATOR = new Parcelable.Creator<UncompletedBusiness>() {
        /* class com.miui.tsmclient.entity.UncompletedBusiness.AnonymousClass1 */

        public final UncompletedBusiness createFromParcel(Parcel parcel) {
            return new UncompletedBusiness(parcel);
        }

        public final UncompletedBusiness[] newArray(int i) {
            return new UncompletedBusiness[i];
        }
    };
    @SerializedName("aid")
    private String aid;
    @SerializedName("businessSource")
    private String businessSource;
    @SerializedName("businessStatus")
    private String businessStatus;
    @SerializedName("businessStatusDesc")
    private String businessStatusDesc;
    @SerializedName("businessStatusOtherDesc")
    private String businessStatusOtherDesc;
    @SerializedName("cardName")
    private String cardName;
    @SerializedName("uncompletedMoveInOrderInfo")
    private UncompletedMoveInOrder moveInOrderInfo;
    @SerializedName("uncompletedMoveOutOrderInfo")
    private UncompletedMoveOutOrder moveOutOrderInfo;
    @SerializedName("respDesc")
    private String respDesc;
    @SerializedName("updateTime")
    private long updateTime;
    @SerializedName("userIdMismatchDesc")
    private String userIdMismatchDesc;

    public int describeContents() {
        return 0;
    }

    protected UncompletedBusiness(Parcel parcel) {
        this.cardName = parcel.readString();
        this.aid = parcel.readString();
        this.businessSource = parcel.readString();
        this.businessStatus = parcel.readString();
        this.businessStatusDesc = parcel.readString();
        this.businessStatusOtherDesc = parcel.readString();
        this.updateTime = parcel.readLong();
        this.userIdMismatchDesc = parcel.readString();
        this.respDesc = parcel.readString();
        this.moveInOrderInfo = (UncompletedMoveInOrder) parcel.readParcelable(UncompletedMoveInOrder.class.getClassLoader());
        this.moveOutOrderInfo = (UncompletedMoveOutOrder) parcel.readParcelable(UncompletedMoveOutOrder.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cardName);
        parcel.writeString(this.aid);
        parcel.writeString(this.businessSource);
        parcel.writeString(this.businessStatus);
        parcel.writeString(this.businessStatusDesc);
        parcel.writeString(this.businessStatusOtherDesc);
        parcel.writeLong(this.updateTime);
        parcel.writeString(this.userIdMismatchDesc);
        parcel.writeString(this.respDesc);
        parcel.writeParcelable(this.moveInOrderInfo, i);
        parcel.writeParcelable(this.moveOutOrderInfo, i);
    }

    public String getAid() {
        return this.aid;
    }

    public boolean isInWalletBusiness() {
        return "IN_WALLET".equals(this.businessSource);
    }

    public String getBusinessStatus() {
        return this.businessStatus;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getBusinessStatusDesc() {
        return this.businessStatusDesc;
    }

    public String getBusinessStatusOtherDesc() {
        return this.businessStatusOtherDesc;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUserIdMismatchDesc() {
        return this.userIdMismatchDesc;
    }

    public String getRespDesc() {
        return this.respDesc;
    }

    public boolean isReturn() {
        UncompletedMoveOutOrder uncompletedMoveOutOrder = this.moveOutOrderInfo;
        return uncompletedMoveOutOrder != null && "RETURN".equals(uncompletedMoveOutOrder.mTypeCode);
    }

    public String getReturnSource() {
        return this.moveOutOrderInfo.mSource;
    }

    public boolean isIssueOrTransferIn() {
        return this.moveInOrderInfo != null;
    }

    public boolean isRefundOrTransferOut() {
        return this.moveOutOrderInfo != null;
    }

    public OrderInfo getOrderInfo() {
        UncompletedMoveInOrder uncompletedMoveInOrder = this.moveInOrderInfo;
        if (uncompletedMoveInOrder == null || uncompletedMoveInOrder.mActionTokens == null) {
            return null;
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.mOrderStatus = OrderInfo.OrderStatus.paid;
        orderInfo.mOrderId = this.moveInOrderInfo.mOrderId;
        orderInfo.mCardType = this.moveInOrderInfo.mCardType;
        orderInfo.mCityId = this.moveInOrderInfo.mCityId;
        orderInfo.mActionTokens = new ArrayList();
        for (UncompletedMoveInOrder.UncompletedActionToken next : this.moveInOrderInfo.mActionTokens) {
            ActionToken actionToken = new ActionToken();
            actionToken.mToken = next.mToken;
            actionToken.mType = ActionToken.TokenType.newInstance(next.mType);
            orderInfo.mActionTokens.add(actionToken);
        }
        return orderInfo;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public int getType() {
        char c;
        String str = this.businessStatus;
        switch (str.hashCode()) {
            case -777164067:
                if (str.equals("TRANSFER_OUT_ING")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -459887775:
                if (str.equals("OUT_RETURN")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 527466890:
                if (str.equals("IN_RETURN")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 766828668:
                if (str.equals("TRANSFER_IN_ING")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1671687455:
                if (str.equals("IN_ISSUE")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1) {
            return 2;
        }
        if (c == 2 || c == 3) {
            return 3;
        }
        return c != 4 ? 0 : 4;
    }

    public String getToken() {
        OrderInfo orderInfo = getOrderInfo();
        if (orderInfo != null) {
            for (ActionToken next : orderInfo.mActionTokens) {
                if (!next.isRechargeType()) {
                    return next.mToken;
                }
            }
        }
        TransferOutOrderInfo transferOutOrderInfo = getTransferOutOrderInfo();
        if (transferOutOrderInfo != null) {
            return transferOutOrderInfo.getTransferOutToken();
        }
        return null;
    }

    public String getRechargeToken() {
        OrderInfo orderInfo = getOrderInfo();
        if (orderInfo == null) {
            return null;
        }
        for (ActionToken next : orderInfo.mActionTokens) {
            if (next.isRechargeType()) {
                return next.mToken;
            }
        }
        return null;
    }

    public TransferOutOrderInfo getTransferOutOrderInfo() {
        if (this.moveOutOrderInfo == null) {
            return null;
        }
        TransferOutOrderInfo transferOutOrderInfo = new TransferOutOrderInfo();
        transferOutOrderInfo.setOrderId(this.moveOutOrderInfo.mOrderId);
        transferOutOrderInfo.setCardType(this.moveOutOrderInfo.mCardType);
        transferOutOrderInfo.setTransferOutToken(this.moveOutOrderInfo.mToken);
        transferOutOrderInfo.setOrderType(this.moveOutOrderInfo.mTypeCode);
        return transferOutOrderInfo;
    }

    static class UncompletedMoveInOrder implements Parcelable {
        public static final Parcelable.Creator<UncompletedMoveInOrder> CREATOR = new Parcelable.Creator<UncompletedMoveInOrder>() {
            /* class com.miui.tsmclient.entity.UncompletedBusiness.UncompletedMoveInOrder.AnonymousClass1 */

            public final UncompletedMoveInOrder createFromParcel(Parcel parcel) {
                return new UncompletedMoveInOrder(parcel);
            }

            public final UncompletedMoveInOrder[] newArray(int i) {
                return new UncompletedMoveInOrder[i];
            }
        };
        @SerializedName("tokens")
        public List<UncompletedActionToken> mActionTokens = new ArrayList();
        @SerializedName("cardName")
        public String mCardType;
        @SerializedName("cityId")
        public String mCityId;
        @SerializedName("orderId")
        public String mOrderId;

        public int describeContents() {
            return 0;
        }

        protected UncompletedMoveInOrder(Parcel parcel) {
            this.mOrderId = parcel.readString();
            this.mCardType = parcel.readString();
            this.mCityId = parcel.readString();
            parcel.readList(this.mActionTokens, UncompletedActionToken.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mOrderId);
            parcel.writeString(this.mCardType);
            parcel.writeString(this.mCityId);
            parcel.writeList(this.mActionTokens);
        }

        static class UncompletedActionToken implements Parcelable {
            public static final Parcelable.Creator<UncompletedActionToken> CREATOR = new Parcelable.Creator<UncompletedActionToken>() {
                /* class com.miui.tsmclient.entity.UncompletedBusiness.UncompletedMoveInOrder.UncompletedActionToken.AnonymousClass1 */

                public final UncompletedActionToken createFromParcel(Parcel parcel) {
                    return new UncompletedActionToken(parcel);
                }

                public final UncompletedActionToken[] newArray(int i) {
                    return new UncompletedActionToken[i];
                }
            };
            @SerializedName("token")
            public String mToken;
            @SerializedName("type")
            public int mType;

            public int describeContents() {
                return 0;
            }

            protected UncompletedActionToken(Parcel parcel) {
                this.mToken = parcel.readString();
                this.mType = parcel.readInt();
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.mToken);
                parcel.writeInt(this.mType);
            }
        }
    }

    static class UncompletedMoveOutOrder implements Parcelable {
        public static final Parcelable.Creator<UncompletedMoveOutOrder> CREATOR = new Parcelable.Creator<UncompletedMoveOutOrder>() {
            /* class com.miui.tsmclient.entity.UncompletedBusiness.UncompletedMoveOutOrder.AnonymousClass1 */

            public final UncompletedMoveOutOrder createFromParcel(Parcel parcel) {
                return new UncompletedMoveOutOrder(parcel);
            }

            public final UncompletedMoveOutOrder[] newArray(int i) {
                return new UncompletedMoveOutOrder[i];
            }
        };
        @SerializedName("cardName")
        public String mCardType;
        @SerializedName("orderId")
        public String mOrderId;
        @SerializedName("source")
        public String mSource;
        @SerializedName("token")
        public String mToken;
        @SerializedName("typeCode")
        public String mTypeCode;

        public int describeContents() {
            return 0;
        }

        protected UncompletedMoveOutOrder(Parcel parcel) {
            this.mOrderId = parcel.readString();
            this.mCardType = parcel.readString();
            this.mToken = parcel.readString();
            this.mTypeCode = parcel.readString();
            this.mSource = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mOrderId);
            parcel.writeString(this.mCardType);
            parcel.writeString(this.mToken);
            parcel.writeString(this.mTypeCode);
            parcel.writeString(this.mSource);
        }
    }
}
