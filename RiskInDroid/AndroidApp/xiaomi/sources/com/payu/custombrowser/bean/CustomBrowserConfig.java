package com.payu.custombrowser.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.payu.custombrowser.Bank;
import com.payu.custombrowser.util.CBUtil;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

public class CustomBrowserConfig implements Parcelable {
    public static final Parcelable.Creator<CustomBrowserConfig> CREATOR = new Parcelable.Creator<CustomBrowserConfig>() {
        /* class com.payu.custombrowser.bean.CustomBrowserConfig.AnonymousClass1 */

        public final CustomBrowserConfig createFromParcel(Parcel parcel) {
            return new CustomBrowserConfig(parcel);
        }

        public final CustomBrowserConfig[] newArray(int i) {
            return new CustomBrowserConfig[i];
        }
    };
    private int autoApprove;
    private int autoSelectOTP;
    private int disableBackButtonDialog;
    private int enableSurePay;
    private int internetRestoredWindowTTL;
    private int magicRetry = 1;
    private String merchantCheckoutActivityPath;
    private String merchantKey;
    private int merchantSMSPermission;
    private String payuPostData;
    private String postURL;
    private String sdkVersionName;
    private int showCustombrowser;
    private int storeOneClickHash;
    private int surePayBackgroundTTL;
    private int surePayMode;
    private String surePayNotificationGoodNetWorkBody;
    private String surePayNotificationGoodNetWorkHeader;
    private String surePayNotificationGoodNetworkTitle;
    private int surePayNotificationIcon;
    private String surePayNotificationPoorNetWorkBody;
    private String surePayNotificationPoorNetWorkHeader;
    private String surePayNotificationPoorNetWorkTitle;
    private String surePayNotificationTransactionNotVerifiedBody;
    private String surePayNotificationTransactionNotVerifiedHeader;
    private String surePayNotificationTransactionNotVerifiedTitle;
    private String surePayNotificationTransactionVerifiedBody;
    private String surePayNotificationTransactionVerifiedHeader;
    private String surePayNotificationTransactionVerifiedTitle;
    private String transactionID;
    private int viewPortWideEnable;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SnoozeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StoreOneClickHashMode {
    }

    public int describeContents() {
        return 0;
    }

    public int getSurePayBackgroundTTL() {
        return this.surePayBackgroundTTL;
    }

    public void setSurePayBackgroundTTL(int i) {
        this.surePayBackgroundTTL = i;
    }

    private CustomBrowserConfig() {
    }

    protected CustomBrowserConfig(Parcel parcel) {
        this.viewPortWideEnable = parcel.readInt();
        this.autoApprove = parcel.readInt();
        this.autoSelectOTP = parcel.readInt();
        this.transactionID = parcel.readString();
        this.merchantKey = parcel.readString();
        this.sdkVersionName = parcel.readString();
        this.showCustombrowser = parcel.readInt();
        this.disableBackButtonDialog = parcel.readInt();
        this.storeOneClickHash = parcel.readInt();
        this.magicRetry = parcel.readInt();
        this.merchantSMSPermission = parcel.readInt();
        this.enableSurePay = parcel.readInt();
        this.merchantCheckoutActivityPath = parcel.readString();
        this.postURL = parcel.readString();
        this.payuPostData = parcel.readString();
        this.surePayNotificationIcon = parcel.readInt();
        this.surePayNotificationGoodNetworkTitle = parcel.readString();
        this.surePayNotificationGoodNetWorkHeader = parcel.readString();
        this.surePayNotificationGoodNetWorkBody = parcel.readString();
        this.surePayNotificationPoorNetWorkTitle = parcel.readString();
        this.surePayNotificationPoorNetWorkHeader = parcel.readString();
        this.surePayNotificationPoorNetWorkBody = parcel.readString();
        this.surePayNotificationTransactionVerifiedTitle = parcel.readString();
        this.surePayNotificationTransactionVerifiedHeader = parcel.readString();
        this.surePayNotificationTransactionVerifiedBody = parcel.readString();
        this.surePayNotificationTransactionNotVerifiedTitle = parcel.readString();
        this.surePayNotificationTransactionNotVerifiedHeader = parcel.readString();
        this.surePayNotificationTransactionNotVerifiedBody = parcel.readString();
        this.surePayMode = parcel.readInt();
        this.surePayBackgroundTTL = parcel.readInt();
        this.internetRestoredWindowTTL = parcel.readInt();
    }

    public CustomBrowserConfig(String str, String str2) {
        this.transactionID = str2;
        this.merchantKey = str;
        this.surePayNotificationIcon = R.drawable.surepay_logo;
        this.surePayNotificationGoodNetworkTitle = "Internet Restored";
        this.surePayNotificationGoodNetWorkHeader = "You can now resume the transaction";
        this.surePayNotificationPoorNetWorkTitle = "No Internet Found";
        this.surePayNotificationPoorNetWorkHeader = "We could not detect internet on your device";
        this.surePayNotificationTransactionVerifiedTitle = "Transaction Verified";
        this.surePayNotificationTransactionVerifiedHeader = "The bank has verified this transaction and we are good to go.";
        this.surePayNotificationTransactionNotVerifiedTitle = "Transaction Status Unknown";
        this.surePayNotificationTransactionNotVerifiedHeader = "The bank could not verify the transaction at this time.";
        this.enableSurePay = 0;
        this.surePayMode = 1;
        this.surePayBackgroundTTL = 1800000;
        this.internetRestoredWindowTTL = 5000;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.viewPortWideEnable);
        parcel.writeInt(this.autoApprove);
        parcel.writeInt(this.autoSelectOTP);
        parcel.writeString(this.transactionID);
        parcel.writeString(this.merchantKey);
        parcel.writeString(this.sdkVersionName);
        parcel.writeInt(this.showCustombrowser);
        parcel.writeInt(this.disableBackButtonDialog);
        parcel.writeInt(this.storeOneClickHash);
        parcel.writeInt(this.magicRetry);
        parcel.writeInt(this.merchantSMSPermission);
        parcel.writeInt(this.enableSurePay);
        parcel.writeString(this.merchantCheckoutActivityPath);
        parcel.writeString(this.postURL);
        parcel.writeString(this.payuPostData);
        parcel.writeInt(this.surePayNotificationIcon);
        parcel.writeString(this.surePayNotificationGoodNetworkTitle);
        parcel.writeString(this.surePayNotificationGoodNetWorkHeader);
        parcel.writeString(this.surePayNotificationGoodNetWorkBody);
        parcel.writeString(this.surePayNotificationPoorNetWorkTitle);
        parcel.writeString(this.surePayNotificationPoorNetWorkHeader);
        parcel.writeString(this.surePayNotificationPoorNetWorkBody);
        parcel.writeString(this.surePayNotificationTransactionVerifiedTitle);
        parcel.writeString(this.surePayNotificationTransactionVerifiedHeader);
        parcel.writeString(this.surePayNotificationTransactionVerifiedBody);
        parcel.writeString(this.surePayNotificationTransactionNotVerifiedTitle);
        parcel.writeString(this.surePayNotificationTransactionNotVerifiedHeader);
        parcel.writeString(this.surePayNotificationTransactionNotVerifiedBody);
        parcel.writeInt(this.surePayMode);
        parcel.writeInt(this.surePayBackgroundTTL);
        parcel.writeInt(this.internetRestoredWindowTTL);
    }

    public String getPostURL() {
        return this.postURL;
    }

    public void setPostURL(String str) {
        this.postURL = str;
    }

    public String getPayuPostData() {
        return this.payuPostData;
    }

    public void setPayuPostData(String str) {
        this.payuPostData = str;
        HashMap<String, String> dataFromPostData = new CBUtil().getDataFromPostData(str);
        String str2 = "Product info: " + dataFromPostData.get("productinfo") + "\nAmount: " + dataFromPostData.get("amount");
        if (this.surePayNotificationGoodNetWorkBody == null) {
            setSurePayNotificationGoodNetWorkBody(str2);
        }
        if (this.surePayNotificationPoorNetWorkBody == null) {
            setSurePayNotificationPoorNetWorkBody(str2);
        }
        if (this.surePayNotificationTransactionVerifiedBody == null) {
            setSurePayNotificationTransactionVerifiedBody(str2);
        }
        if (this.surePayNotificationTransactionNotVerifiedBody == null) {
            setSurePayNotificationTransactionNotVerifiedBody(str2);
        }
        if (dataFromPostData.get("key") != null) {
            setMerchantKey(Bank.keyAnalytics == null ? dataFromPostData.get("key") : Bank.keyAnalytics);
        }
    }

    public int getEnableSurePay() {
        return this.enableSurePay;
    }

    public void setEnableSurePay(int i) {
        if (i > 3) {
            i = 3;
        }
        this.enableSurePay = i;
    }

    public int getMerchantSMSPermission() {
        return this.merchantSMSPermission;
    }

    public void setMerchantSMSPermission(boolean z) {
        this.merchantSMSPermission = z ? 1 : 0;
    }

    public int getMagicretry() {
        return this.magicRetry;
    }

    public void setmagicRetry(boolean z) {
        this.magicRetry = z ? 1 : 0;
    }

    public int getStoreOneClickHash() {
        return this.storeOneClickHash;
    }

    public void setStoreOneClickHash(int i) {
        this.storeOneClickHash = i;
    }

    public String getMerchantCheckoutActivityPath() {
        return this.merchantCheckoutActivityPath;
    }

    public void setMerchantCheckoutActivityPath(String str) {
        this.merchantCheckoutActivityPath = str;
    }

    public int getDisableBackButtonDialog() {
        return this.disableBackButtonDialog;
    }

    public void setDisableBackButtonDialog(boolean z) {
        this.disableBackButtonDialog = z ? 1 : 0;
    }

    public int getViewPortWideEnable() {
        return this.viewPortWideEnable;
    }

    public void setViewPortWideEnable(boolean z) {
        this.viewPortWideEnable = z ? 1 : 0;
    }

    public int getAutoApprove() {
        return this.autoApprove;
    }

    public void setAutoApprove(boolean z) {
        this.autoApprove = z ? 1 : 0;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public int getAutoSelectOTP() {
        return this.autoSelectOTP;
    }

    public void setAutoSelectOTP(boolean z) {
        this.autoSelectOTP = z ? 1 : 0;
    }

    public String getMerchantKey() {
        return this.merchantKey;
    }

    public void setMerchantKey(String str) {
        this.merchantKey = Bank.keyAnalytics;
        String str2 = this.merchantKey;
        if (str2 == null || str2.trim().length() <= 0) {
            this.merchantKey = str;
            Bank.keyAnalytics = str;
        }
    }

    public String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public void setSdkVersionName(String str) {
        this.sdkVersionName = str;
    }

    public int getShowCustombrowser() {
        return this.showCustombrowser;
    }

    public void setShowCustombrowser(boolean z) {
        this.showCustombrowser = z ? 1 : 0;
    }

    public String getSurePayNotificationGoodNetworkTitle() {
        return this.surePayNotificationGoodNetworkTitle;
    }

    public void setSurePayNotificationGoodNetworkTitle(String str) {
        this.surePayNotificationGoodNetworkTitle = str;
    }

    public String getSurePayNotificationGoodNetWorkHeader() {
        return this.surePayNotificationGoodNetWorkHeader;
    }

    public void setSurePayNotificationGoodNetWorkHeader(String str) {
        this.surePayNotificationGoodNetWorkHeader = str;
    }

    public String getSurePayNotificationGoodNetWorkBody() {
        return this.surePayNotificationGoodNetWorkBody;
    }

    public void setSurePayNotificationGoodNetWorkBody(String str) {
        this.surePayNotificationGoodNetWorkBody = str;
    }

    public String getSurePayNotificationPoorNetWorkTitle() {
        return this.surePayNotificationPoorNetWorkTitle;
    }

    public void setSurePayNotificationPoorNetWorkTitle(String str) {
        this.surePayNotificationPoorNetWorkTitle = str;
    }

    public String getSurePayNotificationPoorNetWorkHeader() {
        return this.surePayNotificationPoorNetWorkHeader;
    }

    public void setSurePayNotificationPoorNetWorkHeader(String str) {
        this.surePayNotificationPoorNetWorkHeader = str;
    }

    public String getSurePayNotificationPoorNetWorkBody() {
        return this.surePayNotificationPoorNetWorkBody;
    }

    public void setSurePayNotificationPoorNetWorkBody(String str) {
        this.surePayNotificationPoorNetWorkBody = str;
    }

    public String getSurePayNotificationTransactionVerifiedTitle() {
        return this.surePayNotificationTransactionVerifiedTitle;
    }

    public void setSurePayNotificationTransactionVerifiedTitle(String str) {
        this.surePayNotificationTransactionVerifiedTitle = str;
    }

    public String getSurePayNotificationTransactionVerifiedHeader() {
        return this.surePayNotificationTransactionVerifiedHeader;
    }

    public void setSurePayNotificationTransactionVerifiedHeader(String str) {
        this.surePayNotificationTransactionVerifiedHeader = str;
    }

    public String getSurePayNotificationTransactionVerifiedBody() {
        return this.surePayNotificationTransactionVerifiedBody;
    }

    public void setSurePayNotificationTransactionVerifiedBody(String str) {
        this.surePayNotificationTransactionVerifiedBody = str;
    }

    public String getSurePayNotificationTransactionNotVerifiedTitle() {
        return this.surePayNotificationTransactionNotVerifiedTitle;
    }

    public void setSurePayNotificationTransactionNotVerifiedTitle(String str) {
        this.surePayNotificationTransactionNotVerifiedTitle = str;
    }

    public String getSurePayNotificationTransactionNotVerifiedHeader() {
        return this.surePayNotificationTransactionNotVerifiedHeader;
    }

    public void setSurePayNotificationTransactionNotVerifiedHeader(String str) {
        this.surePayNotificationTransactionNotVerifiedHeader = str;
    }

    public String getSurePayNotificationTransactionNotVerifiedBody() {
        return this.surePayNotificationTransactionNotVerifiedBody;
    }

    public void setSurePayNotificationTransactionNotVerifiedBody(String str) {
        this.surePayNotificationTransactionNotVerifiedBody = str;
    }

    public int getSurePayNotificationIcon() {
        return this.surePayNotificationIcon;
    }

    public void setSurePayNotificationIcon(int i) {
        this.surePayNotificationIcon = i;
    }

    public int getSurePayMode() {
        return this.surePayMode;
    }

    public void setSurePayMode(int i) {
        this.surePayMode = i;
    }

    public int getInternetRestoredWindowTTL() {
        return this.internetRestoredWindowTTL;
    }

    public void setInternetRestoredWindowTTL(int i) {
        this.internetRestoredWindowTTL = i;
    }
}
