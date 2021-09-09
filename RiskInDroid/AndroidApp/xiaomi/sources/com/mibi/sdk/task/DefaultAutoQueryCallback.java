package com.mibi.sdk.task;

import android.util.Log;
import com.mibi.sdk.task.AutoQuerier;

public abstract class DefaultAutoQueryCallback implements AutoQuerier.AutoQuerierCallback {
    public void onStart() {
        Log.i("DefaultAutoQuerier", "onStart");
    }

    public void onProgressUpdate(long j) {
        Log.i("DefaultAutoQuerier", "onProgressUpdate");
    }

    public void onComplete() {
        Log.i("DefaultAutoQuerier", "onComplete");
    }
}
