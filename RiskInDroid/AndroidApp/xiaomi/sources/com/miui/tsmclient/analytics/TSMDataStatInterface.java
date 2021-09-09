package com.miui.tsmclient.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.miui.tsmclient.util.EnvironmentConfig;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TSMDataStatInterface {
    private static volatile TSMDataStatInterface sInstance;
    private ThreadPoolExecutor executor;
    private boolean isRecord = true;
    public Context mContext;
    public TSMDataStatManager mDataStatManger = new TSMDataStatManager();

    private TSMDataStatInterface() {
    }

    public static TSMDataStatInterface getInstance() {
        if (sInstance == null) {
            synchronized (TSMDataStatInterface.class) {
                if (sInstance == null) {
                    TSMDataStatInterface tSMDataStatInterface = new TSMDataStatInterface();
                    sInstance = tSMDataStatInterface;
                    tSMDataStatInterface.init(EnvironmentConfig.getContext());
                }
            }
        }
        return sInstance;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.DiscardPolicy());
            return;
        }
        throw new IllegalArgumentException("context can not be null");
    }

    public void recordCountEvent(final int i) {
        if (this.mContext == null) {
            throw new IllegalArgumentException("context can not be null");
        } else if (this.isRecord) {
            this.executor.execute(new Runnable() {
                /* class com.miui.tsmclient.analytics.TSMDataStatInterface.AnonymousClass1 */

                public void run() {
                    TSMDataStatInterface.this.mDataStatManger.recordCountEvent(TSMDataStatInterface.this.mContext, i);
                }
            });
        }
    }

    public void recordStringEvent(final int i, final String str) {
        if (this.mContext == null) {
            throw new IllegalArgumentException("context can not be null");
        } else if (this.isRecord) {
            this.executor.execute(new Runnable() {
                /* class com.miui.tsmclient.analytics.TSMDataStatInterface.AnonymousClass2 */

                public void run() {
                    TSMDataStatInterface.this.mDataStatManger.recordStringEvent(TSMDataStatInterface.this.mContext, i, str);
                }
            });
        }
    }

    public void recordListEvent(int i, List<String> list) {
        if (list == null || list.isEmpty()) {
            recordCountEvent(i);
        } else if (this.isRecord) {
            String generateEventString = generateEventString(list);
            if (TextUtils.isEmpty(generateEventString)) {
                recordCountEvent(i);
            } else {
                recordStringEvent(i, generateEventString);
            }
        }
    }

    private String generateEventString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            if (!TextUtils.isEmpty(next)) {
                sb.append(next.replace(",", "_"));
                sb.append(",");
            } else {
                sb.append(next);
                sb.append(",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public boolean isRecord() {
        return this.isRecord;
    }

    public void setRecord(boolean z) {
        this.isRecord = z;
    }
}
