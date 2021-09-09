package com.facebook.internal;

import android.content.Intent;
import java.util.UUID;

public class AppCall {
    private static AppCall currentPendingCall;
    private UUID callId;
    private int requestCode;
    private Intent requestIntent;

    public static AppCall getCurrentPendingCall() {
        return currentPendingCall;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        return null;
     */
    public static synchronized AppCall finishPendingCall(UUID uuid, int i) {
        synchronized (AppCall.class) {
            AppCall currentPendingCall2 = getCurrentPendingCall();
            if (currentPendingCall2 != null && currentPendingCall2.getCallId().equals(uuid)) {
                if (currentPendingCall2.getRequestCode() == i) {
                    setCurrentPendingCall(null);
                    return currentPendingCall2;
                }
            }
        }
    }

    private static synchronized boolean setCurrentPendingCall(AppCall appCall) {
        boolean z;
        synchronized (AppCall.class) {
            AppCall currentPendingCall2 = getCurrentPendingCall();
            currentPendingCall = appCall;
            if (currentPendingCall2 != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public AppCall(int i) {
        this(i, UUID.randomUUID());
    }

    public AppCall(int i, UUID uuid) {
        this.callId = uuid;
        this.requestCode = i;
    }

    public Intent getRequestIntent() {
        return this.requestIntent;
    }

    public UUID getCallId() {
        return this.callId;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public void setRequestCode(int i) {
        this.requestCode = i;
    }

    public void setRequestIntent(Intent intent) {
        this.requestIntent = intent;
    }

    public boolean setPending() {
        return setCurrentPendingCall(this);
    }
}
