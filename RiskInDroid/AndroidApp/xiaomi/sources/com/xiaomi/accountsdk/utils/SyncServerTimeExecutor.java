package com.xiaomi.accountsdk.utils;

import android.os.SystemClock;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SyncServerTimeExecutor {
    public static final String URL = (URLs.URL_ACOUNT_API_BASE_SECURE + "/configuration");
    private static final SyncServerTimeExecutor instance = new SyncServerTimeExecutor();
    private final Object mLock = new Object();
    private final Executor syncExecutor = Executors.newSingleThreadExecutor();
    private long timeCorrectionMillis;

    private SyncServerTimeExecutor() {
    }

    public static SyncServerTimeExecutor getInstance() {
        return instance;
    }

    public void runBackgroundSyncAndPostResult() {
        this.syncExecutor.execute(new Runnable() {
            /* class com.xiaomi.accountsdk.utils.SyncServerTimeExecutor.AnonymousClass1 */

            public void run() {
                try {
                    ProtocolLogHelper.newRequestLog(SyncServerTimeExecutor.URL, HttpMethod.GET).log();
                    ProtocolLogHelper.newResponseLog(SyncServerTimeExecutor.URL).stringResponseOrNull(SimpleRequest.getAsString(SyncServerTimeExecutor.URL, null, null, true)).log();
                } catch (IOException e) {
                    AccountLog.e("SyncServerTimeExecutor", "syncServerTime", e);
                } catch (AccessDeniedException e2) {
                    AccountLog.e("SyncServerTimeExecutor", "syncServerTime", e2);
                } catch (AuthenticationFailureException e3) {
                    AccountLog.e("SyncServerTimeExecutor", "syncServerTime", e3);
                }
            }
        });
    }

    public long getCurrentServerTimeMillis() {
        if (this.timeCorrectionMillis == 0) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime() + this.timeCorrectionMillis;
    }

    public void syncServerTime(Date date) {
        if (date == null) {
            AccountLog.w("SyncServerTimeExecutor", "server date is null");
            return;
        }
        long time = date.getTime() - SystemClock.elapsedRealtime();
        synchronized (this.mLock) {
            if (time != this.timeCorrectionMillis) {
                this.timeCorrectionMillis = time;
            }
        }
    }
}
