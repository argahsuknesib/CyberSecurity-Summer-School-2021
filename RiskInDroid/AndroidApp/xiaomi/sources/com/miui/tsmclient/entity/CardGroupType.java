package com.miui.tsmclient.entity;

public enum CardGroupType {
    TRANSCARD(1),
    BANKCARD(2),
    MIFARECARD(3),
    EIDCARD(4),
    QRBANKCARD(5);
    
    private int mId;

    private CardGroupType(int i) {
        this.mId = i;
    }

    public static CardGroupType newInstance(int i) {
        for (CardGroupType cardGroupType : values()) {
            if (cardGroupType.mId == i) {
                return cardGroupType;
            }
        }
        return null;
    }

    public final int getId() {
        return this.mId;
    }
}
