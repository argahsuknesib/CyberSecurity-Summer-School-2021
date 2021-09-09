package com.xiaomi.accountsdk.account.data;

@Deprecated
public enum BindingType {
    ADD_SAFE_EMAIL,
    REPLACE_SAFE_EMAIL,
    ADD_PHONE,
    REPLACE_PHONE,
    DELETE_PHONE;

    public final boolean isBindingEmail() {
        return this == ADD_SAFE_EMAIL || this == REPLACE_SAFE_EMAIL;
    }

    public final boolean isBindingPhone() {
        return this == ADD_PHONE || this == REPLACE_PHONE || this == DELETE_PHONE;
    }
}
