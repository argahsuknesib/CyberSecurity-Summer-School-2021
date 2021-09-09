package com.facebook.react.uimanager;

public class ReactRootViewTagGenerator {
    private static int sNextRootViewTag = 1;

    public static synchronized int getNextRootViewTag() {
        int i;
        synchronized (ReactRootViewTagGenerator.class) {
            i = sNextRootViewTag;
            sNextRootViewTag += 10;
        }
        return i;
    }
}
