package com.mibi.sdk.common.account;

public final class AccountRegistry {
    private static IAccountProvider sAccountProvider;
    private static ILoginProvider sLoginProvider;

    private AccountRegistry() {
    }

    public static IAccountProvider getAccountProvider() {
        return sAccountProvider;
    }

    public static void setAccountProvider(IAccountProvider iAccountProvider) {
        sAccountProvider = iAccountProvider;
    }

    public static ILoginProvider getLoginProvider() {
        return sLoginProvider;
    }

    public static void setLoginProvider(ILoginProvider iLoginProvider) {
        sLoginProvider = iLoginProvider;
    }

    public static void release() {
        sAccountProvider = null;
    }
}
