package com.mibi.sdk.common.account;

import android.text.TextUtils;

public enum AccountLevel {
    SYSTEM("system"),
    GUEST("guest");
    
    private final String mLevelStr;

    private AccountLevel(String str) {
        this.mLevelStr = str;
    }

    public static AccountLevel get(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (AccountLevel accountLevel : values()) {
                if (str.equalsIgnoreCase(accountLevel.mLevelStr)) {
                    return accountLevel;
                }
            }
        }
        return SYSTEM;
    }
}
