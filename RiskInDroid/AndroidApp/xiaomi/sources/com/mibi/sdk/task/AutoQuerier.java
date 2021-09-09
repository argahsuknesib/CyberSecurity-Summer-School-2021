package com.mibi.sdk.task;

import android.util.Log;
import com.mibi.sdk.task.RxCountDown;

public class AutoQuerier {
    public AutoQuerierCallback mAutoQuerierback;
    private RxCountDown.ICountDownListener mICountDownListener = new RxCountDown.ICountDownListener() {
        /* class com.mibi.sdk.task.AutoQuerier.AnonymousClass1 */

        public void onProgress(long j) {
        }

        public void onStart() {
        }

        public void onError() {
            Log.d("AutoQuerier", "count down error");
            throw new IllegalStateException();
        }

        public void onCompleted() {
            AutoQuerier.this.mAutoQuerierback.onProgressUpdate((long) AutoQuerier.this.mQueryIndex);
            AutoQuerier.this.mQueryIndex++;
            AutoQuerier.this.mAutoQuerierback.onComplete();
        }
    };
    public int mQueryIndex = 0;
    private int[] mQueryInterval;

    public interface AutoQuerierCallback {
        void onComplete();

        void onProgressUpdate(long j);

        void onStart();
    }

    public AutoQuerier(int[] iArr, AutoQuerierCallback autoQuerierCallback) {
        this.mQueryInterval = iArr;
        this.mAutoQuerierback = autoQuerierCallback;
    }

    public boolean hasNext() {
        return this.mQueryIndex < this.mQueryInterval.length;
    }

    public boolean query() {
        if (!hasNext()) {
            this.mAutoQuerierback.onComplete();
            return false;
        }
        if (this.mQueryIndex == 0) {
            this.mAutoQuerierback.onStart();
        }
        RxCountDown.getTask().start(this.mQueryInterval[this.mQueryIndex], this.mICountDownListener);
        return true;
    }
}
