package com.mobikwik.sdk.lib;

import android.util.Log;
import com.mobikwik.sdk.lib.utils.Utils;
import java.io.Serializable;

public class TransactionConfiguration implements Serializable {
    private boolean allowMixedContent;
    private String checksumUrl;
    private String currency = "INR";
    private boolean debitWallet = true;
    private boolean disableConnectionCheck;
    private String fetchSavedCardUrl;
    private String mbkId;
    private String merchantName;
    private String mode;
    private String pgResponseUrl;
    private boolean saveCardByDefault;

    public String getChecksumUrl() {
        return this.checksumUrl;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getFetchSavedCardUrl() {
        return this.fetchSavedCardUrl;
    }

    public String getMbkId() {
        return this.mbkId;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getMode() {
        return this.mode;
    }

    public String getPgResponseUrl() {
        return this.pgResponseUrl;
    }

    public boolean isAllowMixedContent() {
        return this.allowMixedContent;
    }

    public boolean isConfigValid() {
        String str;
        if (Utils.isNull(this.mbkId)) {
            str = "MBK ID is not provided";
        } else if (Utils.isNull(this.merchantName)) {
            str = "merchantName not provided";
        } else if (Utils.isNull(this.mode)) {
            str = "mode not provided";
        } else if (Utils.isNull(this.pgResponseUrl)) {
            str = "pgResponseUrl not provided";
        } else if (!Utils.isNull(this.checksumUrl)) {
            return true;
        } else {
            str = "checksumUrl not provided";
        }
        Log.e("MobikwikSDK", str);
        return false;
    }

    public boolean isDebitWallet() {
        return this.debitWallet;
    }

    public boolean isDisableConnectionCheck() {
        return this.disableConnectionCheck;
    }

    public boolean isSaveCardByDefault() {
        return this.saveCardByDefault;
    }

    public void setAllowMixedContent(boolean z) {
        this.allowMixedContent = z;
    }

    public void setChecksumUrl(String str) {
        this.checksumUrl = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDebitWallet(boolean z) {
        this.debitWallet = z;
    }

    public void setDisableConnectionCheck(boolean z) {
        this.disableConnectionCheck = z;
    }

    public void setFetchSavedCardUrl(String str) {
        this.fetchSavedCardUrl = str;
    }

    public void setMbkId(String str) {
        this.mbkId = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setPgResponseUrl(String str) {
        this.pgResponseUrl = str;
    }

    public void setSaveCardByDefault(boolean z) {
        this.saveCardByDefault = z;
    }
}
