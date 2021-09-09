package com.xiaomi.smarthome.camera.activity.utils;

import android.view.View;

public abstract class SingleClickListener implements View.OnClickListener {
    private long mLastClickTime;
    private long timeInterval = 1000;

    /* access modifiers changed from: protected */
    public void onFastClick() {
    }

    /* access modifiers changed from: protected */
    public abstract void onSingleClick();

    public SingleClickListener() {
    }

    public SingleClickListener(long j) {
        this.timeInterval = j;
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastClickTime > this.timeInterval) {
            onSingleClick();
            this.mLastClickTime = currentTimeMillis;
            return;
        }
        onFastClick();
    }
}
