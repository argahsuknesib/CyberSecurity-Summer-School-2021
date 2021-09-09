package com.xiaomi.accountsdk.account;

import com.xiaomi.account.data.PassportCAToken;

public interface PassportCAExternal {
    PassportCAToken loadCAToken();

    long loadNextCAEnabledTime(long j);

    void saveCAToken(PassportCAToken passportCAToken);

    void saveNextCAEnabledTime(long j);
}
