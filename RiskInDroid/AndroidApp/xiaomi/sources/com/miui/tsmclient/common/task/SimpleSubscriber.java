package com.miui.tsmclient.common.task;

import android.text.TextUtils;
import com.miui.tsmclient.util.LogUtils;
import rx.Subscriber;

public class SimpleSubscriber<T> extends Subscriber<T> {
    private String mCompleteLog;
    private String mErrorLog;

    public void onNext(T t) {
    }

    public SimpleSubscriber() {
        this("error occurred");
    }

    public SimpleSubscriber(String str) {
        this(null, str);
    }

    public SimpleSubscriber(String str, String str2) {
        this.mCompleteLog = str;
        this.mErrorLog = str2;
    }

    public void onCompleted() {
        if (!TextUtils.isEmpty(this.mCompleteLog)) {
            LogUtils.d(this.mCompleteLog);
        }
    }

    public void onError(Throwable th) {
        if (!TextUtils.isEmpty(this.mErrorLog)) {
            LogUtils.e(this.mErrorLog, th);
        }
    }
}
