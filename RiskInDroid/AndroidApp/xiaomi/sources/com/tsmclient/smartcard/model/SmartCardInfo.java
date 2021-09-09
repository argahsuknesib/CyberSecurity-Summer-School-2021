package com.tsmclient.smartcard.model;

public class SmartCardInfo {
    protected String mCardCode;
    protected String mCardId;
    protected String mCardLogoPath;
    protected String mCardName;
    protected int mIssuable = 0;

    public int getIssuable() {
        return this.mIssuable;
    }

    public void setIssuable(int i) {
        this.mIssuable = i;
    }

    public String getCardId() {
        return this.mCardId;
    }

    public void setCardId(String str) {
        this.mCardId = str;
    }

    public String getCardCode() {
        return this.mCardCode;
    }

    public void setCardCode(String str) {
        this.mCardCode = str;
    }

    public String getCardName() {
        return this.mCardName;
    }

    public void setCardName(String str) {
        this.mCardName = str;
    }

    public String getCardLogo() {
        return this.mCardLogoPath;
    }

    public void setCardLogo(String str) {
        this.mCardLogoPath = str;
    }
}
