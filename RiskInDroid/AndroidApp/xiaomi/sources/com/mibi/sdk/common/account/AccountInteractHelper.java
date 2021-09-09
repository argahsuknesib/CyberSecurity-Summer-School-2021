package com.mibi.sdk.common.account;

import java.util.concurrent.CopyOnWriteArraySet;

public final class AccountInteractHelper {
    public static boolean mInteractionResult = false;
    public static final Object sInteractionWaitingLock = new Object();
    public static final CopyOnWriteArraySet<String> sUserInteractionSet = new CopyOnWriteArraySet<>();

    private AccountInteractHelper() {
    }

    public static void notifyInteractionResult(boolean z) {
        synchronized (sInteractionWaitingLock) {
            mInteractionResult = z;
            sInteractionWaitingLock.notifyAll();
        }
    }

    public static void registerUserInteraction(String str) {
        sUserInteractionSet.add(str);
    }

    public static void unregisterUserInteraction(String str) {
        sUserInteractionSet.remove(str);
        if (sUserInteractionSet.isEmpty()) {
            mInteractionResult = false;
        }
    }
}
