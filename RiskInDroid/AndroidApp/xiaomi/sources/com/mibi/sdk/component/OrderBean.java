package com.mibi.sdk.component;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderBean implements Parcelable {
    public static final Parcelable.Creator<OrderBean> CREATOR = new Parcelable.Creator<OrderBean>() {
        /* class com.mibi.sdk.component.OrderBean.AnonymousClass1 */

        public final OrderBean createFromParcel(Parcel parcel) {
            OrderBean orderBean = new OrderBean();
            orderBean.mOrder = parcel.readString();
            orderBean.mOrderType = parcel.readInt();
            boolean z = true;
            orderBean.mIsNoAccount = parcel.readByte() != 0;
            orderBean.mUseBalance = parcel.readByte() != 0;
            orderBean.mUseGiftcard = parcel.readByte() != 0;
            orderBean.mUseParterGiftcard = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z = false;
            }
            orderBean.mUseUi = z;
            orderBean.mDiscountGiftCardId = parcel.readLong();
            orderBean.mRechargeFee = parcel.readLong();
            orderBean.mChannel = parcel.readString();
            orderBean.mQueryIntervalConfig = parcel.readString();
            orderBean.mPartnerUserId = parcel.readString();
            orderBean.mPartnerAccountType = parcel.readString();
            orderBean.mPartnerMarketType = parcel.readLong();
            return orderBean;
        }

        public final OrderBean[] newArray(int i) {
            return new OrderBean[i];
        }
    };
    public String mChannel;
    public long mDiscountGiftCardId;
    public boolean mIsNoAccount;
    public String mOrder;
    public int mOrderType;
    public String mPartnerAccountType;
    public long mPartnerMarketType;
    public String mPartnerUserId;
    public String mQueryIntervalConfig;
    public long mRechargeFee;
    public boolean mUseBalance;
    public boolean mUseGiftcard;
    public boolean mUseParterGiftcard;
    public boolean mUseUi;

    public int describeContents() {
        return 0;
    }

    private OrderBean() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mOrder);
        parcel.writeInt(this.mOrderType);
        parcel.writeByte(this.mIsNoAccount ? (byte) 1 : 0);
        parcel.writeByte(this.mUseBalance ? (byte) 1 : 0);
        parcel.writeByte(this.mUseGiftcard ? (byte) 1 : 0);
        parcel.writeByte(this.mUseParterGiftcard ? (byte) 1 : 0);
        parcel.writeByte(this.mUseUi ? (byte) 1 : 0);
        parcel.writeLong(this.mDiscountGiftCardId);
        parcel.writeLong(this.mRechargeFee);
        parcel.writeString(this.mChannel);
        parcel.writeString(this.mQueryIntervalConfig);
        parcel.writeString(this.mPartnerUserId);
        parcel.writeString(this.mPartnerAccountType);
        parcel.writeLong(this.mPartnerMarketType);
    }

    public static class OrderBeanBuilder {
        private OrderBean mOrderBean = new OrderBean();

        public OrderBeanBuilder setOrder(String str) {
            this.mOrderBean.mOrder = str;
            return this;
        }

        public OrderBeanBuilder setNoAccount(boolean z) {
            this.mOrderBean.mIsNoAccount = z;
            return this;
        }

        public OrderBeanBuilder useBalance(boolean z) {
            this.mOrderBean.mUseBalance = z;
            return this;
        }

        public OrderBeanBuilder useGiftcard(boolean z) {
            this.mOrderBean.mUseGiftcard = z;
            return this;
        }

        public OrderBeanBuilder usePartnerGiftcard(boolean z) {
            this.mOrderBean.mUseParterGiftcard = z;
            return this;
        }

        public OrderBeanBuilder useUi(boolean z) {
            this.mOrderBean.mUseUi = z;
            return this;
        }

        public OrderBeanBuilder setChannel(String str) {
            this.mOrderBean.mChannel = str;
            return this;
        }

        public OrderBeanBuilder setQueryIntervalConfig(String str) {
            this.mOrderBean.mQueryIntervalConfig = str;
            return this;
        }

        public OrderBeanBuilder setPartnerUserId(String str) {
            this.mOrderBean.mPartnerUserId = str;
            return this;
        }

        public OrderBeanBuilder setPartnerAccountType(String str) {
            this.mOrderBean.mPartnerAccountType = str;
            return this;
        }

        public OrderBeanBuilder setPartnerMarketType(long j) {
            this.mOrderBean.mPartnerMarketType = j;
            return this;
        }

        public OrderBeanBuilder setDiscountGiftcardId(long j) {
            this.mOrderBean.mDiscountGiftCardId = j;
            return this;
        }

        public OrderBeanBuilder setRechargeFee(long j) {
            this.mOrderBean.mRechargeFee = j;
            return this;
        }

        public OrderBean build() {
            return this.mOrderBean;
        }
    }
}
