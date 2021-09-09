package com.miui.tsmclient.account;

public class AccountManagerFactory {
    public static IAccountManager createAccountManager() {
        return new TSMAccountManager();
    }
}
