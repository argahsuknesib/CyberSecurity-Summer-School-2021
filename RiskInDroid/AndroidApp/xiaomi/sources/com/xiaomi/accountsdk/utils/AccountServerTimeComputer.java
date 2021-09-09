package com.xiaomi.accountsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.utils.ServerTimeUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AccountServerTimeComputer implements ServerTimeUtil.IServerTimeComputer {
    private static final Set<String> acceptHosts = new HashSet();
    private final AtomicBoolean alignFlag = new AtomicBoolean(false);
    private final Context context;
    private volatile long elapsedRealTimeDiff = 0;

    static {
        String[] strArr = {URLs.ACCOUNT_DOMAIN, URLs.CA_ACCOUNT_DOMAIN};
        for (int i = 0; i < 2; i++) {
            try {
                acceptHosts.add(new URL(strArr[i]).getHost().toLowerCase());
            } catch (MalformedURLException unused) {
            }
        }
    }

    public AccountServerTimeComputer(Context context2) {
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("context == null");
    }

    public long computeServerTime() {
        if (this.alignFlag.get()) {
            return SystemClock.elapsedRealtime() + this.elapsedRealTimeDiff;
        }
        return System.currentTimeMillis() + getSystemTimeDiff();
    }

    public void alignWithServerTime(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("serverDate == null");
        } else if (!this.alignFlag.get()) {
            alignServer(date);
            this.alignFlag.set(true);
        }
    }

    public void alignWithServerDateHeader(String str, String str2) {
        if (!this.alignFlag.get() && isAccountUrl(str)) {
            try {
                alignWithServerTime(DateUtils.parseDate(str2));
            } catch (ParseException e) {
                AccountLog.w("AccountServerTimeCompu", e);
            }
        }
    }

    static boolean isAccountUrl(String str) {
        try {
            return acceptHosts.contains(new URL(str).getHost().toLowerCase());
        } catch (MalformedURLException e) {
            AccountLog.w("AccountServerTimeCompu", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void alignServer(Date date) {
        long time = date.getTime();
        this.elapsedRealTimeDiff = time - SystemClock.elapsedRealtime();
        setSystemTimeDiff(time - System.currentTimeMillis());
        ServerTimeUtil.notifyServerTimeAligned();
        SyncServerTimeExecutor.getInstance().syncServerTime(date);
    }

    /* access modifiers changed from: package-private */
    public long getSystemTimeDiff() {
        return getSP().getLong("system_time_diff", 0);
    }

    /* access modifiers changed from: package-private */
    public void setSystemTimeDiff(long j) {
        getSP().edit().putLong("system_time_diff", j).apply();
    }

    /* access modifiers changed from: package-private */
    public SharedPreferences getSP() {
        return this.context.getSharedPreferences("accountsdk_servertime", 0);
    }

    /* access modifiers changed from: package-private */
    public void updateElapsedRealTimeDiffForTest(long j) {
        this.elapsedRealTimeDiff = j;
    }

    /* access modifiers changed from: package-private */
    public long getElapsedRealTimeDiffForTest() {
        return this.elapsedRealTimeDiff;
    }

    /* access modifiers changed from: package-private */
    public void setAlignedForTest(boolean z) {
        this.alignFlag.set(z);
    }
}
