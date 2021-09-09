package com.miui.tsmclient.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.pay.OrderInfo;
import java.util.List;

public class OrderDetailInfo {
    @SerializedName("cardName")
    private String mCardType;
    @SerializedName("hint")
    private String mHint;
    @SerializedName("orderFlow")
    private List<OrderFlow> mOrderFlows;
    @SerializedName("orderId")
    private String mOrderId;
    @SerializedName("refundDesc")
    private String mRefundDesc;
    @SerializedName("spOrderId")
    private String mSpOrderId;
    @SerializedName("status")
    private int mStatus;
    @SerializedName("statusDesc")
    private String mStatusDesc;
    @SerializedName("shouldReadCardWhenRefund")
    private boolean mSyncBeforeRefund;
    @SerializedName("time")
    private String mTime;
    @SerializedName("unfinishedOrder")
    private OrderInfo mUnfinishedOrder;

    public static class OrderFlow {
        @SerializedName("amount")
        private int mAmount;
        @SerializedName("desc")
        private String mDesc;
        @SerializedName("leftTitle")
        private String mKey;
        @SerializedName("leftContent")
        private String mSubKey;
        @SerializedName("rightContent")
        private String mSubValue;
        @SerializedName("time")
        private String mTime;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("rightTitle")
        private String mValue;

        public String getTitle() {
            return this.mTitle;
        }

        public String getDesc() {
            return this.mDesc;
        }

        public String getTime() {
            return this.mTime;
        }

        public int getAmount() {
            return this.mAmount;
        }

        public String getKey() {
            return this.mKey;
        }

        public String getSubKey() {
            return this.mSubKey;
        }

        public String getValue() {
            return this.mValue;
        }

        public String getSubValue() {
            return this.mSubValue;
        }

        public boolean shouldShowNewOrderFlow() {
            return !TextUtils.isEmpty(this.mKey) || !TextUtils.isEmpty(this.mSubKey) || !TextUtils.isEmpty(this.mValue) || !TextUtils.isEmpty(this.mSubValue);
        }
    }

    public String getCardType() {
        return this.mCardType;
    }

    public String getHint() {
        return this.mHint;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getSpOrderId() {
        return this.mSpOrderId;
    }

    public String getStatusDesc() {
        return this.mStatusDesc;
    }

    public String getRefundDesc() {
        return this.mRefundDesc;
    }

    public String getTime() {
        return this.mTime;
    }

    public boolean isSyncBeforeRefund() {
        return this.mSyncBeforeRefund;
    }

    public OrderInfo getUnfinishedOrder() {
        return this.mUnfinishedOrder;
    }

    public List<OrderFlow> getOrderFlows() {
        return this.mOrderFlows;
    }

    public boolean isSuccess() {
        return (this.mStatus & 1) == 1 || isRefundSuccess();
    }

    public boolean canRefund() {
        return (this.mStatus & 2) == 2;
    }

    public boolean canRetry() {
        return (this.mStatus & 4) == 4;
    }

    public boolean isRefundSuccess() {
        return (this.mStatus & 8) == 8;
    }

    public int getRechargeAmount() {
        if (isRechargeOrder()) {
            return this.mUnfinishedOrder.getRechargeAmount();
        }
        return 0;
    }

    public boolean isRechargeOrder() {
        OrderInfo orderInfo = this.mUnfinishedOrder;
        if (orderInfo != null) {
            return orderInfo.isRechargeOrder();
        }
        return false;
    }

    public boolean isIssueOrWithdrawOrder() {
        OrderInfo orderInfo = this.mUnfinishedOrder;
        return orderInfo != null && orderInfo.isIssueOrWithdrawOrder();
    }

    public boolean isIssuable(CardInfo cardInfo) {
        return cardInfo != null && !cardInfo.mHasIssue && isIssueOrWithdrawOrder();
    }
}
