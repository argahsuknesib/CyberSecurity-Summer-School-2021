package com.miui.tsmclient.entity;

import android.text.TextUtils;

public class RfCardCacheData {
    private String mAid;
    private int mCardGroupId;
    private int mPickType;

    public RfCardCacheData(CardInfo cardInfo, int i) {
        if (cardInfo != null) {
            this.mAid = cardInfo.mAid;
            this.mCardGroupId = cardInfo.mCardGroupId;
            this.mPickType = i;
            return;
        }
        this.mAid = "none";
    }

    public RfCardCacheData(CardInfo cardInfo) {
        this(cardInfo, 0);
    }

    public RfCardCacheData(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("&");
            if (split.length > 0) {
                this.mAid = split[0];
            }
            if (split.length > 1 && TextUtils.isDigitsOnly(split[1])) {
                this.mCardGroupId = Integer.valueOf(split[1]).intValue();
            }
            if (split.length > 2 && TextUtils.isDigitsOnly(split[2])) {
                this.mPickType = Integer.valueOf(split[2]).intValue();
            }
        }
    }

    public String buildCacheStr() {
        return this.mAid + "&" + this.mCardGroupId + "&" + this.mPickType;
    }

    public CardInfo getCardInfo() {
        CardInfo cardInfo = new CardInfo("DUMMY");
        cardInfo.mAid = this.mAid;
        cardInfo.mCardGroupId = this.mCardGroupId;
        return cardInfo;
    }

    public String getAid() {
        return this.mAid;
    }

    public CardGroupType getCardGroupType() {
        return CardGroupType.newInstance(this.mCardGroupId);
    }

    public int getPickType() {
        return this.mPickType;
    }
}
