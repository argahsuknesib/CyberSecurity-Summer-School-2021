package com.miui.tsmclient.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class ReturnCardPayAccountExtra implements Parcelable {
    public static final Parcelable.Creator<ReturnCardPayAccountExtra> CREATOR = new Parcelable.Creator<ReturnCardPayAccountExtra>() {
        /* class com.miui.tsmclient.entity.ReturnCardPayAccountExtra.AnonymousClass1 */

        public final ReturnCardPayAccountExtra createFromParcel(Parcel parcel) {
            return new ReturnCardPayAccountExtra(parcel);
        }

        public final ReturnCardPayAccountExtra[] newArray(int i) {
            return new ReturnCardPayAccountExtra[i];
        }
    };
    public static String KEY_RETURN_CARD_PAY_ACCOUNT_ID = "return_card_pay_account_id";
    public static String KEY_RETURN_CARD_PAY_ACCOUNT_NAME = "return_card_pay_account_name";
    public static String KEY_RETURN_CARD_PAY_ACCOUNT_TYPE = "return_card_pay_account_type";
    public static String KEY_RETURN_CARD_PHONE_NUMBER = "return_card_phone_number";
    public static String KEY_RETURN_CARD_REASON_CODE = "return_card_reason_code";
    public static String PAY_ACCOUNT_TYPE_ALIPAY = "ALIPAY";
    public static String PAY_ACCOUNT_TYPE_DEBIT_CARD = "DEBIT_CARD";
    public static String PAY_ACCOUNT_TYPE_WECHAT_PAY = "WECHAT_PAY";
    private String mPayAccountId;
    private String mPayAccountName;
    private String mPayAccountType;
    private String mPhoneNumber;

    public int describeContents() {
        return 0;
    }

    public ReturnCardPayAccountExtra(String str, String str2, String str3) {
        this.mPayAccountType = PAY_ACCOUNT_TYPE_ALIPAY;
        this.mPayAccountName = str;
        this.mPayAccountId = str2;
        this.mPhoneNumber = str3;
    }

    public ReturnCardPayAccountExtra(String str, String str2, String str3, String str4) {
        this.mPayAccountType = str;
        this.mPayAccountName = str2;
        this.mPayAccountId = str3;
        this.mPhoneNumber = str4;
    }

    public String getPayAccountType() {
        return this.mPayAccountType;
    }

    public String getPayAccountName() {
        return this.mPayAccountName;
    }

    public String getPayAccountId() {
        return this.mPayAccountId;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    protected ReturnCardPayAccountExtra(Parcel parcel) {
        this.mPayAccountType = parcel.readString();
        this.mPayAccountName = parcel.readString();
        this.mPayAccountId = parcel.readString();
        this.mPhoneNumber = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPayAccountType);
        parcel.writeString(this.mPayAccountName);
        parcel.writeString(this.mPayAccountId);
        parcel.writeString(this.mPhoneNumber);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RETURN_CARD_PAY_ACCOUNT_TYPE, this.mPayAccountType);
        bundle.putString(KEY_RETURN_CARD_PAY_ACCOUNT_NAME, this.mPayAccountName);
        bundle.putString(KEY_RETURN_CARD_PAY_ACCOUNT_ID, this.mPayAccountId);
        bundle.putString(KEY_RETURN_CARD_PHONE_NUMBER, this.mPhoneNumber);
        return bundle;
    }
}
