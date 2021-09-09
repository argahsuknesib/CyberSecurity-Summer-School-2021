package com.xiaomi.mico.api;

interface AccountStore {
    AccountType getAccountType();

    AccountInfo loadAccountInfo();

    void removeAccountInfo();

    void saveAccountInfo(AccountInfo accountInfo);

    void setAccountType(AccountType accountType);
}
