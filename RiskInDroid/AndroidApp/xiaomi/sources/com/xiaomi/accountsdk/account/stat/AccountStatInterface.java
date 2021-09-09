package com.xiaomi.accountsdk.account.stat;

import android.text.TextUtils;
import java.util.Map;

public abstract class AccountStatInterface {
    private static AccountStatInterface sInstance = new EmptyAccountStatImplementation();

    public abstract void statCountEvent(String str, String str2);

    public abstract void statCountEvent(String str, String str2, Map<String, String> map);

    public abstract void statHttpEvent(String str, long j);

    public abstract void statHttpEvent(String str, Exception exc);

    public abstract void statPageEnd(String str);

    public abstract void statPageStart(String str);

    public static AccountStatInterface getInstance() {
        return sInstance;
    }

    public static void setInstance(AccountStatInterface accountStatInterface) {
        sInstance = accountStatInterface;
    }

    public static String dropUnusedUrlParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://dummyurl/")) {
            return str;
        }
        String[] split = str.split("\\?");
        return split.length > 0 ? split[0] : str;
    }

    static class EmptyAccountStatImplementation extends AccountStatInterface {
        public void statCountEvent(String str, String str2) {
        }

        public void statCountEvent(String str, String str2, Map<String, String> map) {
        }

        public void statHttpEvent(String str, long j) {
        }

        public void statHttpEvent(String str, Exception exc) {
        }

        public void statPageEnd(String str) {
        }

        public void statPageStart(String str) {
        }

        private EmptyAccountStatImplementation() {
        }
    }
}
