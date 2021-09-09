package com.xiaomi.accountsdk.account.data;

public enum Gender {
    MALE("m"),
    FEMALE("f");
    
    private String mGender;

    private Gender(String str) {
        this.mGender = str;
    }

    public final String getType() {
        return this.mGender;
    }
}
