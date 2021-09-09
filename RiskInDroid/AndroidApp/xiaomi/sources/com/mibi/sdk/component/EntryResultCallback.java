package com.mibi.sdk.component;

import com.mibi.sdk.common.account.loader.AccountLoader;

public interface EntryResultCallback {
    void onEntryFailed(int i, String str);

    void onEntrySuccess(AccountLoader accountLoader);
}
