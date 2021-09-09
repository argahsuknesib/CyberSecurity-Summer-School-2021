package com.miui.tsmclient.entity;

public enum CardActionType {
    UNKNOWN(-1),
    ISSUE(1),
    RECHARGE(2),
    TRANSFER(3),
    TRANSFER_OUT(4),
    TRANSFER_IN(5),
    AFTER_SALE(10);
    
    private int mId;

    private CardActionType(int i) {
        this.mId = i;
    }

    public static CardActionType get(int i) {
        for (CardActionType cardActionType : values()) {
            if (cardActionType.mId == i) {
                return cardActionType;
            }
        }
        return UNKNOWN;
    }

    public final int getId() {
        return this.mId;
    }
}
