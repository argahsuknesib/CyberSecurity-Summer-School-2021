package com.xiaomi.mico.api;

import android.accounts.Account;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountInfo {
    private static String CORE_SID = ApiConstants.MICO_SID;
    private PassportInfo mPassportInfo = new PassportInfo();
    private final Object mPassportLock = new Object();
    private Map<String, ServiceInfo> mServiceInfoMap = new ConcurrentHashMap();

    public static class PassportInfo implements Serializable {
        private static final long serialVersionUID = 4196400872621314050L;
        public String cUserId;
        public String passToken;
        public String psecurity;
        public String userId;

        private PassportInfo() {
            reset();
        }

        public void reset() {
            this.userId = "";
            this.cUserId = "";
            this.passToken = "";
            this.psecurity = "";
        }

        public String getUserId() {
            return this.userId;
        }

        public String getCUserId() {
            return this.cUserId;
        }

        public String getPassToken() {
            return this.passToken;
        }

        public boolean isValid() {
            return !TextUtils.isEmpty(this.userId);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.userId);
            objectOutputStream.writeObject(this.cUserId);
            objectOutputStream.writeObject(this.passToken);
            objectOutputStream.writeObject(this.psecurity);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.userId = (String) objectInputStream.readObject();
            this.cUserId = (String) objectInputStream.readObject();
            this.passToken = (String) objectInputStream.readObject();
            this.psecurity = (String) objectInputStream.readObject();
        }
    }

    public static class ServiceInfo implements Serializable {
        private static final long serialVersionUID = -1387759219905842987L;
        private long expireTimestamp;
        private String serviceToken;
        private String sid;
        private String ssecurity;

        private ServiceInfo(String str, String str2, String str3) {
            this(str, str2, str3, System.currentTimeMillis() + 86400000);
        }

        private ServiceInfo(String str, String str2, String str3, long j) {
            this.sid = str;
            this.serviceToken = str2;
            this.ssecurity = str3;
            this.expireTimestamp = j;
        }

        public String getServiceToken() {
            return this.serviceToken;
        }

        public boolean isServiceTokenValid() {
            if (!TextUtils.isEmpty(this.serviceToken) && this.expireTimestamp - System.currentTimeMillis() >= 14400000) {
                return true;
            }
            return false;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.sid);
            objectOutputStream.writeObject(this.serviceToken);
            objectOutputStream.writeObject(this.ssecurity);
            objectOutputStream.writeLong(this.expireTimestamp);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.sid = (String) objectInputStream.readObject();
            this.serviceToken = (String) objectInputStream.readObject();
            this.ssecurity = (String) objectInputStream.readObject();
            try {
                this.expireTimestamp = objectInputStream.readLong();
            } catch (IOException unused) {
                this.expireTimestamp = 0;
            }
        }

        public String getSsecurity() {
            return this.ssecurity;
        }

        public long getExpireTimestamp() {
            return this.expireTimestamp;
        }

        public String getSid() {
            return this.sid;
        }
    }

    static AccountInfo load(MiAccountManager miAccountManager, AccountStore accountStore) {
        AccountInfo accountInfo;
        if (miAccountManager.O00000oo() == null) {
            AccountType accountType = accountStore.getAccountType();
            if (!(accountType == AccountType.UNKNOWN || accountType == AccountType.NONE)) {
                accountStore.setAccountType(AccountType.NONE);
            }
            accountStore.removeAccountInfo();
            accountInfo = null;
        } else {
            accountInfo = accountStore.loadAccountInfo();
        }
        return accountInfo == null ? new AccountInfo() : accountInfo;
    }

    static AccountInfo newAccountInfo(PassportInfo passportInfo, Map<String, ServiceInfo> map) {
        return new AccountInfo(passportInfo, map);
    }

    private AccountInfo() {
    }

    private AccountInfo(PassportInfo passportInfo, Map<String, ServiceInfo> map) {
        this.mPassportInfo = passportInfo;
        if (map != null && !map.isEmpty()) {
            this.mServiceInfoMap.putAll(map);
        }
    }

    /* access modifiers changed from: package-private */
    public PassportInfo getPassportInfo() {
        PassportInfo passportInfo;
        synchronized (this.mPassportLock) {
            passportInfo = this.mPassportInfo;
        }
        return passportInfo;
    }

    /* access modifiers changed from: package-private */
    public Map<String, ServiceInfo> getServiceInfoMap() {
        return this.mServiceInfoMap;
    }

    /* access modifiers changed from: package-private */
    public ServiceInfo getServiceInfo(String str) {
        return this.mServiceInfoMap.get(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isPassportValid() {
        boolean isValid;
        synchronized (this.mPassportLock) {
            isValid = this.mPassportInfo.isValid();
        }
        return isValid;
    }

    /* access modifiers changed from: package-private */
    public boolean isCoreServiceValid() {
        return this.mServiceInfoMap.containsKey(ApiConstants.MICO_SID);
    }

    /* access modifiers changed from: package-private */
    public void updateAccountCoreInfo(MiAccountManager miAccountManager, AccountStore accountStore, Account account, String str, String str2) {
        String str3;
        try {
            str3 = miAccountManager.O000000o(account);
        } catch (SecurityException unused) {
            str3 = null;
        }
        updatePassportInfo(account.name, str, str3);
        updateServiceInfo(ApiConstants.MICO_SID, str2);
        if (miAccountManager.O00000Oo()) {
            accountStore.setAccountType(AccountType.SYSTEM);
        } else {
            accountStore.setAccountType(AccountType.LOCAL);
        }
        accountStore.saveAccountInfo(this);
    }

    private void updatePassportInfo(String str, String str2, String str3) {
        synchronized (this.mPassportLock) {
            this.mPassportInfo.userId = str;
            this.mPassportInfo.cUserId = str2;
            ExtendedAuthToken parse = ExtendedAuthToken.parse(str3);
            if (parse != null) {
                this.mPassportInfo.passToken = parse.authToken;
                this.mPassportInfo.psecurity = parse.security;
            }
        }
    }

    private void updateServiceInfo(String str, String str2) {
        ExtendedAuthToken parse = ExtendedAuthToken.parse(str2);
        if (parse != null) {
            this.mServiceInfoMap.put(str, new ServiceInfo(str, parse.authToken, parse.security));
        }
    }

    /* access modifiers changed from: package-private */
    public void updateServiceInfo(AccountStore accountStore, String str, String str2, String str3) {
        this.mServiceInfoMap.put(str, new ServiceInfo(str, str2, str3));
        accountStore.saveAccountInfo(this);
    }

    /* access modifiers changed from: package-private */
    public void remove(AccountStore accountStore) {
        synchronized (this.mPassportLock) {
            this.mPassportInfo.reset();
        }
        this.mServiceInfoMap.clear();
        accountStore.setAccountType(AccountType.NONE);
        accountStore.removeAccountInfo();
    }
}
